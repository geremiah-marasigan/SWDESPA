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
public class Task extends Item{
    private boolean status;
    
    public Task(CalendarProgram cp, String t, Calendar cd){
        this.owner = cp;
        this.title = t;
        this.date = cd;
        this.num_30min_intervals = 1;
        this.status = false;
    }
    
    public boolean getStatus(){
        return this.status;
    }
    
    public void changeStatus(){
        this.status = !(this.status);
    }
}
