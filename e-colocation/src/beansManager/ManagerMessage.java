package beansManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Message;
import database.DataBase;


public class ManagerMessage {
	
	public int fct_countMessages(){
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		int nbMsg = 0;

		try {
			connexion = DataBase.connection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("select count(*) from message;");

			resultat.next();
			nbMsg = resultat.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (resultat != null)
					resultat.close();
				if (statement != null)
					statement.close();
				if (connexion != null)
					connexion.close();
			} catch (SQLException ignore) {

			}
		}

		return nbMsg;
	}
	public boolean fct_sendMessage(int id_sender, int id_receiver, String message) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		boolean statut = false;

		try {
			connexion = DataBase.connection();
			preparedStatement = connexion.prepareStatement("insert into message(id_sender,id_receiver,message) values(?,?,?)");
			preparedStatement.setInt(1,id_sender);
			preparedStatement.setInt(2,id_receiver);
			preparedStatement.setString(3,message);
			statut = preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connexion != null)
					connexion.close();
			} catch (SQLException ignore) {

			}
		}

		return statut;

		
	}

	public ArrayList<Message> fct_getAllBySender(int id_user){
		ArrayList<Message> messages = new ArrayList<Message>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
			try {
				connexion = DataBase.connection();
				preparedStatement = connexion.prepareStatement("select r.nom, r.prenom, m.* from message m, user r where id_sender=? and m.id_receiver=r.id order by m.date desc");
				preparedStatement.setInt(1, id_user);
				resultat = preparedStatement.executeQuery();

				while (resultat.next()) {
					Message message = new Message();
					
					message.setId(resultat.getInt("id"));
					message.setMessage(resultat.getString("message"));
					message.setId_sender(resultat.getInt("id_sender"));
					message.setId_receiver(resultat.getInt("id_receiver"));
					message.setNomSender(resultat.getString("nom"));
					message.setPrenomSender(resultat.getString("prenom"));
					message.setDate(resultat.getString("date"));
					
					messages.add(message);

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

		return messages;

	}
	
	public ArrayList<Message> fct_getAllByReceiver(int id_user){
		ArrayList<Message> messages = new ArrayList<Message>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultat = null;
		
			try {
				connexion = DataBase.connection();
				preparedStatement = connexion.prepareStatement("select u.nom, u.prenom, m.* from message m, user u where id_receiver=? and m.id_sender=u.id order by m.date desc");
				preparedStatement.setInt(1, id_user);
				resultat = preparedStatement.executeQuery();

				while (resultat.next()) {
					Message message = new Message();
										
					message.setId(resultat.getInt("id"));
					message.setMessage(resultat.getString("message"));
					message.setId_sender(resultat.getInt("id_sender"));
					message.setId_receiver(resultat.getInt("id_receiver"));
					message.setNomSender(resultat.getString("nom"));
					message.setPrenomSender(resultat.getString("prenom"));
					message.setDate(resultat.getString("date"));
					
					messages.add(message);

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

		return messages;

	}

}
