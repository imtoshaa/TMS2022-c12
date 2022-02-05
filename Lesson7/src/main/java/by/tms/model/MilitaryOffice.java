package by.tms.model;

import by.tms.service.MainMilitaryOffice;

import java.util.ArrayList;

public class MilitaryOffice {
    private PersonRegistry personRegistry;
    private ArrayList<Person> personArrayList;

    public MilitaryOffice(PersonRegistry personRegistry) {//конструктор
        personArrayList = personRegistry.getListPerson();
    }

    public int getNumberOfRecruitsByName(String name) {
        int count = 0;
        for (int i = 0; i < personArrayList.size(); i++) {
            if (personArrayList.get(i).getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    public ArrayList fitForMilitary() {
        ArrayList<Person> fitFromMilitary = new ArrayList<>();
        for (int i = 0; i < personArrayList.size(); i++) {
            if (checkFitAgeAndSex(personArrayList.get(i))) {
                fitFromMilitary.add(personArrayList.get(i));
            }
        }
        return fitFromMilitary;
    }

    public int fitFrom(String city) {
        int count = 0;
        for (int i = 0; i < personArrayList.size(); i++) {
            if (personArrayList.get(i).getCity().equals(city) && checkFitAgeAndSex(personArrayList.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int ageSearch(int lower, int upper) {
        int count = 0;
        for (int i = 0; i < personArrayList.size(); i++) {
            if (checkAge(personArrayList.get(i), lower, upper)) {
                count++;
            }
        }
        return count;

    }

    private boolean checkFitAgeAndSex(Person person) {
        if (checkAge(person, 18, 27) && !person.getSex().equals(MainMilitaryOffice.FEMALE)) {
            return true;
        }
        return false;
    }

    private boolean checkAge(Person person, int lower, int upper) {
        if (person.getAge() >= lower && person.getAge() <= upper) {
            return true;
        }
        return false;
    }

}