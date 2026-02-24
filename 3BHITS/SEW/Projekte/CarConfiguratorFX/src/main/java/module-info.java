module at.htlhl.carconfiguratorfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.fasterxml.jackson.databind;

    opens at.htlhl.carconfiguratorfx to javafx.fxml;
    exports at.htlhl.carconfiguratorfx;
}