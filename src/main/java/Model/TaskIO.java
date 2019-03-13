package Model;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

public class TaskIO {
    private static final Logger log = Logger.getLogger(TaskInfo.class);

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
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);){
            write(tasks, fileOutputStream);
        }
    }

    public static void readBinary(TaskList tasks, File file) throws IOException {
        try ( FileInputStream fileInputStream = new FileInputStream(file);){
            read(tasks, fileInputStream);
        }
    }

    public static void write(TaskList tasks, Writer out){
        try (BufferedWriter output = new BufferedWriter(out)) {
            Iterator<Task> taskIterator = tasks.iterator();
            while(taskIterator.hasNext()) {
                output.write(taskIterator.next().toString());
                if (taskIterator.hasNext()) output.write(";");
                else output.write(".");
                output.newLine();
                //output.flush();
            }
        } catch (IOException e) {
            log.error(e);
        }
    }

    public static void read(TaskList tasks, Reader in) throws IOException {
        BufferedReader reader = new BufferedReader(in);
        String myChecker;
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
        try(FileWriter fileWriter = new FileWriter(file,false);) {
            write(tasks, fileWriter);
        }
    }

    public static void readText(TaskList tasks, File file) throws IOException {
        try (FileReader fileReader = new FileReader(file);){
            read(tasks, fileReader);
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