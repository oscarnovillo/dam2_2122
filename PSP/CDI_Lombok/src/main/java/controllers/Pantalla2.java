package controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Pantalla2 implements Initializable {
    public Button boton;


    public  ListView<String> lvPantalla2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void cargarPepes(List<String> pepes)
    {
        lvPantalla2.getItems().clear();
        lvPantalla2.getItems().addAll(pepes);

    }


}
