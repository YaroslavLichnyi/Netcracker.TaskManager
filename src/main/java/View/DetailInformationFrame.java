package View;

import Controller.TaskManagerController;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class DetailInformationFrame extends TaskManagerGUI {
    private Task mytask;

    DetailInformationFrame(Task task, TaskManagerController taskManagerController)  {
        super();
        mytask = task;
        setController(taskManagerController);
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        addElements();
        this.setVisible(true);
    }

    @Override
    protected void addElements() {
        panel.setLayout( gridBagLayout );

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

        JLabel lbLabel3 = new JLabel("Time");
        gridBag.gridx = 2;
        gridBag.gridy = 1;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLabel3, gridBag );
        panel.add(lbLabel3);

        JButton btDelete = new JButton("Delete");
        gridBag.gridx = 3;
        gridBag.gridy = 3;
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
        gridBag.gridx = 2;
        gridBag.gridy = 3;
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
                new EditTaskFrame(mytask, controller);
                dispose();
            }
        });

        JLabel lbLbTaskActive;
        if(mytask.isActive()){
            lbLbTaskActive = new JLabel( "Task is active"  );
            lbLbTaskActive.setForeground(new Color(0, 255, 0));
        } else {
            lbLbTaskActive = new JLabel( "Task is not active "  );
            lbLbTaskActive.setForeground(new Color(255, 0, 0));
        }

        gridBag.gridx = 2;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbLbTaskActive, gridBag );
        panel.add(lbLbTaskActive);
        this.add(panel);
    }
}
