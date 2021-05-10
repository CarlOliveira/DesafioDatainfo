package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConexao() {
		Connection conexao = null;
		String usuario = "postgres";
		String senha = "admin";
		String nomeBancoDados = "desafiodatainfo";
 
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nomeBancoDados,
					 usuario, senha);
			System.out.println("Banco conectado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}
