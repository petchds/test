package com.tti.accscms.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Generator {
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/accscmstest?cacheServerConfiguration=true";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String MAPPER_PACKAGE = "com.tti.accscms.mapper";
	private static final String INTERFACE_PACKAGE = "com.tti.accscms.dao";

	private List<File> files;
	private FileFilter fileFilter;
	private Map<String, String> tableMap;
	private Map<String, String> classMap;

	private File workingDir;

	private Generator(File workingDir) throws SAXException, IOException, ParserConfigurationException {
		this.workingDir = workingDir;
		this.files = new ArrayList<File>();
		this.fileFilter = new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory() ? true : pathname.getName().endsWith(".java");
			}
		};

		System.out.print("Loading Document Builder... ");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		builder.setEntityResolver(new EntityResolver() {
			
			@Override
			public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
				if (systemId.contains("mybatis-generator-config_1_0.dtd")) {
					return new InputSource(Generator.class.getResourceAsStream("mybatis-generator-config_1_0.dtd"));
				} else {
					return null;
				}
			}
		});
		System.out.println("OK");

		String[] configs = new String[] {
				"generatorConfig_client.xml",
				"generatorConfig_manifest.xml",
				"generatorConfig_movement.xml"};

		this.tableMap = new HashMap<String, String>();
		this.classMap = new HashMap<String, String>();

		for (String config : configs) {
			System.out.print("Loading Generator Configuration (" + config + ")... ");
			File configFile = new File(config);

			Document doc;
			try {
				doc = builder.parse(new InputSource(new FileReader(configFile)));
				doc = builder.parse(configFile);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				doc = null;
			}
			String pkg = ((Element) doc.getElementsByTagName("javaModelGenerator").item(0)).getAttribute("targetPackage");

			NodeList nl = doc.getElementsByTagName("table");
			for (int i = 0; i < nl.getLength(); i++) {
				Element elem = (Element) nl.item(i);
				this.tableMap.put(pkg + "." + elem.getAttribute("domainObjectName"), elem.getAttribute("tableName"));
				this.classMap.put(elem.getAttribute("tableName"), pkg + "." + elem.getAttribute("domainObjectName"));
			}
			System.out.println("OK");
		}

	}
	
	private File createFileFromAbsoluteClassName(String clazzName) {
		String folder = this.workingDir.getAbsolutePath();
		String[] data = clazzName.split("[.]");
		for (int i = 0; i < data.length - 1; i++) {
			folder += System.getProperty("file.separator");
			folder += data[i];
		}
		File dir = new File(folder);
		dir.mkdirs();

		String file = this.workingDir.getAbsolutePath();
		for (String element : data) {
			file += System.getProperty("file.separator");
			file += element;
		}
		file += ".java";
		return new File(file);
	}

	private int loadFilesFromPath(File pathname) {
		int result = 0;

		for (File f : pathname.listFiles(this.fileFilter)) {

			if (f.isDirectory()) {
				result += this.loadFilesFromPath(f);
			} else {
				this.files.add(f);
				result++;
			}
		}

		return result;
	}

	private List<File> listLoadedFiles() {
		return this.files;
	}

	private String retrieveAbsoluteClassName(File pathname) {
		return pathname.getAbsolutePath()
				.replace(this.workingDir.getAbsolutePath(), "")
				.substring(1)
				.replace(System.getProperty("file.separator"), ".")
				.replace(".java", "");
	}

	private String retrieveClassName(File pathname) {
		String absoluteClassName = this.retrieveAbsoluteClassName(pathname);
		return absoluteClassName.substring(absoluteClassName.lastIndexOf('.') + 1, absoluteClassName.length());
	}

	private String retrieveMappedTableFromClass(String className) {
		return this.tableMap.get(className);
	}

	private String retrieveMapperClassFromTable(String tableName) {
		return this.classMap.get(tableName);
	}
	
	private String convertColumnToField(String column) {
		column = column.substring(1, column.length() - 1);
		
		String res = "";
		for (int i = 0; i < column.length(); i++) {
			char ch = column.charAt(i);
			if (ch == '_' || ch == '-') {
				res += Character.toUpperCase(column.charAt(++i));
			} else {
				res += ch;
			}
		}
		return res;
	}
	
	private String retrieveSqlTypeFromDBType(String dbType) {
		if (dbType.equals("int")) {
			return "java.sql.Types.INTEGER";
		} else if (dbType.equals("datetime")) {
			return "java.sql.Types.TIMESTAMP";
		} else if (dbType.equals("text")) {
			return "java.sql.Types.LONGVARCHAR";
		} else {
			return "java.sql.Types." + dbType.toUpperCase();
		}
	}
	
	private String readTmpl(String tmpl) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(tmpl)));
		StringBuilder builder = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
			builder.append(System.getProperty("line.separator"));
		}
		reader.close();

		return builder.toString();
	}
	
	private String generateWithMap(String tmpl, Map<String, String> map) throws IOException {
		String tmp = this.readTmpl(tmpl);

		for (String r : map.keySet()) {
			tmp = tmp.replaceAll("#" + r, map.get(r) != null ? map.get(r) : "");
		}
		return tmp;
	}
	
	private void generateFileWithMap(String tmpl, File file, Map<String, String> map) throws IOException {
		String tmp = this.generateWithMap(tmpl, map);

		File dir = new File(file.getPath().substring(0, file.getPath().lastIndexOf(System.getProperty("file.separator"))));
		dir.mkdirs();
		
		file.createNewFile();

		FileWriter writer = new FileWriter(file, false);
		writer.write(tmp);
		writer.close();
	}
	//
	// interface here
	//
	public void generateInterface(
			String interfacePackage, 
			String importClasses,
			String countType,
			String keyType,
			String keyName,
			String packageName, 
			String domainClass, 
			String findAllInterface,
			String tableName) throws IOException {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("INTERFACE_PACKAGE", interfacePackage);
		data.put("IMPORT", importClasses);
		data.put("COUNT_TYPE", countType);
		data.put("KEY_TYPE", keyType);
		data.put("KEY_NAME", keyName);
		data.put("U_KEY_NAME", Character.toUpperCase(keyName.charAt(0)) + keyName.substring(1));
		data.put("DOMAIN_CLASS", domainClass);
		data.put("L_DOMAIN_CLASS", Character.toLowerCase(domainClass.charAt(0)) + domainClass.substring(1));
		data.put("FIND_ALL_INTERFACE", findAllInterface);
		data.put("TABLE_NAME", tableName);
		data.put("INSERT_TYPE", keyType.equals("String") ? keyType : countType);
		
		String className = interfacePackage + "." + domainClass + "Dao";
		
		this.generateFileWithMap("interface.tmpl", this.createFileFromAbsoluteClassName(className), data);
	}

	private String generateFindAll(
			String domainClass, 
			String foreignDomainClass, 
			String tableName, 
			String fieldName, 
			String fieldType,
			boolean isInterface,
			String domainAttrs) throws IOException {
		
		String tmp = this.readTmpl(isInterface ? "interface_findall.tmpl" : "mapper_findall.tmpl");
		
		tmp = tmp.replaceAll("#DOMAIN_CLASS", domainClass);

		foreignDomainClass = foreignDomainClass.substring(foreignDomainClass.lastIndexOf('.') + 1, foreignDomainClass.length());
		
		if (fieldType.equals("Integer")) {
			fieldType = "Int";
		}

		tmp = tmp.replaceAll("#TABLE_NAME", tableName);
		tmp = tmp.replaceAll("#KEY_NAME", fieldName);
		tmp = tmp.replaceAll("#KEY_FTYPE", foreignDomainClass);
		tmp = tmp.replaceAll("#KEY_FT", fieldType);
		tmp = tmp.replaceAll("#KEY_FNAME", Character.toLowerCase(foreignDomainClass.charAt(0)) + foreignDomainClass.substring(1));
		tmp = tmp.replaceAll("#DOMAIN_ATTRS", domainAttrs);

		return tmp;
	}
	//
	// mapper here
	//
	private void generateMapper(String absInterfaceName, 
			String packageName, 
			String importClasses,
			String rs,
			String pss,
			String crud,
			String findAll,
			String example,
			String domainClass,
			String tableName) throws IOException, ClassNotFoundException, SecurityException, NoSuchFieldException {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("MAPPER_PACKAGE", packageName);
		map.put("ABS_INTERFACE_CLASS", absInterfaceName);
		map.put("INTERFACE_CLASS", absInterfaceName.substring(absInterfaceName.lastIndexOf('.') + 1));
		map.put("IMPORT", importClasses);
		map.put("RS", rs);
		map.put("PSS", pss);
		map.put("CRUD", crud);
		map.put("FIND_ALL", findAll);
		map.put("EXAMPLE", example);
		map.put("DOMAIN_CLASS", domainClass);
		map.put("TABLE_NAME", tableName);
		
		String className = packageName + "." + absInterfaceName.substring(absInterfaceName.lastIndexOf('.') + 1) + "Impl";
		
		this.generateFileWithMap("mapper.tmpl", this.createFileFromAbsoluteClassName(className), map);
	}
	
	
	public String generateBeanDao(String id, String clazz) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("BEAN_ID", id);
		map.put("BEAN_CLASS", clazz);
		
		return this.generateWithMap("beans_dao.tmpl", map);
	}
	
	public void generateBean(String dao) throws IOException {
		File bean = new File("src"
				+ System.getProperty("file.separator")
				+ "main"
				+ System.getProperty("file.separator")
				+ "resources"
				+ System.getProperty("file.separator")
				+ "com"
				+ System.getProperty("file.separator")
				+ "tti"
				+ System.getProperty("file.separator")
				+ "accscms"
				+ System.getProperty("file.separator")
				+ "dao"
				+ System.getProperty("file.separator")
				+ "dao.xml");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("DAO", dao);
		
		this.generateFileWithMap("beans.tmpl", bean, map);
	}
	
	public String generateCrud(
			String countType, 
			String domainClass, 
			String domainAttrs, 
			String tableName,
			String keyType,
			String keyName,
			boolean autoInc) throws IOException {
		
		Map<String, String> map = new HashMap<String, String>();
		String upperCountType = Character.toUpperCase(countType.charAt(0)) + countType.substring(1);
		map.put("U_COUNT_TYPE", upperCountType);
		map.put("COUNT_TYPE", countType);
		String lowerDomainClass = Character.toLowerCase(domainClass.charAt(0)) + domainClass.substring(1);
		map.put("L_DOMAIN_CLASS", lowerDomainClass);
		map.put("DOMAIN_CLASS", domainClass);
		map.put("DOMAIN_ATTRS", domainAttrs);
		map.put("DOMAIN_VALUES", domainAttrs.replaceAll("[a-zA-Z0-9_`]+", "?"));
		map.put("DOMAIN_UPDATE", domainAttrs.replace(",", "=?,") + "=?");
		map.put("TABLE_NAME", tableName);
		map.put("DOMAIN_COUNT", new Integer(domainAttrs.split(",").length + 1).toString());
		String upperKeyName = Character.toUpperCase(keyName.charAt(0)) + keyName.substring(1);
		map.put("U_KEY_NAME", upperKeyName);
		map.put("KEY_NAME", keyName);
		map.put("U_KEY_TYPE", keyType.equals("Integer") ? "Int" : keyType);
		map.put("KEY_TYPE", keyType);
		map.put("INSERT_TYPE", keyType.equals("String") ? keyType : countType);
		map.put("DEFAULT_INSERT_RET", keyType.equals("String") ? "null" : "-1");
		
		StringBuilder extra = new StringBuilder();
		if (autoInc) {
			extra.append("\t\t\t" + countType + " id = -1;");
			extra.append(System.getProperty("line.separator"));
			extra.append("\t\t\tResultSet rs = ps.getGeneratedKeys();");
			extra.append(System.getProperty("line.separator"));
			extra.append("\t\t\tif (rs.next()) {");
			extra.append(System.getProperty("line.separator"));
			extra.append("\t\t\t\tid = rs.get" + upperCountType + "(1);");
			extra.append(System.getProperty("line.separator"));
			extra.append("\t\t\t}");
			extra.append(System.getProperty("line.separator"));
			extra.append("\t\t\trs.close();");
			extra.append(System.getProperty("line.separator"));
			extra.append("\t\t\tps.close();");
			extra.append(System.getProperty("line.separator"));
			extra.append(System.getProperty("line.separator"));
			extra.append("\t\t\tlogger.info(\"DB:INSERT " + tableName + "[" + keyName + "=\" + id + \"]\");");
			extra.append(System.getProperty("line.separator"));
			extra.append(System.getProperty("line.separator"));
			extra.append("\t\t\treturn id;");
		} else {
			extra.append("\t\t\tps.close();");
			extra.append(System.getProperty("line.separator"));
			extra.append(System.getProperty("line.separator"));
			extra.append("\t\t\tlogger.info(\"DB:INSERT " + tableName + "[" + keyName + "=\" + " + lowerDomainClass + ".get" + upperKeyName + "()" + " + \"]\");");
			extra.append(System.getProperty("line.separator"));
			extra.append(System.getProperty("line.separator"));
			extra.append("\t\t\treturn " + lowerDomainClass + ".get" + upperKeyName + "();");
		}
		StringBuilder psnull = new StringBuilder();
		if (autoInc) {
			psnull.append(System.getProperty("line.separator"));
			psnull.append("\t\t\tps.setNull(1, java.sql.Types." + (countType.equals("int") ? "INTEGER" : "BIGINT") + ");");
		}
		
		map.put("PS_AUTO_INC", psnull.toString());
		map.put("EXTRA_AUTO_INC", extra.toString());
		map.put("AUTO_INC", autoInc ? ", Statement.RETURN_GENERATED_KEYS" : "");
		
		return this.generateWithMap("mapper_crud.tmpl", map);
	}
	
	public String generateExample(String countType, String domainClass, String tableName, String domainAttrs) throws IOException {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("U_COUNT_TYPE", Character.toUpperCase(countType.charAt(0)) + countType.substring(1));
		map.put("COUNT_TYPE", countType);
		map.put("L_DOMAIN_CLASS", Character.toLowerCase(domainClass.charAt(0)) + domainClass.substring(1));
		map.put("DOMAIN_CLASS", domainClass);
		map.put("TABLE_NAME", tableName);
		map.put("DOMAIN_ATTRS", domainAttrs);
		
		return this.generateWithMap("mapper_example.tmpl", map);
	}
	
	public String generatePSS(String domainClass, String domainAttrs, String tableName, Map<String, String> attrsType) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IOException {
		StringBuilder psAttrs = new StringBuilder();
		String[] attrs = domainAttrs.split(",");
		
		String loweredDomainClass = Character.toLowerCase(domainClass.charAt(0)) + domainClass.substring(1);
		
		for (int i = 0; i < attrs.length; i++) {
			Class<?> clazz = Class.forName(this.retrieveMapperClassFromTable(tableName));
			String col = attrs[i];
			
			System.out.print(col + " ");
			
			String f = this.convertColumnToField(col);
			String type = clazz.getDeclaredField(f).getType().getSimpleName();
			if (type.equals("Integer")) {
				type = "Int";
			} else if (type.equals("byte[]")) {
				type = "Bytes";
			} else if (type.equals("Date")) {
				type = "Timestamp";
			}
			
			String var = loweredDomainClass + ".get" + Character.toUpperCase(f.charAt(0)) + f.substring(1) + "()";
			
			psAttrs.append("\t\tif (" + var + " != null) {");
			psAttrs.append(System.getProperty("line.separator"));
			if (type.equals("Timestamp")) {
				var = "new java.sql.Timestamp(" + var + ".getTime())";
			}
			psAttrs.append("\t\t\tps.set" + type + "(" + (i + 1) + ", " + var + ");");
			psAttrs.append(System.getProperty("line.separator"));
			psAttrs.append("\t\t} else {");
			psAttrs.append(System.getProperty("line.separator"));
			if ((f.equals("modifiedDate") || f.equals("modifiedDateTime")) && type.equals("Timestamp")) {
				psAttrs.append("\t\t\tps.set" + type + "(" + (i + 1) + ", new java.sql.Timestamp(System.currentTimeMillis()));");
			} else {
				String cleanCol = col.substring(1, col.length() - 1);
				psAttrs.append("\t\t\tps.setNull(" + (i + 1) + ", " + this.retrieveSqlTypeFromDBType(attrsType.get(cleanCol)) + ");");
			}
			psAttrs.append(System.getProperty("line.separator"));
			psAttrs.append("\t\t}");
			psAttrs.append(System.getProperty("line.separator"));
			psAttrs.append(System.getProperty("line.separator"));
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("L_DOMAIN_CLASS", Character.toLowerCase(domainClass.charAt(0)) + domainClass.substring(1));
		map.put("DOMAIN_CLASS", domainClass);
		map.put("PS_ATTRS", psAttrs.toString());
		
		return this.generateWithMap("mapper_pss.tmpl", map);
	}
	
	public String generateRS(String domainClass, String domainAttrs, String tableName) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IOException {
		String[] attrs = domainAttrs.split(",");
		
		StringBuilder createInstance = new StringBuilder();
		
		String loweredDomainClass = Character.toLowerCase(domainClass.charAt(0)) + domainClass.substring(1);
		
		for (int i = 0; i < attrs.length; i++) {
			Class<?> clazz = Class.forName(this.retrieveMapperClassFromTable(tableName));
			String col = attrs[i];
			String cleanCol = col.substring(1, col.length() - 1);
			String f = this.convertColumnToField(col);
			String type = clazz.getDeclaredField(f).getType().getSimpleName();
			String otype = type;
			if (type.equals("Integer")) {
				type = "Int";
			} else if (type.equals("byte[]")) {
				type = "Bytes";
			} else if (type.equals("Date")) {
				type = "Timestamp";
				otype = "java.sql.Timestamp";
			} else if (type.equals("BigDecimal")) {
				otype = "java.math.BigDecimal";
			}
			
			createInstance.append("\t\t" + otype + " col" + (i + 1) + " = ");
			createInstance.append("rs.get" + type + "(\"" + cleanCol + "\")");
			createInstance.append(";");
			createInstance.append(System.getProperty("line.separator"));
			
			createInstance.append("\t\t" + loweredDomainClass + ".set" + Character.toUpperCase(f.charAt(0)) + f.substring(1) + "(");
			createInstance.append("rs.wasNull() ? null : ");
			if (type.equals("Timestamp")) {
				createInstance.append("new java.util.Date(");
			}
			createInstance.append("col" + (i + 1));
			if (type.equals("Timestamp")) {
				createInstance.append(".getTime())");
			}
			createInstance.append(");");
			createInstance.append(System.getProperty("line.separator"));
			createInstance.append(System.getProperty("line.separator"));
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("DOMAIN_CLASS", domainClass);
		map.put("L_DOMAIN_CLASS", loweredDomainClass);
		map.put("CREATE_INSTANCE_FROM_RS", createInstance.toString());
		
		return this.generateWithMap("mapper_rs.tmpl", map);
	} 	

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		File workingDir = new File("src"
				+ System.getProperty("file.separator")
				+ "main"
				+ System.getProperty("file.separator")
				+ "java");

		File packageDir = new File("src"
				+ System.getProperty("file.separator")
				+ "main"
				+ System.getProperty("file.separator")
				+ "java"
				+ System.getProperty("file.separator")
				+ "com"
				+ System.getProperty("file.separator")
				+ "tti"
				+ System.getProperty("file.separator")
				+ "accscms"
				+ System.getProperty("file.separator")
				+ "domain");
		System.out.println("Working Directory: " + workingDir.getAbsolutePath());
		System.out.println("Package Directory: " + packageDir.getAbsolutePath());

		Generator generator = new Generator(workingDir);

		System.out.println("Loading Generated Domain Classes...");
		System.out.println("Found: " + generator.loadFilesFromPath(packageDir) + " files");
		for (File f : generator.files) {
			System.out.println("\t" + generator.retrieveAbsoluteClassName(f));
		}

		System.out.print("Checking MySQL Driver... ");
		Class.forName(Generator.DRIVER);
		System.out.println("OK");

		System.out.print("Connecting Database... ");
		Connection con = DriverManager.getConnection(Generator.CONNECTION_STRING, "cmsadmin", "cmsadmin");
		System.out.println("OK");
		
		System.out.println("Checking Tables Data...");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SHOW FULL TABLES");

		List<String> tables = new ArrayList<String>();
		List<String> checkTables = new ArrayList<String>();
		
		while (rs.next()) {
			String tbl = rs.getString(1);
			tables.add(tbl);
			System.out.println("\tTable: " + tbl + " -> " + generator.retrieveMapperClassFromTable(tbl));
			
			if (rs.getString(2).equalsIgnoreCase("BASE TABLE")) {
				checkTables.add(tbl);
			}
		}
		System.out.println("Found: " + tables.size() + " tables");
		
		int pairs = 0;
		Map<String, String> daoClasses = new HashMap<String, String>();

		for (File f : generator.listLoadedFiles()) {
			String absoluteClassName = generator.retrieveAbsoluteClassName(f);
			System.out.println("Generating For " + absoluteClassName);
			
			String base = absoluteClassName.replace("com.tti.accscms.domain.", "");
			int lastIndex = base.lastIndexOf('.');
			
			if (lastIndex != -1) {
				base = base.substring(0, base.lastIndexOf('.'));
			} else {
				base = "";
			}

			String interfacePackage = Generator.INTERFACE_PACKAGE + (base.isEmpty() ? "" : ".") + base;
			String mapperPackage = Generator.MAPPER_PACKAGE + (base.isEmpty() ? "" : ".") + base;
			String tableName = generator.retrieveMappedTableFromClass(absoluteClassName);
			String className = generator.retrieveClassName(f);
			String loweredClassName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
			
			checkTables.remove(tableName);

			System.out.println("\tChecking Database Metadata... ");
			String tbl = generator.retrieveMappedTableFromClass(absoluteClassName);
			if (tbl == null) {
				System.out.println("\tSKIPPED");
				continue;
			}
			pairs++;
			daoClasses.put(mapperPackage + "." + className + "DaoImpl", 
					base + (base.isEmpty() ? loweredClassName : className) + "Dao");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("DESCRIBE " + tbl);

			String importClasses = "import " + absoluteClassName + ";" + System.getProperty("line.separator");
			importClasses += "import " + absoluteClassName + "Example;" + System.getProperty("line.separator");
			
			String findAllInterface = "";
			String findAll = "";
			String domainAttrs = "";
			String countType = "int";
			String keyType = "String";
			String keyName = "id";
			boolean autoInc = false;
			
			Map<String, String> attrType = new HashMap<String, String>();
			
			while (rs.next()) {
				String field = rs.getString("Field");
				String type = rs.getString("Type");
				
				attrType.put(field, type.indexOf('(') != -1 ? type.substring(0, type.indexOf('(')) : type);
				
				if (!domainAttrs.isEmpty()) {
					domainAttrs += ",";
				}
				domainAttrs += "`" + field + "`";
			}

			rs = stmt.executeQuery("DESCRIBE " + tbl);
			while (rs.next()) {
				String field = rs.getString("Field");
				String type = rs.getString("Type");
				String key = rs.getString("Key");
				String extra = rs.getString("Extra");

				if (field.equals("id") || key.equals("PRI")) {
					System.out.println("\tPK: " + field + " : " + type);
					
					countType = type.startsWith("bigint") ? "long" : "int";
					
					keyName = field;

					if (type.startsWith("int")) {
						keyType = "Integer";
					} else if (type.startsWith("bigint")) {
						keyType = "Long";
					} else if (type.startsWith("datetime")) {
						keyType = "Timestamp";
					}
					
					if (extra.equals("auto_increment")) {
						autoInc = true;
					}
				} else if (key.equals("MUL")) {
					Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery("SHOW CREATE TABLE " + tbl);
					rs2.next();
					
					String ftbl = rs2.getString(2);
					String ss = "FOREIGN KEY (`" + field + "`) REFERENCES `";
					
					int fk = ftbl.indexOf(ss);
					
					if (fk == -1) continue;
					
					System.out.print("\tFK: " + field + " : ");
					
					ftbl = ftbl.substring(fk);
					ftbl = ftbl.substring(ss.length(), ftbl.indexOf('`', ss.length()));
					
					String foreignDomainClass = generator.retrieveMapperClassFromTable(ftbl);
					
					System.out.println(foreignDomainClass);
					
					String ftype = "String";
					if (type.startsWith("int")) {
						ftype = "Integer";
					} else if (type.startsWith("bigint")) {
						ftype = "Long";
					}
							
					importClasses += "import " + foreignDomainClass + ";" + System.getProperty("line.separator");
					findAllInterface += generator.generateFindAll(className, foreignDomainClass, tbl, field, ftype, true, domainAttrs);
					findAll += generator.generateFindAll(className, foreignDomainClass, tbl, field, ftype, false, domainAttrs);
				}
			}
			rs.close();
			
			String absInterfaceName = interfacePackage + "." + className + "Dao";
			
			System.out.print("\tGenerating Interface... ");
			generator.generateInterface(interfacePackage, importClasses, countType, keyType, keyName, interfacePackage, className, findAllInterface, tableName);
			System.out.println("OK");

			System.out.print("\tGenerating Mapper... ");
			//generator.generateMapper(absInterfaceName, absMapperName, data, autoInc, attrType);
			String rsString = generator.generateRS(className, domainAttrs, tableName);
			String pss = generator.generatePSS(className, domainAttrs, tableName, attrType);
			String crud = generator.generateCrud(countType, className, domainAttrs, tableName, keyType, keyName, autoInc);
			String example = generator.generateExample(countType, className, tableName, domainAttrs);
			
			generator.generateMapper(absInterfaceName, mapperPackage, importClasses, rsString, pss, crud, findAll, example, className, tableName);
			System.out.println("OK");
		}

		System.out.print("Closing Database... ");
		con.close();
		System.out.println("OK");
		
		System.out.print("Generating dao.xml For Testing... ");
		StringBuilder builder = new StringBuilder();
		for (String dao : daoClasses.keySet()) {
			builder.append(generator.generateBeanDao(daoClasses.get(dao), dao));
		}
		generator.generateBean(builder.toString());
		System.out.println("OK");
		
		System.out.println("Generating Finished: " + pairs + " pairs");
		
		System.out.println("Found " + checkTables.size() + " unmapped tables");
		if (checkTables.size() > 0) {
			for (String s : checkTables) {
				System.out.println("\t" + s);
			}
		}
	}

}
