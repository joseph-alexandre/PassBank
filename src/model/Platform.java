package model;

public class Platform {

	private Integer id;
	private String name, image, username, password;
	
	public Platform() {
		super();
	}

	public Platform(Integer id, String name, String image, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.username = username;
		this.password = password;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Platform [id=" + id + ", name=" + name + ", image=" + image + ", username=" + username + ", password="
				+ password + "]";
	}

	
}
