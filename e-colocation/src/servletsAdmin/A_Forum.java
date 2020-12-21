package servletsAdmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReponseForum;
import beansManager.ManagerForum;
import beansManager.ManagerReponseForum;

/**
 * Servlet implementation class A_Forum
 */
@WebServlet("/A_Forum")
public class A_Forum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public A_Forum() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerForum mgf = new ManagerForum();
		request.setAttribute("publications", mgf.fct_findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Admin/forum.jsp").forward(request, response);}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ManagerForum mngF = new ManagerForum();
		ManagerReponseForum mngRep = new ManagerReponseForum();
		PrintWriter out = response.getWriter();
		
		
		String form = request.getParameter("form");
		
		switch(form) {
		case "supprimerPub":
			int id_pub = Integer.parseInt(request.getParameter("id_pub"));
			mngRep.fct_supprimerRepPub(id_pub);
			mngF.fct_supprimerPub(id_pub);
			System.out.println("supprimerPub");
			break;
			
		case "supprimerRep":
			int id_rep = Integer.parseInt(request.getParameter("id_rep"));
			mngRep.fct_supprimer(id_rep);
			break;
			
		case "afficherRep":
			ManagerReponseForum mrf = new ManagerReponseForum();
			int id_publication = Integer.parseInt(request.getParameter("id_pub"));
			ArrayList<ReponseForum> rfs = mrf.fct_findReponses(id_publication);
			out = response.getWriter();
			String reponse = new String();
			System.out.println(rfs.size());
			for(int i=0; i < rfs.size() ; i++) {
				reponse += "<div class='alert alert-warning'>"
						+"<button class='btn btn-danger pull-right' onClick='supprimerRep("+rfs.get(i).getId()+")'>Supprimer</button>"
						+"<span><b>"+ rfs.get(i).getNom()+" "+ rfs.get(i).getPrenom()+" | <small>"+ rfs.get(i).getDateRep()+"</small></b><br>"
						+ rfs.get(i).getReponse()+"</span>"
						+ "</div>";
			}
			out.print(reponse);	
			break;
			
		}
	}

}
