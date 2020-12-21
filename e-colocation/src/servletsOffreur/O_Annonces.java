package servletsOffreur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import beansManager.ManagerPropriete;
import mesFonctions.FonctionUtil;

/**
 * Servlet implementation class Annonce
 */
@WebServlet("/O_Annonces")
public class O_Annonces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public O_Annonces() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur proprietaire = (Utilisateur)session.getAttribute("proprietaire");
		ManagerPropriete mngProp = new ManagerPropriete();
		request.setAttribute("proprietes",mngProp.fct_findAllByOwner(proprietaire.getId()));
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Offreur/annonces.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = new Utilisateur();
		user = (Utilisateur)session.getAttribute("proprietaire");
		FonctionUtil.uploadPhotoPropriete(request,user.getId());
		doGet(request,response);

		
		
	}

}
