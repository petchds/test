package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.MasterStatus;
import com.tti.accscms.domain.movement.MasterStatusExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table mas_status
 */
public interface MasterStatusDao {
    
    public int count() throws DaoException;

    public int deleteByCode(String code) throws DaoException;

    public String insert(MasterStatus masterStatus) throws DaoException;

    public MasterStatus findByCode(String code) throws DaoException;
	
	public int update(MasterStatus masterStatus) throws DaoException;
	
	public int countByMasterStatusExample(MasterStatusExample masterStatusExample) throws DaoException;
	
	public MasterStatus findByMasterStatusExample(MasterStatusExample masterStatusExample) throws DaoException;
	
    public List<MasterStatus> findAllByMasterStatusExample(MasterStatusExample masterStatusExample) throws DaoException;
    
    public List<MasterStatus> findAllByMasterStatusExample(MasterStatusExample masterStatusExample, int limit) throws DaoException;
    
    public List<MasterStatus> findAllByMasterStatusExample(MasterStatusExample masterStatusExample, int offset, int limit) throws DaoException;
}