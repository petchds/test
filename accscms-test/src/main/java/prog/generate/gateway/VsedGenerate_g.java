package prog.generate.gateway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Map;

import Domain.Vsed;
import Domain.Vsed_g;

public class VsedGenerate_g extends _GenObject{
    public String formFile;
    public String toFolder;
    public String name;
    public Connection conn;
    public int length = 10;
    
    
    
    public void run() throws IOException, Exception{
    	
    	Vsed_g vsed = new Vsed_g();
  		String[][] fieldControl = new String[13][2];
  		String[][] fieldDetail = new String[9][2];
  		
  		vsed.setCon(conn);

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
				" k.referenceNumber ," +
				" k.receivecontrolnumber ," + 
				" v.documenttype ," + 
				" k.userid ," + 
				" v.carrierid ," + 
				" v.transportmeanscode ," + 
				" v.transportmeansjourneyid ," + 
				" v.transportmeansidentificationtext ," + 
				" v.nationality ," + 
				" v.transportmodecode ," + 
				" k.mawb ," + 
				" v.previousflightno ," + 
				" v.previousdate " + 
				"FROM vsed_control_g v ,keyword k WHERE v.id = k.id and v.id =" ;



		fieldDetail[0][0] = "DischargeLocationID";
		fieldDetail[1][0] = "BerthDate";
		fieldDetail[2][0] = "TransportEquipmentID";
		fieldDetail[3][0] = "ExpectedDateAndTime";
		fieldDetail[4][0] = "LastCallLocationID";
		fieldDetail[5][0] = "Measure";
		fieldDetail[6][0] = "MeasureUnitCode";
		fieldDetail[7][0] = "MessageFunction";
		fieldDetail[8][0] = "LastEntry";
		
		
			String sqlCommand2 = "SELECT "+
				" v.dischargelocationid ," + 
				" v.berthdate ," + 
				" k.flightno ," + 
				" k.flightdate ," + 
				" k.grossweight ," + 
				" k.grossweightunit ," + 
				" v.lastcalllocationid ," + 
				
				" k.messagefunction ," + 
				" k.lastentry " + 
				"FROM vsed_detail_g v ,keyword k WHERE v.id_2 = k.id and v.id_2 = "; 
		
  		vsed.setFieldControl(fieldControl);
  		vsed.setFieldDetail(fieldDetail);
  		
  		
  		
  		for (int i = 1; i <= length; i++) {
    	Map<String, Object> mapstrControl = vsed.getDBVsedControl(sqlCommand1.concat(Integer.toString(i)));
  		vsed.setVsedControl(mapstrControl);
  	
  		LinkedList<Map<String, Object>> listDetail = vsed.getDBVsedDetail(sqlCommand2.concat(Integer.toString(i)));
  		vsed.setVsedDetail(listDetail);
 		
  		WriteFile(formFile, vsed, toFolder, name.concat(Integer.toString(i)).concat(".xml")); 
  		}
        
  	}
	
	
	
}
