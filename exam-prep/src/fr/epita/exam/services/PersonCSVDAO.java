package fr.epita.exam.services;

import fr.epita.exam.datamodel.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PersonCSVDAO {

    private static final String DELIMITER = ",";

    public PersonCSVDAO(){

    }

    public void save(Person person){

    }
    public void delete(Person person){

    }

    public void update(Person person){}

    public Person findById(int id){
        return null;
    }

    public List<Person> readAll(String path) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(path));
        List<Person> entries = new ArrayList<>();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            line = line.replace("\"", "");
            String[] parts = line.split(DELIMITER);

            Person entry = new Person();
            entry.setName(parts[0].trim());
            entry.setGender(parts[1].trim());
            entry.setAge(Integer.parseInt(parts[2].trim()));
            entry.setHeight(Integer.parseInt(parts[3].trim()));
            entry.setWeight(Integer.parseInt(parts[4].trim()));
            entries.add(entry);
        }
        scanner.close();
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getHeight() - o2.getHeight();
            }
        };

        entries.sort(comparator);

        entries.sort(Comparator.comparing(Person::getHeight));
        return entries;
    }
}
