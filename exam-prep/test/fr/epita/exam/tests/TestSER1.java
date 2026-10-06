package fr.epita.exam.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestSER1 {

    static void main() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("./exam-prep/biostats.csv"));
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
           list.add(scanner.nextLine());
        }
        System.out.println(list.get(1));
        scanner.close();
    }
}
