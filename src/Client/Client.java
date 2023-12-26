package Client;

public class Client {
	
	
	/**
	 * LES ATTREBUS
	 */

	private int cin;
	private String nom;
	private String prenom;
	private String email;
	private int telephone;
	private String adresse;
	private String mdp;
	
	

	/**
	 * CONSTRUCTEUR
	 * @param mdp 
	 */
	
	public Client(int cin, String nom, String prenom, String email, int telephone, String adresse, String mdp) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.mdp = mdp;
	}
	
	/**
	 * GETTER && SETTER
	 */
	
	/***** CIN ******/
	public int getCin() {
		return cin;
	}
	
	public void setCin(int cin) {
		this.cin = cin;
	}
	
	
	/***** NOM *****/
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	/**** PRENOM *****/
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	/**** EMAIL *****/
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**** TELEPHONE ****/
	public int getTelephone() {
		return telephone;
	}
	
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	
	/***** ADRESSE *****/
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** MOT DE PASSE**/
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	/**
	 * TOSTRING()
	 */
	
	@Override
	public String toString() {
		return "Client [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone="
				+ telephone + ", adresse=" + adresse + "]\n";
	}
	
}
