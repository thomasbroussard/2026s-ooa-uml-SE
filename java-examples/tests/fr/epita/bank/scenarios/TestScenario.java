package fr.epita.bank.scenarios;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

public class TestScenario {


    public static void main(String[] args) {
        System.out.println("test");

        Customer customer = new Customer();
        //1. put name = "Thomas", adress = "paris"
        customer.setName("Thomas");
        customer.setAddress("paris");


        //2. initialize savings account with 500,0€ balance
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setBalance(500.0);

        //3. set the interest rate to 10% (0.10)
        savingsAccount.setInterestRate(0.10);

        //4. compute the gain in cas we have reached the "gain" calculation moment.
        double gain = savingsAccount.getBalance() * savingsAccount.getInterestRate();
        savingsAccount.setBalance(savingsAccount.getBalance() + gain);
        System.out.println("final balance = " + savingsAccount.getBalance());


        //write a program allowing to implement the following scenario:
        //1. investment account
        //2. set the same customer as owner
        //3. set the investment account to 28 000€
        //4. define the GOLD stock (unit price = 10000€)
        //5. buy 2 GOLD stocks
        //6. what is the final balance of the investment account?
        //7. what should happen in case we try to buy more than 3 GOLD stocks?

    }
}
