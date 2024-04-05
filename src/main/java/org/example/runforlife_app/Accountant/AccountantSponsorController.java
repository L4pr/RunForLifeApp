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

public class AccountantSponsorController extends Controller {
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
    @FXML
    private VBox vBox;


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
        double size = stage.getWidth() / 9;
        for (int i = 0; i < 7; i++) {
            sponsorTableView.getColumns().get(i).setPrefWidth(size);
        }
        sponsorTableView.getColumns().get(6).setPrefWidth(size * 2);
        vBox.setPrefWidth(size);
    }

    @FXML
    public void Back() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AccountantChooseMenu.fxml"));
        changeScene(fxmlLoader, stage);
    }

    @FXML
    public void togglePayed() {
        Sponsor sponsor = sponsorTableView.getSelectionModel().getSelectedItem();
        if (sponsor != null) {
            sponsor.setPayed(!sponsor.isPayed());
        } else {
            System.out.println("No selection made.");
        }
        sponsorTableView.refresh();
    }


}
