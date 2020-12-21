package beans;

public class Reclamation {
	private int id;
	private String type;
	private String reclamation;
	private String date;
	private int id_user;
	private int id_pro;
	private String address;
	
	
	
	
	public Reclamation() {
		super();
	}
	public Reclamation(String type, String reclamation, int id_user, int id_pro) {
		super();
		this.type = type;
		this.reclamation = reclamation;
		this.id_user = id_user;
		this.id_pro = id_pro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReclamation() {
		return reclamation;
	}
	public void setReclamation(String reclamation) {
		this.reclamation = reclamation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
