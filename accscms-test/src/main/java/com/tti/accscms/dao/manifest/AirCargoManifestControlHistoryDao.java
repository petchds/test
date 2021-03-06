package com.tti.accscms.dao.manifest;

import java.util.List;

import com.tti.accscms.domain.manifest.AirCargoManifestControlHistory;
import com.tti.accscms.domain.manifest.AirCargoManifestControlHistoryExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table aman_control_his
 */
public interface AirCargoManifestControlHistoryDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(AirCargoManifestControlHistory airCargoManifestControlHistory) throws DaoException;

    public AirCargoManifestControlHistory findById(Integer id) throws DaoException;
	
	public int update(AirCargoManifestControlHistory airCargoManifestControlHistory) throws DaoException;
	
	public int countByAirCargoManifestControlHistoryExample(AirCargoManifestControlHistoryExample airCargoManifestControlHistoryExample) throws DaoException;
	
	public AirCargoManifestControlHistory findByAirCargoManifestControlHistoryExample(AirCargoManifestControlHistoryExample airCargoManifestControlHistoryExample) throws DaoException;
	
    public List<AirCargoManifestControlHistory> findAllByAirCargoManifestControlHistoryExample(AirCargoManifestControlHistoryExample airCargoManifestControlHistoryExample) throws DaoException;
    
    public List<AirCargoManifestControlHistory> findAllByAirCargoManifestControlHistoryExample(AirCargoManifestControlHistoryExample airCargoManifestControlHistoryExample, int limit) throws DaoException;
    
    public List<AirCargoManifestControlHistory> findAllByAirCargoManifestControlHistoryExample(AirCargoManifestControlHistoryExample airCargoManifestControlHistoryExample, int offset, int limit) throws DaoException;
}
