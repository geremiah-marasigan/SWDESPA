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
	private ToDoItem header;
	private ItemController controller;
	
	public ToDoPanel (ItemController controller) {
		header = ToDoItem.createHeader();
		this.controller = controller;
		items = new ArrayList <ToDoItem> ();
		setPreferredSize(new Dimension(980,700));		
		setLayout(new VerticalFlowLayout(VerticalFlowLayout.LEFT, 
				VerticalFlowLayout.TOP,0,0));
		add(header);
		revalidate();
		repaint();
		
	}
	
	public void setItems (List <Item> directory) {
			if(directory != null) {
			for (int i = 0; i < items.size(); i++) {
				remove(items.get(i));
			}
			
			items.clear();
			
			for (int i = 0; i < directory.size(); i++) {
				items.add(new ToDoItem(controller, this, directory.get(i)));
			}
			
			for (int i = 0; i < items.size(); i++) {
				add(items.get(i));
			}
		}
	}
}

