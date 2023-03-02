package fr.eni.encheres.dal;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl {
	
	// attributes :
	
	
	
	// loading connection :
	
	private static final String INSERT = "INSERT INTO utilisateurs (pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDepasse,credit,admnistrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	public UtilisateurDAOJdbcImpl() {
		  try {
			  
	 		// loading connection :  
			  
			DriverManager.registerDriver(new SQLServerDriver());

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		  JdbcTools.closeConnection();
	}
	
	public void insert(Utilisateur utilisateur) throws DALException {
		
		try {
			PreparedStatement ps = JdbcTools.getConnection().prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			fillPreparedStatement(utilisateur, ps);
			ps.executeUpdate();
			
			// récupère l'id
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			
		}
		
		
	}
	
	// methodes :
	
    private void fillPreparedStatement(Utilisateur utilisateur, PreparedStatement ps) throws SQLException {
    	ps.setString(1, utilisateur.getPseudo());
        ps.setString(2, utilisateur.getNom());
        ps.setString(3, utilisateur.getPrenom());
        ps.setString(4, utilisateur.getEmail());
        ps.setString(5, utilisateur.getTelephone());
        ps.setString(6, utilisateur.getRue());
        ps.setString(7, utilisateur.getCodePostal());
        ps.setString(8, utilisateur.getVille());
        ps.setString(9, utilisateur.getMotDePasse());
        ps.setInt(10, utilisateur.getCredit());
        ps.setBoolean(11, utilisateur.isAdministrateur());
    }
	
	

}
