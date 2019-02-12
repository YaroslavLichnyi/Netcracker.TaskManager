package View;

import Controller.TaskManagerController;
import Model.ArrayTaskList;
import Model.Task;
import Model.Tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CalendarFrame extends JFrame {
    private ArrayTaskList tasks;
    private JTable table;
    private DefaultTableModel model;
    private Calendar cal = new GregorianCalendar();
    private JLabel label;
    private int year;
    private int monthNumber;
    private ArrayTaskList arrayTaskList;
    private TaskManagerController taskManagerController;
    SimpleDateFormat taskFormat ;

    CalendarFrame(ArrayTaskList tasksArr, TaskManagerController controller) {
        tasks = tasksArr;
        taskManagerController = controller;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        this.setTitle("Calendar");
        this.setLayout(new BorderLayout());


        taskFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground( new Color( 0,128,255 ) );
        label.setForeground( new Color( 255,255,255 ) );

        JButton previous = new JButton("<-");
        previous.setBackground( new Color( 0,128,255 ) );
        previous.setBackground( new Color( 0,128,255 ) );
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                cal.add(Calendar.MONTH, -1);
                updateMonth();
            }
        });

        JButton next = new JButton("->");
        next.setBackground( new Color( 0,128,255 ) );
        next.setBackground( new Color( 0,128,255 ) );
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                cal.add(Calendar.MONTH, +1);
                updateMonth();
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground( new Color( 0,128,255 ) );
        panel.setLayout(new BorderLayout());
        panel.add(previous, BorderLayout.WEST);
        panel.add(label, BorderLayout.CENTER);
        panel.add(next, BorderLayout.EAST);


        String[] columns = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        model = new DefaultTableModel(null, columns);
        table = new JTable(model){
            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
        };
        table.setGridColor( new Color( 0,128,255 ) );
        JScrollPane pane = new JScrollPane(table);

        this.add(panel, BorderLayout.NORTH);
        this.add(pane, BorderLayout.CENTER);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String str =String.valueOf(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())) ;
                String dayStr = "";
                if (str.charAt(str.length()-1) == '*'){
                    if (str.length()==2){
                        dayStr+="0";
                        dayStr+=str.charAt(0);
                    } else {
                        dayStr+=str.charAt(0);
                        dayStr+=str.charAt(1);
                    }
                    String monthStr = "";
                    if (monthNumber < 10 ){
                        monthStr = "0"+monthNumber;
                    } else {
                        monthStr = Integer.toString(monthNumber);
                    }
                    String fromStr = dayStr + monthStr + year + "000000";
                    String toStr = dayStr + monthStr + year + "235959";

                    if (tasks != null) {
                        try {
                            Date from = (Date) taskFormat.parse(fromStr);
                            Date to = (Date) taskFormat.parse(toStr);
                            arrayTaskList = tasks.clone();
                            arrayTaskList = (ArrayTaskList) Tasks.incoming(arrayTaskList,from, to);
                            if (arrayTaskList.size()==1){
                                if(arrayTaskList.getTask(0).isRepeated()){
                                    DetailInformationFrameRepeated detInfFrRep = new DetailInformationFrameRepeated(arrayTaskList.getTask(0),taskManagerController);
                                } else {
                                    DetailInformationFrame detInfFr = new DetailInformationFrame(arrayTaskList.getTask(0),taskManagerController);
                                }
                            } else if (arrayTaskList.size()>1) {
                                TaskTableFrame tableFrame = new TaskTableFrame(arrayTaskList,taskManagerController);
                            }

                        } catch (ParseException ex){
                            System.out.println(ex);
                        }
                    }
                }
            }
        });
        this.updateMonth();
        this.setVisible(true);
    }

    void updateMonth() {
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
        year = cal.get(Calendar.YEAR);
        label.setText(month + " " + year);
        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        model.setRowCount(0);
        model.setRowCount(6);
        int i = startDay - 1;

        monthNumber = cal.get(Calendar.MONTH)+1;
        String dayStr = "";
        String monthStr = "";
        for (int day = 1; day <= numberOfDays; day++) {
            if ( day < 10) {
              dayStr = "0"+day;
            } else {
                dayStr = Integer.toString(day);
            }
            if (monthNumber < 10 ){
                monthStr = "0"+monthNumber;
            } else {
                monthStr = Integer.toString(monthNumber);
            }
            String fromStr = dayStr + monthStr + year + "000000";
            String toStr = dayStr + monthStr + year + "235959";
            model.setValueAt(day, i / 7, i % 7); // в любом случае пишем число

            if (tasks != null) {
                try {
                    Date from = (Date) taskFormat.parse(fromStr);
                    Date to = (Date) taskFormat.parse(toStr);
                    arrayTaskList = tasks.clone();
                    arrayTaskList = (ArrayTaskList) Tasks.incoming(arrayTaskList,from, to);
                    if(!arrayTaskList.isEmpty() ){
                        model.setValueAt(day + "*" , i / 7, i % 7);
                    }
                } catch (ParseException e){
                    System.out.println(e);
                }
            }
               i += 1;
            }
        }

    }
