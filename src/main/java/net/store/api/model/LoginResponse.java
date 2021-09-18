package net.store.api.model;

public class LoginResponse {
	
	private int status;
	private String errMsg;
	private UserDetail user;
	
	public LoginResponse()
	{
		
	}
	public LoginResponse(int status, String errMsg, UserDetail user) {
		super();
		this.errMsg = errMsg;
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public UserDetail getUser() {
		return user;
	}

	public void setUser(UserDetail user) {
		this.user = user;
	}
	
	

}
