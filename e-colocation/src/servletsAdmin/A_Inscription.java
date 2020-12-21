package servletsAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansManager.ManagerUtilisateur;

@WebServlet("/A_Inscription")
public class A_Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public A_Inscription() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerUtilisateur mngUser = new ManagerUtilisateur();
		request.setAttribute("demandes", mngUser.fct_getAllInscriptionDemandes());
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Admin/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerUtilisateur mngU = new ManagerUtilisateur();
		
		String form = request.getParameter("form");
		int id_user = Integer.parseInt(request.getParameter("id"));
		switch(form) {
		case "valider":
			mngU.fct_accepteRefuseDemandeInscription(id_user, "valider");
			break;
			
		case "rejeter":
			mngU.fct_accepteRefuseDemandeInscription(id_user, "rejeter");
			break;
		}
	}

}
