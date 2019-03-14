package Model;

public class Interval {
    int seconds;
    int minutes;
    int days;
    int hours;
    int months;
    int years;


    public Interval(int seconds) {
        this.seconds = seconds;
        calculateIntevals();
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getDays() {
        return days;
    }

    public int getHours() {
        return hours;
    }

    public int getMonths() {
        return months;
    }

    public int getYears() {
        return years;
    }


    public String getIntervalInShortStr(){
        String intervalInf = "";
        if (years > 0)   intervalInf += years + "y " ;
        if (months > 0) intervalInf += months + "m " ;
        if (days > 0)    intervalInf += days + "d " ;
        if (hours > 0)   intervalInf += hours + "h " ;
        if (minutes > 0) intervalInf += minutes + "min " ;
        if (seconds > 0)     intervalInf += seconds + "s " ;
        return intervalInf;
    }

    public static String getIntervalInFullStr(int interval){

        StringBuilder result = new StringBuilder();
        result.append( " [");
        int intervalDays = (interval - interval % SecondsIn.DAY)/SecondsIn.DAY;
        interval = interval - intervalDays * SecondsIn.DAY;
        if (intervalDays > 0) {
            result.append(" ");
            result.append(intervalDays);
            result.append(" ");
            result.append("day");
            if (intervalDays >= 1) result.append('s');
        }

        int intervalHours = (interval - interval % SecondsIn.HOUR)/SecondsIn.HOUR;
        interval = interval - intervalHours * SecondsIn.HOUR;
        if (intervalHours > 0) {
            result.append(" ");
            result.append(intervalHours);
            result.append(" ");
            result.append("hour ");
            if (intervalHours >= 1) result.append('s');
        }

        int intervalMinutes = (interval - interval % SecondsIn.MINUTE)/SecondsIn.MINUTE;
        interval = interval - intervalMinutes * SecondsIn.MINUTE;
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

    public void calculateIntevals(){
        years = (seconds - seconds % SecondsIn.YEAR)/SecondsIn.YEAR;
        seconds = seconds - years * SecondsIn.YEAR;

        months = (seconds - seconds % SecondsIn.MONTH)/SecondsIn.MONTH;
        seconds = seconds - months * SecondsIn.MONTH;

        days = (seconds - seconds % SecondsIn.DAY)/SecondsIn.DAY;
        seconds = seconds - days * SecondsIn.DAY;

        hours = (seconds - seconds % SecondsIn.HOUR)/SecondsIn.HOUR;
        seconds = seconds - hours * SecondsIn.HOUR;

        minutes = (seconds - seconds % SecondsIn.MINUTE)/SecondsIn.MINUTE;
        seconds = seconds - minutes * SecondsIn.MINUTE;
    }
}
