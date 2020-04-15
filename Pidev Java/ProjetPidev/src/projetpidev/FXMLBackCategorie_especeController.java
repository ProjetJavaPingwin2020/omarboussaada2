/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

import Entity.Categorie_espece;
import Entity.Espece;
import Services.ServiceCategorie_espece;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.io.InputStream;
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
public class FXMLBackCategorie_especeController implements Initializable {

   
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button modify;
    @FXML
    private TableView<Categorie_espece> categorietable;
    @FXML
    private TextField id;
    @FXML
    private TextField nom;
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
       categorietable.getColumns().addAll(id);
       TableColumn nom = new TableColumn("Nom");
       categorietable.getColumns().addAll(nom);
        ServiceCategorie_espece sce = new ServiceCategorie_espece();
        nom.setCellValueFactory(new PropertyValueFactory<Categorie_espece, String>("nom"));
        id.setCellValueFactory(new PropertyValueFactory<Categorie_espece, Integer>("id"));
       
       
     
     
        try {
         categorietable.setItems(sce.getAllCategorie_especes());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLBackCategorie_especeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO
    }

    @FXML
    private void display(MouseEvent event) {
          Categorie_espece f = categorietable.getSelectionModel().getSelectedItem();
        
        id.setText( String.valueOf(f.getId()));
        nom.setText(f.getNom());
    }

    @FXML
    private void add(ActionEvent event) throws SQLException {
         String Nom = nom.getText();
         Categorie_espece ce = new Categorie_espece(Nom);
          int status = ServiceCategorie_espece.ajouter(ce);
          System.out.println(status);
        if (status == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ajouter categorie espece");
            alert.setHeaderText("Dialogue information");
            alert.setContentText("ajouter avec succés");

            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ajouter categorie espece");
            alert.setHeaderText("Dialogue ERREUR");
            alert.setContentText("Un probléme est survenu");

            alert.showAndWait();
        }
        ServiceCategorie_espece sce = new ServiceCategorie_espece();
        categorietable.setItems(sce.getAllCategorie_especes());
        
    }

    @FXML
    private void delete(ActionEvent event) throws IOException, SQLException {
       
     int Id = Integer.valueOf(id.getText()); //yekhou nom eli aatithoulou besh yfasakh bih

        int status = ServiceCategorie_espece.delete(Id);
        if (status != 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Supprimer categorie espece");
             alert.setHeaderText("Dialogue information");
            alert.setContentText("supprimer avec succés");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Supprimer categorie categorie");
            alert.setHeaderText("Dialogue ERREUR");
            alert.setContentText("Un probléme est survenu");

            alert.showAndWait();

        }
        nom.clear(); 
        id.clear();
        ServiceCategorie_espece sce = new ServiceCategorie_espece();
        categorietable.setItems(sce.getAllCategorie_especes());
             
    }

    @FXML
    
    private void modifer(ActionEvent event) throws SQLException {
         String Nom = nom.getText();
         int Id =Integer.valueOf(id.getText());
           //  String Img = img.getText();
       // String NomImage = lien;

         Categorie_espece f = new Categorie_espece(Nom);

        int status = ServiceCategorie_espece.update(f, Id );
        System.out.println(status);
        if (status == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modifier categorie espece ");
            alert.setHeaderText("Dialogue information");
            alert.setContentText("Modification avec succés");

            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modifier categorie espece");
            alert.setHeaderText("Dialogue ERREUR");
            alert.setContentText("Un probléme est survenu");

            alert.showAndWait();
        }
        ServiceCategorie_espece sce = new ServiceCategorie_espece();
        categorietable.setItems(sce.getAllCategorie_especes());
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
    