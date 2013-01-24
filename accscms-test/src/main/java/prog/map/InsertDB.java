package prog.map;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



import com.mysql.jdbc.Connection;

public class InsertDB {
	
	
	
	
	public SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm:ss");
	private int row =10;
	
	
	
	public InsertDB(java.sql.Connection conn2,int row) throws SQLException {
		// TODO Auto-generated constructor stub
	this.row = row;
	create_keyword_row(conn2);
	create_vsedcontrolgate(conn2);
	create_vseddetailgate(conn2);
	create_amancontrolgate(conn2);
	create_amandetailgate(conn2);
	create_abilcontrolgate(conn2);
	create_abildetailgate(conn2);
	
	}
	
	
	private void create_vsedcontrolgate(java.sql.Connection conn2) throws SQLException {
		// TODO Auto-generated method stub
		Statement st = conn2.createStatement();
		
		String sqldrop = "DROP TABLE IF EXISTS `vsed_control_g`";
		
		String sqlcreate =  "CREATE TABLE `vsed_control_g` ( "+
						
				"  `id` int(11) NOT NULL AUTO_INCREMENT, "+	
				"`documenttype` varchar(45) NOT NULL ," +
				"`carrierid` varchar(45) NOT NULL ," +
				"`transportmeanscode` varchar(45) NOT NULL ," +
				"`transportmeansjourneyid` varchar(45) NOT NULL ," +
				"`transportmeansidentificationtext` varchar(45) NOT NULL ," +
				"`nationality` varchar(45) NOT NULL ," +
				"`transportmodecode` varchar(45) NOT NULL ," +
				"`previousflightno` varchar(45) NOT NULL ," +
				"`previousdate` varchar(45) NOT NULL ," +
		
		
		"  PRIMARY KEY (`id`) "+
		") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci  ";
		;
		
		st.executeUpdate(sqldrop);
		
		st.executeUpdate(sqlcreate);
				
		
		
		int count =1 ;
		for (int i = 1; i < row; i++) {
			int length = Integer.parseInt(NodeXml.Random_Func1("i"));

				
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
			
				
				String sql = "INSERT vsed_control_g VALUES("+null+","+
							"'"+NodeXml.Random_Func1("I")+"'"+","+
							"'"+(Integer.parseInt(NodeXml.Random_Func1("i")) >5 ? 0 : 1)+"'"+","+
							"'"+(Integer.parseInt(NodeXml.Random_Func1("i")) >5 ? 22 : 23)+"'"+","+
							"'"+ NodeXml.Random_Func1("N/A")+"'"+","+
							"'"+ NodeXml.Random_Func1("TGiii")+"'"+","+
							"'"+ NodeXml.Random_Func1("OT")+"'"+","+
							"'"+ NodeXml.Random_Func1("ii")+"'"+","+
							"'"+ NodeXml.Random_Func1("TGiii")+"'"+","+
							"'"+DateFormat.format(oldDate)+"'"+""+
							")";
				
				System.out.println(sql);
				int val = st.executeUpdate(sql);
			
			
			count++;
		}
	}

