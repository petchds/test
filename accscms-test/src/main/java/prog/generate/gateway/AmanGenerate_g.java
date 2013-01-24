package prog.generate.gateway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Map;

import Domain.Aman;
import Domain.Aman_g;

public class AmanGenerate_g extends _GenObject{
    public String formFile;
    public String toFolder;
    public String name;
    public Connection conn;
    public int length=10;
    
    
    
    
    
    public void run() throws IOException, Exception{
    	
    	Aman_g aman = new Aman_g();
  		String[][] fieldControl = new String[8][2];
  		String[][] fieldDetail = new String[8][2];
  		aman.setCon(conn);
  		
		fieldControl[0][0] = "ReferenceNo";
		fieldControl[1][0] = "RecvControlNo";
		fieldControl[2][0] = "ProcessIndicator";
		fieldControl[3][0] = "MessageFunction";
		fieldControl[4][0] = "UserId";
		fieldControl[5][0] = "LoadingLocationID";
		fieldControl[6][0] = "DischargeLocationID";
		fieldControl[7][0] = "DeliveryLocationID";
		

		String sqlCommand1 = "SELECT "+
				" k.referenceNumber ," +
				" k.receivecontrolnumber ," + 
				" a.processindicator ," + 
				" k.messagefunction ," +
				" k.userid , " +
				" a.loadinglocationid ," + 
				" a.dischargelocationid ," + 
				" a.deliverylocationid " + 
				"FROM aman_control_g  a, keyword k WHERE a.id = k.id and a.id = ";


		   
		fieldDetail[0][0] = "MasterBLNo";
		fieldDetail[1][0] = "HouseNo";
		fieldDetail[2][0] = "NumberOfPackages";
		fieldDetail[3][0] = "UnitOfPackages";
		fieldDetail[4][0] = "Measure";
		fieldDetail[5][0] = "MeasureUnitCode";
		fieldDetail[6][0] = "LastEntry";
		fieldDetail[7][0] = "TransportEquipmentID";


		String sqlCommand2 = "SELECT "+
				" k.mawb ," + 
				" k.hawb ," + 
				" a.numberofpackages ," + 
				" a.unitofpackages ," + 
				" k.grossweight ," + 
				" k.grossweightunit ," + 
				" k.lastentry , " + 
				" k.flightno " + 
				" FROM aman_detail_g a ,keyword k WHERE a.id_2 = k.id and a.id_2 = "; 
				
				
  		aman.setFieldControl(fieldControl);
  		aman.setFieldDetail(fieldDetail);
  		
  		for (int i = 1; i <= length; i++) {		
	    	Map<String, Object> mapstrControl = aman.getDBAmanControl(sqlCommand1.concat(Integer.toString(i)));
	  		aman.setAmanControl(mapstrControl);
	  		LinkedList<Map<String, Object>> listDetail = aman.getDBAmanDetail(sqlCommand2.concat(Integer.toString(i)));
	  		
	  		aman.setAmanDetail(listDetail);
	  		WriteFile(formFile, aman, toFolder, name.concat(Integer.toString(i)).concat(".xml"));
  		}
        
  	}
	
	
	
}
