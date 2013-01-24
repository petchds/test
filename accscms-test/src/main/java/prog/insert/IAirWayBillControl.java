package prog.insert;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.tti.accscms.dao.DaoException;
import com.tti.accscms.dao.manifest.AirCargoManifestControlDao;
import com.tti.accscms.dao.manifest.AirWaybillControlDao;
import com.tti.accscms.domain.manifest.AirCargoManifestControl;
import com.tti.accscms.domain.manifest.AirCargoManifestControlExample;
import com.tti.accscms.domain.manifest.AirCargoManifestDetail;
import com.tti.accscms.domain.manifest.AirWaybillControl;
import com.tti.accscms.domain.manifest.VesselScheduleControl;
import com.tti.accscms.domain.manifest.VesselScheduleDetail;
import com.tti.accscms.mapper.manifest.AirCargoManifestControlDaoImpl;
import com.tti.accscms.mapper.manifest.AirCargoManifestDetailDaoImpl;
import com.tti.accscms.mapper.manifest.AirWaybillControlDaoImpl;
import com.tti.accscms.mapper.manifest.VesselScheduleControlDaoImpl;
import com.tti.accscms.mapper.manifest.VesselScheduleDetailDaoImpl;

public class IAirWayBillControl {

	@Autowired
	private AirWaybillControlDaoImpl abilControlDao;
	@Autowired
	private AirCargoManifestDetailDaoImpl amanDetailDao;
	@Autowired
	private AirCargoManifestControlDaoImpl amanControlDao;
	private int count = 0;
	public int insert(int amount) throws DaoException {
		
		for (int i = 1; i <= amount; i++) {
		
			AirCargoManifestDetail airCargoManifestDetail = amanDetailDao.findById(i);
			 
			AirCargoManifestControlExample airCargoManifestControlExample = new AirCargoManifestControlExample();
			airCargoManifestControlExample.createCriteria().andReceivedControlNumberEqualTo(airCargoManifestDetail.getReceivedControlNumber());
			AirCargoManifestControl airCargoManifestControl = amanControlDao.findByAirCargoManifestControlExample(airCargoManifestControlExample);
			
			int length = Integer.parseInt(RandomValue.Func1("i"));
			length = length > 5 ? length : 4 ;
			
			
			
			if(airCargoManifestDetail!= null)	
			for (int j = 1; j <=length ; j++) {
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
			
				AirWaybillControl airWaybillControl = new AirWaybillControl();
				airWaybillControl.setId(null);
				airWaybillControl.setId2(i);
				airWaybillControl.setMawb(airCargoManifestDetail.getMawb());
				airWaybillControl.setReceivedControlNumber(airCargoManifestDetail.getReceivedControlNumber());
				airWaybillControl.setReferenceNumber(airCargoManifestControl.getReferenceNumber());
				airWaybillControl.setType(Integer.parseInt(RandomValue.Func1("i")));
				
				
				abilControlDao.insert(airWaybillControl);
				
				count++;
			}
		}
		
		return count;
	}
}
