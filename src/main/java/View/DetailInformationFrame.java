package View;

import Controller.TaskManagerController;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DetailInformationFrame extends TaskManagerGUI {
    private Task mytask;
    private int interval ;
    private int intervalYears;
    private int intervalMonthes ;
    private int intervalDays;
    private int intervalHours ;
    private int intervalMinutes;
    public DetailInformationFrame(Task task, TaskManagerController taskManagerController)  {
        super();
        mytask = task;
        setController(taskManagerController);
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        addElements();
        this.setVisible(true);
    }

    @Override
    protected void addElements() {
        JLabel lbLabel2 = new JLabel("Title");
        lbLabel2.setBackground( new Color( 227,230,255 ) );
        gridBag.gridx = 2;
        gridBag.gridy = 0;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLabel2, gridBag );
        panel.add(lbLabel2);


        JLabel lbLbTaskTitle = new JLabel(mytask.getTitle());
        gridBag.gridx = 3;
        gridBag.gridy = 0;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLbTaskTitle, gridBag );
        panel.add(lbLbTaskTitle);

        if (mytask.isRepeated()) addElementsForRepeatedTask();
        else addElementsForNonRepeatedTask();

        JLabel lbLbTaskActive;
        if(mytask.isActive()){
            lbLbTaskActive = new JLabel( "Task is active"  );
            lbLbTaskActive.setForeground(new Color(0, 255, 0));
        } else {
            lbLbTaskActive = new JLabel( "Task is not active "  );
            lbLbTaskActive.setForeground(new Color(255, 0, 0));
        }
        lbLbTaskActive.setBackground(new Color(238,247,255 ));
        gridBag.gridx = 2;
        gridBag.gridy = 4;
        gridBag.gridwidth = 2;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLbTaskActive, gridBag );
        panel.add(lbLbTaskActive);

        JButton btDelete = new JButton("Delete");
        btDelete.setBackground( new Color( 238,247,255 ) );
        gridBag.gridx = 3;
        gridBag.gridy = 5;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(btDelete, gridBag );
        panel.add(btDelete);
        btDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.deleteTask(mytask);
                dispose();
            }
        });

        JButton btEdit = new JButton("Edit");
        btEdit.setBackground( new Color( 238,247,255 ) );
        gridBag.gridx = 2;
        gridBag.gridy = 5;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(btEdit, gridBag );
        panel.add(btEdit);
        btEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // repeated or not repeated
               // new EditRepeatedTaskFrame(mytask, controller);
                dispose();
            }
        });
        this.add(panel);
    }

    private void addElementsForNonRepeatedTask(){
        JLabel label = new JLabel("Time");
        gridBag.gridx = 2;
        gridBag.gridy = 1;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(label, gridBag );
        panel.add(label);

        JLabel lbIbTaskTime = new JLabel(mytask.getTime().toString());
        lbIbTaskTime.setBackground( new Color( 245,249,252 ) );
        gridBag.gridx = 3;
        gridBag.gridy = 1;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbIbTaskTime, gridBag );
        panel.add(lbIbTaskTime);

    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private void addElementsForRepeatedTask(){

        calculateIntevals();



        JLabel lbTaskStartTime = new JLabel(mytask.getStartTime().toString());
        lbTaskStartTime.setBackground(new Color(153,184,240));
        lbTaskStartTime.setForeground(new Color(0,0,88));
        gridBag.gridx = 3;
        gridBag.gridy = 1;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskStartTime, gridBag);
        panel.add(lbTaskStartTime);

        lbTaskStartTime = new JLabel(mytask.getEndTime().toString());
        lbTaskStartTime.setBackground(new Color(153,184,240 ));
        lbTaskStartTime.setForeground(new Color(0,0,88 ));
        gridBag.gridx = 3;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskStartTime, gridBag );
        panel.add(lbTaskStartTime);

        lbTaskStartTime = new JLabel(getTimeInformation());
        lbTaskStartTime.setBackground( new Color( 153,184,240 ) );
        lbTaskStartTime.setForeground( new Color( 0,0,88 ) );
        gridBag.gridx = 3;
        gridBag.gridy = 3;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskStartTime, gridBag );
        panel.add(lbTaskStartTime);

        JLabel lbTaskEndTime = new JLabel("Start time");
        lbTaskEndTime.setBackground( new Color( 153,184,240 ) );
        gridBag.gridx = 2;
        gridBag.gridy = 1;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskEndTime, gridBag );
        panel.add(lbTaskEndTime);

        JLabel lbEndTime = new JLabel("End time");
        lbEndTime.setBackground( new Color( 181,209,240 ) );
        gridBag.gridx = 2;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbEndTime, gridBag );
        panel.add(lbEndTime);







        JLabel lbInterval = new JLabel("Interval");
        lbInterval.setBackground(new Color( 206,230,240));
        gridBag.gridx = 2;
        gridBag.gridy = 3;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbInterval, gridBag);
        panel.add(lbInterval);
        this.add(panel);

    }

    private void calculateIntevals(){
        final int SECONDS_IN_A_YEAR = 31536000;
        final int SECONDS_IN_A_MONTH = 2592000;
        final int SECONDS_IN_A_DAY = 86400;
        final int SECONDS_IN_AN_HOUR = 3600;
        final int SECONDS_IN_A_MINUTE = 60;

        interval = mytask.getRepeatInterval();

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

    private String getTimeInformation(){
        String intervalInf = "";
        if (intervalYears > 0)   intervalInf += intervalYears   + "y " ;
        if (intervalMonthes > 0) intervalInf += intervalMonthes + "m " ;
        if (intervalDays > 0)    intervalInf += intervalDays    + "d " ;
        if (intervalHours > 0)   intervalInf += intervalHours   + "h " ;
        if (intervalMinutes > 0) intervalInf += intervalMinutes + "min " ;
        if (interval > 0)        intervalInf += interval        + "s " ;
        return intervalInf;
    }
}
