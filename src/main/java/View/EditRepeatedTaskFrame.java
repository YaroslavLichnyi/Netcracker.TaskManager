package View;

import Controller.TaskManagerController;
import Model.Task;
import Model.TaskInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

class EditRepeatedTaskFrame extends RepeatedTaskFillingFormWithIntervalGUI {

    private JTextField txfTitle;
    private Task oldTask;
    private JCheckBox cbActiveBox;
    private int interval ;
    private int intervalYears;
    private int intervalMonthes ;
    private int intervalDays;
    private int intervalHours ;
    private int intervalMinutes;



    public EditRepeatedTaskFrame(Task task, TaskManagerController taskManagerController ) {
        super();
        setController(taskManagerController);
        oldTask = task;
        this.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 200, 300, 400);
        calculateIntevals();
        addElements();
        this.setVisible(true);
    }

    private String getFormatedItemName(int value){
        String intervalDaysStr;
        if (value < 10) return intervalDaysStr = "0" + String.valueOf(value);
        return String.valueOf(value);
    }

    @Override
    protected void addElements() {
        JButton btAdd;
        SimpleDateFormat yearFormat = new SimpleDateFormat("YYYY");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        SimpleDateFormat secondFormat = new SimpleDateFormat("ss");
        JLabel lbLabel0 = new JLabel("Time");
        gridBag.gridx = 1;
        gridBag.gridy = 1;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLabel0, gridBag);
        panel.add(lbLabel0);

        txfTitle = new JTextField( );
        txfTitle.setText(oldTask.getTitle());
        txfTitle.setForeground(new Color( 0,128,255 ));
        gridBag.gridx = 2;
        gridBag.gridy = 1;
        gridBag.gridwidth = 2;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.SOUTH;
        gridBagLayout.setConstraints( txfTitle, gridBag);
        panel.add( txfTitle );

        lbLabel0 = new JLabel( "From"  );
        gridBag.gridx = 1;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLabel0, gridBag);
        panel.add(lbLabel0);

        JLabel lbDay = new JLabel("Day");
        gridBag.gridx = 1;
        gridBag.gridy = 3;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbDay, gridBag);
        panel.add(lbDay);

        JLabel lbMonth = new JLabel("Month");
        gridBag.gridx = 2;
        gridBag.gridy = 3;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbMonth, gridBag);
        panel.add(lbMonth);

        JLabel lbYear = new JLabel("Year");
        gridBag.gridx = 3;
        gridBag.gridy = 3;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbYear, gridBag);
        panel.add(lbYear);

        JLabel lbHours = new JLabel("Hours");
        gridBag.gridx = 1;
        gridBag.gridy = 5;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbHours, gridBag);
        panel.add(lbHours);

        JLabel lbMinutes = new JLabel("Minutes");
        gridBag.gridx = 2;
        gridBag.gridy = 5;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbMinutes, gridBag);
        panel.add(lbMinutes);

        JLabel lbSeconds = new JLabel("Seconds");
        gridBag.gridx = 3;
        gridBag.gridy = 5;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbSeconds, gridBag);
        panel.add(lbSeconds);

        String []dataDays = { "00", "01", "02", "03", "04", "05", "06", "07",
                "08", "09", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23",
                "24", "25", "26", "27", "28", "29", "30", "31" };
        cmbDaysFrom = new JComboBox( dataDays );
        cmbDaysFrom.setSelectedItem(dayFormat.format(oldTask.getStartTime()));
        gridBag.gridx = 1;
        gridBag.gridy = 4;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbDaysFrom, gridBag);
        panel.add( cmbDaysFrom );

        String []dataMonthes = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12" };
        cmbMonthesFrom = new JComboBox( dataMonthes );
        cmbMonthesFrom.setSelectedItem(monthFormat.format(oldTask.getStartTime()));
        gridBag.gridx = 2;
        gridBag.gridy = 4;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMonthesFrom, gridBag);
        panel.add( cmbMonthesFrom );

        String []dataCombo3 = {  "2019", "2020", "2021", "2022",
                "2023", "2024", "2025", "2026", "2027",  "2028",
                "2029", "2030", "2031", "2032", "2033", "2034",
                "2035", "2036", "2037", "2038", "2039", "2040",
                "2041", "2042", "2043", "2044", "2045", "2046",
                "2047", "2048", "2049", "2050" };
        cmbYearsFrom = new JComboBox( dataCombo3 );
        cmbYearsFrom.setSelectedItem(yearFormat.format(oldTask.getStartTime()));
        gridBag.gridx = 3;
        gridBag.gridy = 4;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbYearsFrom, gridBag);
        panel.add( cmbYearsFrom );

        String []dataSeconds = { "00", "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26",
                "27", "28", "29", "30", "31", "32", "33", "34", "35",
                "36", "37", "38", "39", "40", "41", "42", "43", "44",
                "45", "46", "47", "48", "49", "50", "51", "52", "53",
                "54", "55", "56", "57", "58", "59" };
        cmbSecondsFrom = new JComboBox( dataSeconds );
        cmbSecondsFrom.setSelectedItem(secondFormat.format(oldTask.getStartTime()));
        gridBag.gridx = 3;
        gridBag.gridy = 6;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbSecondsFrom, gridBag);
        panel.add( cmbSecondsFrom );

        String []dataMinutes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31", "32", "33", "34", "35", "36",
                "37", "38", "39", "40", "41", "42", "43", "44", "45",
                "46", "47", "48", "49", "50", "51", "52", "53", "54",
                "55", "56", "57", "58", "59" };
        cmbMinutesFrom = new JComboBox( dataMinutes );
        cmbMinutesFrom.setSelectedItem(minuteFormat.format(oldTask.getStartTime()));
        gridBag.gridx = 2;
        gridBag.gridy = 6;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMinutesFrom, gridBag);
        panel.add( cmbMinutesFrom );

        String []dataHours = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23" };
        cmbHoursFrom = new JComboBox( dataHours );
        cmbHoursFrom.setSelectedItem(hourFormat.format(oldTask.getStartTime()));
        gridBag.gridx = 1;
        gridBag.gridy = 6;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbHoursFrom, gridBag);
        panel.add( cmbHoursFrom );

        lbLabel0 = new JLabel( "To"  );
        gridBag.gridx = 1;
        gridBag.gridy = 7;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLabel0, gridBag);
        panel.add(lbLabel0);

        lbDay = new JLabel( "Day"  );
        gridBag.gridx = 1;
        gridBag.gridy = 8;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbDay, gridBag);
        panel.add(lbDay);

        lbMonth = new JLabel( "Month"  );
        gridBag.gridx = 2;
        gridBag.gridy = 8;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbMonth, gridBag);
        panel.add(lbMonth);

        lbYear = new JLabel( "Year"  );
        gridBag.gridx = 3;
        gridBag.gridy = 8;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbYear, gridBag);
        panel.add(lbYear);

        cmbDaysTo = new JComboBox( dataDays );
        cmbDaysTo.setSelectedItem(dayFormat.format(oldTask.getStartTime()));
        gridBag.gridx = 1;
        gridBag.gridy = 9;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbDaysTo, gridBag);
        panel.add( cmbDaysTo );

        cmbMonthesTo = new JComboBox( dataMonthes );
        cmbMonthesTo.setSelectedItem(monthFormat.format(oldTask.getEndTime()));
        gridBag.gridx = 2;
        gridBag.gridy = 9;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMonthesTo, gridBag);
        panel.add( cmbMonthesTo );

        cmbYearsTo = new JComboBox( dataCombo3 );
        cmbYearsTo.setSelectedItem(yearFormat.format(oldTask.getEndTime()));
        gridBag.gridx = 3;
        gridBag.gridy = 9;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbYearsTo, gridBag);
        panel.add( cmbYearsTo );

        lbHours = new JLabel( "Hours"  );
        gridBag.gridx = 1;
        gridBag.gridy = 10;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbHours, gridBag);
        panel.add(lbHours);

        lbMinutes = new JLabel( "Minutes"  );
        gridBag.gridx = 2;
        gridBag.gridy = 10;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbMinutes, gridBag);
        panel.add(lbMinutes);

        lbSeconds = new JLabel( "Seconds"  );
        gridBag.gridx = 3;
        gridBag.gridy = 10;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbSeconds, gridBag);
        panel.add(lbSeconds);

        cmbSecondsTo = new JComboBox( dataSeconds );
        cmbSecondsTo.setSelectedItem(secondFormat.format(oldTask.getEndTime()));
        gridBag.gridx = 3;
        gridBag.gridy = 11;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbSecondsTo, gridBag);
        panel.add( cmbSecondsTo );

        cmbMinutesTo = new JComboBox( dataMinutes );
        cmbMinutesTo.setSelectedItem(minuteFormat.format(oldTask.getEndTime()));
        gridBag.gridx = 2;
        gridBag.gridy = 11;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMinutesTo, gridBag);
        panel.add( cmbMinutesTo );

        cmbHoursTo = new JComboBox( dataHours );
        cmbHoursTo.setSelectedItem(hourFormat.format(oldTask.getEndTime()));
        gridBag.gridx = 1;
        gridBag.gridy = 11;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbHoursTo, gridBag);
        panel.add( cmbHoursTo );

        lbLabel0 = new JLabel( "Interval"  );
        gridBag.gridx = 1;
        gridBag.gridy = 12;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLabel0, gridBag);
        panel.add(lbLabel0);

        lbDay = new JLabel( "Day"  );
        gridBag.gridx = 1;
        gridBag.gridy = 13;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbDay, gridBag);
        panel.add(lbDay);

        lbMonth = new JLabel( "Month"  );
        gridBag.gridx = 2;
        gridBag.gridy = 13;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbMonth, gridBag);
        panel.add(lbMonth);

        lbYear = new JLabel( "Year"  );
        gridBag.gridx = 3;
        gridBag.gridy = 13;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbYear, gridBag);
        panel.add(lbYear);

        cmbDaysInreval = new JComboBox( dataDays );
        cmbDaysInreval.setSelectedItem(getFormatedItemName(intervalDays));
        gridBag.gridx = 1;
        gridBag.gridy = 14;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbDaysInreval, gridBag);
        panel.add( cmbDaysInreval );

        String []dataMonthesInterval = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12" };

        cmbMonthesInreval = new JComboBox(dataMonthesInterval);
        cmbMonthesInreval.setSelectedItem(getFormatedItemName(intervalMonthes));
        gridBag.gridx = 2;
        gridBag.gridy = 14;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(cmbMonthesInreval, gridBag);
        panel.add(cmbMonthesInreval);

        String []dataYearsInterval = {"00", "01", "02", "03", "04", "05" };

        cmbYearsInreval = new JComboBox(dataYearsInterval);
        cmbYearsInreval.setSelectedItem(getFormatedItemName(intervalYears));
        gridBag.gridx = 3;
        gridBag.gridy = 14;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(cmbYearsInreval, gridBag);
        panel.add(cmbYearsInreval);

        lbHours = new JLabel( "Hours"  );

        gridBag.gridx = 1;
        gridBag.gridy = 15;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbHours, gridBag);
        panel.add(lbHours);

        lbMinutes = new JLabel( "Minutes"  );
        gridBag.gridx = 2;
        gridBag.gridy = 15;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbMinutes, gridBag);
        panel.add(lbMinutes);

        lbSeconds = new JLabel( "Seconds"  );
        gridBag.gridx = 3;
        gridBag.gridy = 15;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbSeconds, gridBag);
        panel.add(lbSeconds);

        cmbSecondsInreval = new JComboBox( dataSeconds );
        cmbSecondsInreval.setSelectedItem(getFormatedItemName(interval));
        gridBag.gridx = 3;
        gridBag.gridy = 16;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbSecondsInreval, gridBag);
        panel.add( cmbSecondsInreval );

        cmbMinutesInreval = new JComboBox( dataMinutes );
        cmbMinutesInreval.setSelectedItem(getFormatedItemName(intervalMinutes));
        gridBag.gridx = 2;
        gridBag.gridy = 16;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMinutesInreval, gridBag);
        panel.add( cmbMinutesInreval );

        cmbHoursInreval = new JComboBox( dataHours );
        cmbHoursInreval.setSelectedItem(getFormatedItemName(intervalHours));
        gridBag.gridx = 1;
        gridBag.gridy = 16;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbHoursInreval, gridBag);
        panel.add( cmbHoursInreval );

        btAdd = new JButton( "Save"  );
        gridBag.gridx = 3;
        gridBag.gridy = 17;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( btAdd, gridBag);
        panel.add( btAdd );
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isIncorrectTimeInputed()){
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Too many days for this month");
                } else if (TaskInfo.isNameIncorrect(txfTitle.getText())){
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Too short title");
                } else if (getInputedInterval() == 0){
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Your interval must be at least 1 second (not 0)");
                } else {
                    getController().editTask( oldTask, getNewTask());
                    dispose();
                }
            }
        });
        cbActiveBox = new JCheckBox( "task is active"  );
        cbActiveBox.setSelected( oldTask.isActive() );
        gridBag.gridx = 1;
        gridBag.gridy = 17;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cbActiveBox, gridBag);
        panel.add( cbActiveBox );
        this.add(panel);
    }

    private void calculateIntevals(){

        final int SECONDS_IN_A_YEAR = 31536000;
        final int SECONDS_IN_A_MONTH = 2592000;
        final int SECONDS_IN_A_DAY = 86400;
        final int SECONDS_IN_AN_HOUR = 3600;
        final int SECONDS_IN_A_MINUTE = 60;

        int interval = oldTask.getRepeatInterval();

        intervalYears = (interval - interval % SECONDS_IN_A_YEAR)/SECONDS_IN_A_YEAR;
        interval = interval - intervalYears * SECONDS_IN_A_YEAR;

        intervalMonthes = (interval - interval % SECONDS_IN_A_MONTH)/SECONDS_IN_A_MONTH;
        interval = interval - intervalMonthes * SECONDS_IN_A_MONTH;

        intervalDays = (interval - interval % SECONDS_IN_A_DAY)/SECONDS_IN_A_DAY;
        interval = interval - intervalDays * SECONDS_IN_A_DAY;

        intervalHours = (interval - interval % SECONDS_IN_AN_HOUR)/SECONDS_IN_AN_HOUR;
        interval = interval - intervalHours * SECONDS_IN_AN_HOUR;

        intervalMinutes = (interval - interval % SECONDS_IN_A_MINUTE)/SECONDS_IN_A_MINUTE;
        interval = interval - intervalMinutes * SECONDS_IN_A_MINUTE;
    }

    private Task getNewTask(){
        Task newTask = new Task(txfTitle.getText(), getInputedStartTime(), getInputedEndTime(), getInputedInterval());
        newTask.setActive(cbActiveBox.isSelected());
        return newTask;
    }
}