package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBD {

	private static Connection connexion;

	static  {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver avec succes");
			connexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/ENVIRONNEMENT","root","");
			//System.out.println("Connexion établie avec succes");
			//System.out.println("*********** CONNEXION  ********* ");

			//System.out.println(ConnexionBD.getCon());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Connection getCon() {
		//System.out.println(connexion);

		return connexion;}
	/**
	 * Probleme Connexion: d'hors cette class le connexion = null 
	 */
}
