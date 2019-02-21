package Controller;
import Model.TaskIO;
import org.apache.log4j.Logger;
import Model.ArrayTaskList;
import Model.Task;
import View.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;

public class TaskManagerController extends Observable {
    ArrayTaskList tasks ;
    TaskManagerView view ;
    private static final Logger log = Logger.getLogger(TaskManagerController.class);
    File tasksTextFile = new File("tasksForTaskManager.txt");
    File tasksFile = new File("TaskManagerTasks");

    public TaskManagerController() {

        tasks = new ArrayTaskList();
        readTasks();
        view = new TaskManagerView(tasks, this);
        this.addObserver(view);
        NotificationThread notificationThread = new NotificationThread(tasks);
        notificationThread.start();


    }
    public void addTask(Task task){
        log.info("New task was added("+task.getTitle()+")");
        tasks.add(task);
        this.notifyObservers(tasks);
        view.update(this, tasks);
        writeTasks();
    }

    public void deleteTask(Task task){
        log.info("Task was deleted("+task.getTitle()+")");
        tasks.remove(task);
        this.notifyObservers(tasks);
        view.update(this, tasks);
        writeTasks();

    }
    public void editTask(Task oldTask, Task newTask ){
        if(oldTask.getTitle()!=null && newTask.getTitle()!=null && !oldTask.getTitle().equals(newTask.getTitle())){
            log.info("Task was edited("+oldTask.getTitle()+" -> "+newTask.getTitle()+")");
        } else if(oldTask.getTitle()!=null && newTask.getTitle()!=null && oldTask.getTitle().equals(newTask.getTitle())) {
            log.info("Task was edited("+oldTask.getTitle()+")");
        }
        oldTask.setTitle(newTask.getTitle());
        oldTask.setActive(newTask.isActive());
        if (oldTask.isRepeated()){
            oldTask.setTime(newTask.getStartTime(), newTask.getEndTime(),newTask.getRepeatInterval());
        } else {
            oldTask.setTime(newTask.getTime());
        }

     /*   this.deleteTask(oldTask);
        this.addTask(newTask);*/
        this.notifyObservers(tasks);
        view.update(this, tasks);
        writeTasks();
    }
    public void writeTasks(){
        try {
               TaskIO.writeText(tasks, tasksTextFile);
            //  TaskIO.writeBinary(tasks, tasksFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readTasks(){
        try {
             TaskIO.readText(tasks, tasksTextFile);
            // TaskIO.readBinary(tasks, tasksFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
