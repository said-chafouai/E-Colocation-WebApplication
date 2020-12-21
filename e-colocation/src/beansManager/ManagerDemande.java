package beansManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Demande;
import database.DataBase;

public class ManagerDemande {
	/*
	 * Retourne les demandes envoyes par les demandeur 
	 * selon le statut entre comme parametre
	 * en_attante : tous les demande envoye
	 * rejetee : les demande rejeter
	 * validee : les residants
	 * */
	public ArrayList<Demande> fct_findDemandeByProprietaire(int id_proprietaire, String statut) {
		ArrayList<Demande> demandes = new ArrayList<Demande>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {			
			connexion = DataBase.connection();
			preparedStatement = connexion.prepareStatement("select d.* from demande d, propriete p, user u where u.id=? and u.id = p.id_proprietaire and d.id_prop = p.id and d.statut=?;");
			preparedStatement.setInt(1,id_proprietaire);
			preparedStatement.setString(2,statut);
			result = preparedStatement.executeQuery();
			
			while (result.next()) {
				Demande demande = new Demande();
				
				demande.setId(result.getInt("id"));
				demande.setDate(result.getDate("date"));
				demande.setId_user(result.getInt("id_user"));
				demande.setId_prop(result.getInt("id_prop"));
				demande.setStatut(result.getString("statut"));
				
				demandes.add(demande);

			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(connexion != null)
					connexion.close();
				if(preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}
			
		}
		
		return demandes;
		
	}
	
	/*
	 * Retourne les demande envoye par un demandeur
	 * selon un staut
	 * */
	public ArrayList<Demande> fct_findDemandeByDemandeur(int id_demandeur,String statut) {
		ArrayList<Demande> demandes = new ArrayList<Demande>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {			
			connexion = DataBase.connection();
			preparedStatement = connexion.prepareStatement("select * from demande where id_user=? and statut=?");
			preparedStatement.setInt(1,id_demandeur);
			preparedStatement.setString(2,statut);
			result = preparedStatement.executeQuery();
			
			while (result.next()) {
				Demande demande = new Demande();
				
				demande.setId(result.getInt("id"));
				demande.setDate(result.getDate("date"));
				demande.setId_user(result.getInt("id_user"));
				demande.setId_prop(result.getInt("id_prop"));
				demande.setStatut(result.getString("statut"));
				
				demandes.add(demande);

			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(connexion != null)
					connexion.close();
				if(preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}
			
		}
		
		return demandes;
		
	}
	/*
	 * Changer le statut d'une demande en (en_attente, rejetee, validee)
	 * */
	public boolean fct_updateStatut(int id_demande,String statut) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		boolean retour = false;
		
		
		try {			
			connexion = DataBase.connection();
			preparedStatement = connexion.prepareStatement("update demande set statut=? where id=?");
			preparedStatement.setString(1,statut);
			preparedStatement.setInt(2,id_demande);
			retour = preparedStatement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(connexion != null)
					connexion.close();
				if(preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}
			
		}
		
		return retour;
	}
	
	/*
	 * Insert une demande quand un demandeur fait une demande
	 * statut (en_attent,rejetee,validee)
	 * */
	public boolean fct_insert(int id_propriete,int id_demandeur,String statut) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		boolean retour = false;
		
		
		try {
			java.util.Date javaDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
			
			connexion = DataBase.connection();
			preparedStatement = connexion.prepareStatement("insert into demande(date,id_user,id_prop,statut) values(?,?,?,?); ");
			preparedStatement.setDate(1,sqlDate);
			preparedStatement.setInt(2, id_demandeur);
			preparedStatement.setInt(3, id_propriete);
			preparedStatement.setString(4, statut);
			preparedStatement.execute();
			retour = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(connexion != null)
					connexion.close();
				if(preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}
			
		}
		
		return retour;
	}

}
