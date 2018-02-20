/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

import java.util.*;
import java.io.*;
/**
 *
 * @author Zach Marasigan
 */
public abstract class DataParser {
    protected ArrayList<List> events = new ArrayList<>();
    protected String filename;
    protected CalendarProgram owner;
    
    
    public abstract void readData(String filename);
    public abstract void processData();
    public void writeData(){
        StringBuilder sb = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        ColorDecoder cd = new ColorDecoder();
        for(Event e: owner.events){
            calendar.setTime(e.getDate());
            sb.append(calendar.get(Calendar.MONTH) + 1);
            sb.append("/");
            sb.append(calendar.get(Calendar.DAY_OF_MONTH));
            sb.append("/");
            sb.append(calendar.get(Calendar.YEAR));
            sb.append(", ");
            
            sb.append(e.getEvent());
            sb.append(", ");
            
            sb.append(cd.getStringGivenColor(e.getColor()));
            sb.append(", ");
            
            if(e.getHoliday())
                sb.append("1");
            else
                sb.append("0");
            
            sb.append(System.getProperty("line.separator"));
        }
        try{
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("output.csv", true))); 
            System.out.print(sb.toString());
            writer.write(sb.toString());
            writer.flush();
            writer.close();
	} catch (IOException e){
			
	}
    }
}
