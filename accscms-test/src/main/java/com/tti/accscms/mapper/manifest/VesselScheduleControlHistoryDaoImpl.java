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
import com.tti.accscms.dao.manifest.VesselScheduleControlHistoryDao;

import com.tti.accscms.domain.manifest.VesselScheduleControlHistory;
import com.tti.accscms.domain.manifest.VesselScheduleControlHistoryExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table vsed_control_his
 */
public class VesselScheduleControlHistoryDaoImpl implements VesselScheduleControlHistoryDao {

	private static final Logger logger = LoggerFactory.getLogger(VesselScheduleControlHistoryDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, VesselScheduleControlHistory vesselScheduleControlHistory) throws SQLException {
		
		if (vesselScheduleControlHistory.getId() != null) {
			ps.setInt(1, vesselScheduleControlHistory.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (vesselScheduleControlHistory.getId2() != null) {
			ps.setInt(2, vesselScheduleControlHistory.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (vesselScheduleControlHistory.getVsedControlId() != null) {
			ps.setInt(3, vesselScheduleControlHistory.getVsedControlId());
		} else {
			ps.setNull(3, java.sql.Types.INTEGER);
		}

		if (vesselScheduleControlHistory.getReferenceNumber() != null) {
			ps.setString(4, vesselScheduleControlHistory.getReferenceNumber());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getReceivedControlNumber() != null) {
			ps.setString(5, vesselScheduleControlHistory.getReceivedControlNumber());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getModeOfTransport() != null) {
			ps.setString(6, vesselScheduleControlHistory.getModeOfTransport());
		} else {
			ps.setNull(6, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getProcessingIndicator() != null) {
			ps.setString(7, vesselScheduleControlHistory.getProcessingIndicator());
		} else {
			ps.setNull(7, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getTypeOfTransport() != null) {
			ps.setString(8, vesselScheduleControlHistory.getTypeOfTransport());
		} else {
			ps.setNull(8, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getShipAgentTaxNumber() != null) {
			ps.setString(9, vesselScheduleControlHistory.getShipAgentTaxNumber());
		} else {
			ps.setNull(9, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getShipAgentBranch() != null) {
			ps.setInt(10, vesselScheduleControlHistory.getShipAgentBranch());
		} else {
			ps.setNull(10, java.sql.Types.INTEGER);
		}

		if (vesselScheduleControlHistory.getCallsign() != null) {
			ps.setString(11, vesselScheduleControlHistory.getCallsign());
		} else {
			ps.setNull(11, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getVesselName() != null) {
			ps.setString(12, vesselScheduleControlHistory.getVesselName());
		} else {
			ps.setNull(12, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getMasterName() != null) {
			ps.setString(13, vesselScheduleControlHistory.getMasterName());
		} else {
			ps.setNull(13, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getPreviousFlightNo() != null) {
			ps.setString(14, vesselScheduleControlHistory.getPreviousFlightNo());
		} else {
			ps.setNull(14, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getPreviousDate() != null) {
			ps.setTimestamp(15, new java.sql.Timestamp(vesselScheduleControlHistory.getPreviousDate().getTime()));
		} else {
			ps.setNull(15, java.sql.Types.DATE);
		}

		if (vesselScheduleControlHistory.getNationality() != null) {
			ps.setString(16, vesselScheduleControlHistory.getNationality());
		} else {
			ps.setNull(16, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getNetRegisterTonnage() != null) {
			ps.setDouble(17, vesselScheduleControlHistory.getNetRegisterTonnage());
		} else {
			ps.setNull(17, java.sql.Types.DOUBLE);
		}

		if (vesselScheduleControlHistory.getGrossRegisterTonnage() != null) {
			ps.setDouble(18, vesselScheduleControlHistory.getGrossRegisterTonnage());
		} else {
			ps.setNull(18, java.sql.Types.DOUBLE);
		}

		if (vesselScheduleControlHistory.getDeadWeightTonnage() != null) {
			ps.setDouble(19, vesselScheduleControlHistory.getDeadWeightTonnage());
		} else {
			ps.setNull(19, java.sql.Types.DOUBLE);
		}

		if (vesselScheduleControlHistory.getRegistrationId() != null) {
			ps.setString(20, vesselScheduleControlHistory.getRegistrationId());
		} else {
			ps.setNull(20, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleControlHistory.getModifiedDateTime() != null) {
			ps.setTimestamp(21, new java.sql.Timestamp(vesselScheduleControlHistory.getModifiedDateTime().getTime()));
		} else {
			ps.setTimestamp(21, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (vesselScheduleControlHistory.getType() != null) {
			ps.setInt(22, vesselScheduleControlHistory.getType());
		} else {
			ps.setNull(22, java.sql.Types.INTEGER);
		}

	}

		
	private static VesselScheduleControlHistory createInstanceFromResultSet(ResultSet rs) throws SQLException {
		VesselScheduleControlHistory vesselScheduleControlHistory = new VesselScheduleControlHistory();
		
		Integer col1 = rs.getInt("id");
		vesselScheduleControlHistory.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		vesselScheduleControlHistory.setId2(rs.wasNull() ? null : col2);

		Integer col3 = rs.getInt("vsed_control_id");
		vesselScheduleControlHistory.setVsedControlId(rs.wasNull() ? null : col3);

		String col4 = rs.getString("reference_number");
		vesselScheduleControlHistory.setReferenceNumber(rs.wasNull() ? null : col4);

		String col5 = rs.getString("received_control_number");
		vesselScheduleControlHistory.setReceivedControlNumber(rs.wasNull() ? null : col5);

		String col6 = rs.getString("mode_of_transport");
		vesselScheduleControlHistory.setModeOfTransport(rs.wasNull() ? null : col6);

		String col7 = rs.getString("processing_indicator");
		vesselScheduleControlHistory.setProcessingIndicator(rs.wasNull() ? null : col7);

		String col8 = rs.getString("type_of_transport");
		vesselScheduleControlHistory.setTypeOfTransport(rs.wasNull() ? null : col8);

		String col9 = rs.getString("ship_agent_tax_number");
		vesselScheduleControlHistory.setShipAgentTaxNumber(rs.wasNull() ? null : col9);

		Integer col10 = rs.getInt("ship_agent_branch");
		vesselScheduleControlHistory.setShipAgentBranch(rs.wasNull() ? null : col10);

		String col11 = rs.getString("callsign");
		vesselScheduleControlHistory.setCallsign(rs.wasNull() ? null : col11);

		String col12 = rs.getString("vessel_name");
		vesselScheduleControlHistory.setVesselName(rs.wasNull() ? null : col12);

		String col13 = rs.getString("master_name");
		vesselScheduleControlHistory.setMasterName(rs.wasNull() ? null : col13);

		String col14 = rs.getString("previous_flight_no");
		vesselScheduleControlHistory.setPreviousFlightNo(rs.wasNull() ? null : col14);

		java.sql.Timestamp col15 = rs.getTimestamp("previous_date");
		vesselScheduleControlHistory.setPreviousDate(rs.wasNull() ? null : new java.util.Date(col15.getTime()));

		String col16 = rs.getString("nationality");
		vesselScheduleControlHistory.setNationality(rs.wasNull() ? null : col16);

		Double col17 = rs.getDouble("net_register_tonnage");
		vesselScheduleControlHistory.setNetRegisterTonnage(rs.wasNull() ? null : col17);

		Double col18 = rs.getDouble("gross_register_tonnage");
		vesselScheduleControlHistory.setGrossRegisterTonnage(rs.wasNull() ? null : col18);

		Double col19 = rs.getDouble("dead_weight_tonnage");
		vesselScheduleControlHistory.setDeadWeightTonnage(rs.wasNull() ? null : col19);

		String col20 = rs.getString("registration_id");
		vesselScheduleControlHistory.setRegistrationId(rs.wasNull() ? null : col20);

		java.sql.Timestamp col21 = rs.getTimestamp("modified_date_time");
		vesselScheduleControlHistory.setModifiedDateTime(rs.wasNull() ? null : new java.util.Date(col21.getTime()));

		Integer col22 = rs.getInt("type");
		vesselScheduleControlHistory.setType(rs.wasNull() ? null : col22);


		return vesselScheduleControlHistory;
	}  

		
	@Override
	public int insert(VesselScheduleControlHistory vesselScheduleControlHistory) throws DaoException {
		if (vesselScheduleControlHistory == null) {
			throw new DaoException("Cannot insert vsed_control_his with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into vsed_control_his(`id`,`id2`,`vsed_control_id`,`reference_number`,`received_control_number`,`mode_of_transport`,`processing_indicator`,`type_of_transport`,`ship_agent_tax_number`,`ship_agent_branch`,`callsign`,`vessel_name`,`master_name`,`previous_flight_no`,`previous_date`,`nationality`,`net_register_tonnage`,`gross_register_tonnage`,`dead_weight_tonnage`,`registration_id`,`modified_date_time`,`type`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            VesselScheduleControlHistoryDaoImpl.setPreparedStatementValues(ps, vesselScheduleControlHistory);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT vsed_control_his[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from vsed_control_his");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT vsed_control_his => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public VesselScheduleControlHistory findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`vsed_control_id`,`reference_number`,`received_control_number`,`mode_of_transport`,`processing_indicator`,`type_of_transport`,`ship_agent_tax_number`,`ship_agent_branch`,`callsign`,`vessel_name`,`master_name`,`previous_flight_no`,`previous_date`,`nationality`,`net_register_tonnage`,`gross_register_tonnage`,`dead_weight_tonnage`,`registration_id`,`modified_date_time`,`type` from vsed_control_his where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND vsed_control_his[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            VesselScheduleControlHistory instance = null;
            if (rs.next()) {
                instance = VesselScheduleControlHistoryDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(VesselScheduleControlHistory vesselScheduleControlHistory) throws DaoException {
		if (vesselScheduleControlHistory == null) {
			throw new DaoException("Cannot insert vsed_control_his with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update vsed_control_his set `id`=?,`id2`=?,`vsed_control_id`=?,`reference_number`=?,`received_control_number`=?,`mode_of_transport`=?,`processing_indicator`=?,`type_of_transport`=?,`ship_agent_tax_number`=?,`ship_agent_branch`=?,`callsign`=?,`vessel_name`=?,`master_name`=?,`previous_flight_no`=?,`previous_date`=?,`nationality`=?,`net_register_tonnage`=?,`gross_register_tonnage`=?,`dead_weight_tonnage`=?,`registration_id`=?,`modified_date_time`=?,`type`=? where id=?");
            VesselScheduleControlHistoryDaoImpl.setPreparedStatementValues(ps, vesselScheduleControlHistory);
            ps.setInt(23, vesselScheduleControlHistory.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE vsed_control_his[id=" + vesselScheduleControlHistory.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from vsed_control_his where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE vsed_control_his[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (VesselScheduleControlHistoryExample.Criteria criteria : vesselScheduleControlHistoryExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (VesselScheduleControlHistoryExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (vesselScheduleControlHistoryExample.getOrderByClause() != null && !vesselScheduleControlHistoryExample.getOrderByClause().isEmpty()) {
			clause += " order by " + vesselScheduleControlHistoryExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByVesselScheduleControlHistoryExample(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = VesselScheduleControlHistoryDaoImpl.buildClause(vesselScheduleControlHistoryExample);			
            ResultSet rs = stmt.executeQuery("select" + (vesselScheduleControlHistoryExample.isDistinct() ? " distinct " : " ") + "count(*) from vsed_control_his" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT vsed_control_his[distinct=" + vesselScheduleControlHistoryExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public VesselScheduleControlHistory findByVesselScheduleControlHistoryExample(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample) throws DaoException {
		List<VesselScheduleControlHistory> res = this.findAllByVesselScheduleControlHistoryExample(vesselScheduleControlHistoryExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<VesselScheduleControlHistory> findAllByVesselScheduleControlHistoryExample(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample) throws DaoException {
    	return this.findAllByVesselScheduleControlHistoryExample(vesselScheduleControlHistoryExample, 0, 2000);
    }
    
    @Override
    public List<VesselScheduleControlHistory> findAllByVesselScheduleControlHistoryExample(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample, int limit) throws DaoException {
    	return this.findAllByVesselScheduleControlHistoryExample(vesselScheduleControlHistoryExample, 0, limit);
    }
    
    @Override
    public List<VesselScheduleControlHistory> findAllByVesselScheduleControlHistoryExample(VesselScheduleControlHistoryExample vesselScheduleControlHistoryExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = VesselScheduleControlHistoryDaoImpl.buildClause(vesselScheduleControlHistoryExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND vsed_control_his[distinct=" + vesselScheduleControlHistoryExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (vesselScheduleControlHistoryExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`vsed_control_id`,`reference_number`,`received_control_number`,`mode_of_transport`,`processing_indicator`,`type_of_transport`,`ship_agent_tax_number`,`ship_agent_branch`,`callsign`,`vessel_name`,`master_name`,`previous_flight_no`,`previous_date`,`nationality`,`net_register_tonnage`,`gross_register_tonnage`,`dead_weight_tonnage`,`registration_id`,`modified_date_time`,`type` from vsed_control_his" + clause);

            List<VesselScheduleControlHistory> list = new ArrayList<VesselScheduleControlHistory>();
            while (rs.next()) {
                list.add(VesselScheduleControlHistoryDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}