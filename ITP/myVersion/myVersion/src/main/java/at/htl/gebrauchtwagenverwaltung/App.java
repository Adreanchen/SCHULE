package at.htl.gebrauchtwagenverwaltung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {



    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Gebrauchtwagenverwaltung.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Gebrauchtwagenverwaltung");
        stage.setScene(scene);
        stage.show();
//        Pane carControllViewPane = fxmlLoader.load();
//        CarController carController = fxmlLoader.getController();



    }
    //for testing purpose
    private void fillTables() {
        Utility utility = new Utility();
        utility.createDatabase();
        utility.fillCarTable();
        utility.fillUserTable();
    }
}
