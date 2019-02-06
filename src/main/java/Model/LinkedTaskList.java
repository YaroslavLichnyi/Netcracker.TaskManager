package Model;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
import java.util.*;


public class LinkedTaskList extends TaskList {
    private Node first;
    private Node last;
    private int numOfElements=0;

    public LinkedTaskList() {
        first = null;
        last = null;
        numOfElements = 0;
    }
    @Override
    public boolean remove(Task task) {
        boolean result = false;
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove() from and empty list.");
        }
        if (task==null) {
            throw new NullPointerException("Cannot remove() empty task.");
        }
        Node prev = this.first;
        Node curr = this.first;
        if (curr == null) {
            throw new NullPointerException("The first argument for addLast() is null.");
        }
        if (curr.data == null) {
            throw new NullPointerException("The first argument for addLast() is null.");
        }
        int i=0;
        while (i<numOfElements) {
            if (curr.data.equals(task)) {
                // remove the last remaining element
                if (numOfElements == 1) {
                    first = null;
                    last = null;
                }
                // remove first element
                else if (curr.equals(first)) {
                    first = first.next;
                }
                // remove last element
                else if (curr.equals(last)) {
                    last = prev;
                    last.next = null;
                }
                // remove element
                else {
                    prev.next = curr.next;
                }
                numOfElements--;
                result = true;
                break;
            }
            prev = curr;
            curr = prev.next;
            i++;
        }
        return result;
    }
	


    @Override
    public void add(Task item) {
        if (item == null) {
            throw new NullPointerException("The first argument for addLast() is null.");
        }
        if (!isEmpty()) {
            Node prev = last;
            last = new Node(item, null);
            prev.next = last;
        } else {
            last = new Node(item, null);
            first = last;
        }
        numOfElements++;
    }




    @Override
    public int size() {
        return numOfElements;
    }

    public boolean isEmpty() {
        return numOfElements == 0;
    }

    private class Node {
        private Task data;
        private Node next;

        public Node(Task data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    @Override
    public Task getTask(int index) {
        try {
            Node a = new Node(null, this.first);
            a=a.next;
            for (int i = 0; i <index ; i++) {
                a=a.next;
            }
            return a.data;

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
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList that = (LinkedTaskList) o;
        if (!(numOfElements == that.numOfElements) ||  !(this.first.equals(that.first)) ||  !(this.last.equals(that.last))) return false;
        Node a = new Node(null, this.first);
        a=a.next;
        Node b = new Node(null, that.first);
        b=b.next;
        for (int i = 0; i <numOfElements ; i++) {
            if (a.data.equals(b.data) ){
                return false;
            }
                a=a.next;
                b=b.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        Task[] myArrayTaskList = new Task[numOfElements];
        for (int i = 0; i < numOfElements; i++) {
            myArrayTaskList[i] = getTask(i);
        }
        return 31*Objects.hash( Arrays.hashCode(myArrayTaskList), numOfElements);
    }

    @Override
    public LinkedTaskList clone()  {
        try {
            return (LinkedTaskList)super.clone();
        } catch( CloneNotSupportedException ex ) {
            throw new InternalError();
        }

    }


    public Iterator iterator() { return new LinkedTaskListIterator(); }

    private class LinkedTaskListIterator implements Iterator {
        private Node current = first;
		private Node prev = current;
		private boolean i = false;
        public Task next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
			prev = current;
            current = current.next;
			i=true;
            return prev.data;
        }

        public boolean hasNext() { return prev.next != null; }

        public void remove() {
            if (current == null || i==false ){
                throw new IllegalStateException();
            }
            LinkedTaskList.this.remove(prev.data);
        }
		
}
}
