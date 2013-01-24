package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.ExpressCustomsPermitDetailHistory;
import com.tti.accscms.domain.movement.ExpressCustomsPermitDetailHistoryExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table exp_customs_permit_detail_his
 */
public interface ExpressCustomsPermitDetailHistoryDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(ExpressCustomsPermitDetailHistory expressCustomsPermitDetailHistory) throws DaoException;

    public ExpressCustomsPermitDetailHistory findById(Integer id) throws DaoException;
	
	public int update(ExpressCustomsPermitDetailHistory expressCustomsPermitDetailHistory) throws DaoException;
	
	public int countByExpressCustomsPermitDetailHistoryExample(ExpressCustomsPermitDetailHistoryExample expressCustomsPermitDetailHistoryExample) throws DaoException;
	
	public ExpressCustomsPermitDetailHistory findByExpressCustomsPermitDetailHistoryExample(ExpressCustomsPermitDetailHistoryExample expressCustomsPermitDetailHistoryExample) throws DaoException;
	
    public List<ExpressCustomsPermitDetailHistory> findAllByExpressCustomsPermitDetailHistoryExample(ExpressCustomsPermitDetailHistoryExample expressCustomsPermitDetailHistoryExample) throws DaoException;
    
    public List<ExpressCustomsPermitDetailHistory> findAllByExpressCustomsPermitDetailHistoryExample(ExpressCustomsPermitDetailHistoryExample expressCustomsPermitDetailHistoryExample, int limit) throws DaoException;
    
    public List<ExpressCustomsPermitDetailHistory> findAllByExpressCustomsPermitDetailHistoryExample(ExpressCustomsPermitDetailHistoryExample expressCustomsPermitDetailHistoryExample, int offset, int limit) throws DaoException;
}
