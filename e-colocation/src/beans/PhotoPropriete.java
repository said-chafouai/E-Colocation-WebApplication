package beans;

public class PhotoPropriete {
	private int id;
	private int id_pro;
	private String chemin;
	
	
	public PhotoPropriete() {
	}
	
	public PhotoPropriete(int id_pro, String chemin) {
		this.id_pro = id_pro; 
		this.chemin = chemin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_pro() {
		return id_pro;
	}

	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	
	

}
