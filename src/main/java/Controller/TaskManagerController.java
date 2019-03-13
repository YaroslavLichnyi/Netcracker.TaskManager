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
    private ArrayTaskList tasks ;
    private TaskManagerView view ;
    private static final Logger log = Logger.getLogger(TaskManagerController.class);
    private File tasksTextFile = new File("tasksForTaskManager.txt");

    public TaskManagerController() {
        tasks = new ArrayTaskList();
        readTasks();
        view = new TaskManagerView(tasks, this);
        this.addObserver(view);
        NotificationThread notificationThread = new NotificationThread(tasks, this);
        notificationThread.start();
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

    public void updateTasks(){
        view.update(this, tasks);
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

    public void notifyOb(){
        this.notifyObservers(tasks);
    }

    /**
     * Writes list of tasks to file.
     */
    public void writeTasks(){
        try {
               TaskIO.writeText(tasks, tasksTextFile);
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * Read list of tasks from file. List of tasks gets data from the file.
     */
    public void readTasks(){
        try {
             TaskIO.readText(tasks, tasksTextFile);
        } catch (IOException e) {
            log.error(e);
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
    public ArrayTaskList findTasksByTimeAndTitle (ArrayTaskList taskList,Date from, Date to, String name){
        ArrayTaskList arr = findTasksByTitle(taskList, name);
        if (arr != null && arr.size()>0){
          arr = findTasksByTime(taskList, from, to);
            if (arr != null && arr.size()>0){
                return arr;
            }
        }
        JFrame frame = new JFrame("Error");
        JOptionPane.showMessageDialog(frame, "No tasks were found");
        return  null;
    }
}
