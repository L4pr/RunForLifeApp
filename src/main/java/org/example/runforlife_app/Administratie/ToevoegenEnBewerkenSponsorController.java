package org.example.runforlife_app.Administratie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.example.runforlife_app.RunForLifeApplication;
import org.example.runforlife_app.util.Sponsor;


public class ToevoegenEnBewerkenSponsorController extends Controller {

    private Sponsor sponsor;

    @FXML
    private TextField company;
    @FXML
    private TextField name;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField email;
    @FXML
    private TextField donated;
    @FXML
    private TextField remark;
    @FXML
    private Label errorMessage;

    @Override
    public void Initialize() {

    }

    public void setSponsor(Sponsor sponsor) {
        if (sponsor == null) {
            this.sponsor = new Sponsor();
            return;
        }
        this.sponsor = sponsor;
        name.setText(sponsor.getName());
        company.setText(sponsor.getCompany());
        email.setText(sponsor.getEmail());
        donated.setText(String.valueOf(sponsor.getDonated()));
        phoneNumber.setText(sponsor.getPhoneNumber());
        remark.setText(sponsor.getRemarks());
    }

    @FXML
    public void Back() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieSponsor.fxml"));
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
        sponsor.setName(name.getText());
        sponsor.setEmail(email.getText());
        sponsor.setCompany(company.getText());
        sponsor.setPhoneNumber(phoneNumber.getText());
        sponsor.setDonated(Double.parseDouble(donated.getText()));
        sponsor.setRemarks(remark.getText());
    }

    private Boolean checkIfDataFine() {
        if (name.getText().equals("")) {
            return false;
        }
        if (email.getText().equals("")) {
            return false;
        }
        if (phoneNumber.getText().equals("")) {
            return false;
        }
        if (donated.getText().equals("")) {
            return false;
        }
        Double registrationFeeAmount;
        try {
            registrationFeeAmount = Double.parseDouble(donated.getText());
        } catch (Exception e) {
            return false;
        }
        if (registrationFeeAmount <= 0) {
            return false;
        }
        return true;
    }
}
