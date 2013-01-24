package prog.generate.gateway;

import java.io.IOException;
import java.sql.Connection;

import prog.common._GenObject;
import prog.domain.gateway.*;

public class CloseFlight extends _GenObject{
    public String formFile;
    public String toFolder;
    public String name;
    public Connection conn;
    public int length=10;
    
    public void run() throws IOException, Exception{
    
    	GateWay gateWay = new GateWay();
    	String[][] fieldControl = new String[13][2];
    	String[][] fieldDetail = new String[39][2];

    	fieldControl[0][0] = "DocumentNumber";
		fieldControl[1][0] = "Receivedcontrolnumber";
		fieldControl[2][0] = "DocumentType";
		fieldControl[3][0] = "UserId";
		fieldControl[4][0] = "CarrierID";
		fieldControl[5][0] = "TransportMeansCode";
		fieldControl[6][0] = "TransportMeansJourneyID";
		fieldControl[7][0] = "TransportMeansIdentificationText";
		fieldControl[8][0] = "Nationality";
		fieldControl[9][0] = "TransportModeCode";
		fieldControl[10][0] = "MasterName";
		fieldControl[11][0] = "PreviousFlightNo";
		fieldControl[12][0] = "PreviousDate";
		
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
				" registration_id ," + 
				" modified_date_time ," + 
				" type ," + 
				"FROM vsed_control WHERE ...";

  		fieldDetail[0][0] = "DischargeLocationID";
		fieldDetail[1][0] = "BerthDate";
		fieldDetail[2][0] = "TransportEquipmentID";
		fieldDetail[3][0] = "ExpectedDateAndTime";
		fieldDetail[4][0] = "LastCallLocationID";
		fieldDetail[5][0] = "Measure";
		fieldDetail[6][0] = "MeasureUnitCode";
		fieldDetail[7][0] = "MessageFunction";
		fieldDetail[8][0] = "LastEntry";
		
		gateWay.
//		String sqlCommand2 = "SELECT "+
//				" id ," + 
//				" id2 ," + 
//				" vsed_control_id ," + 
//				" received_control_number ," + 
//				" port_of_discharge ," + 
//				" flight_no ," + 
//				" flight_date ," + 
//				" flight_time ," + 
//				" estimate_to_berth_date ," + 
//				" estimate_to_berth_time ," + 
//				" berth ," + 
//				" last_port_of_call ," + 
//				" number_of_mawb ," + 
//				" number_of_hawb ," + 
//				" number_of_container ," + 
//				" total_gross_weight ," + 
//				" total_gross_weight_unit ," + 
//				" message_function ," + 
//				" last_entry ," + 
//				" modified_date_time ," + 
//				" terminal_operator ," + 
//				" type ," + 
//				" close_flight ," + 
//				"FROM vsed_detail WHERE ..."


//  		
    
    }
	
}
