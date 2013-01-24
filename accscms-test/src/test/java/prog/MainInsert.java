package prog;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import prog.insert.IAirCargoManifestControl;
import prog.insert.IAirCargoManifestDetail;
import prog.insert.IAirWayBillControl;
import prog.insert.IAirWayBillDetail;
import prog.insert.IVesselScheduleControl;
import prog.insert.IVesselScheduleDetail;

import com.tti.accscms.dao.DaoException;
import com.tti.accscms.domain.clientmanagement.ShedNo;
import com.tti.accscms.domain.manifest.VesselScheduleControl;
import com.tti.accscms.mapper.clientmanagement.ShedNoDaoImpl;
import com.tti.accscms.mapper.manifest.VesselScheduleControlDaoImpl;
import com.tti.accscms.mapper.manifest.VesselScheduleDetailDaoImpl;

@ContextConfiguration("/beans.xml")
public class MainInsert extends AbstractJUnit4SpringContextTests {
	

	@Autowired
	private IVesselScheduleControl iVesselScheduleControl;
	@Autowired
	private IVesselScheduleDetail iVesselScheduleDetail;
	@Autowired
	private IAirCargoManifestControl iAirCargoManifestControl;
	@Autowired
	private IAirCargoManifestDetail iAirCargoManifestDetail;
	@Autowired
	private IAirWayBillControl iAirWayBillControl;
	@Autowired
	private IAirWayBillDetail iAirWayBillDetail;
	
	
	@Test
	public void RuninsertCloseFlight() throws DaoException {
		
		

	Add_IDNode id2 = new Add_IDNode();
	Delete_Row delete = new Delete_Row();

	
	int Vesselamount = 1;
	
	iAirWayBillDetail.insert(iAirWayBillControl.insert
			(iAirCargoManifestDetail.insert(iAirCargoManifestControl.insert
			(iVesselScheduleDetail.insert(iVesselScheduleControl.insert(Vesselamount)))
	)));
	}
	

}
