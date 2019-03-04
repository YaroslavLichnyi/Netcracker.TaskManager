package View;

import Model.TaskInfo;

import javax.swing.*;
import java.util.Date;

public abstract class TaskFillingFormGUI extends TaskManagerGUI{
    protected JComboBox cmbDays;
    protected JComboBox cmbMonthes;
    protected JComboBox cmbYear;
    protected JComboBox cmbSeconds;
    protected JComboBox cmbMinutes;
    protected JComboBox cmbHours;

    protected Date getInputedTime(){
        String days     =(String) cmbDays.getSelectedItem();
        String monthes  =(String) cmbMonthes.getSelectedItem();
        String years    =(String) cmbYear.getSelectedItem();
        String seconds  =(String) cmbSeconds.getSelectedItem();
        String minutes  =(String) cmbMinutes.getSelectedItem();
        String hours    =(String) cmbHours.getSelectedItem();
        String strDate  = days + monthes + years + hours + minutes + seconds;
        return TaskInfo.createDate(strDate);
    }

    protected boolean isInputedTimeIncorrect(){
        String days     =(String) cmbDays.getSelectedItem();
        String monthes  =(String) cmbMonthes.getSelectedItem();
        String years    =(String) cmbYear.getSelectedItem();
        return TaskInfo.isDateIncorrect(Integer.parseInt(days),Integer.parseInt(monthes),Integer.parseInt(years));
    }
}
