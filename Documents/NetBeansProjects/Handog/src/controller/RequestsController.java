package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

import javax.swing.JFrame;

import model.UserModel;
import view.HomeView;
import view.RequestsView;
import view.SearchView;

public class RequestsController {
    private UserModel model;
    private RequestsView view;

    public RequestsController(UserModel model, RequestsView view) {
        this.model = model;
        this.view = view;

        view.getBack().addMouseListener(new ShowBack());
        view.getAddBtn().addActionListener(new AddButtonListener());
    }

    public static Duration createDuration(int hours, int minutes, int seconds) {
        return Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }

    class ShowBack implements MouseListener {

        private HomeView nextView;

        @Override
        public void mouseClicked(MouseEvent e) {
            nextView = new HomeView();
            HomeController nextController = new HomeController(model, nextView);
            nextView.setVisible(true);
            nextView.pack();
            nextView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            view.getBack().setForeground(Color.BLUE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            view.getBack().setForeground(Color.BLACK);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    }

    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
          
        }
    }
}
