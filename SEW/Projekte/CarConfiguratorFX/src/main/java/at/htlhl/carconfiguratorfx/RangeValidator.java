package at.htlhl.carconfiguratorfx;

import javafx.scene.control.Control;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.Validator;

public class RangeValidator implements Validator<Double> {
    @Override
    public ValidationResult apply(Control control, Double value) {
        return ValidationResult.fromErrorIf(
                control,
                "Range must be between 400 and 1000 km",
                value < 400 || value > Car.MAX_RANGE
        );
    }
}
