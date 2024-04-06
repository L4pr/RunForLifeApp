package org.example.runforlife_app.Accountant;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.example.runforlife_app.Administratie.Controller;
import org.example.runforlife_app.RunForLifeApplication;
import org.example.runforlife_app.util.CSVReader;
import org.example.runforlife_app.util.Database;
import org.example.runforlife_app.util.Runner;
import org.example.runforlife_app.util.Sponsor;

import java.io.File;
import java.util.ArrayList;

public class AccountantRunnerController extends Controller {
    @FXML
    private TableView<Runner> runnerTableView;
    @FXML
    private TableColumn<Runner, String> nameColumn;
    @FXML
    private TableColumn<Runner, String> addressColumn;
    @FXML
    private TableColumn<Runner, String> postalCodeColumn;
    @FXML
    private TableColumn<Runner, String> cityColumn;
    @FXML
    private TableColumn<Runner, String> countryColumn;
    @FXML
    private TableColumn<Runner, String> emailColumn;
    @FXML
    private TableColumn<Runner, String> phoneNumberColumn;
    @FXML
    private TableColumn<Runner, Double> registrationFeeColumn;
    @FXML
    private TableColumn<Runner, Boolean> payedColumn;



    private ObservableList<Runner> getDataTable(int i) {
        return Database.getEvent(i).getRunnerData();
    }


    public void Initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        registrationFeeColumn.setCellValueFactory(new PropertyValueFactory<>("registrationFee"));
        payedColumn.setCellValueFactory(new PropertyValueFactory<>("payed"));
        runnerTableView.setItems(getDataTable(Database.currentEvent));
        double size = stage.getWidth() / 9;
        for (int i = 0; i < 9; i++) {
            runnerTableView.getColumns().get(i).setPrefWidth(size);
        }
        runnerTableView.setPrefHeight(stage.getHeight() - 270);
    }

    @FXML
    public void Back() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AccountantChooseMenu.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void togglePayed() {
        Runner runner = runnerTableView.getSelectionModel().getSelectedItem();
        if (runner != null) {
            runner.setPayed(!runner.isPayed());
        } else {
            System.out.println("No selection made.");
        }
        runnerTableView.refresh();
    }

}
