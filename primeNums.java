import java.util.Scanner;

public class primeNums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter \'000\' to end the program.");
            System.out.println("Enter the lower bound 'a': "); //asks for the lower bound
            int a = scanner.nextInt();

            if(a == 000){
               System.out.println("You have ended the program. Bye.");
                break;
            }
            System.out.println("Enter the upper bound 'b': "); //asks for the upper bound
            int b = scanner.nextInt();

            if(b == 000){
                System.out.println("You have ended the program. Bye.");
                break;
            }

            System.out.println("Prime numbers between " + a + " and " + b + " (inclusive) are:");
            for (int i = a; i <= b; i++) { //iterates through every number between upper and lower bound and checks with boolean function if it's prime or not
                if (isPrime(i)) {
                    System.out.print(i + "\n"); //prints out all the prime numbers between given bounds
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) { //checks if number remainder is zero if it is returns false
            if (num % i == 0) {
                return false;
            }
        }

        return true; //else returns true and the number which is actually prime
    }
}
