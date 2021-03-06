package com.tti.accscms.mapper.manifest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.tti.accscms.dao.DaoException;
import com.tti.accscms.dao.manifest.VesselScheduleControlDao;

import com.tti.accscms.domain.manifest.VesselScheduleControl;
import com.tti.accscms.domain.manifest.VesselScheduleControlExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table vsed_control
 */
public class VesselScheduleControlDaoImpl implements VesselScheduleControlDao {

	private static final Logger logger = LoggerFactory.getLogger(VesselScheduleControlDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, VesselScheduleControl vesselScheduleControl) throws SQLException {
		
		if (vesselScheduleControl.getId() != null) {
			ps.setInt(1, vesselScheduleControl.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (vesselScheduleControl.getId2() != null) {
			ps.setInt(2, vesselScheduleControl.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (vesselScheduleControl.getReferenceNumber() != null) {
			ps.setString(3, vesselScheduleControl.getReferenceNumber());
		} else {
			ps.setNull(3, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getReceivedControlNumber() != null) {
			ps.setString(4, vesselScheduleControl.getReceivedControlNumber());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getModeOfTransport() != null) {
			ps.setString(5, vesselScheduleControl.getModeOfTransport());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getProcessingIndicator() != null) {
			ps.setString(6, vesselScheduleControl.getProcessingIndicator());
		} else {
			ps.setNull(6, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getTypeOfTransport() != null) {
			ps.setString(7, vesselScheduleControl.getTypeOfTransport());
		} else {
			ps.setNull(7, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getShipAgentTaxNumber() != null) {
			ps.setString(8, vesselScheduleControl.getShipAgentTaxNumber());
		} else {
			ps.setNull(8, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getShipAgentBranch() != null) {
			ps.setInt(9, vesselScheduleControl.getShipAgentBranch());
		} else {
			ps.setNull(9, java.sql.Types.INTEGER);
		}

		if (vesselScheduleControl.getCallsign() != null) {
			ps.setString(10, vesselScheduleControl.getCallsign());
		} else {
			ps.setNull(10, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getVesselName() != null) {
			ps.setString(11, vesselScheduleControl.getVesselName());
		} else {
			ps.setNull(11, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getMasterName() != null) {
			ps.setString(12, vesselScheduleControl.getMasterName());
		} else {
			ps.setNull(12, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getPreviousFlightNo() != null) {
			ps.setString(13, vesselScheduleControl.getPreviousFlightNo());
		} else {
			ps.setNull(13, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getPreviousDate() != null) {
			ps.setTimestamp(14, new java.sql.Timestamp(vesselScheduleControl.getPreviousDate().getTime()));
		} else {
			ps.setNull(14, java.sql.Types.DATE);
		}

		if (vesselScheduleControl.getNationality() != null) {
			ps.setString(15, vesselScheduleControl.getNationality());
		} else {
			ps.setNull(15, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getNetRegisterTonnage() != null) {
			ps.setDouble(16, vesselScheduleControl.getNetRegisterTonnage());
		} else {
			ps.setNull(16, java.sql.Types.DOUBLE);
		}

		if (vesselScheduleControl.getGrossRegisterTonnage() != null) {
			ps.setDouble(17, vesselScheduleControl.getGrossRegisterTonnage());
		} else {
			ps.setNull(17, java.sql.Types.DOUBLE);
		}

		if (vesselScheduleControl.getDeadWeightTonnage() != null) {
			ps.setDouble(18, vesselScheduleControl.getDeadWeightTonnage());
		} else {
			ps.setNull(18, java.sql.Types.DOUBLE);
		}

		if (vesselScheduleControl.getRegistrationId() != null) {
			ps.setString(19, vesselScheduleControl.getRegistrationId());
		} else {
			ps.setNull(19, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControl.getModifiedDateTime() != null) {
			ps.setTimestamp(20, new java.sql.Timestamp(vesselScheduleControl.getModifiedDateTime().getTime()));
		} else {
			ps.setTimestamp(20, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (vesselScheduleControl.getType() != null) {
			ps.setInt(21, vesselScheduleControl.getType());
		} else {
			ps.setNull(21, java.sql.Types.INTEGER);
		}

	}

		
	private static VesselScheduleControl createInstanceFromResultSet(ResultSet rs) throws SQLException {
		VesselScheduleControl vesselScheduleControl = new VesselScheduleControl();
		
		Integer col1 = rs.getInt("id");
		vesselScheduleControl.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		vesselScheduleControl.setId2(rs.wasNull() ? null : col2);

		String col3 = rs.getString("reference_number");
		vesselScheduleControl.setReferenceNumber(rs.wasNull() ? null : col3);

		String col4 = rs.getString("received_control_number");
		vesselScheduleControl.setReceivedControlNumber(rs.wasNull() ? null : col4);

		String col5 = rs.getString("mode_of_transport");
		vesselScheduleControl.setModeOfTransport(rs.wasNull() ? null : col5);

		String col6 = rs.getString("processing_indicator");
		vesselScheduleControl.setProcessingIndicator(rs.wasNull() ? null : col6);

		String col7 = rs.getString("type_of_transport");
		vesselScheduleControl.setTypeOfTransport(rs.wasNull() ? null : col7);

		String col8 = rs.getString("ship_agent_tax_number");
		vesselScheduleControl.setShipAgentTaxNumber(rs.wasNull() ? null : col8);

		Integer col9 = rs.getInt("ship_agent_branch");
		vesselScheduleControl.setShipAgentBranch(rs.wasNull() ? null : col9);

		String col10 = rs.getString("callsign");
		vesselScheduleControl.setCallsign(rs.wasNull() ? null : col10);

		String col11 = rs.getString("vessel_name");
		vesselScheduleControl.setVesselName(rs.wasNull() ? null : col11);

		String col12 = rs.getString("master_name");
		vesselScheduleControl.setMasterName(rs.wasNull() ? null : col12);

		String col13 = rs.getString("previous_flight_no");
		vesselScheduleControl.setPreviousFlightNo(rs.wasNull() ? null : col13);

		java.sql.Timestamp col14 = rs.getTimestamp("previous_date");
		vesselScheduleControl.setPreviousDate(rs.wasNull() ? null : new java.util.Date(col14.getTime()));

		String col15 = rs.getString("nationality");
		vesselScheduleControl.setNationality(rs.wasNull() ? null : col15);

		Double col16 = rs.getDouble("net_register_tonnage");
		vesselScheduleControl.setNetRegisterTonnage(rs.wasNull() ? null : col16);

		Double col17 = rs.getDouble("gross_register_tonnage");
		vesselScheduleControl.setGrossRegisterTonnage(rs.wasNull() ? null : col17);

		Double col18 = rs.getDouble("dead_weight_tonnage");
		vesselScheduleControl.setDeadWeightTonnage(rs.wasNull() ? null : col18);

		String col19 = rs.getString("registration_id");
		vesselScheduleControl.setRegistrationId(rs.wasNull() ? null : col19);

		java.sql.Timestamp col20 = rs.getTimestamp("modified_date_time");
		vesselScheduleControl.setModifiedDateTime(rs.wasNull() ? null : new java.util.Date(col20.getTime()));

		Integer col21 = rs.getInt("type");
		vesselScheduleControl.setType(rs.wasNull() ? null : col21);


		return vesselScheduleControl;
	}  

		
	@Override
	public int insert(VesselScheduleControl vesselScheduleControl) throws DaoException {
		if (vesselScheduleControl == null) {
			throw new DaoException("Cannot insert vsed_control with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into vsed_control(`id`,`id2`,`reference_number`,`received_control_number`,`mode_of_transport`,`processing_indicator`,`type_of_transport`,`ship_agent_tax_number`,`ship_agent_branch`,`callsign`,`vessel_name`,`master_name`,`previous_flight_no`,`previous_date`,`nationality`,`net_register_tonnage`,`gross_register_tonnage`,`dead_weight_tonnage`,`registration_id`,`modified_date_time`,`type`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            VesselScheduleControlDaoImpl.setPreparedStatementValues(ps, vesselScheduleControl);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT vsed_control[id=" + id + "]");

			return id;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int count() throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select count(*) from vsed_control");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT vsed_control => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public VesselScheduleControl findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`reference_number`,`received_control_number`,`mode_of_transport`,`processing_indicator`,`type_of_transport`,`ship_agent_tax_number`,`ship_agent_branch`,`callsign`,`vessel_name`,`master_name`,`previous_flight_no`,`previous_date`,`nationality`,`net_register_tonnage`,`gross_register_tonnage`,`dead_weight_tonnage`,`registration_id`,`modified_date_time`,`type` from vsed_control where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND vsed_control[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            VesselScheduleControl instance = null;
            if (rs.next()) {
                instance = VesselScheduleControlDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(VesselScheduleControl vesselScheduleControl) throws DaoException {
		if (vesselScheduleControl == null) {
			throw new DaoException("Cannot insert vsed_control with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update vsed_control set `id`=?,`id2`=?,`reference_number`=?,`received_control_number`=?,`mode_of_transport`=?,`processing_indicator`=?,`type_of_transport`=?,`ship_agent_tax_number`=?,`ship_agent_branch`=?,`callsign`=?,`vessel_name`=?,`master_name`=?,`previous_flight_no`=?,`previous_date`=?,`nationality`=?,`net_register_tonnage`=?,`gross_register_tonnage`=?,`dead_weight_tonnage`=?,`registration_id`=?,`modified_date_time`=?,`type`=? where id=?");
            VesselScheduleControlDaoImpl.setPreparedStatementValues(ps, vesselScheduleControl);
            ps.setInt(22, vesselScheduleControl.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE vsed_control[id=" + vesselScheduleControl.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from vsed_control where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE vsed_control[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(VesselScheduleControlExample vesselScheduleControlExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (VesselScheduleControlExample.Criteria criteria : vesselScheduleControlExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (VesselScheduleControlExample.Criterion criterion : criteria.getAllCriteria()) {
					if (first) {
						first = false;
					} else {
						builder.append(" and ");
					}
					
					if (criterion.isNoValue()) {
						builder.append(criterion.getCondition());
					} else if (criterion.isSingleValue()) {
						builder.append(criterion.getCondition());
						builder.append(' ');
						builder.append("'");
						if (criterion.getValue() instanceof java.util.Date) {
							builder.append(dateFormat.format(criterion.getValue()));
						} else {
							builder.append(criterion.getValue().toString().replace("'", "\'"));
						}
						builder.append("'");
					} else if (criterion.isBetweenValue()) {
						builder.append(criterion.getCondition());
						builder.append(' ');
						
						builder.append("'");
						if (criterion.getValue() instanceof java.util.Date) {
							builder.append(dateFormat.format(criterion.getValue()));
						} else {
							builder.append(criterion.getValue().toString().replace("'", "\'"));
						}
						builder.append("'");
						
						builder.append(" and ");
						builder.append("'");
						if (criterion.getSecondValue() instanceof java.util.Date) {
							builder.append(dateFormat.format(criterion.getSecondValue()));
						} else {
							builder.append(criterion.getSecondValue().toString().replace("'", "\'"));
						}
						builder.append("'");
					} else if (criterion.isListValue()) {
						builder.append(criterion.getCondition());
						builder.append('(');
						List<?> items = (List<?>) criterion.getValue();
						boolean firstC = true;
						for (Object item : items) {
							if (firstC) {
								firstC = false;
							} else {
								builder.append(", ");
							}
							builder.append("'");
							if (item instanceof java.util.Date) {
								builder.append(dateFormat.format(item));
							} else {
								builder.append(item.toString().replace("'", "\'"));
							}
							builder.append("'");
						}
						builder.append(')');
					}
				}
				builder.append(')');
			}
		}
		
		String clause = firstO ? "" : " where " + builder.toString();
		
		if (vesselScheduleControlExample.getOrderByClause() != null && !vesselScheduleControlExample.getOrderByClause().isEmpty()) {
			clause += " order by " + vesselScheduleControlExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByVesselScheduleControlExample(VesselScheduleControlExample vesselScheduleControlExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = VesselScheduleControlDaoImpl.buildClause(vesselScheduleControlExample);			
            ResultSet rs = stmt.executeQuery("select" + (vesselScheduleControlExample.isDistinct() ? " distinct " : " ") + "count(*) from vsed_control" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT vsed_control[distinct=" + vesselScheduleControlExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public VesselScheduleControl findByVesselScheduleControlExample(VesselScheduleControlExample vesselScheduleControlExample) throws DaoException {
		List<VesselScheduleControl> res = this.findAllByVesselScheduleControlExample(vesselScheduleControlExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<VesselScheduleControl> findAllByVesselScheduleControlExample(VesselScheduleControlExample vesselScheduleControlExample) throws DaoException {
    	return this.findAllByVesselScheduleControlExample(vesselScheduleControlExample, 0, 2000);
    }
    
    @Override
    public List<VesselScheduleControl> findAllByVesselScheduleControlExample(VesselScheduleControlExample vesselScheduleControlExample, int limit) throws DaoException {
    	return this.findAllByVesselScheduleControlExample(vesselScheduleControlExample, 0, limit);
    }
    
    @Override
    public List<VesselScheduleControl> findAllByVesselScheduleControlExample(VesselScheduleControlExample vesselScheduleControlExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = VesselScheduleControlDaoImpl.buildClause(vesselScheduleControlExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND vsed_control[distinct=" + vesselScheduleControlExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (vesselScheduleControlExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`reference_number`,`received_control_number`,`mode_of_transport`,`processing_indicator`,`type_of_transport`,`ship_agent_tax_number`,`ship_agent_branch`,`callsign`,`vessel_name`,`master_name`,`previous_flight_no`,`previous_date`,`nationality`,`net_register_tonnage`,`gross_register_tonnage`,`dead_weight_tonnage`,`registration_id`,`modified_date_time`,`type` from vsed_control" + clause);

            List<VesselScheduleControl> list = new ArrayList<VesselScheduleControl>();
            while (rs.next()) {
                list.add(VesselScheduleControlDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
