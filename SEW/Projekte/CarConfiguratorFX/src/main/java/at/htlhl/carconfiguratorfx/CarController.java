package at.htlhl.carconfiguratorfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Window;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class CarController {

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button tuneButton;

    @FXML
    private TextField manufacturerTextField;

    @FXML
    private TextField typeTextField;

    @FXML
    private Slider powerSlider;

    @FXML
    private Slider rangeSlider;

    private Car model;

    private ResourceBundle resourceBundle;

    public CarController() {
        resourceBundle = ResourceBundle.getBundle("at.htlhl.carconfiguratorfx.misc");
    }

/*    public void init(Car model) {
        this.model = model;

        rangeSlider.setMax(Car.MAX_RANGE);
        powerSlider.setMax(Car.MAX_POWER);

        manufacturerTextField.setText(model.getManufacturer());
        typeTextField.setText(model.getType());
        powerSlider.setValue(model.getPower());
        rangeSlider.setValue(model.getRange());
    }

 */

    public void init() {
        model = new Car();

        rangeSlider.setMax(Car.MAX_RANGE);
        powerSlider.setMax(Car.MAX_POWER);

        initBinding();
        initValidation();
        assignModelDefaults();

        model.manufacturerProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                System.out.println("Source: " + observableValue + ", oldValue: '" + oldValue + "', newValue: '" + newValue + "'");
            }
        });
    }

    private void initBinding() {
        manufacturerTextField.textProperty().bindBidirectional(model.manufacturerProperty());
        typeTextField.textProperty().bindBidirectional(model.typeProperty());
        powerSlider.valueProperty().bindBidirectional(model.powerProperty());
        rangeSlider.valueProperty().bindBidirectional(model.rangeProperty());
    }

    private void initValidation() {
        ValidationSupport validationSupport = new ValidationSupport();
        validationSupport.registerValidator(manufacturerTextField,
                Validator.createEmptyValidator("Manufacturer is required"));
        saveButton.disabledProperty().and(validationSupport.invalidProperty());
    }

    private void assignModelDefaults() {
        model.setManufacturer("");
        model.setType("");
        model.setPower(0);
        model.setRange(100);
    }

    /*
    private void updateModelFromView() {
        model.setManufacturer(manufacturerTextField.getText());
        model.setType(typeTextField.getText());
        model.setPower((int) powerSlider.getValue());
        model.setRange((int) rangeSlider.getValue());
    }
     */


    /*
    private void updateViewFromModel() {
        manufacturerTextField.setText(model.getManufacturer());
        typeTextField.setText(model.getType());
        powerSlider.setValue(model.getPower());
        rangeSlider.setValue(model.getRange());
    }
     */

    private void updateModel(Car newModel) {
        model.setManufacturer(newModel.getManufacturer());
        model.setType(newModel.getType());
        model.setPower(newModel.getPower());
        model.setRange(newModel.getRange());
    }

    @FXML
    protected void loadAction(ActionEvent event) {
        System.out.println("Load clicked ... " + event.getSource());

        File configFile = new File(App.MODEL_FILE_PATH);
        if (configFile.exists()) {
            try {
                Car car = App.JSON_MAPPER.readValue(configFile, Car.class);
                updateModel(car);

                // throw new IOException("Test Fritz Error");
                // updateViewFromModel();
            } catch (IOException ioex) {
                System.err.println("Reading config file failed: " + ioex.getMessage());

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(findParentWindow(event));
                alert.setTitle(App.APP_NAME);
                alert.setHeaderText(resourceBundle.getString("loadErrorAlert.headerText"));
                alert.setContentText(resourceBundle.getString("loadErrorAlert.contentText") + ioex.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    protected void saveAction(ActionEvent event) {
        System.out.println("Save clicked ... " + event.getSource());

        // updateModelFromView();

        File configFile = new File(App.MODEL_FILE_PATH);

        try {
            App.JSON_MAPPER.writerWithDefaultPrettyPrinter().writeValue(configFile, model);

            // throw new IOException("Test save problem");
        } catch (IOException ioex) {
            System.err.println("Writing config file failed: " + ioex.getMessage());

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(findParentWindow(event));
            alert.setTitle(App.APP_NAME);
            alert.setHeaderText(resourceBundle.getString("saveErrorAlert.headerText"));
            alert.setContentText(resourceBundle.getString("saveErrorAlert.contentText") + ioex.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    protected void tuneAction(ActionEvent event) {
        System.out.println("Tune clicked ... " + event.getSource());
    }

    private Window findParentWindow(ActionEvent event) {
        return ((Node) event.getTarget()).getScene().getWindow();
    }
}
