package prog.generate.gateway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Map;

import Domain.Aman;

public class AmanGenerate extends _GenObject{
    public String formFile;
    public String toFolder;
    public String name;
    public Connection conn;
    
    
    
    
    public void run() throws IOException, Exception{
    	
    	Aman aman = new Aman();
  		String[][] fieldControl = new String[6][2];
  		String[][] fieldDetail = new String[9][2];
  		aman.setCon(conn);
  		

		fieldControl[0][0] = "man1:referenceNumber";
		fieldControl[1][0] = "man1:receivedControlNumber";
		fieldControl[2][0] = "man1:portOfLoading";
		fieldControl[3][0] = "man1:portOfDischarge";
		fieldControl[4][0] = "man1:processingIndicator";
		fieldControl[5][0] = "man1:messageFunction";
		
	
		
		
		String sqlCommand1 = "SELECT "+
		" reference_number ," + 
		" received_control_number ," + 
		" port_of_loading ," + 
		" port_of_discharge ," + 
		" processing_indicator ," + 
		" message_function " + 
		"FROM aman_control WHERE id =";

		   

		fieldDetail[0][0] = "man1:referenceNo";
		fieldDetail[1][0] = "man1:shipAgentCode";
		fieldDetail[2][0] = "man1:masterAirWaybillNumber";
		fieldDetail[3][0] = "man1:numberOfHouseAirWaybill";
		fieldDetail[4][0] = "man1:grossWeight";
		fieldDetail[5][0] = "man1:grossWeightUnit";
		fieldDetail[6][0] = "man1:numberOfPackage";
		fieldDetail[7][0] = "man1:packageUnit";
		fieldDetail[8][0] = "man1:lastEntry";


		
		String sqlCommand2 = "SELECT "+
				" received_control_number ," + 
				" aircraft_agent_tax_number ," + 
				" mawb ," + 
				" number_of_hawb ," + 
				" total_gross_weight ," + 
				" total_gross_weight_unit ," + 
				" total_number_of_package ," + 
				" total_number_of_package_unit ," + 
				" last_entry " + 
			//	" modified_date_time ," + 
			//	" terminal_operator ," + 
			//	" type ," + 
				"FROM aman_detail WHERE aman_control_id = ";
		
  		aman.setFieldControl(fieldControl);
  		aman.setFieldDetail(fieldDetail);
  		
  		for (int i = 1; i <= 200; i++) {		
	    	Map<String, Object> mapstrControl = aman.getDBAmanControl(sqlCommand1.concat(Integer.toString(i)));
	  		aman.setAmanControl(mapstrControl);
	  		LinkedList<Map<String, Object>> listDetail = aman.getDBAmanDetail(sqlCommand2.concat(Integer.toString(i)));
	  		
	  		aman.setAmanDetail(listDetail);
	  		WriteFile(formFile, aman, toFolder, name.concat(Integer.toString(i)).concat(".xml"));
  		}
        
  	}
	
	
	
}
