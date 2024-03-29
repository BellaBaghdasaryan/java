package com.bella.brs.model.dao;

import com.bella.brs.model.entity.Passenger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 * The Service class, which contains business logic to update Passenger model.
 * @author Bella Baghdasaryan
 * @see Passenger
 */
public class PassengerDAOImpl extends BaseDAO implements PassengerDAO {
	
	private static final String table = Passenger.indentity;
	
	public void save(Passenger passenger){
		
		String sql = "insert into "+table+" (username,password,name,email,mobile) values(?,?,?,?,?)";
			 
		getJdbcTemplate().update(sql, 
				new Object[] { 
					passenger.getUsername(),
					passenger.getPassword(),
					passenger.getName(),
					passenger.getEmail(),
					passenger.getMobile()});
			
	}

	/**
	 * Following function retrieves Passenger data for given id.
	 * @param id Passenger Id
	 * @return Passenger object.
	 */
    @Override
    public Passenger findById(int id) throws EmptyResultDataAccessException{
        String query = "select * from "+table+" where id = ?";
        
        //query single row with BeanPropertyRowMapper (Passenger.class)
        Passenger passenger = (Passenger)getJdbcTemplate().queryForObject(query, 
        		new Object[] { id }, 
				new BeanPropertyRowMapper<Passenger>(Passenger.class));
       
        return passenger;
    }
    
    /**
	 * Following function retrieves Passenger data for given username.
	 * @param id Passenger Id
	 * @return Passenger object.
	 */
    @Override
//			(Passenger)getJdbcTemplate().queryForObject(query, new Object[] { username },new BeanPropertyRowMapper<Passenger>(Passenger.class))
    public Passenger findByUsername(String username) throws EmptyResultDataAccessException{
        String query = "select * from "+table+" where username = ?";
     
        //query single row with BeanPropertyRowMapper (Passenger.class)
        Passenger passenger = (Passenger)getJdbcTemplate().queryForObject(query, 
    		   			new Object[] { username }, 
    		   			new BeanPropertyRowMapper<Passenger>(Passenger.class));
        return passenger;
    }
 
}