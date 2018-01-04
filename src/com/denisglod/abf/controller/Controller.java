package com.denisglod.abf.controller;

import com.denisglod.abf.bean.Rib;
import com.denisglod.abf.bean.SaveContent;
import com.denisglod.abf.main.Main;
import com.denisglod.abf.util.AlertBFA;
import com.denisglod.abf.util.FileBFA;
import com.denisglod.abf.util.ParametersBFA;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    @FXML
    private TextField tfNumberOfVertices;
    @FXML
    private TextField tfVertexNames;
    @FXML
    private TextField tfWeightOfEdges;
    @FXML
    private TextArea taConsole;

    public void mClearAll() {
        taConsole.clear();
        tfNumberOfVertices.clear();
        tfVertexNames.clear();
        tfWeightOfEdges.clear();
    }

    public void mClearConsole() {
        taConsole.clear();
    }

    public void mClearTextFields() {
        tfNumberOfVertices.clear();
        tfVertexNames.clear();
        tfWeightOfEdges.clear();
    }

    public void mOpenAction() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Алгоритм Белмана-Форда (*.bfa)", "*.bfa");
        fileChooser.getExtensionFilters().add(filter);

        File file = fileChooser.showOpenDialog(Main.getPrimaryStage());
        if (file != null) {
            SaveContent saveContent = FileBFA.OpenFile(file);
            taConsole.setText(saveContent.getConsole());
            tfWeightOfEdges.setText(saveContent.getWeightOfEdges());
            tfVertexNames.setText(saveContent.getVertexNames());
            tfNumberOfVertices.setText(saveContent.getNumberOfVertices());
        }
    }

    public void mSaveAsAction() {
        SaveContent saveContent = new SaveContent();
        saveContent.setConsole(taConsole.getText());
        saveContent.setNumberOfVertices(tfNumberOfVertices.getText());
        saveContent.setVertexNames(tfVertexNames.getText());
        saveContent.setWeightOfEdges(tfWeightOfEdges.getText());

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Алгоритм Белмана-Форда (*.bfa)", "*.bfa");
        fileChooser.getExtensionFilters().add(filter);

        File file = fileChooser.showSaveDialog(Main.getPrimaryStage());
        if (file != null) {
            FileBFA.SaveFile(saveContent, file);
        }
    }


    public void mExitAction() {
        Platform.exit();
    }

    public void mAboutAction() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AboutUs.fxml"));
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/logo.png")));
            stage.setTitle(ParametersBFA.ABOUT.getParamName());
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            AlertBFA.alertException(ParametersBFA.ERROR.getParamName(), "Ошибка открытия формы!", ex.toString(), Alert.AlertType.ERROR);
        }
    }

    public void onActionCalculate() {
        if (tfNumberOfVertices.getText().isEmpty() ||
                tfVertexNames.getText().isEmpty() ||
                tfWeightOfEdges.getText().isEmpty()) {
            AlertBFA.alertException(ParametersBFA.WARNING.getParamName(), "Ошибка ввода данных!", "Некоторые поля пусты!\r\nПожалуйста заполните все поля.", Alert.AlertType.WARNING);
            return;
        }
        String[] vertexNames = tfVertexNames.getText().trim().split(ParametersBFA.SPACE.getParamName());

        String[] weightOfEdges = tfWeightOfEdges.getText().trim().split(ParametersBFA.SPACE.getParamName());

        List<Rib> weight = new ArrayList<>();
        if (Integer.parseInt(tfNumberOfVertices.getText()) != vertexNames.length) {
            AlertBFA.alertException(ParametersBFA.WARNING.getParamName(), "Ошибка ввода данных!", "Количество вершин не совпадает!", Alert.AlertType.WARNING);
            return;
        }

        for (String item : weightOfEdges) {
            String[] tempWeight = item.split(ParametersBFA.EQUALS.getParamName());
            String[] tempPointName = tempWeight[0].split(ParametersBFA.COMMA.getParamName());
            Rib rib = new Rib(tempPointName[0], tempPointName[1], Integer.parseInt(tempWeight[1]));
            weight.add(rib);
        }
        Map<String, Integer> stepByStepResult = new LinkedHashMap<>();
        for (String pointStart : vertexNames) {
            stepByStepResult.put(pointStart, Integer.MAX_VALUE);
        }
        stepByStepResult.replace(vertexNames[0], 0);

        int length = vertexNames.length - 1;
        while (length > 0) {
            taConsole.appendText("----- Итерация ");
            taConsole.appendText(String.valueOf(vertexNames.length - length));
            taConsole.appendText("-----\r\n");
            for (String pointStart : vertexNames) {
                weight.forEach(rib -> {
                    if (rib.getPointStart().equals(pointStart) && stepByStepResult.get(pointStart) != Integer.MAX_VALUE) {
                        int sumPointEnd = stepByStepResult.get(pointStart) + rib.getWeight();
                        if (stepByStepResult.get(rib.getPointEnd()) > sumPointEnd) {
                            stepByStepResult.replace(rib.getPointEnd(), sumPointEnd);
                        }
                    }
                });
            }
            taConsole.appendText(stepByStepResult.toString() + "\r\n");
            length--;
        }
        taConsole.appendText("**** Ответ: кратчайший путь до всех точек ****\r\n");
        taConsole.appendText(stepByStepResult.toString());
        taConsole.appendText("\r\n");
    }


}
