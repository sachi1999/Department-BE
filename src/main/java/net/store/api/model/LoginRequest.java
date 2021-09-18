package net.store.api.model;

public class LoginRequest {

	private String emailId;
	private String pwd;
	
	public LoginRequest(String emailId, String pwd) {
		super();
		this.emailId = emailId;
		this.pwd = pwd;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
