package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {

	ArticleVendu selectById(int noArticle) throws DALException;

	List<ArticleVendu> selectAll() throws DALException;

	void update(ArticleVendu av1) throws DALException;

	void insert(ArticleVendu av1) throws DALException;

	void delete(int idArticle) throws DALException;

	ArticleVendu selectBynomArticle(String nomArticle);

	void delete(ArticleVendu articleVendu);

}