package prog.insert;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.tti.accscms.dao.DaoException;
import com.tti.accscms.dao.manifest.AirCargoManifestControlDao;
import com.tti.accscms.domain.manifest.AirCargoManifestControl;
import com.tti.accscms.domain.manifest.AirCargoManifestDetail;
import com.tti.accscms.domain.manifest.VesselScheduleControl;
import com.tti.accscms.domain.manifest.VesselScheduleDetail;
import com.tti.accscms.mapper.manifest.AirCargoManifestControlDaoImpl;
import com.tti.accscms.mapper.manifest.AirCargoManifestDetailDaoImpl;
import com.tti.accscms.mapper.manifest.VesselScheduleControlDaoImpl;
import com.tti.accscms.mapper.manifest.VesselScheduleDetailDaoImpl;

public class IAirCargoManifestDetail {


	@Autowired
	private VesselScheduleControlDaoImpl vsedControlDao ;
	@Autowired
	private VesselScheduleDetailDaoImpl vsedDetailDao;
	@Autowired
	private AirCargoManifestControlDaoImpl amanControlDao ;
	@Autowired
	private AirCargoManifestDetailDaoImpl amanDetailDao;
	private int count = 0;
	public int insert(int amount) throws DaoException {
		
		for (int i = 1; i <= amount; i++) {
			 
		//	VesselScheduleControl vesselScheduleControl = vsedControlDao.findById(i);
		//	VesselScheduleDetail vesselScheduleDetail = vsedDetailDao.findById(vesselScheduleControl.getId());
			AirCargoManifestControl airCargoManifestComtrol = amanControlDao.findById(i);
			
			int length = Integer.parseInt(RandomValue.Func1("i"));
			length = length > 5 ? length : 4 ;
			
			
			
			if(airCargoManifestComtrol!= null)	
			for (int j = 1; j <=length ; j++) {
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)) );
			
				
				AirCargoManifestDetail airCargoManifestDetail = new AirCargoManifestDetail();
				airCargoManifestDetail.setId(null);
				airCargoManifestDetail.setId2(i);
			//	airCargoManifestDetail.setNumberOfHawb();
				airCargoManifestDetail.setReceivedControlNumber(airCargoManifestComtrol.getReceivedControlNumber());
				airCargoManifestDetail.setMawb(RandomValue.Func1("Mawbiiii"));
				airCargoManifestDetail.setNumberOfHawb(Integer.parseInt(RandomValue.Func1("iiiiii")));
				airCargoManifestDetail.setAmanControlId(airCargoManifestComtrol.getId());
				airCargoManifestDetail.setType(airCargoManifestComtrol.getType());
				amanDetailDao.insert(airCargoManifestDetail);
				
				//airCargoManifestDetail.set
				
				count++;
			}
		}
		
		return count;
	}
}
