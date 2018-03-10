/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Item;
import model.ItemsServices;
import view.CalendarProgram;
import java.util.List;
/**
 *
 * @author Kyle
 */
public class ItemController {
	private ItemsServices service;
	private CalendarProgram view;
	
	public ItemController(ItemsServices service, CalendarProgram frame) {
		this.service = service;
		this.view = frame;
	}
	
	public void deleteItem(Item item) {
		service.deleteItem(item.getToDo());
		view.getToDoPanel().setItems(service.getAllByDay(view.getMonth(),view.getDay(),view.getYear()));
		view.revalidate();
		view.repaint();
	}
	
	public void addItem(Item item) {
		service.addItem(item);
		view.getToDoPanel().setItems(service.getAllByDay(view.getMonth(),view.getDay(),view.getYear()));
		view.revalidate();
		view.repaint();
	}
	
	public void editItem(Item item) {
		service.updateItem(item);
		view.getToDoPanel().setItems(service.getAllByDay(view.getMonth(),view.getDay(),view.getYear()));
		view.revalidate();
		view.repaint();		
	}
	
	public void SchedView () {
		view.getToDoPanel().setItemsSched(service.getAllByDay(view.getMonth(),view.getDay(),view.getYear()));
                System.out.println("Hello Lord");
		view.revalidate();
		view.repaint();
	}
	
        public void filterToDo (int month, int day, int year) {
		view.getToDoPanel().setItems(service.getAllByDay(month,day,year));
		view.revalidate();
		view.repaint();
	}
        
	public void start() {
		view.initialize(this);
		view.getToDoPanel().setItems(service.getAllByDay(view.getMonth(),view.getDay(),view.getYear()));
		view.revalidate();
		view.repaint();
	}
        
        public boolean checkMatch(int month, int day, int year){
            if(month == view.getMonth() && day == view.getDay() && year == view.getYear())
                return true;
            else
                return false;
        }
        
        public List<Item> getAllItems(){
            return service.getAll();
        }
}

