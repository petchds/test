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
import com.tti.accscms.dao.movement.DischargeLogDao;

import com.tti.accscms.domain.movement.DischargeLog;
import com.tti.accscms.domain.movement.DischargeLogExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table discharge_log
 */
public class DischargeLogDaoImpl implements DischargeLogDao {

	private static final Logger logger = LoggerFactory.getLogger(DischargeLogDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, DischargeLog dischargeLog) throws SQLException {
		
		if (dischargeLog.getId() != null) {
			ps.setInt(1, dischargeLog.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (dischargeLog.getId2() != null) {
			ps.setInt(2, dischargeLog.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (dischargeLog.getDeclarationNo() != null) {
			ps.setString(3, dischargeLog.getDeclarationNo());
		} else {
			ps.setNull(3, java.sql.Types.VARCHAR);
		}

		if (dischargeLog.getTransactionNo() != null) {
			ps.setString(4, dischargeLog.getTransactionNo());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (dischargeLog.getDesc() != null) {
			ps.setString(5, dischargeLog.getDesc());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

		if (dischargeLog.getDateTime() != null) {
			ps.setTimestamp(6, new java.sql.Timestamp(dischargeLog.getDateTime().getTime()));
		} else {
			ps.setNull(6, java.sql.Types.TIMESTAMP);
		}

		if (dischargeLog.getUser() != null) {
			ps.setString(7, dischargeLog.getUser());
		} else {
			ps.setNull(7, java.sql.Types.VARCHAR);
		}

	}

		
	private static DischargeLog createInstanceFromResultSet(ResultSet rs) throws SQLException {
		DischargeLog dischargeLog = new DischargeLog();
		
		Integer col1 = rs.getInt("id");
		dischargeLog.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		dischargeLog.setId2(rs.wasNull() ? null : col2);

		String col3 = rs.getString("declaration_no");
		dischargeLog.setDeclarationNo(rs.wasNull() ? null : col3);

		String col4 = rs.getString("transaction_no");
		dischargeLog.setTransactionNo(rs.wasNull() ? null : col4);

		String col5 = rs.getString("desc");
		dischargeLog.setDesc(rs.wasNull() ? null : col5);

		java.sql.Timestamp col6 = rs.getTimestamp("date_time");
		dischargeLog.setDateTime(rs.wasNull() ? null : new java.util.Date(col6.getTime()));

		String col7 = rs.getString("user");
		dischargeLog.setUser(rs.wasNull() ? null : col7);


		return dischargeLog;
	}  

		
	@Override
	public int insert(DischargeLog dischargeLog) throws DaoException {
		if (dischargeLog == null) {
			throw new DaoException("Cannot insert discharge_log with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into discharge_log(`id`,`id2`,`declaration_no`,`transaction_no`,`desc`,`date_time`,`user`) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            DischargeLogDaoImpl.setPreparedStatementValues(ps, dischargeLog);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT discharge_log[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from discharge_log");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT discharge_log => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public DischargeLog findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`declaration_no`,`transaction_no`,`desc`,`date_time`,`user` from discharge_log where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND discharge_log[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            DischargeLog instance = null;
            if (rs.next()) {
                instance = DischargeLogDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(DischargeLog dischargeLog) throws DaoException {
		if (dischargeLog == null) {
			throw new DaoException("Cannot insert discharge_log with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update discharge_log set `id`=?,`id2`=?,`declaration_no`=?,`transaction_no`=?,`desc`=?,`date_time`=?,`user`=? where id=?");
            DischargeLogDaoImpl.setPreparedStatementValues(ps, dischargeLog);
            ps.setInt(8, dischargeLog.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE discharge_log[id=" + dischargeLog.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from discharge_log where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE discharge_log[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(DischargeLogExample dischargeLogExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (DischargeLogExample.Criteria criteria : dischargeLogExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (DischargeLogExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (dischargeLogExample.getOrderByClause() != null && !dischargeLogExample.getOrderByClause().isEmpty()) {
			clause += " order by " + dischargeLogExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByDischargeLogExample(DischargeLogExample dischargeLogExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = DischargeLogDaoImpl.buildClause(dischargeLogExample);			
            ResultSet rs = stmt.executeQuery("select" + (dischargeLogExample.isDistinct() ? " distinct " : " ") + "count(*) from discharge_log" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT discharge_log[distinct=" + dischargeLogExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public DischargeLog findByDischargeLogExample(DischargeLogExample dischargeLogExample) throws DaoException {
		List<DischargeLog> res = this.findAllByDischargeLogExample(dischargeLogExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<DischargeLog> findAllByDischargeLogExample(DischargeLogExample dischargeLogExample) throws DaoException {
    	return this.findAllByDischargeLogExample(dischargeLogExample, 0, 2000);
    }
    
    @Override
    public List<DischargeLog> findAllByDischargeLogExample(DischargeLogExample dischargeLogExample, int limit) throws DaoException {
    	return this.findAllByDischargeLogExample(dischargeLogExample, 0, limit);
    }
    
    @Override
    public List<DischargeLog> findAllByDischargeLogExample(DischargeLogExample dischargeLogExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = DischargeLogDaoImpl.buildClause(dischargeLogExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND discharge_log[distinct=" + dischargeLogExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (dischargeLogExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`declaration_no`,`transaction_no`,`desc`,`date_time`,`user` from discharge_log" + clause);

            List<DischargeLog> list = new ArrayList<DischargeLog>();
            while (rs.next()) {
                list.add(DischargeLogDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
