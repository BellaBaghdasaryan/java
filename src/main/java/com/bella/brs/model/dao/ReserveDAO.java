package com.bella.brs.model.dao;

import java.util.List;

import com.bella.brs.model.entity.Reserve;
import org.springframework.dao.EmptyResultDataAccessException;

//CRUD operations
public interface ReserveDAO {
   
  //Create
  public int save(Reserve reserve);
  
  //Read
  public int findNewId();
  public Reserve findById(int id) throws EmptyResultDataAccessException;
  
  //Delete
  public void deleteById(int id);
  
  //Get All
  public List<Integer> getSeatNumbersByBusAndDate(int bid, String date) throws EmptyResultDataAccessException;
}