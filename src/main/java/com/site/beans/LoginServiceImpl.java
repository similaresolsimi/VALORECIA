package com.site.beans;

public class LoginServiceImpl implements LoginService{

	@Override
	public String authorize(String name, String pswd) {
		if((name.equals("admin")) && (pswd.equals("admin"))){
			return "login2";
		}
		else return "pasok";
	}


}
