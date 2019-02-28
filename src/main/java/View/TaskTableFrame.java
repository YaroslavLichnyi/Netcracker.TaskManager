package View;

import Controller.TaskManagerController;
import Model.Task;
import Model.TaskList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Iterator;

public class TaskTableFrame extends JFrame {
    private JTable taskTable;
    private DefaultTableModel model;
    private TaskList taskList;
    private TaskManagerController controller;
    public TaskTableFrame(TaskList tasks, TaskManagerController taskManagerController){
        super("Tasks");
        taskList = tasks;
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
                if (taskList.getTask(taskTable.getSelectedRow()).isRepeated()){
                    DetailInformationFrameRepeated detInfFrRep = new DetailInformationFrameRepeated(taskList.getTask(taskTable.getSelectedRow()),controller);
                } else {
                    DetailInformationFrame detInfFr = new DetailInformationFrame(taskList.getTask(taskTable.getSelectedRow()),controller);
                }
                dispose();
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
        this.updateTableData();
        this.add(panel);
        this.setVisible(true);
    }

    private void updateTableData(){
        model.setRowCount(taskList.size());
        Iterator<Task> taskIterator = taskList.iterator();
        Task task;
        int i = 0;
        while (taskIterator.hasNext()){
            task = taskIterator.next();
            model.setValueAt(task.getTitle(), i , 0);
            try {
                model.setValueAt(task.nextTimeAfter(new Date()), i , 1);
            } catch (Exception ex){
                model.setValueAt("-", i , 1);
            }
            i++;
        }
        taskTable.repaint();
    }
}
