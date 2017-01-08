/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Desk1nd
 */
public class MarshallerManager {
    
    private JAXBContext context;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    
    public MarshallerManager() {
        try {
            this.context = JAXBContext.newInstance(WorkUnits.class);
            this.marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            this.unmarshaller = context.createUnmarshaller();
        } catch (JAXBException ex) {
            Logger.getLogger(MarshallerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }
    
    
}
