package View;

import Controller.TaskManagerController;
import Model.ArrayTaskList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindFrame extends TaskFillingFormGUI {

    private ArrayTaskList tasks;
    private JTextField txfTitle;
    private JRadioButton rbTitle;
    private JRadioButton rbTime;
    private JRadioButton rbBoth;

    FindFrame(ArrayTaskList arr, TaskManagerController taskManagerController)  {
        super();
        tasks = arr;
        setController(taskManagerController);
        this.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 250, 400, 500);
        addElements();
        this.setVisible(true);
    }

    @Override
    protected void addElements() {
        panel.setBackground(Color.WHITE);

        txfTitle = new JTextField( );
        txfTitle.setForeground(TaskColor.getBlue());
        gridBag.gridx = 1;
        gridBag.gridy = 1;
        gridBag.gridwidth = 3;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.SOUTH;
        gridBagLayout.setConstraints( txfTitle, gridBag);
        panel.add( txfTitle );

        JLabel lbTitle = new JLabel("Title");
        lbTitle.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        lbTitle.setForeground(TaskColor.getBlue());
        gridBag.gridx = 2;
        gridBag.gridy = 0;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTitle, gridBag);
        panel.add(lbTitle);

        JLabel lbFrom = new JLabel( "From"  );
        lbFrom.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        lbFrom.setForeground(TaskColor.getBlue());
        gridBag.gridx = 2;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbFrom, gridBag);
        panel.add( lbFrom );


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

        cmbYearsFrom = new JComboBox( dataYears);
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

        lbFrom = new JLabel( "To"  );
        lbFrom.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        lbFrom.setForeground(TaskColor.getBlue());
        gridBag.gridx = 2;
        gridBag.gridy = 7;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbFrom, gridBag);
        panel.add( lbFrom );

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

        JLabel lbSearchBy = new JLabel( "Search by"  );
        gridBag.gridx = 1;
        gridBag.gridy = 12;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbSearchBy, gridBag);
        panel.add( lbSearchBy );

        rbTitle = new JRadioButton( "title"  );
        gridBag.gridx = 1;
        gridBag.gridy = 13;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 0;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( rbTitle, gridBag);
        panel.add( rbTitle );

        rbTime = new JRadioButton( "time"  );
        gridBag.gridx = 2;
        gridBag.gridy = 13;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( rbTime, gridBag);
        panel.add( rbTime );

        rbBoth = new JRadioButton( "both"  );
        rbBoth.setSelected( true );
        gridBag.gridx = 3;
        gridBag.gridy = 13;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( rbBoth, gridBag);
        panel.add( rbBoth );

        ButtonGroup group = new ButtonGroup();
        group.add(rbTitle);
        group.add(rbTime);
        group.add(rbBoth);

        JButton btFind = new JButton( "Find"  );
        gridBag.gridx = 2;
        gridBag.gridy = 14;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.CENTER;
        gridBagLayout.setConstraints( btFind, gridBag);
        panel.add( btFind );

        btFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbTitle.isSelected()){
                    new TaskTableFrame(getController().findTasksByTitle(tasks, txfTitle.getText()), getController());
                } else if (rbTime.isSelected()){
                    new TaskTableFrame(getController().findTasksByTime(tasks,getInputedStartTime(), getInputedEndTime()), getController());
                } else if (rbBoth.isSelected()){
                    new TaskTableFrame(getController().findTasksByTime(tasks,getInputedStartTime(), getInputedEndTime()), getController());
                }
            }
        });
        this.add(panel);
    }
}
