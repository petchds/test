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
import com.tti.accscms.dao.movement.ShipmentManualDao;

import com.tti.accscms.domain.movement.ShipmentManual;
import com.tti.accscms.domain.movement.ShipmentManualExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table shp_manual
 */
public class ShipmentManualDaoImpl implements ShipmentManualDao {

	private static final Logger logger = LoggerFactory.getLogger(ShipmentManualDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, ShipmentManual shipmentManual) throws SQLException {
		
		if (shipmentManual.getId() != null) {
			ps.setInt(1, shipmentManual.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (shipmentManual.getId2() != null) {
			ps.setInt(2, shipmentManual.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (shipmentManual.getShedNo() != null) {
			ps.setString(3, shipmentManual.getShedNo());
		} else {
			ps.setNull(3, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getGroupDeclaration() != null) {
			ps.setInt(4, shipmentManual.getGroupDeclaration());
		} else {
			ps.setNull(4, java.sql.Types.INTEGER);
		}

		if (shipmentManual.getDeclarationNo() != null) {
			ps.setString(5, shipmentManual.getDeclarationNo());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getMawb() != null) {
			ps.setString(6, shipmentManual.getMawb());
		} else {
			ps.setNull(6, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getHawb() != null) {
			ps.setString(7, shipmentManual.getHawb());
		} else {
			ps.setNull(7, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getFlightNo() != null) {
			ps.setString(8, shipmentManual.getFlightNo());
		} else {
			ps.setNull(8, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getOutFzDateTime() != null) {
			ps.setTimestamp(9, new java.sql.Timestamp(shipmentManual.getOutFzDateTime().getTime()));
		} else {
			ps.setNull(9, java.sql.Types.TIMESTAMP);
		}

		if (shipmentManual.getFlightDate() != null) {
			ps.setTimestamp(10, new java.sql.Timestamp(shipmentManual.getFlightDate().getTime()));
		} else {
			ps.setNull(10, java.sql.Types.DATE);
		}

		if (shipmentManual.getNumberOfPackage() != null) {
			ps.setInt(11, shipmentManual.getNumberOfPackage());
		} else {
			ps.setNull(11, java.sql.Types.INTEGER);
		}

		if (shipmentManual.getGrossWeight() != null) {
			ps.setDouble(12, shipmentManual.getGrossWeight());
		} else {
			ps.setNull(12, java.sql.Types.DOUBLE);
		}

		if (shipmentManual.getNumberOfPackageUnit() != null) {
			ps.setString(13, shipmentManual.getNumberOfPackageUnit());
		} else {
			ps.setNull(13, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getGrossWeightUnit() != null) {
			ps.setString(14, shipmentManual.getGrossWeightUnit());
		} else {
			ps.setNull(14, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getGoodsDescription() != null) {
			ps.setString(15, shipmentManual.getGoodsDescription());
		} else {
			ps.setNull(15, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getConsigneeName() != null) {
			ps.setString(16, shipmentManual.getConsigneeName());
		} else {
			ps.setNull(16, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getCompanyType() != null) {
			ps.setString(17, shipmentManual.getCompanyType());
		} else {
			ps.setNull(17, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getCompanyCode() != null) {
			ps.setString(18, shipmentManual.getCompanyCode());
		} else {
			ps.setNull(18, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getAbilDetailId() != null) {
			ps.setInt(19, shipmentManual.getAbilDetailId());
		} else {
			ps.setNull(19, java.sql.Types.INTEGER);
		}

		if (shipmentManual.getUser() != null) {
			ps.setString(20, shipmentManual.getUser());
		} else {
			ps.setNull(20, java.sql.Types.VARCHAR);
		}

		if (shipmentManual.getModifiedDateTime() != null) {
			ps.setTimestamp(21, new java.sql.Timestamp(shipmentManual.getModifiedDateTime().getTime()));
		} else {
			ps.setTimestamp(21, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (shipmentManual.getBalanced() != null) {
			ps.setByte(22, shipmentManual.getBalanced());
		} else {
			ps.setNull(22, java.sql.Types.TINYINT);
		}

		if (shipmentManual.getBalancedDateTime() != null) {
			ps.setTimestamp(23, new java.sql.Timestamp(shipmentManual.getBalancedDateTime().getTime()));
		} else {
			ps.setNull(23, java.sql.Types.TIMESTAMP);
		}

	}

		
	private static ShipmentManual createInstanceFromResultSet(ResultSet rs) throws SQLException {
		ShipmentManual shipmentManual = new ShipmentManual();
		
		Integer col1 = rs.getInt("id");
		shipmentManual.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		shipmentManual.setId2(rs.wasNull() ? null : col2);

		String col3 = rs.getString("shed_no");
		shipmentManual.setShedNo(rs.wasNull() ? null : col3);

		Integer col4 = rs.getInt("group_declaration");
		shipmentManual.setGroupDeclaration(rs.wasNull() ? null : col4);

		String col5 = rs.getString("declaration_no");
		shipmentManual.setDeclarationNo(rs.wasNull() ? null : col5);

		String col6 = rs.getString("mawb");
		shipmentManual.setMawb(rs.wasNull() ? null : col6);

		String col7 = rs.getString("hawb");
		shipmentManual.setHawb(rs.wasNull() ? null : col7);

		String col8 = rs.getString("flight_no");
		shipmentManual.setFlightNo(rs.wasNull() ? null : col8);

		java.sql.Timestamp col9 = rs.getTimestamp("out_fz_date_time");
		shipmentManual.setOutFzDateTime(rs.wasNull() ? null : new java.util.Date(col9.getTime()));

		java.sql.Timestamp col10 = rs.getTimestamp("flight_date");
		shipmentManual.setFlightDate(rs.wasNull() ? null : new java.util.Date(col10.getTime()));

		Integer col11 = rs.getInt("number_of_package");
		shipmentManual.setNumberOfPackage(rs.wasNull() ? null : col11);

		Double col12 = rs.getDouble("gross_weight");
		shipmentManual.setGrossWeight(rs.wasNull() ? null : col12);

		String col13 = rs.getString("number_of_package_unit");
		shipmentManual.setNumberOfPackageUnit(rs.wasNull() ? null : col13);

		String col14 = rs.getString("gross_weight_unit");
		shipmentManual.setGrossWeightUnit(rs.wasNull() ? null : col14);

		String col15 = rs.getString("goods_description");
		shipmentManual.setGoodsDescription(rs.wasNull() ? null : col15);

		String col16 = rs.getString("consignee_name");
		shipmentManual.setConsigneeName(rs.wasNull() ? null : col16);

		String col17 = rs.getString("company_type");
		shipmentManual.setCompanyType(rs.wasNull() ? null : col17);

		String col18 = rs.getString("company_code");
		shipmentManual.setCompanyCode(rs.wasNull() ? null : col18);

		Integer col19 = rs.getInt("abil_detail_id");
		shipmentManual.setAbilDetailId(rs.wasNull() ? null : col19);

		String col20 = rs.getString("user");
		shipmentManual.setUser(rs.wasNull() ? null : col20);

		java.sql.Timestamp col21 = rs.getTimestamp("modified_date_time");
		shipmentManual.setModifiedDateTime(rs.wasNull() ? null : new java.util.Date(col21.getTime()));

		Byte col22 = rs.getByte("balanced");
		shipmentManual.setBalanced(rs.wasNull() ? null : col22);

		java.sql.Timestamp col23 = rs.getTimestamp("balanced_date_time");
		shipmentManual.setBalancedDateTime(rs.wasNull() ? null : new java.util.Date(col23.getTime()));


		return shipmentManual;
	}  

		
	@Override
	public int insert(ShipmentManual shipmentManual) throws DaoException {
		if (shipmentManual == null) {
			throw new DaoException("Cannot insert shp_manual with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into shp_manual(`id`,`id2`,`shed_no`,`group_declaration`,`declaration_no`,`mawb`,`hawb`,`flight_no`,`out_fz_date_time`,`flight_date`,`number_of_package`,`gross_weight`,`number_of_package_unit`,`gross_weight_unit`,`goods_description`,`consignee_name`,`company_type`,`company_code`,`abil_detail_id`,`user`,`modified_date_time`,`balanced`,`balanced_date_time`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ShipmentManualDaoImpl.setPreparedStatementValues(ps, shipmentManual);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT shp_manual[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from shp_manual");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT shp_manual => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public ShipmentManual findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`shed_no`,`group_declaration`,`declaration_no`,`mawb`,`hawb`,`flight_no`,`out_fz_date_time`,`flight_date`,`number_of_package`,`gross_weight`,`number_of_package_unit`,`gross_weight_unit`,`goods_description`,`consignee_name`,`company_type`,`company_code`,`abil_detail_id`,`user`,`modified_date_time`,`balanced`,`balanced_date_time` from shp_manual where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND shp_manual[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            ShipmentManual instance = null;
            if (rs.next()) {
                instance = ShipmentManualDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(ShipmentManual shipmentManual) throws DaoException {
		if (shipmentManual == null) {
			throw new DaoException("Cannot insert shp_manual with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update shp_manual set `id`=?,`id2`=?,`shed_no`=?,`group_declaration`=?,`declaration_no`=?,`mawb`=?,`hawb`=?,`flight_no`=?,`out_fz_date_time`=?,`flight_date`=?,`number_of_package`=?,`gross_weight`=?,`number_of_package_unit`=?,`gross_weight_unit`=?,`goods_description`=?,`consignee_name`=?,`company_type`=?,`company_code`=?,`abil_detail_id`=?,`user`=?,`modified_date_time`=?,`balanced`=?,`balanced_date_time`=? where id=?");
            ShipmentManualDaoImpl.setPreparedStatementValues(ps, shipmentManual);
            ps.setInt(24, shipmentManual.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE shp_manual[id=" + shipmentManual.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from shp_manual where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE shp_manual[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(ShipmentManualExample shipmentManualExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (ShipmentManualExample.Criteria criteria : shipmentManualExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (ShipmentManualExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (shipmentManualExample.getOrderByClause() != null && !shipmentManualExample.getOrderByClause().isEmpty()) {
			clause += " order by " + shipmentManualExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByShipmentManualExample(ShipmentManualExample shipmentManualExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = ShipmentManualDaoImpl.buildClause(shipmentManualExample);			
            ResultSet rs = stmt.executeQuery("select" + (shipmentManualExample.isDistinct() ? " distinct " : " ") + "count(*) from shp_manual" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT shp_manual[distinct=" + shipmentManualExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public ShipmentManual findByShipmentManualExample(ShipmentManualExample shipmentManualExample) throws DaoException {
		List<ShipmentManual> res = this.findAllByShipmentManualExample(shipmentManualExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<ShipmentManual> findAllByShipmentManualExample(ShipmentManualExample shipmentManualExample) throws DaoException {
    	return this.findAllByShipmentManualExample(shipmentManualExample, 0, 2000);
    }
    
    @Override
    public List<ShipmentManual> findAllByShipmentManualExample(ShipmentManualExample shipmentManualExample, int limit) throws DaoException {
    	return this.findAllByShipmentManualExample(shipmentManualExample, 0, limit);
    }
    
    @Override
    public List<ShipmentManual> findAllByShipmentManualExample(ShipmentManualExample shipmentManualExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = ShipmentManualDaoImpl.buildClause(shipmentManualExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND shp_manual[distinct=" + shipmentManualExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (shipmentManualExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`shed_no`,`group_declaration`,`declaration_no`,`mawb`,`hawb`,`flight_no`,`out_fz_date_time`,`flight_date`,`number_of_package`,`gross_weight`,`number_of_package_unit`,`gross_weight_unit`,`goods_description`,`consignee_name`,`company_type`,`company_code`,`abil_detail_id`,`user`,`modified_date_time`,`balanced`,`balanced_date_time` from shp_manual" + clause);

            List<ShipmentManual> list = new ArrayList<ShipmentManual>();
            while (rs.next()) {
                list.add(ShipmentManualDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}