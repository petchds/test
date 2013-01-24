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
import com.tti.accscms.dao.manifest.AirWaybillControlDao;

import com.tti.accscms.domain.manifest.AirWaybillControl;
import com.tti.accscms.domain.manifest.AirWaybillControlExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table abil_control
 */
public class AirWaybillControlDaoImpl implements AirWaybillControlDao {

	private static final Logger logger = LoggerFactory.getLogger(AirWaybillControlDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, AirWaybillControl airWaybillControl) throws SQLException {
		
		if (airWaybillControl.getId() != null) {
			ps.setInt(1, airWaybillControl.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (airWaybillControl.getId2() != null) {
			ps.setInt(2, airWaybillControl.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (airWaybillControl.getReferenceNumber() != null) {
			ps.setString(3, airWaybillControl.getReferenceNumber());
		} else {
			ps.setNull(3, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getReceivedControlNumber() != null) {
			ps.setString(4, airWaybillControl.getReceivedControlNumber());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getMawb() != null) {
			ps.setString(5, airWaybillControl.getMawb());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getFreightForwarderTaxNumber() != null) {
			ps.setString(6, airWaybillControl.getFreightForwarderTaxNumber());
		} else {
			ps.setNull(6, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getFreightForwarderBranch() != null) {
			ps.setInt(7, airWaybillControl.getFreightForwarderBranch());
		} else {
			ps.setNull(7, java.sql.Types.INTEGER);
		}

		if (airWaybillControl.getProcessingIndicator() != null) {
			ps.setString(8, airWaybillControl.getProcessingIndicator());
		} else {
			ps.setNull(8, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getOriginCountryCode() != null) {
			ps.setString(9, airWaybillControl.getOriginCountryCode());
		} else {
			ps.setNull(9, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getPortOfLoading() != null) {
			ps.setString(10, airWaybillControl.getPortOfLoading());
		} else {
			ps.setNull(10, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getPortOfDischarge() != null) {
			ps.setString(11, airWaybillControl.getPortOfDischarge());
		} else {
			ps.setNull(11, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getPlaceOfReceipt() != null) {
			ps.setString(12, airWaybillControl.getPlaceOfReceipt());
		} else {
			ps.setNull(12, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getPlaceOfDelivery() != null) {
			ps.setString(13, airWaybillControl.getPlaceOfDelivery());
		} else {
			ps.setNull(13, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getShedNo() != null) {
			ps.setInt(14, airWaybillControl.getShedNo());
		} else {
			ps.setNull(14, java.sql.Types.INTEGER);
		}

		if (airWaybillControl.getMessageFunction() != null) {
			ps.setString(15, airWaybillControl.getMessageFunction());
		} else {
			ps.setNull(15, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getFreightCharges() != null) {
			ps.setString(16, airWaybillControl.getFreightCharges());
		} else {
			ps.setNull(16, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getOtherCharges() != null) {
			ps.setString(17, airWaybillControl.getOtherCharges());
		} else {
			ps.setNull(17, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getFreightAmountForeign() != null) {
			ps.setDouble(18, airWaybillControl.getFreightAmountForeign());
		} else {
			ps.setNull(18, java.sql.Types.DOUBLE);
		}

		if (airWaybillControl.getFreightCurrencyCode() != null) {
			ps.setString(19, airWaybillControl.getFreightCurrencyCode());
		} else {
			ps.setNull(19, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getTermOfPaymentFreight() != null) {
			ps.setString(20, airWaybillControl.getTermOfPaymentFreight());
		} else {
			ps.setNull(20, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getRegistrationId() != null) {
			ps.setString(21, airWaybillControl.getRegistrationId());
		} else {
			ps.setNull(21, java.sql.Types.VARCHAR);
		}

		if (airWaybillControl.getModifiedDateTime() != null) {
			ps.setTimestamp(22, new java.sql.Timestamp(airWaybillControl.getModifiedDateTime().getTime()));
		} else {
			ps.setTimestamp(22, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (airWaybillControl.getType() != null) {
			ps.setInt(23, airWaybillControl.getType());
		} else {
			ps.setNull(23, java.sql.Types.INTEGER);
		}

	}

		
	private static AirWaybillControl createInstanceFromResultSet(ResultSet rs) throws SQLException {
		AirWaybillControl airWaybillControl = new AirWaybillControl();
		
		Integer col1 = rs.getInt("id");
		airWaybillControl.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		airWaybillControl.setId2(rs.wasNull() ? null : col2);

		String col3 = rs.getString("reference_number");
		airWaybillControl.setReferenceNumber(rs.wasNull() ? null : col3);

		String col4 = rs.getString("received_control_number");
		airWaybillControl.setReceivedControlNumber(rs.wasNull() ? null : col4);

		String col5 = rs.getString("mawb");
		airWaybillControl.setMawb(rs.wasNull() ? null : col5);

		String col6 = rs.getString("freight_forwarder_tax_number");
		airWaybillControl.setFreightForwarderTaxNumber(rs.wasNull() ? null : col6);

		Integer col7 = rs.getInt("freight_forwarder_branch");
		airWaybillControl.setFreightForwarderBranch(rs.wasNull() ? null : col7);

		String col8 = rs.getString("processing_indicator");
		airWaybillControl.setProcessingIndicator(rs.wasNull() ? null : col8);

		String col9 = rs.getString("origin_country_code");
		airWaybillControl.setOriginCountryCode(rs.wasNull() ? null : col9);

		String col10 = rs.getString("port_of_loading");
		airWaybillControl.setPortOfLoading(rs.wasNull() ? null : col10);

		String col11 = rs.getString("port_of_discharge");
		airWaybillControl.setPortOfDischarge(rs.wasNull() ? null : col11);

		String col12 = rs.getString("place_of_receipt");
		airWaybillControl.setPlaceOfReceipt(rs.wasNull() ? null : col12);

		String col13 = rs.getString("place_of_delivery");
		airWaybillControl.setPlaceOfDelivery(rs.wasNull() ? null : col13);

		Integer col14 = rs.getInt("shed_no");
		airWaybillControl.setShedNo(rs.wasNull() ? null : col14);

		String col15 = rs.getString("message_function");
		airWaybillControl.setMessageFunction(rs.wasNull() ? null : col15);

		String col16 = rs.getString("freight_charges");
		airWaybillControl.setFreightCharges(rs.wasNull() ? null : col16);

		String col17 = rs.getString("other_charges");
		airWaybillControl.setOtherCharges(rs.wasNull() ? null : col17);

		Double col18 = rs.getDouble("freight_amount_foreign");
		airWaybillControl.setFreightAmountForeign(rs.wasNull() ? null : col18);

		String col19 = rs.getString("freight_currency_code");
		airWaybillControl.setFreightCurrencyCode(rs.wasNull() ? null : col19);

		String col20 = rs.getString("term_of_payment_freight");
		airWaybillControl.setTermOfPaymentFreight(rs.wasNull() ? null : col20);

		String col21 = rs.getString("registration_id");
		airWaybillControl.setRegistrationId(rs.wasNull() ? null : col21);

		java.sql.Timestamp col22 = rs.getTimestamp("modified_date_time");
		airWaybillControl.setModifiedDateTime(rs.wasNull() ? null : new java.util.Date(col22.getTime()));

		Integer col23 = rs.getInt("type");
		airWaybillControl.setType(rs.wasNull() ? null : col23);


		return airWaybillControl;
	}  

		
	@Override
	public int insert(AirWaybillControl airWaybillControl) throws DaoException {
		if (airWaybillControl == null) {
			throw new DaoException("Cannot insert abil_control with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into abil_control(`id`,`id2`,`reference_number`,`received_control_number`,`mawb`,`freight_forwarder_tax_number`,`freight_forwarder_branch`,`processing_indicator`,`origin_country_code`,`port_of_loading`,`port_of_discharge`,`place_of_receipt`,`place_of_delivery`,`shed_no`,`message_function`,`freight_charges`,`other_charges`,`freight_amount_foreign`,`freight_currency_code`,`term_of_payment_freight`,`registration_id`,`modified_date_time`,`type`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            AirWaybillControlDaoImpl.setPreparedStatementValues(ps, airWaybillControl);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT abil_control[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from abil_control");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT abil_control => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public AirWaybillControl findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`reference_number`,`received_control_number`,`mawb`,`freight_forwarder_tax_number`,`freight_forwarder_branch`,`processing_indicator`,`origin_country_code`,`port_of_loading`,`port_of_discharge`,`place_of_receipt`,`place_of_delivery`,`shed_no`,`message_function`,`freight_charges`,`other_charges`,`freight_amount_foreign`,`freight_currency_code`,`term_of_payment_freight`,`registration_id`,`modified_date_time`,`type` from abil_control where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND abil_control[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            AirWaybillControl instance = null;
            if (rs.next()) {
                instance = AirWaybillControlDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(AirWaybillControl airWaybillControl) throws DaoException {
		if (airWaybillControl == null) {
			throw new DaoException("Cannot insert abil_control with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update abil_control set `id`=?,`id2`=?,`reference_number`=?,`received_control_number`=?,`mawb`=?,`freight_forwarder_tax_number`=?,`freight_forwarder_branch`=?,`processing_indicator`=?,`origin_country_code`=?,`port_of_loading`=?,`port_of_discharge`=?,`place_of_receipt`=?,`place_of_delivery`=?,`shed_no`=?,`message_function`=?,`freight_charges`=?,`other_charges`=?,`freight_amount_foreign`=?,`freight_currency_code`=?,`term_of_payment_freight`=?,`registration_id`=?,`modified_date_time`=?,`type`=? where id=?");
            AirWaybillControlDaoImpl.setPreparedStatementValues(ps, airWaybillControl);
            ps.setInt(24, airWaybillControl.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE abil_control[id=" + airWaybillControl.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from abil_control where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE abil_control[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(AirWaybillControlExample airWaybillControlExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (AirWaybillControlExample.Criteria criteria : airWaybillControlExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (AirWaybillControlExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (airWaybillControlExample.getOrderByClause() != null && !airWaybillControlExample.getOrderByClause().isEmpty()) {
			clause += " order by " + airWaybillControlExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByAirWaybillControlExample(AirWaybillControlExample airWaybillControlExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = AirWaybillControlDaoImpl.buildClause(airWaybillControlExample);			
            ResultSet rs = stmt.executeQuery("select" + (airWaybillControlExample.isDistinct() ? " distinct " : " ") + "count(*) from abil_control" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT abil_control[distinct=" + airWaybillControlExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public AirWaybillControl findByAirWaybillControlExample(AirWaybillControlExample airWaybillControlExample) throws DaoException {
		List<AirWaybillControl> res = this.findAllByAirWaybillControlExample(airWaybillControlExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<AirWaybillControl> findAllByAirWaybillControlExample(AirWaybillControlExample airWaybillControlExample) throws DaoException {
    	return this.findAllByAirWaybillControlExample(airWaybillControlExample, 0, 2000);
    }
    
    @Override
    public List<AirWaybillControl> findAllByAirWaybillControlExample(AirWaybillControlExample airWaybillControlExample, int limit) throws DaoException {
    	return this.findAllByAirWaybillControlExample(airWaybillControlExample, 0, limit);
    }
    
    @Override
    public List<AirWaybillControl> findAllByAirWaybillControlExample(AirWaybillControlExample airWaybillControlExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = AirWaybillControlDaoImpl.buildClause(airWaybillControlExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND abil_control[distinct=" + airWaybillControlExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (airWaybillControlExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`reference_number`,`received_control_number`,`mawb`,`freight_forwarder_tax_number`,`freight_forwarder_branch`,`processing_indicator`,`origin_country_code`,`port_of_loading`,`port_of_discharge`,`place_of_receipt`,`place_of_delivery`,`shed_no`,`message_function`,`freight_charges`,`other_charges`,`freight_amount_foreign`,`freight_currency_code`,`term_of_payment_freight`,`registration_id`,`modified_date_time`,`type` from abil_control" + clause);

            List<AirWaybillControl> list = new ArrayList<AirWaybillControl>();
            while (rs.next()) {
                list.add(AirWaybillControlDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
