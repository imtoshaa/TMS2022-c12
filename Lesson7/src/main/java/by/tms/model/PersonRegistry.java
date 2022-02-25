package by.tms.model;

import java.util.ArrayList;

public class PersonRegistry {
    private ArrayList<Person> listPerson = new ArrayList<>();

    public void addPerson(Person person) {
        listPerson.add(person);
    }

    public ArrayList<Person> getListPerson() {
        return listPerson;
    }
}
