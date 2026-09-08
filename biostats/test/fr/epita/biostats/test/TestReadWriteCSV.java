package fr.epita.biostats.test;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.service.BiostatEntryCsvService;

import java.io.FileNotFoundException;
import java.util.List;

public class TestReadWriteCSV {

    static void main(String[] args) throws FileNotFoundException {
        List<BiostatEntry> list = BiostatEntryCsvService.readCsv("./biostats/biostats.csv");
        if (list.size() != 18){
            System.out.println("Error size mismatch");
        };
        list.get(0).setName("AAAfromTest");
        BiostatEntryCsvService.writeCsv("./biostats/biostats-write.csv", list);
        List<BiostatEntry> anotherList = BiostatEntryCsvService.readCsv("./biostats/biostats-write.csv");

        if (!anotherList.get(0).equals(list.get(0))){
            System.out.println("Error equality mismatch");
        }else {
            System.out.println("Test successful");
        }

    }
}
