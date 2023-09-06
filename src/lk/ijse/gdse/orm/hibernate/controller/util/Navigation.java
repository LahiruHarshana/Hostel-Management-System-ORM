package lk.ijse.gdse.orm.hibernate.controller.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Navigation {
    private static AnchorPane root;
    public static void navigation(Rout rout,AnchorPane root) throws IOException {
        Navigation.root = root;
        Navigation.root.getChildren().clear();
        Stage window = (Stage) Navigation.root.getScene().getWindow();
        switch (rout) {
            case LOGIN : initUi("loginPageForm.fxml");
            break;
            case SIGN_UP : initUi("signUpForm.fxml");
            break;
            case DASH_BOARD : initUi("dashBoardForm.fxml");
            break;
            case HOME : initUi("homeForm.fxml");
            break;
            case SETTINGS : initUi("settingsForm.fxml");
            break;
            case ROOMS : initUi("roomForm.fxml");
            break;
            case STUDENT : initUi("stdForm.fxml");
            break;
            case RESERVATION : initUi("reservationForm.fxml");
            break;
        }
    }
    private static void initUi(String location) throws IOException {
        Navigation.root.getChildren().add(FXMLLoader.load(Objects.requireNonNull(Navigation.class.getResource("/lk/ijse/gdse/orm/hibernate/view/" + location))));
    }
}
