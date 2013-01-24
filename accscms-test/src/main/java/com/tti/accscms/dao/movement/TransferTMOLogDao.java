package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.TransferTMOLog;
import com.tti.accscms.domain.movement.TransferTMOLogExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table transfer_tmo_log
 */
public interface TransferTMOLogDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(TransferTMOLog transferTMOLog) throws DaoException;

    public TransferTMOLog findById(Integer id) throws DaoException;
	
	public int update(TransferTMOLog transferTMOLog) throws DaoException;
	
	public int countByTransferTMOLogExample(TransferTMOLogExample transferTMOLogExample) throws DaoException;
	
	public TransferTMOLog findByTransferTMOLogExample(TransferTMOLogExample transferTMOLogExample) throws DaoException;
	
    public List<TransferTMOLog> findAllByTransferTMOLogExample(TransferTMOLogExample transferTMOLogExample) throws DaoException;
    
    public List<TransferTMOLog> findAllByTransferTMOLogExample(TransferTMOLogExample transferTMOLogExample, int limit) throws DaoException;
    
    public List<TransferTMOLog> findAllByTransferTMOLogExample(TransferTMOLogExample transferTMOLogExample, int offset, int limit) throws DaoException;
}