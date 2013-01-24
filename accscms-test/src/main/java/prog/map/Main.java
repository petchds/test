package prog.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//import Domain.Aman;
//import Generate.AbilGenerate;
//import Generate.AbilGenerate_g;
//import Generate.AmanGenerate;
//import Generate.AmanGenerate_g;
//import Generate.CommonGenerate;
//import Generate.VsedGenerate;
//import Generate.VsedGenerate_g;

public class Main {
	private static Print print = new Print();
	

	/**
	 * @param args
	 * @throws Exception 
	 */
	
	
	public static void main(String[] args) throws Exception {
		 // TODO code application logic here 
		Connection conn = ConnectionMysql();
		
     	print.writeFile("TempXML/GateWay/vsed.xml", "TPrintOutput/Vessel_GateWay.txt", conn ,"vsed_control","vsed_detail");
    	print.writeFile("TempXML/GateWay/aman.xml", "TPrintOutput/Aman_GateWay.txt", conn,"aman_control","aman_detail" );
    	print.writeFile("TempXML/GateWay/abil.xml", "TPrintOutput/Abil_GateWay.txt", conn ,"abil_control","abil_detail" );
     	
//		
//		
//		Connection conn = ConnectionMysql();
//		
//			
	
	
//    	InsertDB insertDB = new InsertDB(conn,20);
//	
//     	print.writeFile("TempXML/vsed_g1.xml", "Output/Vessel_GateWay.txt", conn ,"vsed_control_g","vsed_detail_g","keyword");
//    	print.writeFile("TempXML/aman_g1.xml", "Output/Aman_GateWay.txt", conn,"aman_control_g","aman_detail_g","keyword" );
//    	print.writeFile("TempXML/abil_g1.xml", "Output/Abil_GateWay.txt", conn ,"abil_control_g","abil_detail_g","keyword" );
//     	
//     	
//     	VsedGenerate_g vsedGenerate = new 	VsedGenerate_g();
//    	vsedGenerate.formFile = "TempXML/vsed_g1.xml";
//    	vsedGenerate.toFolder = "TestCaseXML/vsed";
//    	vsedGenerate.name = "vsed";
//    	vsedGenerate.conn = conn;
//    	vsedGenerate.length = 20;
//    	vsedGenerate.run();
//
//    	AmanGenerate_g amanGenerate = new AmanGenerate_g();
//		amanGenerate.formFile = "TempXML/aman_g1.xml";
//		amanGenerate.toFolder = "TestCaseXML/aman";
//		amanGenerate.name = "aman";
//		amanGenerate.conn = conn;
//		amanGenerate.length = 20;
//    	amanGenerate.run();
//
//
//    	AbilGenerate_g abilGenerate = new AbilGenerate_g();
//    	abilGenerate.formFile = "TempXML/abil_g1.xml";
//    	abilGenerate.toFolder = "TestCaseXML/abil";
//    	abilGenerate.name = "abil";
//    	abilGenerate.conn = conn;
//    	abilGenerate.length = 20;
//    	abilGenerate.run();
//    	
//    	
//    	
//    	
    	
    	
    	
    	
    	
    	
    	
    	
	} 
	
	public static Connection ConnectionMysql(){
		
		System.out.println("MySQL Connect Example.");
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "accscmstest";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "1234";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");
             } catch (Exception e) {
            e.printStackTrace();
        }
       return conn; 
	}
	
}
