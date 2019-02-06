package Model;

import java.io.*;
import java.util.*;

public class TaskIO {


    public static void write(TaskList tasks, OutputStream out) throws IOException {

        OutputStream os = new DataOutputStream(out);
        Iterator<Task> taskIterator = tasks.iterator();
        out.write(tasks.size());
        while (taskIterator.hasNext()){
            Task task = taskIterator.next();
            os.write(task.getTitle().length());
            os.write(task.getTitle().getBytes());
            ((DataOutputStream) os).writeBoolean(task.isActive());
            os.write(task.getRepeatInterval());
            ((DataOutputStream) os).writeBoolean(task.isRepeated());
            if (task.isRepeated()){
                ((DataOutputStream) os).writeLong(task.getStartTime().getTime());
                ((DataOutputStream) os).writeLong(task.getEndTime().getTime());
            }else {
                ((DataOutputStream) os).writeLong(task.getTime().getTime());
            }
        }
    }

    public static void read(TaskList tasks, InputStream in) throws IOException {
        InputStream inputStream = new DataInputStream(in);
        int size = inputStream.read();
        for (int i = 0; i < size;i++){
            int titleSize = inputStream.read();
            byte[] tmp = new byte[titleSize];
            for (int j = 0;j < titleSize; j++){
                tmp[j] = (byte) inputStream.read();
            }
            String title = new String(tmp);
            boolean tmpActive = ((DataInputStream) inputStream).readBoolean();
            int tmpInterval = inputStream.read();
            if (((DataInputStream) inputStream).readBoolean()){
                Date tmpStartTime = new Date(inputStream.read());
                Date tmpEndTime = new Date(inputStream.read());
                Task task = new Task(title,tmpStartTime,tmpEndTime,tmpInterval);
                task.setActive(tmpActive);
                tasks.add(task);
            }else{
                Date tmpTime = new Date(((DataInputStream) inputStream).readLong());
                Task task = new Task(title,tmpTime);
                task.setActive(tmpActive);
                tasks.add(task);
            }
        }
    }

