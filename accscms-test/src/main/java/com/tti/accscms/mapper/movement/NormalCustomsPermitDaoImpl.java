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
import com.tti.accscms.dao.movement.NormalCustomsPermitDao;

import com.tti.accscms.domain.movement.NormalCustomsPermit;
import com.tti.accscms.domain.movement.NormalCustomsPermitExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table norm_customs_permit
 */
public class NormalCustomsPermitDaoImpl implements NormalCustomsPermitDao {

	private static final Logger logger = LoggerFactory.getLogger(NormalCustomsPermitDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, NormalCustomsPermit normalCustomsPermit) throws SQLException {
		
		if (normalCustomsPermit.getId() != null) {
			ps.setInt(1, normalCustomsPermit.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (normalCustomsPermit.getId2() != null) {
			ps.setInt(2, normalCustomsPermit.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (normalCustomsPermit.getDeclarationNo() != null) {
			ps.setString(3, normalCustomsPermit.getDeclarationNo());
		} else {
			ps.setNull(3, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getTransactionNo() != null) {
			ps.setString(4, normalCustomsPermit.getTransactionNo());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getDocumentType() != null) {
			ps.setString(5, normalCustomsPermit.getDocumentType());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getReceivedControlNumber() != null) {
			ps.setString(6, normalCustomsPermit.getReceivedControlNumber());
		} else {
			ps.setNull(6, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getVesselName() != null) {
			ps.setString(7, normalCustomsPermit.getVesselName());
		} else {
			ps.setNull(7, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getMawb() != null) {
			ps.setString(8, normalCustomsPermit.getMawb());
		} else {
			ps.setNull(8, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getHawb() != null) {
			ps.setString(9, normalCustomsPermit.getHawb());
		} else {
			ps.setNull(9, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getCallsign() != null) {
			ps.setString(10, normalCustomsPermit.getCallsign());
		} else {
			ps.setNull(10, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getFlightNo() != null) {
			ps.setString(11, normalCustomsPermit.getFlightNo());
		} else {
			ps.setNull(11, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getPortOfDischarge() != null) {
			ps.setString(12, normalCustomsPermit.getPortOfDischarge());
		} else {
			ps.setNull(12, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getShedNo() != null) {
			ps.setString(13, normalCustomsPermit.getShedNo());
		} else {
			ps.setNull(13, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getFlightDate() != null) {
			ps.setTimestamp(14, new java.sql.Timestamp(normalCustomsPermit.getFlightDate().getTime()));
		} else {
			ps.setNull(14, java.sql.Types.DATE);
		}

		if (normalCustomsPermit.getConsigneeName() != null) {
			ps.setString(15, normalCustomsPermit.getConsigneeName());
		} else {
			ps.setNull(15, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getMarkAndNumber() != null) {
			ps.setString(16, normalCustomsPermit.getMarkAndNumber());
		} else {
			ps.setNull(16, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getNumberOfPackage() != null) {
			ps.setInt(17, normalCustomsPermit.getNumberOfPackage());
		} else {
			ps.setNull(17, java.sql.Types.INTEGER);
		}

		if (normalCustomsPermit.getNumberOfPackageUnit() != null) {
			ps.setString(18, normalCustomsPermit.getNumberOfPackageUnit());
		} else {
			ps.setNull(18, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getGrossWeight() != null) {
			ps.setDouble(19, normalCustomsPermit.getGrossWeight());
		} else {
			ps.setNull(19, java.sql.Types.DOUBLE);
		}

		if (normalCustomsPermit.getGrossWeightUnit() != null) {
			ps.setString(20, normalCustomsPermit.getGrossWeightUnit());
		} else {
			ps.setNull(20, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getCargoClearanceDate() != null) {
			ps.setTimestamp(21, new java.sql.Timestamp(normalCustomsPermit.getCargoClearanceDate().getTime()));
		} else {
			ps.setNull(21, java.sql.Types.DATE);
		}

		if (normalCustomsPermit.getCargoClearanceTime() != null) {
			ps.setTimestamp(22, new java.sql.Timestamp(normalCustomsPermit.getCargoClearanceTime().getTime()));
		} else {
			ps.setNull(22, java.sql.Types.TIME);
		}

		if (normalCustomsPermit.getTransmitDate() != null) {
			ps.setTimestamp(23, new java.sql.Timestamp(normalCustomsPermit.getTransmitDate().getTime()));
		} else {
			ps.setNull(23, java.sql.Types.DATE);
		}

		if (normalCustomsPermit.getTransmitTime() != null) {
			ps.setTimestamp(24, new java.sql.Timestamp(normalCustomsPermit.getTransmitTime().getTime()));
		} else {
			ps.setNull(24, java.sql.Types.TIME);
		}

		if (normalCustomsPermit.getNumberOfContainer() != null) {
			ps.setInt(25, normalCustomsPermit.getNumberOfContainer());
		} else {
			ps.setNull(25, java.sql.Types.INTEGER);
		}

		if (normalCustomsPermit.getBalanced() != null) {
			ps.setByte(26, normalCustomsPermit.getBalanced());
		} else {
			ps.setNull(26, java.sql.Types.TINYINT);
		}

		if (normalCustomsPermit.getBalancedDateTime() != null) {
			ps.setTimestamp(27, new java.sql.Timestamp(normalCustomsPermit.getBalancedDateTime().getTime()));
		} else {
			ps.setNull(27, java.sql.Types.TIMESTAMP);
		}

		if (normalCustomsPermit.getModifiedDateTime() != null) {
			ps.setTimestamp(28, new java.sql.Timestamp(normalCustomsPermit.getModifiedDateTime().getTime()));
		} else {
			ps.setTimestamp(28, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (normalCustomsPermit.getAbilGoodsDescription() != null) {
			ps.setString(29, normalCustomsPermit.getAbilGoodsDescription());
		} else {
			ps.setNull(29, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getStatus() != null) {
			ps.setString(30, normalCustomsPermit.getStatus());
		} else {
			ps.setNull(30, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getStatusBy() != null) {
			ps.setString(31, normalCustomsPermit.getStatusBy());
		} else {
			ps.setNull(31, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getStatusDateTime() != null) {
			ps.setTimestamp(32, new java.sql.Timestamp(normalCustomsPermit.getStatusDateTime().getTime()));
		} else {
			ps.setNull(32, java.sql.Types.TIMESTAMP);
		}

		if (normalCustomsPermit.getRemark() != null) {
			ps.setString(33, normalCustomsPermit.getRemark());
		} else {
			ps.setNull(33, java.sql.Types.VARCHAR);
		}

		if (normalCustomsPermit.getIsEditManual() != null) {
			ps.setInt(34, normalCustomsPermit.getIsEditManual());
		} else {
			ps.setNull(34, java.sql.Types.INTEGER);
		}

		if (normalCustomsPermit.getDestination() != null) {
			ps.setString(35, normalCustomsPermit.getDestination());
		} else {
			ps.setNull(35, java.sql.Types.VARCHAR);
		}

	}

		
	private static NormalCustomsPermit createInstanceFromResultSet(ResultSet rs) throws SQLException {
		NormalCustomsPermit normalCustomsPermit = new NormalCustomsPermit();
		
		Integer col1 = rs.getInt("id");
		normalCustomsPermit.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		normalCustomsPermit.setId2(rs.wasNull() ? null : col2);

		String col3 = rs.getString("declaration_no");
		normalCustomsPermit.setDeclarationNo(rs.wasNull() ? null : col3);

		String col4 = rs.getString("transaction_no");
		normalCustomsPermit.setTransactionNo(rs.wasNull() ? null : col4);

		String col5 = rs.getString("document_type");
		normalCustomsPermit.setDocumentType(rs.wasNull() ? null : col5);

		String col6 = rs.getString("received_control_number");
		normalCustomsPermit.setReceivedControlNumber(rs.wasNull() ? null : col6);

		String col7 = rs.getString("vessel_name");
		normalCustomsPermit.setVesselName(rs.wasNull() ? null : col7);

		String col8 = rs.getString("mawb");
		normalCustomsPermit.setMawb(rs.wasNull() ? null : col8);

		String col9 = rs.getString("hawb");
		normalCustomsPermit.setHawb(rs.wasNull() ? null : col9);

		String col10 = rs.getString("callsign");
		normalCustomsPermit.setCallsign(rs.wasNull() ? null : col10);

		String col11 = rs.getString("flight_no");
		normalCustomsPermit.setFlightNo(rs.wasNull() ? null : col11);

		String col12 = rs.getString("port_of_discharge");
		normalCustomsPermit.setPortOfDischarge(rs.wasNull() ? null : col12);

		String col13 = rs.getString("shed_no");
		normalCustomsPermit.setShedNo(rs.wasNull() ? null : col13);

		java.sql.Timestamp col14 = rs.getTimestamp("flight_date");
		normalCustomsPermit.setFlightDate(rs.wasNull() ? null : new java.util.Date(col14.getTime()));

		String col15 = rs.getString("consignee_name");
		normalCustomsPermit.setConsigneeName(rs.wasNull() ? null : col15);

		String col16 = rs.getString("mark_and_number");
		normalCustomsPermit.setMarkAndNumber(rs.wasNull() ? null : col16);

		Integer col17 = rs.getInt("number_of_package");
		normalCustomsPermit.setNumberOfPackage(rs.wasNull() ? null : col17);

		String col18 = rs.getString("number_of_package_unit");
		normalCustomsPermit.setNumberOfPackageUnit(rs.wasNull() ? null : col18);

		Double col19 = rs.getDouble("gross_weight");
		normalCustomsPermit.setGrossWeight(rs.wasNull() ? null : col19);

		String col20 = rs.getString("gross_weight_unit");
		normalCustomsPermit.setGrossWeightUnit(rs.wasNull() ? null : col20);

		java.sql.Timestamp col21 = rs.getTimestamp("cargo_clearance_date");
		normalCustomsPermit.setCargoClearanceDate(rs.wasNull() ? null : new java.util.Date(col21.getTime()));

		java.sql.Timestamp col22 = rs.getTimestamp("cargo_clearance_time");
		normalCustomsPermit.setCargoClearanceTime(rs.wasNull() ? null : new java.util.Date(col22.getTime()));

		java.sql.Timestamp col23 = rs.getTimestamp("transmit_date");
		normalCustomsPermit.setTransmitDate(rs.wasNull() ? null : new java.util.Date(col23.getTime()));

		java.sql.Timestamp col24 = rs.getTimestamp("transmit_time");
		normalCustomsPermit.setTransmitTime(rs.wasNull() ? null : new java.util.Date(col24.getTime()));

		Integer col25 = rs.getInt("number_of_container");
		normalCustomsPermit.setNumberOfContainer(rs.wasNull() ? null : col25);

		Byte col26 = rs.getByte("balanced");
		normalCustomsPermit.setBalanced(rs.wasNull() ? null : col26);

		java.sql.Timestamp col27 = rs.getTimestamp("balanced_date_time");
		normalCustomsPermit.setBalancedDateTime(rs.wasNull() ? null : new java.util.Date(col27.getTime()));

		java.sql.Timestamp col28 = rs.getTimestamp("modified_date_time");
		normalCustomsPermit.setModifiedDateTime(rs.wasNull() ? null : new java.util.Date(col28.getTime()));

		String col29 = rs.getString("abil_goods_description");
		normalCustomsPermit.setAbilGoodsDescription(rs.wasNull() ? null : col29);

		String col30 = rs.getString("status");
		normalCustomsPermit.setStatus(rs.wasNull() ? null : col30);

		String col31 = rs.getString("status_by");
		normalCustomsPermit.setStatusBy(rs.wasNull() ? null : col31);

		java.sql.Timestamp col32 = rs.getTimestamp("status_date_time");
		normalCustomsPermit.setStatusDateTime(rs.wasNull() ? null : new java.util.Date(col32.getTime()));

		String col33 = rs.getString("remark");
		normalCustomsPermit.setRemark(rs.wasNull() ? null : col33);

		Integer col34 = rs.getInt("is_edit_manual");
		normalCustomsPermit.setIsEditManual(rs.wasNull() ? null : col34);

		String col35 = rs.getString("destination");
		normalCustomsPermit.setDestination(rs.wasNull() ? null : col35);


		return normalCustomsPermit;
	}  

		
	@Override
	public int insert(NormalCustomsPermit normalCustomsPermit) throws DaoException {
		if (normalCustomsPermit == null) {
			throw new DaoException("Cannot insert norm_customs_permit with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into norm_customs_permit(`id`,`id2`,`declaration_no`,`transaction_no`,`document_type`,`received_control_number`,`vessel_name`,`mawb`,`hawb`,`callsign`,`flight_no`,`port_of_discharge`,`shed_no`,`flight_date`,`consignee_name`,`mark_and_number`,`number_of_package`,`number_of_package_unit`,`gross_weight`,`gross_weight_unit`,`cargo_clearance_date`,`cargo_clearance_time`,`transmit_date`,`transmit_time`,`number_of_container`,`balanced`,`balanced_date_time`,`modified_date_time`,`abil_goods_description`,`status`,`status_by`,`status_date_time`,`remark`,`is_edit_manual`,`destination`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            NormalCustomsPermitDaoImpl.setPreparedStatementValues(ps, normalCustomsPermit);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT norm_customs_permit[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from norm_customs_permit");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT norm_customs_permit => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public NormalCustomsPermit findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`declaration_no`,`transaction_no`,`document_type`,`received_control_number`,`vessel_name`,`mawb`,`hawb`,`callsign`,`flight_no`,`port_of_discharge`,`shed_no`,`flight_date`,`consignee_name`,`mark_and_number`,`number_of_package`,`number_of_package_unit`,`gross_weight`,`gross_weight_unit`,`cargo_clearance_date`,`cargo_clearance_time`,`transmit_date`,`transmit_time`,`number_of_container`,`balanced`,`balanced_date_time`,`modified_date_time`,`abil_goods_description`,`status`,`status_by`,`status_date_time`,`remark`,`is_edit_manual`,`destination` from norm_customs_permit where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND norm_customs_permit[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            NormalCustomsPermit instance = null;
            if (rs.next()) {
                instance = NormalCustomsPermitDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(NormalCustomsPermit normalCustomsPermit) throws DaoException {
		if (normalCustomsPermit == null) {
			throw new DaoException("Cannot insert norm_customs_permit with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update norm_customs_permit set `id`=?,`id2`=?,`declaration_no`=?,`transaction_no`=?,`document_type`=?,`received_control_number`=?,`vessel_name`=?,`mawb`=?,`hawb`=?,`callsign`=?,`flight_no`=?,`port_of_discharge`=?,`shed_no`=?,`flight_date`=?,`consignee_name`=?,`mark_and_number`=?,`number_of_package`=?,`number_of_package_unit`=?,`gross_weight`=?,`gross_weight_unit`=?,`cargo_clearance_date`=?,`cargo_clearance_time`=?,`transmit_date`=?,`transmit_time`=?,`number_of_container`=?,`balanced`=?,`balanced_date_time`=?,`modified_date_time`=?,`abil_goods_description`=?,`status`=?,`status_by`=?,`status_date_time`=?,`remark`=?,`is_edit_manual`=?,`destination`=? where id=?");
            NormalCustomsPermitDaoImpl.setPreparedStatementValues(ps, normalCustomsPermit);
            ps.setInt(36, normalCustomsPermit.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE norm_customs_permit[id=" + normalCustomsPermit.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from norm_customs_permit where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE norm_customs_permit[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(NormalCustomsPermitExample normalCustomsPermitExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (NormalCustomsPermitExample.Criteria criteria : normalCustomsPermitExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (NormalCustomsPermitExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (normalCustomsPermitExample.getOrderByClause() != null && !normalCustomsPermitExample.getOrderByClause().isEmpty()) {
			clause += " order by " + normalCustomsPermitExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByNormalCustomsPermitExample(NormalCustomsPermitExample normalCustomsPermitExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = NormalCustomsPermitDaoImpl.buildClause(normalCustomsPermitExample);			
            ResultSet rs = stmt.executeQuery("select" + (normalCustomsPermitExample.isDistinct() ? " distinct " : " ") + "count(*) from norm_customs_permit" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT norm_customs_permit[distinct=" + normalCustomsPermitExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public NormalCustomsPermit findByNormalCustomsPermitExample(NormalCustomsPermitExample normalCustomsPermitExample) throws DaoException {
		List<NormalCustomsPermit> res = this.findAllByNormalCustomsPermitExample(normalCustomsPermitExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<NormalCustomsPermit> findAllByNormalCustomsPermitExample(NormalCustomsPermitExample normalCustomsPermitExample) throws DaoException {
    	return this.findAllByNormalCustomsPermitExample(normalCustomsPermitExample, 0, 2000);
    }
    
    @Override
    public List<NormalCustomsPermit> findAllByNormalCustomsPermitExample(NormalCustomsPermitExample normalCustomsPermitExample, int limit) throws DaoException {
    	return this.findAllByNormalCustomsPermitExample(normalCustomsPermitExample, 0, limit);
    }
    
    @Override
    public List<NormalCustomsPermit> findAllByNormalCustomsPermitExample(NormalCustomsPermitExample normalCustomsPermitExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = NormalCustomsPermitDaoImpl.buildClause(normalCustomsPermitExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND norm_customs_permit[distinct=" + normalCustomsPermitExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (normalCustomsPermitExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`declaration_no`,`transaction_no`,`document_type`,`received_control_number`,`vessel_name`,`mawb`,`hawb`,`callsign`,`flight_no`,`port_of_discharge`,`shed_no`,`flight_date`,`consignee_name`,`mark_and_number`,`number_of_package`,`number_of_package_unit`,`gross_weight`,`gross_weight_unit`,`cargo_clearance_date`,`cargo_clearance_time`,`transmit_date`,`transmit_time`,`number_of_container`,`balanced`,`balanced_date_time`,`modified_date_time`,`abil_goods_description`,`status`,`status_by`,`status_date_time`,`remark`,`is_edit_manual`,`destination` from norm_customs_permit" + clause);

            List<NormalCustomsPermit> list = new ArrayList<NormalCustomsPermit>();
            while (rs.next()) {
                list.add(NormalCustomsPermitDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
