/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
import control.ItemController;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import model.Item;

/**
 *
 * @author Kyle
 */
public class ToDoItem extends JPanel {

    private JLabel timeLabel, todoLabel;

    private JButton btnDelete, btnComplete;

    private Item item;

    private ItemController control;
    
    private String[] days = {" Sunday"," Monday"," Tuesday"," Wednesday"," Thursday"," Friday"," Saturday"};

    public ToDoItem() {
        timeLabel = new JLabel();
        todoLabel = new JLabel();

        btnDelete = new JButton();
        btnComplete = new JButton();

        btnDelete.setFocusable(false);
        btnDelete.setToolTipText("Delete This Task");
        btnComplete.setFocusable(false);
        btnComplete.setToolTipText("Complete This Task");

        //timeLabel.setFont(Font.decode("Arial").deriveFont(18f).deriveFont(Font.BOLD));
        //todoLabel.setFont(Font.decode("Arial").deriveFont(18f).deriveFont(Font.BOLD));
        timeLabel.setPreferredSize(new Dimension(100, 50));
        todoLabel.setPreferredSize(new Dimension(440, 50));
        btnDelete.setPreferredSize(new Dimension(60, 40));
        btnComplete.setPreferredSize(new Dimension(60, 40));

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

        setPreferredSize(new Dimension(705, 60));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    public void setController(ItemController control) {
        this.control = control;
    }

    public ToDoItem(ItemController con, ToDoPanel parent, Item item) {
        this();
        setController(con);
        this.item = item;

        ArrayList<String> timeInterval = new ArrayList<String>();

        int min = 0;
        for (int i = 0; i < 48; i++) {
            String temp;
            String hour;
            if (min / 60 == 1) {
                min = 0;
            }
            if (min != 30) {
                temp = "00";
            } else {
                temp = "30";
            }
            if (i / 2 < 10) {
                hour = "0" + i / 2;
            } else {
                hour = "" + i / 2;
            }
            timeInterval.add(hour + ":" + temp);

            min += 30;
        }
        timeLabel.setText(" " + this.item.getStartTime());
        todoLabel.setText(" " + this.item.getToDo());
        if (this.item.getDone() == 0) {
            todoLabel.setForeground(Color.red);
        } else if (this.item.getDone() == 1) {
            todoLabel.setForeground(Color.green);
            btnComplete.setVisible(false);
        } else {
            for (String time : timeInterval) {
                if (this.item.getStartTime().equals(time)) {
                    timeLabel.setText(" " + this.item.getStartTime() + " - " + timeInterval.get(timeInterval.indexOf(this.item.getStartTime()) + this.item.getInterval()));
                }
            }
            todoLabel.setForeground(Color.blue);
            btnDelete.setVisible(false);
            btnComplete.setVisible(false);
        }

        setBackground(Color.white);

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //cp.events.remove(event);
                control.deleteItem(item);
            }
        });
        btnComplete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                todoLabel.setForeground(Color.green);
                control.deleteItem(item);
                item.setDone(1);
                control.addItem(item);
            }
        });
        this.setBorder(BorderFactory.createTitledBorder(""));
        URL deleteUrl = CalendarProgram.class.getResource("/view/rsrc/Delete.png");
        ImageIcon btnDeleteIcon = new ImageIcon(new ImageIcon(deleteUrl).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        URL doneUrl = CalendarProgram.class.getResource("/view/rsrc/Completed.png");
        ImageIcon btnCompleteIcon = new ImageIcon(new ImageIcon(doneUrl).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        btnDelete.setIcon(btnDeleteIcon);
        btnComplete.setIcon(btnCompleteIcon);
    }

    public ToDoItem(int i, ItemController con, ToDoPanel parent, Item item, boolean odd, int interval) {
        this();

        setController(con);
        if (odd) {
            this.setBorder(BorderFactory.createTitledBorder(" " + i + ":30"));
        } else {
            this.setBorder(BorderFactory.createTitledBorder(" " + i + ":00"));
        }
        if (item != null) {
            this.item = item;
            if (interval == item.getInterval()) {
                todoLabel.setText(" " + item.getToDo());
            } else {
                todoLabel.setText("");
            }

            if (item.getDone() == 0) {
                this.setBackground(Color.red);
            } else if (item.getDone() == 1) {
                this.setBackground(Color.green);
            } else {
                this.setBackground(Color.pink);
            }

        } else {
            todoLabel.setText("");
            setBackground(Color.white);
        }
        btnDelete.setVisible(false);
        btnComplete.setVisible(false);
    }

    public ToDoItem(ItemController con, Item item, int day, boolean first) {
        this();

        setController(con);
        
        this.item = item;
        if(first)
            timeLabel.setText(days[day]);
        if(item != null){
            todoLabel.setText(item.getToDo());
            if (item.getDone() == 0) {
                todoLabel.setForeground(Color.red);
            } else if (item.getDone() == 1) {
                todoLabel.setForeground(Color.green);
            } else {
                todoLabel.setForeground(Color.blue);
            }
        }
        else
            todoLabel.setText("Nothing to do this day");
        if(day%2 == 0)
            this.setBackground(Color.white);
        
        btnDelete.setVisible(false);
        btnComplete.setVisible(false);
    }

    public static final ToDoItem createHeaderToDo() {
        ToDoItem item = new ToDoItem();
        item.timeLabel.setText(" Time");
        item.todoLabel.setText(" ToDoToday");

        item.btnDelete.setVisible(false);
        item.btnComplete.setVisible(false);
        System.out.println("Hello");
        item.setBackground(Color.yellow);
        item.setBorder(BorderFactory.createTitledBorder(""));
        return item;
    }

    public static final ToDoItem createHeaderSched() {
        ToDoItem item = new ToDoItem();
        item.timeLabel.setText(" Time");
        item.todoLabel.setText(" Agenda");

        item.btnDelete.setVisible(false);
        item.btnComplete.setVisible(false);
        System.out.println("Bye");
        item.setBackground(Color.ORANGE);
        item.setBorder(BorderFactory.createTitledBorder(""));
        return item;
    }

    public static final ToDoItem createEmpty() {
        ToDoItem item = new ToDoItem();
        item.timeLabel.setText(" ");
        item.todoLabel.setText(" Nothing to do today");

        item.btnDelete.setVisible(false);
        item.btnComplete.setVisible(false);
        System.out.println("Bye");
        item.setBackground(Color.white);
        item.setBorder(BorderFactory.createTitledBorder(""));
        return item;
    }

    public static final ToDoItem createWeek() {
        ToDoItem item = new ToDoItem();
        item.timeLabel.setText(" Day");
        item.todoLabel.setText(" Agenda");

        item.btnDelete.setVisible(false);
        item.btnComplete.setVisible(false);
        System.out.println("Bye");
        item.setBackground(Color.green);
        return item;
    }
}
