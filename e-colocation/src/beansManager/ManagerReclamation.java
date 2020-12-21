package beansManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Reclamation;
import database.DataBase;

public class ManagerReclamation {
	
	public boolean fct_insert(Reclamation reclamation) {
		Connection connexion = null;
		PreparedStatement preparedStmt = null;
		boolean retour = false;
		
		try {
			connexion = DataBase.connection();
			preparedStmt = connexion.prepareStatement("insert into reclamation(type, reclamation, id_user, id_prop) values(?,?,?,?)");
			preparedStmt.setString(1,reclamation.getType());
			preparedStmt.setString(2,reclamation.getReclamation());
			preparedStmt.setInt(3,reclamation.getId_user());
			preparedStmt.setInt(4,reclamation.getId_pro());
			preparedStmt.execute();
			retour = true;
			
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
		return retour;
	}
	
	public ArrayList<Reclamation> fct_findAllByOwner(int id_user) {
		ArrayList<Reclamation> reclamations = new ArrayList<Reclamation>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
			try {
				connexion = DataBase.connection();
				preparedStatement = connexion.prepareStatement("select r.*,adresse from reclamation r, propriete p where id_user=? and r.id_prop=p.id");
				preparedStatement.setInt(1, id_user);
				resultat = preparedStatement.executeQuery();

				while (resultat.next()) {;
					Reclamation reclamation = new Reclamation();
					
					reclamation.setId(resultat.getInt("id"));
					reclamation.setType(resultat.getString("type"));
					reclamation.setReclamation(resultat.getString("reclamation"));
					reclamation.setDate(resultat.getString("date"));
					reclamation.setId_user(resultat.getInt("id_user"));
					reclamation.setId_pro(resultat.getInt("id_prop"));
					reclamation.setAddress(resultat.getString("adresse"));
					
					reclamations.add(reclamation);

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

		return reclamations;

	}
}
