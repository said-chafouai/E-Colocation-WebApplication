package servletsDemandeur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import beansManager.ManagerUtilisateur;


@WebServlet("/D_Profil")
public class D_Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public D_Profil() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute("demandeur");
		request.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Demandeur/profil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute("demandeur");
		ManagerUtilisateur mngUser = new ManagerUtilisateur();
		
		String form = request.getParameter("form");
		switch(form) {
		case "modifierProfil":
			user.setPassword(request.getParameter("mdp"));
			user.setVille(request.getParameter("ville"));
			user.setAdresse(request.getParameter("adresse"));
			user.setDescription(request.getParameter("description"));
			mngUser.modifierProfil(user);
			
			break;
		}
	}

}
