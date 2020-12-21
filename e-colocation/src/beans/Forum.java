package beans;

import java.util.ArrayList;

public class Forum {
	private int id ;
	private String pub;
	private String datePub;
	private int idUser;
	private String nom;
	private String prenom;
	ArrayList<ReponseForum> reponsesPub;
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	public String getDatePub() {
		return datePub;
	}
	public void setDatePub(String date_pub) {
		this.datePub = date_pub;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int id_user) {
		this.idUser = id_user;
	}
	public ArrayList<ReponseForum> getReponsesPub() {
		return reponsesPub;
	}
	public void setReponsesPub(ArrayList<ReponseForum> reponsesPub) {
		this.reponsesPub = reponsesPub;
	}
	
	
	
	
}
