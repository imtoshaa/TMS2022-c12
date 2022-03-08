package task3.model;

import lombok.Getter;

//     * 3)Написать обобщенный класс MinMax, который содержит методы для нахождения минимального и максимального элемента массива.
//     * Массив является переменной класса. Массив должен передаваться в класс через конструктор.
//     * Написать метод принимающий MinMax объект и печатающий информацию об элементах.
@Getter
public class MinMax<T extends Number & Comparable<? super T>> {

    private final T[] arrayOfNumbers;

    public MinMax(T[] array) throws Exception {
        if (array != null) {
            this.arrayOfNumbers = array;
        } else {
            throw new Exception();
        }
    }

    public T[] sortArray() { //решил вспомнить сортировку пузырьками;
        //сделал отдельно от getMax и getMin, так как лучше я объявлю в мэйне этот метод один раз,
//        чем будет два раза идти одна и та же процедура перебора этого массива
        for (int i = arrayOfNumbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayOfNumbers[j].compareTo(arrayOfNumbers[j + 1]) > 0) {
                    T temp = arrayOfNumbers[j];
                    arrayOfNumbers[j] = arrayOfNumbers[j + 1];
                    arrayOfNumbers[j + 1] = temp;
                }
            }
        }
        return arrayOfNumbers;
    }

    public T getMax() {
        return arrayOfNumbers[arrayOfNumbers.length - 1];
    }

    public T getMin() {
        return arrayOfNumbers[0];
    }
}
