// java
package at.htl.gebrauchtwagenverwaltung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CarController {
    private Utility utility = new Utility();
    private Car carModel;
    private UserLogin userLoginModel;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    //Table
    @FXML
    private TableView tableView;

    @FXML
    private TableColumn brandTableColumn;

    @FXML
    private TableColumn modelTableColumn;

    @FXML
    private TableColumn priceTableColumn;

    @FXML
    private TableColumn rangeTableColumn;

    @FXML
    private TableColumn kilometerTableColumn;

    @FXML
    private TableColumn powerTableColumn;

    @FXML
    private TableColumn firstRegistrationTableColumn;

    @FXML
    private TableColumn priceChangeDateTableColumn;

    @FXML
    private TableColumn automaticTableColumn;


    @FXML
    private void initialize() {
        utility.createDatabase();
        utility.fillCarTable();
        utility.fillUserTable();
        userLoginModel = new UserLogin(); // <-- initialize here to avoid NPE
        fillTable();
    }

    @FXML
    protected void fillTable() {
        brandTableColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelTableColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        rangeTableColumn.setCellValueFactory(new PropertyValueFactory<>("range"));
        powerTableColumn.setCellValueFactory(new PropertyValueFactory<>("power"));
        firstRegistrationTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstRegistration"));
        automaticTableColumn.setCellValueFactory(new PropertyValueFactory<>("automatic"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        kilometerTableColumn.setCellValueFactory(new PropertyValueFactory<>("kilometer"));
        priceChangeDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("priceChangeDate"));
        tableView.getItems().addAll(utility.getCarTable());
    }

    protected void updateUserLoginView() {
        if (userLoginModel == null) {
            userLoginModel = new UserLogin();
        }
        String username = usernameTextField != null ? usernameTextField.getText() : "";
        String password = passwordTextField != null ? passwordTextField.getText() : "";
        userLoginModel.setUsername(username);
        userLoginModel.setPassword(String.valueOf(password.hashCode()));
    }

    @FXML
    protected void loginAction(ActionEvent event) {
        updateUserLoginView();
        if (utility.verifyLogin(userLoginModel)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}
