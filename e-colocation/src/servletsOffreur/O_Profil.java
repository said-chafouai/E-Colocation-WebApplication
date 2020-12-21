package servletsOffreur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import beansManager.ManagerUtilisateur;


@WebServlet("/O_Profil")
public class O_Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public O_Profil() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute("proprietaire");
		request.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Offreur/profil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute("proprietaire");
		ManagerUtilisateur mngUser = new ManagerUtilisateur();
		
		String form = request.getParameter("form");
		System.out.println(form);
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
