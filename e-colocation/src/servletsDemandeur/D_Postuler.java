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
import beansManager.ManagerPropriete;

/**
 * Servlet implementation class D_Postuler
 */
@WebServlet("/D_Postuler")
public class D_Postuler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_Postuler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerPropriete mngProp = new ManagerPropriete();
		request.setAttribute("proprietes",mngProp.fct_findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Demandeur/postuler.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Utilisateur demnadeur = (Utilisateur)session.getAttribute("demandeur");
		ManagerDemande mngD = new ManagerDemande();
		Integer id_propriete = Integer.parseInt(request.getParameter("id"));
		int id_demandeur = demnadeur.getId();
		String statut = "en_attente";
		mngD.fct_insert(id_propriete, id_demandeur, statut);
		
	}

}
