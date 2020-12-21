package servletsDemandeur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansManager.ManagerPropriete;

/**
 * Servlet implementation class FaireRecherche
 */
@WebServlet("/FaireRecherche")
public class FaireRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaireRecherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Demandeur/faire_recherche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prix = request.getParameter("prix");
		if(prix != null) {
			if(prix.equals(""))
				prix = "0";
		
		}
		
		String superficie = request.getParameter("superficie");
		if(superficie != null) {
			if(superficie.equals(""))
				superficie = "0";	
		}
		
		String ville = request.getParameter("ville");

		ManagerPropriete mngProp = new ManagerPropriete();
	    request.setAttribute("proprietes",mngProp.fct_find(Integer.parseInt(prix) ,Integer.parseInt(superficie), ville));
		doGet(request, response);
	}

}
