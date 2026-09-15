package fr.epita.biostats.datamodel;

import java.util.Objects;

public class BiostatEntry {

    private String name;
    private String gender;
    private int age;
    private int height;
    private int weight;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BiostatEntry that = (BiostatEntry) o;
        return age == that.age && height == that.height && weight == that.weight && Objects.equals(name, that.name) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, height, weight);
    }

    public BiostatEntry(){

    }

    public BiostatEntry(String name, String gender, int age, int height, int weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
