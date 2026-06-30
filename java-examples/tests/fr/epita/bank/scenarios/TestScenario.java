package fr.epita.bank.scenarios;

import fr.epita.bank.datamodel.*;
import fr.epita.bank.services.AccountService;

import java.time.LocalDate;

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
        buyStocks(stock, investmentAccount);

        //6. what is the final balance of the investment account?
        System.out.println("final balance = " + investmentAccount.getBalance());

        //7. what should happen in case we try to buy more than 3 GOLD stocks?

    }

    private static void buyStocks(Stock stock, InvestmentAccount investmentAccount) {
        StockTransaction tx = new StockTransaction();
        tx.setStock(stock);
        tx.setAccount(investmentAccount);
        tx.setQuantity(2);
        tx.setUnitPrice(stock.getPrice());
        tx.setTxDate(LocalDate.now());

        Double txAmount = tx.getQuantity() * tx.getUnitPrice();
        double finalBalance = investmentAccount.getBalance() - txAmount;
        investmentAccount.setBalance(finalBalance);
    }

}
