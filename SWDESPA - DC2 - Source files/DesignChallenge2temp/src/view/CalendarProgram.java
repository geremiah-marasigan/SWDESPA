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
import java.io.PrintStream;
import java.util.*;
import view.ToDoItem;

public class CalendarProgram{
	
        /**** Day Components ****/
	public int yearBound, monthBound, dayBound, yearToday, monthToday;

        /**** Swing Components ****/
        public JLabel monthLabel, yearLabel, eventLabel, timeLabel, todoLabel;
	public JButton btnPrev, btnNext, btnAddtoDo;
        public JComboBox cmbYear;
	public JFrame frmMain;
	public Container pane;
	public JScrollPane scrollCalendarTable, scrollToDo;
	public JPanel calendarPanel;
        
        /**** Calendar Table Components ***/
	public JTable calendarTable;
        public DefaultTableModel modelCalendarTable;
        
        /**** Event Components ****/
        public ArrayList<Event> events;
        
        /**** Notification Components ****/
        public ToDoPanel ToDoPanel;
        
        /**** Export Components ****/
        public JButton btnExport;
        
        public void refreshCalendar(int month, int year)
        {
                String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som, i, j;
		Calendar today = Calendar.getInstance();	
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		if (month == 0 && year <= yearBound-10)
                    btnPrev.setEnabled(false);
		if (month == 11 && year >= yearBound+100)
                    btnNext.setEnabled(false);
                
		monthLabel.setText(months[month] + " " + yearToday);
		monthLabel.setBounds(280-monthLabel.getPreferredSize().width/2, 290, 300, 50);
                
		cmbYear.setSelectedItem(""+year);
		
		for (i = 0; i < 6; i++)
			for (j = 0; j < 7; j++)
				modelCalendarTable.setValueAt(null, i, j);
		
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);
		
