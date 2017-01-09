/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml;

import com.jfoenix.controls.JFXDatePicker;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.json.JSONArray;

public class FXMLDocumentController implements Initializable {
    
    public static ObservableList<String> cities = FXCollections.observableArrayList("Minsk");
    MarshallerManager marshallerManager = new MarshallerManager();
    WorkUnits workUnits = new WorkUnits();
    File file = new File("work.txt");
    
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

    //Process SAVE button
    @FXML
    void handleSaveBtn(ActionEvent event) {
        
        
            //Collect data from app form
            String date = datePicker.getValue().toString();
            String city = cityChoise.getValue();
//              Calculate tim e
                double beginDouble = (double)beginTime.getTime().toSecondOfDay();
                double finishDouble = (double)finishTime.getTime().toSecondOfDay();
                double totalTime = finishDouble - beginDouble;
                double resultDouble = (finishDouble-beginDouble)/60/60;
                String resultString = String.valueOf(resultDouble);
                //End
            //End
            
            //Prepare an object and add it to list
            WorkUnit workUnit = new WorkUnit(date, city, beginTime.getTime().toString(), finishTime.getTime().toString(), resultDouble);
            //End
            
            
            try {
                Unmarshaller unmarshaller = marshallerManager.getUnmarshaller();
                workUnits = (WorkUnits)unmarshaller.unmarshal(file);
                workUnits.getList().add(workUnit);
                System.out.println(workUnits.getList().size());
                
                System.out.println(workUnits.getList().size());
                Marshaller marshaller = marshallerManager.getMarshaller();
                marshaller.marshal(workUnits, file);
                marshaller.marshal(workUnits, System.out);
            } catch (JAXBException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            //Disable SAVE button
            saveBtn.setDisable(true);
            //End
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
    
    @FXML
    void handleAddCityButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCity.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Add City");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("cities.txt"));
            while(reader.readLine()!=null){
                FXMLDocumentController.cities.add(reader.readLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cityChoise.setValue("Минск");
        cityChoise.setItems(cities);
    } 
    
    
    
}
