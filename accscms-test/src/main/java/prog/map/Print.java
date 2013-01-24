package prog.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Print {

	public void writeFile(String FromFileXml,String ToFilePrint,Connection conn,String... Table) throws IOException, ParserConfigurationException, SAXException, SQLException{
	
		  FileWriter fstream = new FileWriter(ToFilePrint);
		  BufferedWriter out = new BufferedWriter(fstream);

		  String data ="";
		  data = data.concat(printField(FromFileXml));
		  data = data.concat(System.getProperty("line.separator"));
		  data = data.concat(System.getProperty("line.separator"));
		  
		  data = data.concat(printFieldCreate(FromFileXml));
		  data = data.concat(System.getProperty("line.separator"));
		  data = data.concat(System.getProperty("line.separator"));
		  
		  data = data.concat(printColumn(conn,Table));
		  data = data.concat(System.getProperty("line.separator"));
		  data = data.concat(System.getProperty("line.separator"));
		  
		  data = data.concat(printSwitchCase(FromFileXml));
		  data = data.concat(System.getProperty("line.separator"));
		  data = data.concat(System.getProperty("line.separator"));
		//	 " `hawb` varchar(45) NOT NULL,"+
		  out.write(data);
		  out.close();
	
	}
	
	public String printField(String FromFileXml) throws ParserConfigurationException, SAXException, IOException{
		
		String data = "";
		ArrayList<String> arr = getField(FromFileXml);
		for (int i = 0; i < arr.size(); i++) {	
			
			data = data.concat("\t\tfield[").concat(String.valueOf(i)).concat("][0] = ").concat("\""+arr.get(i)+"\";").concat(System.getProperty("line.separator"));
			
		}
		return data;
		}
	
	
	public String printFieldCreate(String FromFileXml) throws ParserConfigurationException, SAXException, IOException{
		
		String data = "";
		ArrayList<String> arr = getField(FromFileXml);
		for (int i = 0; i < arr.size(); i++) {	

			data = data.concat("\"`").concat(arr.get(i).substring(arr.get(i).indexOf(':')+1, arr.get(i).length()).toLowerCase()).concat("`").concat(" varchar(45) NOT NULL ,\" +").concat(System.getProperty("line.separator"));
	}
		return data;
		}
	public String printSwitchCase(String FromFileXml) throws ParserConfigurationException, SAXException, IOException {
		String data = "";
		ArrayList<String> arr = getField(FromFileXml);
		
		for (int i = 0; i < arr.size(); i++) {
			String nodeName = 	arr.get(i).indexOf(":") !=-1 ? 
								arr.get(i).substring(arr.get(i).indexOf(":")+1, arr.get(i).length()) :
								arr.get(i);
			data = data.concat("\t\tcase ").concat("\""+nodeName+"\"").concat(" :\t").concat("value = value;").concat(System.getProperty("line.separator")).concat("\t\tbreak;").concat(System.getProperty("line.separator"));
		
		}
		return data;
	}
	
	public String printColumn(Connection conn,String... Table) throws SQLException {

		String data = "";
		for (int i = 0; i < Table.length; i++) {
			
			ArrayList<String> arr = getColumn(conn ,Table[i]);
			data = data.concat("\t\tString sqlCommand").concat(String.valueOf(i+1)).concat(" = ").concat("\"SELECT \"+");
			for (int j = 0; j < arr.size(); j++) {
				if(j==arr.size())
					data = data.concat(System.getProperty("line.separator")).concat("\t\t\t\" "+arr.get(j)+ " \" + ");
				else
					data = data.concat(System.getProperty("line.separator")).concat("\t\t\t\" "+arr.get(j)+ " ,\" + ");
			}
			data = data.concat(System.getProperty("line.separator")).concat("\t\t\t\"FROM "+Table[i]+" WHERE ...\"");
			data = data.concat(System.getProperty("line.separator"));
			data = data.concat(System.getProperty("line.separator"));			
		}	
	return data;
	}

	public ArrayList<String> getColumn(Connection conn ,String table) throws SQLException {

		ArrayList<String> arr = new ArrayList<String>();	
		Statement statement = conn.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM " + table);
	    ResultSetMetaData rsMetaData = rs.getMetaData();
	    int numberOfColumns = rsMetaData.getColumnCount();
	    
	    for (int i = 1; i <= numberOfColumns; i++) 
	    	arr.add(rsMetaData.getColumnName(i));
	     
		return arr;
	}
	
	public ArrayList<String> getField(String FromFileXml) throws ParserConfigurationException, SAXException, IOException{
		
		File fXmlFile = new File(FromFileXml);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		ArrayList<String> arr = new ArrayList<String>();
		Child(doc.getChildNodes(),arr);
		
		return arr;
	}
	
	public static Boolean Child(NodeList nList,List<String> arr){
		Boolean  value = false;
	
		for (int index = 0; index < nList.getLength(); index++) {
                        
				if (nList.item(index).getChildNodes() != null)
			   {
				   NodeList nodeList =  nList.item(index).getChildNodes(); 
				   if(Child(nodeList,arr)){
					   String nodeName = nList.item(index).getNodeName();
					   arr.add(nList.item(index).getNodeName());
				   }   
	           }
			   
				if (nList.item(index).getAttributes() != null)
			   {
				   NamedNodeMap attr = nList.item(index).getAttributes();
				   for (int i = 0; i < attr.getLength(); i++) {
					   if(attr.item(i).getNodeValue().indexOf('?')!=-1){
					//	   arr.add(attr.item(i).getNodeName());
					   }
				   }
			   }
				if(checkValue(nList.item(index).getNodeValue()))
			    	 return true;

		 }
		return value;
	}
	
	public static Boolean checkValue(String str){
		Boolean  value = false;
		try{
		if(str.indexOf('?')!=-1){
			value = true;
		}}catch (Exception e) {
			 value = false;
		}
		return value;
	}
	
    public String getFirstRange(File file , String str) throws Exception {
        //File file = new File("./src/generate/".concat("Prog").concat(".java"));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String read = null;
        StringBuffer buffer = new StringBuffer();
        while ((read = reader.readLine()) != null) {
            buffer.append(read);
            buffer.append(System.getProperty("line.separator"));
        }
        reader.close();
        String data = buffer.toString();
        int index = data.indexOf(str);
        index += str.length();
        String dataTemp1 = data.substring(0, index);
        dataTemp1.concat(System.getProperty("line.separator"));
        return dataTemp1;
    }
    
    public  String getlastRange(File file,String str) throws Exception {
        //File file = new File("./src/generate/".concat("Prog").concat(".java"));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String read = null;
        StringBuffer buffer = new StringBuffer();
        while ((read = reader.readLine()) != null) {
            buffer.append(read);
            buffer.append(System.getProperty("line.separator"));
        }
        reader.close();
        String data = buffer.toString();
        int index = data.indexOf("str");
        String dataTemp2 = data.substring(index, data.length());
        return dataTemp2;
    }

}


