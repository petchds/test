package prog.map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class NodeXml {
	
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String dbName = "testcase";
    private  static String driver = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String password = "1234";
    
    
	public static int count = 0 ;
	public static Date fromDate = new Date();
	public static Date toDate; 
	
	public static String Classname = "";
	public static LinkedList<String> list_DeclarationNo;
	
	public static String getValue(String nodeName,Object obj){
	
			String checkNodeName = nodeName.indexOf(":")!=-1 ?nodeName.substring(nodeName.indexOf(":")+1,nodeName.length()): nodeName;
			String value = "";
			
			if(Classname != obj.getClass().getName()){
				Classname = obj.getClass().getName();
				System.out.println( Classname + " run getValue");
///	list_DeclarationNo = getlistdeclaration();
				
			}
			fromDate = new Date();
			fromDate.setDate( 0 - (int)(Math.random()*365));
		
			switch(checkNodeName){
		
			case "created" : value = "2006-08-20T00:27:14+07:00";
			break;
			case "offset" :	value = "10";
			break;
			case "numOfResult" : value = "3";
			break;
			case "estimateToBerthDate" :	value = "2012-08-19";
			break;
			case "estimateToBerthTime" :	value = "04:45:33";
			break;
			case "declarationNo" :	value = list_DeclarationNo.getFirst();
											list_DeclarationNo.removeFirst();
			break;
			case "balancedDate" : value = "2012-12-20T00:27:14+07:00";	
			break;
//			case "vesselName" :	value = value;
//			break;
//			case "masterAirWaybill" :	value = value;
//			break;
//			case "houseAirWaybill" :	value = value;
//			break;
//			case "flightNo" :	value = value;
//			break;
//			case "flightDate" :	value = value;
//			break;
//			case "portOfDischarge" :	value = value;
//			break;
//			case "shedNumber" :	value = value;
//			break;
//			case "numberOfPackage" :	value = value;
//			break;
//			case "numberOfPackageUnit" :	value = value;
//			break;
//			case "grossWeight" :	value = value;
//			break;
//			case "grossWeightUnit" :	value = value;
//			break;
//			case "status0309DateTime" :	value = value;
//			break;

			
			case "toDate" : value = toDate.toString();
			break;
			case "fromDate" : value = fromDate.toString();
			break;
			
			default : value = Random_Func1("iissSS");
			break;
		}
		return value;
		
		//s
	}
	
	
	
	public static Connection ConnectionMysql(){
		
		System.out.println("MySQL Connect  Node Xml ");
        Connection conn = null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database  Node Xml ");
             } catch (Exception e) {
            e.printStackTrace();
        }
       return conn; 
	}
	
	
	public static LinkedList<String> getlistdeclaration() throws SQLException{   
			LinkedList<String> List = new LinkedList<String>(); 
			String sqlCommand = "SELECT declaration_no FROM goods_transition g limit 200";
		
		//	list_declaration_no
			Connection con = ConnectionMysql();
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(sqlCommand);
	        ResultSetMetaData md = rs.getMetaData();
	        while(rs.next()){
	        		String param = rs.getString(1);
	            	List.add(param);
	              }
	        return List;
	    }

	public static String Random_Func1(String str){
	char[] charArray = str.toCharArray();
	String  value = "";
	int x ;
	for (int i = 0; i < charArray.length; i++) {
		switch(charArray[i]){
		
		case 'i':	value = value + (int)(Math.random()*10);
					break;
		case 'I':	x =  (int)(Math.random()*10);
					value = value +( x > 0 ? x :x+1);
					
					break;
		case 's':	value = value.concat(Character.toString((char) (97+(int)(Math.random()*26))));
					break;
		case 'S':	value = value.concat(Character.toString((char) (65+(int)(Math.random()*26))));
					break;
		default:	value = value.concat(Character.toString(charArray[i]));
					break;
		}}
	return value;
	}
	
	
	
	

	
	
	//"return String random length "
	public static String Random_Func2(){
		int length = (int)(Math.random()*100)/5;
		String value = "";
		int Character ;
		
		length = length > 5 ? length : 5;
		
		for (int i = 0; i < length; i++) {
			Character =(int)(Math.random()*10);
			Character = Character >= 3 ? Character >= 6 ?  3: 2 : 1;
			
			
		switch (Character) {
		case 1:
			value = value.concat("i");
			break;
		case 2:
			value = value.concat("s");
			
			break;
		case 3:
			value = value.concat("S");
			
			break;	
		default:
			break;
		}
			
			
			
		}
		
		
		
		
		return  Random_Func1(value);
		
		
	}

	

}
