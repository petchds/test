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
import com.tti.accscms.dao.movement.AutoBlockProfileConditionDao;

import com.tti.accscms.domain.movement.AutoBlockProfileCondition;
import com.tti.accscms.domain.movement.AutoBlockProfileConditionExample;
import com.tti.accscms.domain.movement.AutoBlockProfile;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table auto_block_profile_condition
 */
public class AutoBlockProfileConditionDaoImpl implements AutoBlockProfileConditionDao {

	private static final Logger logger = LoggerFactory.getLogger(AutoBlockProfileConditionDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, AutoBlockProfileCondition autoBlockProfileCondition) throws SQLException {
		
		if (autoBlockProfileCondition.getId() != null) {
			ps.setInt(1, autoBlockProfileCondition.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (autoBlockProfileCondition.getId2() != null) {
			ps.setInt(2, autoBlockProfileCondition.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (autoBlockProfileCondition.getProfileId() != null) {
			ps.setInt(3, autoBlockProfileCondition.getProfileId());
		} else {
			ps.setNull(3, java.sql.Types.INTEGER);
		}

		if (autoBlockProfileCondition.getFieldName() != null) {
			ps.setString(4, autoBlockProfileCondition.getFieldName());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (autoBlockProfileCondition.getConditionS() != null) {
			ps.setString(5, autoBlockProfileCondition.getConditionS());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (autoBlockProfileCondition.getValue() != null) {
			ps.setString(6, autoBlockProfileCondition.getValue());
		} else {
			ps.setNull(6, java.sql.Types.VARCHAR);
		}

		if (autoBlockProfileCondition.getModifiedDateTime() != null) {
			ps.setTimestamp(7, new java.sql.Timestamp(autoBlockProfileCondition.getModifiedDateTime().getTime()));
		} else {
			ps.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis()));
		}

	}

		
	private static AutoBlockProfileCondition createInstanceFromResultSet(ResultSet rs) throws SQLException {
		AutoBlockProfileCondition autoBlockProfileCondition = new AutoBlockProfileCondition();
		
		Integer col1 = rs.getInt("id");
		autoBlockProfileCondition.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		autoBlockProfileCondition.setId2(rs.wasNull() ? null : col2);

		Integer col3 = rs.getInt("profile_id");
		autoBlockProfileCondition.setProfileId(rs.wasNull() ? null : col3);

		String col4 = rs.getString("field_name");
		autoBlockProfileCondition.setFieldName(rs.wasNull() ? null : col4);

		String col5 = rs.getString("condition_s");
		autoBlockProfileCondition.setConditionS(rs.wasNull() ? null : col5);

		String col6 = rs.getString("value");
		autoBlockProfileCondition.setValue(rs.wasNull() ? null : col6);

		java.sql.Timestamp col7 = rs.getTimestamp("modified_date_time");
		autoBlockProfileCondition.setModifiedDateTime(rs.wasNull() ? null : new java.util.Date(col7.getTime()));


		return autoBlockProfileCondition;
	}  

		
	@Override
	public int insert(AutoBlockProfileCondition autoBlockProfileCondition) throws DaoException {
		if (autoBlockProfileCondition == null) {
			throw new DaoException("Cannot insert auto_block_profile_condition with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into auto_block_profile_condition(`id`,`id2`,`profile_id`,`field_name`,`condition_s`,`value`,`modified_date_time`) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            AutoBlockProfileConditionDaoImpl.setPreparedStatementValues(ps, autoBlockProfileCondition);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT auto_block_profile_condition[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from auto_block_profile_condition");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT auto_block_profile_condition => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public AutoBlockProfileCondition findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`profile_id`,`field_name`,`condition_s`,`value`,`modified_date_time` from auto_block_profile_condition where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND auto_block_profile_condition[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            AutoBlockProfileCondition instance = null;
            if (rs.next()) {
                instance = AutoBlockProfileConditionDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(AutoBlockProfileCondition autoBlockProfileCondition) throws DaoException {
		if (autoBlockProfileCondition == null) {
			throw new DaoException("Cannot insert auto_block_profile_condition with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update auto_block_profile_condition set `id`=?,`id2`=?,`profile_id`=?,`field_name`=?,`condition_s`=?,`value`=?,`modified_date_time`=? where id=?");
            AutoBlockProfileConditionDaoImpl.setPreparedStatementValues(ps, autoBlockProfileCondition);
            ps.setInt(8, autoBlockProfileCondition.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE auto_block_profile_condition[id=" + autoBlockProfileCondition.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from auto_block_profile_condition where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE auto_block_profile_condition[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
	@Override
	public List<AutoBlockProfileCondition> findAllByAutoBlockProfile(AutoBlockProfile autoBlockProfile) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = null;
            if (autoBlockProfile == null || autoBlockProfile.getId() == null) {
            	ps = conn.prepareStatement("select `id`,`id2`,`profile_id`,`field_name`,`condition_s`,`value`,`modified_date_time` from auto_block_profile_condition where profile_id=null");
            } else {
            	ps = conn.prepareStatement("select `id`,`id2`,`profile_id`,`field_name`,`condition_s`,`value`,`modified_date_time` from auto_block_profile_condition where profile_id=?");
            	ps.setInt(1, autoBlockProfile.getId());
            }
            
            logger.debug("DB:FIND auto_block_profile_condition[profile_id=" + (autoBlockProfile != null ? autoBlockProfile.getId() : "null") + "]");
            
            ResultSet rs = ps.executeQuery();

            List<AutoBlockProfileCondition> list = new ArrayList<AutoBlockProfileCondition>();
            while (rs.next()) {
                list.add(AutoBlockProfileConditionDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            ps.close();

            return list;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

		
	private static String buildClause(AutoBlockProfileConditionExample autoBlockProfileConditionExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (AutoBlockProfileConditionExample.Criteria criteria : autoBlockProfileConditionExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (AutoBlockProfileConditionExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (autoBlockProfileConditionExample.getOrderByClause() != null && !autoBlockProfileConditionExample.getOrderByClause().isEmpty()) {
			clause += " order by " + autoBlockProfileConditionExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByAutoBlockProfileConditionExample(AutoBlockProfileConditionExample autoBlockProfileConditionExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = AutoBlockProfileConditionDaoImpl.buildClause(autoBlockProfileConditionExample);			
            ResultSet rs = stmt.executeQuery("select" + (autoBlockProfileConditionExample.isDistinct() ? " distinct " : " ") + "count(*) from auto_block_profile_condition" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT auto_block_profile_condition[distinct=" + autoBlockProfileConditionExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public AutoBlockProfileCondition findByAutoBlockProfileConditionExample(AutoBlockProfileConditionExample autoBlockProfileConditionExample) throws DaoException {
		List<AutoBlockProfileCondition> res = this.findAllByAutoBlockProfileConditionExample(autoBlockProfileConditionExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<AutoBlockProfileCondition> findAllByAutoBlockProfileConditionExample(AutoBlockProfileConditionExample autoBlockProfileConditionExample) throws DaoException {
    	return this.findAllByAutoBlockProfileConditionExample(autoBlockProfileConditionExample, 0, 2000);
    }
    
    @Override
    public List<AutoBlockProfileCondition> findAllByAutoBlockProfileConditionExample(AutoBlockProfileConditionExample autoBlockProfileConditionExample, int limit) throws DaoException {
    	return this.findAllByAutoBlockProfileConditionExample(autoBlockProfileConditionExample, 0, limit);
    }
    
    @Override
    public List<AutoBlockProfileCondition> findAllByAutoBlockProfileConditionExample(AutoBlockProfileConditionExample autoBlockProfileConditionExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = AutoBlockProfileConditionDaoImpl.buildClause(autoBlockProfileConditionExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND auto_block_profile_condition[distinct=" + autoBlockProfileConditionExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (autoBlockProfileConditionExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`profile_id`,`field_name`,`condition_s`,`value`,`modified_date_time` from auto_block_profile_condition" + clause);

            List<AutoBlockProfileCondition> list = new ArrayList<AutoBlockProfileCondition>();
            while (rs.next()) {
                list.add(AutoBlockProfileConditionDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
