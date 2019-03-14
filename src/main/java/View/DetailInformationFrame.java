package View;

import Controller.TaskManagerController;
import Model.Interval;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DetailInformationFrame extends TaskManagerGUI {
    private Task mytask;
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

        JLabel lbTaskActive;
        if(mytask.isActive()){
            lbTaskActive = new JLabel( "Task is active"  );
            lbTaskActive.setForeground(new Color(0, 255, 0));
        } else {
            lbTaskActive = new JLabel( "Task is not active "  );
            lbTaskActive.setForeground(new Color(255, 0, 0));
        }
        gridBag.gridx = 2;
        gridBag.gridy = 4;
        gridBag.gridwidth = 2;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(lbTaskActive, gridBag );
        panel.add(lbTaskActive);

        JButton btDelete = new JButton("Delete");
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
                new EditFrame(mytask, controller);
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

    private void addElementsForRepeatedTask(){
        Interval interval = new Interval(mytask.getRepeatInterval());
        JLabel lbTaskStartTime = new JLabel(mytask.getStartTime().toString());
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

        lbTaskStartTime = new JLabel(interval.getIntervalInShortStr());
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



}
