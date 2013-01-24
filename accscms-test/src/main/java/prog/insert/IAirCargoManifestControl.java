package prog.insert;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;


import com.tti.accscms.dao.DaoException;
import com.tti.accscms.dao.manifest.AirCargoManifestControlDao;
import com.tti.accscms.domain.manifest.AirCargoManifestControl;
import com.tti.accscms.domain.manifest.VesselScheduleControl;
import com.tti.accscms.domain.manifest.VesselScheduleDetail;
import com.tti.accscms.mapper.manifest.AirCargoManifestControlDaoImpl;
import com.tti.accscms.mapper.manifest.VesselScheduleControlDaoImpl;
import com.tti.accscms.mapper.manifest.VesselScheduleDetailDaoImpl;


public class IAirCargoManifestControl {
	
	@Autowired
	private VesselScheduleControlDaoImpl vsedControlDao ;
	@Autowired
	private VesselScheduleDetailDaoImpl vsedDetailDao;
	@Autowired
	private AirCargoManifestControlDaoImpl amanControlDao ;
	
	private int count = 0;
	
	public int insert(int amount) throws DaoException {
		
		for (int i = 1; i <= amount; i++) {
			 
			VesselScheduleControl vesselScheduleControl = vsedControlDao.findById(i);
			VesselScheduleDetail vesselScheduleDetail = vsedDetailDao.findById(vesselScheduleControl.getId());
			
			int length = Integer.parseInt(RandomValue.Func1("i"));
			length = length > 5 ? length : 4 ;
			
			if(vesselScheduleControl!= null)	
			for (int j = 1; j <=length ; j++) {
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
			
				AirCargoManifestControl airCargoManifestControl = new AirCargoManifestControl();
				
				airCargoManifestControl.setId(null);
				airCargoManifestControl.setId2(i);
				airCargoManifestControl.setFlightDate(oldDate);
				airCargoManifestControl.setFlightNo(RandomValue.Func1("SSSiiiiiii"));
				airCargoManifestControl.setModifiedDateTime(current);
				airCargoManifestControl.setProcessingIndicator(vesselScheduleControl.getProcessingIndicator());
				airCargoManifestControl.setReferenceNumber(vesselScheduleControl.getReferenceNumber());
				airCargoManifestControl.setReceivedControlNumber(vesselScheduleControl.getReceivedControlNumber());
				airCargoManifestControl.setType(0);
				count++;
				
				amanControlDao.insert(airCargoManifestControl);
				
				
			}
			
		}
		return count;
		
	}
}
