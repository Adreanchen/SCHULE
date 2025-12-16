package at.htlhl.carconfiguratorfx;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class App extends Application {

    public static final String APP_NAME ="CarConfiguratorFX";
    public static final String CONFIG_DIR_PATH = System.getProperty("user.dir") + "/." + APP_NAME;
    public static final String MODEL_FILE_PATH = CONFIG_DIR_PATH + "/car.json";
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();


    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        initConfigDir();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("at.htlhl.carconfiguratorfx.car-view");

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("car-view.fxml"), resourceBundle);
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
        // Force a specific locale (e.g. ENGLISH, GERMAN, ...)
        Locale.setDefault(new Locale("de", "AT"));
        launch();
    }
}
