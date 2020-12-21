	package servletsOffreur;

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
 * Servlet implementation class ConsulterDemande
 */
@WebServlet("/O_Demandes")
public class O_Demandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public O_Demandes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur proprietaire = (Utilisateur)session.getAttribute("proprietaire");
		ManagerDemande mngD = new ManagerDemande();
		int id_proprietaire =  proprietaire.getId();
		String statut = "en_attente";
		request.setAttribute("demandes",mngD.fct_findDemandeByProprietaire(id_proprietaire, statut));
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Offreur/demandes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form = request.getParameter("form");
		Integer id_demande = Integer.parseInt(request.getParameter("id"));
		String statut;
		ManagerDemande mngD = new ManagerDemande();
		
		switch(form){
		case "valider":
			statut = "valider";
			mngD.fct_updateStatut(id_demande, statut);
			break;
		case "rejeter":
			statut = "rejeter";
			mngD.fct_updateStatut(id_demande, statut);
			break;
		}
	}

}
