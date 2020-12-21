package beansManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.PhotoPropriete;
import database.DataBase;

public class ManagerPhotoPropriete {
	
	public ArrayList<PhotoPropriete> fct_findPhotosByPropriete(int id_pro) {
		ArrayList<PhotoPropriete> pps = new ArrayList<PhotoPropriete>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
			try {
				connexion = DataBase.connection();
				preparedStatement = connexion.prepareStatement("select chemin from photos where id_prop=?");
				preparedStatement.setInt(1, id_pro);
				resultat = preparedStatement.executeQuery();

				while (resultat.next()) {
					PhotoPropriete pp = new PhotoPropriete();
					pp.setChemin(resultat.getString("chemin"));
					pps.add(pp);

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

		return pps;

	}
	public boolean fct_insert(PhotoPropriete pp) {
		Connection connexion = null;
		PreparedStatement preparedStmt = null;
		boolean retour = false;
		
		try {
			connexion = DataBase.connection();
			preparedStmt = connexion.prepareStatement("insert into photos(id_prop, chemin) values(?,?)");
			preparedStmt.setInt(1,pp.getId_pro());
			preparedStmt.setString(2,pp.getChemin());
			
			retour = preparedStmt.execute();
			
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

}
