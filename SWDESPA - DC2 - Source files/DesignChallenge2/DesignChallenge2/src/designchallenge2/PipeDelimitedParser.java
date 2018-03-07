/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge2;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Zach Marasigan
 */
public class PipeDelimitedParser extends DataParser{
    public PipeDelimitedParser(CalendarProgram c){
        super.owner = c;
    }
    
    public void readData(String filename) {
        System.out.println("Reading data from psv file");

        try{
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String line;
                String[] temp;
                while ((line = reader.readLine()) != null){
                        temp = line.split("\\| ");
                        super.events.add(Arrays.asList(temp));
                } 

                reader.close();
        }
        catch (IOException e){
                System.err.format("Exception occurred trying to read '%s'.", filename);
                e.printStackTrace();
        }
    }
    
    public void processData(){
        ColorDecoder cd = new ColorDecoder();
        try{
        for(int event = 0; event< events.size(); event++){ /*** PipeDelimited format is Title, Date, Color ***/
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date date = df.parse((String)events.get(event).get(1));
            
            System.out.println((String)events.get(event).get(2));
            
            if (events.get(event).size() == 3)
                super.owner.addEvent((String)events.get(event).get(0), date, cd.decode((String)events.get(event).get(2)),0);
            else
                if(events.get(event).get(3).toString().equals("0"))
                    super.owner.addEvent((String)events.get(event).get(1), date, cd.decode((String)events.get(event).get(2)),0);
                else
                    super.owner.addEvent((String)events.get(event).get(1), date, cd.decode((String)events.get(event).get(2)),1);
        }
        } catch (Exception e){
            System.out.println("Error in PipeDelimited processing");
        }
    }

}
