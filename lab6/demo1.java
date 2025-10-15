
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
demo1.java
fall 2025
Isabella Herrera

 */
public class demo1 {
    public static void main(String[] args) {

        // Java Collection Stack
        Stack<Integer> s = new Stack<Integer>();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("top = " + s.peek());

        while (!s.isEmpty()) {
            System.out.println("top = " + s.peek());
            System.out.println(" Removing " + s.pop());
        }
        System.out.println();
        System.out.println();

        // Java Collection Queue
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("front = " + q.element());
        while (!q.isEmpty()) {
            System.out.println("front = " + q.element());
            System.out.println(" Removing " + q.remove());
        }
    }// main
}// class