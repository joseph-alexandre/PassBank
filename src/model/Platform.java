package model;

public class Platform {

	private Integer id;
	private String nome;
	private String imagem;
	private Login login;
	
	public Platform() {
		super();
	}

	public Platform(Integer id, String nome, String imagem, Login login) {
		super();
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
		this.login = login;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Plataforma [id=" + id + ", nome=" + nome + ", imagem=" + imagem + ", login=" + login + "]";
	}

		
}
