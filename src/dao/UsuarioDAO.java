package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Telefone;
import model.Usuario;

public class UsuarioDAO extends ConnectionFactory {

	public void insert(Usuario usuario) {
		try {
			Connection conexao = getConexao();
			PreparedStatement stmt = conexao
					.prepareStatement("INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)");
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro 1:" + e.getMessage());
		}
	}

	public List<Usuario> selectAll() {
		List<Usuario> usuarios = new ArrayList<>();
		List<Telefone> telefones = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM usuario");
			ResultSet rsts = stmt.executeQuery();

			while (rsts.next()) {
				Long id = rsts.getLong("id");
				String nome = rsts.getString("nome");
				String email = rsts.getString("email");
				String senha = rsts.getString("senha");
				telefones = selectByIdUsuario(id);
				usuarios.add(new Usuario(id, nome, email, senha, telefones));
			}
		} catch (SQLException e) {
			System.out.println("Erro 4:" + e.getMessage());
		}
		return usuarios;
	}

	public void update(Usuario usuario, Long id) {
		try {
			Connection conexao = getConexao();
			PreparedStatement stmt = conexao
					.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?");
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setLong(4, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro 5:" + e.getMessage());
		}
	}

	public void delete(Long id) {
		try {
			Connection conexao = getConexao();
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM usuario WHERE id = ?");
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro 6:" + e.getMessage());
		}
	}

	public void insertTelefone(Telefone telefone) {
		try {
			Connection conexao = getConexao();
			PreparedStatement stmt = conexao
					.prepareStatement("INSERT INTO telefone (ddd, numero, tipo, idusuario) VALUES (?, ?, ?, ?)");
			stmt.setInt(1, telefone.getDdd());
			stmt.setString(2, telefone.getNumero());
			stmt.setString(3, telefone.getTipo());
			stmt.setLong(4, telefone.getIdUsuario());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro 7:" + e.getMessage());
		}
	}

	public List<Telefone> selectByIdUsuario(Long id) {
		List<Telefone> telefones = new ArrayList<>();

		try {
			Connection conexao = getConexao();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM telefone WHERE idusuario = ?");
			stmt.setLong(1, id);
			ResultSet rsts = stmt.executeQuery();

			while (rsts.next()) {
				Long idTelefone = rsts.getLong("id");
				int ddd = rsts.getInt("ddd");
				String numero = rsts.getString("numero");
				String tipo = rsts.getString("tipo");
				Long idUsuario = rsts.getLong("idusuario");
				telefones.add(new Telefone(idTelefone, ddd, numero, tipo, idUsuario));
			}
		} catch (SQLException e) {
			System.out.println("Erro 8:" + e.getMessage());
		}
		return telefones;
	}

	public void updateTelefone(Telefone telefone, Long id) {
		try {
			Connection conexao = getConexao();
			PreparedStatement stmt = conexao
					.prepareStatement("UPDATE telefone SET ddd = ?, numero = ?, tipo = ? WHERE id = ?");
			stmt.setInt(1, telefone.getDdd());
			stmt.setString(2, telefone.getNumero());
			stmt.setString(3, telefone.getTipo());
			stmt.setLong(4, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro 9:" + e.getMessage());
		}
	}

	public void deleteTelefone(Long id) {
		try {
			Connection conexao = getConexao();
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM telefone WHERE id = ?");
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro 10:" + e.getMessage());
		}
	}
	
	public void deleteTelefoneByIdUsuario(Long id) {
		try {
			Connection conexao = getConexao();
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM telefone WHERE idusuario = ?");
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro 11:" + e.getMessage());
		}
	}
	
	public boolean validador(String email, String senha) {
		boolean verificador = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE email = ? and senha = ?");
			stmt.setString(1, email);
			stmt.setString(2, senha);
			ResultSet rsts = stmt.executeQuery();
			if (rsts.next()) {
				verificador = true;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro 12:" + e.getMessage());
		}
		return verificador;
	}
}
