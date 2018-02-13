/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Arturo III
 */
public class TableRenderer extends JTextPane implements TableCellRenderer
{
    private ArrayList<Event> events;
    public TableRenderer(ArrayList<Event> events){
        this.events = events;
    }   
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {
            
            //super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if ( value != null)
                this.setText(String.valueOf(value));
            else
                this.setText("");
            if (column == 0 || column == 6)
                    setBackground(new Color(220,220,255));
            else
                    setBackground(Color.WHITE);
            
            try{
                for(Event event: this.events)
                    if(value.toString().contains(event.getEvent())){
                        setForeground(event.getColor());
                        break;
                    }
            }
            catch (Exception e){

            }
            if (selected)
                setBackground(Color.GRAY);
            setBorder(null);
            
            return this;  
    }
}
