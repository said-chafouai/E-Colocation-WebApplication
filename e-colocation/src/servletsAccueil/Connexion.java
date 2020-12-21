package servletsAccueil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import beansManager.ManagerUtilisateur;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Connexion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Accueil/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(100*60);
		
		ManagerUtilisateur managerUser = new ManagerUtilisateur();
		Utilisateur user = null;
		
		String login = request.getParameter("login");
		String password = request.getParameter("mdp");
		
		user = managerUser.Connexion(login, password);
		if(user != null) {
			switch(user.getStatut()) {
			case "admin" : 
				session.setAttribute("admin", user);
				this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Admin/accueil.jsp").forward(request, response);
				break;
			case "offreur" : 
				session.setAttribute("proprietaire", user);
				this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Offreur/accueil.jsp").forward(request, response);
				break;
			case "demandeur" : 
				session.setAttribute("demandeur", user);
				this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Demandeur/accueil.jsp").forward(request, response);
				break;
			}
		}else {
			request.setAttribute("connexionEchoue", "set");
			this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Accueil/connexion.jsp").forward(request, response);
			
		}
	}

}