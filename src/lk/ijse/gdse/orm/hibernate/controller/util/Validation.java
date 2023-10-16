package lk.ijse.gdse.orm.hibernate.controller.util;

import animatefx.animation.Shake;
import javafx.animation.TranslateTransition;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Validation {
    static Shake shake;
    public static boolean txtValidation(TextField txt) {
        if (txt.getText().matches("^$")) {
            txt.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), txt);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

        } else {
            return true;
        }
        return false;
    }
    public static boolean pwValidation(PasswordField pwTxt) {
        if (pwTxt.getText().matches("^$")) {
            pwTxt.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), pwTxt);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

        }else {
            return true;
        }
        return false;
    }
    public static void shakeLine(Line line){
        line.setStroke(Color.RED);
        shake=new Shake(line);
        shake.setOnFinished(actionEvent -> {
            defaultLine(line);
        });
        shake.play();
    }
    public static void defaultLine(Line line){
        line.setStroke(Color.BLACK);
    }

    public static boolean dateValidation(DatePicker date) {
        if (date.getValue()==null){
            shakeDate(date);
        }else {
            return true;
        }
        return false;
    }

    private static void shakeDate(DatePicker date) {
        date.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), date);
        translateTransition.setFromX(0);
        translateTransition.setToX(10);
        translateTransition.setCycleCount(10);
        translateTransition.setAutoReverse(true);
        shake=new Shake(date);
        shake.setOnFinished(actionEvent -> {
            defueltDate(date);
        });
        shake.play();
    }

    private static void defueltDate(DatePicker date) {
        date.setStyle(
                "-fx-background-color:tranceparent; " +
                        "-fx-text-fill: white"
        );
    }

    public static boolean comboValidation(ComboBox<String> idCmb) {
        if (idCmb.getValue() == null){
            shakeCmb(idCmb);
        }else {
            return true;
        }
        return false;
    }

    
    private static void shakeCmb(ComboBox<String> idCmb) {
        idCmb.setStyle(
                "-fx-border-color: red; " +
                        "-fx-border-width: 2px ;" +
                        "-fx-background-color: tranceparent ;"
        );
        shake=new Shake(idCmb);
        shake.setOnFinished(actionEvent -> {
            defueltDate(idCmb);
        });
        shake.play();
    }
    private static void defueltDate(ComboBox<String> idCmb) {
        idCmb.setStyle(
                "-fx-background-color:tranceparent; "+
                        "-fx-border-color: black; "+
                        "-fx-border-width: 2px ;"
        );
    }

    public static boolean cNumValidation(TextField txt) {
        if (txt.getText().matches("[0-9+]+")) {
            txt.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), txt);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);       } else {
            return true;
        }
        return false;
    }
}
