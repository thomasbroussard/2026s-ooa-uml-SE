package fr.epita.bank.datamodel;

public class SavingsAccount extends Account{
    Double interestRate;

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }


}
