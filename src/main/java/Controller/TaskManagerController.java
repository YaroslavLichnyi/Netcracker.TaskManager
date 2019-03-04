package Controller;
import Model.*;
import org.apache.log4j.Logger;
import View.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Observable;

public class TaskManagerController extends Observable {
    private static final TaskManagerController instance = new TaskManagerController();
    ArrayTaskList tasks ;
    TaskManagerView view ;
    private static final Logger log = Logger.getLogger(TaskManagerController.class);
    File tasksTextFile = new File("tasksForTaskManager.txt");
    File tasksFile = new File("TaskManagerTasks");

    private TaskManagerController() {

        tasks = new ArrayTaskList();
        readTasks();
        view = new TaskManagerView(tasks, this);
        this.addObserver(view);
        NotificationThread notificationThread = new NotificationThread(tasks);
        notificationThread.start();
    }

    public static TaskManagerController getInstance() {
        return instance;
    }

    /**
     * Adds the task to the list.
     * @param task will be added to list of tasks.
     */
    public void addTask(Task task){
        log.info("New task was added("+task.getTitle()+")");
        tasks.add(task);
        this.notifyObservers(tasks);
        view.update(this, tasks);
        writeTasks();
    }

    /**
     * Deletes the task from the list.
     * @param task will be deleted from list of tasks.
     */
    public void deleteTask(Task task){
        log.info("Task was deleted("+task.getTitle()+")");
        tasks.remove(task);
        this.notifyObservers(tasks);
        view.update(this, tasks);
        writeTasks();

    }

    /**
     * Modifies task properties.
     * Properties of oldTask are replaces with properties of newTasl.
     * @param oldTask is a task, that will be replaces by newTask
     * @param newTask updated task, that will replace oldTask
     */
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
        this.notifyObservers(tasks);
        view.update(this, tasks);
        writeTasks();
    }

    /**
     * Writes list of tasks to file.
     */
    public void writeTasks(){
        try {
               TaskIO.writeText(tasks, tasksTextFile);
            //  TaskIO.writeBinary(tasks, tasksFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read list of tasks from file. List of tasks gets data from the file.
     */
    public void readTasks(){
        try {
             TaskIO.readText(tasks, tasksTextFile);
            // TaskIO.readBinary(tasks, tasksFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayTaskList findTasksByTime (ArrayTaskList taskList,Date from, Date to){
            ArrayTaskList arr = (ArrayTaskList) Tasks.incoming(taskList, from, to);
            if (arr.size()>0){
                return arr;
            } else {
                JFrame frame = new JFrame("Error");
                JOptionPane.showMessageDialog(frame, "No tasks were found");
            }
        return  null;
    }

    public ArrayTaskList findTasksByTitle (ArrayTaskList taskList, String name){
        if (TaskInfo.isNameIncorrect(name)){
            JFrame frame = new JFrame("Error");
            JOptionPane.showMessageDialog(frame, "Too short title");
        } else {
            Iterator<Task> taskIterator = taskList.iterator();
            ArrayTaskList arrayTaskList = new ArrayTaskList();
            Task task;
            while (taskIterator.hasNext()){
                task = taskIterator.next();
                if (task.getTitle().toLowerCase().contains(name.toLowerCase())){
                    arrayTaskList.add(task);
                }
            }
            if (arrayTaskList.size()>0){
                return arrayTaskList;
            } else {
                JFrame frame = new JFrame("Error");
                JOptionPane.showMessageDialog(frame, "No tasks were found");
            }
        }
        return  null;
    }

}
