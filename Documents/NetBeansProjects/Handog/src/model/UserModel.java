    package model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UserModel {
    private String donorLastName="", donorFirstName="", dPhoneNumber="", dEmail="", address="", donationCateg="";
    private LocalDate donationDate;
    private double donationAmount = 0;
        
        

	private ArrayList<Transaction> transactions = new ArrayList<>();
	private Stack<Double> donationAmountStack = new Stack<Double>();
        

        

	
	public Stack<Double> getStack() {
		return donationAmountStack;
	}
	
	public void addAmountDonation(double userInput) {
		
		donationAmountStack.push(userInput);
	}
	
	public double getDonationAmount() {
		return donationAmount;
	}
	
	public void addTransactions(Transaction transaction) {
	    transactions.add(transaction);
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	
	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}
	
	
	public LocalDate getDonationDate() {
		return donationDate;
	}
	
	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}
	
//	public String getDonationCategory() {
//		return donationCategory;
//	}
//	
//	public void setDonationCategory(String donorCategory) {
//		this.donationCategory = donorCategory;
//	}
	
	public String getDonorFirstName() {
		return donorFirstName;
	}
	
	public void setDonorFirstName(String donorFirstName) {
		this.donorFirstName = donorFirstName;
	}
	
	public String getDonorLastName() {
		return donorLastName;
	}
	
	public void setDonorLastName(String donorLastName) {
		this.donorLastName = donorLastName;
	}
	
	public String getPhoneNumber() {
		return dPhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.dPhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return dEmail;
	}
	public void setEmail(String email) {
		this.dEmail = email;
	}

    
   

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDonationCateg() {
		return donationCateg;
	}

	public void setDonationCateg(String donationType) {
		this.donationCateg = donationType;
	}
        
        
        
        
        ////////////////////////////////
        

        // Getter and Setter for brgy

}
