package View;

import Controller.TaskManagerController;
import Model.ArrayTaskList;
import Model.Task;
import Model.Tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class FindFrame extends JFrame {
    JTextField titleField;  //текстовое поле с названием задачи
    JTextField timeField;   //текстовое поле со временем
    ArrayTaskList tasks;
    Date from;
    Date to;

    private String title;
    private JPanel panel;
    private JLabel lbNames;
    private JLabel lbDay;
    private JLabel lbMonth;
    private JLabel lbYear;
    private JLabel lbHours;
    private JLabel lbMinutes;
    private JLabel lbSeconds;
    private JComboBox cmbDaysFrom;
    private JComboBox cmbMonthesFrom;
    private JComboBox cmbYearsFrom;
    private JComboBox cmbSecondsFrom;
    private JComboBox cmbMinutesFrom;
    private JComboBox cmbHoursFrom;
    private JComboBox cmbDaysTo;
    private JComboBox cmbMonthesTo;
    private JComboBox cmbYearsTo;
    private JComboBox cmbSecondsTo;
    private JComboBox cmbMinutesTo;
    private JComboBox cmbHoursTo;
    private JTextField txfTitle;
    private JRadioButton rbTitle;
    private JRadioButton rbTime;
    private JRadioButton rbBoth;
    private TaskManagerController controller;

    public FindFrame(ArrayTaskList arr,  TaskManagerController taskManagerController )  {
        tasks = arr;
        controller = taskManagerController;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 250, 400, 500);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        JPanel panel = new JPanel();
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        panel.setLayout( gbPanel0 );
        panel.setBackground(Color.WHITE);

        txfTitle = new JTextField( );
        txfTitle.setForeground(new Color( 0,128,242 ));
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 3;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.SOUTH;
        gbPanel0.setConstraints( txfTitle, gbcPanel0 );
        panel.add( txfTitle );

        JLabel lbTitle = new JLabel("Title");
        lbTitle.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        lbTitle.setForeground(new Color(0, 128, 242));
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(lbTitle, gbcPanel0 );
        panel.add(lbTitle);

        JLabel lbLabel0 = new JLabel( "From"  );
        lbLabel0.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        lbLabel0.setForeground(new Color(0, 128, 242));
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 2;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbLabel0, gbcPanel0 );
        panel.add( lbLabel0 );


        lbDay = new JLabel( "Day"  );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbDay, gbcPanel0 );
        panel.add( lbDay );

        lbMonth = new JLabel( "Month"  );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbMonth, gbcPanel0 );
        panel.add( lbMonth );

        lbYear = new JLabel( "Year"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbYear, gbcPanel0 );
        panel.add( lbYear );


        lbHours = new JLabel( "Hours"  );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbHours, gbcPanel0 );
        panel.add( lbHours );

        lbMinutes = new JLabel( "Minutes"  );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbMinutes, gbcPanel0 );
        panel.add( lbMinutes );

        lbSeconds = new JLabel( "Seconds"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbSeconds, gbcPanel0 );
        panel.add( lbSeconds );


        String []dataDays = { "01", "02", "03", "04", "05", "06", "07",
                "08", "09", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23",
                "24", "25", "26", "27", "28", "29", "30", "31" };
        cmbDaysFrom = new JComboBox( dataDays );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 4;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbDaysFrom, gbcPanel0 );
        panel.add( cmbDaysFrom );

        String []dataMonthes = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12" };
        cmbMonthesFrom = new JComboBox( dataMonthes );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 4;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbMonthesFrom, gbcPanel0 );
        panel.add( cmbMonthesFrom );

        String []dataCombo3 = {  "2019", "2020", "2021", "2022",
                "2023", "2024", "2025", "2026", "2027",  "2028",
                "2029", "2030", "2031", "2032", "2033", "2034",
                "2035", "2036", "2037", "2038", "2039", "2040",
                "2041", "2042", "2043", "2044", "2045", "2046",
                "2047", "2048", "2049", "2050" };
        cmbYearsFrom = new JComboBox( dataCombo3 );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 4;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbYearsFrom, gbcPanel0 );
        panel.add( cmbYearsFrom );

        String []dataSeconds = { "00", "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26",
                "27", "28", "29", "30", "31", "32", "33", "34", "35",
                "36", "37", "38", "39", "40", "41", "42", "43", "44",
                "45", "46", "47", "48", "49", "50", "51", "52", "53",
                "54", "55", "56", "57", "58", "59" };
        cmbSecondsFrom = new JComboBox( dataSeconds );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 6;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbSecondsFrom, gbcPanel0 );
        panel.add( cmbSecondsFrom );

        String []dataMinutes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31", "32", "33", "34", "35", "36",
                "37", "38", "39", "40", "41", "42", "43", "44", "45",
                "46", "47", "48", "49", "50", "51", "52", "53", "54",
                "55", "56", "57", "58", "59" };
        cmbMinutesFrom = new JComboBox( dataMinutes );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 6;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbMinutesFrom, gbcPanel0 );
        panel.add( cmbMinutesFrom );

        String []dataHours = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23" };
        cmbHoursFrom = new JComboBox( dataHours );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 6;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbHoursFrom, gbcPanel0 );
        panel.add( cmbHoursFrom );

        lbLabel0 = new JLabel( "To"  );
        lbLabel0.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        lbLabel0.setForeground(new Color(0, 128, 242));
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 7;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbLabel0, gbcPanel0 );
        panel.add( lbLabel0 );

        lbDay = new JLabel( "Day"  );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 8;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbDay, gbcPanel0 );
        panel.add( lbDay );

        lbMonth = new JLabel( "Month"  );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 8;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbMonth, gbcPanel0 );
        panel.add( lbMonth );

        lbYear = new JLabel( "Year"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 8;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbYear, gbcPanel0 );
        panel.add( lbYear );

        cmbDaysTo = new JComboBox( dataDays );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 9;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbDaysTo, gbcPanel0 );
        panel.add( cmbDaysTo );

        cmbMonthesTo = new JComboBox( dataMonthes );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 9;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbMonthesTo, gbcPanel0 );
        panel.add( cmbMonthesTo );

        cmbYearsTo = new JComboBox( dataCombo3 );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 9;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbYearsTo, gbcPanel0 );
        panel.add( cmbYearsTo );

        lbHours = new JLabel( "Hours"  );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 10;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbHours, gbcPanel0 );
        panel.add( lbHours );

        lbMinutes = new JLabel( "Minutes"  );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 10;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbMinutes, gbcPanel0 );
        panel.add( lbMinutes );

        lbSeconds = new JLabel( "Seconds"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 10;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbSeconds, gbcPanel0 );
        panel.add( lbSeconds );

        cmbSecondsTo = new JComboBox( dataSeconds );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 11;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbSecondsTo, gbcPanel0 );
        panel.add( cmbSecondsTo );

        cmbMinutesTo = new JComboBox( dataMinutes );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 11;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbMinutesTo, gbcPanel0 );
        panel.add( cmbMinutesTo );

        cmbHoursTo = new JComboBox( dataHours );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 11;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbHoursTo, gbcPanel0 );
        panel.add( cmbHoursTo );

        JLabel lbSearchBy = new JLabel( "Search by"  );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 12;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbSearchBy, gbcPanel0 );
        panel.add( lbSearchBy );

        rbTitle = new JRadioButton( "title"  );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 13;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 0;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( rbTitle, gbcPanel0 );
        panel.add( rbTitle );

        rbTime = new JRadioButton( "time"  );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 13;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( rbTime, gbcPanel0 );
        panel.add( rbTime );

        rbBoth = new JRadioButton( "both"  );
        rbBoth.setSelected( true );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 13;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( rbBoth, gbcPanel0 );
        panel.add( rbBoth );

        ButtonGroup group = new ButtonGroup();
        group.add(rbTitle);
        group.add(rbTime);
        group.add(rbBoth);

        JButton btFind = new JButton( "Find"  );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 14;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.CENTER;
        gbPanel0.setConstraints( btFind, gbcPanel0 );
        panel.add( btFind );

        btFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbTitle.isSelected()){
                    if (txfTitle.getText().length()<2){
                        JFrame frame = new JFrame("Error");
                        JOptionPane.showMessageDialog(frame, "Too short title");
                    } else {
                        Iterator<Task> taskIterator = tasks.iterator();
                        ArrayTaskList arrayTaskList = new ArrayTaskList();
                        Task task;
                        int i = 0;
                        while (taskIterator.hasNext()){
                            task = taskIterator.next();
                            if (task.getTitle().equals(txfTitle.getText())){
                                arrayTaskList.add(task);
                            }
                            i++;
                        }
                        if (arrayTaskList.size()>0){
                            TaskTableFrame taskTableFrame = new TaskTableFrame(arrayTaskList,controller);
                        } else {
                            JFrame frame = new JFrame("Error");
                            JOptionPane.showMessageDialog(frame, "No tasks were found");
                        }
                    }
                } else if (rbTime.isSelected()){
                    SimpleDateFormat taskFormat = new SimpleDateFormat("ddMMyyyyHHmmss");

                    String daysFrom =(String) cmbDaysFrom.getSelectedItem();
                    String monthesFrom =(String) cmbMonthesFrom.getSelectedItem();
                    String yearsFrom =(String) cmbYearsFrom.getSelectedItem();
                    String daysTo =(String) cmbDaysTo.getSelectedItem();
                    String monthesTo =(String) cmbMonthesTo.getSelectedItem();
                    String yearsTo =(String) cmbYearsTo.getSelectedItem();

                    if (
                            (Integer.parseInt(daysFrom) == 31 && ( monthesFrom == "04" || monthesFrom == "06" || monthesFrom == "09" || monthesFrom == "11"))
                                    || (Integer.parseInt(daysFrom) >= 30 && monthesFrom == "02" &&  ((Integer.parseInt(yearsFrom) % 4 == 0) && Integer.parseInt(yearsFrom) % 100 != 0) )
                                    || (Integer.parseInt(daysFrom) >= 29 && monthesFrom == "02" &&  !((Integer.parseInt(yearsFrom) % 4 == 0) && Integer.parseInt(yearsFrom) % 100 != 0))
                                    || (Integer.parseInt(daysTo) == 31 && ( monthesTo == "04" || monthesTo == "06" || monthesTo == "09" || monthesTo == "11"))
                                    || (Integer.parseInt(daysTo) >= 30 && monthesTo == "02" &&  ((Integer.parseInt(yearsTo) % 4 == 0) && Integer.parseInt(yearsTo) % 100 != 0) )
                                    || (Integer.parseInt(daysTo) >= 29 && monthesTo == "02" &&  !((Integer.parseInt(yearsTo) % 4 == 0) && Integer.parseInt(yearsTo) % 100 != 0))
                    ){

                        JFrame frame = new JFrame("Error");
                        JOptionPane.showMessageDialog(frame, "Too many days for this month");
                    } else{
                        String seconds =(String) cmbSecondsFrom.getSelectedItem();
                        String minutes =(String) cmbMinutesFrom.getSelectedItem();
                        String hours =(String) cmbHoursFrom.getSelectedItem();
                        String days =(String) cmbDaysFrom.getSelectedItem();
                        String monthes =(String) cmbMonthesFrom.getSelectedItem();
                        String years =(String) cmbYearsFrom.getSelectedItem();

                        String strDateFrom = days + monthes + years + hours + minutes + seconds;

                        seconds =(String) cmbSecondsTo.getSelectedItem();
                        minutes =(String) cmbMinutesTo.getSelectedItem();
                        hours =(String) cmbHoursTo.getSelectedItem();
                        days =(String) cmbDaysTo.getSelectedItem();
                        monthes =(String) cmbMonthesTo.getSelectedItem();
                        years =(String) cmbYearsTo.getSelectedItem();

                        String strDateTo = days + monthes + years + hours + minutes + seconds;

                        Date dateFrom = null;
                        Date dateTo = null;
                        try {
                            dateFrom = (Date)taskFormat.parse(strDateFrom);
                            dateTo = (Date)taskFormat.parse(strDateTo);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                        ArrayTaskList arr = (ArrayTaskList) Tasks.incoming(tasks, dateTo, dateFrom );
                        if (arr.size()>0){
                            TaskTableFrame taskTableFrame = new TaskTableFrame(tasks,controller);
                        } else {
                            JFrame frame = new JFrame("Error");
                            JOptionPane.showMessageDialog(frame, "No tasks were found");
                        }
                    }
                } else if (rbBoth.isSelected()){
                    SimpleDateFormat taskFormat = new SimpleDateFormat("ddMMyyyyHHmmss");

                    String daysFrom =(String) cmbDaysFrom.getSelectedItem();
                    String monthesFrom =(String) cmbMonthesFrom.getSelectedItem();
                    String yearsFrom =(String) cmbYearsFrom.getSelectedItem();
                    String daysTo =(String) cmbDaysTo.getSelectedItem();
                    String monthesTo =(String) cmbMonthesTo.getSelectedItem();
                    String yearsTo =(String) cmbYearsTo.getSelectedItem();
                    if (txfTitle.getText().length()<2){
                        JFrame frame = new JFrame("Error");
                        JOptionPane.showMessageDialog(frame, "Too short title");
                    } else  if (
                            (Integer.parseInt(daysFrom) == 31 && ( monthesFrom == "04" || monthesFrom == "06" || monthesFrom == "09" || monthesFrom == "11"))
                                    || (Integer.parseInt(daysFrom) >= 30 && monthesFrom == "02" &&  ((Integer.parseInt(yearsFrom) % 4 == 0) && Integer.parseInt(yearsFrom) % 100 != 0) )
                                    || (Integer.parseInt(daysFrom) >= 29 && monthesFrom == "02" &&  !((Integer.parseInt(yearsFrom) % 4 == 0) && Integer.parseInt(yearsFrom) % 100 != 0))
                                    || (Integer.parseInt(daysTo) == 31 && ( monthesTo == "04" || monthesTo == "06" || monthesTo == "09" || monthesTo == "11"))
                                    || (Integer.parseInt(daysTo) >= 30 && monthesTo == "02" &&  ((Integer.parseInt(yearsTo) % 4 == 0) && Integer.parseInt(yearsTo) % 100 != 0) )
                                    || (Integer.parseInt(daysTo) >= 29 && monthesTo == "02" &&  !((Integer.parseInt(yearsTo) % 4 == 0) && Integer.parseInt(yearsTo) % 100 != 0))
                    ){

                        JFrame frame = new JFrame("Error");
                        JOptionPane.showMessageDialog(frame, "Too many days for this month");
                    } else{
                        String seconds =(String) cmbSecondsFrom.getSelectedItem();
                        String minutes =(String) cmbMinutesFrom.getSelectedItem();
                        String hours =(String) cmbHoursFrom.getSelectedItem();
                        String days =(String) cmbDaysFrom.getSelectedItem();
                        String monthes =(String) cmbMonthesFrom.getSelectedItem();
                        String years =(String) cmbYearsFrom.getSelectedItem();

                        String strDateFrom = days + monthes + years + hours + minutes + seconds;

                        seconds =(String) cmbSecondsTo.getSelectedItem();
                        minutes =(String) cmbMinutesTo.getSelectedItem();
                        hours =(String) cmbHoursTo.getSelectedItem();
                        days =(String) cmbDaysTo.getSelectedItem();
                        monthes =(String) cmbMonthesTo.getSelectedItem();
                        years =(String) cmbYearsTo.getSelectedItem();

                        String strDateTo = days + monthes + years + hours + minutes + seconds;

                        Date dateFrom = null;
                        Date dateTo = null;
                        try {
                            dateFrom = (Date)taskFormat.parse(strDateFrom);
                            dateTo = (Date)taskFormat.parse(strDateTo);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                        ArrayTaskList arr = (ArrayTaskList) Tasks.incoming(tasks, dateTo, dateFrom );
                        Iterator<Task> taskIterator = arr.iterator();
                        ArrayTaskList arrayTaskList = new ArrayTaskList();
                        Task task;
                        int i = 0;
                        while (taskIterator.hasNext()){
                            task = taskIterator.next();
                            if (task.getTitle().equals(txfTitle.getText())){
                                arrayTaskList.add(task);
                            }
                            i++;
                        }
                        if (arr.size()>0){
                            TaskTableFrame taskTableFrame = new TaskTableFrame(arr,controller);
                        } else {
                            JFrame frame = new JFrame("Error");
                            JOptionPane.showMessageDialog(frame, "No tasks were found");
                        }
                    }
                }
            }
        });


        this.add(panel);
        this.setVisible(true);
    }

}
