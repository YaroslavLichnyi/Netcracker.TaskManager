package Controller;

import Model.ArrayTaskList;
import Model.Task;
import Model.Tasks;
import View.TaskNotification;
import java.util.Date;
import java.util.Iterator;

/**
 * This is a deamon thread, which create a notification, when task time comes.
 */
public class NotificationThread extends Thread {
    /**
     * Tasks, that are checked.
     */
    private ArrayTaskList tasks;

    @Override
    public void run() {
        while (true){
            Date from = new Date();
            Date to = new Date(from.getTime() + 2000);
            ArrayTaskList arrayTaskList  = (ArrayTaskList) Tasks.incoming(tasks, from, to);
            Iterator<Task> taskIterator = arrayTaskList.iterator();
            while(taskIterator.hasNext()){
                Task task = taskIterator.next();
                TaskNotification td = new TaskNotification(task);
                td.displayTray();
            }
            try {
                sleep(1000);
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
