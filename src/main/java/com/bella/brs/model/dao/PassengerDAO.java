package com.bella.brs.model.dao;

import com.bella.brs.model.entity.Passenger;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 * CRUD operations for passenger table.
 * @author Bella Baghdasaryan
 */
public interface PassengerDAO {
   
  //Create
  public void save(Passenger employee);
  
  //Read
  public Passenger findById(int id) throws EmptyResultDataAccessException;
  public Passenger findByUsername(String username) throws EmptyResultDataAccessException;

}