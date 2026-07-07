package fr.epita.biostats.launcher;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.service.BiostatEntryCsvService;

import java.io.FileNotFoundException;
import java.util.List;

public class Launcher {

    static void main(String[] args) throws FileNotFoundException {
        List<BiostatEntry> entries = BiostatEntryCsvService.readCsv("./biostats/biostats.csv");
        double averageAge = 0;

        for (BiostatEntry entry : entries) {
            averageAge += entry.getAge();
        }
        averageAge /= entries.size();
        System.out.println(averageAge);


        entries.stream().mapToInt(BiostatEntry::getAge).average().ifPresent(System.out::println);
    }
}
