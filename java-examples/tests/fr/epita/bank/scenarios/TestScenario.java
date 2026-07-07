package fr.epita.bank.scenarios;

import fr.epita.bank.datamodel.*;
import fr.epita.bank.services.AccountService;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class TestScenario {



    int test;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int test;
        Integer test2;

        System.out.println("test");

        Customer customer = new Customer();
        //1. put name = "Thomas", adress = "paris"
        System.out.println("Give me your name:");
        customer.setName(scanner.nextLine());

        System.out.println("Give me your address:");
        customer.setAddress(scanner.nextLine());



        //2. initialize savings account with 500,0€ balance
        System.out.println("account creation, input the balance:");
        SavingsAccount savingsAccount = new SavingsAccount();
        String line = scanner.nextLine();
        savingsAccount.setBalance(Double.parseDouble(line));

        //3. set the interest rate to 10% (0.10)
        System.out.println("input the interest rate:");
        line = scanner.nextLine();
        savingsAccount.setInterestRate(Double.parseDouble(line));

        //4. compute the gain in cas we have reached the "gain" calculation moment.
        double gain = AccountService.computeGainAndUpdateBalance(savingsAccount);
        System.out.println(gain);

        //write a program allowing to implement the following scenario:
        //1. investment account
        InvestmentAccount investmentAccount = new InvestmentAccount();

        //2. set the same customer as owner
        investmentAccount.setCustomer(customer);

        //3. set the investment account to 28 000€
        investmentAccount.setBalance(28000.0);

        //4. define the GOLD stock (unit price = 10000€)
        Stock stock = new Stock();
        stock.setPrice(10000.0);
        stock.setTicker("GOLD");

        //5. buy 2 GOLD stocks
        AccountService.buyStocks(stock, 2, investmentAccount);

        //6. what is the final balance of the investment account?
        System.out.println("final balance = " + investmentAccount.getBalance());

        //7. what should happen in case we try to buy more than 3 GOLD stocks?


        //8. save stocks somewhere
        AccountService.writeStocks(Arrays.asList(stock), "./test.csv");
        scanner.close();
    }


}
