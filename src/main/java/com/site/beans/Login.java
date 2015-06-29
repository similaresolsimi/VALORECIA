package com.site.beans;



import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Login {
	@Inject
	private LoginService myService;
	private String name;
	private String pswd;
	private String result;
	
	public String valide(){
		result = myService.authorize(name, pswd);
		return result;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
}
