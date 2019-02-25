package Model;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskInfo {
    public static boolean isDateIncorrect(int days, int months, int years ){
        return (days == 31 && (months==4 || months == 6 || months == 9 || months == 11))
                || (days >= 30 && months == 02 && years % 4 == 0 && years % 100 != 0)
                || (days >= 29 && months == 02 && !((years % 4 == 0) && years % 100 != 0));
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
            JFrame frame = new JFrame("Error");
            JOptionPane.showMessageDialog(frame, e1);
            e1.printStackTrace();
        }
        return date;

    }
}
