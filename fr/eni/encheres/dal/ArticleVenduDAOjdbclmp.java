package fr.eni.encheres.dal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.eni.encheres.bo.*;
public class  ArticleVenduDAOjdbclmp {
	
		private static final String sqlSelectByNo = "select noArticleVendu,nomArticleVendu,description,dateDebutEncheres,dateFinEncheres,miseAPrix,prixVente,etatVente" 
		+ " from articles where noArticleVendu = ? " ;
		private static final String sqlSelectAll ="select noArticleVendu,nomArticleVendu,description,dateDebutEncheres,dateFinEncheres,miseAPrix,prixVente,etatVente" 
		+ "from articles";
		private static final String sqlUpdate = "update articles set nomArticleVendu=?,description=?,dateDebutEncheres=?,dateFinEncheres=?,miseAPrix=?,prixVente=?,etatVente=?,where noArticleVendu=?";
		private static final String sqlInsert = "insert into articles(nomArticleVendu,description,dateDebutEncheres,dateFinEncheres,miseAPrix,prixVente,etatVente) values (?,?,?,?,?,?,?)";
		private static final String sqlDelete = "delete from articles where noArticleVendu=?";
		private  Connection connection;
		// constructeur
		public ArticleVenduDAOjdbclmp () {
			
		}
		// Connection port 1433
		public Connection getConnection() throws SQLException {
			if (connection == null || connection.isClosed()) {
				String urldb = "jdbc:sqlserver://localhost:1433;databaseName=Encheres";
				connection = DriverManager.getConnection(urldb, "sa", "Pa$$w0rd");
			}
			return connection;
		}
		public ArticleVendu selectById(int no) throws DALException {
			ArticleVendu art = null;
			try (Connection cnx = getConnection(); PreparedStatement rqt = cnx.prepareStatement(sqlSelectByNo);) {
				rqt.setInt(1, no);

				try (ResultSet rs = rqt.executeQuery();) {
					if (rs.next()) {
						art = mapping(rs);
					}
				}
			} catch (SQLException e) {
				throw new DALException("selectByNO failed - no = " + no, e);
			}
			return art;
		}
		public List<ArticleVendu> selectAll() throws DALException {
			List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
			try (Connection cnx = getConnection(); Statement rqt = cnx.createStatement();) {
				try (ResultSet rs = rqt.executeQuery(sqlSelectAll);) {
					ArticleVendu art = null;
					while (rs.next()) {
						art = mapping(rs); //mappin une méthode
						liste.add(art);
					}
				}
			} catch (SQLException e) {
				throw new DALException("selectAll failed - ", e);
			}
			return liste;

		}
		// update 
		public void update(ArticleVendu data) throws DALException {
			try (Connection cnx = getConnection(); PreparedStatement rqt = cnx.prepareStatement(sqlUpdate);) {
				setParameter(rqt, data);
				rqt.setInt(2, data.getNoArticle()); // 2 num d'article , il faut extend class dans articleVendu
				rqt.executeUpdate();

			} catch (SQLException e) {
				throw new DALException("Update article failed - " + data, e);
			}
		}
		// insert
		public void insert(ArticleVendu data) throws DALException {
			try (Connection cnx = getConnection();
					PreparedStatement rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
				setParameter(rqt, data);
			

				int nbRows = rqt.executeUpdate();
				if (nbRows == 1) {
					try (ResultSet rs = rqt.getGeneratedKeys();) {
						if (rs.next()) {
							data.setNoArticle(rs.getInt(1));
						}
					}

				}

			} catch (SQLException e) {
				throw new DALException("Insert article failed - " + data, e);
			}
		}
		// delete

		public void delete(int no) throws DALException {
			try (Connection cnx = getConnection(); PreparedStatement rqt = cnx.prepareStatement(sqlDelete);) {
				rqt.setInt(1, no); // num darticle
				rqt.executeUpdate();
			} catch (SQLException e) {
				throw new DALException("Delete article failed - no=" + no, e);
			}
		}		
		private ArticleVendu mapping(ResultSet rs) throws SQLException {
			ArticleVendu art = null;
			int noArticleVendu = rs.getInt("noArticleVendu");
			String nomArticleVendu = rs.getString("nomArticleVendu").trim();
			String description = rs.getString("description");
			Date dateDebutEncheres = rs.getDate("dateDebutEncheres");
			Date dateFinEncheres = rs.getDate("dateFinEncheres");
			float miseAPrix = rs.getFloat("miseAPrix");
			float prixVente = rs.getFloat("prixVente");
			String etatVente = rs.getString("etatVente");
		
			return art;
	}
			private void setParameter(PreparedStatement rqt, ArticleVendu art) throws SQLException {
				rqt.setString(1, art.getNomArticle());
				rqt.setString(2, art.getDescription());
				rqt.setDate(3, (Date) art.getDateDebutEncheres());
				rqt.setDate(4,  (Date) art.getDateFinEncheres());
				rqt.setFloat(5, art.getMiseAPrix());
				rqt.setFloat(5, art.getPrixVente());
				rqt.setString(5, art.getEtatVente());
			}
}


		