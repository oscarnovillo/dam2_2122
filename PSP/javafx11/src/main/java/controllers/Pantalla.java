package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pantalla implements Initializable {


    public Button lanzador;
    private Principal papa;

    public void setPapa(Principal papa) {
        this.papa = papa;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void irPantallaNuevo(ActionEvent actionEvent) {
        papa.cargarPantallaNuevo();



    }
}
