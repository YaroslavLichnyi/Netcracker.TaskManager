package View;

import Controller.TaskManagerController;
import Model.Task;
import Model.TaskList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class TaskTableFrame extends JFrame {
    private JTable taskTable;
    private DefaultTableModel model;
    private TaskList mytasks;
    private TaskManagerController controller;
    public TaskTableFrame(TaskList tasks, TaskManagerController taskManagerController){
        super("Tasks");
        mytasks = tasks;
        controller = taskManagerController;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        JPanel panel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBag = new GridBagConstraints();
        panel.setLayout( gridBagLayout );


        Object[] headers = {"Name", "Next time"};
        model = new DefaultTableModel(null, headers);
        taskTable = new JTable(model){
            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
        };
        taskTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //String str = String.valueOf(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
                System.out.println(String.valueOf(taskTable.getValueAt(taskTable.getSelectedRow(), taskTable.getSelectedColumn())));
                if (mytasks.getTask(taskTable.getSelectedRow()).isRepeated()){
                    DetailInformationFrameRepeated detInfFrRep = new DetailInformationFrameRepeated(mytasks.getTask(taskTable.getSelectedRow()),controller);
                } else {
                    DetailInformationFrame detInfFr = new DetailInformationFrame(mytasks.getTask(taskTable.getSelectedRow()),controller);
                }


            }
        });
        gridBag.gridx = 1;
        gridBag.gridy = 1;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( taskTable, gridBag );
        panel.add( taskTable );
        model.setRowCount(10);
        Iterator<Task> taskIterator = tasks.iterator();
        Task task;
        int i = 0;
        while (taskIterator.hasNext()){
            task = taskIterator.next();
            model.setValueAt(task.getTitle(), i , 0);
            model.setValueAt("-", i , 1);
            i++;
        }
        taskTable.repaint();
        this.add(panel);
        this.setVisible(true);
    }
}
