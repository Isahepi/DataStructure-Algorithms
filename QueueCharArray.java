/*
QueueCharArray.java
fall 2025
Isabella Herrera

Write the class QueueCharArray that implements an ADT for a queue that can store the Java char type using an array.
Modify code file QueueCharArray.java given below.
Implement the methods shown in the UML diagram.
Add comments throughout your program to describe your design. 
Test your class using testQueue.java code provided. Add additional test cases to verify your understangin.
Use the class StackCharArray that implements an ADT for a stack that can store the Java char type using an array as a template.

Default queue size must be 5
Alternate constructor sets maximum queue size
If queue is empty, front() should return ‘?’
Feel free to use private data items shown or create your own to support your class
 */
public class QueueCharArray {

	// data
	char data[];
	int front;
	int back;
	int size;
	int MAX;

    
	// default constructor
	public QueueCharArray() {
        this(8); // default capacity
    }

    // alternate constructor
    public QueueCharArray(int max) {
        MAX = max;
        data = new char[MAX];
        front = 0;
        back = 0;
        size = 0;
    }

    // delete all items in queue
    public void clear() {
        front = 0;
        back = 0;
        size = 0;
    }

    // add to back of queue
    // Check if the queue is full before adding a new element.
    public void add(char v) {
        if (full()) {
            return; // no error shown
        }
        data[back] = v;
        back = (back + 1) % MAX;
        size++;
    }

    // see if queue is empty
    public boolean empty() {
        return size == 0;
    }

    // see if queue is full
    public boolean full() {
        return size == MAX;
    }

    // return element from front of queue
    public char front() {
        if (empty()) {
            return '?'; // denotes empty
        }
        return data[front];
    }

    // remove element from front of queue
    public boolean remove() {
        if (empty()) {
            return false;
        }
        front = (front + 1) % MAX;
        size--;
        return true;
    }
    public int size() {
        return size;
    }
	 /**
     * use with println to display queue
     * 
     * @return set as a String
     */
    @Override
    public String toString() {
    if (size == 0) return "[empty queue]";

    StringBuilder sb = new StringBuilder();

    // width of box = number of letters + commas between them
    int width = size + (size - 1); // size letters + (size-1) commas

    // top border
    sb.append("+");
    for (int i = 0; i < width; i++) sb.append("-");
    sb.append("+\n");

    // middle line with letters separated by commas
    sb.append("|");
    for (int i = 0; i < size; i++) {
        sb.append(data[(front + i) % data.length]);
        if (i < size - 1) sb.append(","); // add comma between letters
    }
    sb.append("|\n");

    // bottom border
    sb.append("+");
    for (int i = 0; i < width; i++) sb.append("-");
    sb.append("+\n");

    return sb.toString();
}


}// class