    public static void writeBinary(TaskList tasks, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            write(tasks, fileOutputStream);
        }finally {
            fileOutputStream.close();
        }
    }

    public static void readBinary(TaskList tasks, File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            read(tasks, fileInputStream);
        }finally {
            fileInputStream.close();
        }
    }

    public static void write(TaskList tasks, Writer out) throws IOException {
        BufferedWriter output = new BufferedWriter(out);
        String myString;
        Task task ;
        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()){

            task = taskIterator.next();
            myString = "";
            myString +=  '"';
            for(int i = 0; i < task.getTitle().length();i++){
                myString+= task.getTitle().charAt(i);
            }

            myString +=  '"';

            if (task.isRepeated()) {
                Calendar startCal = new GregorianCalendar();
                startCal.setTime(task.getStartTime());
                Calendar endCal = new GregorianCalendar();
                endCal.setTime(task.getEndTime());

                //start
                myString += " from " + '[' + (startCal.get(Calendar.YEAR)) + '-' + startCal.get(Calendar.MONTH) + '-' + startCal.get(Calendar.DAY_OF_MONTH) + ' ' + startCal.get(Calendar.HOUR) + ':' + startCal.get(Calendar.MINUTE) + ':' + startCal.get(Calendar.SECOND)+ '.' + startCal.get(Calendar.MILLISECOND) + ']';

                //end
                myString += " to " + '[' + (endCal.get(Calendar.YEAR)) + '-' + endCal.get(Calendar.MONTH) + '-' + endCal.get(Calendar.DAY_OF_MONTH) + ' ' + endCal.get(Calendar.HOUR) + ':' + endCal.get(Calendar.MINUTE) + ':' + endCal.get(Calendar.SECOND)+ '.' + endCal.get(Calendar.MILLISECOND) + ']';

                //interval
                int interval = task.getRepeatInterval();
                myString += " [";
                final int day = 86400;
                final int hour = 3600;
                final int minute = 60;

                //DAY
                int fullTimes = interval % day;
                int numberOfIntervals = fullTimes *  day;
                interval -= numberOfIntervals * day;
                if (numberOfIntervals > 0) {
                    myString += numberOfIntervals + " " + "day";
                    if (numberOfIntervals >= 1) myString += 's';

                }

                //HOUR
                fullTimes = interval % hour;
                numberOfIntervals = fullTimes *  hour;
                interval -= numberOfIntervals * hour;
                if (numberOfIntervals > 0) {
                    myString += numberOfIntervals + " " + "hour";
                    if (numberOfIntervals >= 1) myString += 's';

                }

                //MINUTE
                fullTimes = interval % minute;
                numberOfIntervals = fullTimes *  minute;
                interval -= numberOfIntervals * minute;
                if (numberOfIntervals > 0) {
                    myString += numberOfIntervals + " " + "minute";
                    if (numberOfIntervals >= 1) myString += 's';

                }

                //SECONDE
                if (numberOfIntervals > 0) {
                    myString += numberOfIntervals + " " +"second";
                    if (numberOfIntervals >= 1) myString += 's';

                }

                myString+="]";
            }else {

                Calendar calendar = new GregorianCalendar();
                calendar.setTime(task.getTime());
                myString += " at " + '[' + (calendar.get(Calendar.YEAR)) + '-' + calendar.get(Calendar.MONTH) + '-' + calendar.get(Calendar.DAY_OF_MONTH) + ' ' + calendar.get(Calendar.HOUR) + ':' + calendar.get(Calendar.MINUTE) + ':' + calendar.get(Calendar.SECOND)+ '.' + calendar.get(Calendar.MILLISECOND) + ']';
            }

            if (task.isActive()){
                myString += " inactive";
            }

            if (taskIterator.hasNext()){
                myString+=';';
            }else {
                myString += '.';
            }

            output.write(myString);
            output.newLine();
            output.flush();
        }
    }

    public static void read(TaskList tasks, Reader in) throws IOException {
        BufferedReader reader = new BufferedReader(in);
        String myChecker ;

        while (reader.ready()){
            final int day = 86400;
            final int hour = 3600;
            final int minute = 60;
            int filePointer = 1;
            boolean repeated;
            myChecker = reader.readLine();
            String title = new String();
            while (true){
                if (myChecker.charAt(filePointer) == '"'){
                    if(myChecker.charAt(filePointer + 1) == '"'){
                        title+=myChecker.charAt(filePointer);
                        filePointer+=2;
                    }else{
                        filePointer+=2;
                        break;
                    }
                }else {
                    title+=myChecker.charAt(filePointer);
                    filePointer++;
                }
            }
            if (myChecker.charAt(filePointer) == 'a'){
                filePointer+=4;
                String data = new String();
                while (myChecker.charAt(filePointer) != ']'){
                    data+=myChecker.charAt(filePointer);
                    filePointer++;
                }
                filePointer+=2;
                Date time = parsDate(data);
                Task myTask = new Task(title,time);
                if (filePointer < myChecker.length()){
                    myTask.setActive(true);
                }
                tasks.add(myTask);
            }else{
                int inteval = 0;
                filePointer+=6;
                String data = new String();
                while (myChecker.charAt(filePointer) != ']'){
                    data+=myChecker.charAt(filePointer);
                    filePointer++;
                }
                filePointer+=6;
                Date startTime = parsDate(data);
                data = new String();
                while (myChecker.charAt(filePointer) != ']'){
                    data+=myChecker.charAt(filePointer);
                    filePointer++;
                }
                filePointer+=3;
                Date endTime = parsDate(data);
                while (myChecker.charAt(filePointer ) != ']'){
                    data = new String();
                    while (myChecker.charAt(filePointer) != ' ' && myChecker.charAt(filePointer + 1) != ']'){
                        data+=myChecker.charAt(filePointer);
                        filePointer++;
                    }
                    try {
                        int a = Integer.parseInt(data);
                        filePointer++;
                        switch (myChecker.charAt(filePointer)){

                            case 'd':
                                inteval+=a*day;
                                break;

                            case 'h':
                                inteval+=a*hour;
                                break;

                            case 'm':
                                inteval+=a*minute;
                                break;

                            case 's':
                                inteval+=a;
                                break;
                        }
                    }catch (NumberFormatException e){
                        filePointer++;
                    }
                }
                filePointer+=2;
                Task myTask = new Task(title,startTime,endTime,inteval);
                if (filePointer < myChecker.length()){
                    myTask.setActive(true);
                }
                tasks.add(myTask);
            }
        }
    }

    public static void writeText(TaskList tasks, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file,false);
        try {
            write(tasks, fileWriter);
        }finally {
            fileWriter.close();
        }
    }

    public static void readText(TaskList tasks, File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        try {
            read(tasks, fileReader);
        }finally {
            fileReader.close();
        }
    }

    public static Date parsDate(String pars){
        pars+=']';
        int curr = 0;
        Calendar time = new GregorianCalendar();
        char[] pointer = {'-','-',' ',':',':','.',']'};
        int [] dates = new int[7];
        for (int i = 0;i < 7;i++){
            int timeTemp;
            String tmp = new String();
            while (pars.charAt(curr) != pointer[i]){
                tmp+=pars.charAt(curr);
                curr++;
            }
            curr++;
            dates[i] = Integer.parseInt(tmp);
        }
        time.set(Calendar.YEAR,dates[0]);
        time.set(Calendar.MONTH,dates[1]);
        time.set(Calendar.DAY_OF_MONTH,dates[2]);
        time.set(Calendar.HOUR,dates[3]);
        time.set(Calendar.MINUTE,dates[4]);
        time.set(Calendar.SECOND,dates[5]);
        time.set(Calendar.MILLISECOND,dates[6]);
        Date myTime = new Date(time.getTimeInMillis());
        return myTime;
    }
}