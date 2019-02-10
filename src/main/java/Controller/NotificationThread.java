package Controller;

import Model.ArrayTaskList;
import Model.Task;
import Model.TaskList;
import Model.Tasks;

import java.util.Date;
import java.util.Iterator;

public class NotificationThread extends Thread{
    private TaskList tasks;

    @Override
    public void run() {
        setDaemon(true);
        while (true){
            Date from = new Date();
            Date to = new Date(from.getTime() +60000);
           // ArrayTaskList arr = Tasks.incoming(tasks,from,to);

            Iterator<Task> taskIterator = tasks.iterator();
            while(taskIterator.hasNext()){
                Task task = taskIterator.next();
          //      if (task.nex)
            }
            try {
                sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public NotificationThread(TaskList tasks) {
        this.tasks = tasks;

    }
}
