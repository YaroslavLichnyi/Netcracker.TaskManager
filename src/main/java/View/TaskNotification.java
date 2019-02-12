package View;
import Model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.TrayIcon.MessageType;


public class TaskNotification {
    private Task task;

    public TaskNotification(Task task) {
    this.task = task;
    }

     public void displayTray() {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("TaskManager notification");
        try {
            tray.add(trayIcon);
            trayIcon.displayMessage("TaskManager", "Don't forget about " + task.getTitle(), MessageType.INFO);
        }  catch (AWTException e){
            JFrame frame = new JFrame("TaskManager");
            JOptionPane.showMessageDialog(frame, "Don't forget about " + task.getTitle());
        }
    }
}