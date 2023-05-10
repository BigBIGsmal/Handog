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
public class SearchController {
    
        	private UserModel model;
	private SearchView view;
	
    
    	public SearchController(UserModel model, SearchView view ) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.view = view;
                
                view.getDonate().addMouseListener((MouseListener) new SearchController.showTable());
                view.getRequests().addMouseListener((MouseListener) new SearchController.showRequests());
                view.getHome().addMouseListener((MouseListener) new SearchController.showHome());
                view.getBack().addMouseListener((MouseListener) new SearchController.showBack());
                
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
	        view.getRequests().setForeground(Color.BLUE);
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	        // Code to execute when the mouse exits the label
	        view.getRequests().setForeground(Color.BLACK);
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
     
          class showHome implements MouseListener {

        private HomeView nextView;
	    @Override
	    public void mouseClicked(MouseEvent e) {
	        // Code to execute when the label is clicked
         nextView = new HomeView();
            HomeController nextController = new HomeController(model,nextView);
        nextView.setVisible(true);
        nextView.pack();
        nextView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
	        // Code to execute when the mouse enters the label
	        view.getHome().setForeground(Color.BLUE);
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	        // Code to execute when the mouse exits the label
	        view.getHome().setForeground(Color.BLACK);
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
           class showBack implements MouseListener {

        private HomeView nextView;
	    @Override
	    public void mouseClicked(MouseEvent e) {
	        // Code to execute when the label is clicked
         nextView = new HomeView();
            HomeController nextController = new HomeController(model,nextView);
        nextView.setVisible(true);
        nextView.pack();
        nextView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
	        // Code to execute when the mouse enters the label
	        view.getBack().setForeground(Color.BLUE);
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	        // Code to execute when the mouse exits the label
	        view.getBack().setForeground(Color.BLACK);
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
