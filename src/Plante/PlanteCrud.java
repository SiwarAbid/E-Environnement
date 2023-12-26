package Plante;

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

public class PlanteCrud implements Crud<Plante>{

	@Override
	public ObservableList<Plante> getAll() {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Plante p;
		ObservableList<Plante> plantes=FXCollections.observableArrayList();
		
		try {
			ps=ConnexionBD.getCon().prepareStatement("SELECT * FROM `plante` ;");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				p= new Plante(rs.getInt("ID"),rs.getString("TYPE"),rs.getString("NOM"),rs.getInt("STOCK"));
				plantes.add(p);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plantes;
	}

	@Override
	public int add(Plante p) {
		// TODO Auto-generated method stub
		try {
			System.out.println("*********** ADD METHODE ********* ");
			PreparedStatement ps;

			ps=ConnexionBD.getCon().prepareStatement("INSERT INTO `plante`( `type`, `nom`, `stock`)  VALUES (?,?,?);");
			
			ps.setString(1,p.getType());
			ps.setString(2,p.getNom());
			ps.setInt(3,p.getStock());
			
			ps.executeUpdate();
			 
			//System.out.println("Insertion éffectuée avec succés du PLANTE");
			JOptionPane.showConfirmDialog(null, "Insertion effectuée avec succés du PLANTE","Message",JOptionPane.PLAIN_MESSAGE);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		return 0;
	}

	@Override
	public int delete(Plante p) {
		// TODO Auto-generated method stub
		try {
			
			 PreparedStatement ps;
			 
			ps= ConnexionBD.getCon().prepareStatement("DELETE FROM `plante` WHERE id="+p.getId());
			ps.executeUpdate();
			
			System.out.println("Suppression effectuée avec succés du PLANTE");
			JOptionPane.showConfirmDialog(null, "Suppression effectuée avec succés du PLANTE","Message",JOptionPane.PLAIN_MESSAGE);

			
		
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return 0;
	}

	@Override
	public int update(Plante p) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps;
			ps= ConnexionBD.getCon().prepareStatement("UPDATE `plante` SET `type`=?,`nom`=?,`stock`=? WHERE  id="+p.getId());
			
			ps.setString(1,p.getType());
			ps.setString(2,p.getNom());
			ps.setInt(3,p.getStock());
			
			ps.executeUpdate();
			
			 //System.out.println("Update éffectuée avec succés du PLANTE");
			JOptionPane.showConfirmDialog(null, "Update effectuée avec succés du PLANTE","Message",JOptionPane.PLAIN_MESSAGE);

			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ObservableList<Plante> get(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Plante p;
		ObservableList<Plante> plantes=FXCollections.observableArrayList();
		
		try {
			ps=ConnexionBD.getCon().prepareStatement("SELECT * FROM `plante` WHERE id="+id+";");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				p= new Plante(rs.getInt("ID"),rs.getString("TYPE"),rs.getString("NOM"),rs.getInt("STOCK"));
				plantes.add(p);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plantes;
	}

}
