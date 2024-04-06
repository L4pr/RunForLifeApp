package org.example.runforlife_app.Administratie;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import org.example.runforlife_app.util.Controller;
import org.example.runforlife_app.util.Sponsor;
import org.example.runforlife_app.util.CSVReader;
import org.example.runforlife_app.util.Database;
import org.example.runforlife_app.RunForLifeApplication;

import java.io.File;
import java.util.ArrayList;

public class AdministratieSponsorController extends Controller {
    @FXML
    private TableView<Sponsor> sponsorTableView;
    @FXML
    private TableColumn<Sponsor, String> companyColumn;
    @FXML
    private TableColumn<Sponsor, String> nameColumn;
    @FXML
    private TableColumn<Sponsor, Double> donatedColumn;
    @FXML
    private TableColumn<Sponsor, String> phoneNumberColumn;
    @FXML
    private TableColumn<Sponsor, String> emailColumn;
    @FXML
    private TableColumn<Sponsor, String> remarksColumn;
    @FXML
    private TableColumn<Sponsor, Boolean> payedColumn;

    private ObservableList<Sponsor> getDataTable(int i) {
        return Database.getEvent(i).getSponsorData();
    }


    public void Initialize() {
        companyColumn.setCellValueFactory(new PropertyValueFactory<>("company"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        donatedColumn.setCellValueFactory(new PropertyValueFactory<>("donated"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        remarksColumn.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        payedColumn.setCellValueFactory(new PropertyValueFactory<>("payed"));
        sponsorTableView.setItems(getDataTable(Database.currentEvent));
        double size = stage.getWidth() / 7;
        for (int i = 0; i < 7; i++) {
            sponsorTableView.getColumns().get(i).setPrefWidth(size);
        }
        sponsorTableView.setPrefHeight(stage.getHeight() - 270);
    }

    @FXML
    public void Back() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieChooseMenu.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void editData() {
        Sponsor sponsor = sponsorTableView.getSelectionModel().getSelectedItem();
        if (sponsor != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("ToevoegenEnBewerkenSponsor.fxml"));
            ToevoegenEnBewerkenSponsorController sponsorController = (ToevoegenEnBewerkenSponsorController) changeScene(fxmlLoader, stage);
            sponsorController.setSponsor(sponsor);
        } else {
            System.out.println("No selection made.");
        }
    }

    @FXML
    public void addData() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("ToevoegenEnBewerkenSponsor.fxml"));
        ToevoegenEnBewerkenSponsorController sponsorController = (ToevoegenEnBewerkenSponsorController) changeScene(fxmlLoader, stage);
        Sponsor newSponsor = new Sponsor();
        sponsorController.setSponsor(newSponsor);
        Database.getCurrentEvent().getSponsorData().add(newSponsor);
    }

    @FXML
    public void deleteData() {
        Sponsor sponsor = sponsorTableView.getSelectionModel().getSelectedItem();
        if (sponsor != null) {
            getDataTable(Database.currentEvent).remove(sponsor);
        } else {
            System.out.println("No selection made.");
        }
    }

    @FXML
    public void loadData() {

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
                getDataTable(Database.currentEvent).add(new Sponsor(csvFile.get(i)[0], csvFile.get(i)[1], Double.parseDouble(csvFile.get(i)[2]), csvFile.get(i)[3], csvFile.get(i)[4], csvFile.get(i)[5]));
            }
        } else {
            System.out.println("File Not Found Somehow even though you selected it.....");
        }

    }

}
