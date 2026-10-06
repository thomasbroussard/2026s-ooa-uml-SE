package fr.epita.exam.services;

import fr.epita.exam.datamodel.Person;

import java.time.Year;
import java.util.List;

public class PersonDataService {

    int averageAge(List<Person> persons){
        // new Double(persons.stream().mapToInt(Person::getAge).average().getAsDouble()).intValue();
        Integer cumulatedAge = 0;
        for (Person person : persons) {
            cumulatedAge += person.getAge();
        }
        return cumulatedAge / persons.size();

    }
    List<Person> filter(List<Person> persons, int thresholdAge){
        List<Person> filteredPersons = persons.stream().filter(person -> person.getAge() >= thresholdAge).toList();
        filteredPersons.clear();
        for(Person person : persons){
                if (person.getAge() >= thresholdAge){
                    filteredPersons.add(person);
                }
        }
        return filteredPersons;
    }
    int calculateYearOfBirth(Person person){
        Year yearOfBirth = Year.now().minusYears(person.getAge());
        return yearOfBirth.getValue();
    }
}
