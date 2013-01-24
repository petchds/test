package prog.generate.gateway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Map;

import prog.common._GenObject;
import prog.domain.cms.AbilCMS;

public class AbilGenerate_g extends _GenObject{
    public String formFile;
    public String toFolder;
    public String name;
    public Connection conn;
    public int length=10;
    
    
    
    
    public void run() throws IOException, Exception{
//    	
//    	AbilCMS abil = new Abil_g();
//  		String[][] fieldControl = new String[13][2];
//  		String[][] fieldDetail = new String[39][2];
//  		abil.setCon(conn);
//  		
//  		
//  		
//  		fieldControl[0][0] = "ReferenceNo";
//  		fieldControl[1][0] = "RecvControlNo";
//  		fieldControl[2][0] = "ProcessIndicator";
//  		fieldControl[3][0] = "MessageFunction";
//  		fieldControl[4][0] = "OriginCountryCode";
//  		fieldControl[5][0] = "UserId";
//  		fieldControl[6][0] = "ForwarderAssignedID";
//  		fieldControl[7][0] = "TaxReference";
//  		fieldControl[8][0] = "MasterBLNo";
//  		fieldControl[9][0] = "LoadingLocationID";
//  		fieldControl[10][0] = "DischargeLocationID";
//  		fieldControl[11][0] = "DeliveryLocationID";
//  		fieldControl[12][0] = "ShedNo";
//		
//
//		String sqlCommand1 = "SELECT "+
//				" k.referenceNumber ," +
//				" k.receivecontrolnumber ," + 
//				" a.processindicator ," + 
//				" k.messagefunction ," +
//				" a.origincountrycode , " +
//				" k.userid , " + 
//				" a.forwarderassignedid ," + 
//				" a.taxreference ," + 
//				" k.mawb ," + 
//				" a.loadinglocationid ," + 
//				" a.dischargelocationid ," + 
//				" a.deliverylocationid ," + 
//				" k.shedno " + 
//				"FROM abil_control_g  a, keyword k WHERE a.id = k.id and a.id = ";
//
//
//  	
//		fieldDetail[0][0] = "HouseBLNo";
//		fieldDetail[1][0] = "ItemDescription";
//		fieldDetail[2][0] = "DangerousGoods";
//		fieldDetail[3][0] = "ShippingMark";
//		fieldDetail[4][0] = "NumberOfPackages";
//		fieldDetail[5][0] = "UnitOfPackages";
//		fieldDetail[6][0] = "Measure";
//		fieldDetail[7][0] = "MeasureUnitCode";
//		fieldDetail[8][0] = "FOBValue";
//		fieldDetail[9][0] = "FOBCurrencyCode";
//		fieldDetail[10][0] = "FreightValue";
//		fieldDetail[11][0] = "FreightCurrencyCode";
//		fieldDetail[12][0] = "InsuranceValue";
//		fieldDetail[13][0] = "InsuranceCurrencyCode";
//		fieldDetail[14][0] = "Name";
//		fieldDetail[15][0] = "Street";
//		fieldDetail[16][0] = "District";
//		fieldDetail[17][0] = "SubProvince";
//		fieldDetail[18][0] = "Province";
//		fieldDetail[19][0] = "PostCode";
//		fieldDetail[20][0] = "CountryCode";
//		fieldDetail[21][0] = "PhoneNo";
//		fieldDetail[22][0] = "Name";
//		fieldDetail[23][0] = "Street";
//		fieldDetail[24][0] = "District";
//		fieldDetail[25][0] = "SubProvince";
//		fieldDetail[26][0] = "Province";
//		fieldDetail[27][0] = "PostCode";
//		fieldDetail[28][0] = "CountryCode";
//		fieldDetail[29][0] = "PhoneNo";
//		fieldDetail[30][0] = "Name";
//		fieldDetail[31][0] = "Street";
//		fieldDetail[32][0] = "District";
//		fieldDetail[33][0] = "SubProvince";
//		fieldDetail[34][0] = "Province";
//		fieldDetail[35][0] = "PostCode";
//		fieldDetail[36][0] = "CountryCode";
//		fieldDetail[37][0] = "PhoneNo";
//		fieldDetail[38][0] = "LastEntry";
//
//		String sqlCommand2 = "SELECT "+
//				" k.hawb ," + 
//			" a.itemdescription ," + 
//			" a.dangerousgoods ," + 
//			" a.shippingmark ," + 
//			"  a.numberofpackages ," + 
//			
//			
//			"  a.unitofpackages ," + 
//				" k.grossweight ," + 
//				" k.grossweightunit ," + 
//			"  a.fobvalue ," + 
//			"  a.fobcurrencycode ," + 
//			
//			
//			"  a.freightvalue ," + 
//			"  a.freightcurrencycode ," + 
//			"  a.insurancevalue ," + 
//			"  a.insurancecurrencycode ," + 
//			"  a.cosignorparty_name ," + 
//			
//			
//			"  a.cosignorparty_street ," + 
//			"  a.cosignorparty_district ," + 
//			"  a.cosignorparty_subprovince ," + 
//			"  a.cosignorparty_province ," + 
//			"  a.cosignorparty_postcode ," + 
//			
//			
//			"  a.cosignorparty_countrycode ," + 
//			"  a.cosignorparty_phoneno ," + 
//			"  a.cosigneeparty_name ," + 
//			"  a.cosigneeparty_street ," + 
//			"  a.cosigneeparty_district ," + 
//			
//			
//			"  a.cosigneeparty_subprovince ," + 
//			"  a.cosigneeparty_province ," + 
//			"  a.cosigneeparty_postcode ," + 
//			"  a.cosigneeparty_countrycode ," + 
//			"  a.cosigneeparty_phoneno ," + 
//			
//			
//			"  a.notifyparty_name ," + 
//			"  a.notifyparty_street ," + 
//			"  a.notifyparty_district ," + 
//			"  a.notifyparty_subprovince ," + 
//			"  a.notifyparty_province ," + 
//			
//			
//			"  a.notifyparty_postcode ," + 
//			"  a.notifyparty_countrycode ," + 
//			"  a.notifyparty_phoneno ," + 
//			" k.lastentry " + 
//			"FROM abil_detail_g a ,keyword k WHERE a.id_2 = k.id and a.id_2 = "; 
//			
//  		abil.setFieldControl(fieldControl);
//  		abil.setFieldDetail(fieldDetail);
//  		
//  		for (int i = 1; i <=length; i++) {
//    		Map<String, Object> mapstrControl = abil.getDBAbilControl(sqlCommand1.concat(Integer.toString(i)));
//  		abil.setAbilControl(mapstrControl);
//  		LinkedList<Map<String, Object>> listDetail = abil.getDBAbilDetail(sqlCommand2.concat(Integer.toString(i)));
//  		abil.setAbilDetail(listDetail);
//  		WriteFile(formFile, abil, toFolder, name.concat(Integer.toString(i)).concat(".xml")); 
//  		
  		}
        
  	}
	
	
	
}
