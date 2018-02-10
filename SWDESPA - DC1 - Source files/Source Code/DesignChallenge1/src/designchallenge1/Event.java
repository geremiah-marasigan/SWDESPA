/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package designchallenge1;
import java.awt.Color;
import java.util.Date;
/**
 *
 * @author Zach Marasigan
 */
public class Event {
    Color eventColor;
    String eventTitle;
    Date eventDate;
    public Event(String title, Date d, Color c){
        this.eventDate = d;
        this.eventColor = c;
        this.eventTitle = title;
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
    public String toString(){
        return ("Date : " + eventDate + " Color : " + eventColor + " eventTitle : " + eventTitle);
    }
}
