package fr.epita.bank.scenarios;

import fr.epita.bank.datamodel.Stock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestReadStock {

    public static void main(String[] args) {
        File file = new File("./java-examples/stocks.csv");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanner.nextLine();
        List<Stock> stocks = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Stock stock = new Stock();
            String[] parts = line.split(";");
            stock.setPrice(Double.parseDouble(parts[1]));
            stock.setTicker(parts[0]);
            System.out.println(stock);
            stocks.add(stock);
        }
        scanner.close();



    }
}
