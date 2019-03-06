package View;

import Controller.TaskManagerController;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRepeatedTaskFrame extends RepeatedTaskFillingFormWithIntervalGUI {
    private String title;
    private JCheckBox cbActiveBox;

    public AddRepeatedTaskFrame(final String title, TaskManagerController controller ) {
        super();
        this.title = title;
        setController(controller);
        this.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 250, 400, 500);
        addElements();
        this.setVisible(true);
    }

    @Override
    protected void addElements() {
        JButton btAdd;
        panel.setLayout( gridBagLayout );
        panel.setBackground(Color.WHITE);

        JLabel lbNames = new JLabel("Time");
        lbNames.setFont(new Font("Serif", Font.BOLD, 22));
        gridBag.gridx = 2;
        gridBag.gridy = 0;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbNames, gridBag);
        panel.add(lbNames);

        lbNames = new JLabel( "From"  );
        lbNames.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        lbNames.setForeground(new Color(0, 128, 242));
        gridBag.gridx = 2;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbNames, gridBag);
        panel.add(lbNames);

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

        String []dataDays = { "01", "02", "03", "04", "05", "06", "07",
                "08", "09", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23",
                "24", "25", "26", "27", "28", "29", "30", "31" };
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

        String []dataMonthes = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12" };
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

        String []dataYears = {  "2019", "2020", "2021", "2022",
                "2023", "2024", "2025", "2026", "2027",  "2028",
                "2029", "2030", "2031", "2032", "2033", "2034",
                "2035", "2036", "2037", "2038", "2039", "2040",
                "2041", "2042", "2043", "2044", "2045", "2046",
                "2047", "2048", "2049", "2050" };
        cmbYearsFrom = new JComboBox( dataYears );
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

        lbNames = new JLabel( "To"  );
        lbNames.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        lbNames.setForeground(new Color(0, 128, 242));
        gridBag.gridx = 2;
        gridBag.gridy = 7;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbNames, gridBag);
        panel.add(lbNames);

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

        lbNames = new JLabel( "Interval"  );
        lbNames.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        lbNames.setForeground(new Color(0, 128, 242));

        gridBag.gridx = 2;
        gridBag.gridy = 12;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbNames, gridBag);
        panel.add(lbNames);

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

        String []dataDaysInterval = { "00", "01", "02", "03", "04", "05", "06", "07",
                "08", "09", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23",
                "24", "25", "26", "27", "28", "29", "30", "31" };

        cmbDaysInreval = new JComboBox( dataDaysInterval );
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

        cmbMonthesInreval = new JComboBox( dataMonthesInterval );
        gridBag.gridx = 2;
        gridBag.gridy = 14;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMonthesInreval, gridBag);
        panel.add( cmbMonthesInreval );

        String []dataYearsInterval = {"00", "01", "02", "03", "04", "05" };

        cmbYearsInreval = new JComboBox( dataYearsInterval );
        gridBag.gridx = 3;
        gridBag.gridy = 14;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbYearsInreval, gridBag);
        panel.add( cmbYearsInreval );

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

        btAdd = new JButton( "Add"  );
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

        cbActiveBox = new JCheckBox( "Make an active"  );
        cbActiveBox.setSelected( true );
        gridBag.gridx = 1;
        gridBag.gridy = 17;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(cbActiveBox, gridBag);
        panel.add(cbActiveBox);

        this.add(panel);
        btAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isIncorrectTimeInputed()){
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Too many days for this month");
                } else if (getInputedInterval() == 0){
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Your interval must be at least 1 second (not 0)");
                } else {
                    Task task = new Task(title, getInputedStartTime(), getInputedEndTime(), getInputedInterval() );
                    task.setActive(cbActiveBox.isSelected());
                    getController().addTask(task);
                }
                dispose();
            }
        });
    }
}
