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
import com.tti.accscms.dao.movement.ChangeAirportDao;

import com.tti.accscms.domain.movement.ChangeAirport;
import com.tti.accscms.domain.movement.ChangeAirportExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table change_airport
 */
public class ChangeAirportDaoImpl implements ChangeAirportDao {

	private static final Logger logger = LoggerFactory.getLogger(ChangeAirportDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, ChangeAirport changeAirport) throws SQLException {
		
		if (changeAirport.getId() != null) {
			ps.setInt(1, changeAirport.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (changeAirport.getId2() != null) {
			ps.setInt(2, changeAirport.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (changeAirport.getNewMawb() != null) {
			ps.setString(3, changeAirport.getNewMawb());
		} else {
			ps.setNull(3, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getNewHawb() != null) {
			ps.setString(4, changeAirport.getNewHawb());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getNewFlightNo() != null) {
			ps.setString(5, changeAirport.getNewFlightNo());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getNewFlightDate() != null) {
			ps.setTimestamp(6, new java.sql.Timestamp(changeAirport.getNewFlightDate().getTime()));
		} else {
			ps.setNull(6, java.sql.Types.DATE);
		}

		if (changeAirport.getOldMawb() != null) {
			ps.setString(7, changeAirport.getOldMawb());
		} else {
			ps.setNull(7, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getOldHawb() != null) {
			ps.setString(8, changeAirport.getOldHawb());
		} else {
			ps.setNull(8, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getOldFlightNo() != null) {
			ps.setString(9, changeAirport.getOldFlightNo());
		} else {
			ps.setNull(9, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getOldFlightDate() != null) {
			ps.setTimestamp(10, new java.sql.Timestamp(changeAirport.getOldFlightDate().getTime()));
		} else {
			ps.setNull(10, java.sql.Types.DATE);
		}

		if (changeAirport.getNumberOfPackage() != null) {
			ps.setInt(11, changeAirport.getNumberOfPackage());
		} else {
			ps.setNull(11, java.sql.Types.INTEGER);
		}

		if (changeAirport.getGrossWeight() != null) {
			ps.setDouble(12, changeAirport.getGrossWeight());
		} else {
			ps.setNull(12, java.sql.Types.DOUBLE);
		}

		if (changeAirport.getDestination() != null) {
			ps.setString(13, changeAirport.getDestination());
		} else {
			ps.setNull(13, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getModifiedDateTime() != null) {
			ps.setTimestamp(14, new java.sql.Timestamp(changeAirport.getModifiedDateTime().getTime()));
		} else {
			ps.setTimestamp(14, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (changeAirport.getUser() != null) {
			ps.setString(15, changeAirport.getUser());
		} else {
			ps.setNull(15, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getNumberOfPackageUnit() != null) {
			ps.setString(16, changeAirport.getNumberOfPackageUnit());
		} else {
			ps.setNull(16, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getGrossWeightUnit() != null) {
			ps.setString(17, changeAirport.getGrossWeightUnit());
		} else {
			ps.setNull(17, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getGoodsDescription() != null) {
			ps.setString(18, changeAirport.getGoodsDescription());
		} else {
			ps.setNull(18, java.sql.Types.VARCHAR);
		}

		if (changeAirport.getConsigneeName() != null) {
			ps.setString(19, changeAirport.getConsigneeName());
		} else {
			ps.setNull(19, java.sql.Types.VARCHAR);
		}

	}

		
	private static ChangeAirport createInstanceFromResultSet(ResultSet rs) throws SQLException {
		ChangeAirport changeAirport = new ChangeAirport();
		
		Integer col1 = rs.getInt("id");
		changeAirport.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		changeAirport.setId2(rs.wasNull() ? null : col2);

		String col3 = rs.getString("new_mawb");
		changeAirport.setNewMawb(rs.wasNull() ? null : col3);

		String col4 = rs.getString("new_hawb");
		changeAirport.setNewHawb(rs.wasNull() ? null : col4);

		String col5 = rs.getString("new_flight_no");
		changeAirport.setNewFlightNo(rs.wasNull() ? null : col5);

		java.sql.Timestamp col6 = rs.getTimestamp("new_flight_date");
		changeAirport.setNewFlightDate(rs.wasNull() ? null : new java.util.Date(col6.getTime()));

		String col7 = rs.getString("old_mawb");
		changeAirport.setOldMawb(rs.wasNull() ? null : col7);

		String col8 = rs.getString("old_hawb");
		changeAirport.setOldHawb(rs.wasNull() ? null : col8);

		String col9 = rs.getString("old_flight_no");
		changeAirport.setOldFlightNo(rs.wasNull() ? null : col9);

		java.sql.Timestamp col10 = rs.getTimestamp("old_flight_date");
		changeAirport.setOldFlightDate(rs.wasNull() ? null : new java.util.Date(col10.getTime()));

		Integer col11 = rs.getInt("number_of_package");
		changeAirport.setNumberOfPackage(rs.wasNull() ? null : col11);

		Double col12 = rs.getDouble("gross_weight");
		changeAirport.setGrossWeight(rs.wasNull() ? null : col12);

		String col13 = rs.getString("destination");
		changeAirport.setDestination(rs.wasNull() ? null : col13);

		java.sql.Timestamp col14 = rs.getTimestamp("modified_date_time");
		changeAirport.setModifiedDateTime(rs.wasNull() ? null : new java.util.Date(col14.getTime()));

		String col15 = rs.getString("user");
		changeAirport.setUser(rs.wasNull() ? null : col15);

		String col16 = rs.getString("number_of_package_unit");
		changeAirport.setNumberOfPackageUnit(rs.wasNull() ? null : col16);

		String col17 = rs.getString("gross_weight_unit");
		changeAirport.setGrossWeightUnit(rs.wasNull() ? null : col17);

		String col18 = rs.getString("goods_description");
		changeAirport.setGoodsDescription(rs.wasNull() ? null : col18);

		String col19 = rs.getString("consignee_name");
		changeAirport.setConsigneeName(rs.wasNull() ? null : col19);


		return changeAirport;
	}  

		
	@Override
	public int insert(ChangeAirport changeAirport) throws DaoException {
		if (changeAirport == null) {
			throw new DaoException("Cannot insert change_airport with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into change_airport(`id`,`id2`,`new_mawb`,`new_hawb`,`new_flight_no`,`new_flight_date`,`old_mawb`,`old_hawb`,`old_flight_no`,`old_flight_date`,`number_of_package`,`gross_weight`,`destination`,`modified_date_time`,`user`,`number_of_package_unit`,`gross_weight_unit`,`goods_description`,`consignee_name`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ChangeAirportDaoImpl.setPreparedStatementValues(ps, changeAirport);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT change_airport[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from change_airport");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT change_airport => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public ChangeAirport findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`new_mawb`,`new_hawb`,`new_flight_no`,`new_flight_date`,`old_mawb`,`old_hawb`,`old_flight_no`,`old_flight_date`,`number_of_package`,`gross_weight`,`destination`,`modified_date_time`,`user`,`number_of_package_unit`,`gross_weight_unit`,`goods_description`,`consignee_name` from change_airport where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND change_airport[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            ChangeAirport instance = null;
            if (rs.next()) {
                instance = ChangeAirportDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(ChangeAirport changeAirport) throws DaoException {
		if (changeAirport == null) {
			throw new DaoException("Cannot insert change_airport with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update change_airport set `id`=?,`id2`=?,`new_mawb`=?,`new_hawb`=?,`new_flight_no`=?,`new_flight_date`=?,`old_mawb`=?,`old_hawb`=?,`old_flight_no`=?,`old_flight_date`=?,`number_of_package`=?,`gross_weight`=?,`destination`=?,`modified_date_time`=?,`user`=?,`number_of_package_unit`=?,`gross_weight_unit`=?,`goods_description`=?,`consignee_name`=? where id=?");
            ChangeAirportDaoImpl.setPreparedStatementValues(ps, changeAirport);
            ps.setInt(20, changeAirport.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE change_airport[id=" + changeAirport.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from change_airport where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE change_airport[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(ChangeAirportExample changeAirportExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (ChangeAirportExample.Criteria criteria : changeAirportExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (ChangeAirportExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (changeAirportExample.getOrderByClause() != null && !changeAirportExample.getOrderByClause().isEmpty()) {
			clause += " order by " + changeAirportExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByChangeAirportExample(ChangeAirportExample changeAirportExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = ChangeAirportDaoImpl.buildClause(changeAirportExample);			
            ResultSet rs = stmt.executeQuery("select" + (changeAirportExample.isDistinct() ? " distinct " : " ") + "count(*) from change_airport" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT change_airport[distinct=" + changeAirportExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public ChangeAirport findByChangeAirportExample(ChangeAirportExample changeAirportExample) throws DaoException {
		List<ChangeAirport> res = this.findAllByChangeAirportExample(changeAirportExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<ChangeAirport> findAllByChangeAirportExample(ChangeAirportExample changeAirportExample) throws DaoException {
    	return this.findAllByChangeAirportExample(changeAirportExample, 0, 2000);
    }
    
    @Override
    public List<ChangeAirport> findAllByChangeAirportExample(ChangeAirportExample changeAirportExample, int limit) throws DaoException {
    	return this.findAllByChangeAirportExample(changeAirportExample, 0, limit);
    }
    
    @Override
    public List<ChangeAirport> findAllByChangeAirportExample(ChangeAirportExample changeAirportExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = ChangeAirportDaoImpl.buildClause(changeAirportExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND change_airport[distinct=" + changeAirportExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (changeAirportExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`new_mawb`,`new_hawb`,`new_flight_no`,`new_flight_date`,`old_mawb`,`old_hawb`,`old_flight_no`,`old_flight_date`,`number_of_package`,`gross_weight`,`destination`,`modified_date_time`,`user`,`number_of_package_unit`,`gross_weight_unit`,`goods_description`,`consignee_name` from change_airport" + clause);

            List<ChangeAirport> list = new ArrayList<ChangeAirport>();
            while (rs.next()) {
                list.add(ChangeAirportDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
