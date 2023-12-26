package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CrudController {

	@FXML
	private Button bPlante;
	
	@FXML
	private Button bAnimal;
	
	
	
	@FXML
	private Button bRetour;
	
	@FXML
	private Button bDescription;
	
	// Event Listener on Button[#bPlante].onAction
		@FXML
		public void actionPlante(ActionEvent event) {
			try {
				
				Parent root = null;
				
				if(bPlante.getText().equals("Insert Plante") ) 
					root = FXMLLoader.load(getClass().getResource("/View/InsertPlante.fxml"));
				else if(bPlante.getText().equals( "Delete Plante"))
					root = FXMLLoader.load(getClass().getResource("/View/DeletePlante.fxml"));
				else if(bPlante.getText().equals("Update Plante"))
					root = FXMLLoader.load(getClass().getResource("/View/UpdatePlante.fxml"));
				else
					root = FXMLLoader.load(getClass().getResource("/View/DescriptionPlante.fxml"));

	
		    Scene scene = new Scene(root);
		    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setTitle(bPlante.getText());
		    stage.setScene(scene);
		    stage.show();
		    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	// Event Listener on Button[#bAnimal].onAction
		@FXML
		public void actionAnimal(ActionEvent event) {
			try {
				
				Parent root = null;
				
				if(bAnimal.getText().equals("Insert Animal") ) 
					root = FXMLLoader.load(getClass().getResource("/View/InsertAnimal.fxml"));
				else if(bAnimal.getText().equals ("Delete Animal"))
					root = FXMLLoader.load(getClass().getResource("/View/DeleteAnimal.fxml"));
				else if(bAnimal.getText().equals ("Update Animal"))
					root = FXMLLoader.load(getClass().getResource("/View/UpdateAnimal.fxml"));
				else
					root = FXMLLoader.load(getClass().getResource("/View/DescriptionAnimal.fxml"));
		

		    Scene scene = new Scene(root);
		    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setTitle(bAnimal.getText());
		    stage.setScene(scene);
		    stage.show();
		    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
	// Event Listener on Button[#bRetour].onAction
		@FXML
		public void actionRetour(ActionEvent event) {
			try {
			Parent root= FXMLLoader.load(getClass().getResource("/View/Accueil.fxml"));
		

		    Scene scene = new Scene(root);
		    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setTitle("Votre profil");
		    stage.setScene(scene);
		    stage.show();
		    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Event Listener on Button[#bDescription].onAction
		@FXML
		public void accederDescription(ActionEvent event) {
			try {
			Parent root= FXMLLoader.load(getClass().getResource("/View/Description.fxml"));
		

		    Scene scene = new Scene(root);
		    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setTitle("Votre profil");
		    stage.setScene(scene);
		    stage.show();
		    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
