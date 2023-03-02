package fr.eni.encheres.dal;

import java.sql.DriverManager;
import java.sql.SQLException;

public class CategorieDAOjdbclmpl {
	
	// attributes :
	
	
	
	// loading connection :
	
	public CategorieDAOjdbclmpl () {
		  try {
			  
	 		// loading connection :  
			  
			DriverManager.registerDriver(new SQLServerDriver());

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		  JdbcTools.closeConnection();
	}
	
	
	

}