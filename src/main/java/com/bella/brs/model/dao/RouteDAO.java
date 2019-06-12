package com.bella.brs.model.dao;

import java.util.List;

import com.bella.brs.model.entity.Route;
import org.springframework.dao.EmptyResultDataAccessException;

//CRUD operations
public interface RouteDAO {

	// Read
	public List<String> findAllOrigins() throws EmptyResultDataAccessException;
	public List<Route> findByOrigin(String origin) throws EmptyResultDataAccessException;

}