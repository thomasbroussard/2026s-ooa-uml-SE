package fr.epita.bank.datamodel;

import java.time.LocalDate;

public class StockTransaction {
    Double unitPrice;
    Integer quantity;
    Double commission;
    LocalDate txDate;

    InvestmentAccount account;
    Stock stock;
}
