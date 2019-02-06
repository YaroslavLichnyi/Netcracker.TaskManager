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
    public TaskManagerController() {

        tasks = new ArrayTaskList();
        readTasks();
/*
        SimpleDateFormat taskFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        String some = "03022019220000";
        String some1 = "23022019220000";
        String some2 = "25022019220000";

        try{
            Date date = (Date)taskFormat.parse(some);
            Task task = new Task("Reading", date);
            task.setActive(true);
            Date date1 =(Date)taskFormat.parse(some1);
            Date date2 =(Date)taskFormat.parse(some2);
            Task task1 = new Task("SomeMore", date1, date2, 2335446);
            tasks.add(task);
            tasks.add(task1);
        } catch (Exception e){
        }
        tasks.add(new Task("Football", new Date(1000000000), new Date(500000000), 100000));
        tasks.add(new Task("Coding", new Date(1000000000),new Date(400000000), 500000) );
        */
        view = new TaskManagerView(tasks, this);
        this.addObserver(view);
        TaskTableFrame taskTableFrame = new TaskTableFrame(tasks, this);


    }
    public void addTask(Task task){
        log.info("New task was added("+task.getTitle()+")");
        tasks.add(task);
        this.notifyObservers(tasks);
        view.update(this, tasks);

    }

    public void deleteTask(Task task){
        tasks.remove(task);
        this.notifyObservers(tasks);
        view.update(this, tasks);
    }
    public void editTask(Task oldTask, Task newTask ){
        this.deleteTask(oldTask);
        this.addTask(newTask);
    }
    public void writeTasks(){
        try {
            TaskIO.writeText(tasks, tasksTextFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readTasks(){
        try {
            TaskIO.readText(tasks, tasksTextFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
