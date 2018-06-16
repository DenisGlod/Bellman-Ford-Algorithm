package com.denisglod.bfa.util;

import com.denisglod.bfa.bean.SaveContent;
import javafx.scene.control.Alert;

import java.io.*;

public class FileBFA {

    public static void saveFile(SaveContent content, File file) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(content);
        } catch (IOException ex) {
            AlertBFA.alertException(ParametersBFA.ERROR.getParamName(), "Ошибка соханения в файл!", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public static SaveContent openFile(File file) {
        SaveContent result = new SaveContent();
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))) {
            result = (SaveContent) stream.readObject();
        } catch (Exception ex) {
            AlertBFA.alertException(ParametersBFA.ERROR.getParamName(), "Ошибка открытия файла!", ex.getMessage(), Alert.AlertType.ERROR);
        }
        return result;
    }

}
