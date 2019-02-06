package View;

import Model.ArrayTaskList;
import Model.Task;
import Model.Tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class FindFrame {
    JTextField titleField;  //текстовое поле с названием задачи
    JTextField timeField;   //текстовое поле со временем
    ArrayTaskList arr;
    Date from;
    Date to;

    public FindFrame(ArrayTaskList arr, String timeFrom, String timeTo)  {
        this.arr = arr;
        try{
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");
            from = format.parse(timeFrom);
            to = format.parse(timeTo);
        } catch (Exception ex){

        }


        JPanel pnPanel0;
        JLabel lbFrom;
        JTextField tfFromText;
        JLabel lbLabel3;
        JTextField tfText1;
        JLabel lbLabel4;
        JTextField tfText2;
        JButton btBut0;
    }

    public void actionPerformed(ActionEvent e) {
        JPanel panel;
        JLabel lbTitle;
        JLabel lbFrom;
        JLabel lbTo;
        JTextField titleField;
        JTextField fromField;
        JTextField toField;

        JButton findBotton;

        JFrame addFrame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        addFrame.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        panel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBag = new GridBagConstraints();
        panel.setLayout( gridBagLayout );

        ArrayTaskList selectedTasks = (ArrayTaskList) Tasks.incoming(arr,from,to);

        Object[] headers = { "Name", "Next time" };
        Object[][] data = new Object[selectedTasks.size()][2];
        Iterator<Task> taskIterator = selectedTasks.iterator();
        Task task;
        int i = 0;
        while (taskIterator.hasNext()){
            task = taskIterator.next();
            data[i][0] = task.getTitle();
            data[i][1] = task.nextTimeAfter(new Date(1));
            i++;
        }
        String []colsTable0 = new String[] { "", "" };
        JTable taskTable = new JTable(data, headers);
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


/*
        lbFrom = new JLabel( "From"  );
        gridBag.gridx = 2;
        gridBag.gridy = 6;
        gridBag.gridwidth = 3;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbFrom, gridBag );
        panel.add( lbFrom );

        fromField = new JTextField( );
        gridBag.gridx = 2;
        gridBag.gridy = 7;
        gridBag.gridwidth = 7;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( fromField, gridBag );
        panel.add( fromField );

        lbTo = new JLabel( "To"  );
        gridBag.gridx = 2;
        gridBag.gridy = 10;
        gridBag.gridwidth = 3;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbTo, gridBag );
        panel.add( lbTo );

        toField = new JTextField( );
        gridBag.gridx = 2;
        gridBag.gridy = 11;
        gridBag.gridwidth = 7;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( toField, gridBag );
        panel.add( toField );

        lbTitle = new JLabel( "Title"  );
        gridBag.gridx = 2;
        gridBag.gridy = 2;
        gridBag.gridwidth = 3;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( lbTitle, gridBag );
        panel.add( lbTitle );

        titleField = new JTextField( );
        gridBag.gridx = 2;
        gridBag.gridy = 3;
        gridBag.gridwidth = 7;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( titleField, gridBag );
        panel.add( titleField );

        findBotton = new JButton( "Find"  );
        gridBag.gridx = 8;
        gridBag.gridy = 18;
        gridBag.gridwidth = 5;
        gridBag.gridheight = 1;
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 1;
        gridBag.weighty = 0;
        gridBag.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( findBotton, gridBag );
        panel.add( findBotton );
        */
        addFrame.add(panel);
        addFrame.setVisible(true);





/*

        JPanel panel = new JPanel();
        timeField = new JTextField();

        Iterator<Task> taskIterator = arr.iterator();
        //выводит все задачи

        while (taskIterator.hasNext()){
            panel.add(new JLabel(taskIterator.next().toString()));
        }
        addFrame.setVisible(true);
        */
    }
}
