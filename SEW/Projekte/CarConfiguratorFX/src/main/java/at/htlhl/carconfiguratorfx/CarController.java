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

import java.io.File;
import java.io.IOException;

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

    public CarController() {

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

                throw new IOException("Test Fritz Error");
                // updateViewFromModel();
            } catch (IOException ioex) {
                System.err.println("Reading config file failed: " + ioex.getMessage());

                Window ownerWindow = ((Node) event.getTarget()).getScene().getWindow();

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(ownerWindow);
                alert.setTitle(App.APP_NAME);
                alert.setHeaderText("Load failed");
                alert.setContentText("During loading the configuration an error occurred: " + ioex.getMessage());
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
        } catch (IOException ex) {
            System.err.println("Writing config file failed: " + ex.getMessage());
        }

    }

    @FXML
    protected void tuneAction(ActionEvent event) {
        System.out.println("Tune clicked ... " + event.getSource());
    }
}