	private void create_vseddetailgate(java.sql.Connection conn2) throws SQLException {
		// TODO Auto-generated method stub
		Statement st = conn2.createStatement();
		
		

String sqldrop = "DROP TABLE IF EXISTS `vsed_detail_g`";


String sqlcreate =  "CREATE TABLE `vsed_detail_g` ( "+
"  `id` int(11) NOT NULL AUTO_INCREMENT, "+	
"  `id_2` int(11) NOT NULL , "+	
	

"`dischargelocationid` varchar(45) NOT NULL ," +
"`berthdate` varchar(45) NOT NULL ," +
"`lastcalllocationid` varchar(45) NOT NULL ," +

"  PRIMARY KEY (`id`) "+
") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci  ";
;

st.executeUpdate(sqldrop);

st.executeUpdate(sqlcreate);
		
		
		
		int count =1 ;
		for (int i = 1; i < row; i++) {
			int length = Integer.parseInt(NodeXml.Random_Func1("i"));

			length = length > 2 ? length : 2; 
			for (int j = 1; j <length ; j++) {
				
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
			
				
				String sql = "INSERT vsed_detail_g VALUES("+null+","+
							"'"+count+"'"+","+
							"'"+NodeXml.Random_Func1("THBKK")+"'"+","+
							"'"+DateFormat.format(oldDate)+"T"+TimeFormat.format(oldDate)+"Z"+"'"+","+
							"'"+"THBKK"+"'"+""+
						")";
				
				System.out.println(sql);
				int val = st.executeUpdate(sql);
			}
			
			count++;
		}
	}
	
	
	private void create_amancontrolgate(java.sql.Connection conn2) throws SQLException {
		// TODO Auto-generated method stub
		Statement st = conn2.createStatement();
		
//"`referenceno` varchar(45) NOT NULL ," +
//"`recvcontrolno` varchar(45) NOT NULL ," +
//"`processindicator` varchar(45) NOT NULL ," +
//"`messagefunction` varchar(45) NOT NULL ," +
//"`userid` varchar(45) NOT NULL ," +
//"`loadinglocationid` varchar(45) NOT NULL ," +
//"`dischargelocationid` varchar(45) NOT NULL ," +
//"`deliverylocationid` varchar(45) NOT NULL ," +

		

		String sqldrop = "DROP TABLE IF EXISTS `aman_control_g`";
		
		String sqlcreate =  "CREATE TABLE `aman_control_g` ( "+
		
				
		"`id` int(11) NOT NULL AUTO_INCREMENT, "+	
		"`processindicator` varchar(45) NOT NULL ," +
		"`loadinglocationid` varchar(45) NOT NULL ," +
		"`dischargelocationid` varchar(45) NOT NULL ," +
		"`deliverylocationid` varchar(45) NOT NULL ," +
		
		"  PRIMARY KEY (`id`) "+
		") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci  ";
		;
		
		st.executeUpdate(sqldrop);
		
		st.executeUpdate(sqlcreate);
				
				
				
		int count =1 ;
		for (int i = 1; i < row; i++) {
			int length = Integer.parseInt(NodeXml.Random_Func1("i"));

				
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
			
				
				String sql = "INSERT aman_control_g VALUES("+null+","+
						"'"+(Integer.parseInt(NodeXml.Random_Func1("i")) >2 ?
								Integer.parseInt(NodeXml.Random_Func1("i")) >5 ?
										Integer.parseInt(NodeXml.Random_Func1("i")) >8 ?
												22 : 23 : 24 : 28)+"'"+","+
				"'"+"THBKK"+"'"+","+
							"'"+ NodeXml.Random_Func1("SNSSS")+"'"+","+
							"'"+ NodeXml.Random_Func1("iiii")+"'"+""+		
							")";
				System.out.println(sql);
				int val = st.executeUpdate(sql);
			
			
			count++;
		}
	}

	private void create_amandetailgate(java.sql.Connection conn2) throws SQLException {
		// TODO Auto-generated method stub
		Statement st = conn2.createStatement();
		
				
		
		String sqldrop = "DROP TABLE IF EXISTS `aman_detail_g`";
		
		
		//"`numberofpackages` varchar(45) NOT NULL ," +
		//"`unitofpackages` varchar(45) NOT NULL ," +
		
		
		
		String sqlcreate =  "CREATE TABLE `aman_detail_g` ( "+
		"  `id` int(11) NOT NULL AUTO_INCREMENT, "+	
		"  `id_2` int(11) NOT NULL , "+	
			
		"`numberofpackages` varchar(45) NOT NULL ," +
		"`unitofpackages` varchar(45) NOT NULL ," +
		
		
		"  PRIMARY KEY (`id`) "+
		") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci  ";
		;
		
		st.executeUpdate(sqldrop);
		
		st.executeUpdate(sqlcreate);
				
				
		
		int count =1 ;
		for (int i = 1; i < row; i++) {
			int length = Integer.parseInt(NodeXml.Random_Func1("i"));

			length = length > 2 ? length : 2; 
			for (int j = 1; j <length ; j++) {
				
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
			
				String sql = "INSERT aman_detail_g VALUES("+null+","+
						"'"+count+"'"+","+
							"'"+NodeXml.Random_Func1("II")+"'"+","+
							"'"+NodeXml.Random_Func1("SII")+"'"+""+
							
						")";
				
				System.out.println(sql);
				int val = st.executeUpdate(sql);
			}
			
			count++;
		}
	}
	
	
	

