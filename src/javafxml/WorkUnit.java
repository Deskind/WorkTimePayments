/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desk1nd
 */

@XmlRootElement(name = "WorkUnit")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkUnit {
    private String date;
    private String city;
    private String beginTime;
    private String finishTime;
    private double totalTime;

    public WorkUnit() {
    }

    public WorkUnit(String date, String city, String beginTime, String finishTime, double totalTime) {
        this.date = date;
        this.city = city;
        this.beginTime = beginTime;
        this.finishTime = finishTime;
        this.totalTime = totalTime;
    }
    
   
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }
    
    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }
    
    

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public double getTotalTime() {
        return totalTime;
    }
    
    
    
    
}
