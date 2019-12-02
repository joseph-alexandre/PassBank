package model;

import java.util.List;

public class User {

	private Integer id;
	private String name;
	private String email;
	private Login login;
	private Platform platform;
	
	
	public User() {
		super();
	}


	public User(Integer id, String name, String email, Login login, Platform platform) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.login = login;
		this.platform = platform;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public Platform getPlatform() {
		return platform;
	}


	public void setPlatform(Platform platform) {
		this.platform = platform;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", login=" + login + ", platform=" + platform
				+ "]";
	}


}