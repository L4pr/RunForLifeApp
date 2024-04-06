package org.example.runforlife_app.Administratie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.runforlife_app.RunForLifeApplication;
import org.example.runforlife_app.util.Controller;
import org.example.runforlife_app.util.Database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AdministratieChooseMenuController extends Controller {

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
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieEvenementKiezer.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void gotoRunners() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieRunner.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void gotoSponsors() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieSponsor.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void gotoAanpassen() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieEvenementAanpassen.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void gotoFinancieel() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieFinancieel.fxml"));
        changeScene(fxmlLoader, stage);
    }


    @FXML
    public void exporteren() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Public\\Downloads\\export.csv"))) {
            bw.write("Name, Address, Postal Code, City, Country, Rugnummer");
            bw.newLine();
            int index = 1;
            for (int i = 0; i < Database.getCurrentEvent().getRunnerData().size(); i++) {
                if (Database.getCurrentEvent().getRunnerData().get(i).isPayed()) {
                    bw.write(Database.getCurrentEvent().getRunnerData().get(i).getName() + ", ");
                    bw.write(Database.getCurrentEvent().getRunnerData().get(i).getAddress() + ", ");
                    bw.write(Database.getCurrentEvent().getRunnerData().get(i).getPostalCode() + ", ");
                    bw.write(Database.getCurrentEvent().getRunnerData().get(i).getCity() + ", ");
                    bw.write(Database.getCurrentEvent().getRunnerData().get(i).getCountry() + ", ");
                    bw.write(index + ", ");
                    bw.newLine();
                    index++;
                }
            }
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while creating the CSV file.");
        }
        ExporterenButton.setText("File exported to Public Downloads");
        ExporterenButton.setOnAction(actionEvent -> Nothing());
    }

    private void Nothing() {

    }

    @FXML
    public void delete() {
        Database.deleteEvent(Database.currentEvent);
        Back();
    }

    public void setRightName() {
        eventLabel.setText(Database.getCurrentEvent().getEventName());
    }

    @Override
    public void Initialize() {
        eventLabel.setText(Database.getCurrentEvent().getEventName());
    }
}
