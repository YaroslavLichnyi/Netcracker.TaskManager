package View;

import Controller.TaskManagerController;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditRepeatedTaskFrame extends JFrame{
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
    private  JTextField txfTitle;
    private TaskManagerController controller;
    private Task oldTask;

    public EditRepeatedTaskFrame(Task task, TaskManagerController taskManagerController ) {
        controller = taskManagerController;
        oldTask = task;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 200, 300, 400);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        JButton btAdd;
        JCheckBox cbActiveBox;
        panel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstr = new GridBagConstraints();
        panel.setLayout( gridBagLayout );
        SimpleDateFormat yearFormat = new SimpleDateFormat("YYYY");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        SimpleDateFormat secondFormat = new SimpleDateFormat("ss");
        lbLabel0 = new JLabel( "Time"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 1;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbLabel0, gridBagConstr);
        panel.add( lbLabel0 );

        txfTitle = new JTextField( );
        txfTitle.setText(task.getTitle());
        txfTitle.setForeground(new Color( 0,128,255 ));
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 1;
        gridBagConstr.gridwidth = 2;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.SOUTH;
        gridBagLayout.setConstraints( txfTitle, gridBagConstr);
        panel.add( txfTitle );

        lbLabel0 = new JLabel( "From"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 2;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbLabel0, gridBagConstr);
        panel.add( lbLabel0 );


        lbDay = new JLabel( "Day"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 3;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbDay, gridBagConstr);
        panel.add( lbDay );

        lbMonth = new JLabel( "Month"  );
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 3;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbMonth, gridBagConstr);
        panel.add( lbMonth );

        lbYear = new JLabel( "Year"  );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 3;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbYear, gridBagConstr);
        panel.add( lbYear );


        lbHours = new JLabel( "Hours"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 5;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbHours, gridBagConstr);
        panel.add( lbHours );

        lbMinutes = new JLabel( "Minutes"  );
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 5;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbMinutes, gridBagConstr);
        panel.add( lbMinutes );

        lbSeconds = new JLabel( "Seconds"  );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 5;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbSeconds, gridBagConstr);
        panel.add( lbSeconds );


        String []dataDays = { "00", "01", "02", "03", "04", "05", "06", "07",
                "08", "09", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23",
                "24", "25", "26", "27", "28", "29", "30", "31" };
        cmbDaysFrom = new JComboBox( dataDays );
        cmbDaysFrom.setSelectedItem(dayFormat.format(task.getStartTime()));
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 4;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbDaysFrom, gridBagConstr);
        panel.add( cmbDaysFrom );

        String []dataMonthes = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12" };
        cmbMonthesFrom = new JComboBox( dataMonthes );
        cmbMonthesFrom.setSelectedItem(monthFormat.format(task.getStartTime()));
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 4;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMonthesFrom, gridBagConstr);
        panel.add( cmbMonthesFrom );

        String []dataCombo3 = {  "2019", "2020", "2021", "2022",
                "2023", "2024", "2025", "2026", "2027",  "2028",
                "2029", "2030", "2031", "2032", "2033", "2034",
                "2035", "2036", "2037", "2038", "2039", "2040",
                "2041", "2042", "2043", "2044", "2045", "2046",
                "2047", "2048", "2049", "2050" };
        cmbYearsFrom = new JComboBox( dataCombo3 );
        cmbYearsFrom.setSelectedItem(yearFormat.format(task.getStartTime()));
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 4;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbYearsFrom, gridBagConstr);
        panel.add( cmbYearsFrom );

        String []dataSeconds = { "00", "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26",
                "27", "28", "29", "30", "31", "32", "33", "34", "35",
                "36", "37", "38", "39", "40", "41", "42", "43", "44",
                "45", "46", "47", "48", "49", "50", "51", "52", "53",
                "54", "55", "56", "57", "58", "59" };
        cmbSecondsFrom = new JComboBox( dataSeconds );
        cmbSecondsFrom.setSelectedItem(secondFormat.format(task.getStartTime()));
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 6;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbSecondsFrom, gridBagConstr);
        panel.add( cmbSecondsFrom );

        String []dataMinutes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31", "32", "33", "34", "35", "36",
                "37", "38", "39", "40", "41", "42", "43", "44", "45",
                "46", "47", "48", "49", "50", "51", "52", "53", "54",
                "55", "56", "57", "58", "59" };
        cmbMinutesFrom = new JComboBox( dataMinutes );
        cmbMinutesFrom.setSelectedItem(minuteFormat.format(task.getStartTime()));
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 6;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMinutesFrom, gridBagConstr);
        panel.add( cmbMinutesFrom );

        String []dataHours = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23" };
        cmbHoursFrom = new JComboBox( dataHours );
        cmbHoursFrom.setSelectedItem(hourFormat.format(task.getStartTime()));
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 6;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbHoursFrom, gridBagConstr);
        panel.add( cmbHoursFrom );

        lbLabel0 = new JLabel( "To"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 7;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbLabel0, gridBagConstr);
        panel.add( lbLabel0 );

        lbDay = new JLabel( "Day"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 8;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbDay, gridBagConstr);
        panel.add( lbDay );

        lbMonth = new JLabel( "Month"  );
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 8;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbMonth, gridBagConstr);
        panel.add( lbMonth );

        lbYear = new JLabel( "Year"  );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 8;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbYear, gridBagConstr);
        panel.add( lbYear );

        cmbDaysTo = new JComboBox( dataDays );
        cmbDaysTo.setSelectedItem(dayFormat.format(task.getStartTime()));
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 9;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbDaysTo, gridBagConstr);
        panel.add( cmbDaysTo );

        cmbMonthesTo = new JComboBox( dataMonthes );
        cmbMonthesTo.setSelectedItem(monthFormat.format(task.getEndTime()));
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 9;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMonthesTo, gridBagConstr);
        panel.add( cmbMonthesTo );

        cmbYearsTo = new JComboBox( dataCombo3 );
        cmbYearsTo.setSelectedItem(yearFormat.format(task.getEndTime()));
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 9;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbYearsTo, gridBagConstr);
        panel.add( cmbYearsTo );

        lbHours = new JLabel( "Hours"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 10;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbHours, gridBagConstr);
        panel.add( lbHours );

        lbMinutes = new JLabel( "Minutes"  );
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 10;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbMinutes, gridBagConstr);
        panel.add( lbMinutes );

        lbSeconds = new JLabel( "Seconds"  );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 10;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbSeconds, gridBagConstr);
        panel.add( lbSeconds );

        cmbSecondsTo = new JComboBox( dataSeconds );
        cmbSecondsTo.setSelectedItem(secondFormat.format(task.getEndTime()));
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 11;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbSecondsTo, gridBagConstr);
        panel.add( cmbSecondsTo );

        cmbMinutesTo = new JComboBox( dataMinutes );
        cmbMinutesTo.setSelectedItem(minuteFormat.format(task.getEndTime()));
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 11;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMinutesTo, gridBagConstr);
        panel.add( cmbMinutesTo );

        cmbHoursTo = new JComboBox( dataHours );
        cmbHoursTo.setSelectedItem(hourFormat.format(task.getEndTime()));
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 11;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbHoursTo, gridBagConstr);
        panel.add( cmbHoursTo );








        lbLabel0 = new JLabel( "Interval"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 12;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbLabel0, gridBagConstr);
        panel.add( lbLabel0 );

        lbDay = new JLabel( "Day"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 13;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbDay, gridBagConstr);
        panel.add( lbDay );

        lbMonth = new JLabel( "Month"  );
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 13;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbMonth, gridBagConstr);
        panel.add( lbMonth );

        lbYear = new JLabel( "Year"  );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 13;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbYear, gridBagConstr);
        panel.add( lbYear );





        int interval = task.getRepeatInterval();
        final int day = 86400;
        int intervalDays = (interval - interval%day)/day;
        interval = interval - intervalDays * day;
        final int hour = 3600;
        int intervalHours = (interval - interval%hour)/hour;
        interval = interval - intervalHours * hour;
        final int minute = 60;
        int intervalMinutes = (interval - interval%minute)/minute;
        interval = interval - intervalMinutes * minute;

       // lbTaskStartTime = new JLabel( intervalDays + "d " + intervalHours + "h "+ intervalMinutes+ "m "+interval +"s");

        cmbDaysInreval = new JComboBox( dataDays );
        cmbDaysInreval.setSelectedItem(String.valueOf(intervalDays));
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 14;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbDaysInreval, gridBagConstr);
        panel.add( cmbDaysInreval );

        String []dataMonthesInterval = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12" };

        cmbMonthesInreval = new JComboBox( dataMonthesInterval );

        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 14;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMonthesInreval, gridBagConstr);
        panel.add( cmbMonthesInreval );

        String []dataYearsInterval = {"00", "01", "02", "03", "04", "05" };

        cmbYearsInreval = new JComboBox( dataYearsInterval );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 14;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbYearsInreval, gridBagConstr);
        panel.add( cmbYearsInreval );

        lbHours = new JLabel( "Hours"  );

        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 15;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbHours, gridBagConstr);
        panel.add( lbHours );

        lbMinutes = new JLabel( "Minutes"  );
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 15;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbMinutes, gridBagConstr);
        panel.add( lbMinutes );

        lbSeconds = new JLabel( "Seconds"  );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 15;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbSeconds, gridBagConstr);
        panel.add( lbSeconds );

        cmbSecondsInreval = new JComboBox( dataSeconds );
        cmbSecondsInreval.setSelectedItem(String.valueOf(interval));
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 16;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbSecondsInreval, gridBagConstr);
        panel.add( cmbSecondsInreval );

        cmbMinutesInreval = new JComboBox( dataMinutes );
        cmbMinutesInreval.setSelectedItem(String.valueOf(intervalMinutes));
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 16;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMinutesInreval, gridBagConstr);
        panel.add( cmbMinutesInreval );

        cmbHoursInreval = new JComboBox( dataHours );
        cmbHoursInreval.setSelectedItem(String.valueOf(intervalHours));
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 16;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbHoursInreval, gridBagConstr);
        panel.add( cmbHoursInreval );

        btAdd = new JButton( "Save"  );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 17;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( btAdd, gridBagConstr);
        panel.add( btAdd );
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                } else if (txfTitle.getText().length()<2){
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Incorrect title");
                } else {
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

                    int intervalValue = Integer.parseInt( (String) cmbSecondsInreval.getSelectedItem());
                    intervalValue += Integer.parseInt( (String) cmbSecondsInreval.getSelectedItem());
                    intervalValue += Integer.parseInt( (String) cmbMinutesInreval.getSelectedItem()) * 60;
                    intervalValue += Integer.parseInt( (String) cmbHoursInreval.getSelectedItem()) * 60 * 60 ;
                    intervalValue += Integer.parseInt( (String) cmbDaysInreval.getSelectedItem()) * 60 * 60 * 24 ;
                    intervalValue += Integer.parseInt( (String) cmbHoursInreval.getSelectedItem()) * 60 * 60 * 30;
                    intervalValue += Integer.parseInt( (String) cmbHoursInreval.getSelectedItem()) * 60 * 60  * 365;

                    Date dateFrom = null;
                    Date dateTo = null;
                    try {
                        dateFrom = (Date)taskFormat.parse(strDateFrom);
                        dateTo = (Date)taskFormat.parse(strDateTo);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    title = txfTitle.getText();
                    Task newTask = new Task(title, dateFrom, dateTo,intervalValue );
                    controller.editTask( oldTask, newTask);
                    dispose();
                }
            }
        });



        cbActiveBox = new JCheckBox( "task is active"  );
        cbActiveBox.setSelected( task.isActive() );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 17;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cbActiveBox, gridBagConstr);
        panel.add( cbActiveBox );

        this.add(panel);
        this.setVisible(true);
    }
}
