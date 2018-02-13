/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;
import facebook.*;
import sms.*;
/**
 *
 * @author Arturo III
 */
public class DesignChallenge1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CalendarProgram cp = new CalendarProgram();
        FBView fb = new FBView();
        SMSView sms = new SMSView();
        FBObserver obvFb = new FBObserver(fb, cp);
        SMSObserver obvSMS = new SMSObserver(sms, cp);
        cp.attach(obvFb);
        cp.attach(obvSMS);
    }
}
