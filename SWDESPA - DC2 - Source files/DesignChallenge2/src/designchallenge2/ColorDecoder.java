/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

import java.awt.Color;
import java.util.*;
/**
 *
 * @author Zach Marasigan
 */
public class ColorDecoder {
    Map<String, Color>  colors;
    public ColorDecoder(){
        colors = new HashMap<>();
        colors.put("red", Color.red);
        colors.put("green", Color.green);
        colors.put("blue", Color.blue);
    }
    
    public Color decode(String s){
        return colors.get(s);
    }
    
    public String getStringGivenColor(Color c){
        for(Map.Entry<String, Color> entry: colors.entrySet())
            if(entry.getValue().equals(c))
                return entry.getKey();
        return "";
    }
}
