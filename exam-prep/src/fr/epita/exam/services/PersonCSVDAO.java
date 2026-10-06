package fr.epita.exam.services;

import fr.epita.exam.datamodel.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PersonCSVDAO {

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

    public List<Person> readAll(){

        Scanner scanner = new Scanner(new File("./exam-prep/biostats.csv"));
        List<Person> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        System.out.println(list.get(1));
        scanner.close();
        Comparator comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getHeight() - o2.getHeight();
            }
        };

        list.sort(comparator);

        list.sort(Comparator.comparing(Person::getHeight));

    }
}
