package org.example.runforlife_app.Administratie;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.example.runforlife_app.util.Runner;
import org.example.runforlife_app.RunForLifeApplication;


public class ToevoegenEnBewerkenRunnerController extends Controller {

    private Runner runner;

    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField postalCode;
    @FXML
    private TextField city;
    @FXML
    private TextField country;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField registrationFee;
    @FXML
    private Label errorMessage;

    @Override
    public void Initialize() {

    }

    public void setRunner(Runner runner) {
        if (runner == null) {
            this.runner = new Runner();
            return;
        }
        this.runner = runner;
        name.setText(runner.getName());
        address.setText(runner.getAddress());
        postalCode.setText(runner.getPostalCode());
        city.setText(runner.getCity());
        country.setText(runner.getCountry());
        email.setText(runner.getEmail());
        registrationFee.setText(String.valueOf(runner.getRegistrationFee()));
        phoneNumber.setText(runner.getPhoneNumber());
    }

    @FXML
    public void Back() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieRunner.fxml"));
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
        runner.setName(name.getText());
        runner.setEmail(email.getText());
        runner.setAddress(address.getText());
        runner.setCity(city.getText());
        runner.setCountry(country.getText());
        runner.setPostalCode(postalCode.getText());
        runner.setPhoneNumber(phoneNumber.getText());
        runner.setRegistrationFee(Double.parseDouble(registrationFee.getText()));
    }

    private Boolean checkIfDataFine() {
        if (name.getText().equals("")) {
            return false;
        }
        if (email.getText().equals("")) {
            return false;
        }
        if (address.getText().equals("")) {
            return false;
        }
        if (city.getText().equals("")) {
            return false;
        }
        if (country.getText().equals("")) {
            return false;
        }
        if (postalCode.getText().equals("")) {
            return false;
        }
        if (phoneNumber.getText().equals("")) {
            return false;
        }
        if (registrationFee.getText().equals("")) {
            return false;
        }
        Double registrationFeeAmount;
        try {
            registrationFeeAmount = Double.parseDouble(registrationFee.getText());
        } catch (Exception e) {
            return false;
        }
        if (registrationFeeAmount <= 0) {
            return false;
        }
        return true;
    }
}
