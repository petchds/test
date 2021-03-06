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
import com.tti.accscms.dao.movement.AirportDao;

import com.tti.accscms.domain.movement.Airport;
import com.tti.accscms.domain.movement.AirportExample;

/**
 * This class was generated by Generator.
 * This class corresponds to the database table airport
 */
public class AirportDaoImpl implements AirportDao {

	private static final Logger logger = LoggerFactory.getLogger(AirportDaoImpl.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    }
		
	private static void setPreparedStatementValues(PreparedStatement ps, Airport airport) throws SQLException {
		
		if (airport.getId() != null) {
			ps.setInt(1, airport.getId());
		} else {
			ps.setNull(1, java.sql.Types.INTEGER);
		}

		if (airport.getId2() != null) {
			ps.setInt(2, airport.getId2());
		} else {
			ps.setNull(2, java.sql.Types.INTEGER);
		}

		if (airport.getName() != null) {
			ps.setString(3, airport.getName());
		} else {
			ps.setNull(3, java.sql.Types.VARCHAR);
		}

		if (airport.getModifiedDate() != null) {
			ps.setTimestamp(4, new java.sql.Timestamp(airport.getModifiedDate().getTime()));
		} else {
			ps.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
		}

		if (airport.getUser() != null) {
			ps.setString(5, airport.getUser());
		} else {
			ps.setNull(5, java.sql.Types.VARCHAR);
		}

	}

		
	private static Airport createInstanceFromResultSet(ResultSet rs) throws SQLException {
		Airport airport = new Airport();
		
		Integer col1 = rs.getInt("id");
		airport.setId(rs.wasNull() ? null : col1);

		Integer col2 = rs.getInt("id2");
		airport.setId2(rs.wasNull() ? null : col2);

		String col3 = rs.getString("name");
		airport.setName(rs.wasNull() ? null : col3);

		java.sql.Timestamp col4 = rs.getTimestamp("modified_date");
		airport.setModifiedDate(rs.wasNull() ? null : new java.util.Date(col4.getTime()));

		String col5 = rs.getString("user");
		airport.setUser(rs.wasNull() ? null : col5);


		return airport;
	}  

		
	@Override
	public int insert(Airport airport) throws DaoException {
		if (airport == null) {
			throw new DaoException("Cannot insert airport with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("insert into airport(`id`,`id2`,`name`,`modified_date`,`user`) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            AirportDaoImpl.setPreparedStatementValues(ps, airport);
			ps.setNull(1, java.sql.Types.INTEGER);
            ps.execute();
			int id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			ps.close();

			logger.info("DB:INSERT airport[id=" + id + "]");

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
			ResultSet rs = stmt.executeQuery("select count(*) from airport");
			
			int count = -1;
			if (rs.next()) { 
				count = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			
			logger.debug("DB:COUNT airport => " + count);
			
			return count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Airport findById(Integer id) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("select `id`,`id2`,`name`,`modified_date`,`user` from airport where id=?");
            ps.setInt(1, id);
            
            logger.debug("DB:FIND airport[id=" + id + "]");

            ResultSet rs = ps.executeQuery();
            Airport instance = null;
            if (rs.next()) {
                instance = AirportDaoImpl.createInstanceFromResultSet(rs);
            }
            rs.close();
            ps.close();

            return instance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int update(Airport airport) throws DaoException {
		if (airport == null) {
			throw new DaoException("Cannot insert airport with null value.");
		}
		
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("update airport set `id`=?,`id2`=?,`name`=?,`modified_date`=?,`user`=? where id=?");
            AirportDaoImpl.setPreparedStatementValues(ps, airport);
            ps.setInt(6, airport.getId());
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:UPDATE airport[id=" + airport.getId() + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public int deleteById(Integer id) throws DaoException {
		 try {
		 	Connection conn = DataSourceUtils.doGetConnection(dataSource);
            PreparedStatement ps = conn.prepareStatement("delete from airport where id=?");
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            ps.close();
            
            logger.info("DB:DELETE airport[id=" + id + "] => " + count);

            return count;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
	}

	
		
	private static String buildClause(AirportExample airportExample) {
		StringBuilder builder = new StringBuilder();
		boolean firstO = true;
		for (AirportExample.Criteria criteria : airportExample.getOredCriteria()) {
			if (firstO) {
				firstO = false;
			} else {
				builder.append(" or ");
			}
			
			if (criteria.isValid()) {
				builder.append('(');
				boolean first = true;
				for (AirportExample.Criterion criterion : criteria.getAllCriteria()) {
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
		
		if (airportExample.getOrderByClause() != null && !airportExample.getOrderByClause().isEmpty()) {
			clause += " order by " + airportExample.getOrderByClause();
		}
		
		return clause;
	}
	
	@Override
	public int countByAirportExample(AirportExample airportExample) throws DaoException {
		try {
			Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();

			String clause = AirportDaoImpl.buildClause(airportExample);			
            ResultSet rs = stmt.executeQuery("select" + (airportExample.isDistinct() ? " distinct " : " ") + "count(*) from airport" + clause);
            int count = -1;
            if (rs.next()) {
            	count = rs.getInt(1);
           	}
            rs.close();
            stmt.close();
            
            logger.debug("DB:COUNT airport[distinct=" + airportExample.isDistinct() + ",clause=" + clause + "] => " + count);

            return count;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}
	
	@Override
	public Airport findByAirportExample(AirportExample airportExample) throws DaoException {
		List<Airport> res = this.findAllByAirportExample(airportExample, 0, 1);
		if (res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}
	
	@Override
    public List<Airport> findAllByAirportExample(AirportExample airportExample) throws DaoException {
    	return this.findAllByAirportExample(airportExample, 0, 2000);
    }
    
    @Override
    public List<Airport> findAllByAirportExample(AirportExample airportExample, int limit) throws DaoException {
    	return this.findAllByAirportExample(airportExample, 0, limit);
    }
    
    @Override
    public List<Airport> findAllByAirportExample(AirportExample airportExample, int offset, int limit) throws DaoException {
    	try {
    		Connection conn = DataSourceUtils.doGetConnection(dataSource);
            Statement stmt = conn.createStatement();
            String clause = AirportDaoImpl.buildClause(airportExample) + " limit " + offset + "," + limit;
            
            logger.debug("DB:FIND airport[distinct=" + airportExample.isDistinct() + ",clause=" + clause + "]");
            
            ResultSet rs = stmt.executeQuery("select" + (airportExample.isDistinct() ? " distinct " : " ") + "`id`,`id2`,`name`,`modified_date`,`user` from airport" + clause);

            List<Airport> list = new ArrayList<Airport>();
            while (rs.next()) {
                list.add(AirportDaoImpl.createInstanceFromResultSet(rs));
            }
            rs.close();
            stmt.close();

            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
