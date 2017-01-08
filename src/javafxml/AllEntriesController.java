/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml;

import com.jfoenix.controls.JFXTextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * FXML Controller class
 *
 * @author Desk1nd
 */
public class AllEntriesController implements Initializable {
    MarshallerManager marshallerManager = new MarshallerManager();
    WorkUnits workUnits;
    File file = new File("work.txt");
    
    {
        Unmarshaller unmarshaller = marshallerManager.getUnmarshaller();
        
        try {
            workUnits = (WorkUnits)unmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(AllEntriesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(workUnits.getList().size());
    }
    
    @FXML
    TableView<WorkUnit> tableWithWorkItems;
    @FXML
    TableColumn<WorkUnit, String> date;
    @FXML
    TableColumn<WorkUnit, String> beginTime;
    @FXML
    TableColumn<WorkUnit, String> finishTime;
    @FXML
    TableColumn<WorkUnit, String> city;
    @FXML
    TableColumn<WorkUnit, Double> workedTime;
    
    final ObservableList<WorkUnit> list = FXCollections.observableArrayList(workUnits.getList());
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        date.setCellValueFactory(new PropertyValueFactory<WorkUnit, String>("date"));
        beginTime.setCellValueFactory(new PropertyValueFactory<WorkUnit, String>("beginTime"));
        finishTime.setCellValueFactory(new PropertyValueFactory<WorkUnit, String>("finishTime"));
        city.setCellValueFactory(new PropertyValueFactory<WorkUnit, String>("city"));
        workedTime.setCellValueFactory(new PropertyValueFactory<WorkUnit, Double>("totalTime"));
        
        tableWithWorkItems.setItems(list);
    }
}
