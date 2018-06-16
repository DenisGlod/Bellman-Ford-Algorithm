package com.denisglod.bfa.util;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AlertBFA {

    public static void alertException(String title, String headerText, String contentText, Alert.AlertType exceptionType) {
        Alert alert = new Alert(exceptionType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/images/logo.png"));
        alert.getDialogPane().setPrefWidth(250);
        alert.show();
    }
}
