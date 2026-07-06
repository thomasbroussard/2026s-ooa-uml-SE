package fr.epita.bank.scenarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestFileIO {

    public static void main(String[] args) {
        File file = new File("./java-examples/customers.csv");
        Path p = Paths.get("src/fr/epita/bank/datamodel/customers.csv");

        System.out.println("file exists:" +file.exists());

        try {
            Scanner scanner = new Scanner(file);
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }
}
