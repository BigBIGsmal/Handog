/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.BorderFactory;





/**
 *
 * @author jovde
 */

public class TableView extends javax.swing.JFrame {

    /**
     * Creates new form TableView
     */
    public TableView() {
        initComponents();
         // Center the frame on the screen
        setLocationRelativeTo(null);
        
        // Set the frame to not be resizable
        setResizable(false);
    
    }







        
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        clrBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        fNameTb = new javax.swing.JTextField();
        lNameTb = new javax.swing.JTextField();
        pNumberTb = new javax.swing.JTextField();
        eMailTb = new javax.swing.JTextField();
        hAddressTb = new javax.swing.JTextField();
        donationTypeCb = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ascBtn = new javax.swing.JButton();
        descBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setMaximumSize(new java.awt.Dimension(800, 90));
        jPanel4.setMinimumSize(new java.awt.Dimension(800, 90));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 90));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, -1));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(250, 5102767));
        jPanel2.setMinimumSize(new java.awt.Dimension(250, 510));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 510));

        clrBtn.setText("clear");
        clrBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clrBtnMouseEntered(evt);
            }
        });

        addBtn.setText("add");

        fNameTb.setText("First Name");
        fNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameTbActionPerformed(evt);
            }
        });

        lNameTb.setText("Last Name");
        lNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lNameTbActionPerformed(evt);
            }
        });

        pNumberTb.setText("Phone Number");
        pNumberTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pNumberTbActionPerformed(evt);
            }
        });

        eMailTb.setText("Email");
        eMailTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eMailTbActionPerformed(evt);
            }
        });

        hAddressTb.setText("Address");
        hAddressTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hAddressTbActionPerformed(evt);
            }
        });

        donationTypeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(donationTypeCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hAddressTb)
                    .addComponent(eMailTb)
                    .addComponent(lNameTb)
                    .addComponent(fNameTb, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(clrBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(addBtn))
                    .addComponent(pNumberTb))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(fNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(pNumberTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(eMailTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(hAddressTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(donationTypeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clrBtn)
                    .addComponent(addBtn))
                .addGap(48, 48, 48))
        );

        fNameTb.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
        fNameTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
        fNameTb.setText("First Name"); // set placeholder text

        // Add FocusListener to remove placeholder text when field gains focus
        fNameTb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (fNameTb.getText().equals("First Name")) {
                    fNameTb.setText("");
                    fNameTb.setForeground(java.awt.Color.BLACK); // set text color back to black
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (fNameTb.getText().isEmpty()) {
                    fNameTb.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
                    fNameTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
                    fNameTb.setText("First Name"); // set placeholder text
                }
            }
        });

        // Add ActionListener to handle user input
        fNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameTbActionPerformed(evt);
            }
        });
        lNameTb.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
        lNameTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
        lNameTb.setText("Last Name"); // set placeholder text

        // Add FocusListener to remove placeholder text when field gains focus
        lNameTb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (lNameTb.getText().equals("Last Name")) {
                    lNameTb.setText("");
                    lNameTb.setForeground(java.awt.Color.BLACK); // set text color back to black
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (lNameTb.getText().isEmpty()) {
                    lNameTb.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
                    lNameTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
                    lNameTb.setText("Last Name"); // set placeholder text
                }
            }
        });

        // Add ActionListener to handle user input
        lNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameTbActionPerformed(evt);
            }
        });
        pNumberTb.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
        pNumberTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
        pNumberTb.setText("Phone Number"); // set placeholder text

        // Add FocusListener to remove placeholder text when field gains focus
        pNumberTb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (pNumberTb.getText().equals("Phone Number")) {
                    pNumberTb.setText("");
                    pNumberTb.setForeground(java.awt.Color.BLACK); // set text color back to black
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (pNumberTb.getText().isEmpty()) {
                    pNumberTb.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
                    pNumberTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
                    pNumberTb.setText("Phone Number"); // set placeholder text
                }
            }
        });

        // Add ActionListener to handle user input
        pNumberTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pNumberTbActionPerformed(evt);
            }
        });
        eMailTb.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
        eMailTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
        eMailTb.setText("Email"); // set placeholder text

        // Add FocusListener to remove placeholder text when field gains focus
        eMailTb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (eMailTb.getText().equals("Email")) {
                    eMailTb.setText("");
                    eMailTb.setForeground(java.awt.Color.BLACK); // set text color back to black
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (eMailTb.getText().isEmpty()) {
                    eMailTb.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
                    eMailTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
                    eMailTb.setText("Email"); // set placeholder text
                }
            }
        });

        // Add ActionListener to handle user input
        eMailTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eMailTbActionPerformed(evt);
            }
        });
        hAddressTb.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
        hAddressTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
        hAddressTb.setText("Address"); // set placeholder text

        // Add FocusListener to remove placeholder text when field gains focus
        hAddressTb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (hAddressTb.getText().equals("Address")) {
                    hAddressTb.setText("");
                    hAddressTb.setForeground(java.awt.Color.BLACK); // set text color back to black
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (hAddressTb.getText().isEmpty()) {
                    hAddressTb.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
                    hAddressTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
                    hAddressTb.setText("Address"); // set placeholder text
                }
            }
        });

        // Add ActionListener to handle user input
        hAddressTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hAddressTbActionPerformed(evt);
            }
        });

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 530));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(550, 510));
        jPanel3.setMinimumSize(new java.awt.Dimension(550, 510));
        jPanel3.setPreferredSize(new java.awt.Dimension(550, 510));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Phone Number", "Email", "Address", "Donation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        // Set the background color of the table
        jTable1.setBackground(new java.awt.Color(255, 248, 238));

        // Set the foreground color of the table
        jTable1.setForeground(new java.awt.Color(0,0,0));

        // Set the font of the table
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11));

        // Set the selection background color of the table
        jTable1.setSelectionBackground(new java.awt.Color(255, 192, 203));

        // Set the selection foreground color of the table
        jTable1.setSelectionForeground(new java.awt.Color(0,0,0));

        // Set the grid color of the table
        jTable1.setGridColor(new java.awt.Color(255, 192, 203));

        // Set the row height of the table
        jTable1.setRowHeight(30);

        // Set the header font of the table
        jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", 1, 11));

        // Set the header background color of the table
        jTable1.getTableHeader().setBackground(new java.awt.Color(255, 192, 203));

        // Set the header foreground color of the table
        jTable1.getTableHeader().setForeground(new java.awt.Color(0,0,0));

        // Set the header row height of the table
        jTable1.getTableHeader().setPreferredSize(new java.awt.Dimension(30, 40));
        // Set the grid color of the table
        jTable1.setGridColor(new java.awt.Color(255, 192, 203));

        // Set the grid radius and color of the table
        jTable1.setShowGrid(true);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5, true));

        ascBtn.setText("Ascending");
        ascBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ascBtnActionPerformed(evt);
            }
        });

        descBtn.setText("Descending");
        descBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Home");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(505, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(ascBtn)
                        .addGap(18, 18, 18)
                        .addComponent(descBtn)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(28, 28, 28))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ascBtn)
                    .addComponent(descBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backBtn)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        ascBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 25, 10, 25));
        ascBtn.setBackground(new java.awt.Color(51, 153, 255));
        ascBtn.setForeground(java.awt.Color.WHITE);
        ascBtn.setFont(new java.awt.Font("Segoe UI", 1, 14));

        ascBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ascBtn.setBackground(new java.awt.Color(0, 102, 204));
                ascBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ascBtn.setBackground(new java.awt.Color(51, 153, 255));
                ascBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        ascBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ascBtnActionPerformed(evt);
            }
        });
        descBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 25, 10, 25));
        descBtn.setBackground(new java.awt.Color(255, 255, 0));
        descBtn.setForeground(java.awt.Color.BLACK);
        descBtn.setFont(new java.awt.Font("Segoe UI", 1, 14));

        descBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                descBtn.setBackground(new java.awt.Color(255, 204, 0));
                descBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                descBtn.setBackground(new java.awt.Color(255, 255, 0));
                descBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        descBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descBtnActionPerformed(evt);
            }
        });

        // Add timer to update background color of jPanel3 every 500 milliseconds
        int animationDelay = 500; // Milliseconds between color updates
        javax.swing.Timer timer = new javax.swing.Timer(animationDelay, new ActionListener() {
            private int colorIndex = 0;
            private java.awt.Color[] colors = {new java.awt.Color(153, 204, 255), new java.awt.Color(255, 153, 153)}; // Array of colors to cycle through
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel3.setBackground(colors[colorIndex]);
                colorIndex = (colorIndex + 1) % colors.length;
            }
        });
        timer.start();

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 720, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ascBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ascBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ascBtnActionPerformed

    private void lNameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lNameTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lNameTbActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        HomeView home = new HomeView();
        home.setVisible(true);
        home.pack();
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void fNameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNameTbActionPerformed

    private void pNumberTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pNumberTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pNumberTbActionPerformed

    private void eMailTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eMailTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eMailTbActionPerformed

    private void hAddressTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hAddressTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hAddressTbActionPerformed

    private void clrBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clrBtnMouseEntered
                                          

 
    }//GEN-LAST:event_clrBtnMouseEntered

    private void descBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton ascBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clrBtn;
    private javax.swing.JButton descBtn;
    private javax.swing.JComboBox<String> donationTypeCb;
    private javax.swing.JTextField eMailTb;
    private javax.swing.JTextField fNameTb;
    private javax.swing.JTextField hAddressTb;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lNameTb;
    private javax.swing.JTextField pNumberTb;
    // End of variables declaration//GEN-END:variables
}
