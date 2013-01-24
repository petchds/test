package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.GoodsTransitionHistory;
import com.tti.accscms.domain.movement.GoodsTransitionHistoryExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table goods_transition_his
 */
public interface GoodsTransitionHistoryDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(GoodsTransitionHistory goodsTransitionHistory) throws DaoException;

    public GoodsTransitionHistory findById(Integer id) throws DaoException;
	
	public int update(GoodsTransitionHistory goodsTransitionHistory) throws DaoException;
	
	public int countByGoodsTransitionHistoryExample(GoodsTransitionHistoryExample goodsTransitionHistoryExample) throws DaoException;
	
	public GoodsTransitionHistory findByGoodsTransitionHistoryExample(GoodsTransitionHistoryExample goodsTransitionHistoryExample) throws DaoException;
	
    public List<GoodsTransitionHistory> findAllByGoodsTransitionHistoryExample(GoodsTransitionHistoryExample goodsTransitionHistoryExample) throws DaoException;
    
    public List<GoodsTransitionHistory> findAllByGoodsTransitionHistoryExample(GoodsTransitionHistoryExample goodsTransitionHistoryExample, int limit) throws DaoException;
    
    public List<GoodsTransitionHistory> findAllByGoodsTransitionHistoryExample(GoodsTransitionHistoryExample goodsTransitionHistoryExample, int offset, int limit) throws DaoException;
}