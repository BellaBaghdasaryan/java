package com.bella.brs.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bella.brs.model.entity.Route;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * @author Bella Baghdasaryan
 */
public class RouteDAOImpl extends BaseDAO implements RouteDAO {
	
	public RouteDAOImpl(){
		this.table = Route.indentity;
	}

	public List<String> findAllOrigins() throws EmptyResultDataAccessException{
		String query = "SELECT DISTINCT(ORIGIN) FROM ROUTE WHERE ID IN (SELECT ROUTEID FROM BUS)";
		
		List<Map<String, Object>> rows = 
				getJdbcTemplate().queryForList(query);
		
		List<String> origins = new ArrayList<String>();
		for (Map<String, Object> row : rows) {
			origins.add((String)row.get("ORIGIN"));
		}
		
		return origins;
	}
	
	public List<Route> findByOrigin(String origin) throws EmptyResultDataAccessException{
		String query = "SELECT * FROM ROUTE"+
						" WHERE ORIGIN = ? AND ID IN (SELECT ROUTEID FROM BUS)";
		
		List<Route> routes = getJdbcTemplate().query(query,
				new Object[] { origin },
				new BeanPropertyRowMapper<Route>(Route.class));
		
		return routes;
	}
}