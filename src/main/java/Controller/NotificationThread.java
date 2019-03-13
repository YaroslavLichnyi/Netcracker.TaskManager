package Controller;

import Model.ArrayTaskList;
import Model.Task;
import Model.Tasks;
import View.TaskNotification;
import org.apache.log4j.Logger;

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
    private TaskManagerController controller;
    private static final Logger log = Logger.getLogger(NotificationThread.class);
    private boolean needToUpdateData;

    @Override
    public void run() {
        while (true){
            needToUpdateData = false;
            Date from = new Date(new Date().getTime() - 500);
            Date to = new Date(from.getTime() + 1000);
            ArrayTaskList arrayTaskList  = (ArrayTaskList) Tasks.incoming(tasks, from, to);
            Iterator<Task> taskIterator = arrayTaskList.iterator();
            while(taskIterator.hasNext()){
                Task task = taskIterator.next();
                TaskNotification td = new TaskNotification(task);
                td.displayTray();
                needToUpdateData = true;
            }
            try {
                sleep(1000);
                controller.updateTasks();
            } catch (InterruptedException e) {
                log.error(e);
            }
        }
    }

    public NotificationThread(ArrayTaskList tasks, TaskManagerController controller) {
        super();
        this.tasks = tasks;
        this.controller = controller;
        setDaemon(true);
    }
}
