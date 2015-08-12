package com.tastydine.dao.login;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import com.tastydine.vo.Login;

@Repository
public class LoginTemplate implements LoginDAO{
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public Login getLoginDetails(String userName) {
		log.info("inside authentication");
		try {
		 String SQL = "select * from login_users where user_name = ?";
	     Login loginResult= jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{userName}, new LoginMapper());
	     return loginResult;
		} catch(EmptyResultDataAccessException empty) {
			log.warn("No result returned in getLoginDetails", empty);
			return null;
		}
	}

}
