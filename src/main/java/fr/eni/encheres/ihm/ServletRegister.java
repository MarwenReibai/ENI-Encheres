package fr.eni.encheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletRegistrer
 */
@WebServlet("/Register")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/Register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Utilisateur utilisateur = userRegister(request);
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			boolean created = utilisateurManager.createUtilisateur(utilisateur);
			if (!created) {
				throw new ServletException("Cet utilisateur existe déjà");
			}
			response.sendRedirect(request.getContextPath()+"/accueil");
		} catch (Exception e){
			request.setAttribute("erreur", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/JSP/Register.jsp").forward(request,response);
			e.printStackTrace();
		}
	}

	
	private String parametreChecker(String input) throws ServletException {
        if(input==null || input.trim().equals(""))
        {
        	throw new ServletException("Saisie invalide");
        }
        return input;
    }
	
	private Utilisateur userRegister(HttpServletRequest request) throws ServletException {
		String prenom = parametreChecker(request.getParameter("prenom"));
		String nom = parametreChecker(request.getParameter("nom"));
		String pseudo = parametreChecker(request.getParameter("pseudo"));
		String email = parametreChecker(request.getParameter("email"));
		String telephone = parametreChecker(request.getParameter("telephone"));
		String rue = parametreChecker(request.getParameter("rue"));
		String ville = parametreChecker(request.getParameter("ville"));
		String codePostal = parametreChecker(request.getParameter("codepostal"));
		String motDePasse = validatePassword(
			parametreChecker(request.getParameter("motdepasse")),
			parametreChecker(request.getParameter("confirmation"))
		);
		int credit = 100;
		Utilisateur utilisateur = new Utilisateur (pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse,credit,false);
		return utilisateur;
	}
	
	
	private String validatePassword(String mdp, String confirm) throws ServletException {
		if (!mdp.equals(confirm)) {
			throw new ServletException("les mots de passes ne correspondent pas");
		}
		return mdp;	
	}	
}
