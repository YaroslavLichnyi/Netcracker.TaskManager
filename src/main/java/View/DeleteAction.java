package View;

import Model.ArrayTaskList;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractAction{
    ArrayTaskList arr;
    Dimension dimension;
    Task task;

    public DeleteAction(ArrayTaskList arr, Dimension dimension, Task task) {
        this.arr = arr;
        this.dimension = dimension;
        this.task = task;

    }

    public void actionPerformed(ActionEvent e) {
        JFrame addFrame = new JFrame();
        addFrame.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
        //пока пустое окно
        arr.remove(task);
        addFrame.setVisible(true);
    }
}
