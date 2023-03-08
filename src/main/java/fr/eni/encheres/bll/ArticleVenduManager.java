package fr.eni.encheres.bll;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.ArticleVenduDAO;

public class ArticleVenduManager {

	private static ArticleVenduDAO dao;

	static {
		try {
			dao = DAOFactory.getArticleVenduDAO();
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	///////////

	public void createArticleVendu(ArticleVendu ArticleVendu) throws DALException {
		// à ajouter : if/else utilisateurvalide & checkforuniquepseudo
		dao.insert(ArticleVendu);
	}

	public ArticleVendu getArticleVenduById (int id) throws DALException {
		return dao.selectById(id);

	}

	public ArticleVendu getArticleVenduByomArticle (String nomArticle) throws DALException {
		return dao.selectBynomArticle(nomArticle);

	}

	public void deleteArticleVendu (ArticleVendu ArticleVendu) throws DALException {
		dao.delete(ArticleVendu);
	}

	public void updateArticleVendu (ArticleVendu ArticleVendu) throws DALException {
		dao.update(ArticleVendu);
	}

}