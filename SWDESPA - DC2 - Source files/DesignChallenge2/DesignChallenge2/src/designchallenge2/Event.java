/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package designchallenge2;

import java.util.Calendar;
/**
 *
 * @author Zach Marasigan
 */
public class Event extends Item{
    public Event(String title, Calendar d, int i){
        this.date = d;
        this.title = title;
        this.num_30min_intervals = i;
    }
    
}
