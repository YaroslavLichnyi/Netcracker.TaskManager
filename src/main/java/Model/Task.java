package Model;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Task implements Cloneable{
    private String title;
    private Date time;
    private Date startTime;
    private Date endTime;
    private int interval;
    private final int doNot = -1;
    private boolean active;

    private static String text;
    private boolean repeated;
    private static final Logger log = Logger.getLogger(Task.class);

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public boolean isActive() {
        return active;
    }

    public boolean isRepeated() {
        return repeated;
    }

    public Date getTime() {
        if (!isRepeated()){
            return time;
        }
        return startTime;
    }

    public void setTime(int time) {
        if (isRepeated()){
            repeated = false;
            startTime.setTime(0);
            endTime.setTime(0);
        }
        this.time.setTime(time);
    }

    public void setTime(Date startTime, Date endTime, int interval) {
        if (!isRepeated()){
            time.setTime(0);
        }
        try {
            assert (interval != 0);
            repeated = true;
            this.startTime.setTime(startTime.getTime());
            this.endTime.setTime(endTime.getTime());
            this.interval = interval;
        } catch( Exception ex ) {
            log.error("Interval cannot be 0",ex);
        }
    }

    public Date getStartTime(){
        if (isRepeated()) {
            return startTime;
        }
        return time;
    }

    public Date getEndTime() {
        if (isRepeated()) {
            return endTime;
        }
        return time;
    }

    public int getRepeatInterval() {
        if (isRepeated()) {
            return interval;
        }
        return 0;
    }
    public void setTime(Date date){
        this.time = date;
    }

    public Date nextTimeAfter(Date currentTime){
        if ((repeated && (startTime==null || endTime == null) || (!repeated && time==null))) return null;
        if (currentTime==null) return null;
        if (isActive()){
            if (isRepeated()){
                if (currentTime.before(startTime)  ){
                    return startTime;
                }
                long nemberOfIntervals = (endTime.getTime() - startTime.getTime())/(interval*1000);
                long remainder = (endTime.getTime()-startTime.getTime())%(interval*1000);
                for (int i=0; i<nemberOfIntervals+1; i++){
                    if (currentTime.getTime() >= startTime.getTime() + (interval*1000*i) && currentTime.getTime() < endTime.getTime()-remainder-(interval*1000*(nemberOfIntervals-i-1) ) && currentTime.getTime() < endTime.getTime()-remainder){
                        Date myDate = new Date();
                        myDate.setTime(startTime.getTime() +(interval*1000 + interval*1000*i));
                        return myDate;
                    }
                }
            }
            try{
                if (currentTime.before(time) && isRepeated()==false){
                    return time;
                }
            } catch (Exception e){
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        if (active == task.active && this.title.equals(task.title) ) {
            if (this.repeated && task.repeated && this.startTime.equals(task.startTime) && this.endTime.equals(task.endTime)  && interval == task.interval) {
                return true;
            }
            if ( this.time.equals(task.time)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        Date date1 = new Date();
        Date date1_2 = new Date(nextTimeAfter(date1).getTime());
        return Objects.hash(title,nextTimeAfter(date1), nextTimeAfter(date1_2), doNot, active, repeated);
    }

    @Override
    public String toString() {
        SimpleDateFormat taskFormat = new SimpleDateFormat("[YYYY-MM-dd HH:mm:ss.SSS]");
        StringBuilder result = new StringBuilder();
        result.append("\"");
        result.append(getTitle());
        result.append("\"");
        if (isRepeated()) {
            result.append(" from ");
            result.append(taskFormat.format(this.startTime));
            result.append(" to ");
            result.append(taskFormat.format(this.endTime));
            result.append(TaskInfo.getIntervalInStr(interval));
        }
        else {
            result.append(" at ");
            result.append(taskFormat.format(time));
        }
        if (isActive()) result.append(" inactive");
        return result.toString();
    }

    @Override
    public Task clone()  {
        try {
            return (Task)super.clone();
        } catch( CloneNotSupportedException ex ) {
            log.error(ex);
            throw new InternalError();
        }
    }

    public Task(String title,  Date time) {
        this.title = title;
        this.time = time;
    }

    public Task(String title, Date startTime, Date end, int interval) {
            try {
                assert (interval != 0);
                this.repeated = true;
                this.title = title;
                this.startTime = startTime;
                this.endTime = end;
                this.interval = interval;
            } catch( Exception ex ) {
                log.error("Interval cannot be 0",ex);
            }
    }
}