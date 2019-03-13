package View;

import Model.Task;

import javax.swing.*;

public abstract class RepeatedTaskFillingFormWithIntervalGUI extends RepeatedTaskFillingFormGUI {
    protected JComboBox cmbDaysInreval;
    protected JComboBox cmbSecondsInreval;
    protected JComboBox cmbMinutesInreval;
    protected JComboBox cmbHoursInreval;
    protected JComboBox cmbYearsInreval;
    protected JComboBox cmbMonthesInreval;
    protected JCheckBox cbActiveBox;

    protected String []dataDaysInterval = { "00", "01", "02", "03", "04", "05", "06", "07",
            "08", "09", "10", "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20", "21", "22", "23",
            "24", "25", "26", "27", "28", "29", "30", "31" };

    protected String []dataMonthesInterval = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12" };

    protected String []dataYearsInterval = {"00", "01", "02", "03", "04", "05" };

    protected int getInputedInterval(){
        return Integer.parseInt( (String) cmbSecondsInreval.getSelectedItem())
                + Integer.parseInt( (String) cmbMinutesInreval.getSelectedItem()) * 60
                + Integer.parseInt( (String) cmbHoursInreval.getSelectedItem())   * 60 * 60
                + Integer.parseInt( (String) cmbDaysInreval.getSelectedItem())    * 60 * 60 * 24
                + Integer.parseInt( (String) cmbMonthesInreval.getSelectedItem()) * 60 * 60 * 24 * 30
                + Integer.parseInt( (String) cmbYearsInreval.getSelectedItem())   * 60 * 60 * 24 * 365;
    }

    protected boolean isTimeCorrect(boolean repeated){
        if(repeated){
            if(isIncorrectStartTimeInputted() || isIncorrectEndTimeInputted() ){
                JFrame frame = new JFrame("Error");
                JOptionPane.showMessageDialog(frame, "Too many days for this month");
                return  false;
            }
            if (getInputedInterval() == 0){
                JFrame frame = new JFrame("Error");
                JOptionPane.showMessageDialog(frame, "Your interval must be at least 1 second (not 0)");
                return  false;
            }
            return true;
        } else {
            if(isIncorrectStartTimeInputted()){
                JFrame frame = new JFrame("Error");
                JOptionPane.showMessageDialog(frame, "Too many days for this month");
                return  false;
            }
        }
        return true;
    }

    protected Task getNewTask(String name, boolean repeated){
        Task newTask;
        if (repeated){
            newTask = new Task(name, getInputedStartTime(), getInputedEndTime(), getInputedInterval());
        } else {
            newTask = new Task(name, getInputedStartTime());
        }
        newTask.setActive(cbActiveBox.isSelected());
        return newTask;
    }
}
