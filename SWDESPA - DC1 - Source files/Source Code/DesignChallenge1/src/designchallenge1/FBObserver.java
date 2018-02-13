/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

import facebook.*;
import java.util.*;
/**
 *
 * @author Zach Marasigan
 */
public class FBObserver extends NotificationObserver{
    private FBView fb;
    private ArrayList<Event> addedEvents;
    private Calendar today;
    public FBObserver(FBView f, CalendarProgram cp){
        fb = f;
        owner = cp;
        addedEvents = new ArrayList<>();
        today = Calendar.getInstance();
    }
    
    public void update(){
        for(Event e: owner.events){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(e.getDate());
            boolean isEventToday = calendar.get(Calendar.YEAR) == this.today.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == this.today.get(Calendar.DAY_OF_YEAR);
            if(!addedEvents.contains(e) && isEventToday){
                fb.showNewEvent(e.getEvent(),e.getDate().getMonth() + 1,e.getDate().getDate(),e.getDate().getYear() + 1900,e.getColor());
                addedEvents.add(e);
            }
        }
    }
}