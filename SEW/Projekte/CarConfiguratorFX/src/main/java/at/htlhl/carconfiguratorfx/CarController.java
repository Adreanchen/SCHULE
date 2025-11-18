package at.htlhl.carconfiguratorfx;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class CarController {

    
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

}
