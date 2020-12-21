package beansManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ReponseForum;
import database.DataBase;

public class ManagerReponseForum {
	
	public boolean fct_supprimerRepPub(int id_pub) {
		Connection connexion = null;
		PreparedStatement preparedStmt = null;
		boolean status = false;
		
		try {
			connexion = DataBase.connection();
			preparedStmt = connexion.prepareStatement("delete from reponseForum where id_pub=?");
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
	
	public boolean fct_supprimer(int id_rep) {
		Connection connexion = null;
		PreparedStatement preparedStmt = null;
		boolean status = false;
		
		try {
			connexion = DataBase.connection();
			preparedStmt = connexion.prepareStatement("delete from reponseForum where id=?");
			preparedStmt.setInt(1,id_rep);
			
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
	
	public boolean fct_insert(ReponseForum rf) {
		Connection connexion = null;
		PreparedStatement preparedStmt = null;
		boolean status = false;
		
		try {
			connexion = DataBase.connection();
			preparedStmt = connexion.prepareStatement("insert into reponseforum(reponse,id_pub,id_user) values(?,?,?)");
			preparedStmt.setString(1,rf.getReponse());
			preparedStmt.setInt(2,rf.getIdPub());
			preparedStmt.setInt(3,rf.getIdUser());
			
			status = preparedStmt.execute();
			
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
	
	public ArrayList<ReponseForum> fct_findReponses(int id_pub) {
		ArrayList<ReponseForum> rfs = new ArrayList<ReponseForum>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
			try {
				connexion = DataBase.connection();
				preparedStatement = connexion.prepareStatement("select rf.*, u.nom, u.prenom from reponseforum rf, user u where id_pub=? and  rf.id_user=u.id order by rf.date_rep desc");
				preparedStatement.setInt(1, id_pub);
				resultat = preparedStatement.executeQuery();

				while (resultat.next()) {
					ReponseForum rf = new ReponseForum();
					
					rf.setId(resultat.getInt("id"));
					rf.setReponse(resultat.getString("reponse"));
					rf.setDateRep(resultat.getString("date_rep"));
					rf.setIdPub(resultat.getInt("id_pub"));
					rf.setIdUser(resultat.getInt("id_user"));
					rf.setNom(resultat.getString("nom"));
					rf.setPrenom(resultat.getString("prenom"));
					
					
					rfs.add(rf);

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

		return rfs;

	}

}
