package at.htlhl.carconfiguratorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("car-view.fxml"));
        Pane carControllViewPane = fxmlLoader.load();
        CarController carController = fxmlLoader.getController();

        Car car = new Car();
        car.setManufacturer("");
        car.setType("");
        car.setPower(0);
        car.setRange(0);

        carController.init(car);
        scene = new Scene(carControllViewPane, 640, 480);

        stage.setScene(scene);
        stage.setTitle("Car Configurator");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
