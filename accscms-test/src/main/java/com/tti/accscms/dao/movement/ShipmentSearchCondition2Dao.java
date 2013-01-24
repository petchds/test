package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.ShipmentSearchCondition2;
import com.tti.accscms.domain.movement.ShipmentSearchCondition2Example;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table shipment_search_condition_2
 */
public interface ShipmentSearchCondition2Dao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(ShipmentSearchCondition2 shipmentSearchCondition2) throws DaoException;

    public ShipmentSearchCondition2 findById(Integer id) throws DaoException;
	
	public int update(ShipmentSearchCondition2 shipmentSearchCondition2) throws DaoException;
	
	public int countByShipmentSearchCondition2Example(ShipmentSearchCondition2Example shipmentSearchCondition2Example) throws DaoException;
	
	public ShipmentSearchCondition2 findByShipmentSearchCondition2Example(ShipmentSearchCondition2Example shipmentSearchCondition2Example) throws DaoException;
	
    public List<ShipmentSearchCondition2> findAllByShipmentSearchCondition2Example(ShipmentSearchCondition2Example shipmentSearchCondition2Example) throws DaoException;
    
    public List<ShipmentSearchCondition2> findAllByShipmentSearchCondition2Example(ShipmentSearchCondition2Example shipmentSearchCondition2Example, int limit) throws DaoException;
    
    public List<ShipmentSearchCondition2> findAllByShipmentSearchCondition2Example(ShipmentSearchCondition2Example shipmentSearchCondition2Example, int offset, int limit) throws DaoException;
}