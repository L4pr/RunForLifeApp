package org.example.runforlife_app.Administratie;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.example.runforlife_app.util.Runner;
import org.example.runforlife_app.util.CSVReader;
import org.example.runforlife_app.util.Database;
import org.example.runforlife_app.RunForLifeApplication;

import java.io.File;
import java.util.ArrayList;

public class AdministratieRunnerController extends Controller {
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
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieChooseMenu.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void editData() {
        Runner runner = runnerTableView.getSelectionModel().getSelectedItem();
        if (runner != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("ToevoegenEnBewerkenRunner.fxml"));
            ToevoegenEnBewerkenRunnerController runnerController = (ToevoegenEnBewerkenRunnerController) changeScene(fxmlLoader, stage);
            runnerController.setRunner(runner);
        } else {
            System.out.println("No selection made.");
        }
    }

    @FXML
    public void addData() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("ToevoegenEnBewerkenRunner.fxml"));
        ToevoegenEnBewerkenRunnerController runnerController = (ToevoegenEnBewerkenRunnerController) changeScene(fxmlLoader, stage);
        Runner newRunner = new Runner();
        runnerController.setRunner(newRunner);
        Database.getCurrentEvent().getRunnerData().add(newRunner);
    }

    @FXML
    public void deleteData() {
        Runner runner = runnerTableView.getSelectionModel().getSelectedItem();
        if (runner != null) {
            getDataTable(Database.currentEvent).remove(runner);
        } else {
            System.out.println("No selection made.");
        }
    }

    @FXML
    public void loadData() {
        Runner runner1 = new Runner("John Doe", "testStreet 36", "7556 CM", "Enschede", "Nederland", "test.testtest@gmail.com", "31652743929", 10.00);
        getDataTable(Database.currentEvent).add(runner1);
        getDataTable(Database.currentEvent).add(new Runner("Pieter Dow", "testStreet 25", "7756 CM", "Almelo", "Nederland", "test.testtest@gmail.com", "31656853929", 15.00));
    }

    @FXML
    public void Import() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV Files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);


        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            ArrayList<String[]> csvFile = CSVReader.readCSVFile(file);
            for (int i = 1; i < csvFile.size(); i++) {
                getDataTable(Database.currentEvent).add(new Runner(csvFile.get(i)[0], csvFile.get(i)[1], csvFile.get(i)[2], csvFile.get(i)[3], csvFile.get(i)[4], csvFile.get(i)[5], csvFile.get(i)[6], Double.parseDouble(csvFile.get(i)[7])));
            }
        } else {
            System.out.println("File Not Found Somehow even though you selected it.....");
        }

    }

}
