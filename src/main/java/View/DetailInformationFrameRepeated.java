package View;

import Controller.TaskManagerController;
import Model.Task;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Shows detail information about repeated tasks.
 */
class DetailInformationFrameRepeated extends JFrame {
    private JPanel panel;
    /**
     * Information about this task is showed in the window.
     */
    private Task mytask;
    /**
     *
     */
    private TaskManagerController controller;

    DetailInformationFrameRepeated(Task task, TaskManagerController taskManagerController) {
        super("Detail information");
        mytask = task;
        controller = taskManagerController;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        panel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        panel.setLayout(gridBagLayout);


        JLabel lbTaskStartTime = new JLabel(task.getStartTime().toString());
        lbTaskStartTime.setBackground(new Color(153,184,240));
        lbTaskStartTime.setForeground(new Color(0,0,88));
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskStartTime, gbcPanel0);
        panel.add(lbTaskStartTime);

        lbTaskStartTime = new JLabel(task.getEndTime().toString());
        lbTaskStartTime.setBackground(new Color(153,184,240 ));
        lbTaskStartTime.setForeground(new Color(0,0,88 ));
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 2;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskStartTime, gbcPanel0 );
        panel.add(lbTaskStartTime);

        int interval = task.getRepeatInterval();
        final int year = 31536000;
        int intervalYears = (interval - interval % year)/year;
        interval = interval - intervalYears * year;
        final int month = 2592000;
        int intervalMonthes = (interval - interval % month)/month;
        interval = interval - intervalMonthes * month;
        final int day = 86400;
        int intervalDays = (interval - interval % day)/day;
        interval = interval - intervalDays * day;
        final int hour = 3600;
        int intervalHours = (interval - interval % hour)/hour;
        interval = interval - intervalHours * hour;
        final int minute = 60;
        int intervalMinutes = (interval - interval % minute)/minute;
        interval = interval - intervalMinutes * minute;
        String intervalInf = "";
        if (intervalYears > 0)   intervalInf += intervalYears   + "y " ;
        if (intervalMonthes > 0) intervalInf += intervalMonthes + "m " ;
        if (intervalDays > 0)    intervalInf += intervalDays    + "d " ;
        if (intervalHours > 0)   intervalInf += intervalHours   + "h " ;
        if (intervalMinutes > 0) intervalInf += intervalMinutes + "min " ;
        if (interval > 0)        intervalInf += interval        + "s " ;

        lbTaskStartTime = new JLabel(intervalInf);
        lbTaskStartTime.setBackground( new Color( 153,184,240 ) );
        lbTaskStartTime.setForeground( new Color( 0,0,88 ) );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskStartTime, gbcPanel0 );
        panel.add(lbTaskStartTime);

        JLabel lbTaskEndTime = new JLabel("Start time");
        lbTaskEndTime.setBackground( new Color( 153,184,240 ) );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskEndTime, gbcPanel0 );
        panel.add(lbTaskEndTime);

        JLabel lbEndTime = new JLabel("End time");
        lbEndTime.setBackground( new Color( 181,209,240 ) );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 2;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbEndTime, gbcPanel0 );
        panel.add(lbEndTime);

        JButton btDelete = new JButton("Delete");
        btDelete.setBackground( new Color( 238,247,255 ) );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(btDelete, gbcPanel0 );
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
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(btEdit, gbcPanel0 );
        panel.add(btEdit);
        btEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditRepeatedTaskFrame(mytask, controller);
                dispose();
            }
        });

        JLabel lbLbTaskActive;
        if(task.isActive()){
            lbLbTaskActive = new JLabel( "Task is active"  );
            lbLbTaskActive.setForeground(new Color(0, 255, 0));
        } else {
            lbLbTaskActive = new JLabel( "Task is not active "  );
            lbLbTaskActive.setForeground(new Color(255, 0, 0));
        }
        lbLbTaskActive.setBackground(new Color(238,247,255 ));
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 4;
        gbcPanel0.gridwidth = 2;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLbTaskActive, gbcPanel0 );
        panel.add(lbLbTaskActive);

        JLabel lbTitle = new JLabel("Title");
        lbTitle.setBackground(new Color(128,159,240));
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTitle, gbcPanel0 );
        panel.add(lbTitle);

        JLabel lbTaskTitle = new JLabel(task.getTitle());
        lbTaskTitle.setBackground( new Color(128,159,240));
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskTitle, gbcPanel0 );
        panel.add(lbTaskTitle);

        JLabel lbInterval = new JLabel("Interval");
        lbInterval.setBackground(new Color( 206,230,240));
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbInterval, gbcPanel0);
        panel.add(lbInterval);
        this.add(panel);
        this.setVisible(true);
    }
}




