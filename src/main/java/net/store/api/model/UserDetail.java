package net.store.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "UserDetail")
public class UserDetail {
	
	
	private String firstName;
	private String lastName;
	private String emailId;
	private String pwd;
	
	public UserDetail() {
	}
	
	public UserDetail(String firstName, String lastName, String emailId, String pwd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.pwd = pwd;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Id
	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "pwd", nullable = false)
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

}
