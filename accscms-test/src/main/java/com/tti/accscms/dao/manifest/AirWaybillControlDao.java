package com.tti.accscms.dao.manifest;

import java.util.List;

import com.tti.accscms.domain.manifest.AirWaybillControl;
import com.tti.accscms.domain.manifest.AirWaybillControlExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table abil_control
 */
public interface AirWaybillControlDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(AirWaybillControl airWaybillControl) throws DaoException;

    public AirWaybillControl findById(Integer id) throws DaoException;
	
	public int update(AirWaybillControl airWaybillControl) throws DaoException;
	
	public int countByAirWaybillControlExample(AirWaybillControlExample airWaybillControlExample) throws DaoException;
	
	public AirWaybillControl findByAirWaybillControlExample(AirWaybillControlExample airWaybillControlExample) throws DaoException;
	
    public List<AirWaybillControl> findAllByAirWaybillControlExample(AirWaybillControlExample airWaybillControlExample) throws DaoException;
    
    public List<AirWaybillControl> findAllByAirWaybillControlExample(AirWaybillControlExample airWaybillControlExample, int limit) throws DaoException;
    
    public List<AirWaybillControl> findAllByAirWaybillControlExample(AirWaybillControlExample airWaybillControlExample, int offset, int limit) throws DaoException;
}