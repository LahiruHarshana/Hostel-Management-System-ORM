package lk.ijse.gdse.orm.hibernate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;

public class AppInitalizer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        SessionFactoryConfig.getInstance().getSession();

        Image image=new Image("/img/train.png");
        Parent parent =  FXMLLoader.load(getClass().getResource("/view/loginPage_form.fxml"));
        stage.getIcons().add(image);
        stage.setScene(new Scene(parent));
        stage.setTitle("Railway Station");
        stage.centerOnScreen();
        stage.setResizable(false);

        stage.show();
    }
}