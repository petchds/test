package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.ShipmentMovementStatusHistory;
import com.tti.accscms.domain.movement.ShipmentMovementStatusHistoryExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table shp_movement_status_his
 */
public interface ShipmentMovementStatusHistoryDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(ShipmentMovementStatusHistory shipmentMovementStatusHistory) throws DaoException;

    public ShipmentMovementStatusHistory findById(Integer id) throws DaoException;
	
	public int update(ShipmentMovementStatusHistory shipmentMovementStatusHistory) throws DaoException;
	
	public int countByShipmentMovementStatusHistoryExample(ShipmentMovementStatusHistoryExample shipmentMovementStatusHistoryExample) throws DaoException;
	
	public ShipmentMovementStatusHistory findByShipmentMovementStatusHistoryExample(ShipmentMovementStatusHistoryExample shipmentMovementStatusHistoryExample) throws DaoException;
	
    public List<ShipmentMovementStatusHistory> findAllByShipmentMovementStatusHistoryExample(ShipmentMovementStatusHistoryExample shipmentMovementStatusHistoryExample) throws DaoException;
    
    public List<ShipmentMovementStatusHistory> findAllByShipmentMovementStatusHistoryExample(ShipmentMovementStatusHistoryExample shipmentMovementStatusHistoryExample, int limit) throws DaoException;
    
    public List<ShipmentMovementStatusHistory> findAllByShipmentMovementStatusHistoryExample(ShipmentMovementStatusHistoryExample shipmentMovementStatusHistoryExample, int offset, int limit) throws DaoException;
}