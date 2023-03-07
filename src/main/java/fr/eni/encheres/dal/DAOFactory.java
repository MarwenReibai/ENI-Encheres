package fr.eni.encheres.dal;

public class DAOFactory {

	private static UtilisateurDAO utilisateurDAO;
	
	public static UtilisateurDAO getUtilisateurDAO() throws DALException{
		if (utilisateurDAO == null) {
			utilisateurDAO = new UtilisateurDAOJdbcImpl();
		}
		return utilisateurDAO;
	}
	
}