	private void create_abilcontrolgate(java.sql.Connection conn2) throws SQLException {
		// TODO Auto-generated method stub
		Statement st = conn2.createStatement();

//"`referenceno` varchar(45) NOT NULL ," +
//"`recvcontrolno` varchar(45) NOT NULL ," +
//"`processindicator` varchar(45) NOT NULL ," +
//"`messagefunction` varchar(45) NOT NULL ," +
//"`origincountrycode` varchar(45) NOT NULL ," +
//"`userid` varchar(45) NOT NULL ," +
//"`forwarderassignedid` varchar(45) NOT NULL ," +
//"`taxreference` varchar(45) NOT NULL ," +
//"`masterblno` varchar(45) NOT NULL ," +
//"`loadinglocationid` varchar(45) NOT NULL ," +
//"`dischargelocationid` varchar(45) NOT NULL ," +
//"`deliverylocationid` varchar(45) NOT NULL ," +
//"`shedno` varchar(45) NOT NULL ," +


		String sqldrop = "DROP TABLE IF EXISTS `abil_control_g`";
		
		String sqlcreate =  "CREATE TABLE `abil_control_g` ( "+
		"`id` int(11) NOT NULL AUTO_INCREMENT, "+	
		"`processindicator` varchar(45) NOT NULL ," +
		"`origincountrycode` varchar(45) NOT NULL ," +
		"`forwarderassignedid` varchar(45) NOT NULL ," +
		"`taxreference` varchar(45) NOT NULL ," +
		"`loadinglocationid` varchar(45) NOT NULL ," +
		"`dischargelocationid` varchar(45) NOT NULL ," +
		"`deliverylocationid` varchar(45) NOT NULL ," +

		"  PRIMARY KEY (`id`) "+
		") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci  ";
		;
		
		st.executeUpdate(sqldrop);
		
		st.executeUpdate(sqlcreate);
				
				
				
		int count =1 ;
		for (int i = 1; i < row; i++) {
			int length = Integer.parseInt(NodeXml.Random_Func1("i"));

				
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
			
				
				String sql = "INSERT abil_control_g VALUES("+null+","+
							"'"+(Integer.parseInt(NodeXml.Random_Func1("i")) >2 ?
									Integer.parseInt(NodeXml.Random_Func1("i")) >5 ?
											Integer.parseInt(NodeXml.Random_Func1("i")) >8 ?22: 23:24: 28)+"'"+","+
							"'"+ NodeXml.Random_Func1("SS")+"'"+","+
							"'"+ NodeXml.Random_Func1("ii")+"'"+","+
							"'"+ NodeXml.Random_Func1("iiiii")+"'"+","+
							"'"+"THBKK"+"'"+","+
							"'"+ NodeXml.Random_Func1("SNSSS")+"'"+","+
							"'"+ NodeXml.Random_Func1("iiii")+"'"+""+		
							")";
				System.out.println(sql);
				int val = st.executeUpdate(sql);
			
			
			count++;
		}
	}

