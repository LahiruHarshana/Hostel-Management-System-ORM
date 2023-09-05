package lk.ijse.gdse.orm.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageFormController {
    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPswd;

    @FXML
    private JFXButton btnLogin;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

    }
}
