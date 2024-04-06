package org.example.runforlife_app.Fondsenwerver;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.runforlife_app.util.Controller;
import org.example.runforlife_app.RunForLifeApplication;
import org.example.runforlife_app.util.Database;
import org.example.runforlife_app.util.Sponsor;

public class FondsenSponsorController extends Controller {
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
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("FondsenChooseMenu.fxml"));
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
