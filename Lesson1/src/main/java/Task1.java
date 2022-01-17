import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int k = 0; //счётчик положительных чисел
        int a;
        Scanner scanner = new Scanner(System.in); //включил считывание строки из консоли
        String str = scanner.nextLine(); //присвоил значение из консоли строке str
        String[] arrstr = str.split(" ");//с помощью метода split разделил строку на состовляющие и заполнил массив String
        for (int i = 0; i < arrstr.length; i++) {
            a = Integer.parseInt(arrstr[i]); //используем метод parseInt для конвертации переменных string в int и тут же заполняем массив
            if (a > 0) { //сравниваем с нулём и плюсуем счётчик, если положительное
                k++;
            }
        }
        System.out.println("Положительных чисел в строке " + k);
    }
}
