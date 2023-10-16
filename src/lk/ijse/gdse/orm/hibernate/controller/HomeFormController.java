package lk.ijse.gdse.orm.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeFormController {

    @FXML
    void setingBtn(ActionEvent event) throws IOException {

        Parent anchorPane =  FXMLLoader.load(getClass().getResource("/lk/ijse/gdse/orm/hibernate/view/settingsForm.fxml"));
        Scene scene = (new Scene(anchorPane));

        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);

        stage.show();

    }

}
