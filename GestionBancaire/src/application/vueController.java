package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Compte;

public class vueController implements Initializable {
		Connection cnx;
		public PreparedStatement  st;
		public ResultSet resultat;
	
	    @FXML
	    private ResourceBundle resources;
	    @FXML
	    private Button statistique;
	    @FXML
	    private Button btn_compte_c;

	    @FXML
	    private Button btn_compte_e;

	    @FXML
	    private Button btn_compte_j;

	    @FXML
	    private TextField txt_c_num;

	    @FXML
	    private TextField txt_c_val;

	    @FXML
	    private TextField txt_e_num;

	    @FXML
	    private TextField txt_e_taux;

	    @FXML
	    private TextField txt_e_val;

	    @FXML
	    private TextField txt_j_num;

	    @FXML
	    private TextField txt_j_val;

	    @FXML
	    private TableView<Compte> tableau_compte;

	    @FXML
	    private URL location;

	 	@FXML
	    private Button exitbtn;

	    @FXML
	    private Button helpbtn;

	    @FXML
	    private Button ligneComptabebtn;

	    @FXML
	    private Button listeComptebtn;

	    @FXML
	    private Label titre;
	    
	    @FXML
	    private TextField text_recherche_compte;
  
	    @FXML
	    private GridPane helppane;

	    @FXML
	    private GridPane lignepane;

	    @FXML
	    private GridPane listepane;
	  
	    @FXML
	    private Button comptebtn;
	    
	    @FXML
	    private TableColumn<Compte, Integer> compte_num;

	    @FXML
	    private TableColumn<Compte, Integer> compte_placement;

	    @FXML
	    private TableColumn<Compte, String> compte_type;

	    @FXML
	    private TableColumn<Compte, Integer> compte_valeur;
	    
	    @FXML
	    private Button statistiquebtn;

	    @FXML
	    private GridPane statistiquepane;
	    
	    @FXML
	    private GridPane comptepane;

	    @FXML
	    private RadioButton r_btn_c;

	    @FXML
	    private RadioButton r_btn_e;

	    @FXML
	    private RadioButton r_btn_j;
	    
	    @FXML
	    private Button credit_btn_l;

	    @FXML
	    private DatePicker date_l_c;

	    @FXML
	    private DatePicker date_l_d;

	    @FXML
	    private Button debit_btn_l;

	    @FXML
	    private TextField montant_l_c;

	    @FXML
	    private TextField montant_l_d;

	    @FXML
	    private ComboBox <String> theme_l_c;

	    @FXML
	    private ComboBox <String>theme_l_d;
	    @FXML
	    private TextField compte_l_c;

	    @FXML
	    private TextField compte_l_d;

	
	   @FXML
	    private ComboBox <String> payement_l_c;

	    @FXML
	    private ComboBox <String> payement_l_d;





