import java.util.Random;
import java.util.Scanner;

public class HomeWork {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//1) Задача на оператор switch!
//        Рандомно генерируется число От 1 до 7.
//        Если число равно 1, выводим на консоль “Понедельник”, 2 –”Вторник” и так далее.
//        Если 6 или 7 – “Выходной”.
        System.out.println("Задача №1");
        weekday();
//2) Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//         сколько амеб будет через 3, 6, 9, 12,..., 24 часа
        System.out.println("Задача №2" + "\n" + "Введите количество часов деления амёбы");
        int am = scanner.nextInt();
        System.out.println("Количество амёб через " + am + " часов равно " + ameba(am));
//3) В переменную записываем число.
//        Надо вывести на экран сколько в этом числе цифр и положительное оно или отрицательное.
//        Например, Введите число: 5
//        "5 - это положительное число, количество цифр = 1"
        System.out.println(numbers(300));
//4) Дано 2 числа, день и месяц рождения. Написать программу, которая определяет знак зодиака человека.
        System.out.println(zodiacSign(1, 3));
        //Некоторые тесты для проверки задач. Можно также написать свои тесты.
        printArray();
        System.out.println(operation(1));
        System.out.println(operation(0));
        System.out.println(calculateCountOfOddElementsInMatrix(new int[]{1, 2, 3, 4, 5, 6}));
        countDevs(103);
        countDevs(11);
        foobar(6);
        foobar(10);
        foobar(15);
        printPrimeNumbers();
    }

    /**
     * Необходимо прочитать с консоли значение числа типа int,
     * сделать проверку что если пользователь ввел не положительное число,
     * то вывести ошибку и отправить пользователя вводить заново новое число!
     * далее создать одномерный массив типа int размера прочитанного с консоли
     * далее заполнить массив случайными значениями
     * далее вывести массив на консоль
     */
    private static void printArray() {
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        do {
            System.out.println("Введите положительное число");
            if (scanner.hasNextInt()) { //проверка на int
                length = scanner.nextInt();
                if (length <= 0) { //проверка на положительный int, чтобы выдало сообщение об ошибке, которую допустили при вводе
                    System.out.println("Ошибка! Введено отрицательное число!");
                }
            } else {
                scanner.next();
                System.out.println("Ошибка! Введено символьное значение");
            }
        } while (length <= 0);
        int[] arr = new int[length];
        System.out.println("Полученный массив");
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt();
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    /**
     * Метод должен выполнять некоторую операцию с int "number" в зависимости от некоторых условий:
     * - if number положительное число, то необходимо number увеличить на 1
     * - if number отрицательное - уменьшить на 2
     * - if number равно 0 , то замените значение number на 10
     * вернуть number после выполнения операций
     */
    public static int operation(int number) {
        if (number > 0) {
            number++;
        } else if (number < 0) {
            number -= 2;
        } else {
            number = 10;
        }
        return number;
    }

    /**
     * На вход приходит массив целых чисел типа int
     * Необходимо найти количество нечетных элементов в массиве и вернуть значение в метод main,
     * в котором это значение распечатается на консоль.
     */
    public static int calculateCountOfOddElementsInMatrix(int[] ints) {
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * На вход приходит число.
     * Вывести в консоль фразу из разряда "_COUNT_ программистов",
     * заменить _COUNT_ на число которое пришло на вход в метод и заменить окончание в слове "программистов" на
     * уместное с точки зрения русского языка.
     * Пример: 1 программист, 42 программиста, 50 программистов
     *
     * @param count - количество программистов
     */
    public static void countDevs(int count) {
        int test = count % 100;
        int test2 = count % 10;
        if (test >= 10 && test <= 20) {
            System.out.println(count + " программистов");
        } else if (test2 == 1) {
            System.out.println(count + " программист");
        } else if (test2 > 1 && test2 <= 4) {
            System.out.println(count + " программиста");
        } else {
            System.out.println(count + " программистов");
        }

    }

    /**
     * Метод должен выводить разные строки в консоли в зависимости от некоторых условий:
     * - если остаток от деления на 3 равен нулю - выведите "foo" (example of number - 6)
     * - если остаток от деления на 5 равен нулю - вывести "bar" (example of number - 10)
     * - если остаток от деления на 3 и 5 равен нулю 0 ,то вывести "foobar" (example of number - 15)
     */
    public static void foobar(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("foobar");
            return;
        }
        if (number % 3 == 0) {
            System.out.println("foo");
            return;
        }
        if (number % 5 == 0) {
            System.out.println("bar");
        }
    }

    /**
     * Задача со звездочкой!
     * Метод должен печатать все простые числа <1000
     * что такое просто число (https://www.webmath.ru/poleznoe/formules_18_5.php)
     */
    public static void printPrimeNumbers() {
        for (int i = 2; i <= 1000; i++) {
            int y = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    y++;
                }
            }
            if (y <= 2) {
                System.out.print(i + " ");
            }
        }
    }

    // ниже методы для задач 1-4
    public static void weekday() {
        int random = (int) (Math.random() * 7) + 1;
        switch (random) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6, 7:
                System.out.println("Выходной");
                break;
        }
    } //Задача 1

    public static int ameba(int k) {
        int value = (int) Math.pow(2, k / 3); //формула члена геометрической прогрессии
        return value;
    } //Задача 2

    public static String numbers(int a) {
        int count = 1;
        int i = a;
        String positive = null;
        if (a < 0) { //проверяем на знак/ноль
            positive = " - это отрицательное число; ";
        } else if (a > 0) {
            positive = " - это положительное число; ";
        } else {
            positive = " - это число является нулём; ";
        }
        while (a != 0) { //проверка на количество цифр
            a = a / 10;
            count++;
        }
        return "Задание №3" + "\n" + i + positive + "количество цифр  = " + (count - 1);
    } //Задача 3

    public static String zodiacSign(int month, int day) { //Задача 4
        final String capricorn = "Козерог";
        final String aquarius = "Водолей";
        final String pisces = "Рыбы";
        final String aries = "Овен";
        final String taurus = "Телец";
        final String gemini = "Близнецы";
        final String cancer = "Рак";
        final String leo = "Лев";
        final String virgo = "Дева";
        final String libra = "Весы";
        final String scorpion = "Скорпион";
        final String sagittarius = "Стрелец";
        final String error = "Неверно введена дата";
        String zodiac;
        switch (month) {
            case 1:
                return zodiac = checkDayInRange(day, 1, 20) ? capricorn :
                        checkDayInRange(day, 21, 31) ? aquarius : error;
            case 2:
                return zodiac = checkDayInRange(day, 1, 19) ? aquarius :
                        checkDayInRange(day, 20, 29) ? pisces : error;
            case 3:
                return zodiac = checkDayInRange(day, 1, 20) ? pisces :
                        checkDayInRange(day, 21, 31) ? aries : error;
            case 4:
                return zodiac = checkDayInRange(day, 1, 21) ? aries :
                        checkDayInRange(day, 22, 30) ? taurus : error;
            case 5:
                return zodiac = checkDayInRange(day, 1, 21) ? taurus :
                        checkDayInRange(day, 22, 31) ? gemini : error;
            case 6:
                return zodiac = checkDayInRange(day, 1, 21) ? gemini :
                        checkDayInRange(day, 22, 30) ? cancer : error;
            case 7:
                return zodiac = checkDayInRange(day, 1, 22) ? cancer :
                        checkDayInRange(day, 23, 31) ? leo : error;
            case 8:
                return zodiac = checkDayInRange(day, 1, 21) ? leo :
                        checkDayInRange(day, 22, 31) ? virgo : error;
            case 9:
                return zodiac = checkDayInRange(day, 1, 23) ? virgo :
                        checkDayInRange(day, 24, 30) ? libra : error;
            case 10:
                return zodiac = checkDayInRange(day, 1, 23) ? libra :
                        checkDayInRange(day, 24, 31) ? scorpion : error;
            case 11:
                return zodiac = checkDayInRange(day, 1, 22) ? scorpion :
                        checkDayInRange(day, 23, 31) ? sagittarius : error;
            case 12:
                return zodiac = checkDayInRange(day, 1, 23) ? scorpion :
                        checkDayInRange(day, 24, 31) ? capricorn : error;
            default:
                zodiac = error;
        }
        return "Задание 4" + "\n" + zodiac;
    } //Задача 4

    private static boolean checkDayInRange(int day, int from, int to) {

        return day >= from && day <= to;
    }
}

