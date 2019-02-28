package Model;
import java.io.Serializable;
import java.util.*;


public class Tasks implements Serializable {
  public static SortedMap<Date, Set<Task>> calendar(Iterable<Task> tasks, Date start, Date end){
        Task myTask ;
        Date myDate ;
        HashSet<Task> mySet = new HashSet<Task>();
        TreeMap<Date, Set<Task>> myFutureMap  = new TreeMap<Date, Set<Task>>();
        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()){
            myTask = taskIterator.next();
            myDate = (Date) start.clone();
            while (myTask.nextTimeAfter(myDate)!=null && !(myTask.nextTimeAfter(myDate).after(end))){
                if (myFutureMap.get(myTask.nextTimeAfter(myDate))==null){
                    mySet = new HashSet<Task>();
                    mySet.add(myTask);
                    myFutureMap.put(myTask.nextTimeAfter(myDate), mySet);
                }else {
                    mySet = (HashSet<Task>) myFutureMap.get(myTask.nextTimeAfter(myDate));
                    mySet.add(myTask);
                    myFutureMap.put(myTask.nextTimeAfter(myDate), mySet);
                }
                myDate.setTime(myTask.nextTimeAfter(myDate).getTime());
            }
        }
        return  myFutureMap;
    }

    public static Iterable<Task> incoming (Iterable<Task> tasks, Date start, Date end){
      TaskList result;
      if (tasks instanceof ArrayTaskList){
          result = new ArrayTaskList();
      } else result = new LinkedTaskList();
        Iterator<Task> taskIterator = tasks.iterator();
        while ( taskIterator.hasNext() ){
            Task myTask = taskIterator.next();
            if (!(myTask.nextTimeAfter(start)==null || myTask.nextTimeAfter(start).after(end))){
                //taskIterator.remove();
                result.add(myTask);
            }
        }
        return result;
    }

}
