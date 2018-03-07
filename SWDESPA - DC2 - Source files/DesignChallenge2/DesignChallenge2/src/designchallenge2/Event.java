/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package designchallenge2;
import java.awt.Color;
import java.util.Date;
/**
 *
 * @author Zach Marasigan
 */
public class Event {
    private Color eventColor;
    private String eventTitle;
    private Date eventDate;
    private boolean eventHoliday;
    public Event(String title, Date d, Color c, int h){
        this.eventDate = d;
        this.eventColor = c;
        this.eventTitle = title;
        if(h == 1)
            this.eventHoliday = true;
        else
            this.eventHoliday = false;
    }
    public Date getDate(){
     return eventDate;   
    }
    public Color getColor(){
        return eventColor;
    }
    public String getEvent(){
        return eventTitle;
    }
    public boolean getHoliday(){
        return eventHoliday;
    }
    public String toString(){
        return ("Date : " + eventDate + " Color : " + eventColor + " eventTitle : " + eventTitle);
    }
}