		for (i = 1; i <= nod; i++)
                {
                    String eventMonth="";
			int row = (i+som-2)/7;
			int column  =  (i+som-2)%7;
                        modelCalendarTable.setValueAt(i, row, column);
                        try{
                            switch(monthToday+1){
                                case 1: eventMonth = "Jan"; break;
                                case 2: eventMonth = "Feb"; break;
                                case 3: eventMonth = "Mar"; break;
                                case 4: eventMonth = "Apr"; break;
                                case 5: eventMonth = "May"; break;
                                case 6: eventMonth = "Jun"; break;
                                case 7: eventMonth = "Jul"; break;
                                case 8: eventMonth = "Aug"; break;
                                case 9: eventMonth = "Sep"; break;
                                case 10: eventMonth = "Oct"; break;
                                case 11: eventMonth = "Nov"; break;
                                case 12: eventMonth = "Dec"; break;
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
                        }
                        catch (Exception e){
                            
                        }
                }

		calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new TableRenderer());
                
	}
        public void initialize(ItemController con){
            ToDoPanel = new ToDoPanel(con);
            scrollToDo = new JScrollPane(ToDoPanel);
            
            pane.add(scrollToDo);
            scrollToDo.setBounds(calendarPanel.getX()+350,calendarPanel.getY() ,703, 750);
        }
	public CalendarProgram()
        {
		try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
		catch (Exception e) {}
                
                //timer = new java.util.Timer(true);
                //timer.scheduleAtFixedRate(timerTask, 1000, 1000); //Update in real-time
                
		frmMain = new JFrame ("Calendar Application");
                frmMain.setSize(1060, 750);
		pane = frmMain.getContentPane();
		pane.setLayout(null);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
		monthLabel = new JLabel ("January ");
		yearLabel = new JLabel ("Change year:");
		cmbYear = new JComboBox();
		btnPrev = new JButton ("<<");
		btnNext = new JButton (">>");
                btnExport = new JButton("Export to .csv");
		modelCalendarTable = new DefaultTableModel()
                {
                    public boolean isCellEditable(int rowIndex, int mColIndex)
                    {
                        return false;
                    }
                };
                
		calendarTable = new JTable(modelCalendarTable);
                calendarTable.addMouseListener(new MouseAdapter()   
                {  
                    public void mouseClicked(MouseEvent evt)  
                    {  
                        int col = calendarTable.getSelectedColumn();  
                        int row = calendarTable.getSelectedRow();  
                        System.out.println("Hello");
                        /*
                        NewEventWindow frmEventAdder = new NewEventWindow(monthToday+1,yearToday,Integer.parseInt(modelCalendarTable.getValueAt(row, col).toString().split(" ")[0]),CalendarProgram.this);
                        frmEventAdder.setResizable(false);
                        frmEventAdder.setVisible(true);
                        frmEventAdder.setSize(450, 100);
                        frmEventAdder.setLocation(frmMain.getX()+frmMain.getWidth(),frmMain.getY());
                        for (int i = 0; i < events.size(); i++)
                            System.out.println(events.get(i).toString());
                        */
                    }
                });
                
		scrollCalendarTable = new JScrollPane(calendarTable);
		calendarPanel = new JPanel(null);
		
                //calendarPanel.setBorder(BorderFactory.createTitledBorder(""));
		//ToDoPanel.setBorder(BorderFactory.createTitledBorder(""));
                
		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());
		
		pane.add(calendarPanel);
		calendarPanel.add(monthLabel);
		calendarPanel.add(yearLabel);
		calendarPanel.add(cmbYear);
		calendarPanel.add(btnPrev);
		calendarPanel.add(btnNext);
		calendarPanel.add(scrollCalendarTable);
                /***************/
                btnExport.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        //exportToCsv();
                    }
                });
                
                calendarPanel.add(btnExport);
                btnExport.setBounds(19, 650, 120, 40);
                
		/***************/
                calendarPanel.setBounds(0, 0, 350, 750);
                monthLabel.setBounds(320-monthLabel.getPreferredSize().width/2, 200, 200, 50);
		yearLabel.setBounds(btnExport.getX()+162, 650, 80, 40);
		cmbYear.setBounds(yearLabel.getX()+80, 650, 60, 40);
		btnPrev.setBounds(20, 290, 50, 50);
		btnNext.setBounds(70, 290, 50, 50);
		scrollCalendarTable.setBounds(20, 350, 300, 290);
                
		frmMain.setResizable(false);
		frmMain.setVisible(true);
		
		GregorianCalendar cal = new GregorianCalendar();
		dayBound = cal.get(GregorianCalendar.DAY_OF_MONTH);
		monthBound = cal.get(GregorianCalendar.MONTH);
		yearBound = cal.get(GregorianCalendar.YEAR);
		monthToday = monthBound; 
		yearToday = yearBound;
		
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++){
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
		
		for (int i = yearBound-100; i <= yearBound+100; i++)
                {
			cmbYear.addItem(String.valueOf(i));
		}
		events = new ArrayList<>();
                /* New Code */
                //importEventFromFile("Philippine Holidays.csv"); //Import from csv
                //importEventFromFile("DLSU Unicalendar.psv"); //Import from psv
                //importEventFromFile("output.csv");
                
                for (int i = 0; i < events.size(); i++)
                    System.out.println(events.get(i).toString());
		refreshCalendar (monthBound, yearBound); //Refresh calendar
	}
	

	class btnPrev_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (monthToday == 0)
                        {
				monthToday = 11;
				yearToday -= 1;
			}
			else
                        {
				monthToday -= 1;
			}
			refreshCalendar(monthToday, yearToday);
		}
	}
	class btnNext_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (monthToday == 11)
                        {
				monthToday = 0;
				yearToday += 1;
			}
			else
                        {
				monthToday += 1;
			}
			refreshCalendar(monthToday, yearToday);
		}
	}
	class cmbYear_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (cmbYear.getSelectedItem() != null)
                        {
				String b = cmbYear.getSelectedItem().toString();
				yearToday = Integer.parseInt(b);
				refreshCalendar(monthToday, yearToday);
			}
		}
	}
        
        /***** New code *****/
        
    /*    public void addEvent(String title, Date d, Color c,int h){
            events.add(new Event(title, d, c, h));
        }
    */  
        public void revalidate(){
            this.frmMain.revalidate();
        }
        public void repaint(){
            this.frmMain.repaint();
        }
        public ToDoPanel getToDoPanel(){
            return this.ToDoPanel;
        }
    
}
