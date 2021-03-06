package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.ChangeAirportLog;
import com.tti.accscms.domain.movement.ChangeAirportLogExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table change_airport_log
 */
public interface ChangeAirportLogDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(ChangeAirportLog changeAirportLog) throws DaoException;

    public ChangeAirportLog findById(Integer id) throws DaoException;
	
	public int update(ChangeAirportLog changeAirportLog) throws DaoException;
	
	public int countByChangeAirportLogExample(ChangeAirportLogExample changeAirportLogExample) throws DaoException;
	
	public ChangeAirportLog findByChangeAirportLogExample(ChangeAirportLogExample changeAirportLogExample) throws DaoException;
	
    public List<ChangeAirportLog> findAllByChangeAirportLogExample(ChangeAirportLogExample changeAirportLogExample) throws DaoException;
    
    public List<ChangeAirportLog> findAllByChangeAirportLogExample(ChangeAirportLogExample changeAirportLogExample, int limit) throws DaoException;
    
    public List<ChangeAirportLog> findAllByChangeAirportLogExample(ChangeAirportLogExample changeAirportLogExample, int offset, int limit) throws DaoException;
}
