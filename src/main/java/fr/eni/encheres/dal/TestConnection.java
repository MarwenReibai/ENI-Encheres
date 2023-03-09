package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class TestConnection {

	public static void main(String[] args) {
		  try {
			DriverManager.registerDriver(new SQLServerDriver());
			Connection con = null;
			//String url ="jdbc:sqlserver://localhost:1433;databaseName=Encheres;integratedSecurity=true;encrypt=true;trustServerCertificate=false;trustStore=storeName;trustStorePassword=storePassword";
			String url ="jdbc:sqlserver://localhost:1433;databaseName=Encheres;trustServerCertificate=true;"; //encrypt=true;
			con = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
			
			if (!con.isClosed()) {
				System.out.println("Connection ouverte");
			}
			JdbcTools.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
