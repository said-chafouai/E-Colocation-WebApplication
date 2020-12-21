package servletsAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beansManager.ManagerPropriete;

/**
 * Servlet implementation class A_Annonce
 */
@WebServlet("/A_Annonce")
public class A_Annonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_Annonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerPropriete mngProp = new ManagerPropriete();
		request.setAttribute("proprietes",mngProp.fct_findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Admin/annonces.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerPropriete mngP = new ManagerPropriete();
		
		String form = request.getParameter("form");
		int id_annonce = Integer.parseInt(request.getParameter("id"));
		switch(form) {
		case "supprimer":
			mngP.fct_supprimer(id_annonce);
			break;
		}
	}

}
