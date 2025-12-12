module gebrauchtwagenverwaltung.gebrauchtwagenverwaltung {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens at.htl.gebrauchtwagenverwaltung to javafx.fxml;
    exports at.htl.gebrauchtwagenverwaltung;
}