package org.example.runforlife_app.Fondsenwerver;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.runforlife_app.util.Controller;
import org.example.runforlife_app.RunForLifeApplication;
import org.example.runforlife_app.util.Database;

public class FondsenChooseMenuController extends Controller {

    @FXML
    private Button SponsorenButton;
    @FXML
    private Button RennersButton;
    @FXML
    private Button FinancieelButton;
    @FXML
    private Button AanpassenButton;
    @FXML
    private Button VerwijderenButton;
    @FXML
    private Button ExporterenButton;
    @FXML
    private Label eventLabel;


    @FXML
    public void Back() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("FondsenwerverEvenementKiezer.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void gotoRunners() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("FondsenRunner.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void gotoSponsors() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("FondsenSponsor.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void gotoFinancieel() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("FondsenFinancieel.fxml"));
        changeScene(fxmlLoader, stage);
    }


    public void setRightName() {
        eventLabel.setText(Database.getCurrentEvent().getEventName());
    }

    @Override
    public void Initialize() {
        eventLabel.setText(Database.getCurrentEvent().getEventName());
    }
}
