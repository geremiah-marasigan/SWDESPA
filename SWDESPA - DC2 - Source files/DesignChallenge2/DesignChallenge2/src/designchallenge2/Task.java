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
public class Task extends Event{
    private boolean status;
    
    public Task(String title, Calendar d){
        super(title, d, 1);
        this.status = false;
    }
    
    public boolean getStatus(){
        return this.status;
    }
    
    public void changeStatus(){
        this.status = !(this.status);
    }
}
