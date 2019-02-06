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

public class AddNotRepeatedTaskFrame extends Frame{
    private String taskTitle;
    private JPanel panel;
    private JLabel lbLabel0;
    private JLabel lbDay;
    private JLabel lbMonth;
    private JLabel lbYear;
    private JLabel lbHours;
    private JLabel lbMinutes;
    private JLabel lbSeconds;
    private JComboBox cmbDays;
    private JComboBox cmbMonthes;
    private JComboBox cmbYear;
    private JComboBox cmbSeconds;
    private JComboBox cmbMinutes;
    private JComboBox cmbHours;
    private JButton btAdd;
    private JCheckBox cbActiveBox;
    private TaskManagerController taskManagerController;
    public AddNotRepeatedTaskFrame(String title, TaskManagerController controller){
        super("Task Manager");
        taskManagerController = controller;
        this.taskTitle = title;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 150, 300, 300);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        panel = new JPanel();
       // panel.setBackground(new Color(255, 255, 255));
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        panel.setLayout( gbPanel0 );

        lbLabel0 = new JLabel( "Time"  );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 1;
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
        gbcPanel0.gridy = 2;
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
        gbcPanel0.gridy = 2;
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
        gbcPanel0.gridy = 2;
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
        gbcPanel0.gridy = 4;
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
        gbcPanel0.gridy = 4;
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
        gbcPanel0.gridy = 4;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbSeconds, gbcPanel0 );
        panel.add( lbSeconds );


        String []dataDays = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31" };
        cmbDays = new JComboBox( dataDays );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbDays, gbcPanel0 );
        panel.add( cmbDays );

        String []dataMonthes = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12" };
        cmbMonthes = new JComboBox( dataMonthes );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbMonthes, gbcPanel0 );
        panel.add( cmbMonthes );

        String []dataCombo3 = {  "2019", "2020", "2021", "2022",
                "2023", "2024", "2025", "2026", "2027",  "2028",
                "2029", "2030", "2031", "2032", "2033", "2034",
                "2035", "2036", "2037", "2038", "2039", "2040",
                "2041", "2042", "2043", "2044", "2045", "2046",
                "2047", "2048", "2049", "2050" };
        cmbYear = new JComboBox( dataCombo3 );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(cmbYear, gbcPanel0 );
        panel.add(cmbYear);

        String []dataSeconds = { "00", "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26",
                "27", "28", "29", "30", "31", "32", "33", "34", "35",
                "36", "37", "38", "39", "40", "41", "42", "43", "44",
                "45", "46", "47", "48", "49", "50", "51", "52", "53",
                "54", "55", "56", "57", "58", "59" };
        cmbSeconds = new JComboBox( dataSeconds );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbSeconds, gbcPanel0 );
        panel.add( cmbSeconds );

        String []dataMinutes = { "0", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31", "32", "33", "34", "35", "36",
                "37", "38", "39", "40", "41", "42", "43", "44", "45",
                "46", "47", "48", "49", "50", "51", "52", "53", "54",
                "55", "56", "57", "58", "59" };
        cmbMinutes = new JComboBox( dataMinutes );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbMinutes, gbcPanel0 );
        panel.add( cmbMinutes );

        String []dataHours = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23" };
        cmbHours = new JComboBox( dataHours );
        gbcPanel0.gridx = 1;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbHours, gbcPanel0 );
        panel.add( cmbHours );

        btAdd = new JButton( "Add"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 6;
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
        gbcPanel0.gridy = 6;
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
                SimpleDateFormat taskFormat = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
                String seconds =(String) cmbSeconds.getSelectedItem();
                String minutes =(String) cmbMinutes.getSelectedItem();
                String hours =(String) cmbHours.getSelectedItem();
                String days =(String) cmbDays.getSelectedItem();
                String monthes =(String) cmbMonthes.getSelectedItem();
                String years =(String) cmbYear.getSelectedItem();
                String myDate =days+monthes+years+" "+hours+":"+minutes+":"+seconds;
                Date date = null;
                try {
                    date = (Date)taskFormat.parse(myDate);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                Task task = new Task(taskTitle ,date);
                taskManagerController.addTask(task);
                dispose();
            }
        });
    }
}