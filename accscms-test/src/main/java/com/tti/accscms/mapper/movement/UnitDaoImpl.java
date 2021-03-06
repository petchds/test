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
import com.tti.accscms.dao.movement.UnitDao;

import com.tti.accscms.domain.movement.Unit;
import com.tti.accscms.domain.movement.UnitExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table unit
 */
public class UnitDaoImpl implements UnitDao {

	private static final Logger logger = LoggerFactory.getLogger(UnitDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, Unit unit) throws SQLException {
		
		if (unit.getId() != null) {
			ps.setInt(1, unit.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (unit.getId2() != null) {
			ps.setInt(2, unit.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (unit.getModifiedDate() != null) {
			ps.setTimestamp(3, new java.sql.Timestamp(unit.getModifiedDate().getTime()));
		} else {
			ps.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (unit.getName() != null) {
			ps.setString(4, unit.getName());
		} else {
			ps.setNull(4, java.sql.Types.VARCHAR);
		}

		if (unit.getType() != null) {
			ps.setInt(5, unit.getType());
		} else {
			ps.setNull(5, java.sql.Types.INTEGER);
		}

	}

		
	private static Unit createInstanceFromResultSet(ResultSet rs) throws SQLException {
		Unit unit = new Unit();
		
		Integer col1 = rs.getInt("id");
		unit.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		unit.setId2(rs.wasNull() ? null : col2);

		java.sql.Timestamp col3 = rs.getTimestamp("modified_date");
		unit.setModifiedDate(rs.wasNull() ? null : new java.util.Date(col3.getTime()));

		String col4 = rs.getString("name");
		unit.setName(rs.wasNull() ? null : col4);

		Integer col5 = rs.getInt("type");
		unit.setType(rs.wasNull() ? null : col5);


		return unit;
	}  

		
	@Override
	public int insert(Unit unit) throws DaoException {
		if (unit == null) {
			throw new DaoException("Cannot insert unit with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into unit(`id`,`id2`,`modified_date`,`name`,`type`) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            UnitDaoImpl.setPreparedStatementValues(ps, unit);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT unit[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from unit");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT unit => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Unit findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`modified_date`,`name`,`type` from unit where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND unit[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            Unit instance = null;
            if (rs.next()) {
                instance = UnitDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(Unit unit) throws DaoException {
		if (unit == null) {
			throw new DaoException("Cannot insert unit with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update unit set `id`=?,`id2`=?,`modified_date`=?,`name`=?,`type`=? where id=?");
            UnitDaoImpl.setPreparedStatementValues(ps, unit);
            ps.setInt(6, unit.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE unit[id=" + unit.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from unit where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE unit[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(UnitExample unitExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (UnitExample.Criteria criteria : unitExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (UnitExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (unitExample.getOrderByClause() != null && !unitExample.getOrderByClause().isEmpty()) {
			clause += " order by " + unitExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByUnitExample(UnitExample unitExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = UnitDaoImpl.buildClause(unitExample);			
            ResultSet rs = stmt.executeQuery("select" + (unitExample.isDistinct() ? " distinct " : " ") + "count(*) from unit" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT unit[distinct=" + unitExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public Unit findByUnitExample(UnitExample unitExample) throws DaoException {
		List<Unit> res = this.findAllByUnitExample(unitExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<Unit> findAllByUnitExample(UnitExample unitExample) throws DaoException {
    	return this.findAllByUnitExample(unitExample, 0, 2000);
    }
    
    @Override
    public List<Unit> findAllByUnitExample(UnitExample unitExample, int limit) throws DaoException {
    	return this.findAllByUnitExample(unitExample, 0, limit);
    }
    
    @Override
    public List<Unit> findAllByUnitExample(UnitExample unitExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = UnitDaoImpl.buildClause(unitExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND unit[distinct=" + unitExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (unitExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`modified_date`,`name`,`type` from unit" + clause);

            List<Unit> list = new ArrayList<Unit>();
            while (rs.next()) {
                list.add(UnitDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
