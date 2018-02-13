/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

/**
 *
 * @author dlsza
 */
public abstract class NotificationObserver {
    protected CalendarProgram owner;
    public abstract void update();
}
