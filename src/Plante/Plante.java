package Plante;

import Animal.Animal;

public class Plante extends Animal{

	/**
	 * CONSTRUCTEUR
	 */
	
	public Plante(int id,String type, String nom, int stock) {
		super(id,type, nom, stock);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * TOSTRING()
	 */	
	
	public String toString() {
		return "Plante "+getId()+" de type: "+getType()+". Son nom est "+getNom()+" ("+stock+")\n";
		
	}

}
