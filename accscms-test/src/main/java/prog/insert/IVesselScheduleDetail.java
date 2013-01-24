package prog.insert;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.tti.accscms.dao.DaoException;
import com.tti.accscms.domain.manifest.VesselScheduleControl;
import com.tti.accscms.domain.manifest.VesselScheduleDetail;
import com.tti.accscms.mapper.manifest.VesselScheduleControlDaoImpl;
import com.tti.accscms.mapper.manifest.VesselScheduleDetailDaoImpl;

public class IVesselScheduleDetail {
	@Autowired
	public VesselScheduleDetailDaoImpl vsedDetailDao;
	
	@Autowired
	public VesselScheduleControlDaoImpl vsedControlDao;

	private int count = 0;
	
	public int insert(int amount) throws DaoException {
		
		System.out.println("Start Insert IVesselScheduleDetail");
		for (int i = 1; i <= amount; i++) {
			
//			int length = Integer.parseInt(RandomValue.Func1("i"));
//			length = length > 5 ? 1 : 2 ;
//			
			VesselScheduleControl vesselScheduleControl = vsedControlDao.findById(i);
			
			if(vesselScheduleControl!= null)
			for (int j = 1; j <=1 ; j++) {
		
			int Mawb = Integer.parseInt( RandomValue.Func1("iiiiiii"));
			int Hawb = Integer.parseInt(RandomValue.Func1("iiiii"));
			
			VesselScheduleDetail vesselScheduleDetail = new VesselScheduleDetail();
			vesselScheduleDetail.setId(null);
			vesselScheduleDetail.setId2(i);
			vesselScheduleDetail.setReceivedControlNumber(vesselScheduleControl.getReceivedControlNumber());
			vesselScheduleDetail.setMessageFunction(j == 1 ? "Y" : "N");
			vesselScheduleDetail.setNumberOfHawb(Hawb);
			vesselScheduleDetail.setNumberOfMawb(Mawb);
			vesselScheduleDetail.setVsedControlId(vesselScheduleControl.getId());
			
			vesselScheduleDetail.setType(1);
		
			vsedDetailDao.insert(vesselScheduleDetail);
			count++;
			}
		}

		
		System.out.println("End Insert IVesselScheduleDetail");
		
		return count;
	}
	
}
