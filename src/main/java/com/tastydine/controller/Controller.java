package com.tastydine.controller;

import javax.servlet.http.HttpServletResponse;

import com.tastydine.service.Service;
import com.tastydine.service.login.LoginService;
import com.tastydine.vo.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.JavaScriptUtils;

/**
 * Created by Software on 5/13/2015.
 */
@RestController
public class Controller {

	@Autowired
    private Service service;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/welcome")
    public @ResponseBody String welcome() {
        return service.welcome();
    }
    
	@RequestMapping("/loginValidation")
	public @ResponseBody Login validateLogin(
			@RequestParam(value = "user", defaultValue = "", required = true) String userName,
			@RequestParam(value = "password", defaultValue = "", required = true) String password) {
		return loginService.validateUser(userName, password);
	}
	@RequestMapping(value="/loginValidationJsonp"/*, produces="application/javascript;charset=UTF-8", headers = "Accept=*", method = RequestMethod.GET*/)
	@ResponseBody
	public MappingJacksonValue validateLoginJsonp(
			@RequestParam(value = "user", defaultValue = "", required = true) String userName,
			@RequestParam(value = "password", defaultValue = "", required = true) String password,
			@RequestParam(value = "callback", defaultValue = "", required = true) String callback,HttpServletResponse response) {
				
		        MappingJacksonValue value = new MappingJacksonValue(loginService.validateUser(userName, password));
		        value.setJsonpFunction(callback);
		        response.setContentType("application/javascript; charset=UTF-8");
		        return value; 
	}
/*	@RequestMapping("/error")
	public @ResponseBody String handleError(){
		return "";
		
		
	}*/
}
