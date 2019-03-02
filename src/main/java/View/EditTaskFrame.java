package View;

import Controller.TaskManagerController;
import Model.Task;
import Model.TaskInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditTaskFrame extends TaskManagerGUI {
    private String taskTitle;
    private JComboBox cmbDays;
    private JComboBox cmbMonthes;
    private JComboBox cmbYear;
    private JComboBox cmbSeconds;
    private JComboBox cmbMinutes;
    private JComboBox cmbHours;
    private JCheckBox cbActiveBox;
    private JTextField txfTitle;
    private Task oldTask;

    public EditTaskFrame(Task task, TaskManagerController taskManagerController) throws HeadlessException {
        super();
        setController(taskManagerController);
        oldTask = task;
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        addElements();
        setVisible(true);
    }

    @Override
    protected void addElements() {
        SimpleDateFormat yearFormat = new SimpleDateFormat("YYYY");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        SimpleDateFormat secondFormat = new SimpleDateFormat("ss");

        panel.setLayout( gridBagLayout );
        JLabel lbLabel0 = new JLabel("Title: ");
        gridBag.gridx = 1;
        gridBag.gridy = 1;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLabel0, gridBag );
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
        gridBagLayout.setConstraints( txfTitle, gridBag );
        panel.add( txfTitle );


        JLabel lbDay = new JLabel("Day");
        gridBag.gridx = 1;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbDay, gridBag );
        panel.add(lbDay);

        JLabel lbMonth = new JLabel("Month");
        gridBag.gridx = 2;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbMonth, gridBag );
        panel.add(lbMonth);

        JLabel lbYear = new JLabel("Year");
        gridBag.gridx = 3;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbYear, gridBag );
        panel.add(lbYear);


        JLabel lbHours = new JLabel("Hours");
        gridBag.gridx = 1;
        gridBag.gridy = 4;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbHours, gridBag );
        panel.add(lbHours);

        JLabel lbMinutes = new JLabel("Minutes");
        gridBag.gridx = 2;
        gridBag.gridy = 4;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbMinutes, gridBag );
        panel.add(lbMinutes);

        JLabel lbSeconds = new JLabel("Seconds");
        gridBag.gridx = 3;
        gridBag.gridy = 4;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbSeconds, gridBag );
        panel.add(lbSeconds);


        String []dataDays = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31" };
        cmbDays = new JComboBox( dataDays );
        cmbDays.setSelectedItem(dayFormat.format(oldTask.getTime()));
        gridBag.gridx = 1;
        gridBag.gridy = 3;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbDays, gridBag );
        panel.add( cmbDays );

        String []dataMonthes = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12" };
        cmbMonthes = new JComboBox( dataMonthes );
        cmbMonthes.setSelectedItem(monthFormat.format(oldTask.getTime()));
        gridBag.gridx = 2;
        gridBag.gridy = 3;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMonthes, gridBag );
        panel.add( cmbMonthes );

        String []dataYear = {  "2019", "2020", "2021", "2022",
                "2023", "2024", "2025", "2026", "2027",  "2028",
                "2029", "2030", "2031", "2032", "2033", "2034",
                "2035", "2036", "2037", "2038", "2039", "2040",
                "2041", "2042", "2043", "2044", "2045", "2046",
                "2047", "2048", "2049", "2050" };
        cmbYear = new JComboBox( dataYear );
        cmbYear.setSelectedItem(yearFormat.format(oldTask.getTime()));
        gridBag.gridx = 3;
        gridBag.gridy = 3;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(cmbYear, gridBag );
        panel.add(cmbYear);

        String []dataSeconds = { "00", "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20", "21", "22", "23", "24", "25", "26",
                "27", "28", "29", "30", "31", "32", "33", "34", "35",
                "36", "37", "38", "39", "40", "41", "42", "43", "44",
                "45", "46", "47", "48", "49", "50", "51", "52", "53",
                "54", "55", "56", "57", "58", "59" };
        cmbSeconds = new JComboBox( dataSeconds );
        cmbSeconds.setSelectedItem(secondFormat.format(oldTask.getTime()));
        gridBag.gridx = 3;
        gridBag.gridy = 5;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbSeconds, gridBag );
        panel.add( cmbSeconds );

        String []dataMinutes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27",
                "28", "29", "30", "31", "32", "33", "34", "35", "36",
                "37", "38", "39", "40", "41", "42", "43", "44", "45",
                "46", "47", "48", "49", "50", "51", "52", "53", "54",
                "55", "56", "57", "58", "59" };
        cmbMinutes = new JComboBox( dataMinutes );
        cmbMinutes.setSelectedItem(minuteFormat.format(oldTask.getTime()));
        gridBag.gridx = 2;
        gridBag.gridy = 5;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbMinutes, gridBag );
        panel.add( cmbMinutes );

        String []dataHours = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23" };
        cmbHours = new JComboBox( dataHours );
        cmbHours.setSelectedItem(hourFormat.format(oldTask.getTime()));
        gridBag.gridx = 1;
        gridBag.gridy = 5;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cmbHours, gridBag );
        panel.add( cmbHours );

        JButton btSave = new JButton("Save");
        gridBag.gridx = 3;
        gridBag.gridy = 6;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(btSave, gridBag );
        panel.add(btSave);
        btSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat taskFormat = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
                String days =(String) cmbDays.getSelectedItem();
                String monthes =(String) cmbMonthes.getSelectedItem();
                String years =(String) cmbYear.getSelectedItem();

                if ( TaskInfo.isDateIncorrect(Integer.parseInt(days),Integer.parseInt(monthes),Integer.parseInt(years))){
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Too many days for this month");
                } else if (TaskInfo.isNameIncorrect(txfTitle.getText())){
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Too short title");
                } else {
                    String seconds =(String) cmbSeconds.getSelectedItem();
                    String minutes =(String) cmbMinutes.getSelectedItem();
                    String hours =(String) cmbHours.getSelectedItem();
                    String myDate = days + monthes + years + " " + hours + ":" + minutes + ":" + seconds;
                    Date date = null;
                    try {
                        date = (Date)taskFormat.parse(myDate);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    taskTitle = txfTitle.getText();
                    Task newTask = new Task(taskTitle ,date);
                    newTask.setActive(cbActiveBox.isSelected());
                    getController().editTask(oldTask, newTask);
                    dispose();
                }
            }
        });

        cbActiveBox = new JCheckBox( "task is active"  );
        cbActiveBox.setSelected( oldTask.isActive() );
        gridBag.gridx = 1;
        gridBag.gridy = 6;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( cbActiveBox, gridBag );
        panel.add( cbActiveBox );
        this.add(panel);
    }
}
