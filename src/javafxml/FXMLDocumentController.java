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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private Button newEntryBtn;
    
    @FXML
    private Button ViewAllEntries;
    
    
    
    //Process CLICK ME button action
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
    
    //Process SAVE button
    @FXML
    void handleSaveBtn(ActionEvent event) {
        
        
            //Collect data from app form
            String date = datePicker.getValue().toString();
            String city = cityChoise.getValue();
                //Calculate time
                double beginDouble = (double)beginTime.getTime().toSecondOfDay();
                double finishDouble = (double)finishTime.getTime().toSecondOfDay();
                double resultDouble = (finishDouble-beginDouble)/60/60;
                String resultString = String.valueOf(resultDouble);
                //End
            //End
            
            //Make result string
            String result = date + " " + beginTime.getTime().toString() + " " + finishTime.getTime().toString() + " " + city + " " + resultString + "\n";

            //
            
            //Adding new line to existing text
            try {
            Files.write(Paths.get("work.txt"), result.getBytes(), StandardOpenOption.APPEND);
            //End
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            saveBtn.setDisable(true);
    }
    
    //Process new entry btn
    @FXML
    void handleNewEntryBtn(ActionEvent event) {
        saveBtn.setDisable(false);
    }
    
    //Process view all entries button action
    @FXML
    void handleViewAllEntriesBtn(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AllEntries.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("All entries");
            stage.setScene(new Scene(root1));
            stage.show();
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
