package View;
import Controller.TaskManagerController;
import Model.ArrayTaskList;
import Model.Task;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class TaskManagerView  extends JFrame implements Observer {
    private TaskManagerController taskManagerController;
    private ArrayTaskList tasks;
    private JTable taskTable;
    private DefaultTableModel model;

    public TaskManagerView(ArrayTaskList arr, final TaskManagerController controller) throws HeadlessException {
        super("Task Manager");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 300, dimension.height / 2 - 200, 600, 400);
        this.tasks = arr;
        taskManagerController = controller;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        JPanel panel = new JPanel();

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBag = new GridBagConstraints();
        panel.setLayout( gridBagLayout );

        //ADD
        JButton addButton = new JButton("Add");
        gridBag.gridx = 1;
        gridBag.gridy = 1;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(addButton, gridBag );
        panel.add(addButton);

        //FIND
        JButton findButton = new JButton("Find");
        gridBag.gridx = 2;
        gridBag.gridy = 1;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(findButton, gridBag );
        panel.add(findButton);


        Object[] headers = {"Name", "Next time"};
        model = new DefaultTableModel(null, headers);
        taskTable = new JTable(model){
            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
        };
        //taskTable = new JTable(data, headers);
        JScrollPane scrollPane = new JScrollPane( taskTable );
        gridBag.gridx = 0;
        gridBag.gridy = 2;
        gridBag.gridwidth = 6;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( scrollPane, gridBag );
        panel.add( scrollPane );

        //CALLENDER (buttom)
        JButton callenderButton = new JButton("Callendar");
        gridBag.gridx = 3;
        gridBag.gridy = 1;
        gridBag.gridwidth = 2;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints(callenderButton, gridBag );
        panel.add(callenderButton);

        //нажатие на ячейку таблицы -> открывается детальная информакция об задаче
        taskTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //String str = String.valueOf(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
                System.out.println(String.valueOf(taskTable.getValueAt(taskTable.getSelectedRow(), taskTable.getSelectedColumn())));
                if (tasks.getTask(taskTable.getSelectedRow()).isRepeated()){
                    DetailInformationFrameRepeated detInfFrRep = new DetailInformationFrameRepeated(tasks.getTask(taskTable.getSelectedRow()),taskManagerController);
                } else {
                    DetailInformationFrame detInfFr = new DetailInformationFrame(tasks.getTask(taskTable.getSelectedRow()),taskManagerController);
                }


            }
        });

        //ACTIONS

        /*
         *Action of button "Add". Creates a window/frame with callender
         */
        callenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarFrame  calendar = new CalendarFrame(tasks, controller);
                calendar.setVisible(true);
            }
        });

        /*
         *Action of button "Callender". Creates a window/frame with creating tasks form
         */
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { ;
                AddFrame addFrame = new AddFrame(taskManagerController);
                addFrame.setVisible( true);
            }
        });

        /*
         *Action of button "Find".
         *Creates a window/frame with table of tasks in period of inputted data
         */
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //FindFrame findFrame = new FindFrame(tasks, fromField.getText(), toField.getText());
            }
        });

        this.add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateTable();
    }

    /*
     * Updates data and window
     */
    public void update(Observable o, Object arg) {
        ArrayTaskList arrayTaskList = (ArrayTaskList) arg;
        this.tasks = arrayTaskList;
        updateTable();
    }

    /*
     * Actions with table
     */
    private  void tableMouseClicked(MouseEvent event){
        DefaultTableModel def = (DefaultTableModel) taskTable.getModel();
        int selectedRow = taskTable.getSelectedRow();
        taskTable.clearSelection();
        System.out.println(def.getValueAt(selectedRow,0).toString());
    }

    private void updateTable(){
        final int tableRowSize = 10;
        //tasks.size();
        model.setRowCount(tableRowSize);
        Iterator<Task> taskIterator = tasks.iterator();
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
        while(i<tableRowSize){
            model.setValueAt(null, i , 0);
            model.setValueAt(null, i , 1);
            i++;
        }
        taskTable.repaint();
    }
}
