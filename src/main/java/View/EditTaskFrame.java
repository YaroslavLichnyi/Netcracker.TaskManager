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

public class EditTaskFrame extends JFrame {
    private JPanel panel;
    private String taskTitle;
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
    private JButton btSave;
    private JCheckBox cbActiveBox;
    private JTextField txfTitle;
    private TaskManagerController controller;
    private Task oldTask;

    public EditTaskFrame(Task task, TaskManagerController taskManagerController) throws HeadlessException {
        //стоит л делать возможными интервалы в год или несколько месяцев
        controller = taskManagerController;
        oldTask = task;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstr = new GridBagConstraints();
        SimpleDateFormat yearFormat = new SimpleDateFormat("YYYY");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        SimpleDateFormat secondFormat = new SimpleDateFormat("ss");
        panel = new JPanel();
        panel.setLayout( gridBagLayout );

        lbLabel0 = new JLabel( "Title: " );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 1;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbLabel0, gridBagConstr );
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
        gridBagLayout.setConstraints( txfTitle, gridBagConstr );
        panel.add( txfTitle );


        lbDay = new JLabel( "Day"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 2;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbDay, gridBagConstr );
        panel.add( lbDay );

        lbMonth = new JLabel( "Month"  );
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 2;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbMonth, gridBagConstr );
        panel.add( lbMonth );

        lbYear = new JLabel( "Year"  );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 2;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbYear, gridBagConstr );
        panel.add( lbYear );


        lbHours = new JLabel( "Hours"  );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 4;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbHours, gridBagConstr );
        panel.add( lbHours );

        lbMinutes = new JLabel( "Minutes"  );
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 4;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbMinutes, gridBagConstr );
        panel.add( lbMinutes );

        lbSeconds = new JLabel( "Seconds"  );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 4;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 1;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbSeconds, gridBagConstr );
        panel.add( lbSeconds );


        String []dataDays = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31" };
        cmbDays = new JComboBox( dataDays );
        cmbDays.setSelectedItem(dayFormat.format(task.getTime()));
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 3;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbDays, gridBagConstr );
        panel.add( cmbDays );

        String []dataMonthes = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12" };
        cmbMonthes = new JComboBox( dataMonthes );
        cmbMonthes.setSelectedItem(monthFormat.format(task.getTime()));
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 3;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMonthes, gridBagConstr );
        panel.add( cmbMonthes );

        String []dataYear = {  "2019", "2020", "2021", "2022",
                "2023", "2024", "2025", "2026", "2027",  "2028",
                "2029", "2030", "2031", "2032", "2033", "2034",
                "2035", "2036", "2037", "2038", "2039", "2040",
                "2041", "2042", "2043", "2044", "2045", "2046",
                "2047", "2048", "2049", "2050" };
        cmbYear = new JComboBox( dataYear );
        cmbYear.setSelectedItem(yearFormat.format(task.getTime()));
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 3;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(cmbYear, gridBagConstr );
        panel.add(cmbYear);

        String []dataSeconds = { "00", "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26",
                "27", "28", "29", "30", "31", "32", "33", "34", "35",
                "36", "37", "38", "39", "40", "41", "42", "43", "44",
                "45", "46", "47", "48", "49", "50", "51", "52", "53",
                "54", "55", "56", "57", "58", "59" };
        cmbSeconds = new JComboBox( dataSeconds );
        cmbSeconds.setSelectedItem(secondFormat.format(task.getTime()));
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 5;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbSeconds, gridBagConstr );
        panel.add( cmbSeconds );

        String []dataMinutes = { "0", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31", "32", "33", "34", "35", "36",
                "37", "38", "39", "40", "41", "42", "43", "44", "45",
                "46", "47", "48", "49", "50", "51", "52", "53", "54",
                "55", "56", "57", "58", "59" };
        cmbMinutes = new JComboBox( dataMinutes );
        cmbMinutes.setSelectedItem(minuteFormat.format(task.getTime()));
        gridBagConstr.gridx = 2;
        gridBagConstr.gridy = 5;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMinutes, gridBagConstr );
        panel.add( cmbMinutes );

        String []dataHours = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23" };
        cmbHours = new JComboBox( dataHours );
        cmbHours.setSelectedItem(hourFormat.format(task.getTime()));
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 5;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbHours, gridBagConstr );
        panel.add( cmbHours );

        btSave = new JButton( "Save"  );
        gridBagConstr.gridx = 3;
        gridBagConstr.gridy = 6;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(btSave, gridBagConstr );
        panel.add(btSave);
        btSave.addActionListener(new ActionListener() {
            @Override
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
                Task newTask = new Task(taskTitle ,date);
                controller.editTask(oldTask, newTask);
                dispose();
            }
        });

        cbActiveBox = new JCheckBox( "task is active"  );
        cbActiveBox.setSelected( task.isActive() );
        gridBagConstr.gridx = 1;
        gridBagConstr.gridy = 6;
        gridBagConstr.gridwidth = 1;
        gridBagConstr.gridheight = 1;
        gridBagConstr.fill = GridBagConstraints.BOTH;
        gridBagConstr.weightx = 1;
        gridBagConstr.weighty = 0;
        gridBagConstr.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cbActiveBox, gridBagConstr );
        panel.add( cbActiveBox );

        this.add(panel);

        setVisible(true);
    }
}
