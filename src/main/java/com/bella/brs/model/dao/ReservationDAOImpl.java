package com.bella.brs.model.dao;

import java.util.List;

import com.bella.brs.model.bean.ReservationBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * CRUD operations for reservation view.
 * @author Bella Baghdasaryan
 */
public class ReservationDAOImpl extends BaseDAO implements ReservationDAO {
		
	
	public ReservationDAOImpl(){
		this.table = ReservationBean.indentity;
	}
	
	public List<ReservationBean> findByPid(int passengerID) throws EmptyResultDataAccessException{
		
		String query = "select * from "+table+" where passengerid = ?";
		
		List<ReservationBean> reservationBeans = 
				getJdbcTemplate().query(query, 
		        		new Object[] { passengerID }, 
						new BeanPropertyRowMapper<ReservationBean>(ReservationBean.class));
		return reservationBeans;
	}
}
