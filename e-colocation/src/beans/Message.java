package beans;

public class Message {
	private int id;
	private String message;
	private int id_sender;
	private int id_receiver;
	private String date;
	private String nomSender;
	private String prenomSender;
	
	
	
	public String getNomSender() {
		return nomSender;
	}
	public void setNomSender(String nomSender) {
		this.nomSender = nomSender;
	}
	public String getPrenomSender() {
		return prenomSender;
	}
	public void setPrenomSender(String prenomSender) {
		this.prenomSender = prenomSender;
	}
	public int getId_sender() {
		return id_sender;
	}
	public void setId_sender(int id_sender) {
		this.id_sender = id_sender;
	}
	public int getId_receiver() {
		return id_receiver;
	}
	public void setId_receiver(int id_receiver) {
		this.id_receiver = id_receiver;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
