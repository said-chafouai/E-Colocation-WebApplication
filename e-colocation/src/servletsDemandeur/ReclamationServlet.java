package servletsDemandeur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Reclamation;
import beans.Utilisateur;
import beansManager.ManagerPropriete;
import beansManager.ManagerReclamation;

@WebServlet("/ReclamationServlet")
public class ReclamationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ReclamationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute("demandeur");
		ManagerPropriete mngP = new ManagerPropriete();
		ManagerReclamation mngR = new ManagerReclamation();
		request.setAttribute("reclamations",mngR.fct_findAllByOwner(user.getId()));
		request.setAttribute("proprietes",mngP.fct_findMesPropriete(user.getId()));	
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Demandeur/d_reclamation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute("demandeur");
		
		String type = request.getParameter("type");
		System.out.println(type);
		String reclamation = request.getParameter("reclamation");
		int id_pro = Integer.parseInt(request.getParameter("id_pro"));
		int id_user = user.getId();
		
		ManagerReclamation mngR = new ManagerReclamation();
		Reclamation rec = new Reclamation(type,reclamation,id_user,id_pro);
		
		if(mngR.fct_insert(rec)) System.out.println("insertion reussit");
		doGet(request,response);
	}

}
