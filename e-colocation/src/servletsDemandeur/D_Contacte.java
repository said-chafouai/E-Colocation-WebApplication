package servletsDemandeur;

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
 * Servlet implementation class D_Contacte
 */
@WebServlet("/D_Contacte")
public class D_Contacte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_Contacte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur usr = (Utilisateur) session.getAttribute("demandeur"); 
		ManagerUtilisateur mngUsr = new ManagerUtilisateur();
		ManagerMessage mngMsg = new ManagerMessage();
		
		request.setAttribute("msgRecus",mngMsg.fct_getAllByReceiver(usr.getId()));	
		request.setAttribute("msgEnvoyes",mngMsg.fct_getAllBySender(usr.getId()));
		request.setAttribute("receivers",mngUsr.fct_findMesProprietaire(usr.getId()));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Demandeur/contacte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur demandeur = (Utilisateur)session.getAttribute("demandeur");
		
		String form = request.getParameter("form");
		
		switch(form) {
		case "envoyer":
			int id_sender = demandeur.getId();
			Integer id_receiver = Integer.parseInt(request.getParameter("id_receiver"));
			String message = request.getParameter("message");
			ManagerMessage mngMsg = new ManagerMessage();
			mngMsg.fct_sendMessage(id_sender, id_receiver, message);
			
			break;
		}
	}

}
