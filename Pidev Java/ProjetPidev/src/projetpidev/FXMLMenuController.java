/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import projetpidev.FXMLLoginController;
import projetpidev.FXMLAfficherCategorie_especeController;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLMenuController implements Initializable {

    @FXML
    private Button boutiqueBtn;
    @FXML
    private Button especesBtn;
    @FXML
    private Button evenementsBtn;
    @FXML
    private Button formateurBtn;
    @FXML
    private Button formationsBtn;
    @FXML
    private Button informationsBtn;
    @FXML
    private ImageView logout;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane1.setStyle("-fx-background-image: url(\"/images/11.jpg\")");
        pane2.setStyle("-fx-background-image: url(\"/images/22.jpg\")");
        pane3.setStyle("-fx-background-image: url(\"/images/33.jpg\")");
        pane4.setStyle("-fx-background-image: url(\"/images/44.jpg\")");

        backgroundAnimation();
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
    private void boutique(ActionEvent event) {
    }

    @FXML
    private void especes(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAfficherCategorie_espece.fxml"));
        Parent root = loader.load();
        FXMLAfficherCategorie_especeController acc = loader.getController();
        acc = loader.getController();
        formateurBtn.getScene().setRoot(root);
    }

    @FXML
    private void evenements(ActionEvent event) {
    }

    @FXML
    private void formateur(ActionEvent event) throws IOException {
       
    }

    @FXML
    private void formations(ActionEvent event) throws IOException {
       
    }

    @FXML
    private void informations(ActionEvent event) {
    }

    @FXML
    private void Déconnexion(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
        Parent root = loader.load();
        FXMLLoginController acc = loader.getController();
        logout.getScene().setRoot(root);
    }

}
