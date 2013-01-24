package com.tti.accscms.dao.manifest;

import java.util.List;

import com.tti.accscms.domain.manifest.VesselScheduleControlHistory;
import com.tti.accscms.domain.manifest.VesselScheduleControlHistoryExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table vsed_control_his
 */
public interface VesselScheduleControlHistoryDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(VesselScheduleControlHistory vesselScheduleControlHistory) throws DaoException;

    public VesselScheduleControlHistory findById(Integer id) throws DaoException;
	
	public int update(VesselScheduleControlHistory vesselScheduleControlHistory) throws DaoException;
	
	public int countByVesselScheduleControlHistoryExample(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample) throws DaoException;
	
	public VesselScheduleControlHistory findByVesselScheduleControlHistoryExample(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample) throws DaoException;
	
    public List<VesselScheduleControlHistory> findAllByVesselScheduleControlHistoryExample(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample) throws DaoException;
    
    public List<VesselScheduleControlHistory> findAllByVesselScheduleControlHistoryExample(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample, int limit) throws DaoException;
    
    public List<VesselScheduleControlHistory> findAllByVesselScheduleControlHistoryExample(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample, int offset, int limit) throws DaoException;
}
