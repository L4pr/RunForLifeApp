package org.example.runforlife_app;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.runforlife_app.util.Controller;
import org.example.runforlife_app.util.Database;
import org.example.runforlife_app.util.Runner;
import org.example.runforlife_app.util.Sponsor;

import java.io.IOException;
import java.time.LocalDate;

public class RunForLifeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("LoginScreen.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(RunForLifeApplication.class.getResource("AdministratieRunner.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Controller controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setTitle("RunForLife");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        Database.addEvent(0);
        Database.getEvent(0).setEventName("Test Event");
        Database.getEvent(0).setGoedDoel("Test Doel");
        Database.getEvent(0).setDatumEvent(LocalDate.now());
        Database.getEvent(0).setDatumGegevensVerwijderen(LocalDate.now());
        ObservableList<Runner> runnerData = Database.getEvent(0).getRunnerData();

        runnerData.add(new Runner("John Doe", "appelstraat 36", "7448 CU", "Deventer", "Nederland", "John.Doe@gmail.com", "0612345678", 10.00));
        runnerData.add(new Runner("Jane Doe", "banaanstraat 36", "7448 CU", "Deventer", "Nederland", "Jane.Doe@gmail.com", "0612345678", 10.00));
        runnerData.add(new Runner("John Smith", "Appelweg 12", "1234 AB", "Utrecht", "Nederland", "john.smith@email.com", "0698765432", 15.00));
        runnerData.add(new Runner("Emily Johnson", "Peerstraat 45", "2345 CD", "Amsterdam", "Nederland", "emily.johnson@email.com", "0687654321", 12.50));
        runnerData.add(new Runner("Michael Brown", "Kersenlaan 78", "3456 EF", "Rotterdam", "Nederland", "michael.brown@email.com", "0676543210", 20.00));
        runnerData.add(new Runner("Olivia Davis", "Druivenhof 90", "4567 GH", "Groningen", "Nederland", "olivia.davis@email.com", "0665432109", 18.00));
        runnerData.add(new Runner("William Wilson", "Mangopad 123", "5678 IJ", "Eindhoven", "Nederland", "william.wilson@email.com", "0654321098", 22.00));
        runnerData.add(new Runner("Alice Martin", "Limoenlaan 2", "7689 KP", "Leeuwarden", "Nederland", "alice.martin@email.com", "0643210987", 14.50));
        runnerData.add(new Runner("Robert Lee", "Meloenstraat 4", "8789 LJ", "Maastricht", "Nederland", "robert.lee@email.com", "0632109876", 16.75));
        runnerData.add(new Runner("Charlotte Young", "Nectarineweg 6", "9890 MN", "Nijmegen", "Nederland", "charlotte.young@email.com", "0621098765", 19.00));
        runnerData.add(new Runner("Thomas Harris", "Olijfboomgaard 8", "1901 OP", "Haarlem", "Nederland", "thomas.harris@email.com", "0610987654", 11.25));
        runnerData.add(new Runner("Sophia Clark", "Papajapad 10", "2102 QR", "Zwolle", "Nederland", "sophia.clark@email.com", "0698765432", 13.00));
        runnerData.add(new Runner("George Rodriguez", "Quincestraat 12", "3223 ST", "Hilversum", "Nederland", "george.rodriguez@email.com", "0687654321", 20.50));
        runnerData.add(new Runner("Isabella Lewis", "Ramboetanruimte 14", "4344 UV", "Breda", "Nederland", "isabella.lewis@email.com", "0676543210", 18.75));
        runnerData.add(new Runner("Edward Walker", "Sinaasappelsingel 16", "5455 VW", "Almere", "Nederland", "edward.walker@email.com", "0665432109", 17.25));
        runnerData.add(new Runner("Mia Hall", "Tamarindetuin 18", "6566 XY", "Enschede", "Nederland", "mia.hall@email.com", "0654321098", 15.00));
        runnerData.add(new Runner("Daniel Allen", "Ugliboog 20", "7677 YZ", "Apeldoorn", "Nederland", "daniel.allen@email.com", "0643210987", 12.50));
        runnerData.add(new Runner("Grace Carter", "Vijgenvallei 22", "8788 ZA", "Dordrecht", "Nederland", "grace.carter@email.com", "0632109876", 21.00));
        runnerData.add(new Runner("Samuel Wright", "Watermeloenweg 24", "9899 AB", "Leiden", "Nederland", "samuel.wright@email.com", "0621098765", 22.25));
        runnerData.add(new Runner("Anna King", "Ximeniaboulevard 26", "1010 BC", "Amersfoort", "Nederland", "anna.king@email.com", "0610987654", 16.00));
        runnerData.add(new Runner("Joseph Scott", "Yuccastraat 28", "2121 CD", "Venlo", "Nederland", "joseph.scott@email.com", "0698765432", 19.50));
        runnerData.add(new Runner("Emily Green", "Zoeteaardappelzijde 30", "3232 DE", "Helmond", "Nederland", "emily.green@email.com", "0687654321", 18.00));
        runnerData.add(new Runner("James Adams", "Appelallee 32", "4343 EF", "Heerlen", "Nederland", "james.adams@email.com", "0676543210", 14.75));
        runnerData.add(new Runner("Victoria Moore", "Bananenboulevard 34", "5454 FG", "Doetinchem", "Nederland", "victoria.moore@email.com", "0665432109", 17.00));
        runnerData.add(new Runner("Andrew Jackson", "Clementinecrescent 36", "6565 GH", "Zaanstad", "Nederland", "andrew.jackson@email.com", "0654321098", 15.25));
        runnerData.add(new Runner("Olivia Brown", "Dadelhof 38", "7676 HI", "Haarlemmermeer", "Nederland", "olivia.brown@email.com", "0643210987", 13.50));
        runnerData.add(new Runner("Ethan Taylor", "Elderbesesplan 40", "8787 IJ", "Arnhem", "Nederland", "ethan.taylor@email.com", "0632109876", 20.75));
        for (int i = 0; i < 8; i++) {
            runnerData.get(i).setPayed(true);
        }

        ObservableList<Sponsor> sponsorData = Database.getEvent(0).getSponsorData();
        sponsorData.add(new Sponsor("Tech Innovations", "Alice Johnson", 500.00, "0612345670", "alice.johnson@techinnovations.com", "Interested in annual sponsorship"));
        sponsorData.add(new Sponsor("Green Solutions", "Bob Smith", 750.00, "0612345671", "bob.smith@greensolutions.com", "Prefers environmental initiatives"));
        sponsorData.add(new Sponsor("Health & Wellness Ltd.", "Cathy Williams", 250.00, "0612345672", "cathy.williams@wellnessltd.com", "In-kind sponsorship in health products"));
        sponsorData.add(new Sponsor("EduFuture", "David Brown", 1000.00, "0612345673", "david.brown@edufuture.com", "Sponsorship for educational programs"));
        sponsorData.add(new Sponsor("Global Tech", "Emma Davis", 1500.00, "0612345674", "emma.davis@globaltech.com", "Interested in tech innovation categories"));
        sponsorData.add(new Sponsor("NextGen Developers", "Frank Wilson", 2000.00, "0612345675", "frank.wilson@nextgendevelopers.com", "Focus on software development education"));
        sponsorData.add(new Sponsor("Creative Minds", "Grace Miller", 300.00, "0612345676", "grace.miller@creativeminds.com", "Supports creative arts programs"));
        sponsorData.add(new Sponsor("Sustainable Future", "Henry Moore", 850.00, "0612345677", "henry.moore@sustainablefuture.com", "Aims to support sustainability projects"));
        sponsorData.add(new Sponsor("Innovate Today", "Isabella Jackson", 1250.00, "0612345678", "isabella.jackson@innovatetoday.com", "Interested in short-term impactful projects"));
        sponsorData.add(new Sponsor("Bright Minds Academy", "Jack Taylor", 675.00, "0612345679", "jack.taylor@brightmindsacademy.com", "Education for underprivileged children"));
        sponsorData.add(new Sponsor("Healthy Eating Inc.", "Julia Scott", 430.00, "0612345680", "julia.scott@healthyeating.com", "Promoting healthy eating habits"));
        sponsorData.add(new Sponsor("Eco Warriors", "Kevin Thompson", 520.00, "0612345681", "kevin.thompson@ecowarriors.com", "Environmental conservation efforts"));
        sponsorData.add(new Sponsor("Code for All", "Laura Anderson", 780.00, "0612345682", "laura.anderson@codeforall.com", "Coding education sponsorships"));
        sponsorData.add(new Sponsor("Fitness First", "Michael Martinez", 890.00, "0612345683", "michael.martinez@fitnessfirst.com", "Sponsor for fitness events"));
        sponsorData.add(new Sponsor("Brighter Futures", "Nancy Clark", 600.00, "0612345684", "nancy.clark@brighterfutures.com", "Supporting youth education programs"));
        sponsorData.add(new Sponsor("Tech Pioneers", "Oliver King", 1300.00, "0612345685", "oliver.king@techpioneers.com", "Funding for tech startups"));
        sponsorData.add(new Sponsor("Green Tomorrow", "Patricia Lewis", 400.00, "0612345686", "patricia.lewis@greentomorrow.com", "Renewable energy projects"));
        sponsorData.add(new Sponsor("Mind and Body Wellness", "Robert Harris", 950.00, "0612345687", "robert.harris@mindbodywellness.com", "Mental and physical health programs"));
        sponsorData.add(new Sponsor("Future Leaders", "Sophia Martin", 1100.00, "0612345688", "sophia.martin@futureleaders.com", "Leadership development for teenagers"));
        sponsorData.add(new Sponsor("Eco Builders", "Tyler Evans", 500.00, "0612345689", "tyler.evans@ecobuilders.com", "Green building projects"));
        for (int i = 0; i < 10; i++) {
            sponsorData.get(i).setPayed(true);
        }

        launch();
    }
}