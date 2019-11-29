package model;

import java.util.List;

public class User {

	private Integer id;
	private String name;
	private String email;
	private Login login;
	private List<Plataforma> plataformas;
	
	
	public User() {
		super();
	}


	public User(Integer id, String name, String email, Login login, List<Plataforma> plataformas) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.login = login;
		this.plataformas = plataformas;
	}


	public Integer getId() {
		return id;
	}


	public void setId(final Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(final String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(final String email) {
		this.email = email;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(final Login login) {
		this.login = login;
	}


	public List<Plataforma> getPlataformas() {
		return plataformas;
	}


	public void setPlataformas(final List<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", login=" + login + ", plataformas="
				+ plataformas + "]";
	}

}
