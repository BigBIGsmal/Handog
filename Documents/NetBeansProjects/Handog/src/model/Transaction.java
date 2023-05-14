package model;

import java.time.LocalDate;

public class Transaction {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String donationType;
    private LocalDate date;
    private double amount;

    public Transaction(String firstName, String lastName, String phoneNumber, String email,
                       String donationType, LocalDate date, double amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.donationType = donationType;
        this.date = date;
        this.amount = amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDonationCategory() {
        return donationType;
    }

    public void setDonationCategory(String donationCategory) {
        this.donationType = donationCategory;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
