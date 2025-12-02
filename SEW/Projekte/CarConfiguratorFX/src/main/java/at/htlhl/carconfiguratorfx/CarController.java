package at.htlhl.carconfiguratorfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

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

        assignModelDefaults();
    }

    private void assignModelDefaults() {
        model.setManufacturer("");
        model.setType("");
        model.setPower(0);
        model.setRange(100);
    }

    private void updateModelFromView() {
        model.setManufacturer(manufacturerTextField.getText());
        model.setType(typeTextField.getText());
        model.setPower((int) powerSlider.getValue());
        model.setRange((int) rangeSlider.getValue());
    }

    @FXML
    protected void loadAction(ActionEvent event) {
        System.out.println("Load clicked ... " + event.getSource());
    }

    @FXML
    protected void saveAction(ActionEvent event) {
        System.out.println("Save clicked ... " + event.getSource());

        updateModelFromView();

        File configFile = new File(App.MODEL_FILE_PATH);

        try {
            App.JSON_MAPPER.writer().writeValue(configFile, model);
        } catch (IOException ex) {
            System.err.println("Writing config file failed: " + ex.getMessage());
        }

    }

    @FXML
    protected void tuneAction(ActionEvent event) {
        System.out.println("Tune clicked ... " + event.getSource());
    }
}
