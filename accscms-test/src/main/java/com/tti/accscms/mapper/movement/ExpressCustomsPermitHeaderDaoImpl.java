package com.tti.accscms.mapper.movement;

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
import com.tti.accscms.dao.movement.ExpressCustomsPermitHeaderDao;

import com.tti.accscms.domain.movement.ExpressCustomsPermitHeader;
import com.tti.accscms.domain.movement.ExpressCustomsPermitHeaderExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table exp_customs_permit_header
 */
public class ExpressCustomsPermitHeaderDaoImpl implements ExpressCustomsPermitHeaderDao {

	private static final Logger logger = LoggerFactory.getLogger(ExpressCustomsPermitHeaderDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, ExpressCustomsPermitHeader expressCustomsPermitHeader) throws SQLException {
		
		if (expressCustomsPermitHeader.getId() != null) {
			ps.setInt(1, expressCustomsPermitHeader.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (expressCustomsPermitHeader.getId2() != null) {
			ps.setInt(2, expressCustomsPermitHeader.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (expressCustomsPermitHeader.getTransactionNo() != null) {
			ps.setString(3, expressCustomsPermitHeader.getTransactionNo());
		} else {
			ps.setNull(3, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getDeclarationNo() != null) {
			ps.setString(4, expressCustomsPermitHeader.getDeclarationNo());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getDocumentType() != null) {
			ps.setString(5, expressCustomsPermitHeader.getDocumentType());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getDocumentStatus() != null) {
			ps.setString(6, expressCustomsPermitHeader.getDocumentStatus());
		} else {
			ps.setNull(6, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getReceivedControlNumber() != null) {
			ps.setString(7, expressCustomsPermitHeader.getReceivedControlNumber());
		} else {
			ps.setNull(7, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getCallsign() != null) {
			ps.setString(8, expressCustomsPermitHeader.getCallsign());
		} else {
			ps.setNull(8, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getFlightNo() != null) {
			ps.setString(9, expressCustomsPermitHeader.getFlightNo());
		} else {
			ps.setNull(9, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getPortOfDischarge() != null) {
			ps.setString(10, expressCustomsPermitHeader.getPortOfDischarge());
		} else {
			ps.setNull(10, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getShedNo() != null) {
			ps.setString(11, expressCustomsPermitHeader.getShedNo());
		} else {
			ps.setNull(11, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getVesselName() != null) {
			ps.setString(12, expressCustomsPermitHeader.getVesselName());
		} else {
			ps.setNull(12, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getMawb() != null) {
			ps.setString(13, expressCustomsPermitHeader.getMawb());
		} else {
			ps.setNull(13, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getHawb() != null) {
			ps.setString(14, expressCustomsPermitHeader.getHawb());
		} else {
			ps.setNull(14, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getFlightDate() != null) {
			ps.setTimestamp(15, new java.sql.Timestamp(expressCustomsPermitHeader.getFlightDate().getTime()));
		} else {
			ps.setNull(15, java.sql.Types.DATE);
		}

		if (expressCustomsPermitHeader.getConsigneeName() != null) {
			ps.setString(16, expressCustomsPermitHeader.getConsigneeName());
		} else {
			ps.setNull(16, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getMarkAndNumber() != null) {
			ps.setString(17, expressCustomsPermitHeader.getMarkAndNumber());
		} else {
			ps.setNull(17, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getCargoClearanceDate() != null) {
			ps.setTimestamp(18, new java.sql.Timestamp(expressCustomsPermitHeader.getCargoClearanceDate().getTime()));
		} else {
			ps.setNull(18, java.sql.Types.DATE);
		}

		if (expressCustomsPermitHeader.getCargoClearanceTime() != null) {
			ps.setTimestamp(19, new java.sql.Timestamp(expressCustomsPermitHeader.getCargoClearanceTime().getTime()));
		} else {
			ps.setNull(19, java.sql.Types.TIME);
		}

		if (expressCustomsPermitHeader.getTotalItem() != null) {
			ps.setInt(20, expressCustomsPermitHeader.getTotalItem());
		} else {
			ps.setNull(20, java.sql.Types.INTEGER);
		}

		if (expressCustomsPermitHeader.getTransmitDate() != null) {
			ps.setTimestamp(21, new java.sql.Timestamp(expressCustomsPermitHeader.getTransmitDate().getTime()));
		} else {
			ps.setNull(21, java.sql.Types.DATE);
		}

		if (expressCustomsPermitHeader.getTransmitTime() != null) {
			ps.setTimestamp(22, new java.sql.Timestamp(expressCustomsPermitHeader.getTransmitTime().getTime()));
		} else {
			ps.setNull(22, java.sql.Types.TIME);
		}

		if (expressCustomsPermitHeader.getNumberOfContainer() != null) {
			ps.setInt(23, expressCustomsPermitHeader.getNumberOfContainer());
		} else {
			ps.setNull(23, java.sql.Types.INTEGER);
		}

		if (expressCustomsPermitHeader.getBalanced() != null) {
			ps.setByte(24, expressCustomsPermitHeader.getBalanced());
		} else {
			ps.setNull(24, java.sql.Types.TINYINT);
		}

		if (expressCustomsPermitHeader.getBalancedDateTime() != null) {
			ps.setTimestamp(25, new java.sql.Timestamp(expressCustomsPermitHeader.getBalancedDateTime().getTime()));
		} else {
			ps.setNull(25, java.sql.Types.TIMESTAMP);
		}

		if (expressCustomsPermitHeader.getModifiedDateTime() != null) {
			ps.setTimestamp(26, new java.sql.Timestamp(expressCustomsPermitHeader.getModifiedDateTime().getTime()));
		} else {
			ps.setTimestamp(26, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (expressCustomsPermitHeader.getAbilGoodsDescription() != null) {
			ps.setString(27, expressCustomsPermitHeader.getAbilGoodsDescription());
		} else {
			ps.setNull(27, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getStatus() != null) {
			ps.setString(28, expressCustomsPermitHeader.getStatus());
		} else {
			ps.setNull(28, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getStatusBy() != null) {
			ps.setString(29, expressCustomsPermitHeader.getStatusBy());
		} else {
			ps.setNull(29, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getRemark() != null) {
			ps.setString(30, expressCustomsPermitHeader.getRemark());
		} else {
			ps.setNull(30, java.sql.Types.VARCHAR);
		}

		if (expressCustomsPermitHeader.getStatusDateTime() != null) {
			ps.setTimestamp(31, new java.sql.Timestamp(expressCustomsPermitHeader.getStatusDateTime().getTime()));
		} else {
			ps.setNull(31, java.sql.Types.TIMESTAMP);
		}

		if (expressCustomsPermitHeader.getIsEditManual() != null) {
			ps.setInt(32, expressCustomsPermitHeader.getIsEditManual());
		} else {
			ps.setNull(32, java.sql.Types.INTEGER);
		}

		if (expressCustomsPermitHeader.getDestination() != null) {
			ps.setString(33, expressCustomsPermitHeader.getDestination());
		} else {
			ps.setNull(33, java.sql.Types.VARCHAR);
		}

	}

		
	private static ExpressCustomsPermitHeader createInstanceFromResultSet(ResultSet rs) throws SQLException {
		ExpressCustomsPermitHeader expressCustomsPermitHeader = new ExpressCustomsPermitHeader();
		
		Integer col1 = rs.getInt("id");
		expressCustomsPermitHeader.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		expressCustomsPermitHeader.setId2(rs.wasNull() ? null : col2);

		String col3 = rs.getString("transaction_no");
		expressCustomsPermitHeader.setTransactionNo(rs.wasNull() ? null : col3);

		String col4 = rs.getString("declaration_no");
		expressCustomsPermitHeader.setDeclarationNo(rs.wasNull() ? null : col4);

		String col5 = rs.getString("document_type");
		expressCustomsPermitHeader.setDocumentType(rs.wasNull() ? null : col5);

		String col6 = rs.getString("document_status");
		expressCustomsPermitHeader.setDocumentStatus(rs.wasNull() ? null : col6);

		String col7 = rs.getString("received_control_number");
		expressCustomsPermitHeader.setReceivedControlNumber(rs.wasNull() ? null : col7);

		String col8 = rs.getString("callsign");
		expressCustomsPermitHeader.setCallsign(rs.wasNull() ? null : col8);

		String col9 = rs.getString("flight_no");
		expressCustomsPermitHeader.setFlightNo(rs.wasNull() ? null : col9);

		String col10 = rs.getString("port_of_discharge");
		expressCustomsPermitHeader.setPortOfDischarge(rs.wasNull() ? null : col10);

		String col11 = rs.getString("shed_no");
		expressCustomsPermitHeader.setShedNo(rs.wasNull() ? null : col11);

		String col12 = rs.getString("vessel_name");
		expressCustomsPermitHeader.setVesselName(rs.wasNull() ? null : col12);

		String col13 = rs.getString("mawb");
		expressCustomsPermitHeader.setMawb(rs.wasNull() ? null : col13);

		String col14 = rs.getString("hawb");
		expressCustomsPermitHeader.setHawb(rs.wasNull() ? null : col14);

		java.sql.Timestamp col15 = rs.getTimestamp("flight_date");
		expressCustomsPermitHeader.setFlightDate(rs.wasNull() ? null : new java.util.Date(col15.getTime()));

		String col16 = rs.getString("consignee_name");
		expressCustomsPermitHeader.setConsigneeName(rs.wasNull() ? null : col16);

		String col17 = rs.getString("mark_and_number");
		expressCustomsPermitHeader.setMarkAndNumber(rs.wasNull() ? null : col17);

		java.sql.Timestamp col18 = rs.getTimestamp("cargo_clearance_date");
		expressCustomsPermitHeader.setCargoClearanceDate(rs.wasNull() ? null : new java.util.Date(col18.getTime()));

		java.sql.Timestamp col19 = rs.getTimestamp("cargo_clearance_time");
		expressCustomsPermitHeader.setCargoClearanceTime(rs.wasNull() ? null : new java.util.Date(col19.getTime()));

		Integer col20 = rs.getInt("total_item");
		expressCustomsPermitHeader.setTotalItem(rs.wasNull() ? null : col20);

		java.sql.Timestamp col21 = rs.getTimestamp("transmit_date");
		expressCustomsPermitHeader.setTransmitDate(rs.wasNull() ? null : new java.util.Date(col21.getTime()));

		java.sql.Timestamp col22 = rs.getTimestamp("transmit_time");
		expressCustomsPermitHeader.setTransmitTime(rs.wasNull() ? null : new java.util.Date(col22.getTime()));

		Integer col23 = rs.getInt("number_of_container");
		expressCustomsPermitHeader.setNumberOfContainer(rs.wasNull() ? null : col23);

		Byte col24 = rs.getByte("balanced");
		expressCustomsPermitHeader.setBalanced(rs.wasNull() ? null : col24);

		java.sql.Timestamp col25 = rs.getTimestamp("balanced_date_time");
		expressCustomsPermitHeader.setBalancedDateTime(rs.wasNull() ? null : new java.util.Date(col25.getTime()));

		java.sql.Timestamp col26 = rs.getTimestamp("modified_date_time");
		expressCustomsPermitHeader.setModifiedDateTime(rs.wasNull() ? null : new java.util.Date(col26.getTime()));

		String col27 = rs.getString("abil_goods_description");
		expressCustomsPermitHeader.setAbilGoodsDescription(rs.wasNull() ? null : col27);

		String col28 = rs.getString("status");
		expressCustomsPermitHeader.setStatus(rs.wasNull() ? null : col28);

		String col29 = rs.getString("status_by");
		expressCustomsPermitHeader.setStatusBy(rs.wasNull() ? null : col29);

		String col30 = rs.getString("remark");
		expressCustomsPermitHeader.setRemark(rs.wasNull() ? null : col30);

		java.sql.Timestamp col31 = rs.getTimestamp("status_date_time");
		expressCustomsPermitHeader.setStatusDateTime(rs.wasNull() ? null : new java.util.Date(col31.getTime()));

		Integer col32 = rs.getInt("is_edit_manual");
		expressCustomsPermitHeader.setIsEditManual(rs.wasNull() ? null : col32);

		String col33 = rs.getString("destination");
		expressCustomsPermitHeader.setDestination(rs.wasNull() ? null : col33);


		return expressCustomsPermitHeader;
	}  

		
	@Override
	public int insert(ExpressCustomsPermitHeader expressCustomsPermitHeader) throws DaoException {
		if (expressCustomsPermitHeader == null) {
			throw new DaoException("Cannot insert exp_customs_permit_header with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into exp_customs_permit_header(`id`,`id2`,`transaction_no`,`declaration_no`,`document_type`,`document_status`,`received_control_number`,`callsign`,`flight_no`,`port_of_discharge`,`shed_no`,`vessel_name`,`mawb`,`hawb`,`flight_date`,`consignee_name`,`mark_and_number`,`cargo_clearance_date`,`cargo_clearance_time`,`total_item`,`transmit_date`,`transmit_time`,`number_of_container`,`balanced`,`balanced_date_time`,`modified_date_time`,`abil_goods_description`,`status`,`status_by`,`remark`,`status_date_time`,`is_edit_manual`,`destination`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ExpressCustomsPermitHeaderDaoImpl.setPreparedStatementValues(ps, expressCustomsPermitHeader);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT exp_customs_permit_header[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from exp_customs_permit_header");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT exp_customs_permit_header => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public ExpressCustomsPermitHeader findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`transaction_no`,`declaration_no`,`document_type`,`document_status`,`received_control_number`,`callsign`,`flight_no`,`port_of_discharge`,`shed_no`,`vessel_name`,`mawb`,`hawb`,`flight_date`,`consignee_name`,`mark_and_number`,`cargo_clearance_date`,`cargo_clearance_time`,`total_item`,`transmit_date`,`transmit_time`,`number_of_container`,`balanced`,`balanced_date_time`,`modified_date_time`,`abil_goods_description`,`status`,`status_by`,`remark`,`status_date_time`,`is_edit_manual`,`destination` from exp_customs_permit_header where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND exp_customs_permit_header[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            ExpressCustomsPermitHeader instance = null;
            if (rs.next()) {
                instance = ExpressCustomsPermitHeaderDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(ExpressCustomsPermitHeader expressCustomsPermitHeader) throws DaoException {
		if (expressCustomsPermitHeader == null) {
			throw new DaoException("Cannot insert exp_customs_permit_header with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update exp_customs_permit_header set `id`=?,`id2`=?,`transaction_no`=?,`declaration_no`=?,`document_type`=?,`document_status`=?,`received_control_number`=?,`callsign`=?,`flight_no`=?,`port_of_discharge`=?,`shed_no`=?,`vessel_name`=?,`mawb`=?,`hawb`=?,`flight_date`=?,`consignee_name`=?,`mark_and_number`=?,`cargo_clearance_date`=?,`cargo_clearance_time`=?,`total_item`=?,`transmit_date`=?,`transmit_time`=?,`number_of_container`=?,`balanced`=?,`balanced_date_time`=?,`modified_date_time`=?,`abil_goods_description`=?,`status`=?,`status_by`=?,`remark`=?,`status_date_time`=?,`is_edit_manual`=?,`destination`=? where id=?");
            ExpressCustomsPermitHeaderDaoImpl.setPreparedStatementValues(ps, expressCustomsPermitHeader);
            ps.setInt(34, expressCustomsPermitHeader.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE exp_customs_permit_header[id=" + expressCustomsPermitHeader.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from exp_customs_permit_header where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE exp_customs_permit_header[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(ExpressCustomsPermitHeaderExample expressCustomsPermitHeaderExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (ExpressCustomsPermitHeaderExample.Criteria criteria : expressCustomsPermitHeaderExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (ExpressCustomsPermitHeaderExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (expressCustomsPermitHeaderExample.getOrderByClause() != null && !expressCustomsPermitHeaderExample.getOrderByClause().isEmpty()) {
			clause += " order by " + expressCustomsPermitHeaderExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByExpressCustomsPermitHeaderExample(ExpressCustomsPermitHeaderExample expressCustomsPermitHeaderExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = ExpressCustomsPermitHeaderDaoImpl.buildClause(expressCustomsPermitHeaderExample);			
            ResultSet rs = stmt.executeQuery("select" + (expressCustomsPermitHeaderExample.isDistinct() ? " distinct " : " ") + "count(*) from exp_customs_permit_header" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT exp_customs_permit_header[distinct=" + expressCustomsPermitHeaderExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public ExpressCustomsPermitHeader findByExpressCustomsPermitHeaderExample(ExpressCustomsPermitHeaderExample expressCustomsPermitHeaderExample) throws DaoException {
		List<ExpressCustomsPermitHeader> res = this.findAllByExpressCustomsPermitHeaderExample(expressCustomsPermitHeaderExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<ExpressCustomsPermitHeader> findAllByExpressCustomsPermitHeaderExample(ExpressCustomsPermitHeaderExample expressCustomsPermitHeaderExample) throws DaoException {
    	return this.findAllByExpressCustomsPermitHeaderExample(expressCustomsPermitHeaderExample, 0, 2000);
    }
    
    @Override
    public List<ExpressCustomsPermitHeader> findAllByExpressCustomsPermitHeaderExample(ExpressCustomsPermitHeaderExample expressCustomsPermitHeaderExample, int limit) throws DaoException {
    	return this.findAllByExpressCustomsPermitHeaderExample(expressCustomsPermitHeaderExample, 0, limit);
    }
    
    @Override
    public List<ExpressCustomsPermitHeader> findAllByExpressCustomsPermitHeaderExample(ExpressCustomsPermitHeaderExample expressCustomsPermitHeaderExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = ExpressCustomsPermitHeaderDaoImpl.buildClause(expressCustomsPermitHeaderExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND exp_customs_permit_header[distinct=" + expressCustomsPermitHeaderExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (expressCustomsPermitHeaderExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`transaction_no`,`declaration_no`,`document_type`,`document_status`,`received_control_number`,`callsign`,`flight_no`,`port_of_discharge`,`shed_no`,`vessel_name`,`mawb`,`hawb`,`flight_date`,`consignee_name`,`mark_and_number`,`cargo_clearance_date`,`cargo_clearance_time`,`total_item`,`transmit_date`,`transmit_time`,`number_of_container`,`balanced`,`balanced_date_time`,`modified_date_time`,`abil_goods_description`,`status`,`status_by`,`remark`,`status_date_time`,`is_edit_manual`,`destination` from exp_customs_permit_header" + clause);

            List<ExpressCustomsPermitHeader> list = new ArrayList<ExpressCustomsPermitHeader>();
            while (rs.next()) {
                list.add(ExpressCustomsPermitHeaderDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
