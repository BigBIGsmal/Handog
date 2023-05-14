
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.ToolTipManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;
import java.text.DecimalFormat;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.UserModel;
import static view.PesoRenderer.totalDonationAmount;

// Custom cell renderer for adding the peso sign and comma separator
class PesoRenderer extends DefaultTableCellRenderer {
    private final DecimalFormat pesoFormat = new DecimalFormat("₱#,##0.000");

    public PesoRenderer() {
        super();
    }
public static double totalDonationAmount = 0.0;

    @Override
    protected void setValue(Object value) {
        if (value != null) {
            double amount = Double.parseDouble(value.toString());
            setText(pesoFormat.format(amount)); // Format the value with comma separator and add the peso sign
        } else {
            setText("");
        }
    }
}

class DonationEntry {
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String address;
    String donationCategory;
    double donationAmount;
    Object date;

    DonationEntry(String firstName, String lastName, String phoneNumber, String email, String address, String donationCategory, double donationAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.donationCategory = donationCategory;
        this.donationAmount = donationAmount;
    }
}

class Node {
    DonationEntry entry;
    Node next;

    Node(DonationEntry entry) {
        this.entry = entry;
        this.next = null;
    }
}

public class TableView extends javax.swing.JFrame {
    Node head;
   
private void saveDataToFile(String filePath) {
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
    String dateText = currentDate.format(dateFormatter);
    String fileName = dateText + " - Data.txt";

    String directoryPath = "C:\\Users\\andre\\OneDrive\\Desktop\\HandogFinal\\Documents\\NetBeansProjects\\Handog\\src\\Data";
    String fileFullPath = directoryPath + File.separator + fileName;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileFullPath))) {
        // Title
        writer.write("+------------------------------------------------------+\n");
        writer.write("|                    DONATION REPORT                    |\n");
        writer.write("+------------------------------------------------------+\n\n");

        Node currentNode = head;
        while (currentNode != null) {
            DonationEntry currentEntry = currentNode.entry;
            writer.write("| First Name        : " + currentEntry.firstName + addSpaces(22 - currentEntry.firstName.length()) + "|\n");
            writer.write("| Last Name         : " + currentEntry.lastName + addSpaces(22 - currentEntry.lastName.length()) + "|\n");
            writer.write("| Phone Number      : " + currentEntry.phoneNumber + addSpaces(22 - currentEntry.phoneNumber.length()) + "|\n");
            writer.write("| Email             : " + currentEntry.email + addSpaces(22 - currentEntry.email.length()) + "|\n");
            writer.write("| Address           : " + currentEntry.address + addSpaces(22 - currentEntry.address.length()) + "|\n");
            writer.write("| Donation Category : " + currentEntry.donationCategory + addSpaces(22 - currentEntry.donationCategory.length()) + "|\n");
            writer.write("| Donation Amount   : ₱" + formatDonationAmount(currentEntry.donationAmount) + addSpaces(22 - formatDonationAmount(currentEntry.donationAmount).length() - 1) + "|\n");
            writer.write("| Date              : " + currentEntry.date + addSpaces(22 - currentEntry.date.toString().length()) + "|\n");
            writer.write("+------------------------------------------------------+\n");
            writer.write("\n");

            currentNode = currentNode.next;
        }

        writer.flush();

        System.out.println("Data saved successfully to " + fileName);
    } catch (IOException e) {
        // Handle the exception
        System.out.println("Failed to save data to " + fileName);
    }
}

private String addSpaces(int count) {
    StringBuilder spaces = new StringBuilder();
    for (int i = 0; i < count; i++) {
        spaces.append(" ");
    }
    return spaces.toString();
}

private String formatDonationAmount(double amount) {
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    return decimalFormat.format(amount);
}


private UserModel model;
   public TableView(UserModel model) {
       this.model=model;
        initComponents();
        // Center the frame on the screen
        getContentPane().requestFocusInWindow();
        setLocationRelativeTo(null);

        // Set the frame to not be resizable
        setResizable(false);

        head = null;


// Code for other table customization...

// Add the table to a scroll pane
jScrollPane1.setViewportView(jTable1);

// Code for other components and parent container...

// Add the table sorter to the table header
jTable1.getTableHeader().setReorderingAllowed(false); // Disable column reordering

jTable1.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int columnIndex = jTable1.getTableHeader().columnAtPoint(evt.getPoint());
        jTable1.getRowSorter().toggleSortOrder(columnIndex); // Toggle the sort order of the clicked column
    }
});

