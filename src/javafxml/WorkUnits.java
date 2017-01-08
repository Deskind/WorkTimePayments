/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkUnits")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkUnits {
    
    @XmlElement(name = "WorkUnit")
    private List<WorkUnit> list;

    public WorkUnits() {
        list = new ArrayList<WorkUnit>();
    }
    
    public List<WorkUnit> getList() {
        return list;
    }

    public void setList(List<WorkUnit> list) {
        this.list = list;
    }
    
    
}
