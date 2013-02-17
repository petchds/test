import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class AccessDataBase extends Thread {// implements Runnable{
	int i;
	String numApl = "abcdedfghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWZYZ0123456789";
	String num = "0123456789";
	static DataSource datasource;

	public AccessDataBase(int i) {
		// TODO Auto-generated constructor stub
		// System.out.println("hello" + i);
		this.i = i;

	}

	void testRun() {

	}

	public static void main(String[] args) throws Exception {
		// AccessDataBase access = new AccessDataBase();
		// access.testRun();
		System.out.println("The machine 14 was update goods_transition as you like.");
		int round = 800;
		if(args.length != 0)
			round = Integer.parseInt(args[0]);
		
		PoolProperties p = new PoolProperties();
		p.setUrl("jdbc:mysql://172.16.17.14:3306/accscms");//localhost:3306/accscms");// 
		p.setDriverClassName("com.mysql.jdbc.Driver");
		p.setUsername("root");
		p.setPassword("p@ssw0rd");//");// 
		p.setJmxEnabled(true);
		p.setTestWhileIdle(false);
		p.setTestOnBorrow(true);
		p.setValidationQuery("SELECT 1");
		p.setTestOnReturn(false);
		p.setValidationInterval(30000);
		p.setTimeBetweenEvictionRunsMillis(30000);
		p.setMaxActive(100);
		p.setInitialSize(10);
		p.setMaxWait(10000);
		p.setRemoveAbandonedTimeout(60);
		p.setMinEvictableIdleTimeMillis(30000);
		p.setMinIdle(10);
		p.setLogAbandoned(true);
		p.setRemoveAbandoned(true);
		p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
				+ "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
		datasource = new DataSource();
		datasource.setPoolProperties(p);
		for (int i = 0; i < 17000; i++) {
			AccessDataBase accessT = new AccessDataBase(i);
			// accessT.testRun();
			accessT.run();//start();
		}

	}

	String[] declNo1 = { "A004", "A005" };
	String[] declNo2 = { "1550360", "1550370", "1550380", "1550390", "1550560",
			"1550570", "1550580", "1550590" };
	static int declIndex;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random rand = new Random();// (i);
		Connection con = null;
		String dec = "";
		int index = i;// declIndex;
		// declIndex++;
		int index1 = index / 1000;
		int index2 = index / 8000;
		dec += declNo1[index2] + declNo2[index1];
		String last = (index % 1000) + "";
		if (last.length() == 1)
			dec += "00" + last;
		else if (last.length() == 2)
			dec += "0" + last;
		else {
			dec += last;
		}
		// declaration_no VARCHAR(14) DEFAULT NULL,
		int taxLen = rand.nextInt(10)+7;
		String compTaxNo = "";
		for (int i = 0; i < taxLen; i++)
			compTaxNo += numApl.charAt(rand.nextInt(numApl.length()));
		// company_tax_no VARCHAR(17) DEFAULT NULL,
		taxLen = rand.nextInt(4) + 2;
		String compTaxBranch = "";
		for (int i = 0; i < taxLen; i++)
			compTaxBranch += num.charAt(rand.nextInt(num.length()));
		// company_branch INT(6) DEFAULT NULL,
		taxLen = 5;// rand.nextInt(6);
		String numOfPack = "";
		for (int i = 0; i < taxLen; i++)
			numOfPack += num.charAt(rand.nextInt(num.length()));
		// number_of_package INT(11) DEFAULT NULL,
		taxLen = 3;// rand.nextInt(6);
		String numOfPackUnit = "";
		String grossWUnit = "";
		for (int i = 0; i < taxLen; i++) {
			numOfPackUnit += numApl.charAt(rand.nextInt(numApl.length()));
			grossWUnit += numApl.charAt(rand.nextInt(numApl.length()));
		}
		// number_of_package_unit VARCHAR(3) DEFAULT NULL,

		// gross_weight DOUBLE DEFAULT NULL,
		String grossWeight = (rand.nextDouble() * 10000) + "";
		// gross_weight_unit VARCHAR(3) DEFAULT NULL,
		String lastEntry = numApl.charAt(rand.nextInt(numApl.length())) + "";
		// last_entry VARCHAR(1) DEFAULT NULL,
		// SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		// Date d = new Date(Calendar.getInstance().getTimeInMillis());
		// String modDateTime = fmt.format(d).toString();
		// modified_date_time DATETIME DEFAULT NULL,
		// mawb VARCHAR(35) DEFAULT NULL,
		// hawb VARCHAR(35) DEFAULT NULL,
		// goods_description VARCHAR(512) DEFAULT NULL,
		// status_0309 VARCHAR(20) DEFAULT NULL,
		// status_0309_date_time DATETIME DEFAULT NULL,
		// status_0309_by VARCHAR(30) DEFAULT NULL,
		// remark_0309 VARCHAR(512) DEFAULT NULL,
		// balanced INT(1) DEFAULT 0,
		// balanced_date_time DATETIME DEFAULT NULL,
		// balanced_type VARCHAR(20) DEFAULT NULL,
		// shipper_name VARCHAR(120) DEFAULT NULL,
		// remain_number_of_package INT(11) DEFAULT NULL,
		// remain_number_of_package_unit VARCHAR(3) DEFAULT NULL,
		// remain_gross_weight DOUBLE DEFAULT NULL,
		// remain_gross_weight_unit VARCHAR(3) DEFAULT NULL,
		// reference_number VARCHAR(13) DEFAULT NULL,
		// company_name VARCHAR(120) DEFAULT NULL,
		// street_and_number VARCHAR(70) DEFAULT NULL,
		// postcode VARCHAR(9) DEFAULT NULL,
		// car_license VARCHAR(10) DEFAULT NULL,
		// container_number VARCHAR(17) DEFAULT NULL,
		// container_type INT(1) DEFAULT NULL,
		// container_code VARCHAR(4) DEFAULT NULL,
		// flight_no VARCHAR(17) DEFAULT NULL,
		// flight_date DATE DEFAULT NULL,
		// release_port INT(4) DEFAULT NULL,
		// load_port INT(4) DEFAULT NULL,
		// packing_port INT(4) DEFAULT NULL,
		// discharge_port VARCHAR(5) DEFAULT NULL,
		// e_seal VARCHAR(35) DEFAULT NULL,
		// detail_line INT(4) DEFAULT NULL,
		// is_edit_manual INT(1) DEFAULT 0,
		// is_manual INT(1) DEFAULT 0,
		// group_declaration INT(1) DEFAULT NULL,
		// is_from_customs INT(1) DEFAULT 1,
		// receive_date_time DATETIME DEFAULT NULL,

		// String name =
		// ""+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()));
		// String passwd =
		// ""+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()));
		// String mail =
		// numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+"@"+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+".com";
		// String fName =
		// ""+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()));
		// String sName =
		// ""+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()))+numApl.charAt(rand.nextInt(numApl.length()));
		// String phone =
		// ""+num.charAt(rand.nextInt(num.length()))+num.charAt(rand.nextInt(num.length()))+num.charAt(rand.nextInt(num.length()))+num.charAt(rand.nextInt(num.length()))+num.charAt(rand.nextInt(num.length()))+num.charAt(rand.nextInt(num.length()))+num.charAt(rand.nextInt(num.length()));
		try {

			con = datasource.getConnection();
			Statement st = con.createStatement();
			// String stm =
			// "INSERT INTO `accscms`.`user` (`username`, `password`, `email`, `activate`,`firstname`,`lastname`,`phone_no`) VALUES ('"
			// +
			// "" +name+"', '" +passwd +"', '" +mail +
			// "', '1', '" +fName+"', '"+sName+"','"+phone+
			// "');";
			//
			String stm = "SELECT * FROM `goods_transition` WHERE `declaration_no` = '"
					+ dec + "';";
			System.out.println(stm);
			ResultSet rs = st.executeQuery(stm);
			if (!rs.next()) {
				// no data so insert
				stm = "INSERT INTO `accscms`.`goods_transition` ( `declaration_no`,`company_tax_no`,`company_branch`,`number_of_package`,`number_of_package_unit`,`gross_weight`,`gross_weight_unit`,`last_entry`  " // ,`modified_date_time`
						+ ") VALUES ('"
						+ dec
						+ "', '"
						+ compTaxNo
						+ "', '"
						+ compTaxBranch
						+ "', '"
						+ numOfPack
						+ "', '"
						+ numOfPackUnit
						+ "', '"
						+ grossWeight
						+ "', '"
						+ grossWUnit + "', '" + lastEntry + "');";
				// + modDateTime.replace('T', ':') + "');";
				System.out.println(stm);
				st.execute(stm);
			} else {
				// upate
				stm = "UPDATE `accscms`.`goods_transition` SET `company_tax_no`='"
						+ compTaxNo + "',`company_branch`='" + compTaxBranch
						+ "',`number_of_package`='" + numOfPack
						+ "',`number_of_package_unit`='" + numOfPackUnit
						+ "',`gross_weight`='" + grossWeight
						+ "',`gross_weight_unit`='" + grossWUnit
						+ "',`last_entry`='" + lastEntry + "' WHERE `id`='"
						+ rs.getString("id") + "';";// UPDATE
													// `accscms`.`user_company`
													// SET
													// `firstname`='aaa'
													// WHERE
													// `id`='7';
			}
			// boolean status = st.execute(stm);
			System.out.println(stm);
			st.execute(stm);
			// System.out.print("Hello" + i + "Update status "+status);
			// while (rs.next()) {
			// System.out.println((cnt++) + ". ID:" + rs.getString("id")
			// + " User:" + rs.getString("username") + " Password:"
			// + rs.getString("password"));
			// }
			// rs.close();
			st.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (Exception ignore) {
				}
		}

	}
}
