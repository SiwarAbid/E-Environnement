package Controller;

import java.io.IOException;

import Client.Client;
import Client.ClientsCrud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SinsecrirClientController {

	@FXML
	private Button bInscrir;
	@FXML
	private Hyperlink hCompte;
	
	
	@FXML
    private TextField txtCin;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrenom;

    @FXML
    private TextField txtAdr;
    
    @FXML
    private TextField txtTlf;

    @FXML
    private TextField txtMdp;

    @FXML
    private TextField txtMail;
	
	// Event Listener on Button [#bInscrir].onAction
		@FXML
		public void actionInscrir(ActionEvent event) {
			try {
				int cin= Integer.parseInt(txtCin.getText());
				String nom= txtNom.getText();
				String prenom= txtPrenom.getText();
				String adr= txtAdr.getText();
				String mail= txtMail.getText();
				int tlf= Integer.parseInt(txtTlf.getText());
				String mdp= txtMdp.getText();
	    	
				Client c= new Client(cin,nom,prenom,mail,tlf,adr,mdp);
				ClientsCrud cc= new ClientsCrud();
			cc.add(c);
			
			Parent root= FXMLLoader.load(getClass().getResource("/View/Accueil.fxml"));
		

		    Scene scene = new Scene(root);
		    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    stage.setTitle("E-Environement");
		    stage.setScene(scene);
		    stage.show();
		    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// Event Listener on Hyperlink [#hCompte].onAction
				@FXML
				public void actionConnexion(ActionEvent event) {
					try {
					Parent root= FXMLLoader.load(getClass().getResource("/View/Connexion.fxml"));
				

				    Scene scene = new Scene(root);
				    Stage stage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
				    stage.setTitle("E-Environement");
				    stage.setScene(scene);
				    stage.show();
				    
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
}
