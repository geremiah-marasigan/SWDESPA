/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kyle
 */
public class Item {

    private String startTime;
    private int interval;
    private int month;
    private int day;
    private int year;
    private String todo;
    private int done;

    public static final String TABLE = "items";
    public static final String COL_ST = "StartTime";
    public static final String COL_IN = "Interval";
    public static final String COL_MN = "Month";
    public static final String COL_DY = "Day";
    public static final String COL_YR = "Year";
    public static final String COL_TD = "ToDo";
    public static final String COL_DN = "Done";

    public String getStartTime() {
        return this.startTime;
    }

    public int getInterval() {
        return this.interval;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getYear() {
        return this.year;
    }

    public String getToDo() {
        return this.todo;
    }

    public int getDone() {
        return this.done;
    }

    public void setStartTime(String ST) {
        this.startTime = ST;
    }

    public void setInterval(int IN) {
        this.interval = IN;
    }

    public void setMonth(int MN) {
        this.month = MN;
    }

    public void setDay(int D) {
        this.day = D;
    }

    public void setYear(int Y) {
        this.year = Y;
    }

    public void setToDo(String TD) {
        this.todo = TD;
    }

    public void setDone(int D) {
        this.done = D;
    }

    @Override
    public String toString() {
        return "items [StartTime=" + startTime + ", Interval=" + interval + ", Month=" + month + ", Day=" + day
                + ", Year=" + year + ", ToDo=" + todo + ", Done=" + done
                + "]";
    }
}
