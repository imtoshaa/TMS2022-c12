public class User {
    int age;
    String name;
    String surname;
    String gender;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void information(int age, String gender) { //вывод основной информации
        this.age = age; //я проинициализировал user через имя и фамилию, а потом уже в этот метод передал возраст и пол
        this.gender = gender;
        System.out.println("Основная информация" + '\n'
                + "Имя " + name + '\n'
                + "Фамилия " + surname + '\n'
                + "Возраст " + age + '\n'
                + "Пол " + gender);
    }

    public void printNameAndSurname() { //вывод имени и фамилии (тут уже имя и фамилия берётся из переменной класса, т.к. в предыдущем
        System.out.println("Имя и фамилия пользователя:" + '\n' //методе записали эти переменные
                + "Имя " + name + '\n'
                + "Фамилия " + surname + '\n');

    }

    @Deprecated
    public void addAge(int value) { //увеличение возраста
        age += value;
    }

    public User(String name, String surname, int age, String gender) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public User(int age) {
        this.age = age;
    }

    public User(String gender) {
        this.gender = gender;
    }
}

