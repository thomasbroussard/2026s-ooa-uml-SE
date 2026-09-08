package fr.epita.biostats.service;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiostatEntryCsvService {


    public static List<BiostatEntry> readCsv(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        List<BiostatEntry> entries = new ArrayList<>();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
           String line = scanner.nextLine();

           line = line.replace("\"", "");
           String[] parts = line.split(",");

           BiostatEntry entry = new BiostatEntry();
           entry.setName(parts[0].trim());
           entry.setGender(parts[1].trim());
           entry.setAge(Integer.parseInt(parts[2].trim()));
           entry.setHeight(Integer.parseInt(parts[3].trim()));
           entry.setWeight(Integer.parseInt(parts[4].trim()));
           entries.add(entry);
        }
        scanner.close();
        return entries;
    }

    public static void writeCsv(String path, List<BiostatEntry> entries) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(path);
        writer.println("name;gender;age;height;weight");
        for (BiostatEntry entry : entries) {
            writer.println(entry.getName() + ";"
                    + entry.getGender() + ";"
                    + entry.getAge() + ";"
                    + entry.getHeight() + ";"
                    + entry.getWeight());
        }

        writer.close();



    }


}
