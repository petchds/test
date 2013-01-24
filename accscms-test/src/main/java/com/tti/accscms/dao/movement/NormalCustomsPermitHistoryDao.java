package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.NormalCustomsPermitHistory;
import com.tti.accscms.domain.movement.NormalCustomsPermitHistoryExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table norm_customs_permit_his
 */
public interface NormalCustomsPermitHistoryDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(NormalCustomsPermitHistory normalCustomsPermitHistory) throws DaoException;

    public NormalCustomsPermitHistory findById(Integer id) throws DaoException;
	
	public int update(NormalCustomsPermitHistory normalCustomsPermitHistory) throws DaoException;
	
	public int countByNormalCustomsPermitHistoryExample(NormalCustomsPermitHistoryExample normalCustomsPermitHistoryExample) throws DaoException;
	
	public NormalCustomsPermitHistory findByNormalCustomsPermitHistoryExample(NormalCustomsPermitHistoryExample normalCustomsPermitHistoryExample) throws DaoException;
	
    public List<NormalCustomsPermitHistory> findAllByNormalCustomsPermitHistoryExample(NormalCustomsPermitHistoryExample normalCustomsPermitHistoryExample) throws DaoException;
    
    public List<NormalCustomsPermitHistory> findAllByNormalCustomsPermitHistoryExample(NormalCustomsPermitHistoryExample normalCustomsPermitHistoryExample, int limit) throws DaoException;
    
    public List<NormalCustomsPermitHistory> findAllByNormalCustomsPermitHistoryExample(NormalCustomsPermitHistoryExample normalCustomsPermitHistoryExample, int offset, int limit) throws DaoException;
}
