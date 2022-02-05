import java.util.Scanner;

public class Main {
    public static final String MALE = "мужской";
    public static final String FEMALE = "женский";
    public static final String BELARUS = "Беларусь";

    public static void main(String[] args) {
        System.out.println("*****Вас приветствует военный комисариат TMS!*****");
        PersonRegistry personRegistry = new PersonRegistry();
        personRegistry.setPerson(new Person("Мария", 19, FEMALE, BELARUS, "Минск"));
        personRegistry.setPerson(new Person("Вадим", 17, MALE, BELARUS, "Минск"));
        personRegistry.setPerson(new Person("Александр", 22, MALE, BELARUS, "Барановичи"));
        personRegistry.setPerson(new Person("Егор", 27, MALE, BELARUS, "Минск"));
        personRegistry.setPerson(new Person("Антон", 20, MALE, BELARUS, "Жодино"));
        personRegistry.setPerson(new Person("Владимир", 25, MALE, BELARUS, "Брест"));
        personRegistry.setPerson(new Person("Александр", 21, MALE, BELARUS, "Минск"));
        setInRegistry(); //регистрируем нового призывника
        MilitaryOffice militaryOffice = new MilitaryOffice(personRegistry);
        militaryOffice.filterAlexander(); //выводим количество призывников с именем Александр
        militaryOffice.fitForMilitary(); //выводим всех годных
        militaryOffice.fitFromMinsk(); //годные из Минска
        militaryOffice.fitOldPeople(); //от 25 до 27

    }

    public static void setInRegistry() {
        Scanner scanner = new Scanner(System.in);
        Person newPerson = new Person();
        boolean go = false;
        System.out.println("Введите yes для добавления нового призывника");
        if (scanner.nextLine().equals("yes")) {
            go = true;
        } else {
            return;
        }
        while (go) {
            System.out.println("Введите имя призывника");
            newPerson.setName(scanner.next());
            System.out.println("Введите возраст призывника");
            newPerson.setAge(scanner.nextInt());
            System.out.println("Введите пол призывника");
            newPerson.setSex(scanner.next());
            System.out.println("Введите страну призывника");
            newPerson.setCountry(scanner.next());
            System.out.println("Введите город призывника");
            newPerson.setCity(scanner.next());
            System.out.println("Хотите добавить ещё одного призывника? Введите yes, чтобы добавить");
            if (!scanner.next().equals("yes")) {
                go = false;
            }
        }
    }
}
    
