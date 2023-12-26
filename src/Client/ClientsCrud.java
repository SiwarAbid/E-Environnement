package Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Connexion.ConnexionBD;
import Crud.Crud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ClientsCrud implements Crud<Client>{

	
	@Override
	public ObservableList<Client> getAll() {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Client c;
		ObservableList<Client> clients=FXCollections.observableArrayList();
		
		try {
			ps=ConnexionBD.getCon().prepareStatement("SELECT * FROM `utilisateur` ;");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				c= new Client(rs.getInt("CIN"),rs.getString("NOM"),rs.getString("PRENOM"),rs.getString("EMAIL"),rs.getInt("TELEPHONE"),rs.getString("ADRESSE"),rs.getString("MOTDEPASSE"));
				clients.add(c);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public int add(Client c) {
		// TODO Auto-generated method stub
		try {
			System.out.println("*********** ADD METHODE ********* ");
			PreparedStatement ps;

			ps=ConnexionBD.getCon().prepareStatement("INSERT INTO `utilisateur`( `nom`, `prenom`, `email`, `telephone`, `adresse`, `motdepasse`)  VALUES (?,?,?,?,?,?);");
			
			ps.setString(1,c.getNom());
			ps.setString(2,c.getPrenom());
			ps.setString(3,c.getEmail());
			ps.setInt(4, c.getTelephone());
			ps.setString(5, c.getAdresse());
			ps.setString(6,c.getMdp());

			ps.executeUpdate();
			 
			//System.out.println("Insertion éffectuée avec succés du CLIENT");
			JOptionPane.showConfirmDialog(null, "Insertion effectuée avec succés du CLIENT","Message",JOptionPane.PLAIN_MESSAGE);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}

	@Override
	public int delete(Client c) {
		// TODO Auto-generated method stub
		try {
			
			 PreparedStatement ps;
			 
			ps= ConnexionBD.getCon().prepareStatement("DELETE FROM `utilisateur` WHERE cin="+c.getCin());
			ps.executeUpdate();
			
			//System.out.println("Suppression éffectuée avec succés du CLIENT");
			JOptionPane.showConfirmDialog(null, "Suppression effectuée avec succés du CLIENT","Message",JOptionPane.PLAIN_MESSAGE);

			
		
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Client c) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps;
			ps= ConnexionBD.getCon().prepareStatement("UPDATE `utilisateur` SET `nom`=?,`prenom`=?,`email`=?,`telephone`=?,`adresse`=?, `motdepasse`=? WHERE cin="+c.getCin());
			
			ps.setString(1,c.getNom());
			ps.setString(2,c.getPrenom());
			ps.setString(3,c.getEmail());
			ps.setInt(4,c.getTelephone());
			ps.setString(5,c.getAdresse());
			ps.setString(6,c.getMdp());
			
			ps.executeUpdate();
			
			 //System.out.println("Update éffectuée avec succés du CLIENT");
			JOptionPane.showConfirmDialog(null, "Update effectuée avec succés du CLIENT","Message",JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean verifierLogin(String userName,String password) {
		PreparedStatement ps;
		Client c;
		
		try {
			ps=ConnexionBD.getCon().prepareStatement("SELECT * FROM `utilisateur` WHERE `nom`=? AND `motdepasse`=?;");
			ps.setString(1,userName);
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return true;
			
			/**
			 * La méthode next() permet de passer à l'enregistrement suivant 
			 * dans le ResultSet et de renvoyer un booléen qui indique si un 
			 * enregistrement suivant existe ou non. La première fois que vous
			 *  appelez next(), le curseur est placé avant le premier enregistrement,
			 *   donc la première fois que vous appelez rs.next(), cela renvoie true 
			 *   si un enregistrement est trouvé et false sinon.
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return false;
			
		}

	@Override
	public ObservableList<Client> get(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Client c;
		ObservableList<Client> clients=FXCollections.observableArrayList();
		
		try {
			ps=ConnexionBD.getCon().prepareStatement("SELECT * FROM `utilisateur` WHERE cin="+id+";");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				c= new Client(rs.getInt("CIN"),rs.getString("NOM"),rs.getString("PRENOM"),rs.getString("EMAIL"),rs.getInt("TELEPHONE"),rs.getString("ADRESSE"),rs.getString("MOTDEPASSE"));
				clients.add(c);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}
}
