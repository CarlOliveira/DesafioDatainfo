package model;

public class Telefone {
	private Long id;
	private int ddd;
	private String numero;
	private String tipo;
	private Long idUsuario;

	public Telefone(Long id, int ddd, String numero, String tipo, Long idUsuario) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.idUsuario = idUsuario;
	}

	public Telefone(int ddd, String numero, String tipo, Long idUsuario) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.idUsuario = idUsuario;
	}

	public Telefone(Long id, int ddd, String numero, String tipo) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return tipo + ": " + "(" + ddd + ")" + numero;
	}
}
