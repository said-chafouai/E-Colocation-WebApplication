package beansManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Forum;
import beans.ReponseForum;
import database.DataBase;

public class ManagerForum {
	
	public boolean fct_supprimerPub(int id_pub) {
		Connection connexion = null;
		PreparedStatement preparedStmt = null;
		boolean status = false;
		
		try {
			connexion = DataBase.connection();
			preparedStmt = connexion.prepareStatement("delete from forum where id=?");
			preparedStmt.setInt(1,id_pub);
			
			preparedStmt.execute();
			status = true;
			
		}catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (preparedStmt != null)
					preparedStmt.close();
				if (connexion != null)
					connexion.close();
			} catch (SQLException ignore) {

			}
		}
		return status;
	}
		
	public boolean fct_insert(Forum forum) {
		Connection connexion = null;
		PreparedStatement preparedStmt = null;
		boolean status = false;
		
		try {
			connexion = DataBase.connection();
			preparedStmt = connexion.prepareStatement("insert into forum(pub,id_user) values(?,?)");
			preparedStmt.setString(1,forum.getPub());
			preparedStmt.setInt(2,forum.getIdUser());
			
			preparedStmt.execute();
			status = true;
			
		}catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (preparedStmt != null)
					preparedStmt.close();
				if (connexion != null)
					connexion.close();
			} catch (SQLException ignore) {

			}
		}
		return status;
	}
	
	public ArrayList<Forum> fct_findAll(){
		ArrayList<Forum> forums = new ArrayList<Forum>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
			try {
				connexion = DataBase.connection();
				preparedStatement = connexion.prepareStatement("select f.*, u.prenom, u.nom from forum f, user u where f.id_user=u.id order by f.date_pub desc;");
				resultat = preparedStatement.executeQuery();

				while (resultat.next()) {
					Forum forum = new Forum();
					
					forum.setId(resultat.getInt("id"));
					forum.setPub(resultat.getString("pub"));
					forum.setDatePub(resultat.getString("date_pub"));
					forum.setNom(resultat.getString("nom"));
					forum.setPrenom(resultat.getString("prenom"));
					forum.setIdUser(resultat.getInt("id_user"));
				
					ArrayList<ReponseForum> reponses = new ArrayList<ReponseForum>();
					PreparedStatement ps = connexion.prepareStatement("select * from reponseforum where id_pub=?");
					ps.setInt(1, forum.getId());
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						ReponseForum rf = new ReponseForum();
						rf.setId(rs.getInt("id"));
						rf.setReponse(rs.getString("reponse"));
						rf.setDateRep(rs.getString("date_rep"));
						rf.setIdPub(rs.getInt("id_pub"));
						rf.setIdUser(rs.getInt("id_user"));
						
						reponses.add(rf);
					}
						
					forum.setReponsesPub(reponses);
					
					forums.add(forum);

				}

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					if (resultat != null)
						resultat.close();
					if (preparedStatement != null)
						preparedStatement.close();
					if (connexion != null)
						connexion.close();
				} catch (SQLException ignore) {

				}
			}

		return forums;

	}

}
