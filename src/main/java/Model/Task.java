package Model;
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
    private boolean repeated;

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
            System.out.println("Interval cannot be 0");
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
            if ((repeated && (startTime==null || endTime == null) || (!repeated && time==null))) return null;
            if (currentTime==null) return null;
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
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", interval=" + interval +
                ", doNot=" + doNot +
                ", active=" + active +
                ", repeated=" + repeated +
                '}';
    }

    @Override
    public Task clone()  {
        try {
            return (Task)super.clone();
        } catch( CloneNotSupportedException ex ) {
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
                System.out.println("Interval cannot be 0");
            }
    }
}