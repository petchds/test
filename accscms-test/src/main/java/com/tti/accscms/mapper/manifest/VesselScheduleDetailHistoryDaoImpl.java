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
import com.tti.accscms.dao.manifest.VesselScheduleDetailHistoryDao;

import com.tti.accscms.domain.manifest.VesselScheduleDetailHistory;
import com.tti.accscms.domain.manifest.VesselScheduleDetailHistoryExample;
import com.tti.accscms.domain.manifest.VesselScheduleControlHistory;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table vsed_detail_his
 */
public class VesselScheduleDetailHistoryDaoImpl implements VesselScheduleDetailHistoryDao {

	private static final Logger logger = LoggerFactory.getLogger(VesselScheduleDetailHistoryDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, VesselScheduleDetailHistory vesselScheduleDetailHistory) throws SQLException {
		
		if (vesselScheduleDetailHistory.getId() != null) {
			ps.setInt(1, vesselScheduleDetailHistory.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (vesselScheduleDetailHistory.getId2() != null) {
			ps.setInt(2, vesselScheduleDetailHistory.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (vesselScheduleDetailHistory.getVsedControlId() != null) {
			ps.setInt(3, vesselScheduleDetailHistory.getVsedControlId());
		} else {
			ps.setNull(3, java.sql.Types.INTEGER);
		}

		if (vesselScheduleDetailHistory.getReceivedControlNumber() != null) {
			ps.setString(4, vesselScheduleDetailHistory.getReceivedControlNumber());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleDetailHistory.getPortOfDischarge() != null) {
			ps.setString(5, vesselScheduleDetailHistory.getPortOfDischarge());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleDetailHistory.getFlightNo() != null) {
			ps.setString(6, vesselScheduleDetailHistory.getFlightNo());
		} else {
			ps.setNull(6, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleDetailHistory.getFlightDate() != null) {
			ps.setTimestamp(7, new java.sql.Timestamp(vesselScheduleDetailHistory.getFlightDate().getTime()));
		} else {
			ps.setNull(7, java.sql.Types.DATE);
		}

		if (vesselScheduleDetailHistory.getFlightTime() != null) {
			ps.setTimestamp(8, new java.sql.Timestamp(vesselScheduleDetailHistory.getFlightTime().getTime()));
		} else {
			ps.setNull(8, java.sql.Types.TIME);
		}

		if (vesselScheduleDetailHistory.getEstimateToBerthDate() != null) {
			ps.setTimestamp(9, new java.sql.Timestamp(vesselScheduleDetailHistory.getEstimateToBerthDate().getTime()));
		} else {
			ps.setNull(9, java.sql.Types.DATE);
		}

		if (vesselScheduleDetailHistory.getEstimateToBerthTime() != null) {
			ps.setTimestamp(10, new java.sql.Timestamp(vesselScheduleDetailHistory.getEstimateToBerthTime().getTime()));
		} else {
			ps.setNull(10, java.sql.Types.TIME);
		}

		if (vesselScheduleDetailHistory.getBerth() != null) {
			ps.setString(11, vesselScheduleDetailHistory.getBerth());
		} else {
			ps.setNull(11, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleDetailHistory.getLastPortOfCall() != null) {
			ps.setString(12, vesselScheduleDetailHistory.getLastPortOfCall());
		} else {
			ps.setNull(12, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleDetailHistory.getNumberOfMawb() != null) {
			ps.setInt(13, vesselScheduleDetailHistory.getNumberOfMawb());
		} else {
			ps.setNull(13, java.sql.Types.INTEGER);
		}

		if (vesselScheduleDetailHistory.getNumberOfHawb() != null) {
			ps.setInt(14, vesselScheduleDetailHistory.getNumberOfHawb());
		} else {
			ps.setNull(14, java.sql.Types.INTEGER);
		}

		if (vesselScheduleDetailHistory.getNumberOfContainer() != null) {
			ps.setInt(15, vesselScheduleDetailHistory.getNumberOfContainer());
		} else {
			ps.setNull(15, java.sql.Types.INTEGER);
		}

		if (vesselScheduleDetailHistory.getTotalGrossWeight() != null) {
			ps.setDouble(16, vesselScheduleDetailHistory.getTotalGrossWeight());
		} else {
			ps.setNull(16, java.sql.Types.DOUBLE);
		}

		if (vesselScheduleDetailHistory.getTotalGrossWeightUnit() != null) {
			ps.setString(17, vesselScheduleDetailHistory.getTotalGrossWeightUnit());
		} else {
			ps.setNull(17, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleDetailHistory.getMessageFunction() != null) {
			ps.setString(18, vesselScheduleDetailHistory.getMessageFunction());
		} else {
			ps.setNull(18, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleDetailHistory.getLastEntry() != null) {
			ps.setString(19, vesselScheduleDetailHistory.getLastEntry());
		} else {
			ps.setNull(19, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleDetailHistory.getModifiedDateTime() != null) {
			ps.setTimestamp(20, new java.sql.Timestamp(vesselScheduleDetailHistory.getModifiedDateTime().getTime()));
		} else {
			ps.setTimestamp(20, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (vesselScheduleDetailHistory.getTerminalOperator() != null) {
			ps.setString(21, vesselScheduleDetailHistory.getTerminalOperator());
		} else {
			ps.setNull(21, java.sql.Types.VARCHAR);
		}

		if (vesselScheduleDetailHistory.getType() != null) {
			ps.setInt(22, vesselScheduleDetailHistory.getType());
		} else {
			ps.setNull(22, java.sql.Types.INTEGER);
		}

		if (vesselScheduleDetailHistory.getCloseFlight() != null) {
			ps.setByte(23, vesselScheduleDetailHistory.getCloseFlight());
		} else {
			ps.setNull(23, java.sql.Types.TINYINT);
		}

	}

		
	private static VesselScheduleDetailHistory createInstanceFromResultSet(ResultSet rs) throws SQLException {
		VesselScheduleDetailHistory vesselScheduleDetailHistory = new VesselScheduleDetailHistory();
		
		Integer col1 = rs.getInt("id");
		vesselScheduleDetailHistory.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		vesselScheduleDetailHistory.setId2(rs.wasNull() ? null : col2);

		Integer col3 = rs.getInt("vsed_control_id");
		vesselScheduleDetailHistory.setVsedControlId(rs.wasNull() ? null : col3);

		String col4 = rs.getString("received_control_number");
		vesselScheduleDetailHistory.setReceivedControlNumber(rs.wasNull() ? null : col4);

		String col5 = rs.getString("port_of_discharge");
		vesselScheduleDetailHistory.setPortOfDischarge(rs.wasNull() ? null : col5);

		String col6 = rs.getString("flight_no");
		vesselScheduleDetailHistory.setFlightNo(rs.wasNull() ? null : col6);

		java.sql.Timestamp col7 = rs.getTimestamp("flight_date");
		vesselScheduleDetailHistory.setFlightDate(rs.wasNull() ? null : new java.util.Date(col7.getTime()));

		java.sql.Timestamp col8 = rs.getTimestamp("flight_time");
		vesselScheduleDetailHistory.setFlightTime(rs.wasNull() ? null : new java.util.Date(col8.getTime()));

		java.sql.Timestamp col9 = rs.getTimestamp("estimate_to_berth_date");
		vesselScheduleDetailHistory.setEstimateToBerthDate(rs.wasNull() ? null : new java.util.Date(col9.getTime()));

		java.sql.Timestamp col10 = rs.getTimestamp("estimate_to_berth_time");
		vesselScheduleDetailHistory.setEstimateToBerthTime(rs.wasNull() ? null : new java.util.Date(col10.getTime()));

		String col11 = rs.getString("berth");
		vesselScheduleDetailHistory.setBerth(rs.wasNull() ? null : col11);

		String col12 = rs.getString("last_port_of_call");
		vesselScheduleDetailHistory.setLastPortOfCall(rs.wasNull() ? null : col12);

		Integer col13 = rs.getInt("number_of_mawb");
		vesselScheduleDetailHistory.setNumberOfMawb(rs.wasNull() ? null : col13);

		Integer col14 = rs.getInt("number_of_hawb");
		vesselScheduleDetailHistory.setNumberOfHawb(rs.wasNull() ? null : col14);

		Integer col15 = rs.getInt("number_of_container");
		vesselScheduleDetailHistory.setNumberOfContainer(rs.wasNull() ? null : col15);

		Double col16 = rs.getDouble("total_gross_weight");
		vesselScheduleDetailHistory.setTotalGrossWeight(rs.wasNull() ? null : col16);

		String col17 = rs.getString("total_gross_weight_unit");
		vesselScheduleDetailHistory.setTotalGrossWeightUnit(rs.wasNull() ? null : col17);

		String col18 = rs.getString("message_function");
		vesselScheduleDetailHistory.setMessageFunction(rs.wasNull() ? null : col18);

		String col19 = rs.getString("last_entry");
		vesselScheduleDetailHistory.setLastEntry(rs.wasNull() ? null : col19);

		java.sql.Timestamp col20 = rs.getTimestamp("modified_date_time");
		vesselScheduleDetailHistory.setModifiedDateTime(rs.wasNull() ? null : new java.util.Date(col20.getTime()));

		String col21 = rs.getString("terminal_operator");
		vesselScheduleDetailHistory.setTerminalOperator(rs.wasNull() ? null : col21);

		Integer col22 = rs.getInt("type");
		vesselScheduleDetailHistory.setType(rs.wasNull() ? null : col22);

		Byte col23 = rs.getByte("close_flight");
		vesselScheduleDetailHistory.setCloseFlight(rs.wasNull() ? null : col23);


		return vesselScheduleDetailHistory;
	}  

		
	@Override
	public int insert(VesselScheduleDetailHistory vesselScheduleDetailHistory) throws DaoException {
		if (vesselScheduleDetailHistory == null) {
			throw new DaoException("Cannot insert vsed_detail_his with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into vsed_detail_his(`id`,`id2`,`vsed_control_id`,`received_control_number`,`port_of_discharge`,`flight_no`,`flight_date`,`flight_time`,`estimate_to_berth_date`,`estimate_to_berth_time`,`berth`,`last_port_of_call`,`number_of_mawb`,`number_of_hawb`,`number_of_container`,`total_gross_weight`,`total_gross_weight_unit`,`message_function`,`last_entry`,`modified_date_time`,`terminal_operator`,`type`,`close_flight`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            VesselScheduleDetailHistoryDaoImpl.setPreparedStatementValues(ps, vesselScheduleDetailHistory);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT vsed_detail_his[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from vsed_detail_his");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT vsed_detail_his => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public VesselScheduleDetailHistory findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`vsed_control_id`,`received_control_number`,`port_of_discharge`,`flight_no`,`flight_date`,`flight_time`,`estimate_to_berth_date`,`estimate_to_berth_time`,`berth`,`last_port_of_call`,`number_of_mawb`,`number_of_hawb`,`number_of_container`,`total_gross_weight`,`total_gross_weight_unit`,`message_function`,`last_entry`,`modified_date_time`,`terminal_operator`,`type`,`close_flight` from vsed_detail_his where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND vsed_detail_his[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            VesselScheduleDetailHistory instance = null;
            if (rs.next()) {
                instance = VesselScheduleDetailHistoryDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(VesselScheduleDetailHistory vesselScheduleDetailHistory) throws DaoException {
		if (vesselScheduleDetailHistory == null) {
			throw new DaoException("Cannot insert vsed_detail_his with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update vsed_detail_his set `id`=?,`id2`=?,`vsed_control_id`=?,`received_control_number`=?,`port_of_discharge`=?,`flight_no`=?,`flight_date`=?,`flight_time`=?,`estimate_to_berth_date`=?,`estimate_to_berth_time`=?,`berth`=?,`last_port_of_call`=?,`number_of_mawb`=?,`number_of_hawb`=?,`number_of_container`=?,`total_gross_weight`=?,`total_gross_weight_unit`=?,`message_function`=?,`last_entry`=?,`modified_date_time`=?,`terminal_operator`=?,`type`=?,`close_flight`=? where id=?");
            VesselScheduleDetailHistoryDaoImpl.setPreparedStatementValues(ps, vesselScheduleDetailHistory);
            ps.setInt(24, vesselScheduleDetailHistory.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE vsed_detail_his[id=" + vesselScheduleDetailHistory.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from vsed_detail_his where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE vsed_detail_his[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
	@Override
	public List<VesselScheduleDetailHistory> findAllByVesselScheduleControlHistory(VesselScheduleControlHistory vesselScheduleControlHistory) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = null;
            if (vesselScheduleControlHistory == null || vesselScheduleControlHistory.getId() == null) {
            	ps = conn.prepareStatement("select `id`,`id2`,`vsed_control_id`,`received_control_number`,`port_of_discharge`,`flight_no`,`flight_date`,`flight_time`,`estimate_to_berth_date`,`estimate_to_berth_time`,`berth`,`last_port_of_call`,`number_of_mawb`,`number_of_hawb`,`number_of_container`,`total_gross_weight`,`total_gross_weight_unit`,`message_function`,`last_entry`,`modified_date_time`,`terminal_operator`,`type`,`close_flight` from vsed_detail_his where vsed_control_id=null");
            } else {
            	ps = conn.prepareStatement("select `id`,`id2`,`vsed_control_id`,`received_control_number`,`port_of_discharge`,`flight_no`,`flight_date`,`flight_time`,`estimate_to_berth_date`,`estimate_to_berth_time`,`berth`,`last_port_of_call`,`number_of_mawb`,`number_of_hawb`,`number_of_container`,`total_gross_weight`,`total_gross_weight_unit`,`message_function`,`last_entry`,`modified_date_time`,`terminal_operator`,`type`,`close_flight` from vsed_detail_his where vsed_control_id=?");
            	ps.setInt(1, vesselScheduleControlHistory.getId());
            }
            
            logger.debug("DB:FIND vsed_detail_his[vsed_control_id=" + (vesselScheduleControlHistory != null ? vesselScheduleControlHistory.getId() : "null") + "]");
            
            ResultSet rs = ps.executeQuery();

            List<VesselScheduleDetailHistory> list = new ArrayList<VesselScheduleDetailHistory>();
            while (rs.next()) {
                list.add(VesselScheduleDetailHistoryDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            ps.close();

            return list;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

		
	private static String buildClause(VesselScheduleDetailHistoryExample vesselScheduleDetailHistoryExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (VesselScheduleDetailHistoryExample.Criteria criteria : vesselScheduleDetailHistoryExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (VesselScheduleDetailHistoryExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (vesselScheduleDetailHistoryExample.getOrderByClause() != null && !vesselScheduleDetailHistoryExample.getOrderByClause().isEmpty()) {
			clause += " order by " + vesselScheduleDetailHistoryExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByVesselScheduleDetailHistoryExample(VesselScheduleDetailHistoryExample vesselScheduleDetailHistoryExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = VesselScheduleDetailHistoryDaoImpl.buildClause(vesselScheduleDetailHistoryExample);			
            ResultSet rs = stmt.executeQuery("select" + (vesselScheduleDetailHistoryExample.isDistinct() ? " distinct " : " ") + "count(*) from vsed_detail_his" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT vsed_detail_his[distinct=" + vesselScheduleDetailHistoryExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public VesselScheduleDetailHistory findByVesselScheduleDetailHistoryExample(VesselScheduleDetailHistoryExample vesselScheduleDetailHistoryExample) throws DaoException {
		List<VesselScheduleDetailHistory> res = this.findAllByVesselScheduleDetailHistoryExample(vesselScheduleDetailHistoryExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<VesselScheduleDetailHistory> findAllByVesselScheduleDetailHistoryExample(VesselScheduleDetailHistoryExample vesselScheduleDetailHistoryExample) throws DaoException {
    	return this.findAllByVesselScheduleDetailHistoryExample(vesselScheduleDetailHistoryExample, 0, 2000);
    }
    
    @Override
    public List<VesselScheduleDetailHistory> findAllByVesselScheduleDetailHistoryExample(VesselScheduleDetailHistoryExample vesselScheduleDetailHistoryExample, int limit) throws DaoException {
    	return this.findAllByVesselScheduleDetailHistoryExample(vesselScheduleDetailHistoryExample, 0, limit);
    }
    
    @Override
    public List<VesselScheduleDetailHistory> findAllByVesselScheduleDetailHistoryExample(VesselScheduleDetailHistoryExample vesselScheduleDetailHistoryExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = VesselScheduleDetailHistoryDaoImpl.buildClause(vesselScheduleDetailHistoryExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND vsed_detail_his[distinct=" + vesselScheduleDetailHistoryExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (vesselScheduleDetailHistoryExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`vsed_control_id`,`received_control_number`,`port_of_discharge`,`flight_no`,`flight_date`,`flight_time`,`estimate_to_berth_date`,`estimate_to_berth_time`,`berth`,`last_port_of_call`,`number_of_mawb`,`number_of_hawb`,`number_of_container`,`total_gross_weight`,`total_gross_weight_unit`,`message_function`,`last_entry`,`modified_date_time`,`terminal_operator`,`type`,`close_flight` from vsed_detail_his" + clause);

            List<VesselScheduleDetailHistory> list = new ArrayList<VesselScheduleDetailHistory>();
            while (rs.next()) {
                list.add(VesselScheduleDetailHistoryDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
