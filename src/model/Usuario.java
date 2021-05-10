package model;

import java.util.List;

public class Usuario {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private List<Telefone> telefone;

	public Usuario(Long id, String nome, String email, String senha, List<Telefone> telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
	}

	public Usuario(Long id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	 }

	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Usuario: " + id + "nome=" + nome + ", email=" + email + ", telefone=" + telefone;
	}
	
	public String retornarTelefone() {
		String telefone = "";
		
		for(Telefone telefoneUsuario : getTelefone()) {
			
			telefone += telefoneUsuario.getTipo() + ": " +"(" + telefoneUsuario.getDdd() + ")" + telefoneUsuario.getNumero() + ". ";
			
		}
		
		return telefone;
	}
}
