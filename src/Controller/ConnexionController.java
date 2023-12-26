package Controller;

import java.io.IOException;

import Client.ClientsCrud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ConnexionController {
	@FXML
	private Button bConnecter;
	@FXML
	private Hyperlink HInscrir;
	
	@FXML
    private TextField password;

    @FXML
    private TextField userName;

	// Event Listener on Button[#bConnecter].onAction
	@FXML
	public void actionConnecter(ActionEvent event) {
		try {
		if(ClientsCrud.verifierLogin(userName.getText(),password.getText())) {
			
		
		Parent root= FXMLLoader.load(getClass().getResource("/View/Accueil.fxml"));
	

	    Scene scene = new Scene(root);
	    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setTitle("E-Environement");
	    stage.setScene(scene);
	    stage.show();
	    
		}else {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Attention !");
	        alert.setHeaderText("ERREUR");
	        alert.setContentText("Nom d'utilisateur ou/et Mot de passe est/sont incorrect !!");

	        ButtonType buttonTypeOk= new ButtonType("OK");
	        alert.showAndWait();
		}
	    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Event Listener on Hyperlink [#HInscrir].onAction
	@FXML
	public void actionInscrir(ActionEvent event) {
		try {
		Parent root= FXMLLoader.load(getClass().getResource("/View/SinsecrirClient.fxml"));
	

	    Scene scene = new Scene(root);
	    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setTitle("Insecription");
	    stage.setScene(scene);
	    stage.show();
	    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
