package prog.generate.gateway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Map;

import Domain.Abil;

public class NormalCustomPermitGenerate extends _GenObject{
    public String formFile;
    public String toFolder;
    public String name;
    public Connection conn;
    
    
    
    
    public void run() throws IOException, Exception{
    	
    	Abil abil = new Abil();
  		String[][] fieldControl = new String[12][2];
  		String[][] fieldDetail = new String[43][2];
  		abil.setCon(conn);
  		
  		
  		
  	
  		fieldControl[0][0] = "man1:referenceNumber";
  		fieldControl[1][0] = "man1:receivedControlNumber";
  		fieldControl[2][0] = "man1:freightForwarderTaxNumber";
  		fieldControl[3][0] = "man1:freightForwarderBranch";
		fieldControl[4][0] = "man1:processingIndicator";
		fieldControl[5][0] = "man1:masterAirWaybill";
		fieldControl[6][0] = "man1:isoOriginCountryCode";
		fieldControl[7][0] = "man1:portOfLoading";
		fieldControl[8][0] = "man1:portOfDischarge";
		fieldControl[9][0] = "man1:placeOfDelivery";
		fieldControl[10][0] = "man1:shedNumber";
		fieldControl[11][0] = "man1:messageFunction";
		
		String sqlCommand1 = "SELECT "+
			
				" reference_number ," + 
				" received_control_number ," + 
				" freight_forwarder_tax_number ," + 
				" freight_forwarder_branch ," + 
				" processing_indicator ," + 
				" mawb ," + 
				" origin_country_code ," + 
				" port_of_loading ," + 
				" port_of_discharge ," + 
				" place_of_delivery ," + 
				" shed_no ," + 
				" message_function " + 
				
				"FROM abil_control WHERE id = ";
  		
  		
  	
		fieldDetail[0][0] = "man1:referenceNo";
		fieldDetail[1][0] = "man1:houseAirWaybill";
		fieldDetail[2][0] = "man1:streetAndNumber";
		fieldDetail[3][0] = "man1:district";
		fieldDetail[4][0] = "man1:subProvince";
		fieldDetail[5][0] = "man1:province";
		fieldDetail[6][0] = "man1:postcode";
		fieldDetail[7][0] = "man1:phoneNumber";
		fieldDetail[8][0] = "man1:isoCountryCode";
		fieldDetail[9][0] = "man1:consignorName";
		fieldDetail[10][0] = "man1:consigneeOrNotifyParty";
		fieldDetail[11][0] = "man1:streetAndNumber";
		fieldDetail[12][0] = "man1:district";
		fieldDetail[13][0] = "man1:subProvince";
		fieldDetail[14][0] = "man1:province";
		fieldDetail[15][0] = "man1:postcode";
		fieldDetail[16][0] = "man1:phoneNumber";
		fieldDetail[17][0] = "man1:isoCountryCode";
		fieldDetail[18][0] = "man1:consigneeName";
		fieldDetail[19][0] = "man1:streetAndNumber";
		fieldDetail[20][0] = "man1:district";
		fieldDetail[21][0] = "man1:subProvince";
		fieldDetail[22][0] = "man1:province";
		fieldDetail[23][0] = "man1:postcode";
		fieldDetail[24][0] = "man1:phoneNumber";
		fieldDetail[25][0] = "man1:isoCountryCode";
		fieldDetail[26][0] = "man1:notifyPartyName";
		fieldDetail[27][0] = "man1:grossWeight";
		fieldDetail[28][0] = "man1:grossWeightUnit";
		fieldDetail[29][0] = "man1:numberOfPackage";
		fieldDetail[30][0] = "man1:packageUnit";
		fieldDetail[31][0] = "man1:fobValue";
		fieldDetail[32][0] = "man1:fobCurrencyCode";
		fieldDetail[33][0] = "man1:freightValue";
		fieldDetail[34][0] = "man1:freightCurrencyCode";
		fieldDetail[35][0] = "man1:insuranceValue";
		fieldDetail[36][0] = "man1:insuranceCurrencyCode";
		fieldDetail[37][0] = "man1:markAndLabels";
		fieldDetail[38][0] = "man1:descriptionOfGoods";
		fieldDetail[39][0] = "man1:declarationNo";
		fieldDetail[40][0] = "man1:lastEntry";
		fieldDetail[41][0] = "man1:balanced";
		fieldDetail[42][0] = "man1:balancedDate";


		String sqlCommand2 = "SELECT "+
	
			" received_control_number ," +
			" hawb ," + 
			" consignor_street_and_number ," + 
			" consignor_district ," + 
			" consignor_sub_province ," + 
			
			" consignor_province ," + 
			" consignor_postcode ," + 
			" consignor_phone_number ," + 
			" consignor_country_code ," +
			" consignor_name ," + 
			
			" consignee_or_notify_party ," + 
			" consignee_street_and_number ," + 
			" consignee_district ," + 
			" consignee_sub_province ," + 
			" consignee_province ," + 
			
			" consignee_postcode ," + 
			" consignee_phone_number ," + 
			" consignee_country_code ," + 
			" consignee_name ," + 
			" notify_party_street_and_number ," + 
			
			" notify_party_district ," + 
			" notify_party_sub_province ," + 
			" notify_party_province ," + 
			" notify_party_postcode ," + 
			" notify_party_phone_number ," + 
			
			" notify_party_country_code ," + 
			" notify_party_name ," + 
			" total_gross_weight ," + 
			" total_gross_weight_unit ," + 
			" total_number_of_package ," + 
			
			" total_number_of_package_unit ," + 
			" fob_value_foreign ," + 
			" fob_currency_code ," + 
			" freight_amount_foreign ," + 
			" freight_currency_code ," + 
			
			" insurance_amount_foreign ," + 
			" insurance_currency_code ," + 
			" mark_and_labels ," + 
			" goods_description ," + 		
			" declaration_no ," + 
			
			" last_entry ," + 
			" balanced ," + 
			" balanced_date_time " +
			
			"FROM abil_detail WHERE abil_control_id = ";
  		
  		
  		
  		
  		
  		abil.setFieldControl(fieldControl);
  		abil.setFieldDetail(fieldDetail);
  		
  		for (int i = 1; i <=200; i++) {
    	Map<String, Object> mapstrControl = abil.getDBAbilControl(sqlCommand1.concat(Integer.toString(i)));
  		abil.setAbilControl(mapstrControl);
  		LinkedList<Map<String, Object>> listDetail = abil.getDBAbilDetail(sqlCommand2.concat(Integer.toString(i)));
  		abil.setAbilDetail(listDetail);
  		WriteFile(formFile, abil, toFolder, name.concat(Integer.toString(i)).concat(".xml")); 
  		
  		}
        
  	}
	
	
	
}
