package View;

import Controller.TaskManagerController;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DetailInformationFrame extends JFrame {
    private JPanel panel;
    private JLabel lbLbTaskTitle;
    private JLabel lbIbTaskTime;
    private JLabel lbLabel2;
    private JLabel lbLabel3;
    private JButton btDelete;
    private JButton btEdit;
    private JLabel lbLbTaskActive;
    private Task mytask;
    private TaskManagerController controller;

    public DetailInformationFrame(Task task, TaskManagerController taskManagerController)  {
        super("Detail information");
        mytask = task;
        controller = taskManagerController;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);

        panel = new JPanel();
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        panel.setLayout( gbPanel0 );

        lbLbTaskTitle = new JLabel( task.getTitle()  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbLbTaskTitle, gbcPanel0 );
        panel.add( lbLbTaskTitle );

        lbIbTaskTime = new JLabel( task.getTime().toString());
        lbIbTaskTime.setBackground( new Color( 245,249,252 ) );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbIbTaskTime, gbcPanel0 );
        panel.add( lbIbTaskTime );

        lbLabel2 = new JLabel( "Title"  );
        lbLabel2.setBackground( new Color( 227,230,255 ) );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbLabel2, gbcPanel0 );
        panel.add( lbLabel2 );

        lbLabel3 = new JLabel( "Time"  );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbLabel3, gbcPanel0 );
        panel.add( lbLabel3 );

        btDelete = new JButton( "Delete"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btDelete, gbcPanel0 );
        panel.add( btDelete );
        btDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  controller.deleteTask(mytask);
            }
        });

        btEdit = new JButton( "Edit"  );
        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btEdit, gbcPanel0 );
        panel.add( btEdit );
        btEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditTaskFrame editFrame = new EditTaskFrame(mytask, controller);
            }
        });


        if(task.isActive()){
            lbLbTaskActive = new JLabel( "Task is active"  );
            lbLbTaskActive.setForeground(new Color(0, 255, 0));
        } else {
            lbLbTaskActive = new JLabel( "Task is not active "  );
            lbLbTaskActive.setForeground(new Color(255, 0, 0));
        }

        gbcPanel0.gridx = 2;
        gbcPanel0.gridy = 2;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbLbTaskActive, gbcPanel0 );
        panel.add( lbLbTaskActive );
        this.add(panel);

        this.setVisible(true);
    }
}
