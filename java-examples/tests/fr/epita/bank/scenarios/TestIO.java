package fr.epita.bank.scenarios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String doubleQuote = "\"";
        doubleQuote.replace("\"", "");
        try { //this is a try-catch block, we will discuss it further
            System.out.println("Enter 1 number (integer): ");
            String num1 = scanner.nextLine();
            System.out.println("Input 1 accepted");
            int num2 = scanner.nextInt();
            System.out.println("Input 2 accepted");
        } catch (InputMismatchException e) {
            System.out.println("Invalid Entry");
        }
        scanner.close();
    }
}
