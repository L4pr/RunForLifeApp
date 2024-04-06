package org.example.runforlife_app.Fondsenwerver;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import org.example.runforlife_app.util.Controller;
import org.example.runforlife_app.RunForLifeApplication;
import org.example.runforlife_app.util.Database;

public class FondsenFinancieelController extends Controller {

    @FXML
    private Label bedrag;




    @FXML
    public void Back() {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("FondsenChooseMenu.fxml"));
        changeScene(fxmlLoader, stage);
    }



    @Override
    public void Initialize() {
        Double total = (double) 0;
        for (int i = 0; i < Database.getCurrentEvent().getRunnerData().size(); i++) {
            if (Database.getCurrentEvent().getRunnerData().get(i).isPayed()) {
                total += Database.getCurrentEvent().getRunnerData().get(i).getRegistrationFee();
            }
        }
        for (int i = 0; i < Database.getCurrentEvent().getSponsorData().size(); i++) {
            if (Database.getCurrentEvent().getSponsorData().get(i).isPayed()) {
                total += Database.getCurrentEvent().getSponsorData().get(i).getDonated();
            }
        }
        bedrag.setText("€" + Double.toString(total));
    }
}
