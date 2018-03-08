/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import view.CalendarProgram;
import model.Driver;
import model.ItemsServices;
/**
 *
 * @author Kyle
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        CalendarProgram cp = new CalendarProgram();
        ItemsServices itemS = new ItemsServices(new Driver());
        ItemController itemControl = new ItemController(itemS,cp);
        itemControl.start();
        
    }
}
