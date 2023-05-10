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

/**
 *
 * @author admin
 */
public class RequestsController {
    private UserModel model;
    private RequestsView view;

    public RequestsController(UserModel model, RequestsView view) {
        this.model=model;
        this.view = view;
        
        view.getBack().addMouseListener((MouseListener) new RequestsController.showBack());
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
        view.dispose();
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
