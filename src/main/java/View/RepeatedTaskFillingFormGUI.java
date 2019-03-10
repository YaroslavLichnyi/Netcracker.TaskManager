package View;

import Model.TaskInfo;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public abstract class RepeatedTaskFillingFormGUI extends TaskManagerGUI{
    protected JComboBox cmbDaysFrom;
    protected JComboBox cmbMonthesFrom;
    protected JComboBox cmbYearsFrom;
    protected JComboBox cmbSecondsFrom;
    protected JComboBox cmbMinutesFrom;
    protected JComboBox cmbHoursFrom;
    protected JComboBox cmbDaysTo;
    protected JComboBox cmbMonthesTo;
    protected JComboBox cmbYearsTo;
    protected JComboBox cmbSecondsTo;
    protected JComboBox cmbMinutesTo;
    protected JComboBox cmbHoursTo;

    public RepeatedTaskFillingFormGUI() throws HeadlessException {
        super();
    }

    protected Date getInputedStartTime(){
        return getDate(cmbSecondsFrom, cmbMinutesFrom, cmbHoursFrom, cmbDaysFrom, cmbMonthesFrom, cmbYearsFrom);
    }

    protected  Date getInputedEndTime(){
        return getDate(cmbSecondsTo, cmbMinutesTo, cmbHoursTo, cmbDaysTo, cmbMonthesTo, cmbYearsTo);
    }

    protected Date getDate(JComboBox cmbSeconds, JComboBox cmbMinutes, JComboBox cmbHours,
                 JComboBox cmbDays, JComboBox cmbMonthes, JComboBox cmbYears){
        String seconds =    (String) cmbSeconds.getSelectedItem();
        String minutes =    (String) cmbMinutes.getSelectedItem();
        String hours   =    (String) cmbHours.getSelectedItem();
        String days    =    (String) cmbDays.getSelectedItem();
        String months  =    (String) cmbMonthes.getSelectedItem();
        String years   =    (String) cmbYears.getSelectedItem();
        String strDate = days + months + years + hours + minutes + seconds;
        if (TaskInfo.isDateIncorrect(Integer.parseInt(days),Integer.parseInt(months),Integer.parseInt(years))){
            return TaskInfo.createDate(strDate);
        }
        return null;
    }

    protected boolean isIncorrectTimeInputed(){
        String daysFrom  =  (String) cmbDaysFrom.getSelectedItem();
        String monthesFrom =(String) cmbMonthesFrom.getSelectedItem();
        String yearsFrom =  (String) cmbYearsFrom.getSelectedItem();
        String daysTo    =  (String) cmbDaysTo.getSelectedItem();
        String monthesTo =  (String) cmbMonthesTo.getSelectedItem();
        String yearsTo   =  (String) cmbYearsTo.getSelectedItem();
        return TaskInfo.isDateIncorrect(Integer.parseInt(daysFrom),Integer.parseInt(monthesFrom),Integer.parseInt(yearsFrom))
                || TaskInfo.isDateIncorrect(Integer.parseInt(daysTo),Integer.parseInt(monthesTo),Integer.parseInt(yearsTo));
    }
}
