/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ItemController;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import model.Item;
import view.materialdesign.VerticalFlowLayout;

/**
 *
 * @author Kyle
 */
public class ToDoPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private List<ToDoItem> items;
    private ToDoItem headerToDo, headerSched, emptyToDo, headerWeek;
    private ItemController controller;

    public ToDoPanel(ItemController controller) {
        headerToDo = ToDoItem.createHeaderToDo();
        headerSched = ToDoItem.createHeaderSched();
        emptyToDo = ToDoItem.createEmpty();
        headerWeek = ToDoItem.createWeek();
        this.controller = controller;
        items = new ArrayList<ToDoItem>();
        setPreferredSize(new Dimension(650, 2940));
        setLayout(new VerticalFlowLayout(VerticalFlowLayout.LEFT,
                VerticalFlowLayout.TOP, 0, 0));
        revalidate();
        repaint();

    }

    public void setItemsSched(List<Item> directory) {
        removeAll();
        add(headerSched);
        if (directory != null) {
            for (int i = 0; i < items.size(); i++) {
                remove(items.get(i));
            }
            int interval = -1;
            Item temp = null;

            items.clear();
            for (int i = 0; i < 48; i++) {

                if (interval < 1) {
                    temp = null;
                    interval = 0;
                } else {
                    interval--;
                }

                boolean odd = false;
                int x = 0;
                if (i % 2 != 0) {
                    odd = true;
                    x = 1;
                }
                for (Item item : directory) {
                    if (controller.checkMatch(item.getMonth(), item.getDay(), item.getYear())) {
                        if (Integer.valueOf(item.getStartTime().toString().split(":")[0]) == i / 2 && Integer.valueOf(item.getStartTime().toString().split(":")[1]) / 10 % 2 == x) {
                            temp = item;
                            interval = temp.getInterval();
                        }
                    }
                }
                items.add(new ToDoItem(i / 2, controller, this, temp, odd, interval));
            }
            for (int i = 0; i < items.size(); i++) {
                add(items.get(i));
            }
        }
    }

    public void setItems(List<Item> directory) {
        removeAll();
        add(headerToDo);
        SimpleDateFormat tn = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dn = new SimpleDateFormat("MM dd yyyy");
        int curTime = Integer.parseInt(tn.format(new Date()).replace(":",""));
        int curDay = Integer.parseInt(dn.format(new Date()).split(" ")[1]);
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
        if (directory != null) {
            for (int i = 0; i < items.size(); i++) {
                remove(items.get(i));
            }

            items.clear();

            for (int i = 0; i < directory.size(); i++) {
                if(directory.get(i).getDone() == -1 && curTime > Integer.parseInt(timeInterval.get(timeInterval.indexOf(directory.get(i).getStartTime()) + directory.get(i).getInterval()).replace(":", "")) && directory.get(i).getDay() == curDay )
                        ;
                else
                    items.add(new ToDoItem(controller, this, directory.get(i)));
            }
            if (items.size() != 0) {
                for (int i = 0; i < items.size(); i++) {
                    add(items.get(i));
                }
            } else {
                add(emptyToDo);
            }
        }
    }

    public void setItemsWeek(List<Item> directory, int day) {
        if (directory != null) {
            if (day == 0) {
                for (int i = 0; i < items.size(); i++) {
                    remove(items.get(i));
                }
                removeAll();
                add(headerWeek);
                items.clear();
            }
                if(directory.size() == 0)
                    items.add(new ToDoItem(controller,  null, day, true));
                boolean first = true;
                for (int i = 0; i < directory.size(); i++) {
                    if(first)
                        System.out.println("Help");
                    items.add(new ToDoItem(controller,  directory.get(i), day, first));
                    first = false;
                    
                }
                for (int i = 0; i < items.size(); i++) {
                    add(items.get(i));
                }
            
            
        }

    }
}
