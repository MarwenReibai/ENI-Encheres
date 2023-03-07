package fr.eni.encheres.dal;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD:fr/eni/encheres/dal/UtilisateurDAOJdbcImpl.java
public class UtilisateurDAOJdbcImpl {
=======
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
>>>>>>> 9b1d15ce4fb582d689ced1377986cc970cc91d9d:src/main/java/fr/eni/encheres/dal/UtilisateurDAOJdbcImpl.java
	
	// attributes :
	
	private static final String INSERT = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,codePostal,ville,mot_de_passe,credit,admnistrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
	private static final String UPDATE = "UPDATE UTILISATEURS SET "+"pseudo = ?"+"nom = ?"+"prenom = ?"+"email = ?"+"telephone = ?"+"rue = ?"+"code_postal = ?"+"ville = ?"+"mot_de_passe = ?"+"credit = ?"+"administrateur = ?"+"WHERE no_utilisateur = ?";
	private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ? ";
	
	// loading connection :
	
	public UtilisateurDAOJdbcImpl() {
		  try {
			  
<<<<<<< HEAD:fr/eni/encheres/dal/UtilisateurDAOJdbcImpl.java

			DriverManager.registerDriver( new com.microsoft.sqlserver.jdbc.SQLServerDriver());
=======
			DriverManager.registerDriver(new SQLServerDriver());
>>>>>>> 9b1d15ce4fb582d689ced1377986cc970cc91d9d:src/main/java/fr/eni/encheres/dal/UtilisateurDAOJdbcImpl.java

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		  JdbcTools.closeConnection();
	}
	
	///////////////////////////////////////////////////////////////
	@Override
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
			JdbcTools.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		
		
	}
	
	///////////////////////////////////////////////////////////////
	@Override
    public Utilisateur selectById(int id) throws DALException {
    	
    	Utilisateur utilisateur = null;
    	
    	try {
    		PreparedStatement ps = JdbcTools.getConnection().prepareStatement(SELECT_BY_ID);
    		ps.setInt(1, id);
    		ps.execute();
    		ResultSet rs = ps.getResultSet();
    		if (rs.next()) {
    			utilisateur = fillUtilisateur(rs);
    		}
    		JdbcTools.closeConnection();
    	} catch (SQLException e){
    		e.printStackTrace();
    	}
		return utilisateur;
    	
    }
    
    ///////////////////////////////////////////////////////////////
	@Override
    public Utilisateur selectByPseudo(String pseudo) throws DALException {
    	
    	Utilisateur utilisateur = null;
    	
    	try {
    		PreparedStatement ps = JdbcTools.getConnection().prepareStatement(SELECT_BY_PSEUDO);
    		ps.setString(1, pseudo);
    		ps.execute();
    		ResultSet rs = ps.getResultSet();
    		if (rs.next()) {
    			utilisateur = fillUtilisateur(rs);
    		}
    		JdbcTools.closeConnection();
    	} catch (SQLException e){
    		e.printStackTrace();
    	}
		return utilisateur;
    	
    }
	
    ///////////////////////////////////////////////////////////////
	@Override
    public void update(Utilisateur utilisateur) throws DALException {
    	
    	try {
    		PreparedStatement ps = JdbcTools.getConnection().prepareStatement(UPDATE);
    		fillPreparedStatement(utilisateur, ps);
    		ps.setInt(12, utilisateur.getNoUtilisateur());
    		ps.executeUpdate();
    		
    		JdbcTools.closeConnection();
    		
    	} catch (SQLException e){
    		e.printStackTrace();
    	}
    }
    
    ///////////////////////////////////////////////////////////////
	@Override
    public void delete(Utilisateur utilisateur) throws DALException {
    	try {
			PreparedStatement ps = JdbcTools.getConnection().prepareStatement(DELETE);
			ps.setInt(1, utilisateur.getNoUtilisateur());
			ps.executeUpdate();
			JdbcTools.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    
	// ---  METHODES --- :
	
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
    


	private Utilisateur fillUtilisateur(ResultSet rs) throws SQLException {
		
		return new Utilisateur(
                rs.getInt("no_utilisateur"),
                rs.getString("pseudo"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("email"),
                rs.getString("telephone"),
                rs.getString("rue"),
                rs.getString("code_postal"),
                rs.getString("ville"),
                rs.getString("mot_de_passe"),
                rs.getInt("credit"),
                rs.getBoolean("administrateur")
				);
	}
	
	

}
