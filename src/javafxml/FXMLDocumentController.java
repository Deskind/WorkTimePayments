/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml;

import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private void handleButtonAction(ActionEvent event) {
        //Substract begin time from finish time
        LocalTime begin = beginTime.getTime();
        LocalTime finish = finishTime.getTime();
        int beginSeconds = begin.toSecondOfDay();
        int finishSeconds = finish.toSecondOfDay();
        label.setText(Integer.toString((finishSeconds-beginSeconds)/60));
        //End
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cityChoise.setValue("Минск");
        cityChoise.setItems(cities);
    }    
    
}
