package com.bella.brs.model.dao;

import java.util.List;

import com.bella.brs.model.entity.Bus;
import com.bella.brs.model.entity.Route;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 * CRUD operations for bus table.
 * @author Bella Baghdasaryan
 */
public interface BusDAO {
  
  //Read
  public List<Bus> findByRouteAndDate(Route route, String date) throws EmptyResultDataAccessException;

}