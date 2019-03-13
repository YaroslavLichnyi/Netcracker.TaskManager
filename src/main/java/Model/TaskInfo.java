package Model;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskInfo {
    private static final Logger log = Logger.getLogger(TaskInfo.class);

    public static boolean isDateIncorrect(int days, int months, int years ){
        return (days == 31 && (months==4 || months == 6 || months == 9 || months == 11))
                || (days >= 30 && months == 2 && years % 4 == 0 && years % 100 != 0)
                || (days >= 29 && months == 2 && !((years % 4 == 0) && years % 100 != 0));
    }

    public  static boolean isNameIncorrect(String name){
        return name.length() == 0;
    }


    public  static Date createDate(String dateStr){
        SimpleDateFormat taskFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date date = null;
        try {
            date = (Date)taskFormat.parse(dateStr);
        } catch (ParseException e1) {
            log.error(e1);
            JFrame frame = new JFrame("Error");
            JOptionPane.showMessageDialog(frame, e1);
        }
        return date;
    }

    public static String getIntervalInStr(int interval){
        final int day = 86400;
        final int hour = 3600;
        final int minute = 60;
        StringBuilder result = new StringBuilder();
        result.append( " [");
        int intervalDays = (interval - interval%day)/day;
        interval = interval - intervalDays * day;
        if (intervalDays > 0) {
            result.append(" ");
            result.append(intervalDays);
            result.append(" ");
            result.append("day");
            if (intervalDays >= 1) result.append('s');
        }

        int intervalHours = (interval - interval%hour)/hour;
        interval = interval - intervalHours * hour;
        if (intervalHours > 0) {
            result.append(" ");
            result.append(intervalHours);
            result.append(" ");
            result.append("hour ");
            if (intervalHours >= 1) result.append('s');
        }

        int intervalMinutes = (interval - interval%minute)/minute;
        interval = interval - intervalMinutes * minute;
        if (intervalMinutes > 0) {
            result.append(" ");
            result.append(intervalMinutes);
            result.append(" ");
            result.append("minute");
            if (intervalMinutes >= 1) result.append('s');
        }

        if (interval > 0) {
            result.append(" ");
            result.append(interval);
            result.append(" ");
            result.append("second");

            if (interval >= 1) result.append('s');
        }
        result.append("]");
        return result.toString();
    }
}
