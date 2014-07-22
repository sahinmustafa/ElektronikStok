/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.extra;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author haye
 */
public class TableRenderer extends DefaultTableCellRenderer{
    
     @Override
     public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
     {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if( row%2 == 0)
            {
                cell.setBackground( Color.white );
                // You can also customize the Font and Foreground this way
                // cell.setForeground();
                // cell.setFont();
            }
            else
            {
                cell.setBackground( Color.lightGray );
            }
            
            
            if( Integer.parseInt(table.getModel().getValueAt(row,3).toString()) <= Integer.parseInt(table.getModel().getValueAt(row,6).toString())){
                cell.setBackground( new Color(255, 50, 50) );
            }
            
            
            if(isSelected){
                cell.setBackground( new Color(0, 162, 232) );
            }
        return cell;
    }
}
