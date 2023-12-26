package Animal;

public class Animal {
	
	/**
	 * LES ATTREBUS
	 */
	
	private int id;
	private String type;
	private String nom;
	protected int stock;
	
	
	/**
	 * CONSTRUCTEUR
	 */
	
	public Animal(int id, String nom, String type, int stock) {
		this.id=id;
		this.type=type;
		this.nom=nom;
		this.stock=stock;
	}
	
	/**
	 * GETTER && SETTER
	 */
	
	/***** ID ******/
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	/***** TYPE ******/
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	/***** NOM ******/
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	/***** STOCK ******/
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

	
	/**
	 * TOSTRING()
	 */
	
	public String toString() {
		return "Animal "+this.id+" de type: "+this.type+". Son nom est "+this.nom+" ("+this.stock+")\n";
	}
}
