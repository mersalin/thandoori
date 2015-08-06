package com.tastydine.dao.login;

import com.tastydine.vo.Login;

public interface LoginDAO {
	
	public Login getLoginDetails(String userName);

}
