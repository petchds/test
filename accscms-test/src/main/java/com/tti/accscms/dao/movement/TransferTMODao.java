package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.TransferTMO;
import com.tti.accscms.domain.movement.TransferTMOExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table transfer_tmo
 */
public interface TransferTMODao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(TransferTMO transferTMO) throws DaoException;

    public TransferTMO findById(Integer id) throws DaoException;
	
	public int update(TransferTMO transferTMO) throws DaoException;
	
	public int countByTransferTMOExample(TransferTMOExample transferTMOExample) throws DaoException;
	
	public TransferTMO findByTransferTMOExample(TransferTMOExample transferTMOExample) throws DaoException;
	
    public List<TransferTMO> findAllByTransferTMOExample(TransferTMOExample transferTMOExample) throws DaoException;
    
    public List<TransferTMO> findAllByTransferTMOExample(TransferTMOExample transferTMOExample, int limit) throws DaoException;
    
    public List<TransferTMO> findAllByTransferTMOExample(TransferTMOExample transferTMOExample, int offset, int limit) throws DaoException;
}