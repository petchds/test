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
import com.tti.accscms.dao.movement.ChangeFlightDao;

import com.tti.accscms.domain.movement.ChangeFlight;
import com.tti.accscms.domain.movement.ChangeFlightExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table change_flight
 */
public class ChangeFlightDaoImpl implements ChangeFlightDao {

	private static final Logger logger = LoggerFactory.getLogger(ChangeFlightDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, ChangeFlight changeFlight) throws SQLException {
		
		if (changeFlight.getId() != null) {
			ps.setInt(1, changeFlight.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (changeFlight.getId2() != null) {
			ps.setInt(2, changeFlight.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (changeFlight.getDeclarationNo() != null) {
			ps.setString(3, changeFlight.getDeclarationNo());
		} else {
			ps.setNull(3, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getRequestNo() != null) {
			ps.setString(4, changeFlight.getRequestNo());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getOldFlightNo() != null) {
			ps.setString(5, changeFlight.getOldFlightNo());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getOldFlightDate() != null) {
			ps.setTimestamp(6, new java.sql.Timestamp(changeFlight.getOldFlightDate().getTime()));
		} else {
			ps.setNull(6, java.sql.Types.DATE);
		}

		if (changeFlight.getOldMawb() != null) {
			ps.setString(7, changeFlight.getOldMawb());
		} else {
			ps.setNull(7, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getOldHawb() != null) {
			ps.setString(8, changeFlight.getOldHawb());
		} else {
			ps.setNull(8, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getModifiedDateTime() != null) {
			ps.setTimestamp(9, new java.sql.Timestamp(changeFlight.getModifiedDateTime().getTime()));
		} else {
			ps.setTimestamp(9, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (changeFlight.getUser() != null) {
			ps.setString(10, changeFlight.getUser());
		} else {
			ps.setNull(10, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getNewFlightNo() != null) {
			ps.setString(11, changeFlight.getNewFlightNo());
		} else {
			ps.setNull(11, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getNewFlightDate() != null) {
			ps.setTimestamp(12, new java.sql.Timestamp(changeFlight.getNewFlightDate().getTime()));
		} else {
			ps.setNull(12, java.sql.Types.DATE);
		}

		if (changeFlight.getNewMawb() != null) {
			ps.setString(13, changeFlight.getNewMawb());
		} else {
			ps.setNull(13, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getNewHawb() != null) {
			ps.setString(14, changeFlight.getNewHawb());
		} else {
			ps.setNull(14, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getNumberOfPackage() != null) {
			ps.setInt(15, changeFlight.getNumberOfPackage());
		} else {
			ps.setNull(15, java.sql.Types.INTEGER);
		}

		if (changeFlight.getNumberOfPackageUnit() != null) {
			ps.setString(16, changeFlight.getNumberOfPackageUnit());
		} else {
			ps.setNull(16, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getGrossWeight() != null) {
			ps.setDouble(17, changeFlight.getGrossWeight());
		} else {
			ps.setNull(17, java.sql.Types.DOUBLE);
		}

		if (changeFlight.getGrossWeightUnit() != null) {
			ps.setString(18, changeFlight.getGrossWeightUnit());
		} else {
			ps.setNull(18, java.sql.Types.VARCHAR);
		}

		if (changeFlight.getShedNo() != null) {
			ps.setString(19, changeFlight.getShedNo());
		} else {
			ps.setNull(19, java.sql.Types.VARCHAR);
		}

	}

		
	private static ChangeFlight createInstanceFromResultSet(ResultSet rs) throws SQLException {
		ChangeFlight changeFlight = new ChangeFlight();
		
		Integer col1 = rs.getInt("id");
		changeFlight.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		changeFlight.setId2(rs.wasNull() ? null : col2);

		String col3 = rs.getString("declaration_no");
		changeFlight.setDeclarationNo(rs.wasNull() ? null : col3);

		String col4 = rs.getString("request_no");
		changeFlight.setRequestNo(rs.wasNull() ? null : col4);

		String col5 = rs.getString("old_flight_no");
		changeFlight.setOldFlightNo(rs.wasNull() ? null : col5);

		java.sql.Timestamp col6 = rs.getTimestamp("old_flight_date");
		changeFlight.setOldFlightDate(rs.wasNull() ? null : new java.util.Date(col6.getTime()));

		String col7 = rs.getString("old_mawb");
		changeFlight.setOldMawb(rs.wasNull() ? null : col7);

		String col8 = rs.getString("old_hawb");
		changeFlight.setOldHawb(rs.wasNull() ? null : col8);

		java.sql.Timestamp col9 = rs.getTimestamp("modified_date_time");
		changeFlight.setModifiedDateTime(rs.wasNull() ? null : new java.util.Date(col9.getTime()));

		String col10 = rs.getString("user");
		changeFlight.setUser(rs.wasNull() ? null : col10);

		String col11 = rs.getString("new_flight_no");
		changeFlight.setNewFlightNo(rs.wasNull() ? null : col11);

		java.sql.Timestamp col12 = rs.getTimestamp("new_flight_date");
		changeFlight.setNewFlightDate(rs.wasNull() ? null : new java.util.Date(col12.getTime()));

		String col13 = rs.getString("new_mawb");
		changeFlight.setNewMawb(rs.wasNull() ? null : col13);

		String col14 = rs.getString("new_hawb");
		changeFlight.setNewHawb(rs.wasNull() ? null : col14);

		Integer col15 = rs.getInt("number_of_package");
		changeFlight.setNumberOfPackage(rs.wasNull() ? null : col15);

		String col16 = rs.getString("number_of_package_unit");
		changeFlight.setNumberOfPackageUnit(rs.wasNull() ? null : col16);

		Double col17 = rs.getDouble("gross_weight");
		changeFlight.setGrossWeight(rs.wasNull() ? null : col17);

		String col18 = rs.getString("gross_weight_unit");
		changeFlight.setGrossWeightUnit(rs.wasNull() ? null : col18);

		String col19 = rs.getString("shed_no");
		changeFlight.setShedNo(rs.wasNull() ? null : col19);


		return changeFlight;
	}  

		
	@Override
	public int insert(ChangeFlight changeFlight) throws DaoException {
		if (changeFlight == null) {
			throw new DaoException("Cannot insert change_flight with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into change_flight(`id`,`id2`,`declaration_no`,`request_no`,`old_flight_no`,`old_flight_date`,`old_mawb`,`old_hawb`,`modified_date_time`,`user`,`new_flight_no`,`new_flight_date`,`new_mawb`,`new_hawb`,`number_of_package`,`number_of_package_unit`,`gross_weight`,`gross_weight_unit`,`shed_no`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ChangeFlightDaoImpl.setPreparedStatementValues(ps, changeFlight);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT change_flight[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from change_flight");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT change_flight => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public ChangeFlight findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`declaration_no`,`request_no`,`old_flight_no`,`old_flight_date`,`old_mawb`,`old_hawb`,`modified_date_time`,`user`,`new_flight_no`,`new_flight_date`,`new_mawb`,`new_hawb`,`number_of_package`,`number_of_package_unit`,`gross_weight`,`gross_weight_unit`,`shed_no` from change_flight where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND change_flight[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            ChangeFlight instance = null;
            if (rs.next()) {
                instance = ChangeFlightDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(ChangeFlight changeFlight) throws DaoException {
		if (changeFlight == null) {
			throw new DaoException("Cannot insert change_flight with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update change_flight set `id`=?,`id2`=?,`declaration_no`=?,`request_no`=?,`old_flight_no`=?,`old_flight_date`=?,`old_mawb`=?,`old_hawb`=?,`modified_date_time`=?,`user`=?,`new_flight_no`=?,`new_flight_date`=?,`new_mawb`=?,`new_hawb`=?,`number_of_package`=?,`number_of_package_unit`=?,`gross_weight`=?,`gross_weight_unit`=?,`shed_no`=? where id=?");
            ChangeFlightDaoImpl.setPreparedStatementValues(ps, changeFlight);
            ps.setInt(20, changeFlight.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE change_flight[id=" + changeFlight.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from change_flight where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE change_flight[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(ChangeFlightExample changeFlightExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (ChangeFlightExample.Criteria criteria : changeFlightExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (ChangeFlightExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (changeFlightExample.getOrderByClause() != null && !changeFlightExample.getOrderByClause().isEmpty()) {
			clause += " order by " + changeFlightExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByChangeFlightExample(ChangeFlightExample changeFlightExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = ChangeFlightDaoImpl.buildClause(changeFlightExample);			
            ResultSet rs = stmt.executeQuery("select" + (changeFlightExample.isDistinct() ? " distinct " : " ") + "count(*) from change_flight" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT change_flight[distinct=" + changeFlightExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public ChangeFlight findByChangeFlightExample(ChangeFlightExample changeFlightExample) throws DaoException {
		List<ChangeFlight> res = this.findAllByChangeFlightExample(changeFlightExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<ChangeFlight> findAllByChangeFlightExample(ChangeFlightExample changeFlightExample) throws DaoException {
    	return this.findAllByChangeFlightExample(changeFlightExample, 0, 2000);
    }
    
    @Override
    public List<ChangeFlight> findAllByChangeFlightExample(ChangeFlightExample changeFlightExample, int limit) throws DaoException {
    	return this.findAllByChangeFlightExample(changeFlightExample, 0, limit);
    }
    
    @Override
    public List<ChangeFlight> findAllByChangeFlightExample(ChangeFlightExample changeFlightExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = ChangeFlightDaoImpl.buildClause(changeFlightExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND change_flight[distinct=" + changeFlightExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (changeFlightExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`declaration_no`,`request_no`,`old_flight_no`,`old_flight_date`,`old_mawb`,`old_hawb`,`modified_date_time`,`user`,`new_flight_no`,`new_flight_date`,`new_mawb`,`new_hawb`,`number_of_package`,`number_of_package_unit`,`gross_weight`,`gross_weight_unit`,`shed_no` from change_flight" + clause);

            List<ChangeFlight> list = new ArrayList<ChangeFlight>();
            while (rs.next()) {
                list.add(ChangeFlightDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}