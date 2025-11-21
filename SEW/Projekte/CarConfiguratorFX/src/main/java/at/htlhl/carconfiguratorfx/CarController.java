package at.htlhl.carconfiguratorfx;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class CarController {

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

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
}
