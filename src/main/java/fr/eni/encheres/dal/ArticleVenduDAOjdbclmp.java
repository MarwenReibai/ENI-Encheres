package fr.eni.encheres.dal;

import java.sql.DriverManager;
import java.sql.SQLException;

public class  ArticleVenduDAOjdbclmp {
	
	// attributes :
	
	
	
	// loading connection :
	
	public ArticleVenduDAOjdbclmp() {
		  try {
			  
	 		// loading connection :  
			  
			DriverManager.registerDriver(new SQLServerDriver());

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		  JdbcTools.closeConnection();
	}
	
	
	

}

