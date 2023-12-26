package Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

//import Animal.Animal;
//import Animal.AnimalCrud;
import Client.Client;
import Client.ClientsCrud;
//import Plante.Plante;
//import Plante.PlanteCrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InformationsClientController implements Initializable{
	@FXML
	private Button bModifier;
	@FXML
	private Button bAccueil;
	@FXML
	private Button bRetour;
	@FXML
	private Button bInsert;
	@FXML
	private Button bDelete;
	@FXML
	private Button bRecherche;
	
	
	//@FXML
	//private Button bRetour;
	
	@FXML
	private TableView<Client> tableView;
	
	@FXML
	private TableColumn<Client, Integer> cin ;
	@FXML
	private TableColumn<Client, String> nom;
	@FXML
	private TableColumn<Client, String> prenom ;
	@FXML
	private TableColumn<Client, String> adr ;
	@FXML
	private TableColumn<Client, Integer> tlf ;
	@FXML
	private TableColumn<Client, String> mdp;
	@FXML
	private TableColumn<Client, String> mail ;

	
	private ObservableList<Client> data =FXCollections.observableArrayList();
	
	
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
    
    @FXML
    private TextField txtRecherche;

// Event Listener on Button[#bModifier].onAction
	@FXML
	public void actionModifier(ActionEvent event) {
		
			int cin= Integer.parseInt(txtCin.getText());
			String nom= txtNom.getText();
			String prenom= txtPrenom.getText();
			String adr= txtAdr.getText();
			String mdp= txtMdp.getText();
			int tlf= Integer.parseInt(txtTlf.getText());
			String mail= txtMail.getText();
			
			Client c= new Client(cin,nom,prenom,mail,tlf,adr,mdp);
			ClientsCrud cc= new ClientsCrud();
			cc.update(c);
			
			
			data= cc.getAll();
			
			tableView.setItems(data);

	
	}

	
	// Event Listener on Button[#bModifier].onAction
		@FXML
		public void actionInsert(ActionEvent event) {
			
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
		data= cc.getAll();
					
		tableView.setItems(data);

		txtCin.setText("");
    	txtNom.setText("");
    	txtPrenom.setText("");
    	txtAdr.setText("");
    	txtTlf.setText("");
    	txtMail.setText("");
    	txtMdp.setText("");
		}
		
		
		// Event Listener on Button[#bModifier].onAction
		@FXML
		public void actionDelete(ActionEvent event) {
		int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
		        	
		        	
        	if (selectedIndex != -1 ) {
        		int cin= Integer.parseInt(txtCin.getText());
    			String nom= txtNom.getText();
    			String prenom= txtPrenom.getText();
    			String adr= txtAdr.getText();
    			String mail= txtMail.getText();
    			int tlf= Integer.parseInt(txtTlf.getText());
    			String mdp= txtMdp.getText();
    			
    			Client c= new Client(cin,nom,prenom,mail,tlf,adr,mdp);
    			ClientsCrud cc= new ClientsCrud();
			cc.delete(c);
			data= cc.getAll();
						
			tableView.setItems(data);

			txtCin.setText("");
        	txtNom.setText("");
        	txtPrenom.setText("");
        	txtAdr.setText("");
        	txtTlf.setText("");
        	txtMail.setText("");
        	txtMdp.setText("");
			}
        	
			
		}
		
		
		
		// Event Listener on Button[#bModifier].onAction
		@FXML
		public void actionRecherche(ActionEvent event) {
			if(!txtRecherche.getText().equalsIgnoreCase("")) {
				cin.setCellValueFactory(new PropertyValueFactory<Client,Integer>("cin"));
				nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
				prenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
				adr.setCellValueFactory(new PropertyValueFactory<Client,String>("adresse"));
				
				mdp.setCellValueFactory(new PropertyValueFactory<Client,String>("mdp"));
				tlf.setCellValueFactory(new PropertyValueFactory<Client,Integer>("telephone"));
				mail.setCellValueFactory(new PropertyValueFactory<Client,String>("email"));
				
				ClientsCrud cc=new ClientsCrud();
				
				data= cc.get(Integer.parseInt(txtRecherche.getText()));
				
				tableView.setItems(data);
				}else {
		            URL url;
					try {
						url = new URL("file:/C:/eclipse-workspace/InterfaceClient/bin/View/InformationsClient.fxml");
						initialize(url,null);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
				}
		}

// Event Listener on Button[#bAccueil].onAction
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

	

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cin.setCellValueFactory(new PropertyValueFactory<Client,Integer>("cin"));
		nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
		adr.setCellValueFactory(new PropertyValueFactory<Client,String>("adresse"));
		
		mdp.setCellValueFactory(new PropertyValueFactory<Client,String>("mdp"));
		tlf.setCellValueFactory(new PropertyValueFactory<Client,Integer>("telephone"));
		mail.setCellValueFactory(new PropertyValueFactory<Client,String>("email"));
		
		ClientsCrud cc=new ClientsCrud();
		
		data= cc.getAll();
		
		//System.out.println(data);
		tableView.setItems(data);
	}
	
	 @FXML
	    public void affichetxt(MouseEvent event) {
	    	int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
	    	
	    	if (selectedIndex != -1 ) {
	    		Client c = tableView.getSelectionModel().getSelectedItem() ;
	    		
	    		txtCin.setText(""+c.getCin());
	        	txtNom.setText(""+c.getNom());
	        	txtPrenom.setText(""+c.getPrenom());
	        	txtAdr.setText(""+c.getAdresse());
	        	txtTlf.setText(""+c.getTelephone());
	        	txtMail.setText(""+c.getEmail());
	        	txtMdp.setText(""+c.getMdp());
	        	
	        	
	        	
	    		}
	        }
}
