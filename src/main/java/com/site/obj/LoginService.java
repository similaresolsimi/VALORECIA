package com.site.obj;

public interface LoginService {

	String authorize(String name,String pswd);
	String authorize(UserEntity util);
}
