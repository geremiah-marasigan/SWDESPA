/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Arturo III
 */
import control.ItemController;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import view.ToDoItem;

public class CalendarProgram {

    /**
     * ** Day Components ***
     */
    public int yearBound, monthBound, dayBound, yearToday, monthToday, dayToday, todayRow,todayCol;

    /**
     * ** Swing Components ***
     */
    public JLabel monthLabel, yearLabel, eventLabel, timeLabel, todoLabel, countLabel;
    public JButton btnPrev, btnNext, btnAddtoDo, btnTask, btnSched, btnDelete, btnWeek;
    public JComboBox cmbYear;
    public JFrame frmMain;
    public Container pane;
    public JScrollPane scrollCalendarTable, scrollToDo, scrollSched;
    public JPanel calendarPanel;
    public BufferedImage btnDeleteIcon;
    /**
     * ** Calendar Table Components **
     */
    public JTable calendarTable;
    public DefaultTableModel modelCalendarTable;

    /**
     * ** Event Components ***
     */
    public ArrayList<Event> events;

    /**
     * ** Notification Components ***
     */
    public ToDoPanel ToDoPanel;
    public ItemController ItemControl;
    /**
     * ** Export Components ***
     */
    public JButton btnAddItem;

    public void refreshCalendar(int month, int year) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int nod, som, i, j;
        
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (month == 0 && year <= yearBound - 10) {
            btnPrev.setEnabled(false);
        }
        if (month == 11 && year >= yearBound + 100) {
            btnNext.setEnabled(false);
        }
        monthLabel.setText(months[month]+ " " + dayToday + ", " + yearToday);
        monthLabel.setBounds(280 - monthLabel.getPreferredSize().width / 2, 240, 300, 50);

        cmbYear.setSelectedItem("" + year);

        for (i = 0; i < 6; i++) {
            for (j = 0; j < 7; j++) {
                modelCalendarTable.setValueAt(null, i, j);
            }
        }

        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        Date now = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        
        for (i = 1; i <= nod; i++) {
            String eventMonth = "";
            int row = (i + som - 2) / 7;
            int column = (i + som - 2) % 7;
            modelCalendarTable.setValueAt(i, row, column);
            try {
                switch (monthToday + 1) {
                    case 1:
                        eventMonth = "Jan";
                        break;
                    case 2:
                        eventMonth = "Feb";
                        break;
                    case 3:
                        eventMonth = "Mar";
                        break;
                    case 4:
                        eventMonth = "Apr";
                        break;
                    case 5:
                        eventMonth = "May";
                        break;
                    case 6:
                        eventMonth = "Jun";
                        break;
                    case 7:
                        eventMonth = "Jul";
                        break;
                    case 8:
                        eventMonth = "Aug";
                        break;
                    case 9:
                        eventMonth = "Sep";
                        break;
                    case 10:
                        eventMonth = "Oct";
                        break;
                    case 11:
                        eventMonth = "Nov";
                        break;
                    case 12:
                        eventMonth = "Dec";
                        break;
                }
                /*
                            for(Event event: this.events){
                                String s = event.toString();
                                String[] sa = s.split(" ");
                                
                                if(Integer.parseInt(sa[4]) == i && eventMonth.equals(sa[3]) && (yearToday == Integer.parseInt(sa[7]) || event.getHoliday())){   
                                    String value = modelCalendarTable.getValueAt(row,column)+" "+event.getEvent();
                                    System.out.println(value);
                                    modelCalendarTable.setValueAt(value, row, column);
                                }
                                
                            }
                 */
            } catch (Exception e) {

            }
        }

        calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new TableRenderer());
    }

    public void initialize(ItemController con) {
        this.ItemControl = con;
        ToDoPanel = new ToDoPanel(con);
        scrollToDo = new JScrollPane(ToDoPanel);

        pane.add(scrollToDo);
        scrollToDo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollToDo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollToDo.setBounds(calendarPanel.getX() + 350, calendarPanel.getY(), 691, 701);
        ItemControl.filterToDo(monthToday+1,dayToday,yearToday);
    }

    public CalendarProgram() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        //timer = new java.util.Timer(true);
        //timer.scheduleAtFixedRate(timerTask, 1000, 1000); //Update in real-time
        frmMain = new JFrame("Calendar Application");
        frmMain.setSize(1048, 737);
        frmMain.setLocationRelativeTo(null);
        pane = frmMain.getContentPane();
        pane.setLayout(null);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        URL deleteUrl = CalendarProgram.class.getResource("/view/rsrc/DeleteDone.png");
        ImageIcon btnDeleteIcon = new ImageIcon(new ImageIcon(deleteUrl).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        URL todoUrl = CalendarProgram.class.getResource("/view/rsrc/ToDoList.png");
        ImageIcon btnToDoIcon = new ImageIcon(new ImageIcon(todoUrl).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
        URL schedUrl = CalendarProgram.class.getResource("/view/rsrc/Sched.png");
        ImageIcon btnSchedIcon = new ImageIcon(new ImageIcon(schedUrl).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
        URL weekUrl = CalendarProgram.class.getResource("/view/rsrc/Week.png");
        ImageIcon btnWeekIcon = new ImageIcon(new ImageIcon(weekUrl).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
        URL nextUrl = CalendarProgram.class.getResource("/view/rsrc/ArrowRight.png");
        ImageIcon btnNextIcon = new ImageIcon(new ImageIcon(nextUrl).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        URL prevUrl = CalendarProgram.class.getResource("/view/rsrc/ArrowLeft.png");
        ImageIcon btnPrevIcon = new ImageIcon(new ImageIcon(prevUrl).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        URL addUrl = CalendarProgram.class.getResource("/view/rsrc/Add.png");
        ImageIcon btnAddIcon = new ImageIcon(new ImageIcon(addUrl).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));

        monthLabel = new JLabel("January ");
        yearLabel = new JLabel("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton(btnPrevIcon);
        btnNext = new JButton(btnNextIcon);
        btnTask = new JButton(btnToDoIcon);
        btnSched = new JButton(btnSchedIcon);
        btnDelete = new JButton(btnDeleteIcon);
        btnWeek = new JButton(btnWeekIcon);
        btnAddItem = new JButton(btnAddIcon);
        countLabel = new JLabel("Tasks left for today: 0");
        modelCalendarTable = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

        calendarTable = new JTable(modelCalendarTable);
        calendarTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int col = calendarTable.getSelectedColumn();
                int row = calendarTable.getSelectedRow();
                System.out.println("Hello");
                dayToday = Integer.parseInt(modelCalendarTable.getValueAt(row, col).toString());
                todayRow = row;
                ItemControl.filterToDo(monthToday + 1, dayToday, yearToday);
                countLabel.setText("Tasks left for today: " + ItemControl.getAllToDoToday().size());
                
                /*
                        NewEventWindow frmEventAdder = new NewEventWindow(monthToday+1,yearToday,Integer.parseInt(modelCalendarTable.getValueAt(row, col).toString().split(" ")[0]),CalendarProgram.this);
                        frmEventAdder.setResizable(false);
                        frmEventAdder.setVisible(true);
                        frmEventAdder.setSize(450, 100);
                        frmEventAdder.setLocation(frmMain.getX()+frmMain.getWidth(),frmMain.getY());
                        for (int i = 0; i < events.size(); i++)
                            System.out.println(events.get(i).toString());
                 */
                refreshCalendar(monthBound, yearBound);
            }
        });

        scrollCalendarTable = new JScrollPane(calendarTable);
        calendarPanel = new JPanel(null);
        calendarPanel.setBackground(Color.white);
        //calendarPanel.setBorder(BorderFactory.createTitledBorder(""));
        //ToDoPanel.setBorder(BorderFactory.createTitledBorder(""));
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        btnTask.addActionListener(new btnTask_Action());
        btnSched.addActionListener(new btnSched_Action());
        btnDelete.addActionListener(new btnDelete_Action());
        btnWeek.addActionListener(new btnWeek_Action());
        cmbYear.addActionListener(new cmbYear_Action());

        //FONT SETTINGS
        //ICON SETTINGS
        btnDelete.setFocusable(false);
        btnDelete.setToolTipText("Delete all completed ToDos");
        btnTask.setFocusable(false);
        btnTask.setToolTipText("See ToDo List");
        btnSched.setFocusable(false);
        btnSched.setToolTipText("See schedule for today");
        btnWeek.setFocusable(false);
        btnWeek.setToolTipText("See schedule for week");
        btnNext.setFocusable(false);
        btnPrev.setFocusable(false);

        pane.add(calendarPanel);
        calendarPanel.add(monthLabel);
        calendarPanel.add(countLabel);
        calendarPanel.add(yearLabel);
        calendarPanel.add(cmbYear);
        calendarPanel.add(btnPrev);
        calendarPanel.add(btnNext);
        calendarPanel.add(btnTask);
        calendarPanel.add(btnSched);
        calendarPanel.add(btnDelete);
        calendarPanel.add(btnWeek);
        calendarPanel.add(scrollCalendarTable);
        /**
         * ************
         */
        btnAddItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NewItemWindow addItem = new NewItemWindow(ItemControl, yearToday);
                addItem.setResizable(false);
                addItem.setVisible(true);
                addItem.setSize(380, 120);
                addItem.setLocation(frmMain.getX() + frmMain.getWidth(), frmMain.getY());
            }
        });

        calendarPanel.add(btnAddItem);
        btnAddItem.setBounds(19, 600, 50, 50);

        /**
         * ************
         */
        calendarPanel.setBounds(0, 0, 350, 750);
        monthLabel.setBounds(320 - monthLabel.getPreferredSize().width / 2, 200, 200, 50);
        yearLabel.setBounds(btnAddItem.getX() + 162, 600, 80, 40);
        cmbYear.setBounds(yearLabel.getX() + 80, 600, 60, 40);
        btnPrev.setBounds(20, 240, 50, 50);
        btnNext.setBounds(70, 240, 50, 50);
        btnTask.setBounds(20, 25, 100, 130);
        btnSched.setBounds(220, 25, 100, 130);
        btnDelete.setBounds(290, 650, 30, 30);
        btnWeek.setBounds(120,30,100,130);
        countLabel.setBounds(20, 640, 300, 50);
        scrollCalendarTable.setBounds(20, 300, 300, 290);

        frmMain.setResizable(false);
        frmMain.setVisible(true);

        GregorianCalendar cal = new GregorianCalendar();
        dayBound = cal.get(GregorianCalendar.DAY_OF_MONTH);
        monthBound = cal.get(GregorianCalendar.MONTH);
        yearBound = cal.get(GregorianCalendar.YEAR);
        monthToday = monthBound;
        yearToday = yearBound;
        dayToday = dayBound;
        
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i = 0; i < 7; i++) {
            modelCalendarTable.addColumn(headers[i]);
        }

        calendarTable.getParent().setBackground(calendarTable.getBackground()); //Set background

        calendarTable.getTableHeader().setResizingAllowed(false);
        calendarTable.getTableHeader().setReorderingAllowed(false);

        calendarTable.setColumnSelectionAllowed(true);
        calendarTable.setRowSelectionAllowed(true);
        calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        calendarTable.setRowHeight(43);
        modelCalendarTable.setColumnCount(7);
        modelCalendarTable.setRowCount(6);

        for (int i = yearBound - 100; i <= yearBound + 100; i++) {
            cmbYear.addItem(String.valueOf(i));
        }
        events = new ArrayList<>();
        /* New Code */
        //importEventFromFile("Philippine Holidays.csv"); //Import from csv
        //importEventFromFile("DLSU Unicalendar.psv"); //Import from psv
        //importEventFromFile("output.csv");

        for (int i = 0; i < events.size(); i++) {
            System.out.println(events.get(i).toString());
        }
        refreshCalendar(monthBound, yearBound); //Refresh calendar
    }

    class btnTask_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ItemControl.filterToDo(monthToday + 1, dayToday, yearToday);
            btnDelete.setVisible(true);
        }
    }

    class btnSched_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ItemControl.SchedView();
            btnDelete.setVisible(false);
        }
    }

    class btnWeek_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < 7; i++)
                if(modelCalendarTable.getValueAt(todayRow, i) != null)
                    temp.add(Integer.parseInt(modelCalendarTable.getValueAt(todayRow, i).toString()));
                else
                    temp.add(0);
            ItemControl.WeekView(temp);
        }
    }
    
    class btnDelete_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ItemControl.removeCompleted();
            btnDelete.setSelected(false);
        }
    }

    class btnPrev_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (monthToday == 0) {
                monthToday = 11;
                yearToday -= 1;
            } else {
                monthToday -= 1;
            }
            refreshCalendar(monthToday, yearToday);
        }
    }

    class btnNext_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (monthToday == 11) {
                monthToday = 0;
                yearToday += 1;
            } else {
                monthToday += 1;
            }
            refreshCalendar(monthToday, yearToday);
        }
    }

    class cmbYear_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (cmbYear.getSelectedItem() != null) {
                String b = cmbYear.getSelectedItem().toString();
                yearToday = Integer.parseInt(b);
                refreshCalendar(monthToday, yearToday);
            }
        }
    }

    /**
     * *** New code ****
     */
    /*    public void addEvent(String title, Date d, Color c,int h){
            events.add(new Event(title, d, c, h));
        }
     */
    public int getMonth() {
        return this.monthToday + 1;
    }

    public int getDay() {
        return this.dayToday;
    }

    public int getYear() {
        return this.yearToday;
    }

    public void revalidate() {
        this.frmMain.revalidate();
    }

    public void repaint() {
        this.frmMain.repaint();
    }

    public ToDoPanel getToDoPanel() {
        return this.ToDoPanel;
    }

}
