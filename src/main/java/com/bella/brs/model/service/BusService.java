package com.bella.brs.model.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.bella.brs.model.dao.BusDAO;
import com.bella.brs.model.entity.Bus;
import com.bella.brs.model.entity.Route;

/**
 * @author Bella Baghdasaryan
 */
public class BusService implements Service {

	public static ClassPathXmlApplicationContext dbApplicationContext;

	public BusService() {
		dbApplicationContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
	}

	public List<Bus> findAvailableBuses(Route route,String date) throws EmptyResultDataAccessException {

		BusDAO busDAO = dbApplicationContext.getBean("busDAO",BusDAO.class);

		return busDAO.findByRouteAndDate(route, date);
	}

	protected void finalize() {
		dbApplicationContext.close();
		dbApplicationContext = null;
	}

}
