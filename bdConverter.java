import java.util.Scanner;
public class bdConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String choice; //holds the user's answer

        while (true) {
            System.out.println("----This is the binary and decimal converter----");
            System.out.println("Enter a number for an option");
            System.out.println("1. Convert Binary to Decimal");
            System.out.println("2. Convert Decimal to Binary");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            choice = scan.next(); //stores the answer by the user in a string

            switch (choice) { //switch cases for each choice made by the user
                case "1" -> {
                    System.out.println("Enter a binary number to be converted: ");
                    String binary = scan.next();
                    int decimal = binaryToDecimal(binary);
                    if (decimal != -1) {
                        System.out.println("The decimal equivalent of: " + binary + "is: " + decimal);
                    } else {
                        System.out.println("You entered an invalid binary number");
                    }
                }
                case "2" -> {
                    System.out.print("Enter a decimal number to be converted: ");
                    int dc = scan.nextInt();
                    String bn = decimalToBinary(dc);
                    System.out.println("The binary equivalent of: " + dc + " is: " + bn);
                }
                case "3" -> {
                    System.out.println("You do not want to convert. Exiting program now...");
                    scan.close();
                    return;
                }
                default -> System.out.println("You didn't enter a valid choice. Try again.");
            }
        }
    }

    public static int binaryToDecimal(String binary) { //function takes in binary number as string and converts every single value to decimal
        int decimal = 0; //varible stores the equivalent of binary
        for (int i = 0; i < binary.length(); i++) {//loop iterates through ever character of the string binary
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, binary.length() - 1 - i); //if character at [i] index position, add the corresponding decimal value which is 2 raised to teh position of char[i]
            } else if (binary.charAt(i) != '0') {
                return -1; //returns an error code to show that input is invalid if char[i] is not 0 or 1
            }
        }
        return decimal; //retursn the converted decimal number
    }

    public static String decimalToBinary(int decimal) { //function takes in a string and converts it to binary
        if (decimal == 0) { //if decimal is equal to zero returns 0. No further calculations
            return "0";
        }

        String binary = new String();
        while (decimal > 0) {
            binary = (decimal % 2) + binary;
            decimal /= 2;
        }
        return binary; //returns the converted binary number
    }
}