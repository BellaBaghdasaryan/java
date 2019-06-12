package com.bella.brs.model.dao;

import java.util.List;

import com.bella.brs.model.bean.ReservationBean;
import org.springframework.dao.EmptyResultDataAccessException;

//CRUD operations
public interface ReservationDAO {
   
	public List<ReservationBean> findByPid(int pid) throws EmptyResultDataAccessException;
  
}