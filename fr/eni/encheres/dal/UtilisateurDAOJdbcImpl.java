package fr.eni.encheres.dal;

import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilisateurDAOJdbcImpl {
	
	// attributes :
	
	
	
	// loading connection :
	
	public UtilisateurDAOJdbcImpl() {
		  try {
			  

			DriverManager.registerDriver( new com.microsoft.sqlserver.jdbc.SQLServerDriver());

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		  JdbcTools.closeConnection();
	}
	
	
	

}
