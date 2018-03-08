/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Arturo III
 */
public class TableRenderer extends JTextPane implements TableCellRenderer
{
       
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {
            StyledDocument doc = this.getStyledDocument();
            Style style = this.addStyle("I'm a Style", null);
            StyleConstants.setForeground(style, Color.black);
            
            if (column == 0 || column == 6)
                    setBackground(new Color(220,220,255));
            else
                    setBackground(Color.WHITE);
            try {
                doc.remove(0, doc.getLength());
            } catch (BadLocationException ex) {
                
            }    
            
            if (value != null){
                try {
                    doc.insertString(doc.getLength(), value.toString().split(" ")[0], style);
                /*
                for(Event event: this.events)
                    if(value.toString().contains(event.getEvent())){
                        StyleConstants.setForeground(style, event.getColor());
                        doc.insertString(doc.getLength(), " " + event.getEvent() , style);
                    }
                */
                }
                
                catch (Exception e){
                    
                }
            }  
            else
                this.setText("");
            if (selected)
                setBackground(Color.GRAY);
            setBorder(null);
            
            return this;  
    }
}
