package org.example.runforlife_app.Accountant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.example.runforlife_app.Administratie.AdministratieChooseMenuController;
import org.example.runforlife_app.Administratie.Controller;
import org.example.runforlife_app.RunForLifeApplication;
import org.example.runforlife_app.util.Database;

public class AccountantEvenementKiesController extends Controller {

    @FXML
    private Button event0;
    @FXML
    private Button event1;
    @FXML
    private Button event2;



    @FXML
    public void Back() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("LoginScreen.fxml"));
        changeScene(fxmlLoader, stage);
    }


    @FXML
    public void goToEvent(int eventNum) {
        Database.currentEvent = eventNum;
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AccountantChooseMenu.fxml"));
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
    }

    @Override
    public void Initialize() {
        addFunctionsToExistingEvents();
    }
}
