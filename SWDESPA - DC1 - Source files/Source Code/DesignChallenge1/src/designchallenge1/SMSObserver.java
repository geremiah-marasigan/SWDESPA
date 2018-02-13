/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

import sms.*;
import java.util.*;

/**
 *
 * @author dlsza
 */
public class SMSObserver extends NotificationObserver{
    private SMSView smsV;
    private ArrayList<Event> addedEvents;
    private Calendar today;
    public SMSObserver(SMSView s, CalendarProgram cp){
        smsV = s;
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
                SMS sms = new SMS(e.getEvent(), calendar, e.getColor());
                smsV.sendSMS(sms);
                addedEvents.add(e);
            }
        }
    }
}
