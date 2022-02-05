import java.util.ArrayList;

public class MilitaryOffice {
    private PersonRegistry personRegistry;
    private ArrayList<Person> personArrayList = personRegistry.getListPerson();

    public MilitaryOffice(PersonRegistry personRegistry) {//конструктор
        personArrayList = personRegistry.getListPerson();
    }

    public void filterAlexander() {
        int count = 0;
        System.out.println("Количество призывников с именем Александр: ");
        for (int i = 0; i < personArrayList.size(); i++) {
            if (personArrayList.get(i).getName().equals("Александр")) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void fitForMilitary() {
        System.out.println("Следующие призывники готовы к несению службы:");
        for (int i = 0; i < personArrayList.size(); i++) {
            if (fitAgeAndSex(personArrayList.get(i))) {
                System.out.println(personArrayList.get(i).toString());
            }
        }
    }

    public void fitFromMinsk() {
        int count = 0;
        System.out.println("Количество призывников из Минска: ");
        for (int i = 0; i < personArrayList.size(); i++) {
            if (personArrayList.get(i).getCity().equals("Минск") && fitAgeAndSex(personArrayList.get(i))) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void fitOldPeople() {
        int count = 0;
        System.out.println("Количество призывников от 25 до 27 лет: ");
        for (int i = 0; i < personArrayList.size(); i++) {
            if (age(personArrayList.get(i), 25, 27)) {
                count++;
            }
        }
        System.out.println(count);

    }

    private boolean fitAgeAndSex(Person person) {
        if (age(person, 18, 27) && !person.getSex().equals(Main.FEMALE)) {
            return true;
        }
        return false;
    }

    private boolean age(Person person, int lower, int upper) {
        if (person.getAge() >= lower && person.getAge() <= upper) {
            return true;
        }
        return false;
    }

}