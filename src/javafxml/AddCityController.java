/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author AUTO
 */
public class AddCityController implements Initializable {
    
    
    @FXML
    private JFXTextField newCityNameTextField;

    @FXML
    private JFXButton addNewCityButton;
    
    @FXML
    void handleAddNewCityButton(ActionEvent event) {
        String cityName = newCityNameTextField.getText();
        String cityNameForWriting = cityName + "\n";
        if(cityName!=null){
            FXMLDocumentController.cities.add(cityName);
        }
        try {
            Files.write(Paths.get("cities.txt"), cityNameForWriting.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(AddCityController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
