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
    private JButton addButton ;
    private JButton findButton;
    private JButton callenderButton;
    private JTextField fromField;
    private JTextField toField;
    private JLabel lbFrom;
    private JLabel lbTo;
    private JTable taskTable;
    private DefaultTableModel model;
    private JPanel panel;
    GridBagLayout gridBagLayout;
    GridBagConstraints gridBag;
    private Object[] headers = { "Name", "Next time" };

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

        panel = new JPanel();

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBag = new GridBagConstraints();
        panel.setLayout( gridBagLayout );

        //ADD
        addButton = new JButton( "Add"  );
        gridBag.gridx = 5;
        gridBag.gridy = 2;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( addButton, gridBag );
        panel.add( addButton );

        //FIND
        findButton = new JButton( "Find"  );
        gridBag.gridx = 5;
        gridBag.gridy = 0;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( findButton, gridBag );
        panel.add( findButton );

        //FROM (textField)
        fromField = new JTextField( );
        gridBag.gridx = 1;
        gridBag.gridy = 0;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( fromField, gridBag );
        panel.add( fromField );

        //TO (textField)
        toField = new JTextField( );
        gridBag.gridx = 4;
        gridBag.gridy = 0;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( toField, gridBag );
        panel.add( toField );

        //FROM (label)
        lbFrom = new JLabel( "From"  );
        gridBag.gridx = 0;
        gridBag.gridy = 0;
        gridBag.gridwidth = 1;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbFrom, gridBag );
        panel.add( lbFrom );

        //TO (label)
        lbTo = new JLabel( "To"  );
        gridBag.gridx = 2;
        gridBag.gridy = 0;
        gridBag.gridwidth = 2;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbTo, gridBag );
        panel.add( lbTo );


/*
        //TABLE
        Object[][] data = new Object[10][2];
        Iterator<Task> taskIterator = arr.iterator();
        Task task;
        if (arr.size() > 0){
            int i = 0;
            while (taskIterator.hasNext()){
                Date currentDate = new Date();
                task = taskIterator.next();
                //выводим название и время следующего выполнения этой задачи
                data[i][0] = task.getTitle();
               /* if(!task.isRepeated()){
                    if(task.getTime().after(currentDate)){
                        data[i][0] = task.getTitle();
                        data[i][1] = task.nextTimeAfter(currentDate).toString();
                    }
                } else if (task.isRepeated()){
                    if (! (task.nextTimeAfter(currentDate) == null)){
                        data[i][0] = task.getTitle();
                        data[i][1] = task.nextTimeAfter(currentDate).toString();
                    }
                }
                i++;
            }
        }

        */
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
        gridBag.gridy = 1;
        gridBag.gridwidth = 6;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( scrollPane, gridBag );
        panel.add( scrollPane );

        //CALLENDER (buttom)
        callenderButton = new JButton( "Callendar"  );
        gridBag.gridx = 3;
        gridBag.gridy = 2;
        gridBag.gridwidth = 2;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( callenderButton, gridBag );
        panel.add( callenderButton );

        //нажатие на ячейку таблицы -> открывается детальная информакция об задаче


 /*
        taskTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                System.out.println(taskTable.getValueAt(taskTable.getSelectedRow(), 0).toString());
            }
        });
                taskTable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                System.out.println("hello");
            }
        });
         */
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
/*

        taskTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
              //  System.out.println(taskTable.getValueAt(taskTable.getSelectedRow(), 0).toString());
                System.out.println("2");
            }
        });
        */

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
                FindFrame findFrame = new FindFrame(tasks, fromField.getText(), toField.getText());
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
        // ArrayTaskList arrayTaskList = (ArrayTaskList) arg;
        // this.tasks = arrayTaskList;
        updateTable();
        System.out.println("OBSERVER WORKS");
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
        model.setRowCount(10);
        Iterator<Task> taskIterator = tasks.iterator();
        Task task;
        int i = 0;
        while (taskIterator.hasNext()){
            task = taskIterator.next();
            model.setValueAt(task.getTitle(), i , 0); // в любом случае пишем число
            model.setValueAt("-", i , 1); // в любом случае пишем число
            i++;
        }
        taskTable.repaint();
    }
}