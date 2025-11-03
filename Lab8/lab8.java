/* sample pseudocode for lab 8 ***
get MAX

set low = 1
set high = MAX
set found = false
set guess count = 0

while not found
   guess = (low + high) / 2
   add 1 to guess count

   Ask if number this is your number?
   if yes, then set found = true and print guess count
   if no, then ask if your number is higher or lower
      if your number is higher, then set low to guess + 1
      if your number is lower, then set high to guess – 1

end loop

display found number in guess count guesses
*/
import java.util.Scanner;

public class lab8 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); //Read the input from the user

        //User selects the largest number
        System.out.println("Enter the largest number:");
        int max = scanner.nextInt();
        scanner.nextLine();

        //Ask user to pick a 1 and the largest number he choose
        System.out.println("\nPick a number between 1 and " + max + " but don’t tell me.");

        //Calculate the maximum number of guesses needed
        int maxGuesses = (int) Math.ceil(Math.log(max) / Math.log(2));
        System.out.println("I can guess your number in " + maxGuesses + " guesses.\n");

        int low = 1;
        int high = max;
        boolean found = false;
        int guessCount = 0;
        
        //Finding inconsistency in response
        while (!found) {
            if (low > high) {
                System.out.println("Inconsistent answer");
                break;
            }

        int guess = (low + high) / 2;
            guessCount++;

        System.out.print("Guess #" + guessCount + ": Is your number " + guess + "? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("y")) {
                System.out.println("\nI was able to guess your number in " + guessCount + " guesses!");
                found = true;
            } else if (answer.equals("n")) {
                System.out.print("Is your number higher or lower than " + guess + "? (h/l): ");
                String direction = scanner.nextLine().trim().toLowerCase();

                if (direction.equals("h")) {
                    low = guess + 1;
                } else if (direction.equals("l")) {
                    high = guess - 1;
                } else {
                    System.out.println("Invalid input. Ending program.");
                    break;
                }
            } else {
                System.out.println("Invalid input. Ending program.");
                break;
            }
        }

        scanner.close();
    }
}