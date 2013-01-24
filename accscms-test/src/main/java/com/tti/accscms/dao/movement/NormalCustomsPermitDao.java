package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.NormalCustomsPermit;
import com.tti.accscms.domain.movement.NormalCustomsPermitExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table norm_customs_permit
 */
public interface NormalCustomsPermitDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(NormalCustomsPermit normalCustomsPermit) throws DaoException;

    public NormalCustomsPermit findById(Integer id) throws DaoException;
	
	public int update(NormalCustomsPermit normalCustomsPermit) throws DaoException;
	
	public int countByNormalCustomsPermitExample(NormalCustomsPermitExample normalCustomsPermitExample) throws DaoException;
	
	public NormalCustomsPermit findByNormalCustomsPermitExample(NormalCustomsPermitExample normalCustomsPermitExample) throws DaoException;
	
    public List<NormalCustomsPermit> findAllByNormalCustomsPermitExample(NormalCustomsPermitExample normalCustomsPermitExample) throws DaoException;
    
    public List<NormalCustomsPermit> findAllByNormalCustomsPermitExample(NormalCustomsPermitExample normalCustomsPermitExample, int limit) throws DaoException;
    
    public List<NormalCustomsPermit> findAllByNormalCustomsPermitExample(NormalCustomsPermitExample normalCustomsPermitExample, int offset, int limit) throws DaoException;
}
