package com.tastydine.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastydine.dao.login.LoginDAO;
import com.tastydine.dao.login.UserDAO;
import com.tastydine.vo.Login;
import com.tastydine.vo.User;

@Service
public class LoginService {
	@Autowired
	private LoginDAO loginDao;
	
	@Autowired
	private UserDAO userDao;
	
/*	public boolean validateUser(String userName, String password) {
		Login login = loginTemplate.getLoginDetails(userName);
		if(login==null) return false;
		if(password.equals(login.getPassword())){
			return true;
		} else return false;
		
	}*/
	
	/**
	 * Login Status Codes - 200 = Success
	 * 404 = Username doesn't exist in system
	 * 405 = Password doesn't match the one existing in system for the provided username
	 * @param userName
	 * @param password
	 * @return
	 */
	public Login validateUser(String userName, String password) {
//		Login login = loginDao.getLoginDetails(userName);
		User user = userDao.getByName(userName);
		Login login = new Login();
		if(user==null) {
//			login = new Login();
			login.setUserName(userName);//setting this from input as this would be null from DB
			login.setStatusMessage("Username/password invalid");
			login.setStatusCode(404);
		} else if(password.equals(user.getPassword())){
			login.setUserName(user.getUserName());
			login.setStatusCode(200);
			login.setStatusMessage("Success");
		} else {
			login.setStatusMessage("Username/password invalid");
			login.setStatusCode(405);
		}
		login.setPassword("");//Emptying password before sending response
		return login;
		
	}

}
