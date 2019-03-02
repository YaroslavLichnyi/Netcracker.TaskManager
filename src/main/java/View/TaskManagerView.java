package View;
import Controller.TaskManagerController;
import Model.ArrayTaskList;
import Model.Task;
import javax.swing.*;
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

/**
 * Creates a main window which contains:
 *  1.List of tasks;
 *  2.Bottons
 */
public class TaskManagerView  extends TaskManagerGUI implements Observer {

    private ArrayTaskList tasks;
    private JTable taskTable;
    private DefaultTableModel model;

    public TaskManagerView(ArrayTaskList arr, final TaskManagerController taskManagerController) throws HeadlessException {
        super();
        setBounds(dimension.width / 2 - 300, dimension.height / 2 - 150, 600, 300);
        this.tasks = arr;

        setController(taskManagerController);
        addElements();
        setVisible(true);
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
    }

    /**
     * Updates information in the table.
     */
    private void updateTable(){
        final int tableRowSize = tasks.size();
        model.setRowCount(tableRowSize);
        Iterator<Task> taskIterator = tasks.iterator();
        Task task;
        int i = 0;
        while (taskIterator.hasNext()){
            task = taskIterator.next();
            model.setValueAt(task.getTitle(), i , 0);
            try {
                assert(task.nextTimeAfter(new Date())!= null);
                model.setValueAt(task.nextTimeAfter(new Date()), i , 1);
            } catch (Exception ex){
                model.setValueAt("-", i , 1);
            }
            i++;
        }
        while(i<tableRowSize){
            model.setValueAt(" ", i , 0);
            model.setValueAt(" ", i , 1);
            i++;
        }
        taskTable.repaint();
    }

    @Override
    protected void addElements() {
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
        taskTable.setGridColor(new Color(0, 128, 242));
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

        taskTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tasks.getTask(taskTable.getSelectedRow()) != null){
                    if (tasks.getTask(taskTable.getSelectedRow()).isRepeated()){
                        DetailInformationFrameRepeated detInfFrRep = new DetailInformationFrameRepeated(tasks.getTask(taskTable.getSelectedRow()),getController());
                    } else {
                        DetailInformationFrame detInfFr = new DetailInformationFrame(tasks.getTask(taskTable.getSelectedRow()),getController());
                    }
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
                CalendarFrame  calendar = new CalendarFrame(tasks, getController());
                calendar.setVisible(true);
            }
        });

        /*
         *Action of button "Callender". Creates a window/frame with creating tasks form
         */
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { ;
                AddFrame addFrame = new AddFrame(getController());
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
                FindFrame findFrame = new FindFrame(tasks, getController());
            }
        });

        this.add(panel);
    }
}
