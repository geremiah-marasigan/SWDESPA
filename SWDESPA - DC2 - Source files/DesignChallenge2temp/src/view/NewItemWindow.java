/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ItemController;
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
public class NewItemWindow extends JFrame{
    private ItemController itemCtrl;
    private final String[] timeInterval;
    private final String[] months;
    private final String[] days31;
    private final String[] days30;
    private final String[] days29;
    private final String[] days28;
    private boolean error;
    
    private JLabel lblTimeStart, lblTimeEnd, lblMonth, lblDay, lblYear;
    private JComboBox cmbDayStart, cmbDayEnd, cmbMonthStart, cmbMonthEnd, cmbTimeStart, cmbTimeEnd;
    
    public NewItemWindow(ItemController iCtrl, int yearToday){
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        this.lblDay = new JLabel("Day: ");
        this.lblMonth = new JLabel("Month: ");
        this.lblYear = new JLabel("Year: ");
        this.lblTimeStart = new JLabel("Time Start: ");
        this.lblTimeEnd = new JLabel("Time End: ");
        
        this.days31 = new String[31];
        for(int i = 0; i<31; i++)
            this.days31[i] = "" + (i+1);
        
        
        this.days30 = new String[30];
        for(int i = 0; i<30; i++)
            this.days30[i] = "" + (i+1);
        
        this.days28 = new String[28];
        for(int i = 0; i<30; i++)
            this.days28[i] = "" + (i+1);
        
        this.days29 = new String[29];
        for(int i = 0; i<30; i++)
            this.days29[i] = "" + (i+1);
        
        this.months = new String[12];
        this.months[0] = "January";
        this.months[1] = "February";
        this.months[2] = "March";
        this.months[3] = "April";
        this.months[4] = "May";
        this.months[5] = "June";
        this.months[6] = "July";
        this.months[7] = "August";
        this.months[8] = "September";
        this.months[9] = "October";
        this.months[10] = "November";
        this.months[11] = "December";

        
        String temp;
        this.timeInterval = new String[48];
        int min = 0;
        for(int i = 0; i<48; i++){
            if(min/60 == 1)
                min = 0;
            if(min != 30)
                temp = "00";
            else
                temp = "30";
            timeInterval[i] = (i/2 + ":" + temp);

            min += 30;
	}
        this.cmbTimeStart = new JComboBox(this.timeInterval);
        this.cmbTimeEnd = new JComboBox(this.timeInterval);
        
        int interval;
        interval = 
        
    }
}
