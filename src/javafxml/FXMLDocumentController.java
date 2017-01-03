/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml;

import com.jfoenix.controls.JFXDatePicker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 *
 * @author AUTO
 */
public class FXMLDocumentController implements Initializable {
    
    ObservableList<String> cities = FXCollections.observableArrayList("Климовичи", "Костюковичи", "Краснополье");
    
    @FXML
    private Label label;
    
    @FXML
    private JFXDatePicker datePicker;
    
    @FXML
    private JFXDatePicker beginTime;
    
    @FXML
    private JFXDatePicker finishTime;
    
    @FXML
    private ChoiceBox<String> cityChoise;
    
    @FXML
    private Button saveBtn;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //Substract begin time from finish time
        LocalTime begin = beginTime.getTime();
        LocalTime finish = finishTime.getTime();
        int beginSeconds = begin.toSecondOfDay();
        int finishSeconds = finish.toSecondOfDay();
        label.setText(Integer.toString((finishSeconds-beginSeconds)/60));
        //End
        
        
    }
    
    @FXML
    void handleSaveBtn(ActionEvent event) {
        
        
            //Collect data from app form
            String date = datePicker.getValue().toString();
            String beginString = String.valueOf(beginTime.getTime().toSecondOfDay());
            String finishString = String.valueOf(finishTime.getTime().toSecondOfDay());
            String city = cityChoise.getValue();
            String result = date + " " + beginTime.getTime().toString() + " " + finishTime.getTime().toString() + " " + city+ " " + String.valueOf((finishTime.getTime().toSecondOfDay())-(beginTime.getTime().toSecondOfDay())+ "\n");
            //End
            
            //Adding new line to existing text
            try {
            Files.write(Paths.get("work.txt"), result.getBytes(), StandardOpenOption.APPEND);
            //End
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cityChoise.setValue("Минск");
        cityChoise.setItems(cities);
    }    
    
}
