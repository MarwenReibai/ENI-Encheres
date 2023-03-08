package fr.eni.encheres.ihm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/Login.jsp");
		rd.forward(request, response);
		//to add :empecher user de s'inscrire/se connecter si l'user est déjà connecté
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String pseudo = request.getParameter("nom_pseudo");
		//String pass = request.getParameter("nom_pass");
		//PrintWriter writer_pass = response.getWriter().append(pseudo);
		//PrintWriter writer_pseudo = response.getWriter().append(pseudo);
		//doGet(request, response);
		
		
		try {
			Utilisateur utilisateur = connectUser(request);
			//to add: garder session user connecté 
			response.sendRedirect(request.getContextPath()+"/accueil");
		} catch (Exception e) {
			request.setAttribute("erreur", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/JSP/Login.jsp").forward(request,response);
			e.printStackTrace();
		}
		
		
	}
	
	private Utilisateur connectUser(HttpServletRequest request) throws ServletException, DALException {
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		String pseudoOk = PseudoParametreReader(request);
		String passOk = MdpParametreReader(request);
		Utilisateur utilisateur = utilisateurManager.getUtilisateurByPseudo(pseudoOk);
		
		if (!utilisateur.getMotDePasse().equals(passOk)) {
			throw new ServletException("Mot de passe invalide");
		}
		return utilisateur;
	}
	
    private String PseudoParametreReader(HttpServletRequest request) throws ServletException {
        String pseudo;
        pseudo = request.getParameter("nom_pseudo");
        if(pseudo==null || pseudo.trim().equals(""))
        {
        	throw new ServletException("Pseudo invalide");
        }
        return pseudo;
    }
	
    private String MdpParametreReader(HttpServletRequest request) throws ServletException {
        String pass;
        pass = request.getParameter("nom_pass");
        if(pass==null || pass.trim().equals(""))
        {
        	throw new ServletException("Mot de passe invalide");
        }
        return pass;
    }

}
