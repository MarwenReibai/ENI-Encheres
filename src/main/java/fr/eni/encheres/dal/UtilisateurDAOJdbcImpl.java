package fr.eni.encheres.dal;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class UtilisateurDAOJdbcImpl {
	
	// attributes :
	
	
	
	// loading connection :
	
	public UtilisateurDAOJdbcImpl() {
		  try {
			  
	 		// loading connection :  
			  
			DriverManager.registerDriver(new SQLServerDriver());

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		  JdbcTools.closeConnection();
	}
	
	
	

}
