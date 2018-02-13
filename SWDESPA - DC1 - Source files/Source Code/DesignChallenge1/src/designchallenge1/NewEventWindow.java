/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author Zach Marasigan
 */
public class NewEventWindow extends JFrame{
    private JMenuBar menu;
    private CalendarProgram owner;
    private JButton btnCancel, btnAddEvent;
    private JLabel lblTitle, lblColor;
    private JTextField txtTitle;
    private JComboBox cmbColor;
    private String title;
    private Color color;
    
    public NewEventWindow(/*CalendarProgram cp*/){
        //this.owner = cp;
        setLayout(new GridLayout(2, 4, 10, 10));
        
        this.lblTitle = new JLabel("Title: ");
        this.lblColor = new JLabel("Color: ");
        
        this.txtTitle = new JTextField();
        
        String[] colors = {"red", "blue", "green"};
        this.cmbColor = new JComboBox(colors);
        
        this.btnCancel = new JButton();
        this.btnCancel.setText("Cancel");
        this.btnCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        add(this.lblTitle);
        add(this.txtTitle);
        add(this.lblColor);
        add(this.cmbColor);
        add(this.btnCancel);
        
        
    }
}