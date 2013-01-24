package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.BlockStatusLog;
import com.tti.accscms.domain.movement.BlockStatusLogExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table block_status_log
 */
public interface BlockStatusLogDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(BlockStatusLog blockStatusLog) throws DaoException;

    public BlockStatusLog findById(Integer id) throws DaoException;
	
	public int update(BlockStatusLog blockStatusLog) throws DaoException;
	
	public int countByBlockStatusLogExample(BlockStatusLogExample blockStatusLogExample) throws DaoException;
	
	public BlockStatusLog findByBlockStatusLogExample(BlockStatusLogExample blockStatusLogExample) throws DaoException;
	
    public List<BlockStatusLog> findAllByBlockStatusLogExample(BlockStatusLogExample blockStatusLogExample) throws DaoException;
    
    public List<BlockStatusLog> findAllByBlockStatusLogExample(BlockStatusLogExample blockStatusLogExample, int limit) throws DaoException;
    
    public List<BlockStatusLog> findAllByBlockStatusLogExample(BlockStatusLogExample blockStatusLogExample, int offset, int limit) throws DaoException;
}