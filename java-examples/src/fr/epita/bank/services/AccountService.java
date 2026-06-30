package fr.epita.bank.services;

import fr.epita.bank.datamodel.SavingsAccount;

public class AccountService {


    public static Double computeGainAndUpdateBalance(SavingsAccount savingsAccount) {
        Double gain= savingsAccount.getBalance() * savingsAccount.getInterestRate();
        savingsAccount.setBalance(savingsAccount.getBalance() + gain);
        System.out.println("final balance = " + savingsAccount.getBalance());
        return gain;
    }

}
