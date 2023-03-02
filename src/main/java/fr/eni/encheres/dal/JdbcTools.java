package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {

private static Connection connection;
	
	/*
	 * Permet d'obtenir une connection a la BDD a condition qu'il n'y en ait pas deja une
	 */
	public static Connection getConnection() throws DALException {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(
						Settings.getProperty("url"),
						Settings.getProperty("user"),
						Settings.getProperty("password"));
	
				System.out.println("Connection to database open");
			}
		} catch (SQLException e) {
			throw new DALException("Echec de la connexion a la BDD", e);
		}
		return connection;
	}
	
	/*
	 * Permet de fermer la connexion avec la base de donnees si celle-ci existe
	 */
	public static void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
