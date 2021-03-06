package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import servicios.ServiciosTest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private Button boton;

    private Alert alert;
    private FXMLLoader pantalla;
    private AnchorPane pantallaPane;

    private FXMLLoader pantallaNuevo;
    private AnchorPane pantallaPaneNuevo;

    public Alert getAlert() {
        return alert;
    }

    public void cargarPantallaNuevo() {
         pantallaNuevo = new FXMLLoader();
        try {
            if (pantallaNuevo==null)
                  pantallaPaneNuevo = pantalla.load(getClass()
                    .getResourceAsStream("/fxml/nuevo.fxml"));


        } catch (Exception e) {
            Logger.getLogger("LOG").log(Level.INFO, "ME NSAE", e);
        }

        root.setCenter(pantallaPaneNuevo);




    }



    private void cargarPantalla()  {
        pantalla = new FXMLLoader();
        try {
            if (pantallaPane == null) {
                pantallaPane = pantalla.load(getClass().getResourceAsStream("/fxml/pantalla.fxml"));
                Pantalla p = pantalla.getController();
                p.setPapa(this);
            }
        } catch (Exception e) {
          Logger.getLogger("LOG").log(Level.INFO,"ME NSAE",e);
        }
        root.setCenter(pantallaPane);
    }


    @FXML
    private void click() {
        ServiciosTest st = new ServiciosTest();
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
        alert.setContentText("hola " + st.dameNombre(1) + " " + st.dameNumero());
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarPantalla();

    }
}
