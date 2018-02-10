/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Arturo III
 */
public class TableRenderer extends DefaultTableCellRenderer
{
    private ArrayList<Event> events;
    int year;
    String month;
    public TableRenderer(ArrayList<Event> events, int year, int month){
        this.events = events;
        this.year = year;
        switch(month+1){
            case 1: this.month = "Jan"; break;
            case 2: this.month = "Feb"; break;
            case 3: this.month = "Mar"; break;
            case 4: this.month = "Apr"; break;
            case 5: this.month = "May"; break;
            case 6: this.month = "Jun"; break;
            case 7: this.month = "Jul"; break;
            case 8: this.month = "Aug"; break;
            case 9: this.month = "Sep"; break;
            case 10: this.month = "Oct"; break;
            case 11: this.month = "Nov"; break;
            case 12: this.month = "Dec"; break;
        }
    }
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6)
                    setBackground(new Color(220,220,255));
            else
                    setBackground(Color.WHITE);
            try{
                for(Event event: this.events){
                    String s = event.toString();
                    String[] sa = s.split(" ");
                    if(Integer.parseInt(sa[4]) == Integer.parseInt(value.toString()) && month.equals(sa[3]) && year == Integer.parseInt(sa[7])){
                        System.out.println(sa[7]);
                        setBackground(event.getColor());
                    }
                }
            }
            catch (Exception e){

            }
            setBorder(null);
            setForeground(Color.black);
            return this;  
    }
}
