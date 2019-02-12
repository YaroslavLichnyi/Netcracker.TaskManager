package Controller;

import Model.ArrayTaskList;
import Model.Task;
import Model.TaskList;
import Model.Tasks;
import View.TaskNotification;

import java.awt.*;
import java.util.Date;
import java.util.Iterator;

public class NotificationThread extends Thread{
    private ArrayTaskList tasks;

    @Override
    public void run() {
        while (true){
            Date from = new Date();
            Date to = new Date(from.getTime() +60000);
            ArrayTaskList arrayTaskList = tasks.clone();
            arrayTaskList = (ArrayTaskList) Tasks.incoming(arrayTaskList,from, to);
            Iterator <Task> taskIterator = arrayTaskList.iterator();
            while(taskIterator.hasNext()){
                Task task = taskIterator.next();
                TaskNotification td = new TaskNotification(task);
                td.displayTray();
            }
            System.out.println("Thread works");
            try {
                sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public NotificationThread(ArrayTaskList tasks) {
        super();
        this.tasks = tasks;
        setDaemon(true);
    }
}
