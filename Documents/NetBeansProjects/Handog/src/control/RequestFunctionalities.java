    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package control;

   import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Color;
import java.awt.Component;

public class RequestFunctionalities {
    public static class StatusCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String status = table.getValueAt(row, 8).toString(); // Assuming status is at column index 8

            switch (status) {
                case "Accepted":
                    cellComponent.setForeground(Color.GREEN);
                    break;
                case "Pending":
                    cellComponent.setForeground(Color.ORANGE);
                break;
                case "Declined":
                    cellComponent.setForeground(Color.RED);
                    break;
                case "Screening":
                    cellComponent.setForeground(Color.YELLOW);
                    break;
                default:
                    cellComponent.setForeground(table.getForeground());
            }

            return cellComponent;
        }
    }
}