	private void create_abildetailgate(java.sql.Connection conn2) throws SQLException {
		// TODO Auto-generated method stub
		Statement st = conn2.createStatement();

	
		
		String sqldrop = "DROP TABLE IF EXISTS `abil_detail_g`";
		
		String sqlcreate =  "CREATE TABLE `abil_detail_g` ( "+
		
				
"  `id` int(11) NOT NULL AUTO_INCREMENT, "+	
"  `id_2` int(11) NOT NULL , "+	
"`itemdescription` varchar(45) NOT NULL ," +
"`dangerousgoods` varchar(45) NOT NULL ," +
"`shippingmark` varchar(45) NOT NULL ," +



"`numberofpackages` varchar(45) NOT NULL ," +
"`unitofpackages` varchar(45) NOT NULL ," +
"`fobvalue` varchar(45) NOT NULL ," +
"`fobcurrencycode` varchar(45) NOT NULL ," +
"`freightvalue` varchar(45) NOT NULL ," +



"`freightcurrencycode` varchar(45) NOT NULL ," +
"`insurancevalue` varchar(45) NOT NULL ," +
"`insurancecurrencycode` varchar(45) NOT NULL ," +
"`cosignorparty_name` varchar(45) NOT NULL ," +
"`cosignorparty_street` varchar(45) NOT NULL ," +


"`cosignorparty_district` varchar(45) NOT NULL ," +
"`cosignorparty_subprovince` varchar(45) NOT NULL ," +
"`cosignorparty_province` varchar(45) NOT NULL ," +
"`cosignorparty_postcode` varchar(45) NOT NULL ," +
"`cosignorparty_countrycode` varchar(45) NOT NULL ," +


"`cosignorparty_phoneno` varchar(45) NOT NULL ," +
"`cosigneeparty_name` varchar(45) NOT NULL ," +
"`cosigneeparty_street` varchar(45) NOT NULL ," +
"`cosigneeparty_district` varchar(45) NOT NULL ," +
"`cosigneeparty_subprovince` varchar(45) NOT NULL ," +


"`cosigneeparty_province` varchar(45) NOT NULL ," +
"`cosigneeparty_postcode` varchar(45) NOT NULL ," +
"`cosigneeparty_countrycode` varchar(45) NOT NULL ," +
"`cosigneeparty_phoneno` varchar(45) NOT NULL ," +
"`notifyparty_name` varchar(45) NOT NULL ," +


"`notifyparty_street` varchar(45) NOT NULL ," +
"`notifyparty_district` varchar(45) NOT NULL ," +
"`notifyparty_subprovince` varchar(45) NOT NULL ," +
"`notifyparty_province` varchar(45) NOT NULL ," +
"`notifyparty_postcode` varchar(45) NOT NULL ," +



"`notifyparty_countrycode` varchar(45) NOT NULL ," +
"`notifyparty_phoneno` varchar(45) NOT NULL ," +
//"`lastentry` varchar(45) NOT NULL ," +

		"  PRIMARY KEY (`id`) "+
		") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci  ";
		;
		st.executeUpdate(sqldrop);
		st.executeUpdate(sqlcreate);
				
		int count =1 ;
		for (int i = 1; i < row; i++) {
			int length = Integer.parseInt(NodeXml.Random_Func1("i"));

			length = length > 2 ? length : 2; 
			for (int j = 1; j <length ; j++) {
				
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
			
				String sql = "INSERT abil_detail_g VALUES("+null+","+
						"'"+count+"'"+","+
							"'"+NodeXml.Random_Func1("SSsssssSSI")+"'"+","+
							"'"+NodeXml.Random_Func1("oN/S")+"'"+","+
							"'"+"N/A"+"'"+","+
							
							
							
							"'"+NodeXml.Random_Func1("ii")+"'"+","+
							"'"+NodeXml.Random_Func1("SSs")+"'"+","+
							"'"+NodeXml.Random_Func1("ii")+"'"+","+
							"'"+NodeXml.Random_Func1("SSS")+"'"+","+
							"'"+NodeXml.Random_Func1("ii")+"'"+","+
							
							
							
							"'"+NodeXml.Random_Func1("SSS")+"'"+","+
							"'"+NodeXml.Random_Func1("ii")+"'"+","+
							"'"+NodeXml.Random_Func1("SSS")+"'"+","+
							"'"+NodeXml.Random_Func1("Name Sss")+"'"+","+
							"'"+NodeXml.Random_Func1("Street SSS   ii/ii")+"'"+","+
							
							
							"'"+NodeXml.Random_Func1("SSS")+"'"+","+
							"'"+"N/A"+"'"+","+
							"'"+"N/A"+"'"+","+
							"'"+"N/A"+"'"+","+
							"'"+"TH"+"'"+","+
							
							
							"'"+NodeXml.Random_Func1("iiiiiiiii")+"'"+","+
							"'"+NodeXml.Random_Func1("S")+"'"+","+
							"'"+NodeXml.Random_Func1("SSS")+"'"+","+
							"'"+NodeXml.Random_Func1("Street SSS   ii/ii")+"'"+","+
							"'"+NodeXml.Random_Func1("SSS")+"'"+","+
							
							
							"'"+"N/A"+"'"+","+
							"'"+"N/A"+"'"+","+
							"'"+"N/A"+"'"+","+
							"'"+NodeXml.Random_Func1("SS")+"'"+","+
							"'"+"N/A"+"'"+","+
							
							
							"'"+"N/A"+"'"+","+
							"'"+"N/A"+"'"+","+
							"'"+"N/A"+"'"+","+
							"'"+"N/A"+"'"+","+
							"'"+"N/A"+"'"+","+
							
							"'"+NodeXml.Random_Func1("SS")+"'"+","+
							"'"+"N/A"+"'"+""+
							
							
						")";
				
				System.out.println(sql);
				int val = st.executeUpdate(sql);
			}
			
			count++;
		}
	}
	
	
	
	
	
	
	
	
	
	
	private void create_keyword_row(java.sql.Connection conn2) throws SQLException {
		// TODO Auto-generated method stub
		Statement st = conn2.createStatement();
		
		String sqldrop = "DROP TABLE IF EXISTS `keyword`";
		
		String sqlcreate =  "CREATE TABLE `keyword` ("+
		 " `id` int(10) NOT NULL AUTO_INCREMENT,"+
		 " `id_2` int(10) unsigned NOT NULL,"+
		 " `userid` varchar(45) NOT NULL,"+
		 "  `mawb` varchar(45) NOT NULL,"+
		 " `hawb` varchar(45) NOT NULL,"+
		 " `flightno` varchar(45) NOT NULL,"+
		"  `flightdate` varchar(45) NOT NULL,"+
		 " `flighttime` varchar(45) NOT NULL,"+
		 "  `referenceNumber` varchar(45) NOT NULL,"+
		 "  `receivecontrolnumber` varchar(45) NOT NULL,"+
		 "  `grossweight` varchar(45) NOT NULL,"+
		 "  `grossweightunit` varchar(45) NOT NULL,"+

		 "  `messagefunction` varchar(45) NOT NULL,"+
		 "  `lastentry` varchar(45) NOT NULL,"+
		 "	`shedno` varchar(45) NOT NULL ," +

		 "PRIMARY KEY (`id`)"+
		") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8";
		
		st.executeUpdate(sqldrop);
		
		st.executeUpdate(sqlcreate);
				
		
		
		int count =1 ;
		for (int i = 1; i < row; i++) {
			int id2 = Integer.parseInt(NodeXml.Random_Func1("i"));
			id2 = id2 > 2 ? id2 : 2; 
			
			for (int j = 1; j <id2 ; j++) {
				
				
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
				
				String groossweight = Integer.parseInt(NodeXml.Random_Func1("i"))>3 ?
						Integer.parseInt(NodeXml.Random_Func1("i"))>5 ? 
						Integer.parseInt(NodeXml.Random_Func1("i"))>8 ?
						"KGM": "TNE": "GRM": "CTM";
				
				String Last = Integer.parseInt(NodeXml.Random_Func1("i")) >5 ?  "Y": "N";
				String sql = "INSERT keyword VALUES("+null+","+
							"'"+count+"'"+","+
							"'"+NodeXml.Random_Func1("iiiiiiiiiii")+"'"+","+
							//MAWB
							"'"+NodeXml.Random_Func1("Siiiiiiiiii")+"'"+","+
							//HAWB
							"'"+NodeXml.Random_Func1("iiii")+"'"+","+
							//flightNO
							"'"+NodeXml.Random_Func1("TGiiii")+"'"+","+
							"'"+DateFormat.format(oldDate)+"'"+","+
							"'"+TimeFormat.format(oldDate)+"'"+","+
							"'"+NodeXml.Random_Func1("DocSiiiiiiiiii")+"'"+","+
							"'"+NodeXml.Random_Func1("RECiiiiiiiiiiiii")+"'"+","+
							"'"+NodeXml.Random_Func1("iiiii")+"."+NodeXml.Random_Func1("iii")+"'"+","+
							"'"+groossweight+"'"+","+
							"'"+( Last == "Y"  ?  9: Integer.parseInt(NodeXml.Random_Func1("i"))>5 ? 1 : 2 )+"'"+","+
							"'"+(Last == "Y" ?  "Y": "N")+"'"+","+
							"'"+(Integer.parseInt(NodeXml.Random_Func1("i")) >5  ?  "1191": "1192")+"'"+""+
							
							")";
				
				System.out.println(sql);
				int val = st.executeUpdate(sql);
			}
			
			count++;
		}
	}
	
	
	
	
}
