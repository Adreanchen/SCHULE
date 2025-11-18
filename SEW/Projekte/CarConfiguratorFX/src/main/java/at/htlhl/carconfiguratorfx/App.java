package at.htlhl.carconfiguratorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class App extends Application {

    public static final String APP_NAME ="CarConfiguratorFX";
    public static final String CONFIG_DIR_PATH = System.getProperty("user.dir") + "/." + APP_NAME;
    public static final String MODEL_FILE_PATH = CONFIG_DIR_PATH + "/car.json";

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        initConfigDir();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("car-view.fxml"));
        Pane carControllViewPane = fxmlLoader.load();
        CarController carController = fxmlLoader.getController();

/*        Car car = new Car();
        car.setManufacturer("");
        car.setType("");
        car.setPower(0);
        car.setRange(100);
 */

        carController.init();
        scene = new Scene(carControllViewPane, 640, 480);

        stage.setScene(scene);
        stage.setTitle("Car Configurator");
        stage.show();
    }

    private void initConfigDir() {
        File configDir = new File(CONFIG_DIR_PATH);
        if (!configDir.exists()) {
            configDir.mkdirs();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
