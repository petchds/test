package prog.insert;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.tti.accscms.dao.DaoException;
import com.tti.accscms.dao.manifest.AirWaybillDetailDao;
import com.tti.accscms.domain.manifest.AirWaybillControl;
import com.tti.accscms.domain.manifest.AirWaybillDetail;
import com.tti.accscms.mapper.manifest.AirWaybillControlDaoImpl;

public class IAirWayBillDetail {

	@Autowired
	private AirWaybillDetailDao abilDetailDao;
	@Autowired
	private AirWaybillControlDaoImpl abilControlDao;
	
	private int count = 0;
	public int insert(int amount) throws DaoException {
		
		for (int i = 1; i <= amount; i++) {
		
			AirWaybillControl airWaybillControl = abilControlDao.findById(i);
			
			int length = Integer.parseInt(RandomValue.Func1("i"));
			length = length > 5 ? length : 4 ;
			
			
			
			if(airWaybillControl!= null)	
			for (int j = 1; j <=length ; j++) {
				Date current = Calendar.getInstance().getTime();
				Date oldDate = new Date(current.getTime() - (int)((Math.random()*1000)  *(Math.random()*100)  *(Math.random()*1000)*(Math.random()*1000)));
			
				AirWaybillDetail airWaybillDetail = new AirWaybillDetail();
				airWaybillDetail.setId(null);
				airWaybillDetail.setId2(i);
				airWaybillDetail.setAbilControlId(airWaybillControl.getId());
				airWaybillDetail.setType(airWaybillControl.getType());
	
				
				abilDetailDao.insert(airWaybillDetail);
				
				count++;
			}
		}
		
		return count;
	}
}
