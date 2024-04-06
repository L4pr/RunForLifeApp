package org.example.runforlife_app.Administratie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.example.runforlife_app.util.Controller;
import org.example.runforlife_app.util.Database;
import org.example.runforlife_app.RunForLifeApplication;

public class EvenementKiesController extends Controller {

    @FXML
    private Button event0;
    @FXML
    private Button event1;
    @FXML
    private Button event2;
    @FXML
    private Button addEventButton;
    @FXML
    private Label addEvent;


    @FXML
    public void Back() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("LoginScreen.fxml"));
        changeScene(fxmlLoader, stage);
    }


    @FXML
    public void goToEvent(int eventNum) {
        Database.currentEvent = eventNum;
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieChooseMenu.fxml"));
        changeScene(fxmlLoader, stage);
    }



    private void addFunctionsToExistingEvents() {
        if (Database.getEvent(0) != null) {
            event0.setOnAction(actionEvent -> goToEvent(0));
            event0.setText(Database.getEvent(0).getEventName());
        } else {
            event0.setOnAction(null);
            event0.setText("null");
        }
        if (Database.getEvent(1) != null) {
            event1.setOnAction(actionEvent -> goToEvent(1));
            event1.setText(Database.getEvent(1).getEventName());
        } else {
            event1.setOnAction(null);
            event1.setText("null");
        }
        if (Database.getEvent(2) != null) {
            event2.setOnAction(actionEvent -> goToEvent(2));
            event2.setText(Database.getEvent(2).getEventName());
        } else {
            event2.setOnAction(null);
            event2.setText("null");
        }
        addEventButton.setOnAction(actionEvent -> addEvent());
        addEventButton.setText("Toevoegen evenementen.");
        addEvent.setText("");
    }

    @FXML
    public void addEvent() {
        event0.setOnAction(actionEvent -> addSpecificEvent(0));
        event1.setOnAction(actionEvent -> addSpecificEvent(1));
        event2.setOnAction(actionEvent -> addSpecificEvent(2));
        addEventButton.setOnAction(actionEvent -> addFunctionsToExistingEvents());
        addEventButton.setText("Stop met toevoegen evenementen.");
    }

    @FXML
    public void addSpecificEvent(int i) {
        if (i == 0) {
            if (Database.getEvent(0) == null) {
                Database.addEvent(0);
                addEvent.setTextFill(Color.GREEN);
                addEvent.setText("Event 0 successfully added");
            } else {
                addEvent.setTextFill(Color.RED);
                addEvent.setText("Event already exists");
            }
        }
        if (i == 1) {
            if (Database.getEvent(1) == null) {
                Database.addEvent(1);
                addEvent.setTextFill(Color.GREEN);
                addEvent.setText("Event 1 successfully added");
            } else {
                addEvent.setTextFill(Color.RED);
                addEvent.setText("Event already exists");
            }
        }
        if (i == 2) {
            if (Database.getEvent(2) == null) {
                Database.addEvent(2);
                addEvent.setTextFill(Color.GREEN);
                addEvent.setText("Event 2 successfully added");
            } else {
                addEvent.setTextFill(Color.RED);
                addEvent.setText("Event already exists");
            }
        }
    }

    @Override
    public void Initialize() {
        addFunctionsToExistingEvents();
    }
}
