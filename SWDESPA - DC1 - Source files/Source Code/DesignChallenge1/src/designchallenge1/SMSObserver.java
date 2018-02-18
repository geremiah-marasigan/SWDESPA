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
 * @author Zach Marasigan
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
        today = Calendar.getInstance();
        for(Event e: owner.events){
            int day, month;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(e.getDate());
            boolean isEventToday = calendar.get(Calendar.YEAR) == this.today.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == this.today.get(Calendar.DAY_OF_YEAR);
            if((e.getHoliday())){
                isEventToday = calendar.get(Calendar.DAY_OF_YEAR) == this.today.get(Calendar.DAY_OF_YEAR);
                day = calendar.get(Calendar.DAY_OF_YEAR);
                month = calendar.get(Calendar.MONTH);
                calendar.set(today.get(Calendar.YEAR), month, day);
            }
            if(!addedEvents.contains(e) && isEventToday){
                SMS sms = new SMS(e.getEvent(), calendar, e.getColor());
                smsV.sendSMS(sms);
                addedEvents.add(e);
            }
        }
    }
}
