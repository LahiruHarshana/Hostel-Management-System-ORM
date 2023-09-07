package lk.ijse.gdse.orm.hibernate.controller.util;

import animatefx.animation.Shake;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
public class Validation {
    static Shake shake;
    public static boolean txtValidation(TextField txt) {
        if (txt.getText().matches("^$")) {
            txt.setStyle(
                    "-fx-border-color: red; " +
                            "-fx-border-width: 2px ;" +
                            "-fx-background-color: tranceparent ;" +
                            "-fx-text-fill : white;"
            );        } else {
            return true;
        }
        return false;
    }
    public static boolean pwValidation(PasswordField pwTxt) {
        if (pwTxt.getText().matches("^$")) {
            pwTxt.setStyle(
                    "-fx-border-color: red; " +
                            "-fx-border-width: 2px ;" +
                            "-fx-background-color: tranceparent ;" +
                            "-fx-text-fill : white;"
            );
        } else {
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
        date.setStyle(
                "-fx-border-color: red; " +
                        "-fx-border-width: 2px ;" +
                        "-fx-background-color: tranceparent ;" +
                        "-fx-text-fill : white;"
        );
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
}
