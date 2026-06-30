package fr.epita.bank.services;

import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockTransaction;

import java.time.LocalDate;

public class AccountService {

    /**
     * this method expects a savings account with some balance initialized
     * <pre><code>
     *     //... Savings account creation etc.
     *     AccountService.computeGainAndUpdateBalance(savings)
     * </code></pre>
     */
    public static Double computeGainAndUpdateBalance(SavingsAccount savingsAccount) {
        Double gain= savingsAccount.getBalance() * savingsAccount.getInterestRate();
        savingsAccount.setBalance(savingsAccount.getBalance() + gain);
        System.out.println("final balance = " + savingsAccount.getBalance());
        return gain;
    }


    public static void buyStocks(Stock stock, int qty, InvestmentAccount investmentAccount) {
        StockTransaction tx = new StockTransaction(stock.getPrice(), qty, 0.01, LocalDate.now(), investmentAccount, stock);


        Double txAmount = tx.getQuantity() * tx.getUnitPrice();
        double finalBalance = investmentAccount.getBalance() - txAmount;
        investmentAccount.setBalance(finalBalance);
    }

}
