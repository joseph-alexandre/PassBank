package model;

public class Record {

	private Integer id, id_user, id_platform;

	public Record() {
		super();
	}

	public Record(Integer id, Integer id_user, Integer id_platform) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_platform = id_platform;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_platform() {
		return id_platform;
	}

	public void setId_platform(Integer id_platform) {
		this.id_platform = id_platform;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", id_user=" + id_user + ", id_platform=" + id_platform + "]";
	}
	
	
	
}
