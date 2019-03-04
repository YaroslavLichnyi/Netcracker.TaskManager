package View;

import Controller.TaskManagerController;
import javax.swing.*;
import java.awt.*;

public abstract class TaskManagerGUI extends JFrame {
    protected TaskManagerController controller;
    protected JPanel panel;
    protected GridBagLayout gridBagLayout ;
    protected GridBagConstraints gridBag ;
    protected Toolkit toolkit;
    protected Dimension dimension;

    public TaskManagerGUI() throws HeadlessException {
        super("Task Manager");
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        panel = new JPanel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        gridBag = new GridBagConstraints();
        gridBagLayout = new GridBagLayout();

    }

    public void setController(TaskManagerController controller) {
        this.controller = controller;
    }

    public TaskManagerController getController() {
        return controller;
    }

    protected abstract void addElements();
}