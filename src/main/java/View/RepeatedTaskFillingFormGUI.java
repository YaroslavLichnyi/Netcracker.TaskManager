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
        String seconds =    (String) cmbSecondsFrom.getSelectedItem();
        String minutes =    (String) cmbMinutesFrom.getSelectedItem();
        String hours   =    (String) cmbHoursFrom.getSelectedItem();
        String days    =    (String) cmbDaysFrom.getSelectedItem();
        String monthes =    (String) cmbMonthesFrom.getSelectedItem();
        String years   =    (String) cmbYearsFrom.getSelectedItem();
        String strDateFrom = days + monthes + years + hours + minutes + seconds;
        return TaskInfo.createDate(strDateFrom);
    }

    protected  Date getInputedEndTime(){
        String seconds =    (String) cmbSecondsTo.getSelectedItem();
        String minutes =    (String) cmbMinutesTo.getSelectedItem();
        String hours   =    (String) cmbHoursTo.getSelectedItem();
        String days    =    (String) cmbDaysTo.getSelectedItem();
        String monthes =    (String) cmbMonthesTo.getSelectedItem();
        String years   =    (String) cmbYearsTo.getSelectedItem();
        String strDateTo = days + monthes + years + hours + minutes + seconds;
      //  getDate(cmbSecondsTo, )
        return TaskInfo.createDate(strDateTo);
    }

  /*  protected Date getDate(JComboBox cmbSeconds, JComboBox cmbMinutes, JComboBox cmbHours,
                 JComboBox cmbDays, JComboBox cmbMonthes, JComboBox cmbYears){
        String seconds =    (String) cmbSeconds.getSelectedItem();
        String minutes =    (String) cmbMinutes.getSelectedItem();
        String hours   =    (String) cmbHours.getSelectedItem();
        String days    =    (String) cmbDays.getSelectedItem();
        String monthes =    (String) cmbMonthes.getSelectedItem();
        String years   =    (String) cmbYears.getSelectedItem();
        String strDate = days + monthes + years + hours + minutes + seconds;
        return strDate;
    }*/

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
