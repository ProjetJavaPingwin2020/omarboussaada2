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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author TH3OMAR
 */
public class FXMLBackEspeceController implements Initializable {

    @FXML
    private TableView<Espece> especetable;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button modify;
    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private TextField categorie;
    @FXML
    private TextField type;
    @FXML
    private Pane pane11;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
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
     
        
          
       TableColumn nom = new TableColumn("Nom");
       especetable.getColumns().addAll(nom);
       TableColumn type = new TableColumn("Type");
       especetable.getColumns().addAll(type);
       TableColumn description = new TableColumn("Description");
       especetable.getColumns().addAll(description);
       TableColumn categorie = new TableColumn("categorie");
       especetable.getColumns().addAll(categorie);
        
        
        
        ServiceEspece se = new ServiceEspece();
        categorie.setCellValueFactory(new PropertyValueFactory<Espece, String>("categorie"));
        nom.setCellValueFactory(new PropertyValueFactory<Espece, String>("nom"));
        type.setCellValueFactory(new PropertyValueFactory<Espece, String>("type"));
        description.setCellValueFactory(new PropertyValueFactory<Espece, String>("description"));
     
     
        try {
         especetable.setItems(se.getAllEspeces());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAfficherEspeceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void display(MouseEvent event) {
         Espece f = especetable.getSelectionModel().getSelectedItem();
        
        
        nom.setText(f.getNom());
        type.setText(f.getType());
        description.setText(f.getDescription());
        categorie.setText(String.valueOf(f.getCategorie()));
    }

     @FXML
    private void add(ActionEvent event) throws SQLException {
         String Nom = nom.getText();
         String Type = type.getText();
         String Description = description.getText();
         int Categorie = Integer.valueOf(categorie.getText());
         Espece ce = new Espece(Nom,Type,Description,Categorie);
          int status = ServiceEspece.ajouter(ce);
          System.out.println(status);
        if (status == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ajouter un espece ");
            alert.setHeaderText("Dialogue information");
            alert.setContentText("ajouter avec succés");

            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ajouter un espece");
            alert.setHeaderText("Dialogue ERREUR");
            alert.setContentText("Un probléme est survenu");

            alert.showAndWait();
        }
        ServiceEspece sce = new ServiceEspece();
        especetable.setItems(sce.getAllEspeces());
        
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException {
         String Nom = nom.getText(); //yekhou nom eli aatithoulou besh yfasakh bih

        int status = ServiceEspece.delete(Nom);
        if (status > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Supprimer espece");
            alert.setHeaderText("Dialogue information");
            alert.setContentText("espece supprimer");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Supprimer espece");
            alert.setHeaderText("Dialogue ERREUR");
            alert.setContentText("Un probléme est survenu");

            alert.showAndWait();

        }
        nom.clear(); 
        type.clear();
        description.clear();
        categorie.clear();
        ServiceEspece sce = new ServiceEspece();
         especetable.setItems(sce.getAllEspeces());
    }

   @FXML
    
    private void modifer(ActionEvent event) throws SQLException {
         String Nom = nom.getText();
         String Type = type.getText();
         String Description = description.getText();
         int Categorie = Integer.valueOf(categorie.getText());
           //  String Img = img.getText();
       // String NomImage = lien;

         Espece E = new Espece(Nom,Type,Description,Categorie);

        int status = ServiceEspece.update(E, Nom );
        System.out.println(status);
        if (status == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modifier categorie");
            alert.setHeaderText("Dialogue information");
            alert.setContentText("Modification avec succés");

            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modifier categorie");
            alert.setHeaderText("Dialogue ERREUR");
            alert.setContentText("Un probléme est survenu");

            alert.showAndWait();
        }
        ServiceEspece sce = new ServiceEspece();
        especetable.setItems(sce.getAllEspeces());
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
    
}
