package fr.epita.bank.scenarios;

import fr.epita.bank.datamodel.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestFileIO {

    public static void main(String[] args) {
        File file = new File("./java-examples/customers.csv");
        Path p = Paths.get("src/fr/epita/bank/datamodel/customers.csv");

        System.out.println("file exists:" +file.exists());

        try {
            List<Customer> customers = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                Customer customer = new Customer();
                customer.setName(parts[0]);
                customer.setSurname(parts[1]);
                customer.setEmail(parts[2]);
                customer.setAddress(parts[3]);
                customers.add(customer);
            }
            System.out.println("customers list size: " + customers.size());
            System.out.println(customers);

        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }
}