// Add ListSelectionListener to the table
jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
    if (!event.getValueIsAdjusting()) {
        fillFieldsFromTable();
    }
        });


        // Set custom UI Manager to override placeholder color
        UIManager.put("TextField.inactiveForeground", Color.BLACK);
        UIManager.put("ComboBox.disabledForeground", Color.BLACK);
    }

    private void fillFieldsFromTable() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
        
            String firstName = jTable1.getValueAt(selectedRow, 0).toString();
            String lastName = jTable1.getValueAt(selectedRow, 1).toString();
            String phoneNumber = jTable1.getValueAt(selectedRow, 2).toString();
            String email = jTable1.getValueAt(selectedRow, 3).toString();
            String address = jTable1.getValueAt(selectedRow, 4).toString();
            String donationCategory = jTable1.getValueAt(selectedRow, 5).toString();
            String donationAmount = jTable1.getValueAt(selectedRow, 6).toString();

            // Set the values in the text fields and combo box
            fNameTb.setForeground(Color.BLACK);
            fNameTb.setText(firstName);
            lNameTb.setForeground(Color.BLACK);
            lNameTb.setText(lastName);
            pNumberTb.setForeground(Color.BLACK);
            pNumberTb.setText(phoneNumber);
            eMailTb.setForeground(Color.BLACK);
            eMailTb.setText(email);
            hAddressTextArea.setForeground(Color.BLACK);
            hAddressTextArea.setText(address);
            donationTypeCb.setForeground(Color.BLACK);
            donationTypeCb.setSelectedItem(donationCategory);
            donationAmtTB.setForeground(Color.BLACK);
            donationAmtTB.setText(donationAmount);
            
            
            //Total
    // Update the total donation amount
    totalDonationAmount += getDonationAmount();

    // Update the "Total" text field
    Total.setText("Total Donation: ₱" + formatDonationAmount(totalDonationAmount));

        }
    
    
   
    
    }

    private void addEntry() {
    String firstName = getFirstName();
    String lastName = getLastName();
    String phoneNumber = getPhoneNum();
    String email = getEmail();
    String address = getAddress();
    String donationCategory = getDonationCategory();
    double donationAmount = getDonationAmount();
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
    String formattedDate = currentDate.format(formatter);

    // Validate fields
    StringBuilder missingFieldsBuilder = new StringBuilder();
    StringBuilder invalidFieldsBuilder = new StringBuilder();

    if (firstName.isEmpty() || firstName.equals("First Name")) {
        missingFieldsBuilder.append("- FIRST NAME\n");
    }

    if (lastName.isEmpty() || lastName.equals("Last Name")) {
        missingFieldsBuilder.append("- LAST NAME\n");
    }

    if (phoneNumber.isEmpty() || phoneNumber.equals("Phone Number")) {
        missingFieldsBuilder.append("- PHONE NUMBER\n");
    }

    if (email.isEmpty() || email.equals("Email")) {
        missingFieldsBuilder.append("- EMAIL\n");
    }

    if (address.isEmpty() || address.equals("Address")) {
        missingFieldsBuilder.append("- ADDRESS\n");
    }

    if (donationCategory.isEmpty() || donationCategory.equals("Donation Category")) {
        missingFieldsBuilder.append(" - DONATION CATEGORY\n");
    }

    if (donationAmount <= 0 || String.valueOf(donationAmount).equals("Donation Amount")) {
        missingFieldsBuilder.append(" - DONATION AMOUNT\n");
    }

    // Validate the fields using regular expressions
    if (!firstName.matches("[A-Za-z]+") || !lastName.matches("[A-Za-z]+")) {
        invalidFieldsBuilder.append("- INVALID NAME. PLEASE USE ALPHABETIC CHARACTERS ONLY.\n");
    }

    if (!phoneNumber.matches("\\d{11}")) {
        invalidFieldsBuilder.append("- INVALID PHONE NUMBER. PLEASE ENTER 11 DIGITS.\n");
    }

    if (!email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")) {
        invalidFieldsBuilder.append("- INVALID EMAIL ADDRESS.\n");
    }

    if (address.isEmpty()) {
        invalidFieldsBuilder.append("- ADDRESS CANNOT BE EMPTY.\n");
    }

    if (donationAmount <= 0) {
        invalidFieldsBuilder.append("- INVALID DONATION AMOUNT.\n");
    }

    if (missingFieldsBuilder.length() > 0 || invalidFieldsBuilder.length() > 0) {
        StringBuilder dialogMessageBuilder = new StringBuilder();
        dialogMessageBuilder.append("<html><font size=\"7\"><b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp WARNING!&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></font></html>\n\n");

        if (invalidFieldsBuilder.length() > 0) {
            dialogMessageBuilder.append("INVALID FIELDS:\n\n");
            dialogMessageBuilder.append(invalidFieldsBuilder);
            dialogMessageBuilder.append("\n");
        }

        if (missingFieldsBuilder.length() > 0) {
            dialogMessageBuilder.append("MISSING FIELDS:\n\n");
            dialogMessageBuilder.append(missingFieldsBuilder);
        }

        // Create a bold font
        Font boldFont = new Font(Font.DIALOG, Font.BOLD, 16);

        // Set the font for the message dialog
                UIManager.put("OptionPane.messageFont", boldFont);

        // Show the message dialog with the warning message
        JOptionPane.showMessageDialog(this, dialogMessageBuilder.toString(), "Warning", JOptionPane.WARNING_MESSAGE);

        // Don't add the entry if any field is invalid or empty
        return;
    }
    
    // Check for duplications
    boolean isDuplicate = false;
    Node current = head;
    while (current != null) {
        DonationEntry existingEntry = current.entry;
        if (existingEntry.firstName.equals(firstName) &&
                existingEntry.lastName.equals(lastName) &&
                existingEntry.phoneNumber.equals(phoneNumber) &&
                existingEntry.email.equals(email) &&
                existingEntry.address.equals(address) &&
                existingEntry.donationCategory.equals(donationCategory) &&
                existingEntry.donationAmount == donationAmount) {
            isDuplicate = true;
            break;
        }
        current = current.next;
    }

    if (isDuplicate) {
        JOptionPane.showMessageDialog(this,
                "DUPLICATE ENTRY. This entry already exists in the table.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Update the total donation amount
    totalDonationAmount += donationAmount;

    // Update the "Total" text field
    Total.setText("₱" + formatDonationAmount(totalDonationAmount));



    DonationEntry entry = new DonationEntry(firstName, lastName, phoneNumber, email, address, donationCategory, donationAmount);
    entry.date = formattedDate;
    Node newNode = new Node(entry);

    if (head == null) {
        head = newNode;
    } else {
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    // Clear the existing rows from the table
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);

    // Update the GUI table with the new entries
    
    Node currentNode = head;
    while (currentNode != null) {
        DonationEntry currentEntry = currentNode.entry;
        Object[] rowData = {currentEntry.firstName, currentEntry.lastName, currentEntry.phoneNumber, currentEntry.email, currentEntry.address, currentEntry.donationCategory, currentEntry.donationAmount, currentEntry.date};
        model.addRow(rowData);
        currentNode = currentNode.next;
    }

    
}

    public JButton getBackButton() {
        return backBtn;
    }

    public JButton getAddButton() {
        return this.addBtn;
    }

    public String getFirstName() {
        return this.fNameTb.getText();
    }

    public String getLastName() {
        return this.lNameTb.getText();
    }

    public String getPhoneNum() {
        return this.pNumberTb.getText();
    }

    public String getEmail() {
        return this.eMailTb.getText();
    }

  public String getAddress() {
    return this.hAddressTextArea.getText();


    }

    public String getDonationCategory() {
        return this.donationTypeCb.getSelectedItem().toString();
    }

 public double getDonationAmount() {
    String amountText = donationAmtTB.getText();
    try {
        double amount = Double.parseDouble(amountText);
        return amount;
    } catch (NumberFormatException e) {
        // Handle the case where the input cannot be parsed as a double
        return 0; // or any other default value you prefer
    }


}

    

    public JButton getClearButton() {
        return this.clrBtn;
    }
public double calculateTotalDonationAmount() {
    double totalAmount = 0.0;
    Node currentNode = head;
    while (currentNode != null) {
        DonationEntry currentEntry = currentNode.entry;
        totalAmount += currentEntry.donationAmount;
        currentNode = currentNode.next;
    }
    return totalAmount;
}

    
    




        
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        fNameTb = new javax.swing.JTextField();
        lNameTb = new javax.swing.JTextField();
        pNumberTb = new javax.swing.JTextField();
        eMailTb = new javax.swing.JTextField();
        donationTypeCb = new javax.swing.JComboBox<>();
        donationAmtTB = new javax.swing.JTextField();
        hAddressTextArea = new java.awt.TextArea();
        Total = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        clrBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Handog-Donate");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(250, 5102767));
        jPanel2.setBackground(new Color(255, 192, 203, 200));
        jPanel2.setMinimumSize(new java.awt.Dimension(250, 510));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 510));

        fNameTb.setText("First Name");
        fNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameTbActionPerformed(evt);
            }
        });

        lNameTb.setText("Last Name");

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

        donationTypeCb.setBackground(new java.awt.Color(255, 204, 255));
        donationTypeCb.setEditable(true);
        donationTypeCb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        donationTypeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Healthcare", "Food", "Material Goods", "Any" }));

        donationAmtTB.setText("Donation Amount");
        donationAmtTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donationAmtTBActionPerformed(evt);
            }
        });

        Total.setEditable(false);
        Total.setText("Email");
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(hAddressTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(donationTypeCb, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(fNameTb)
                        .addComponent(lNameTb)
                        .addComponent(pNumberTb)
                        .addComponent(eMailTb)
                        .addComponent(donationAmtTB, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                        .addComponent(Total, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(fNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pNumberTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eMailTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hAddressTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(donationTypeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(donationAmtTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
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

        //fNameTb.addKeyListener(new java.awt.event.KeyListener() {
            //    @Override
            //    public void keyReleased(KeyEvent e) {
                //        if (fNameTb.getText().isEmpty()) {
                    //            fNameTb.setText("First Name");
                    //            fNameTb.setCaretPosition(0);
                    //        }
                //        if (fNameTb.getText().equals("First Name")){
                    //            fNameTb.setText("");
                    //        }
                //        System.out.println(fNameTb.getText());
                //    }
            //
            //    @Override
            //    public void keyTyped(KeyEvent e) {
                //
                //    }
            //
            //    @Override
            //    public void keyPressed(KeyEvent e) {
                //
                //    }
            //});
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
    donationAmtTB.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
    donationAmtTB.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
    donationAmtTB.setText("Donation Amount"); // set placeholder text

    // Add FocusListener to remove placeholder text when field gains focus
    donationAmtTB.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (donationAmtTB.getText().equals("Donation Amount")) {
                donationAmtTB.setText("");
                donationAmtTB.setForeground(java.awt.Color.BLACK); // set text color back to black
            }
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (donationAmtTB.getText().isEmpty()) {
                donationAmtTB.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
                donationAmtTB.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
                donationAmtTB.setText("Donation Amount"); // set placeholder text
            }
        }
    });

    // Add ActionListener to handle user input
    hAddressTextArea.setText("Address");
    hAddressTextArea.setColumns(10);

    // Set placeholder text color and font
    hAddressTextArea.setForeground(new java.awt.Color(150, 150, 150));
    hAddressTextArea.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));

    // Add FocusListener to remove placeholder text when the field gains focus
    hAddressTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (hAddressTextArea.getText().equals("Address")) {
                hAddressTextArea.setText("");
                hAddressTextArea.setForeground(java.awt.Color.BLACK);
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
            if (hAddressTextArea.getText().isEmpty()) {
                hAddressTextArea.setForeground(new java.awt.Color(150, 150, 150));
                hAddressTextArea.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
                hAddressTextArea.setText("Address");
            }
        }
    });
    Total.setForeground(new java.awt.Color(150,150,150)); // set placeholder text color
    Total.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // set placeholder text font
    Total.setText("Total Donation"); // set placeholder text

    jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 210, 490));

    jPanel3.setBackground(new java.awt.Color(135, 206, 250, 128)); // Translucent sky blue
    jPanel3.setMaximumSize(new java.awt.Dimension(550, 510));
    jPanel3.setMinimumSize(new java.awt.Dimension(550, 510));
    jPanel3.setPreferredSize(new java.awt.Dimension(550, 510));

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String[] {
            "First Name", "Last Name", "Phone Number", "Email", "Address", "Category", "Amount", "Date"
        }

    ) {
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class // Add java.lang.String.class for the Date column
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

    });
    jScrollPane1.setViewportView(jTable1);
    if (jTable1.getColumnModel().getColumnCount() > 0) {
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getColumnModel().getColumn(4).setResizable(false);
        jTable1.getColumnModel().getColumn(5).setResizable(false);
    }
    // Set the background color of the table
    jTable1.setBackground(new java.awt.Color(255, 255, 255));

    // Set the foreground color of the table
    jTable1.setForeground(new java.awt.Color(0, 0, 0));

    // Set the font of the table
    jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11));

    // Set the selection background color of the table
    jTable1.setSelectionBackground(new java.awt.Color(255, 192, 203));

    // Set the selection foreground color of the table
    jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));

    // Set the grid color of the table
    jTable1.setGridColor(new java.awt.Color(0, 0, 0));

    // Set the row height of the table
    jTable1.setRowHeight(30);

    // Set the header font of the table
    jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 11));

    // Set the header background color of the table
    jTable1.getTableHeader().setBackground(new java.awt.Color(255, 192, 203));

    // Set the header foreground color of the table
    jTable1.getTableHeader().setForeground(new java.awt.Color(0, 0, 0));

    // Set the header row height of the table
    jTable1.getTableHeader().setPreferredSize(new java.awt.Dimension(30, 40));

    // Set the grid visibility of the table
    jTable1.setShowGrid(true);

    // Set the border of the table
    jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

    // INSERTION SORT
    // Create a row sorter for the table
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());

    // Set the sorting order for the "Donation" column to ascending
    sorter.setSortKeys(List.of(new RowSorter.SortKey(6, SortOrder.ASCENDING))); // Assuming "Donation" column index is 6

    // Assign the row sorter to the table
    jTable1.setRowSorter(sorter);

    // Perform insertion sort on the table rows
    List<? extends RowSorter.SortKey> sortKeys = sorter.getSortKeys();
    if (!sortKeys.isEmpty()) {
        RowSorter.SortKey sortKey = sortKeys.get(0);
        if (sortKey.getColumn() == 6 && sortKey.getSortOrder() == SortOrder.ASCENDING) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int rowCount = model.getRowCount();
            for (int i = 1; i < rowCount; i++) {
                for (int j = i; j > 0; j--) {
                    Object currentRowAmount = model.getValueAt(j, 6); // Assuming "Amount" column index is 6
                    Object previousRowAmount = model.getValueAt(j - 1, 6);
                    if (currentRowAmount instanceof Double && previousRowAmount instanceof Double) {
                        double currentAmount = (Double) currentRowAmount;
                        double previousAmount = (Double) previousRowAmount;
                        if (currentAmount < previousAmount) {
                            model.moveRow(j, j, j - 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    // Set the cell renderer to align data to the left and add the peso sign
    DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
    leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
    for (int i = 0; i < jTable1.getColumnCount(); i++) {
        if (i == 6) { // Check if it's the "Amount" column
            jTable1.getColumnModel().getColumn(i).setCellRenderer(new PesoRenderer());
        } else {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }
    }

    // Custom cell renderer for adding the peso sign
    class PesoRenderer extends DefaultTableCellRenderer {
        public PesoRenderer() {
            super();
        }

        @Override
        protected void setValue(Object value) {
            if (value != null) {
                double amount = Double.parseDouble(value.toString());
                setText(pesoFormat.format(amount)); // Format the value as an integer and add the peso sign
            } else {
                setText("");
            }
        }
    }

    backBtn.setText("Home");
    backBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            backBtnActionPerformed(evt);
        }
    });

    addBtn.setText("add");
    addBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addBtnActionPerformed(evt);
        }
    });

    clrBtn.setText("clear");
    clrBtn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            clrBtnMouseEntered(evt);
        }
    });
    clrBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            clrBtnActionPerformed(evt);
        }
    });

    jLabel1.setBackground(new java.awt.Color(0, 255, 255));
    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(51, 51, 51));
    jLabel1.setText("TIME");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addGap(48, 48, 48)
            .addComponent(clrBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(32, 32, 32)
            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(50, 50, 50))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap(34, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
            .addGap(31, 31, 31))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clrBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(47, Short.MAX_VALUE))
    );

    LocalTime currentTime = LocalTime.now();

    // Format the time as "hh:mm:ss a"
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
    String formattedTime = currentTime.format(timeFormatter);

    // Set the formatted time as the text for jLabel1
    jLabel1.setText(formattedTime);

    // Set the font style, size, and color to resemble typewriter text
    Font labelFont = new Font(Font.MONOSPACED, Font.BOLD, 22);
    jLabel1.setFont(labelFont);

    // Make the JLabel opaque
    jLabel1.setOpaque(true);

    // Enable tooltips for jLabel1
    ToolTipManager.sharedInstance().registerComponent(jLabel1);

    // Set a tooltip with the full time
    jLabel1.setToolTipText(currentTime.toString());

    // Create a timer to update the time every second
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            LocalTime updatedTime = LocalTime.now();
            String updatedFormattedTime = updatedTime.format(timeFormatter);
            jLabel1.setText(updatedFormattedTime);
        }
    });

    // Start the timer
    timer.start();

    jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 700, 490));

    jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\andre\\OneDrive\\Desktop\\ICONS\\fillout.png")); // NOI18N
    jLabel2.setText("jLabel2");
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 960, 560));

    jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\andre\\OneDrive\\Desktop\\ICONS\\header.png")); // NOI18N
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 290, 70));

    jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\andre\\OneDrive\\Desktop\\ICONS\\tech.png")); // NOI18N
    jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 60));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

