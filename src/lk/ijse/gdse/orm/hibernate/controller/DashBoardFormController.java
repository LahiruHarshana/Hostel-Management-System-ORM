package lk.ijse.gdse.orm.hibernate.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.orm.hibernate.controller.util.Navigation;
import lk.ijse.gdse.orm.hibernate.controller.util.Rout;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {
    @FXML
    private Button hmBtn;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane bodyPane;

    @FXML
    void homeBtnOnAction(ActionEvent event) {
        Thread thread = new Thread(() -> Platform.runLater(() -> {
            try {
                Navigation.navigation(Rout.HOME, bodyPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
        thread.start();
    }
    @FXML
    void reservationBtnOnAction(ActionEvent event) {
        try {
            Navigation.navigation(Rout.RESERVATION,bodyPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void roomsBtnOnAction(ActionEvent event) {
        try {
            Navigation.navigation(Rout.ROOMS, bodyPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void stdBtnOnAction(ActionEvent event) {
        try {
            Navigation.navigation(Rout.STUDENT,bodyPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void logOutBtnOnAction(ActionEvent event) {
        try {
            Navigation.navigation(Rout.LOGIN,root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void loadHome() {
        hmBtn.fire();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadHome();

    }
}
