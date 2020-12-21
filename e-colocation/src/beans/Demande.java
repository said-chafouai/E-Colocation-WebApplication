package beans;

import java.sql.Date;

public class Demande {
	private int id;
	private Date date;
	private int id_user;
	private int id_prop;
	private String statut;
	
	
	
	
	public Demande() {
	}
	public Demande(int id, Date date, int id_user, int id_prop, String statut) {
		super();
		this.id = id;
		this.date = date;
		this.id_user = id_user;
		this.id_prop = id_prop;
		this.statut = statut;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_prop() {
		return id_prop;
	}
	public void setId_prop(int id_prop) {
		this.id_prop = id_prop;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}

	
	

}
