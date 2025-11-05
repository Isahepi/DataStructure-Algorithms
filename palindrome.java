package Lab4;
/*Assume palindrome status is true

Create stack
Create queue
Add all letters from the word to the stack
Add all letters from the word to the queue

While the stack is not empty and the palindrome status is true
   if stack.top() not equal to queue.front()
      palindrome status is false
   else
      pop char from stack, remove char from queue

Return palindrome status */

/// palindrome.java 
// fall 2025
// lab4b assignment
//  Isabella Herrera
// Use for paindrome.java

public class palindrome {
    
    public static void main(String[] args) {

        //single call to test
        System.out.println( palindrome("racecar") ); //true
        System.out.println( palindrome("sass") ); //false

        //uncomment to test additional words
        
        String words[] = { "a", "racecar", "noon", "hannah", "abcba", "abbca", "nope", "ab" };

        for (int i = 0; i < words.length; i++) {

            if (palindrome(words[i]) == true)
                System.out.println( words[i] + " IS a palindrome");
            else
                System.out.println( words[i] + " IS NOT a palindrome");
        }
        
        
    }// main

    // *** use StackCharArray and QueueCharArray here to determine Palindrome
    private static boolean palindrome(String word) {

    boolean status = true;

    StackCharArray stack = new StackCharArray(word.length());
    QueueCharArray queue = new QueueCharArray(word.length());   

    // push/enqueue all letters
    for (int i = 0; i < word.length(); i++) {
        char letter = word.charAt(i);
        stack.push(letter);
        queue.add(letter);
    }

    // compare characters
    while (!stack.empty() && status) {
        if (stack.top() != queue.front()) { // use method top()
            status = false;
        } else {
            stack.pop();
            queue.remove();
        }
    }

    return status;
    }
}