	    public ObservableList<Compte> donnee=FXCollections.observableArrayList();
@FXML
private void  onclick(ActionEvent evenement) {
	
	if(evenement.getSource()==listeComptebtn) {
		titre.setText("Liste /Compte");
		listepane.toFront();
		
	}
	
	
	if(evenement.getSource()==ligneComptabebtn) {
		titre.setText("Ligne /Comptable");
		lignepane.toFront();
	}
	
	
	
	
	if(evenement.getSource()==helpbtn) {
		titre.setText("Liste /Help");
		helppane.toFront();
		
	}


	if(evenement.getSource()==comptebtn) {
		titre.setText("Créer /Compte");
		comptepane.toFront();
	}
	
	if(evenement.getSource()==statistiquebtn) {
		titre.setText("Liste /Statistique");
		statistiquepane.toFront();
	}
	


	
}

@FXML
private void  sortir(javafx.scene.input.MouseEvent evenement) {
	if(evenement.getSource()==exitbtn) {
		System.exit(0);
			
		}
	}


@FXML
private void  ajouterCompte(ActionEvent evenement) {
	
	if(evenement.getSource()==btn_compte_c) {
		
		String numero =txt_c_num.getText();
		String valeur=txt_c_val.getText();
		String type="courant";
		
		
		String sql="insert into compte ( numero,valeur,type) values(?,?,?)";

		if(!numero.equals("")&&!valeur.equals("")) {

			try {

				st =cnx.prepareStatement(sql);
				st.setString(1, numero);
				st.setString(2, valeur);
				st.setString(3, type);
				st.execute();
				txt_c_num.setText("");
				txt_c_val.setText("");
				
				Alert alert =new Alert(AlertType.CONFIRMATION,"compte ajoutée avec succès",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else {
			Alert alert =new Alert(AlertType.WARNING,"remplisser tous les champs",javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
			
		}
		
		
		System.out.println("ok courant");
		
	}
	else if(evenement.getSource()==btn_compte_e) {
		
		String numero =txt_e_num.getText();
		String valeur=txt_e_val.getText();
		String taux_epargne=txt_e_taux.getText();
		String type="epargne";
		
		
		String sql="insert into compte ( numero,valeur,type,taux_epargne) values(?,?,?,?)";

		if(!numero.equals("")&&!valeur.equals("")&&!taux_epargne.equals("")) {

			try {

				st =cnx.prepareStatement(sql);
				st.setString(1, numero);
				st.setString(2, valeur);
				st.setString(3, type);
				st.setString(4, taux_epargne);
				st.executeUpdate();
				txt_e_num.setText("");
				txt_e_val.setText("");
				txt_e_taux.setText("");
				Alert alert =new Alert(AlertType.CONFIRMATION,"compte ajoutée avec succès",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else {
			Alert alert =new Alert(AlertType.WARNING,"remplisser tous les champs",javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
			
		}
		
		System.out.println("ok epargne");
		
	}
	
	else if(evenement.getSource()==btn_compte_j) {
		
		String numero =txt_j_num.getText();
		String valeur=txt_j_val.getText();
		String type="joint";
		
		
		String sql="insert into compte ( numero,valeur,type) values(?,?,?)";

		if(!numero.equals("")&&!valeur.equals("")) {

			try {

				st =cnx.prepareStatement(sql);
				st.setString(1, numero);
				st.setString(2, valeur);
				st.setString(3, type);
				st.execute();
				txt_j_num.setText("");
				txt_j_val.setText("");
				
				Alert alert =new Alert(AlertType.CONFIRMATION,"compte ajoutée avec succès",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		else {
			Alert alert =new Alert(AlertType.WARNING,"remplisser tous les champs",javafx.scene.control.ButtonType.OK);
			alert.showAndWait();
			
		}
		
		System.out.println("ok joint");
		
	}
	
	
	
	}

private void  listecompte() {

	String sql="select * from compte";
	
	try {
		st =cnx.prepareStatement(sql);
		resultat=st.executeQuery();
		while(resultat.next()) {
			
			donnee.add(new Compte(resultat.getInt("numero"),resultat.getString("type"),resultat.getInt("taux_epargne"),resultat.getInt("valeur")));
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	    compte_num.setCellValueFactory(new PropertyValueFactory<Compte, Integer>("numero") );
	    compte_type.setCellValueFactory(new PropertyValueFactory<Compte, String>("type"));
	    compte_valeur.setCellValueFactory(new PropertyValueFactory<Compte, Integer>("valeur"));
	    compte_placement.setCellValueFactory(new PropertyValueFactory<Compte, Integer>("taux_epargne"));

	   
	    tableau_compte.setItems(donnee);
	
}

@FXML
private void  ajouterligne(ActionEvent evenement) {
	
			
	if(evenement.getSource()==debit_btn_l) {

		
		String theme=theme_l_d.getValue();
		String mode_payement=payement_l_d.getValue();
		String montant=montant_l_d.getText();
		String type="debit";
		java.sql.Date date=java.sql.Date.valueOf(date_l_d.getValue());
		String compte=compte_l_d.getText();
		
				
		String sql="select valeur  from compte where numero='"+compte_l_d.getText()+"'";
		int nbr=0;
		System.out.println("ok debit");
		try {
			st =cnx.prepareStatement(sql);
			resultat=st.executeQuery();
			if(resultat.next()) {
			
			nbr=1;
			}
			else {
				Alert alert =new Alert(AlertType.WARNING,"Le numéro de ce compte n'existe pas",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		if(nbr==1) {
			String sql1="insert into ligne_comptable (datel,modepayement,theme,montant,type,compte) values(?,?,?,?,?,?)";
			
			if(!theme.equals("")&&!date.equals("")&&!montant.equals("")&&!compte.equals("")&&!mode_payement.equals("")) {
				
				try {
					 st =cnx.prepareStatement(sql1);
					 st.setDate(1,date);
					 st.setString(2,mode_payement);
					 st.setString(3,theme);
					 st.setString(4,montant);
					 st.setString(5,type);
					 st.setString(6,compte);
					 st.execute();
					
					 montant_l_d.setText("");
					 compte_l_d.setText("");
					
					 Alert alert =new Alert(AlertType.CONFIRMATION,"ligne ajoutée avec succès",javafx.scene.control.ButtonType.OK);
					 alert.showAndWait();
					
				} catch (Exception e) {
					Alert alert =new Alert(AlertType.WARNING,"Remplisser tous les champs",javafx.scene.control.ButtonType.OK);
					alert.showAndWait();
				}
				
			}
			
			

		
		}
		
		
		
	}
			  
	else if(evenement.getSource()==credit_btn_l) {
		
		
		

		String theme=theme_l_c.getValue();
		String mode_payement=payement_l_c.getValue();
		String montant=montant_l_c.getText();
		String type="crédit";
		java.sql.Date date=java.sql.Date.valueOf(date_l_c.getValue());
		String compte=compte_l_c.getText();
		
				
		String sql="select valeur from compte where numero='"+compte_l_c.getText()+"'";
		int nbr=0;
		
		try {
			st =cnx.prepareStatement(sql);
			resultat=st.executeQuery();
			if(resultat.next()) {
			
			nbr=1;
			}
			else {
				Alert alert =new Alert(AlertType.WARNING,"Le numéro de ce compte n'existe pas",javafx.scene.control.ButtonType.OK);
				alert.showAndWait();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		if(nbr==1) {
			String sql1="insert into ligne_comptable (datel,modepayement,theme,montant,type,compte) values(?,?,?,?,?,?)";
			
			if(!theme.equals("")&&!date.equals("")&&!montant.equals("")&&!compte.equals("")&&!mode_payement.equals("")) {
				
				try {
					 st =cnx.prepareStatement(sql1);
					 st.setDate(1,date);
					 st.setString(2,mode_payement);
					 st.setString(3,theme);
					 st.setString(4,montant);
					 st.setString(5,type);
					 st.setString(6,compte);
					 st.execute();
					
					 montant_l_d.setText("");
					 compte_l_d.setText("");
					
					 Alert alert =new Alert(AlertType.CONFIRMATION,"ligne ajoutée avec succès",javafx.scene.control.ButtonType.OK);
					 alert.showAndWait();
					
				} catch (Exception e) {
					Alert alert =new Alert(AlertType.WARNING,"Remplisser tous les champs",javafx.scene.control.ButtonType.OK);
					alert.showAndWait();
				}
				
			}}
		
	}
			  

			
			

}




@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	cnx= ConnexionSql.ConnexionDB();
	listecompte();

	try {
		
			
			   
			   
			
		 FilteredList<Compte> filtre_donne=new FilteredList<>(donnee,b->true);
		    text_recherche_compte.textProperty().addListener((observable,oldvalue,newvalue)->{
		    
		    	filtre_donne.setPredicate(Compte->{
		    		
		    		if (newvalue.isEmpty()||newvalue.isBlank()|| newvalue==null) {
		    			return true;
		    		}
		    		
		    		String mot_a_chercher= newvalue.toLowerCase();
		    		
		    		if(Compte.getNumero().toString().indexOf(mot_a_chercher)>-1) {
		    			return true;
		    		}
		    		
		    		else if(Compte.getType().toLowerCase().indexOf(mot_a_chercher)>-1) {
		    			return true;
		    		}
		    		
		    		else if(Compte.getTaux_epargne().toString().indexOf(mot_a_chercher)>-1) {
		    			return true;
		    		}
		    		
		    		else if(Compte.getValeur().toString().indexOf(mot_a_chercher)>-1) {
		    			return true;
		    		}
					return false;
		    	});
		    });
		    
		    SortedList<Compte> sortdonne= new SortedList<>(filtre_donne);
		    sortdonne.comparatorProperty().bind(tableau_compte.comparatorProperty());
		    tableau_compte.setItems(sortdonne);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	ObservableList<String> listComboTheleC =FXCollections.observableArrayList("salaire","loyer","alimentation","divers");
	ObservableList<String> listComboPayement =FXCollections.observableArrayList("CB","chèque","virement");

	theme_l_c.setItems(listComboTheleC);
	theme_l_d.setItems(listComboTheleC);
	payement_l_d.setItems(listComboPayement);
	payement_l_c.setItems(listComboPayement);
	
	
}



}
