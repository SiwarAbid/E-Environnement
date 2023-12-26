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

public class AccueilController {

	@FXML
	private Button bProfil;
	
	@FXML
	private Button bInfo;
	
	@FXML
	private Button bDescription;
	
	@FXML
	private Button bContact;
	
	@FXML
	private Button bDeconnexion;

	// Event Listener on Button[#bProfil].onAction
	@FXML
	public void accederProfil(ActionEvent event) {
		try {
		Parent root= FXMLLoader.load(getClass().getResource("/View/ProfilClient.fxml"));
	

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
	
	
	// Event Listener on Button[#bInfo].onAction 
		
		public void accederInfo(ActionEvent event) {
			try {
			Parent root= FXMLLoader.load(getClass().getResource("/View/InformationsClient.fxml"));
		

		    Scene scene = new Scene(root);
		    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setTitle("Vos Informations");
		    stage.setScene(scene);
		    stage.show();
		    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// Event Listener on Button[#bDescription].onAction
		
		public void accederDescription(ActionEvent event) {
			try {
			Parent root= FXMLLoader.load(getClass().getResource("/View/Description.fxml"));
		

		    Scene scene = new Scene(root);
		    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setTitle("Description");
		    stage.setScene(scene);
		    stage.show();
		    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// Event Listener on Button[#bContact].onAction
		
		public void accederContact(ActionEvent event) {
			try {
			Parent root= FXMLLoader.load(getClass().getResource("/View/Contacte.fxml"));
		

		    Scene scene = new Scene(root);
		    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setTitle("Contactez-Nous ");
		    stage.setScene(scene);
		    stage.show();
		    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Event Listener on Button[#bDeconnexion].onAction
	
		public void deconnecter (ActionEvent event) {
			try {
			Parent root= FXMLLoader.load(getClass().getResource("/View/AuthentificationClient.fxml"));
		
	
		    Scene scene = new Scene(root);
		    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setTitle("Authentification");
		    stage.setScene(scene);
		    stage.show();
		    
			} catch (IOException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}
