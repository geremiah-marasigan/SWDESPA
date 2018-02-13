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
    public FBObserver(FBView f, CalendarProgram cp){
        fb = f;
        owner = cp;
        addedEvents = new ArrayList<>();
    }
    
    public void update(){
        for(Event e: owner.events){
            if(!addedEvents.contains(e)){
                fb.showNewEvent(e.getEvent(),e.getDate().getMonth(),e.getDate().getDate(),e.getDate().getYear(),e.getColor());
                addedEvents.add(e);
            }
        }
    }
}
