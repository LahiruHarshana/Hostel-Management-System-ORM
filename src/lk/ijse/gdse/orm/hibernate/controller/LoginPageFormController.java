package lk.ijse.gdse.orm.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.orm.hibernate.controller.util.Navigation;
import lk.ijse.gdse.orm.hibernate.controller.util.Rout;

import java.io.IOException;

public class LoginPageFormController {
    @FXML
    private AnchorPane LoginPane;
    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPswd;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        try {
            Navigation.navigation(Rout.DASH_BOARD,root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

    }
}
