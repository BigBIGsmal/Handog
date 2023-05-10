/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import model.UserModel;
import view.HomeView;
import view.RequestsView;
import view.SearchView;
import view.TableView;

/**
 *
 * @author admin
 */
public class HomeController {
    
    	private UserModel model;
	private HomeView view;
	
	public HomeController(UserModel model, HomeView view ) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.view = view;
                
                view.getDonate().addMouseListener((MouseListener) new showTable());
                view.getDonationReq().addMouseListener((MouseListener) new showRequests());
                view.getSearchTransac().addMouseListener((MouseListener) new showSearch());
                //view.getLogout().addMouseListener((MouseListener) new logOut());
                
        }
        
        //User Defined getters and setters for actions of user in
    //the Home View
        
                class showSearch implements MouseListener {

        private SearchView nextView;
	    @Override
	    public void mouseClicked(MouseEvent e) {
	        // Code to execute when the label is clicked
         nextView = new SearchView();
          SearchController nextController = new SearchController(model,nextView);
        nextView.setVisible(true);
        nextView.pack();
        nextView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
	        // Code to execute when the mouse enters the label
	        view.getSearchTransac().setForeground(Color.BLUE);
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	        // Code to execute when the mouse exits the label
	        view.getSearchTransac().setForeground(Color.BLACK);
	    }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	    // Other MouseListener methods
	}
        
        class showRequests implements MouseListener {

        private RequestsView requestView;
	    @Override
	    public void mouseClicked(MouseEvent e) {
	        // Code to execute when the label is clicked
         requestView = new RequestsView();
          RequestsController nextController = new RequestsController(model,requestView);
        requestView.setVisible(true);
        requestView.pack();
        requestView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
	        // Code to execute when the mouse enters the label
	        view.getDonationReq().setForeground(Color.BLUE);
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	        // Code to execute when the mouse exits the label
	        view.getDonationReq().setForeground(Color.BLACK);
	    }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	    // Other MouseListener methods
	}
        
        class showTable implements MouseListener {

        private TableView tableView;
	    @Override
	    public void mouseClicked(MouseEvent e) {
	        // Code to execute when the label is clicked
         tableView = new TableView();
            UserController nextController = new UserController(model,tableView);
        tableView.setVisible(true);
        tableView.pack();
        tableView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
	        // Code to execute when the mouse enters the label
	        view.getDonate().setForeground(Color.BLUE);
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	        // Code to execute when the mouse exits the label
	        view.getDonate().setForeground(Color.BLACK);
	    }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	    // Other MouseListener methods
	}
}
