/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

import java.io.*;
import java.util.*;
import java.text.*;
/**
 *
 * @author Zach Marasigan
 */
public class CSVParser extends DataParser{
    public CSVParser(CalendarProgram c){
        super.owner = c;
    
    }
    
    public void readData(String filename) {
            System.out.println("Reading data from csv file");

            try{
                    BufferedReader reader = new BufferedReader(new FileReader(filename));
                    String line;
                    String[] temp;
                    while ((line = reader.readLine()) != null){
                            System.out.println(line);
                            temp = line.split(", ");
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
        String stringColor;
        try{
        for(int event = 0; event< events.size(); event++){ /*** CSV format is Date, Title, Color ***/
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date date = df.parse((String)events.get(event).get(0));
            
            super.owner.addEvent((String)events.get(event).get(1), date, cd.decode((String)events.get(event).get(2)));
        }
        } catch (Exception e){
            System.out.println("Error in CSV processing");
        }
    }
}
