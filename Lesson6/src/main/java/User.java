public class User {
    int age;
    String name;
    String surname;
    String gender;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public User(int age, String name, String surname, String gender) {
        this(name, surname);
        this.gender = gender;
        this.age = age;
    }

    public String nameAndSurname() {
        return name + " " + surname;
    }

    @Deprecated
    public void addAge(int age) {
        this.age += age;
    }

    public String information() {
        return "Общая информация:" + '\n'
                + "Имя " + name + '\n'
                + "Фамилия " + surname + '\n'
                + "Возраст " + age + '\n'
                + "Пол " + gender;
    }
}

