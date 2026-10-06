package fr.epita.exam.datamodel;

public enum GenderEnum {
    MALE("M"), FEMALE("F");

    private final String code;

    GenderEnum(String m) {
        this.code = m;
    }
}
