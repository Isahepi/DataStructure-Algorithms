import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
lab6.java
fall 2025
Isabella Herrera

Your assignment is to write a function called toDouble that will take a numeric value as a string and convert the value to 
a double. Your function must allow dollar signs, negative sign, commas, spaces, and a single decimal point.
Use the Java Collection stack and queue to implement your function (see sample program for how to use Java Collection stack and 
queue). 
Place all values to the left of the decimal on the stack. 
Place all values to the right of the decimal place (if any) on a queue. 
The result should be calculated by removing and adding values from the stack and queue. 
When you pop values from the stack, multiply the first value by 1, the second by 10, the third by 100, etc ... until all values are removed from the stack. 
When you remove values from the queue divide the first value by 10, the second by 100, the third by 1000, etc ... until all values 
are removed from the queue.
 */

public class lab6 {
    public static void main(String[] args) {

        // test cases - add x3 additional cases here
        test("6", 6.0);
        test("7,000,000", 7000000.0);
        test(" $$$7 000 000 ", 7000000.0);
        test("$5,678.13 ", 5678.13);
        test("$0.25", 0.25);
        test(" -$.25", -0.25);
        test("-8.96", -8.96);
        
        // *** add three additional test cases here
        test("$324$", 324.0); //1
        test("-4829$$$$$43.1937", -482943.1937); //2
        test("456,23", 45623); //3

    }// main

    private static double toDouble(String a) {

        double answer = 0.0;

        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        boolean decimalFound = false; // using approach
        boolean negative = false; // using approach

        // *** add code here ***
        a = a.trim();

        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            
            if (ch == '-') {
                negative = true;
            } else if (ch == '$' || ch == ',' || ch == ' '){
                continue;
            } else if (ch == '.'){
                decimalFound = true;
            } else if (Character.isDigit(ch)){
                int digit = Character.getNumericValue(ch);
                if (!decimalFound){
                    s.push(digit);
                } else {
                    q.add(digit);
                }
            }
        }

        //Pop out values and multiply them
        double stackMultiplier = 1;
        while (!s.isEmpty()){
            int digit = s.pop();
            answer += digit * stackMultiplier;
            stackMultiplier *=10;
        }

        double queueDivisor = 10;
        while(!q.isEmpty()){
            int digit = q.remove();
            answer += digit / queueDivisor;
            queueDivisor *= 10;
        }

        if(negative){
            answer = -answer;
        }

        return answer;

    }

    // test method
    private static void test(String s, double expected) {

        double actual = toDouble(s);

        if (actual == expected)
            System.out.printf("Passed: %15s => %15f\n", s, actual);
        else
            System.out.printf(" Error: %15s => %15f   Expected: %15f\n", s, actual, expected);

    } // test

}// class
