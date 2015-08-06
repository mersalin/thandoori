package com.tastydine.dao.login;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tastydine.vo.Login;

public class LoginMapper implements RowMapper<Login> {

	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		Login login = new Login();
		login.setId(rs.getInt("id"));
		login.setUserName(rs.getString("user_name"));
		login.setPassword(rs.getString("password"));
		return login;
	}

}
