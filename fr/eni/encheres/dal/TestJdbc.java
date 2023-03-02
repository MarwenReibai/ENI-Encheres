package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {
		try {

			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

			String url = "jdbc:sqlserver://localhost:1433;databaseName=Encheres";
			Connection connexion = DriverManager.getConnection(url, "sa", "Pa$$w0rd");

			System.out.println("Connexion OK");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
