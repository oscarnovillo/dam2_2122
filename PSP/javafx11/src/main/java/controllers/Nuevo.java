package controllers;

import dao.DaoPersona;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.converter.IntegerStringConverter;
import modelo.Persona;
import servicios.persona.ServicioAddPersona;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Nuevo implements Initializable {

    public TextField txtEdad;
    public DatePicker registro;
    public ToggleGroup sexo;
    public RadioButton rbHombre;
    public RadioButton rbMujer;
    private final ServicioAddPersona add = new ServicioAddPersona();
    @FXML
    private TextField txtDel;
    @FXML
    private ComboBox<String> cbNombres;
    @FXML
    private ListView<Persona> lvNombres;
    @FXML
    private TextField txtNombre;
    @FXML
    private Button btAdd;

    private Alert alert;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        cbNombres.getItems().add("Hombre");
        cbNombres.getItems().add("Mujer");

        btAdd.setText("añadir");
//        txtEdad.textProperty().addListener((observable, oldValue, newValue) -> {
//            if (!newValue.matches("\\d*")) {
//                txtEdad.setText(newValue.replaceAll("[^\\d]", ""));
//            }
//        });


        UnaryOperator<TextFormatter.Change> numberValidationFormatter = change -> {
            if(change.getText().matches("-?\\d+")){
                return change; //if change is a number
            } else {
                change.setText(""); //else make no change
                change.setRange(    //don't remove any selected text either.
                        change.getRangeStart(),
                        change.getRangeStart()
                );
                return change;
            }
        };
        txtEdad.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(),0,numberValidationFormatter));
    }

    @FXML
    private void addNombre() {
        Persona p = new Persona();
        p.setNombre(txtNombre.getText());
        String edad = txtEdad.getText();
        try {

            p.setEdad(Integer.parseInt(txtEdad.getText()));
            p.setMujer(!((RadioButton) sexo.getSelectedToggle()).getText().equals("Hombre"));
            p.setMujer(rbMujer.isSelected());
            LocalDate fecha = registro.getValue();
            p.setRegistro(fecha);
            if (add.addPersona(p)) {
                alert.setContentText("PErsona añadida");
                lvNombres.getItems().add(p);
            } else {
                alert.setContentText("Persona NO");
            }
            alert.showAndWait();

        } catch (Exception e) {
            alert.setContentText("Edad no es numero");
            alert.showAndWait();
        } finally {

        }


    }

    @FXML
    private void delNombre(ActionEvent actionEvent) {
//        String nombre = lvNombres.getSelectionModel()
//                .getSelectedItem();

        String nombre = txtDel.getText();
        if (lvNombres.getItems().remove(nombre)) {
            alert.setContentText("nombre borrado");
        } else {
            alert.setContentText("nombre no borrado");
        }
        alert.showAndWait();

    }

    public void buscarPersona(ActionEvent actionEvent) {
        String hombre = cbNombres.getSelectionModel().getSelectedItem();

        List<Persona> personas = DaoPersona.personas;

        lvNombres.getItems().clear();
        lvNombres.getItems().addAll(personas.stream().filter(
                persona -> {
                    if (hombre.equals("Hombre"))
                        return !persona.isMujer();
                    else
                        return persona.isMujer();
                }

        ).collect(Collectors.toList()));

    }
}
