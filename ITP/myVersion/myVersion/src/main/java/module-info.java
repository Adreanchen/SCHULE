module at.htl.gebrauchtwagenverwaltung {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires javafx.graphics;
    requires java.sql;
    requires com.fasterxml.jackson.databind;

    opens at.htl.gebrauchtwagenverwaltung to javafx.fxml;
    exports at.htl.gebrauchtwagenverwaltung;
}