/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
public class ReceiverModel {
    private String brgy="",city="", rCategory="", rEmail="", rContactNum="", status="";
    private double rAmount = 0;
    private LocalDate reqDate;
    private LocalTime time;
    private Duration duration;
    private Queue<Request> request = new LinkedList<Request>();
    
    
            public Queue<Request> getRequests(){
            return request;
        }
            
            public void addRequest(Request req){
                request.add(req);
                
            }
            
            public String getBrgy() {
    return brgy;
}
            
            public LocalTime getTime(){
    return time;
}

public void setBrgy(String brgy) {
    this.brgy = brgy;
}

// Getter and Setter for city
public String getCity() {
    return city;
}

public void setCity(String city) {
    this.city = city;
}

// Getter and Setter for rCategory
public String getRCategory() {
    return rCategory;
}

public void setRCategory(String rCategory) {
    this.rCategory = rCategory;
}

// Getter and Setter for rEmail
public String getREmail() {
    return rEmail;
}

public void setREmail(String rEmail) {
    this.rEmail = rEmail;
}

// Getter and Setter for rContactNum
public String getRContactNum() {
    return rContactNum;
}

public void setRContactNum(String rContactNum) {
    this.rContactNum = rContactNum;
}

// Getter and Setter for duration
public Duration getDuration() {
    return duration;
}

public void setDuration(Duration duration) {
    this.duration = duration;
}


// Getter and Setter for status
public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}
public LocalDate getReqDate(){
    return reqDate;
}
public void setReqDate(LocalDate date){
    this.reqDate = date;
}
public double getRAmount() {
    return rAmount;
}

// Setter method
public void setRAmount(double amount) {
    rAmount = amount;
}

    public void setTime(LocalTime currentTime) {
       this.time = currentTime;
    }
    
    
}
