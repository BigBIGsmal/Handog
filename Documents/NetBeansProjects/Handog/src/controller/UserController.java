package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

import model.Transaction;
import model.UserModel;
import view.HomeView;
import view.TableView;
//import handog.view.MainHome;
//import handog.view.UserHomePageMonthly;
//import handog.view.UserHomePageOneTime;
//import handog.view.UserInfoView;

public class UserController {

	private UserModel model;
        private TableView view;
//	private UserInfoView view;
//	private UserHomePageMonthly homeMonthly;
//	private UserHomePageOneTime oneTimePage;
//	private MonthlyDonationsController secondController;
//	private Transaction modelTransaction;
//	private MainHome tryView;

	public UserController(UserModel model, TableView view) {
		this.model = model;
		this.view = view;

//		view.getSubscriptionMonthlyButton().addActionListener(new MonthlyButtonListener());
//		view.getSubscriptionOnetimeButton().addActionListener(new OnetimeButtonListener());

		view.getAddButton().addActionListener(new AddButtonListener());
                view.getBackButton().addActionListener(new BackButtonListener());
	}
        

        
        class BackButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
           HomeView home = new HomeView();
        HomeController control = new HomeController(model, home);
        home.setVisible(true);
        home.pack();
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	}
	

	
	class AddButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String firstName = verifyInput(view.getFirstName());
			String lastName = verifyInput(view.getLastName());
			String address = verifyInput(view.getAddress());
			String email = verifyInput(view.getEmail());
			String phoneNumber = verifyInput(view.getPhoneNum());
//			String donationType = model.getDonationType();
                        String donationCateg = verifyInput(view.getDonationCategory());
			
			boolean fieldsAreValid = checkUserFields(firstName, lastName, address, email, phoneNumber, donationCateg);
			if (!fieldsAreValid) {
				return;
			}
			
			setUserInformation(firstName, lastName, address, email, phoneNumber, donationCateg);
		     
      

		      String userInfo = userInfo(model.getDonorFirstName(),
		          model.getDonorLastName(), model.getAddress(), model.getEmail(),
		          model.getPhoneNumber(), model.getDonationCateg());

//		      String[] options = {"Yes", "Cancel"};

		      int result = JOptionPane.showOptionDialog(null, userInfo, "Confirmation",
		          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
//
//
//			if (result == JOptionPane.OK_OPTION) {
//				// go to user home page monthly/one-time view /// have an if else
//				if (model.getDonationType().equals("Monthly Donation")) {
//					homeMonthly = new UserHomePageMonthly();
//					homeMonthly.showView();
//					MonthlyDonationsController nextController = new MonthlyDonationsController(model, homeMonthly );
//				
//					
//			
//				} else if (model.getDonationType().equals("One-Time Donation")) {
//					oneTimePage = new UserHomePageOneTime(); // turn into one time JFrame
//					oneTimePage.showView();
//					
//					OneTimeDonationsController nextController = new OneTimeDonationsController(model, oneTimePage);
//					
//				}
//				view.getJFrame().setVisible(false);;
//			}
		}
	}
	
	private boolean checkUserFields(String firstName, String lastName, String address, String email, String phoneNumber, String donationType) {
	    // Regular expression patterns
	    Pattern namePattern = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
	    Pattern emailPattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
	    Pattern phonePattern = Pattern.compile("^\\d{11}$");

	    boolean isValid = true;
	    String missingFields = "Please fill out the following fields:";
	    if (firstName.trim().isEmpty() || firstName.trim().equalsIgnoreCase("Enter First Name")) {
	        isValid = false;
	        missingFields += "\n- First Name";
	    } else {
	        Matcher firstnameMatcher = namePattern.matcher(firstName.trim());
	        if (!firstnameMatcher.matches()) {
	            isValid = false;
	            missingFields += "\n- Invalid First Name";
	        }
	    } 
	    if (lastName.trim().isEmpty() || lastName.trim().equalsIgnoreCase("Enter Last Name")) {
	        isValid = false;
	        missingFields += "\n- Last Name";
	    } else {
	        Matcher lastnameMatcher = namePattern.matcher(lastName.trim());
	        if (!lastnameMatcher.matches()) {
	            isValid = false;
	            missingFields += "\n- Invalid Last Name";
	        }
	    }if (address.trim().isEmpty() || address.trim().equalsIgnoreCase("Enter Current Address")) {
	        isValid = false;
	        missingFields += "\n-  Address";
	    }
	    if (phoneNumber.trim().isEmpty() || phoneNumber.trim().equalsIgnoreCase("Enter Phone Number")) {
	        isValid = false;
	        missingFields += "\n- Phone Number";
	    } else {
	        Matcher phoneMatcher = phonePattern.matcher(phoneNumber.trim());
	        if (!phoneMatcher.matches()) {
	            isValid = false;
	            missingFields += "\n- Invalid Phone Number";
	        }
	    }
	    if (email.trim().isEmpty() || email.trim().equalsIgnoreCase("Enter Email")) {
	        isValid = false;
	        missingFields += "\n- Email";
	    } else {
	        Matcher emailMatcher = emailPattern.matcher(email.trim());
	        if (!emailMatcher.matches()) {
	            isValid = false;
	            missingFields += "\n- Invalid Email";
	        }
	    }
	    if (donationType.trim().isEmpty() || donationType.trim().equalsIgnoreCase("N/A")) {
	        isValid = false;
	        missingFields += "\n- Donation Type";
	    }

	    if (!isValid) {
	        JOptionPane.showMessageDialog(null, missingFields, "Missing Fields",
	                JOptionPane.ERROR_MESSAGE);
	    }
	    
	    return isValid;
	}


	private void setUserInformation(String firstName, String lastName, String address, String email, String phoneNumber, String donationCateg) {
	      model.setDonorFirstName(firstName);
	      model.setDonorLastName(lastName);
	      model.setAddress(address);
	      model.setEmail(email);
	      model.setPhoneNumber(phoneNumber);
	      model.setDonationCateg(donationCateg);
	      
	      LocalDate start = LocalDate.of(2021, 1, 1);
		    LocalDate end = LocalDate.of(2022, 12, 31);

		    long startEpochDay = start.toEpochDay();
		    long endEpochDay = end.toEpochDay();
		    long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

		    LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		    model.setDonationDate(randomDate);
	}
	
//	class MonthlyButtonListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			model.setDonationType("Monthly Donation");
//		}
//	}
//
//	class OnetimeButtonListener implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			model.setDonationType("One-Time Donation");
//		}
//	}

	private String verifyInput(String input) {
		if (input.trim().equals("")) {
			return "N/A";
		} else {
			return input.trim();
		}
	}

	private String userInfo(String firstName, String lastName, String address, String email, String phoneNumber,
			String donationType) {
		String message = "First Name: " + firstName + "\n" + "Last Name: " + lastName + "\n" + "Address: " + address
				+ "\n" + "Email: " + email + "\n" + "Phone Number: " + phoneNumber + "\n" + "\n"
				+ "Donation Type: " + donationType;
		return message;
	}
	
	public String getUserName() {
		return model.getDonorFirstName();
	}
}
