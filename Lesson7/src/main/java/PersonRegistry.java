import java.util.ArrayList;

public class PersonRegistry {
    private ArrayList<Person> listPerson = new ArrayList<>();

    public PersonRegistry() {
    }

    public PersonRegistry(ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
    }

    public void setPerson(Person person) {
        listPerson.add(person);
    }

    public Person getPerson(int index) {
        return listPerson.get(index);
    }

}
