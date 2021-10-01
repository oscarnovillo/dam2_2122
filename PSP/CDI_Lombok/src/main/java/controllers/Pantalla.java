package controllers;

import config.ExampleSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import servicios.ServiciosTest;

import javax.inject.Inject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Pantalla implements Initializable {

    @FXML
    public ListView<String> lvPantalla;



    public void setP(Principal p) {
        this.p = p;
    }

    private Principal p ;
    @Inject
    private ServiciosTest st;
    @Inject
    private ExampleSingleton eps;

    @FXML
    public Button boton;

    @FXML
    private void click(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().lookupButton(ButtonType.OK).setId("alertOK");
        alert.setContentText(eps.getNow()+"hola "+st.dameNombre(1)+" "+st.dameNumero());
        alert.showAndWait();
        p.cargarPantalla2();

    }

    public void cargarPepes(List<String> pepes)
    {
        lvPantalla.getItems().clear();
        lvPantalla.getItems().addAll(pepes);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cargarPepes(this.p.pepes);


    }
}
