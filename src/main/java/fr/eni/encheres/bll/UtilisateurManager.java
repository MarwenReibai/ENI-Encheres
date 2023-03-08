package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	private static UtilisateurDAO dao;
	
	static {
		try {
			dao = DAOFactory.getUtilisateurDAO();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	///////////
	
	public void createUtilisateur(Utilisateur utilisateur) throws DALException {
		// à ajouter : if/else utilisateurvalide & checkforuniquepseudo
		dao.insert(utilisateur);
	}
	
	public Utilisateur getUtilisateurById (int id) throws DALException {
		return dao.selectById(id);
		
	}
	
	public Utilisateur getUtilisateurByPseudo (String pseudo) throws DALException {
		Utilisateur utilisateur = dao.selectByPseudo(pseudo);
		if (utilisateur == null) {
			throw new DALException ("Aucun compte n'est lié à ces identifiants. Veuillez réessayer ou vous inscrire. ");
		}
		return utilisateur;
		
	}
	
	public void deleteUtilisateur (Utilisateur utilisateur) throws DALException {
		dao.delete(utilisateur);
	}
	
	public void updateUtilisateur (Utilisateur utilisateur) throws DALException {
		dao.update(utilisateur);
	}

}
