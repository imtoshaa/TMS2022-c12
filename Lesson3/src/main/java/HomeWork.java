import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        //Задачи:
        //1) Используя тип данных char и операцию инкремента вывести на консоль все буквы английского алфавита
        printEnglishAlphabet();
        //2)Проверка четности числа
        //Создать программу, которая будет сообщать, является ли целое число, введённое пользователем,
        // чётным или нет. Ввод числа осуществлять с помощью класса Scanner.
        // Если пользователь введёт не целое число, то сообщать ему об ошибке.
        evenNumber();
        //3) Меньшее по модулю число
        //Создать программу, которая будет выводить на экран меньшее по модулю из трёх введённых
        // пользователем вещественных чисел с консоли.
        minModul();
        //4) На некотором предприятии инженер Петров создал устройство, на табло которого показывается количество секунд,
        // оставшихся до конца рабочего дня. Когда рабочий день начинается ровно в 9 часов утра — табло отображает «28800» (т.е. остаётся 8 часов),
        // когда времени 14:30 — на табло «9000» (т.е. остаётся два с половиной часа), а когда наступает 17 часов — на табло отображается «0»
        // (т.е. рабочий день закончился).
        //Программист Иванов заметил, как страдают офисные сотрудницы — им неудобно оценивать остаток рабочего дня в секундах.
        // Иванов вызвался помочь сотрудницам и написать программу, которая вместо секунд будет выводить на табло понятные фразы с информацией о том,
        // сколько полных часов осталось до конца рабочего дня. Например: «осталось 7 часов», «осталось 4 часа», «остался 1 час», «осталось менее часа».
        //Итак, в переменную n должно записываться случайное (на время тестирования программы) целое число из [0;28800],
        // далее оно должно выводиться на экран (для Петрова) и на следующей строке (для сотрудниц) должна
        // выводиться фраза о количестве полных часов, содержащихся в n секундах.
        timePetrov();
        //5) Необходимо написать программу, которая будет выводить на консоль таблицу приведения типов!
//              byte	short	char	int 	long	float	double	boolean
//    byte
//    short
//    char
//    int
//    long
//    float
//    double
//    boolean
//
//    На пересечении напишите следующие фразы:
//    ня (неявное) – если преобразование происходит автоматически,
//    я (явное) – если нужно использовать явное преобразование,
//    х – если преобразование невозможно,
//    т  - если преобразование тождественно.
//    Внимание! используйте System.out.printLn
        typeConversion();
