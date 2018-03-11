/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
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
        view.getToDoPanel().setItems(service.getAllByDay(view.getMonth(), view.getDay(), view.getYear()));
        view.revalidate();
        view.repaint();
    }

    public void addItem(Item item) {
        service.addItem(item);
        view.getToDoPanel().setItems(service.getAllByDay(view.getMonth(), view.getDay(), view.getYear()));
        view.revalidate();
        view.repaint();
    }

    public void editItem(Item item) {
        service.updateItem(item);
        view.getToDoPanel().setItems(service.getAllByDay(view.getMonth(), view.getDay(), view.getYear()));
        view.revalidate();
        view.repaint();
    }

    public void SchedView() {
        view.getToDoPanel().setItemsSched(service.getAllByDay(view.getMonth(), view.getDay(), view.getYear()));
        System.out.println("Hello Lord");
        view.revalidate();
        view.repaint();
    }

    public void filterToDo(int month, int day, int year) {
        view.getToDoPanel().setItems(service.getAllByDay(month, day, year));
        view.revalidate();
        view.repaint();
    }

    public void start() {
        view.initialize(this);
        view.getToDoPanel().setItems(service.getAllByDay(view.getMonth(), view.getDay(), view.getYear()));
        view.revalidate();
        view.repaint();
    }

    public void removeCompleted() {
        List<Item> temp = service.getAllByDay(view.getMonth(), view.getDay(), view.getYear());
        for (Item item : temp) {
            if (item.getDone() == 1) {
                service.deleteItem(item.getToDo());
            }
        }
        view.getToDoPanel().setItems(service.getAllByDay(view.getMonth(), view.getDay(), view.getYear()));
        view.revalidate();
        view.repaint();
    }

    public boolean checkMatch(int month, int day, int year) {
        if (month == view.getMonth() && day == view.getDay() && year == view.getYear()) {
            return true;
        } else {
            return false;
        }
    }
    public void WeekView(ArrayList<Integer> days){
        List<Item> temp = new ArrayList<>();
        int count = 0;
        int[] firstWeek = {1,2,3,4,5,6,7};
        int[] lastWeek = new int[7];        
        if (view.getMonth() == 2){
            lastWeek[0] = 22;
            lastWeek[1] = 23;
            lastWeek[2] = 24;
            lastWeek[3] = 25;
            lastWeek[4] = 26;
            lastWeek[5] = 27;
            lastWeek[6] = 28;
        }
        else if(view.getMonth() == 4 || view.getMonth() == 6 || view.getMonth() == 9 || view.getMonth() == 11){
            lastWeek[0] = 25;
            lastWeek[1] = 26;
            lastWeek[2] = 27;
            lastWeek[3] = 28;
            lastWeek[4] = 29;
            lastWeek[5] = 30;
            lastWeek[6] = 31;
        }
        else{
            lastWeek[0] = 24;
            lastWeek[1] = 25;
            lastWeek[2] = 26;
            lastWeek[3] = 27;
            lastWeek[4] = 28;
            lastWeek[5] = 29;
            lastWeek[6] = 30;
        }
                
        for (int i: days)
            if(i < 1)
                count++;
        for (int i = 0; i < days.size(); i++){
            System.out.println(days.get(i));
            //if(days.contains(31) || days.contains(30) || (days.contains(28) && view.getMonth() == 2) && days.contains(0))
            //   temp = service.getAllByDay(view.getMonth()+1, days.get(i), view.getYear());
            temp = service.getAllByDay(view.getMonth(), days.get(i), view.getYear());
            
            view.getToDoPanel().setItemsWeek(temp, i);
            view.revalidate();
            view.repaint();
        }
        
    }
    public List<Item> getAllItems() {
        return service.getAll();
    }
    
    public List<Item> getAllToDoToday() {
        return service.getAllByDayToDo(view.getMonth(), view.getDay(), view.getYear());
    }
}
