package org.example.runforlife_app.Administratie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.example.runforlife_app.RunForLifeApplication;
import org.example.runforlife_app.util.Controller;
import org.example.runforlife_app.util.Database;
import org.example.runforlife_app.util.Event;

public class AdministratieEvenementAanpassenController extends Controller {

    @FXML
    private TextField naamEvent;
    @FXML
    private TextField goedDoel;
    @FXML
    private DatePicker datumEvent;
    @FXML
    private DatePicker datumEventVerwijderen;
    @FXML
    private Button opslaan;
    @FXML
    private Button back;
    @FXML
    private Label errorMessage;

    private Event currentEvent = Database.getCurrentEvent();

    @FXML
    public void Back() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieChooseMenu.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void Save() {
        if (!checkIfDataFine()) {
            errorMessage.setText("Some data is empty or not correct");
            errorMessage.setTextFill(Color.RED);
            return;
        }
        errorMessage.setText("Saved");
        errorMessage.setTextFill(Color.GREEN);
        currentEvent.setEventName(naamEvent.getText());
        currentEvent.setGoedDoel(goedDoel.getText());
        currentEvent.setDatumEvent(datumEvent.getValue());
        currentEvent.setDatumGegevensVerwijderen(datumEventVerwijderen.getValue());
    }

    private Boolean checkIfDataFine() {
        if (goedDoel.getText().equals("")) {
            return false;
        }
        if (naamEvent.getText().equals("")) {
            return false;
        }
        if (datumEvent.getValue() == null) {
            return false;
        }
        if (datumEventVerwijderen.getValue() == null) {
            return false;
        }
        return true;
    }

    @Override
    public void Initialize() {
        naamEvent.setText(currentEvent.getEventName());
        goedDoel.setText(currentEvent.getGoedDoel());
        datumEvent.setValue(currentEvent.getDatumEvent());
        datumEventVerwijderen.setValue(currentEvent.getDatumGegevensVerwijderen());
    }
}
