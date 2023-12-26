package Controller;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ResourceBundle;

import Animal.Animal;
import Animal.AnimalCrud;
//import GestionClients.Client;
//import Connexion.ConnexionBD;
import Plante.Plante;
import Plante.PlanteCrud;
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

public class ProfilClientController implements Initializable{

	@FXML
	private Button bInsertAnimal;
	
	@FXML
	private Button bInsertPlante;
	
	@FXML
	private Button bDelete;
	
	@FXML
	private Button bUpdate;
	@FXML
	private Button bRecherche;
	
	@FXML
	private Button bRetour;
	
	@FXML
	private TableView<Animal> tvAnimal;
	
	@FXML
	private TableView<Plante> tvPlante;
	
	@FXML
	private TableColumn<Animal, Integer> idAnimal ;
	@FXML
	private TableColumn<Animal, String> typeAnimal;
	@FXML
	private TableColumn<Animal, String> nomAnimal ;
	@FXML
	private TableColumn<Animal, Integer> stockAnimal ;
	
	@FXML
	private TableColumn<Plante, Integer> idPlante ;
	@FXML
	private TableColumn<Plante, String> typePlante;
	@FXML
	private TableColumn<Plante, String> nomPlante ;
	@FXML
	private TableColumn<Plante, Integer> stockPlante ;
	
	private ObservableList<Animal> data =FXCollections.observableArrayList();
	
	private ObservableList<Plante> dataPlante =FXCollections.observableArrayList();

	
 	@FXML
    private TextField txtId;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtStock;

    @FXML
    private TextField txtType;
    
    @FXML
    private TextField txtRecherche;
    
    
    
    @FXML
    public void affichetxtAnimal(MouseEvent event) {
    	int selectedIndexAnimal = tvAnimal.getSelectionModel().getSelectedIndex();
    	
    	if (selectedIndexAnimal != -1 ) {
    		Animal a = tvAnimal.getSelectionModel().getSelectedItem() ;
    		
    		txtId.setText(""+a.getId());
        	txtNom.setText(""+a.getNom());
        	txtStock.setText(""+a.getStock());
        	txtType.setText(""+a.getType());
    		}
        }
    	
        @FXML
        public void affichetxtPlante(MouseEvent event) {
        	int selectedIndexPlante = tvPlante.getSelectionModel().getSelectedIndex();
        
        	
        	if(selectedIndexPlante != -1 ) {
        		Plante p = tvPlante.getSelectionModel().getSelectedItem() ;

            	txtId.setText(""+p.getId());
            	txtNom.setText(""+p.getNom());
            	txtStock.setText(""+p.getStock());
            	txtType.setText(""+p.getType());
            }	
    		
    	
    	
    }
    
	
	// Event Listener on Button[#bInsertAnimal].onAction
		@FXML
		public void actionInsertAnimal(ActionEvent event) {
				
	        		int id= Integer.parseInt(txtId.getText());
	    			String nom= txtNom.getText();
	    			String type= txtType.getText();
	    			int stock= Integer.parseInt(txtStock.getText());	
	        	
				Animal a= new Animal(id,nom,type,stock);
				AnimalCrud ac= new AnimalCrud();
				ac.add(a);
				data= ac.getAll();
							
				tvAnimal.setItems(data);

				
	        	
	        
	        	
	        	txtId.setText("");
	        	txtNom.setText("");
	        	txtStock.setText("");
	        	txtType.setText("");
		   
		}
		
		// Event Listener on Button[#bInsertAnimal].onAction
				@FXML
				public void actionInsertPlante(ActionEvent event) {
						
			        		int id= Integer.parseInt(txtId.getText());
			    			String nom= txtNom.getText();
			    			String type= txtType.getText();
			    			int stock= Integer.parseInt(txtStock.getText());	
			        	
						Plante p= new Plante(id,nom,type,stock);
						PlanteCrud pc= new PlanteCrud();
						pc.add(p);
						dataPlante= pc.getAll();
									
						tvPlante.setItems(dataPlante);

			       
			        	txtId.setText("");
			        	txtNom.setText("");
			        	txtStock.setText("");
			        	txtType.setText("");
				   
				}
		
