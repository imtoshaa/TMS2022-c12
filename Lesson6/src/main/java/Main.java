public class Main {
    public static void main(String[] args) {
        User u1 = new User("Иван", "Иванов");
        u1.printNameAndSurname();
        u1.information(15, "Мужской");
        u1.addAge(5);
        System.out.println(u1.age);
//        User user = new User("Антон", "Овсейчик", 20, new User("Мужской")); //* В этом конструкторе сделать вызов другого конструктора этого же класса. Не понял тут
        User user = new User("Антон", "Овсейчик", 20, "Мужской");
        user.addAge(3);
    }
}
