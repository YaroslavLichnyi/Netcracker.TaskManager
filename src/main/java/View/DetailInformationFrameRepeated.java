package View;
import Controller.TaskManagerController;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailInformationFrameRepeated extends JFrame {
    JPanel panel;
    JLabel lbStartTime;
    JLabel lbTaskStartTime;
    JLabel lbTaskEndTime;
    JLabel lbEndTime;
    JButton btDelete;
    JButton btEdit;
    JLabel lbLbTaskActive;
    JLabel lbTitle;
    JLabel lbTaskTitle;
    JLabel lbInterval;
    private Task mytask;
    private TaskManagerController controller;

    public DetailInformationFrameRepeated(Task task, TaskManagerController taskManagerController) {
        super("Detail information");
        mytask = task;
        controller = taskManagerController;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        panel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        panel.setLayout( gridBagLayout );


        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        lbTaskStartTime = new JLabel( task.getStartTime().toString());
        lbTaskStartTime.setBackground( new Color( 153,184,240 ) );
        lbTaskStartTime.setForeground( new Color( 0,0,88 ) );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskStartTime, gbcPanel0 );
        panel.add(lbTaskStartTime);



        lbTaskStartTime = new JLabel( task.getEndTime().toString());
        lbTaskStartTime.setBackground( new Color( 153,184,240 ) );
        lbTaskStartTime.setForeground( new Color( 0,0,88 ) );
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

        final int day = 86400;
        int intervalDays = (interval - interval%day)/day;
        interval = interval - intervalDays * day;
        final int hour = 3600;
        int intervalHours = (interval - interval%hour)/hour;
        interval = interval - intervalHours * hour;
        final int minute = 60;
        int intervalMinutes = (interval - interval%minute)/minute;
        interval = interval - intervalMinutes * minute;

        lbTaskStartTime = new JLabel( intervalDays + "d " + intervalHours + "h "+ intervalMinutes+ "m "+interval +"s");
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

        lbTaskEndTime = new JLabel( "Start time" );
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

        lbEndTime = new JLabel( "End time"  );
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

        btDelete = new JButton( "Delete"  );
        btDelete.setBackground( new Color( 238,247,255 ) );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( btDelete, gbcPanel0 );
        panel.add( btDelete );

        btEdit = new JButton( "Edit"  );
        btEdit.setBackground( new Color( 238,247,255 ) );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( btEdit, gbcPanel0 );
        panel.add( btEdit );
        btEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditRepeatedTaskFrame editFrame = new EditRepeatedTaskFrame(mytask, controller);
            }
        });

        if(task.isActive()){
            lbLbTaskActive = new JLabel( "Task is active"  );
            lbLbTaskActive.setForeground(new Color(0, 255, 0));
        } else {
            lbLbTaskActive = new JLabel( "Task is not active "  );
            lbLbTaskActive.setForeground(new Color(255, 0, 0));
        }
        lbLbTaskActive.setBackground( new Color( 238,247,255 ) );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 4;
        gbcPanel0.gridwidth = 2;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbLbTaskActive, gbcPanel0 );
        panel.add( lbLbTaskActive );

        lbTitle = new JLabel( "Title"  );
        lbTitle.setBackground( new Color( 128,159,240 ) );
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

        lbTaskTitle = new JLabel(  task.getTitle()  );
        lbTaskTitle.setBackground( new Color( 128,159,240 ) );
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

        lbInterval = new JLabel( "Interval"  );
        lbInterval.setBackground( new Color( 206,230,240 ) );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbInterval, gbcPanel0 );
        panel.add(lbInterval);
        this.add(panel);
        this.setVisible(true);
    }
}