		// Event Listener on Button[#bDelete].onAction
		@FXML
		public void actionDelete(ActionEvent event) {
			
        	int selectedIndexPlante = tvPlante.getSelectionModel().getSelectedIndex();
        	int selectedIndexAnimal = tvAnimal.getSelectionModel().getSelectedIndex();
        	
        	
        	if (selectedIndexAnimal != -1 ) {
        		int id= Integer.parseInt(txtId.getText());
    			String nom= txtNom.getText();
    			String type= txtType.getText();
    			int stock= Integer.parseInt(txtStock.getText());	
        	
			Animal a= new Animal(id,nom,type,stock);
			AnimalCrud ac= new AnimalCrud();
			ac.delete(a);
			data= ac.getAll();
						
			tvAnimal.setItems(data);

			}
        	
        	if(selectedIndexPlante != -1 ) {
        		int id= Integer.parseInt(txtId.getText());
    			String nom= txtNom.getText();
    			String type= txtType.getText();
    			int stock= Integer.parseInt(txtStock.getText());	
        	
			Plante p= new Plante(id,nom,type,stock);
			PlanteCrud pc= new PlanteCrud();
			pc.delete(p);
			dataPlante= pc.getAll();
						
			tvPlante.setItems(dataPlante);

        	}
        	
        	txtId.setText("");
        	txtNom.setText("");
        	txtStock.setText("");
        	txtType.setText("");


			

		}
		
		
		// Event Listener on Button[#bUpdate].onAction
		@FXML
		public void actionUpdate(ActionEvent event) {
			
			int selectedIndexPlante = tvPlante.getSelectionModel().getSelectedIndex();
        	int selectedIndexAnimal = tvAnimal.getSelectionModel().getSelectedIndex();
        	
        	
        	if (selectedIndexAnimal != -1 ) {
        		int id= Integer.parseInt(txtId.getText());
    			String nom= txtNom.getText();
    			String type= txtType.getText();
    			int stock= Integer.parseInt(txtStock.getText());	
        	
			Animal a= new Animal(id,nom,type,stock);
			AnimalCrud ac= new AnimalCrud();
			ac.update(a);
			data= ac.getAll();
						
			tvAnimal.setItems(data);

			}
        	
        	if(selectedIndexPlante != -1 ) {
        		int id= Integer.parseInt(txtId.getText());
    			String nom= txtNom.getText();
    			String type= txtType.getText();
    			int stock= Integer.parseInt(txtStock.getText());	
        	
			Plante p= new Plante(id,nom,type,stock);
			PlanteCrud pc= new PlanteCrud();
			pc.update(p);
			dataPlante= pc.getAll();
						
			tvPlante.setItems(dataPlante);

        	}
        	
        	txtId.setText("");
        	txtNom.setText("");
        	txtStock.setText("");
        	txtType.setText("");
		}

	// Event Listener on Button[#bRecherche].onAction
		@FXML
		public void actionRecherche(ActionEvent event) {
			if(!txtRecherche.getText().equalsIgnoreCase("")) {
			idAnimal.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("id"));
			typeAnimal.setCellValueFactory(new PropertyValueFactory<Animal,String>("type"));
			nomAnimal.setCellValueFactory(new PropertyValueFactory<Animal,String>("nom"));
			stockAnimal.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("stock"));
			
			idPlante.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("id"));
			typePlante.setCellValueFactory(new PropertyValueFactory<Plante,String>("type"));
			nomPlante.setCellValueFactory(new PropertyValueFactory<Plante,String>("nom"));
			stockPlante.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("stock"));
			
			AnimalCrud ac=new AnimalCrud();
			PlanteCrud pc=new PlanteCrud();
			//System.out.println("************");

			data= ac.get(Integer.parseInt(txtRecherche.getText()));
			dataPlante= pc.get(Integer.parseInt(txtRecherche.getText()));
			
			//System.out.println(data);
			tvAnimal.setItems(data);
			tvPlante.setItems(dataPlante);
			}else {
	            URL url;
				try {
					url = new URL("file:/C:/eclipse-workspace/InterfaceClient/bin/View/ProfilClient.fxml");
					initialize(url,null);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
			}
				
			
		}
		// Event Listener on Button[#bRetour].onAction
		@FXML
		public void actionRetour(ActionEvent event) {
			try {
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
		
	
		/**@FXML
	    private void actionAffichageAnimal() {
			
			Connection connexion = ConnexionBD.getCon();	
			
			PreparedStatement ps;
			Animal p;
			try {
				ps=connexion.prepareStatement("Select * from `animal`;");
				ResultSet rs=ps.executeQuery();
				System.out.println("-------------------");
				while (rs.next()) {
					p= new Animal(rs.getInt("ID"),rs.getString("TYPE"),rs.getString("NOM"),rs.getInt("STOCK"));
					data.add(p);
				}
				rs.close();
				
				idAnimal.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("id"));
				typeAnimal.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("type"));
				nomAnimal.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("nom"));
				stockAnimal.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("stock"));
				
				tvAnimal.setItems(data);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			//System.out.println(arg0+"   "+arg1);

			idAnimal.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("id"));
			typeAnimal.setCellValueFactory(new PropertyValueFactory<Animal,String>("type"));
			nomAnimal.setCellValueFactory(new PropertyValueFactory<Animal,String>("nom"));
			stockAnimal.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("stock"));
			
			idPlante.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("id"));
			typePlante.setCellValueFactory(new PropertyValueFactory<Plante,String>("type"));
			nomPlante.setCellValueFactory(new PropertyValueFactory<Plante,String>("nom"));
			stockPlante.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("stock"));
			
			AnimalCrud ac=new AnimalCrud();
			PlanteCrud pc=new PlanteCrud();
			
			data= ac.getAll();
			dataPlante= pc.getAll();
			
			//System.out.println(data);
			tvAnimal.setItems(data);
			tvPlante.setItems(dataPlante);
		}
}
