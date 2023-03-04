package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur) throws DALException;
	public Utilisateur selectById(int id) throws DALException;
	public Utilisateur selectByPseudo(String pseudo) throws DALException;
	public void update(Utilisateur utilisateur) throws DALException;
	public void delete(Utilisateur utilisateur) throws DALException;
	
}

