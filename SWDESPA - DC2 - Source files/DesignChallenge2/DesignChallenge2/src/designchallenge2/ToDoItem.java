/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kyle
 */
public class ToDoItem extends JPanel{
    
    private JLabel timeLabel, todoLabel;
    
    private JButton btnDelete, btnComplete;
    
    public ToDoItem(){
        timeLabel = new JLabel();
        todoLabel = new JLabel();
        btnDelete = new JButton("D");
        btnComplete = new JButton("C");
        
        //timeLabel.setFont(Font.decode("Arial").deriveFont(18f).deriveFont(Font.BOLD));
        //todoLabel.setFont(Font.decode("Arial").deriveFont(18f).deriveFont(Font.BOLD));
        
        timeLabel.setPreferredSize(new Dimension(100,50));
        todoLabel.setPreferredSize(new Dimension(480,50));
        btnDelete.setPreferredSize(new Dimension(60,40));
        btnComplete.setPreferredSize(new Dimension(60,40));
        
        add(timeLabel);
        add(todoLabel);
        add(btnDelete);
        add(btnComplete);
        /*
        timeLabel.setBounds(panel.getX(),panel.getY(),100,80);
        todoLabel.setBounds(timeLabel.getX()+100,timeLabel.getY(),100,80);
        btnDelete.setBounds(todoLabel.getX()+100,todoLabel.getY(),60,40);
        btnComplete.setBounds(btnDelete.getX()+60,panel.getY(),60,40);
        */
        
        
	setBorder(BorderFactory.createTitledBorder(""));
        setBounds(0,50,705,60);
        //setPreferredSize(new Dimension(705,60));
        setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
    }
    
    public ToDoItem(String lol, String sad, int prev){
        this();
        setBounds(0,this.getY()+prev,705,60);
        timeLabel.setText(lol);
        todoLabel.setText(sad);
        
        timeLabel.setForeground(Color.red);
        todoLabel.setForeground(Color.red);
        
        setBackground(Color.white);
        
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //cp.events.remove(event);
            }
        });
        btnComplete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                todoLabel.setForeground(Color.green);
                timeLabel.setForeground(Color.green);
                btnComplete.setVisible(false);
            }
        });
    }
    
    public static final ToDoItem createHeader() {
		ToDoItem item = new ToDoItem();
		item.timeLabel.setText("Time");
		item.todoLabel.setText("ToDoToday");
		
		
		item.btnDelete.setVisible(false);
		item.btnComplete.setVisible(false);
		System.out.println("Hello");
                item.setBackground(Color.yellow);
		return item;
	}
}
