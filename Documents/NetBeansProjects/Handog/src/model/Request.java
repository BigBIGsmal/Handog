/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class Request {

    private String brgy="",city="", category="", email="", contactNum="", duration="", status="";
    private LocalDate date;
    
        public Request(String barangay, String city, String category, String contactNum,String duration, LocalDate date) {
        this.brgy = barangay;
        this.city = city;
        this.category = category;
        this.contactNum = contactNum;
        this.duration = duration;
        this.date = date;
    }

}
