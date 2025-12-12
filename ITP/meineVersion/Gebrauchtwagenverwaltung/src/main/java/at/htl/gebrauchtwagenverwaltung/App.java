package at.htl.gebrauchtwagenverwaltung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Gebrauchtwagenverwaltung.fxml"));
        Pane gebrauchtControllViewPane = fxmlLoader.load();
        stage.setScene(new Scene(gebrauchtControllViewPane, 640, 480));
        stage.setTitle("Gebrauchtwagenverwaltung");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
