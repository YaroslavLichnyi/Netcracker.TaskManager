package Model;
import org.apache.log4j.Logger;

import java.util.*;

public class ArrayTaskList extends TaskList{
    private int size = 1;
    private Task[] taskList = new Task[size];
    private int numOfElements = 0;
    private static final Logger log = Logger.getLogger(ArrayTaskList.class);
	


    @Override
    public void add(Task task) {
        if (numOfElements==(size-1)){
            size*=2;
            Task[] someTasklist = new Task[size];
            System.arraycopy(taskList,0,someTasklist,0,taskList.length );
            taskList = someTasklist;
        }
        try {
            assert(task != null);
            taskList[numOfElements] = task;
        } catch (Exception e){
            System.out.println("ERROR");

        }
        taskList[numOfElements] = task;
        numOfElements++;
    }

    @Override
    public boolean remove(Task task) {
        try {
            assert(task != null);
            for (int i = 0; i < numOfElements; i++) {
                if (taskList[i].equals(task) && taskList[i] != null) {
                    for (int j = i; j < numOfElements; j++) {
                        taskList[j] = taskList[j + 1];
                    }
                    taskList[numOfElements] = null;
                    numOfElements--;
                    return true;
                }
            }

        } catch (Exception e){
            System.out.println("ERROR. You entered incorrect number");
        }
        return false;
    }
	
	
    @Override
    public int size() {
        return numOfElements;
    }

    @Override
    public Task getTask(int index) {
        try {
            assert(index <= numOfElements);
            return taskList[index];

        } catch (Exception e){
            System.out.println("Dear User, your tasklist sontains "+ numOfElements + " tasks. Pleare, enter number from 0 to " + numOfElements);
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            this.getTask(a);
        }
        return null;
    }




       @Override
    public boolean equals(Object o) {
        if (this == o) return true;
           ArrayTaskList that = (ArrayTaskList) o;
        if (o == null || getClass() != o.getClass() || this.numOfElements != that.numOfElements) return false;
           for (int i = 0; i < numOfElements; i++) {
               if (!(this.getTask(i).equals(that.getTask(i)))){
                   return false;
               }
           }
        return size == that.size &&
                Arrays.equals(taskList, that.taskList);
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(size, numOfElements);
        result = 31 * result + Arrays.hashCode(taskList);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTaskList{" +
                "size=" + size +
                ", taskList=" + Arrays.toString(taskList) +
                ", numOfElements=" + numOfElements +
                '}';
    }

    @Override
    public ArrayTaskList clone()  {
        ArrayTaskList arr = new ArrayTaskList();
        for (int i = 0; i <numOfElements ; i++) {
            arr.add(this.getTask(i).clone());
        }
        return arr;

    }

    public boolean isEmpty(){
        return  numOfElements == 0;
    }


public Iterator iterator() { return new ArrayTaskList.ArrayTaskListIterator(); }


    private class ArrayTaskListIterator implements Iterator {
        int current=0;
		int lastIt = -1;
        public Task next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
			lastIt = current;
           current++;
            return getTask(current-1);
        }

        public boolean hasNext() {
            return current < numOfElements;
        }

        public void remove() {
            if (lastIt<0){
                throw new IllegalStateException();
            }
            try{
                ArrayTaskList.this.remove(getTask(lastIt));
                current = lastIt;
                lastIt =- 1;
            } catch (IndexOutOfBoundsException ex){
                throw new ConcurrentModificationException();
            }
        }
		
		
    }

}
