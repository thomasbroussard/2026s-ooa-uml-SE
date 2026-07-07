package fr.epita.bank.scenarios;

import fr.epita.bank.datamodel.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.*;

public class TestFileIO {

    public static void main(String[] args) {
        File file = new File("./java-examples/customers.csv");
        //readFileTest(file);

        try {
            List<String> strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.write(file.toPath(), Arrays.asList("a", "b", "c"), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (PrintWriter writer = new PrintWriter(file)){

            writer.println("a");
            writer.println("b");
            writer.println("c");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // not necessary thanks to the try-with-resources statement
//        finally {
//            if (writer != null) {
//                writer.close();
//            }
//        }

    }

    private static void readFileTest(File file) {
        Path p = Paths.get("src/fr/epita/bank/datamodel/customers.csv");

        System.out.println("file exists:" + file.exists());

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
