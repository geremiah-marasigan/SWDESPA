/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.*;
import control.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.lang.*;
/**
 *
 * @author Zach Marasigan
 */
public class NewItemWindow extends JFrame{
    private final String[] timeInterval;
    private final String[] months;
    private final String[] days31;
    private final String[] days30;
    private final String[] days29;
    private final String[] days28;
    private int interval;
    
    private JLabel lblTimeStart, lblTimeEnd, lblMonth, lblDay, lblYear, lblTitle;
    private JComboBox cmbDayStart, cmbDayEnd, cmbMonthStart, cmbMonthEnd, cmbTimeStart, cmbTimeEnd;
    private JButton btnAddItem;
    private JCheckBox chkTask;
    private JTextField txtTitle;
    
    public NewItemWindow(ItemController iCtrl, int yearToday){
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
        this.lblDay = new JLabel("Day: ");
        this.lblMonth = new JLabel("Month: ");
        this.lblYear = new JLabel("Year: ");
        this.lblTimeStart = new JLabel("Time Start: ");
        this.lblTimeEnd = new JLabel("Time End: ");
        this.lblTitle = new JLabel("Name: ");
        this.txtTitle = new JTextField();
        this.txtTitle.setPreferredSize(new Dimension(300, 20));
        
        this.days31 = new String[31];
        for(int i = 0; i<31; i++)
            this.days31[i] = "" + (i+1);
        
        this.days30 = new String[30];
        for(int i = 0; i<30; i++)
            this.days30[i] = "" + (i+1);
        
        this.days28 = new String[28];
        for(int i = 0; i<28; i++)
            this.days28[i] = "" + (i+1);
        
        this.days29 = new String[29];
        for(int i = 0; i<29; i++)
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
        this.cmbMonthStart = new JComboBox(months);
        
        ArrayList<String> month31 = new ArrayList<>(Arrays.asList("January", "March", "May", "July", "August", "October", "December"));
        ArrayList<String> month30 = new ArrayList<>(Arrays.asList("April", "June", "September", "November"));
        
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
        this.chkTask = new JCheckBox("Task");
        
        chkTask.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==chkTask){
                    cmbTimeEnd.setEnabled(!chkTask.isSelected());
                    interval = 1;
                }
            }
        });
        
        cmbDayStart = new JComboBox(days31);
        
        DefaultComboBoxModel model30 = new DefaultComboBoxModel(days30);
        DefaultComboBoxModel model31 = new DefaultComboBoxModel(days31);
        DefaultComboBoxModel model28 = new DefaultComboBoxModel(days28);
        

        cmbMonthStart.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if (month30.contains(cmbMonthStart.getSelectedItem())){
                    cmbDayStart.setModel(model30);    
                } else if (month31.contains(cmbMonthStart.getSelectedItem())){
                    cmbDayStart.setModel(model31);    
                } else {
                    cmbDayStart.setModel(model28);
                }
            }
        });
        
        btnAddItem = new JButton();
        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean error = false;
                
                if(!chkTask.isSelected()){
                    if(cmbTimeEnd.getSelectedIndex() - cmbTimeStart.getSelectedIndex() < 1){
                        error = true;
                        System.out.println("Error: " + error);
                    } else{
                        interval = cmbTimeEnd.getSelectedIndex() - cmbTimeStart.getSelectedIndex();
                        System.out.println("Interval: " + interval + " Error: " + error);
                    }
                } else {
                    interval = 1;
                }
                
                String timeStart = (String)cmbTimeStart.getSelectedItem();
                if(timeStart.split(":")[0].length() < 2)
                    timeStart = "0" + timeStart;
                String whatMonth = Integer.toString(cmbMonthStart.getSelectedIndex()+1);
                System.out.println(whatMonth);
                if(whatMonth.length() < 2)
                    whatMonth = "0" + whatMonth;
                System.out.println(whatMonth);
                String whatDay = (String)cmbDayStart.getSelectedItem();
                if(whatDay.length() < 2)
                    whatDay = "0" + whatDay;
                
                String dateString = whatMonth+"/"+whatDay+"/"+ yearToday + " " + (timeStart.split(":"))[0] + ":" + (timeStart.split(":"))[1];
                System.out.println("TimeStart: " + timeStart + " Date: " + dateString);
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
                Calendar cal = Calendar.getInstance();
                try{
                    cal.setTime(df.parse(dateString));
                } catch(ParseException ex){
                    System.out.println(ex.getMessage());
                }
                
                /*Check if conflict, set error to true*/
                List<Item> items = iCtrl.getAllItems();
                Calendar iCalendar = Calendar.getInstance();
                Calendar calEnd = cal;
                calEnd.add(Calendar.MINUTE, 30*interval);
                for(Item i: items){
                    String temp;
                    temp = String.format("%02d",i.getMonth()) + "/" + String.format("%02d",i.getDay()) + "/" + String.format("%04d",i.getYear()) + " " + i.getStartTime();
                    try{
                        iCalendar.setTime(df.parse(temp));
                    } catch(ParseException ex){
                        System.out.println(ex.getMessage());
                    }
                    Calendar iCalendarEnd = iCalendar;
                    iCalendarEnd.add(Calendar.MINUTE, 30*i.getInterval());
                    if(cal.compareTo(iCalendar) > 0 && cal.compareTo(iCalendarEnd) < 0 || /*Start is after iStart and before iEnd*/
                       iCalendar.compareTo(cal) > 0 && iCalendar.compareTo(calEnd) < 0)  /*iStart is after Start and before End*/
                        error = true;
                }
                
                /*Check for conflicting names*/
                for(Item i: items)
                    if(txtTitle.getText().equals(i.getToDo()))
                        error = true;
                
                
                if(error){
                    JOptionPane.showMessageDialog(NewItemWindow.this, "Error Found. Please fix your input");
                } else {
                    System.out.println("Date: " + cal.toString() + " Intervals: " + interval);
                    Item newItem = new Item();
                    if(chkTask.isSelected()){
                        newItem.setDone(0);
                        newItem.setInterval(1);
                    } else {
                        newItem.setDone(-1);
                        newItem.setInterval(interval); 
                    }
                    System.out.println(cal.get(Calendar.MONTH));
                    newItem.setDay(cal.get(Calendar.DAY_OF_MONTH));
                    newItem.setMonth(cal.get(Calendar.MONTH)+1);
                    newItem.setYear(yearToday);
                    newItem.setStartTime(timeStart);
                    newItem.setToDo(txtTitle.getText());
                    
                    iCtrl.addItem(newItem);
                    NewItemWindow.this.dispose();
                }
            }
        });
        
        add(lblTitle);
        add(txtTitle);
        add(lblMonth);
        add(cmbMonthStart);
        add(lblDay);
        add(cmbDayStart);
        add(lblTimeStart);
        add(cmbTimeStart);
        add(lblTimeEnd);
        add(cmbTimeEnd);
        add(chkTask);
        add(btnAddItem);
    }
}