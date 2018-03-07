/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zach Marasigan
 */
public class NewEventWindow extends JFrame{
    private CalendarProgram owner;
    private JButton btnCancel, btnAddEvent;
    private JLabel lblTitle, lblColor;
    private JTextField txtTitle;
    private JComboBox cmbColor;
    private JCheckBox boxHoliday;
    private String title;
    private Color color;
    private Date event;
    
    public NewEventWindow(final int month , final int year, final int day, final CalendarProgram owner){
        //this.owner = cp;
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        this.owner = owner;
        this.boxHoliday = new JCheckBox("Holiday");
        this.lblTitle = new JLabel("Title: ");
        this.lblColor = new JLabel("Color: ");
        this.lblTitle.setPreferredSize(new Dimension(80, 20));
        this.lblColor.setPreferredSize(new Dimension(80, 20));
        this.txtTitle = new JTextField();
        this.txtTitle.setPreferredSize(new Dimension(270, 20));
        
        String[] colors = {"red", "blue", "green"};
        this.cmbColor = new JComboBox(colors);
        this.cmbColor.setPreferredSize(new Dimension(100,20));
        this.btnCancel = new JButton();
        this.btnCancel.setText("Cancel");
        this.btnCancel.setPreferredSize(new Dimension(86, 22));
        this.btnCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        this.btnAddEvent = new JButton();
        this.btnAddEvent.setText("Add");
        this.btnAddEvent.setPreferredSize(new Dimension(85, 22));
        this.btnAddEvent.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    ColorDecoder cd = new ColorDecoder();
                    String dateString = month+"/"+day+"/"+year;
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    event = df.parse(dateString);
                    title = txtTitle.getText();
                    color = cd.decode((String) cmbColor.getSelectedItem());
                    if (boxHoliday.isSelected())
                        owner.addEvent(title,event,color,1);
                    else
                        owner.addEvent(title,event,color,0);
                    owner.refreshCalendar(month-1, year);
                    NewEventWindow.this.setVisible(false);
                } catch (ParseException ex) {
                    
                }
            }
        });
        add(this.lblTitle);
        add(this.txtTitle);
        add(this.boxHoliday);
        add(this.lblColor);
        add(this.cmbColor);
        add(this.btnCancel);
        add(this.btnAddEvent); 
    }
}