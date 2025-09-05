// lab2.java
// Isabella Herrera Pilonieta
// September 5, 2025
// calculates primes using Sieve of Eratosthenes
// demonstrates command line arguments and methods
// What is the maximum prime number you can find using your program? 
    //The program can run up to 2,147,483,647, however, it will take a lot of time to run.
    // However, when I try to run it in my command propmt, it only goes up to 10000.
// How does printing vs. not printing the numbers affect performance?
    //The printing slows down the performance of the program.
// What factors limit your program from finding larger prime numbers?
    //Some factors are the time it takes to run the program, the memory of the computer, the type of language we are using, in the case Java.

public class lab2 {

	public static void main(String[] args) 
	{
		int N = 0;
		//add code to get num from command line argument
		if (args.length > 0){
            N = Integer.parseInt( args[0]);
        } else{
            N = 1000;
        }
		//call showPrimes
		showPrimes( N );
		
	}//main
	
	public static void showPrimes(int N)
	{
        boolean[] arr = new boolean[N + 1];
        arr[0] = false;
        arr[1] = false;

        for (int i = 2; i < N; i++){
            arr[i] = true;
        }

        //Mark the values
        int i;
        for (i = 2; i < N; i++){
            if (arr[i] == true){
                for (int j = i*i; j < N; j+=i){
                arr[j] = false;
                }
            }
        }
        for (i = 2; i < N; i++){
            if (arr[i] == true){
                System.out.println (i);
            }
        };
	}//showPrimes
}//lab2