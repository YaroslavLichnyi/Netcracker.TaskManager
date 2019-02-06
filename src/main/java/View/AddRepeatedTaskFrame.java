package View;

import Controller.TaskManagerController;
import Model.ArrayTaskList;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddRepeatedTaskFrame extends JFrame {
    private String title;
    private JPanel panel;
    private JLabel lbLabel0;
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
    private JComboBox cmbDaysInreval;
    private JComboBox cmbMonthesInreval;
    private JComboBox cmbYearsInreval;
    private JComboBox cmbSecondsInreval;
    private JComboBox cmbMinutesInreval;
    private JComboBox cmbHoursInreval;
    private TaskManagerController taskManagerController;

    public AddRepeatedTaskFrame(final String title, TaskManagerController controller ) {
        super("Task Manager");
        this.title = title;
        taskManagerController = controller;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 150, 300, 300);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        JButton btAdd;
        JCheckBox cbActiveBox;

        panel = new JPanel();

        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        panel.setLayout( gbPanel0 );

        lbLabel0 = new JLabel( "Time"  );
        lbLabel0.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbLabel0, gbcPanel0 );
        panel.add( lbLabel0 );

        lbLabel0 = new JLabel( "From"  );
        gbcPanel0.gridx = 1;
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


        String []dataDays = { "00", "01", "02", "03", "04", "05", "06", "07",
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

        String []dataMonthes = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November",
                "December" };
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

        String []dataMinutes = { "0", "01", "02", "03", "04", "05", "06", "07", "08", "09",
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
        gbcPanel0.gridx = 1;
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
        /*
        Font font = new Font("Verdana", Font.PLAIN, 12);
        lbMinutes.setForeground(new Color(222, 172, 122));
        lbMinutes.setFont(font);
        */
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

        lbLabel0 = new JLabel( "Interval"  );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 12;
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
        gbcPanel0.gridy = 13;
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
        gbcPanel0.gridy = 13;
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
        gbcPanel0.gridy = 13;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbYear, gbcPanel0 );
        panel.add( lbYear );

        cmbDaysInreval = new JComboBox( dataDays );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 14;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbDaysInreval, gbcPanel0 );
        panel.add( cmbDaysInreval );

        String []dataMonthesInterval = {"0", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12" };

        cmbMonthesInreval = new JComboBox( dataMonthesInterval );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 14;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbMonthesInreval, gbcPanel0 );
        panel.add( cmbMonthesInreval );

        String []dataYearsInterval = {"0", "01", "02", "03", "04", "05" };

        cmbYearsInreval = new JComboBox( dataYearsInterval );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 14;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbYearsInreval, gbcPanel0 );
        panel.add( cmbYearsInreval );

        lbHours = new JLabel( "Hours"  );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 15;
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
        gbcPanel0.gridy = 15;
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
        gbcPanel0.gridy = 15;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbSeconds, gbcPanel0 );
        panel.add( lbSeconds );

        cmbSecondsInreval = new JComboBox( dataSeconds );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 16;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbSecondsInreval, gbcPanel0 );
        panel.add( cmbSecondsInreval );

        cmbMinutesInreval = new JComboBox( dataMinutes );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 16;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbMinutesInreval, gbcPanel0 );
        panel.add( cmbMinutesInreval );

        cmbHoursInreval = new JComboBox( dataHours );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 16;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbHoursInreval, gbcPanel0 );
        panel.add( cmbHoursInreval );

        btAdd = new JButton( "Add"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 17;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btAdd, gbcPanel0 );
        panel.add( btAdd );

        cbActiveBox = new JCheckBox( "Make an active"  );
        cbActiveBox.setSelected( true );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 17;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cbActiveBox, gbcPanel0 );
        panel.add( cbActiveBox );

        this.add(panel);
        this.setVisible(true);
        btAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat taskFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
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

                int intervalValue = (Integer) cmbSecondsInreval.getSelectedItem();
                intervalValue += (Integer) cmbSecondsInreval.getSelectedItem();
                intervalValue += (Integer) cmbMinutesInreval.getSelectedItem() * 60;
                intervalValue += (Integer) cmbHoursInreval.getSelectedItem() * 60 * 60 ;
                intervalValue += (Integer) cmbDaysInreval.getSelectedItem() * 60 * 60 * 24 ;
                intervalValue += (Integer) cmbHoursInreval.getSelectedItem() * 60 * 60 * 30;
                intervalValue += (Integer) cmbHoursInreval.getSelectedItem() * 60 * 60  * 365;

                Date dateFrom = null;
                Date dateTo = null;
                try {
                    dateFrom = (Date)taskFormat.parse(strDateFrom);
                    dateTo = (Date)taskFormat.parse(strDateTo);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                Task task = new Task(title, dateFrom, dateTo,intervalValue );
                taskManagerController.addTask(task);
                dispose();
            }
        });
    }
}
