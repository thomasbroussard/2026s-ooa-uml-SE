package fr.epita.biostats.launcher;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.service.BiostatEntryCsvService;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Launcher {

    static void main(String[] args) throws FileNotFoundException {
        List<BiostatEntry> entries = BiostatEntryCsvService.readCsv("./biostats/biostats.csv");
        double averageAge = 0;

        for (BiostatEntry entry : entries) {
            averageAge += entry.getAge();
        }
        averageAge /= entries.size();
        System.out.println(averageAge);


        entries.parallelStream()
                .mapToInt(BiostatEntry::getAge)
                .average()
                .ifPresent(System.out::println);


       Map<String, Long> countByGender = entries.stream()
                .collect(Collectors.groupingBy(BiostatEntry::getGender, Collectors.counting()));
        System.out.println(countByGender);

    }


}
