/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

import Entity.Categorie_espece;
import Entity.Espece;
import Services.ServiceCategorie_espece;
import Services.ServiceEspece;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import utils.sendSMS;

/**
 * FXML Controller class
 *
 * @author TH3OMAR
 */
public class FXMLAfficherCategorie_especeController implements Initializable {
public static int idcourent;
    @FXML
    private TableView<Categorie_espece> categorie_espece;
    
    public ObservableList<Categorie_espece> cls = FXCollections.observableArrayList();
     
    public static Categorie_espece ce;
    @FXML
    private ImageView logout;
    @FXML
    private ImageView panier;
    @FXML
    private Button EspecesBtn;
    @FXML
    private Button EvenementsBtn;
    @FXML
    private Button InformationsBtn;
    @FXML
    private Button BoutiqueBtn;
    @FXML
    private Button FormationsBtn;
    @FXML
    private Label Lhello;
    @FXML
    private Pane pane11;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane11.setStyle("-fx-background-image: url(\"/images/4444.jpg\")");
        pane2.setStyle("-fx-background-image: url(\"/images/2222.jpg\")");
        pane3.setStyle("-fx-background-image: url(\"/images/3333.jpg\")");
        pane4.setStyle("-fx-background-image: url(\"/images/4444.jpg\")");

        backgroundAnimation();
        
        TableColumn id = new TableColumn("id");
       categorie_espece.getColumns().addAll(id);
       TableColumn nom = new TableColumn("Nom");
       categorie_espece.getColumns().addAll(nom);
       
        
        
        
        ServiceCategorie_espece sce = new ServiceCategorie_espece();
        ServiceEspece cl = new ServiceEspece();
        nom.setCellValueFactory(new PropertyValueFactory<Categorie_espece, String>("nom"));
        id.setCellValueFactory(new PropertyValueFactory<Categorie_espece, String>("id"));
     
     
        try {
         categorie_espece.setItems(sce.getAllCategorie_especes());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAfficherCategorie_especeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
private void backgroundAnimation() {

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), pane4);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        fadeTransition.setOnFinished(event -> {

            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3), pane3);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), pane2);
                fadeTransition2.setFromValue(1);
                fadeTransition2.setToValue(0);
                fadeTransition2.play();

                fadeTransition2.setOnFinished(event2 -> {

                    FadeTransition fadeTransition0 = new FadeTransition(Duration.seconds(3), pane2);
                    fadeTransition0.setToValue(1);
                    fadeTransition0.setFromValue(0);
                    fadeTransition0.play();

                    fadeTransition0.setOnFinished(event3 -> {

                        FadeTransition fadeTransition11 = new FadeTransition(Duration.seconds(3), pane3);
                        fadeTransition11.setToValue(1);
                        fadeTransition11.setFromValue(0);
                        fadeTransition11.play();

                        fadeTransition11.setOnFinished(event4 -> {

                            FadeTransition fadeTransition22 = new FadeTransition(Duration.seconds(3), pane4);
                            fadeTransition22.setToValue(1);
                            fadeTransition22.setFromValue(0);
                            fadeTransition22.play();

                            fadeTransition22.setOnFinished(event5 -> {
                                backgroundAnimation();
                            });

                        });

                    });

                });
            });

        });

    }
    @FXML
    private void logout(MouseEvent event) {
    }

    @FXML
    private void redirectionFormation(ActionEvent event) {
    }

    @FXML
    private void afficher_espece(ActionEvent event) throws SQLException, IOException {
          
    
            Categorie_espece f = categorie_espece.getSelectionModel().getSelectedItem();
            idcourent = f.getId();
            sendSMS sms= new sendSMS();
          sms.sendSms("21698821576", "hello");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLafficherparC.fxml"));
        Parent root = loader.load();
        FXMLafficherparCController acc = loader.getController();
        FormationsBtn.getScene().setRoot(root);
            
            
            
        
    }
}

   
    