//
        /**
         * 6) Метод должен вернуть среднее значение из массива чисел
         * (необходимо сумму всех элеменов массива разделить на длину массива)
         * <p>
         * Example:
         * array = {1,2,3,4,5}
         * Метод должен return 3.0
         */
    }

    public static double average(int[] array) {

        return 0;
    }

    /**
     * 7) Метод должен вернуть максимальый элемент массива. Пример: array = {1,2,10,3} метод возвращает 10
     **/
    public static int max(int[] array) {

        return 0;
    }

    private static void printEnglishAlphabet() { //сделал через коды acii
        System.out.println("Задание №1");
        for (int i = 65; i < 91; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println();
    }

    private static void evenNumber() {

        System.out.println("Задание №2");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для проверки на чётность");
        double a = scanner.nextDouble();
        if ((int) a == a) {
            if (a % 2 == 0) {
                System.out.println("Число " + (int) a + " чётное");
            } else {
                System.out.println("Число " + (int) a + " нечётное");
            }
        } else {
            System.out.println("Ошибка! Число " + a + " не является целым числом");
        }

    }

    private static void minModul() {
        System.out.println("Задание №3");
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        System.out.println("Введите 3 числа через Enter для проверки на наименьший модуль");
        for (int i = 0; i < 3; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = Arrays.stream(arr).map(Math::abs).max().getAsInt();//погуглил классы для работы с массивами
        //также можно сделать сортировку с использованием for и if, но это не так красиво, а также занимает больше кода
        for (int i = 0; i < 3; i++) {
            if (Math.abs(arr[i]) == max) {
                System.out.println("Наибольшее по модулю число " + arr[i]);
            }
        }
    }

    private static void timePetrov() {
        System.out.println("Задание №4");
        int random = (int) (Math.random() * ((28800 - 0) + 1));
        System.out.println("Таймер для программиста Петров " + random + " секунд");
        System.out.println("Таймер для сотрудниц " + (int) (random / 3600));
    }

    public static void typeConversion() {
        String[][] tabl = {
                {"       ", "byte   ", "short  ", "char   ", "int    ", "long   ", "float  ", "double ", "boolean"},
                {"byte   ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"short  ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"char   ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"int    ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"long   ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"float  ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"double ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
                {"boolean", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       "},
        };

        for (int i = 1; i < tabl.length; i++) {
            for (int j = 0; j < tabl.length; j++) {
                if (i == j) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "т"; //отнимает символы с конца строки. Погуглил.
                }
                if ((Objects.equals(tabl[i][0], "byte   ") && Objects.equals(tabl[0][j], "boolean")) || (Objects.equals(tabl[i][0], "boolean") && Objects.equals(tabl[0][j], "byte   "))) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(tabl[i][0], "short  ") && Objects.equals(tabl[0][j], "boolean")) || (Objects.equals(tabl[i][0], "boolean") && Objects.equals(tabl[0][j], "short  "))) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(tabl[i][0], "char   ") && Objects.equals(tabl[0][j], "boolean")) || (Objects.equals(tabl[i][0], "boolean") && Objects.equals(tabl[0][j], "char   "))) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(tabl[i][0], "int    ") && Objects.equals(tabl[0][j], "boolean")) || (Objects.equals(tabl[i][0], "boolean") && Objects.equals(tabl[0][j], "int    "))) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(tabl[i][0], "long   ") && Objects.equals(tabl[0][j], "boolean")) || (Objects.equals(tabl[i][0], "boolean") && Objects.equals(tabl[0][j], "long   "))) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(tabl[i][0], "float  ") && Objects.equals(tabl[0][j], "boolean")) || (Objects.equals(tabl[i][0], "boolean") && Objects.equals(tabl[0][j], "float  "))) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
                if ((Objects.equals(tabl[i][0], "double ") && Objects.equals(tabl[0][j], "boolean")) || (Objects.equals(tabl[i][0], "boolean") && Objects.equals(tabl[0][j], "double "))) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
                if (Objects.equals(tabl[i][0], "byte   ") && Objects.equals(tabl[0][j], "short  ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "byte   ") && Objects.equals(tabl[0][j], "int    ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "byte   ") && Objects.equals(tabl[0][j], "long   ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "byte   ") && Objects.equals(tabl[0][j], "double ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "byte   ") && Objects.equals(tabl[0][j], "float  ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "short  ") && Objects.equals(tabl[0][j], "int    ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "short  ") && Objects.equals(tabl[0][j], "long   ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "short  ") && Objects.equals(tabl[0][j], "double ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "short  ") && Objects.equals(tabl[0][j], "float  ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "char   ") && Objects.equals(tabl[0][j], "int    ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "char   ") && Objects.equals(tabl[0][j], "long   ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "char   ") && Objects.equals(tabl[0][j], "double ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "char   ") && Objects.equals(tabl[0][j], "float  ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "int    ") && Objects.equals(tabl[0][j], "long   ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "int    ") && Objects.equals(tabl[0][j], "double ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "int    ") && Objects.equals(tabl[0][j], "float  ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "long   ") && Objects.equals(tabl[0][j], "double ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "long   ") && Objects.equals(tabl[0][j], "float  ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][0], "float  ") && Objects.equals(tabl[0][j], "double ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 2) + "ня";
                }
                if (Objects.equals(tabl[i][j], "       ")) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "я";
                }
            }
        }
        for (String[] strings : tabl) {
            System.out.println(Arrays.toString(strings));
        }
    }
}
