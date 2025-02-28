/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class RequestsView extends javax.swing.JFrame {

    /**
     * Creates new form RequestsView
     */
    public RequestsView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        fNameTb = new javax.swing.JTextField();
        lNameTb = new javax.swing.JTextField();
        pNumberTb = new javax.swing.JTextField();
        eMailTb = new javax.swing.JTextField();
        donationTypeCb = new javax.swing.JComboBox<>();
        clrBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        eMailTb1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(251, 236, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePanel.setBackground(new java.awt.Color(153, 255, 255));
        tablePanel.setLayout(new javax.swing.BoxLayout(tablePanel, javax.swing.BoxLayout.LINE_AXIS));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Barangay", "City", "Category", "Email", "Contact", "Date", "Duration", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        tablePanel.add(jScrollPane1);

        jPanel1.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 550, 490));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fNameTb.setText("Barangay");
        fNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameTbActionPerformed(evt);
            }
        });
        jPanel2.add(fNameTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 20, 191, -1));

        lNameTb.setText("City");
        lNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lNameTbActionPerformed(evt);
            }
        });
        jPanel2.add(lNameTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 76, 191, -1));

        pNumberTb.setText("Contact");
        pNumberTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pNumberTbActionPerformed(evt);
            }
        });
        jPanel2.add(pNumberTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 191, -1));

        eMailTb.setText("Address");
        eMailTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eMailTbActionPerformed(evt);
            }
        });
        jPanel2.add(eMailTb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 191, -1));

        donationTypeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        donationTypeCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donationTypeCbActionPerformed(evt);
            }
        });
        jPanel2.add(donationTypeCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 130, 206, -1));

        clrBtn.setText("clear");
        jPanel2.add(clrBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        addBtn.setText("add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel2.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        jRadioButton1.setText("Accepted");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, -1));

        jRadioButton2.setText("Declined");
        jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 90, -1));

        jPanel6.setBackground(new java.awt.Color(247, 182, 219));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 21, -1, -1));

        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 210, 40));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 230, 40));

        eMailTb1.setText("Email");
        jPanel2.add(eMailTb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 192, 191, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 490));

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lNameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lNameTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lNameTbActionPerformed

    private void fNameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNameTbActionPerformed

    private void donationTypeCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donationTypeCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_donationTypeCbActionPerformed

    private void pNumberTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pNumberTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pNumberTbActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void eMailTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eMailTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eMailTbActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        
        HomeView home = new HomeView();
        home.setVisible(true);
        home.pack();
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(RequestsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RequestsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton clrBtn;
    private javax.swing.JComboBox<String> donationTypeCb;
    private javax.swing.JTextField eMailTb;
    private javax.swing.JTextField eMailTb1;
    private javax.swing.JTextField fNameTb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lNameTb;
    private javax.swing.JTextField pNumberTb;
    private javax.swing.JPanel tablePanel;
    // End of variables declaration//GEN-END:variables
}
