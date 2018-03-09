/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ItemController;
import java.awt.Dimension;
import java.util.ArrayList;
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
	private List <ToDoItem> items;
	private ToDoItem headerToDo,headerSched,emptyToDo;
	private ItemController controller;
	
	public ToDoPanel (ItemController controller) {
		headerToDo = ToDoItem.createHeaderToDo();
                headerSched = ToDoItem.createHeaderSched();
                emptyToDo = ToDoItem.createEmpty();
		this.controller = controller;
		items = new ArrayList <ToDoItem> ();
		setPreferredSize(new Dimension(650,2940));		
		setLayout(new VerticalFlowLayout(VerticalFlowLayout.LEFT, 
				VerticalFlowLayout.TOP,0,0));
		revalidate();
		repaint();
		
	}
	public void setItemsSched(List <Item> directory){
            remove(emptyToDo);
            remove(headerToDo);
            add(headerSched);
            if(directory != null) {
			for (int i = 0; i < items.size(); i++) {
				remove(items.get(i));
			}
			
			items.clear();
			
			for (int i = 0; i < 48; i++) {
                            Item temp = null;
                            boolean odd = false;
                            if (i%2 != 0)
                                odd = true;
                            for (Item item:directory)
                                if (controller.checkMatch(item.getMonth(), item.getDay(), item.getYear()))
                                    if(Integer.valueOf(item.getStartTime().toString().split(":")[0]) == i/2 && !odd)
                                        temp = item;
                            items.add(new ToDoItem(i/2,controller, this, temp, odd));
                            
                        }
			
			for (int i = 0; i < 48; i++) {
				add(items.get(i));
			}
	}
        }
	public void setItems (List <Item> directory) {
            remove(emptyToDo);
            remove(headerSched);
            add(headerToDo);
			if(directory != null) {
			for (int i = 0; i < items.size(); i++) {
				remove(items.get(i));
			}
			
			items.clear();
			
			for (int i = 0; i < directory.size(); i++) {
				items.add(new ToDoItem(controller, this, directory.get(i)));
			}
			if (items.size()!= 0)
                            for (int i = 0; i < items.size(); i++) {
                                    add(items.get(i));
                            }
                        else
                            add(emptyToDo);
		}
	}
}

