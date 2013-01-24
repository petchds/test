package prog.insert;


import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.tti.accscms.dao.DaoException;
import com.tti.accscms.domain.manifest.VesselScheduleControl;
import com.tti.accscms.mapper.manifest.VesselScheduleControlDaoImpl;

public class IVesselScheduleControl {
	
	@Autowired
	public VesselScheduleControlDaoImpl vsedControlDao ;


	private int count = 0;
	
	public int insert(int amount) {
		
		for (int i = 1; i <= amount; i++) {
			 
			for (int j = 1; j <=1 ; j++) {
			Double deadWeightTonnage = Double.parseDouble(RandomValue.Func1("iiii.iii"));
			Double grossRegisterTonnage = Double.parseDouble(RandomValue.Func1("iiii.iii"));
			Date current = Calendar.getInstance().getTime();
			Date oldDateTime = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
			Double netRegisterTonnage = Double.parseDouble(RandomValue.Func1("iiii.iii"));
			
			String processingIndicator = (i > amount /2 ? "22": "23");
			
			VesselScheduleControl vesselScheduleControl = new VesselScheduleControl();
			vesselScheduleControl.setId(null);
			vesselScheduleControl.setId2(i);
			vesselScheduleControl.setCallsign("callsign");
			vesselScheduleControl.setDeadWeightTonnage(deadWeightTonnage);
			
			vesselScheduleControl.setGrossRegisterTonnage(grossRegisterTonnage);
			vesselScheduleControl.setMasterName("maName");
			vesselScheduleControl.setModeOfTransport("23");
			
		
			vesselScheduleControl.setModifiedDateTime(current);
			vesselScheduleControl.setNationality(RandomValue.Func1("ss"));
			vesselScheduleControl.setNetRegisterTonnage(netRegisterTonnage);
			
			vesselScheduleControl.setPreviousDate(oldDateTime);
			vesselScheduleControl.setPreviousFlightNo(RandomValue.Func1("SSiiii"));
			vesselScheduleControl.setProcessingIndicator(processingIndicator);
			vesselScheduleControl.setReceivedControlNumber(RandomValue.Func1("RECiiiiii"));
			vesselScheduleControl.setReferenceNumber(RandomValue.Func1("Refiiii"));
			vesselScheduleControl.setRegistrationId(RandomValue.Func1("regiiiiiii"));
			vesselScheduleControl.setShipAgentBranch(Integer.parseInt(RandomValue.Func1("ii")));
			vesselScheduleControl.setShipAgentTaxNumber(RandomValue.Func1("sss"));
			vesselScheduleControl.setType(Integer.parseInt(RandomValue.Func1("ii")));
			vesselScheduleControl.setVesselName("veName");
		
			
			count++;
			try {
				vsedControlDao.insert(vesselScheduleControl);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			}
		}
		
		return count;
	}
}
