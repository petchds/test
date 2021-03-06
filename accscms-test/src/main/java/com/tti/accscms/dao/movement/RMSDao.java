package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.RMS;
import com.tti.accscms.domain.movement.RMSExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table rms
 */
public interface RMSDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(RMS rMS) throws DaoException;

    public RMS findById(Integer id) throws DaoException;
	
	public int update(RMS rMS) throws DaoException;
	
	public int countByRMSExample(RMSExample rMSExample) throws DaoException;
	
	public RMS findByRMSExample(RMSExample rMSExample) throws DaoException;
	
    public List<RMS> findAllByRMSExample(RMSExample rMSExample) throws DaoException;
    
    public List<RMS> findAllByRMSExample(RMSExample rMSExample, int limit) throws DaoException;
    
    public List<RMS> findAllByRMSExample(RMSExample rMSExample, int offset, int limit) throws DaoException;
}
