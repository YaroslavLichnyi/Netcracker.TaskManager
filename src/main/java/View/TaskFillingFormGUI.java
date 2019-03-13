package View;

import Model.TaskInfo;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public abstract class TaskFillingFormGUI extends TaskManagerGUI{
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

    protected String [] dataDays = { "01", "02", "03", "04", "05", "06", "07",
            "08", "09", "10", "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20", "21", "22", "23",
            "24", "25", "26", "27", "28", "29", "30", "31" };

    protected String []dataYears = {  "2019", "2020", "2021", "2022",
            "2023", "2024", "2025", "2026", "2027",  "2028",
            "2029", "2030", "2031", "2032", "2033", "2034",
            "2035", "2036", "2037", "2038", "2039", "2040",
            "2041", "2042", "2043", "2044", "2045", "2046",
            "2047", "2048", "2049", "2050" };

    protected String []dataSeconds = { "00", "01", "02", "03", "04", "05", "06", "07", "08",
            "09", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23", "24", "25", "26",
            "27", "28", "29", "30", "31", "32", "33", "34", "35",
            "36", "37", "38", "39", "40", "41", "42", "43", "44",
            "45", "46", "47", "48", "49", "50", "51", "52", "53",
            "54", "55", "56", "57", "58", "59" };

    protected String []dataMinutes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
            "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27",
            "28", "29", "30", "31", "32", "33", "34", "35", "36",
            "37", "38", "39", "40", "41", "42", "43", "44", "45",
            "46", "47", "48", "49", "50", "51", "52", "53", "54",
            "55", "56", "57", "58", "59" };

    protected String []dataHours = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
            "20", "21", "22", "23" };

    protected String []dataMonthes = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
            "10", "11", "12" };


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
            return null;
        }
        return TaskInfo.createDate(strDate);
    }

    protected boolean isIncorrectStartTimeInputted(){
        return isIncorrectTimeInputed(cmbDaysFrom, cmbMonthesFrom, cmbYearsFrom);
    }

    protected boolean isIncorrectEndTimeInputted(){
        return isIncorrectTimeInputed(cmbDaysTo, cmbMonthesTo, cmbYearsTo);
    }

    protected boolean isIncorrectTimeInputed(JComboBox days, JComboBox months, JComboBox years){
        String daysStr  =  (String) days.getSelectedItem();
        String monthsStr = (String) months.getSelectedItem();
        String yearsStr =  (String) years.getSelectedItem();
        return TaskInfo.isDateIncorrect(Integer.parseInt(daysStr),Integer.parseInt(monthsStr),Integer.parseInt(yearsStr));
    }


}
