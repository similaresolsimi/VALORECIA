package com.site.obj;

public class LoginServiceImpl implements LoginService{

	@Override
	public String authorize(String name, String pswd) {
		if((name.equals("admin")) && (pswd.equals("admin"))){
			return "console";
		}
		else return "pasok";
	}

	@Override
	public String authorize(UserEntity util) {
		// TODO Auto-generated method stub
		return null;
	}


}
