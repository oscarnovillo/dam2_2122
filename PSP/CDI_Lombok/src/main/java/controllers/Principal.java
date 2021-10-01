package controllers;

import config.ExampleSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import lombok.SneakyThrows;
import servicios.ServiciosTest;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Principal implements Initializable {


    List<String> pepes = List.of("kk","jj","pp","ll");

    @FXML
    private BorderPane root;
    @FXML
    private Button boton;

    private Alert alert;

    public Alert getAlert() {
        return alert;
    }

    private final ServiciosTest st;


    private final ExampleSingleton eps;


    private FXMLLoader fxmlloaderPantalla;
    private AnchorPane panePantalla;
    private Pantalla pantallaController;


    private FXMLLoader fxmlloaderPantalla2;
    private AnchorPane panePantalla2;
    private Pantalla2 pantalla2Controller;


    @Inject
    public Principal(ServiciosTest st, ExampleSingleton eps, FXMLLoader fxmlloaderPantalla, FXMLLoader fxmlloaderPantalla2) {

        this.st = st;
        this.eps = eps;
        this.fxmlloaderPantalla = fxmlloaderPantalla;
        this.fxmlloaderPantalla2 = fxmlloaderPantalla2;
    }




    public void cargarPantalla2() {
       // ServiciosTest sat = new ServiciosTest();
        if (panePantalla2 == null) {

            try {
                panePantalla2 = fxmlloaderPantalla2.load(getClass().getResourceAsStream("/fxml/pantalla2.fxml"));
                pantalla2Controller = fxmlloaderPantalla2.getController();
            } catch (IOException e) {

            }

        }
        pantalla2Controller.cargarPepes(pepes);


        pantalla2Controller.boton.setText("funciona "+eps.getNow());
        root.setCenter(panePantalla2);
    }


    private void cambiarDatos()
    {
        pantalla2Controller.cargarPepes(pepes);
        pantallaController.cargarPepes(pepes);
    }

    @SneakyThrows
    public void cargarPantalla1() {
        if (panePantalla == null) {
            panePantalla = fxmlloaderPantalla.load(getClass().getResourceAsStream("/fxml/pantalla.fxml"));
            pantallaController = fxmlloaderPantalla.getController();

            pantallaController.boton.setText("conseguido2");
            pantallaController.setP(this);
            pantallaController.cargarPepes(pepes);
        }
        root.setCenter(panePantalla);
    }

    @FXML
    private void click() {
        // ServiciosTest st = new ServiciosTest();
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
        alert.setContentText(eps.getNow()+"hola " + st.dameNombre(1) + " " + st.dameNumero());
        alert.showAndWait();
        cargarPantalla1();
    }

    public void clickMenuItem(ActionEvent actionEvent) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        cargarPantalla1();
//        cargarPantalla2();
//


    }

    public void ponerPantallaAdd(ActionEvent actionEvent) {

        cargarPantalla2();
        

    }
}
