import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(30, "Иван", "Иванов", "Мужской");
        System.out.println(user1.nameAndSurname());
        user1.addAge(5);
        System.out.println(user1.information());
        User user = new User(20, "Антон", "Овсейчик", "Мужской");
        user.addAge(40);
        ArrayList<String> objects = new ArrayList<>();
        objects.add("asdasd");
    }
}