private Double parseDoubleValue(Object value) {
    if (value instanceof Double) {
        return (Double) value;
    } else if (value instanceof String) {
        String str = (String) value;
        str = str.replaceAll("[^\\d.]", "");
        return str.isEmpty() ? 0.0 : Double.parseDouble(str);
    }
    return 0.0;
}


    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
         
          HomeView home = new HomeView(model);
        home.setVisible(true);
        home.pack();
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void fNameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameTbActionPerformed
        
    }//GEN-LAST:event_fNameTbActionPerformed

    private void pNumberTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pNumberTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pNumberTbActionPerformed

    private void eMailTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eMailTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eMailTbActionPerformed

    private void clrBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clrBtnMouseEntered
                                          

 
    }//GEN-LAST:event_clrBtnMouseEntered


  
    private void sortEntriesDescending() {
    try {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(sorter);

        // Set custom comparator for the "Donation Amount" column
        sorter.setComparator(jTable1.getColumn("Donation Amount").getModelIndex(), (o1, o2) -> {
            Double value1 = parseDoubleValue(o1);
            Double value2 = parseDoubleValue(o2);
            return value1.compareTo(value2);
        });

        // Sort the table in descending order based on the "Donation Amount" column
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));  // Assuming column 0 is the "Donation Amount" column
        sorter.setSortKeys(sortKeys);
    } catch (IllegalArgumentException e) {
        System.err.println("Invalid SortKey: " + e.getMessage());
    }
}


    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
  
       
  
                addEntry(); 
        
        String filePath = "C:\\Users\\andre\\OneDrive\\Desktop\\HandogFinal\\Documents\\NetBeansProjects\\Handog\\src\\Data"; // Specify the file path here
        saveDataToFile(filePath);
    

    
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void clrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrBtnActionPerformed
if (!fNameTb.getText().isEmpty() || !lNameTb.getText().isEmpty() ||
        !pNumberTb.getText().isEmpty() || !eMailTb.getText().isEmpty() ||
        !hAddressTextArea.getText().isEmpty() || !donationAmtTB.getText().isEmpty()) {
    int confirm = JOptionPane.showConfirmDialog(TableView.this,
            "Are you sure you want to clear the fields?", "Clear Fields",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    if (confirm == JOptionPane.YES_OPTION) {
        // Clear the fields and set placeholder text
        fNameTb.setForeground(new java.awt.Color(150, 150, 150));
        fNameTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        fNameTb.setText("First Name");

        lNameTb.setForeground(new java.awt.Color(150, 150, 150));
        lNameTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        lNameTb.setText("Last Name");

        pNumberTb.setForeground(new java.awt.Color(150, 150, 150));
        pNumberTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        pNumberTb.setText("Phone Number");

        eMailTb.setForeground(new java.awt.Color(150, 150, 150));
        eMailTb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        eMailTb.setText("Email");

        hAddressTextArea.setForeground(new java.awt.Color(150, 150, 150));
        hAddressTextArea.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        hAddressTextArea.setText("Address");

        donationAmtTB.setForeground(new java.awt.Color(150, 150, 150));
        donationAmtTB.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        donationAmtTB.setText("Donation Amount");
    }
}

      

    }//GEN-LAST:event_clrBtnActionPerformed

    private void donationAmtTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donationAmtTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_donationAmtTBActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalActionPerformed
    
    

    
   

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
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Total;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clrBtn;
    private javax.swing.JTextField donationAmtTB;
    private javax.swing.JComboBox<String> donationTypeCb;
    private javax.swing.JTextField eMailTb;
    private javax.swing.JTextField fNameTb;
    private java.awt.TextArea hAddressTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lNameTb;
    private javax.swing.JTextField pNumberTb;
    // End of variables declaration//GEN-END:variables

    private static class pesoFormat {


        private static String format(double amount) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public pesoFormat() {
        }
    }
}
