package br.com.cuml.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	public Connection getConexao() throws SQLException {
		Connection retorno = null;
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		retorno = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "tferezin", "152535");
		System.out.println("CONEXÃO CRIADA COM SUCESSO");
		return retorno;
	}
}
