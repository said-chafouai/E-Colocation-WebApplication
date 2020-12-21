package servletsDemandeur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Forum;
import beans.ReponseForum;
import beans.Utilisateur;
import beansManager.ManagerForum;
import beansManager.ManagerReponseForum;

/**
 * Servlet implementation class D_Forum
 */
@WebServlet("/D_Forum")
public class D_Forum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public D_Forum() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerForum mgf = new ManagerForum();
		request.setAttribute("publications", mgf.fct_findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSPFiles/Demandeur/forum.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user;
		
		if(session.getAttribute("demandeur") != null) {
			user = (Utilisateur)session.getAttribute("demandeur");
		}else {
			user = (Utilisateur)session.getAttribute("proprietaire");
		}
		String form = request.getParameter("form");
		ManagerReponseForum mrf = new ManagerReponseForum(); 
		PrintWriter out = response.getWriter();
		
		
		switch(form) {
		case "insertReponse":
			ReponseForum rf = new ReponseForum();
			mrf = new ManagerReponseForum();
			rf.setIdPub(Integer.parseInt(request.getParameter("idPub")));
			rf.setReponse(request.getParameter("reponse"));
			rf.setIdUser(user.getId());
			mrf.fct_insert(rf); 
			out.print("insertion avec succes");
			break;
		case "insertPub":
			String pub = request.getParameter("pub");
			ManagerForum mf = new ManagerForum();
			Forum forum = new Forum(); 
			forum.setPub(pub);
			forum.setIdUser(user.getId());
			mf.fct_insert(forum); 
			out.print("Operation reussit Acualiser la page SVP");
			break;
		case "afficherRep":
			int id_pub = Integer.parseInt(request.getParameter("id"));
			ArrayList<ReponseForum> rfs = mrf.fct_findReponses(id_pub);
			
			out = response.getWriter();
			String reponse = new String();
			System.out.println(rfs.size());
			for(int i=0; i < rfs.size() ; i++) {
				reponse += "<div class='alert alert-warning'>"
						+"<span><b>"+ rfs.get(i).getNom()+" "+ rfs.get(i).getPrenom()+" | <small>"+ rfs.get(i).getDateRep()+"</small></b><br>"
						+ rfs.get(i).getReponse()+"</span>"
						+"</div>";
			}
			out.print(reponse);	
			break;
			
		}
	}

}
