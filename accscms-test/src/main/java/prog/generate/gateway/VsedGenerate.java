package prog.generate.gateway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Map;

import Domain.Vsed;

public class VsedGenerate extends _GenObject{
    public String formFile;
    public String toFolder;
    public String name;
    public Connection conn;
    
    
    
    
    public void run() throws IOException, Exception{
    	
    	Vsed vsed = new Vsed();
  		String[][] fieldControl = new String[17][2];
  		String[][] fieldDetail = new String[16][2];
  		vsed.setCon(conn);
  		
  		
  		
  		fieldControl[0][0] = "man1:referenceNumber";
  		fieldControl[1][0] = "man1:receivedControlNumber";
  		fieldControl[2][0] = "man1:modeOfTransport";
  		fieldControl[3][0] = "man1:processingIndicator";
  		fieldControl[4][0] = "man1:typeOfTransport";
  		fieldControl[5][0] = "man1:shipAgentTaxNumber";
  		fieldControl[6][0] = "man1:shipAgentBranch";
		fieldControl[7][0] = "man1:callsign";
		fieldControl[8][0] = "man1:vesselName";
		fieldControl[9][0] = "man1:masterName";
		fieldControl[10][0] = "man1:previousFlightNo";
		fieldControl[11][0] = "man1:previousDate";
		fieldControl[12][0] = "man1:nationality";
		fieldControl[13][0] = "man1:netRegisterTonnage";
		fieldControl[14][0] = "man1:grossRegisterTonnage";
		fieldControl[15][0] = "man1:deadWeightTonnage";
		fieldControl[16][0] = "man1:registrationID";
  		

		

	
	
  		
		String sqlCommand1 = "SELECT "+
			
				" reference_number ," + 
				" received_control_number ," + 
				" mode_of_transport ," + 
				" processing_indicator ," + 
				" type_of_transport ," + 
				" ship_agent_tax_number ," + 
				" ship_agent_branch ," + 
				" callsign ," + 
				" vessel_name ," + 
				" master_name ," + 
				" previous_flight_no ," + 
				" previous_date ," + 
				" nationality ," + 
				" net_register_tonnage ," + 
				" gross_register_tonnage ," + 
				" dead_weight_tonnage ," + 
				" registration_id " + 
		//		" modified_date_time ," + 
		//		" type ," + 
				"FROM vsed_control WHERE id = ";
  		
  		
  					  		   
  		fieldDetail[0][0] = "man1:receivedControlNumber";
		fieldDetail[1][0] = "man1:portOfDischarge";
		fieldDetail[2][0] = "man1:flightNo";
		fieldDetail[3][0] = "man1:flightDate";
		fieldDetail[4][0] = "man1:flightTime";
		fieldDetail[5][0] = "man1:estimateToBerthDate";
		fieldDetail[5][0] = "man1:estimateToBerthTime";
		fieldDetail[7][0] = "man1:berth";
		fieldDetail[8][0] = "man1:lastPortOfCall";
		fieldDetail[9][0] = "man1:numberOfMasterAirWaybill";
		fieldDetail[10][0] = "man1:numberOfHouseAirWaybill";
		fieldDetail[11][0] = "man1:numberOfContainer";
		fieldDetail[12][0] = "man1:totalGrossWeight";
		fieldDetail[13][0] = "man1:totalGrossWeightUnitCode";
		fieldDetail[14][0] = "man1:messageFunction";
		fieldDetail[15][0] = "man1:lastEntry";
  		
		String sqlCommand2 = "SELECT "+
				" received_control_number ," + 
				" port_of_discharge ," + 
				" flight_no ," + 
				" flight_date ," + 
				" flight_time ," + 
				" estimate_to_berth_date ," + 
				" estimate_to_berth_time ," + 
				" berth ," + 
				" last_port_of_call ," + 
				" number_of_mawb ," + 
				" number_of_hawb ," + 
				" number_of_container ," + 
				" total_gross_weight ," + 
				" total_gross_weight_unit ," + 
				" message_function ," + 
				" last_entry " + 
				"FROM vsed_detail WHERE vsed_control_id = ";

		
		
		
		
  		vsed.setFieldControl(fieldControl);
  		vsed.setFieldDetail(fieldDetail);
  		
  		
  		
  		for (int i = 1; i <= 200; i++) {
    	Map<String, Object> mapstrControl = vsed.getDBVsedControl(sqlCommand1.concat(Integer.toString(i)));
  		vsed.setVsedControl(mapstrControl);
  	
  		LinkedList<Map<String, Object>> listDetail = vsed.getDBVsedDetail(sqlCommand2.concat(Integer.toString(i)));
  		vsed.setVsedDetail(listDetail);
 		
  		WriteFile(formFile, vsed, toFolder, name.concat(Integer.toString(i)).concat(".xml")); 
  		}
        
  	}
	
	
	
}
