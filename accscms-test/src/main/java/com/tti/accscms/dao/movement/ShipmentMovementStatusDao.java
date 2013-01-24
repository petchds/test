package com.tti.accscms.dao.movement;

import java.util.List;

import com.tti.accscms.domain.movement.ShipmentMovementStatus;
import com.tti.accscms.domain.movement.ShipmentMovementStatusExample;

import com.tti.accscms.dao.DaoException;

/**
 * This interface was generated by Generator.
 * This interface corresponds to the database table shp_movement_status
 */
public interface ShipmentMovementStatusDao {
    
    public int count() throws DaoException;

    public int deleteById(Integer id) throws DaoException;

    public int insert(ShipmentMovementStatus shipmentMovementStatus) throws DaoException;

    public ShipmentMovementStatus findById(Integer id) throws DaoException;
	
	public int update(ShipmentMovementStatus shipmentMovementStatus) throws DaoException;
	
	public int countByShipmentMovementStatusExample(ShipmentMovementStatusExample shipmentMovementStatusExample) throws DaoException;
	
	public ShipmentMovementStatus findByShipmentMovementStatusExample(ShipmentMovementStatusExample shipmentMovementStatusExample) throws DaoException;
	
    public List<ShipmentMovementStatus> findAllByShipmentMovementStatusExample(ShipmentMovementStatusExample shipmentMovementStatusExample) throws DaoException;
    
    public List<ShipmentMovementStatus> findAllByShipmentMovementStatusExample(ShipmentMovementStatusExample shipmentMovementStatusExample, int limit) throws DaoException;
    
    public List<ShipmentMovementStatus> findAllByShipmentMovementStatusExample(ShipmentMovementStatusExample shipmentMovementStatusExample, int offset, int limit) throws DaoException;
}
