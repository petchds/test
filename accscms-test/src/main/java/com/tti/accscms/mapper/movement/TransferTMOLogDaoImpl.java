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
import com.tti.accscms.dao.movement.TransferTMOLogDao;

import com.tti.accscms.domain.movement.TransferTMOLog;
import com.tti.accscms.domain.movement.TransferTMOLogExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table transfer_tmo_log
 */
public class TransferTMOLogDaoImpl implements TransferTMOLogDao {

	private static final Logger logger = LoggerFactory.getLogger(TransferTMOLogDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, TransferTMOLog transferTMOLog) throws SQLException {
		
		if (transferTMOLog.getId() != null) {
			ps.setInt(1, transferTMOLog.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (transferTMOLog.getId2() != null) {
			ps.setInt(2, transferTMOLog.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (transferTMOLog.getDeclarationNo() != null) {
			ps.setString(3, transferTMOLog.getDeclarationNo());
		} else {
			ps.setNull(3, java.sql.Types.VARCHAR);
		}

		if (transferTMOLog.getDesc() != null) {
			ps.setString(4, transferTMOLog.getDesc());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (transferTMOLog.getDateTime() != null) {
			ps.setTimestamp(5, new java.sql.Timestamp(transferTMOLog.getDateTime().getTime()));
		} else {
			ps.setNull(5, java.sql.Types.TIMESTAMP);
		}

		if (transferTMOLog.getUser() != null) {
			ps.setString(6, transferTMOLog.getUser());
		} else {
			ps.setNull(6, java.sql.Types.VARCHAR);
		}

	}

		
	private static TransferTMOLog createInstanceFromResultSet(ResultSet rs) throws SQLException {
		TransferTMOLog transferTMOLog = new TransferTMOLog();
		
		Integer col1 = rs.getInt("id");
		transferTMOLog.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		transferTMOLog.setId2(rs.wasNull() ? null : col2);

		String col3 = rs.getString("declaration_no");
		transferTMOLog.setDeclarationNo(rs.wasNull() ? null : col3);

		String col4 = rs.getString("desc");
		transferTMOLog.setDesc(rs.wasNull() ? null : col4);

		java.sql.Timestamp col5 = rs.getTimestamp("date_time");
		transferTMOLog.setDateTime(rs.wasNull() ? null : new java.util.Date(col5.getTime()));

		String col6 = rs.getString("user");
		transferTMOLog.setUser(rs.wasNull() ? null : col6);


		return transferTMOLog;
	}  

		
	@Override
	public int insert(TransferTMOLog transferTMOLog) throws DaoException {
		if (transferTMOLog == null) {
			throw new DaoException("Cannot insert transfer_tmo_log with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into transfer_tmo_log(`id`,`id2`,`declaration_no`,`desc`,`date_time`,`user`) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            TransferTMOLogDaoImpl.setPreparedStatementValues(ps, transferTMOLog);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT transfer_tmo_log[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from transfer_tmo_log");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT transfer_tmo_log => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public TransferTMOLog findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`declaration_no`,`desc`,`date_time`,`user` from transfer_tmo_log where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND transfer_tmo_log[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            TransferTMOLog instance = null;
            if (rs.next()) {
                instance = TransferTMOLogDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(TransferTMOLog transferTMOLog) throws DaoException {
		if (transferTMOLog == null) {
			throw new DaoException("Cannot insert transfer_tmo_log with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update transfer_tmo_log set `id`=?,`id2`=?,`declaration_no`=?,`desc`=?,`date_time`=?,`user`=? where id=?");
            TransferTMOLogDaoImpl.setPreparedStatementValues(ps, transferTMOLog);
            ps.setInt(7, transferTMOLog.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE transfer_tmo_log[id=" + transferTMOLog.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from transfer_tmo_log where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE transfer_tmo_log[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(TransferTMOLogExample transferTMOLogExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (TransferTMOLogExample.Criteria criteria : transferTMOLogExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (TransferTMOLogExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (transferTMOLogExample.getOrderByClause() != null && !transferTMOLogExample.getOrderByClause().isEmpty()) {
			clause += " order by " + transferTMOLogExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByTransferTMOLogExample(TransferTMOLogExample transferTMOLogExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = TransferTMOLogDaoImpl.buildClause(transferTMOLogExample);			
            ResultSet rs = stmt.executeQuery("select" + (transferTMOLogExample.isDistinct() ? " distinct " : " ") + "count(*) from transfer_tmo_log" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT transfer_tmo_log[distinct=" + transferTMOLogExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public TransferTMOLog findByTransferTMOLogExample(TransferTMOLogExample transferTMOLogExample) throws DaoException {
		List<TransferTMOLog> res = this.findAllByTransferTMOLogExample(transferTMOLogExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<TransferTMOLog> findAllByTransferTMOLogExample(TransferTMOLogExample transferTMOLogExample) throws DaoException {
    	return this.findAllByTransferTMOLogExample(transferTMOLogExample, 0, 2000);
    }
    
    @Override
    public List<TransferTMOLog> findAllByTransferTMOLogExample(TransferTMOLogExample transferTMOLogExample, int limit) throws DaoException {
    	return this.findAllByTransferTMOLogExample(transferTMOLogExample, 0, limit);
    }
    
    @Override
    public List<TransferTMOLog> findAllByTransferTMOLogExample(TransferTMOLogExample transferTMOLogExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = TransferTMOLogDaoImpl.buildClause(transferTMOLogExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND transfer_tmo_log[distinct=" + transferTMOLogExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (transferTMOLogExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`declaration_no`,`desc`,`date_time`,`user` from transfer_tmo_log" + clause);

            List<TransferTMOLog> list = new ArrayList<TransferTMOLog>();
            while (rs.next()) {
                list.add(TransferTMOLogDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}