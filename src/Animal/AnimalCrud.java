package Animal;

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


public class AnimalCrud implements Crud<Animal>{

	@Override
	public ObservableList<Animal> getAll() {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Animal a;
		//List<Animal> animals=new ArrayList<Animal>();
		ObservableList<Animal> animals =FXCollections.observableArrayList();
		
		try {
			ps=ConnexionBD.getCon().prepareStatement("SELECT * FROM `animal` ;");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				a= new Animal(rs.getInt("ID"),rs.getString("TYPE"),rs.getString("NOM"),rs.getInt("STOCK"));
				animals.add(a);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return animals;
	}

	@Override
	public int add(Animal a) {
		// TODO Auto-generated method stub
		try {
			System.out.println("*********** ADD METHODE ********* ");
			PreparedStatement ps;

			ps=ConnexionBD.getCon().prepareStatement("INSERT INTO `animal`( `id`,`type`, `nom`, `stock`)  VALUES (?,?,?,?);");
			
			ps.setInt(1,a.getId());
			ps.setString(2,a.getType());
			ps.setString(3,a.getNom());
			ps.setInt(4,a.getStock());
			
			ps.executeUpdate();
			 
			//System.out.println("Insertion éffectuée avec succés du ANIMAL");
			JOptionPane.showConfirmDialog(null, "Insertion effectuée avec succés du ANIMAL","Message",JOptionPane.PLAIN_MESSAGE);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		return 0;
	}

	@Override
	public int delete(Animal a) {
		// TODO Auto-generated method stub
		 try {
				
			 PreparedStatement ps;
			 
			ps= ConnexionBD.getCon().prepareStatement("DELETE FROM `animal` WHERE id="+a.getId());
			ps.executeUpdate();
			
			//System.out.println("Suppression éffectuée avec succés du ANIMAL");
			JOptionPane.showConfirmDialog(null, "Suppression effectuée avec succés du ANIMAL","Message",JOptionPane.PLAIN_MESSAGE);

			
		
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return 0;
	}

	@Override
	public int update(Animal a) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps;
			ps= ConnexionBD.getCon().prepareStatement("UPDATE `animal` SET `type`=?,`nom`=?,`stock`=? WHERE  id="+a.getId());
			
			ps.setString(1,a.getType());
			ps.setString(2,a.getNom());
			ps.setInt(3,a.getStock());
			
			ps.executeUpdate();
			
			 //System.out.println("Update éffectuée avec succés du ANIMAL");
			 JOptionPane.showConfirmDialog(null, "Update effectuée avec succés du ANIMAL","Message",JOptionPane.PLAIN_MESSAGE);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ObservableList<Animal> get(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Animal a;
		//List<Animal> animals=new ArrayList<Animal>();
		ObservableList<Animal> animals =FXCollections.observableArrayList();
		
		try {
			ps=ConnexionBD.getCon().prepareStatement("SELECT * FROM `animal` WHERE  id="+id+";");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				a= new Animal(rs.getInt("ID"),rs.getString("TYPE"),rs.getString("NOM"),rs.getInt("STOCK"));
				animals.add(a);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return animals;
	}

}
