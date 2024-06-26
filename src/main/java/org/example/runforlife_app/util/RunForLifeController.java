package org.example.runforlife_app.util;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import org.example.runforlife_app.RunForLifeApplication;

import java.util.HashMap;

public class RunForLifeController extends Controller {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongPassword;
    private boolean buttonPressed;

    private HashMap<String, String> accounts = new HashMap<>() {{
        put("Administratie", "password");
        put("Accountant", "password");
        put("Fondsenwerver", "password");
    }};




    @FXML
    public void Login() {
        String usernameString = username.getText();
        String passwordString = password.getText();
        if (accounts.containsKey(usernameString)) {
            if (accounts.get(usernameString).equals(passwordString)) {
                try {
                    switch (usernameString) {
                        case "Administratie":
                            FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieEvenementKiezer.fxml"));
                            changeScene(fxmlLoader, stage);
                            break;
                        case "Accountant":
                            FXMLLoader fxmlLoader2 = new FXMLLoader(RunForLifeApplication.class.getResource("AccountantEvenementKiezer.fxml"));
                            changeScene(fxmlLoader2, stage);
                            break;
                        case "Fondsenwerver":
                            FXMLLoader fxmlLoader3 = new FXMLLoader(RunForLifeApplication.class.getResource("FondsenwerverEvenementKiezer.fxml"));
                            changeScene(fxmlLoader3, stage);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        wrongPassword.setText("The username and/or password are wrong");
    }


    @Override
    public void Initialize() {

    }
}