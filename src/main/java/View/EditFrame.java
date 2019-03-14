package View;

import Controller.TaskManagerController;
import Model.Interval;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

class EditFrame extends TaskFillingFormWithIntervalGUI {

    private JTextField txfTitle;
    private Task oldTask;
    SimpleDateFormat yearFormat;
    SimpleDateFormat monthFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat hourFormat;
    SimpleDateFormat minuteFormat;
    SimpleDateFormat secondFormat;

    public EditFrame(Task task, TaskManagerController taskManagerController ) {
        super();
        setController(taskManagerController);
        oldTask = task;
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        yearFormat   = new SimpleDateFormat("YYYY");
        monthFormat  = new SimpleDateFormat("MM");
        dayFormat    = new SimpleDateFormat("dd");
        hourFormat   = new SimpleDateFormat("HH");
        minuteFormat = new SimpleDateFormat("mm");
        secondFormat = new SimpleDateFormat("ss");
        addElements();
        if (oldTask.isRepeated()) addElementsForRepeatedTask();
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
        txfTitle.setForeground(TaskColor.getBlue());
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

        cmbYearsFrom = new JComboBox( dataYears );
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
                if(isTimeCorrect(oldTask.isRepeated())){
                    getController().editTask( oldTask, getNewTask(txfTitle.getText(),oldTask.isRepeated()));
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


    private void addElementsForRepeatedTask(){
        this.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 200, 300, 400);
        Interval interval = new Interval(oldTask.getRepeatInterval());
        JLabel lbLabel0 = new JLabel( "From"  );
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

        JLabel lbDay = new JLabel( "Day"  );
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

        JLabel lbMonth = new JLabel( "Month"  );
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

        JLabel lbYear = new JLabel( "Year"  );
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

        cmbYearsTo = new JComboBox( dataYears );
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

        JLabel lbHours = new JLabel( "Hours"  );
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

        JLabel lbMinutes = new JLabel( "Minutes"  );
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

        JLabel lbSeconds = new JLabel( "Seconds"  );
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

        cmbDaysInreval = new JComboBox( dataDaysInterval );
        cmbDaysInreval.setSelectedItem(getFormatedItemName(interval.getDays()));
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

        cmbMonthesInreval = new JComboBox(dataMonthesInterval);
        cmbMonthesInreval.setSelectedItem(getFormatedItemName(interval.getMonths()));
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

        cmbYearsInreval = new JComboBox(dataYearsInterval);
        cmbYearsInreval.setSelectedItem(getFormatedItemName(interval.getYears()));
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
        cmbSecondsInreval.setSelectedItem(getFormatedItemName(interval.getSeconds()));
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
        cmbMinutesInreval.setSelectedItem(getFormatedItemName(interval.getMinutes()));
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
        cmbHoursInreval.setSelectedItem(getFormatedItemName(interval.getHours()));
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
    }
}
