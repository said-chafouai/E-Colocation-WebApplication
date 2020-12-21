package servletsDemandeur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import beansManager.ManagerDemande;

/**
 * Servlet implementation class D_Demandes
 */
@WebServlet("/D_Demandes")
public class D_Demandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_Demandes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur demandeur = (Utilisateur)session.getAttribute("demandeur");
		ManagerDemande mngD = new ManagerDemande();
		int id_demandeur =  demandeur.getId();
		request.setAttribute("demandesAttente",mngD.fct_findDemandeByDemandeur(id_demandeur, "en_attente"));
		request.setAttribute("demandesValidee",mngD.fct_findDemandeByDemandeur(id_demandeur, "valider"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Demandeur/demandes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
