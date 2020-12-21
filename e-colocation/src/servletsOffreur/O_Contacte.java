package servletsOffreur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import beansManager.ManagerMessage;
import beansManager.ManagerUtilisateur;

/**
 * Servlet implementation class ContacterDemandeur
 */
@WebServlet("/O_Contacte")
public class O_Contacte extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public O_Contacte() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur proprietaire = (Utilisateur)session.getAttribute("proprietaire");
		ManagerMessage mngMsg = new ManagerMessage();
		ManagerUtilisateur mngUsr = new ManagerUtilisateur();		
		
		request.setAttribute("msgRecus",mngMsg.fct_getAllByReceiver(proprietaire.getId()));	
		request.setAttribute("msgEnvoyes",mngMsg.fct_getAllBySender(proprietaire.getId()));
		request.setAttribute("receivers",mngUsr.fct_findMesDemandeur(proprietaire.getId()));	
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Offreur/contacte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur offreur = (Utilisateur)session.getAttribute("proprietaire");
		
		String form = request.getParameter("form");
		
		
		switch(form) {
		case "envoyer":
			int id_sender = offreur.getId();
			Integer id_receiver = Integer.parseInt(request.getParameter("id_receiver"));
			String message = request.getParameter("message");
			ManagerMessage mngMsg = new ManagerMessage();
			mngMsg.fct_sendMessage(id_sender, id_receiver, message);
			
			break;
		}
			
	}

}
