package servletsAdmin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Propriete;
import beansManager.ManagerMessage;
import beansManager.ManagerPropriete;

/**
 * Servlet implementation class AdminAccueil
 */
@WebServlet("/A_Accueil")
public class A_Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public A_Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerPropriete mngP = new ManagerPropriete();
		ManagerMessage mngMsg = new ManagerMessage();
		ArrayList<Propriete> pros = mngP.fct_findAll();
		int nbMsg = mngMsg.fct_countMessages();
		
		request.setAttribute("countAnnonce", pros.size());
		request.setAttribute("countMsg", nbMsg);
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Admin/accueil.jsp").forward(request, response);

	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
