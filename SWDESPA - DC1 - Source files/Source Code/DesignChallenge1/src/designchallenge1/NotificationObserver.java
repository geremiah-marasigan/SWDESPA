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
public abstract class NotificationObserver {
    protected CalendarProgram owner;
    protected ArrayList<Event> addedEvents;
    protected Calendar today;
    public abstract void update();
}
