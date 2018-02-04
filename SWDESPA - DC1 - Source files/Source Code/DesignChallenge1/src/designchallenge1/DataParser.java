/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

import java.util.*;

/**
 *
 * @author Zach Marasigan
 */
public abstract class DataParser {
    protected ArrayList<List> events;
    protected String filename;
    protected CalendarProgram owner;
    
    
    public abstract void readData(String filename);
    public abstract void processData();
    
}
