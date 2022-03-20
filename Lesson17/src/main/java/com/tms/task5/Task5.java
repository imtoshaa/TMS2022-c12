package com.tms.task5;

import com.tms.task5.model.Office;
import com.tms.task5.model.OfficeAware;
import com.tms.task5.model.Person;

import java.util.Arrays;
import java.util.Optional;

//5) Задан список сотрудников, которые хранятся в коллекции List<p3.Person>.
//        * Объект p3.Person содержит имя и фамилию(по желанию другие данные)
//        *  a) написать метод, который отображает все фамилии, начинающиеся на букву "Д".
//        *     Внимание! метод должен вернуть объект Optional<String>.
//        *  b*)Со звездочкой. Написать метод, который будет выводить в столбик первую букву фамилии и рядом количество сотрудников,
//        *  у которых фамилия начинается с этой буквы.
//        *  Пример: Антонов, Петров, Сидоров, Александров...
//        *  на экран выведет:
//        *  A - 2 сотрудника
//        *  П - 1 сотрудник
//        *  С - 1 сотрудник
public class Task5 {

    public static void main(String[] args) {
        OfficeAware office = new Office(Arrays.asList(
                new Person("Антон", "Овсейчик"),
                new Person("Даниил", "Дубровин"),
                new Person("Павел", "Ильюкевич"),
                new Person("Вадим", "Добронравов")
        ));
        Optional<String> optionalPerson = office.getLastNameBeginningWithD();
        if (optionalPerson.isPresent()) { //проверка на наличие элементов
            System.out.println(optionalPerson.get());
        } else {
            System.out.println("Not present!");
        }
        office.getLetterAndNumberOfEmployees()
                .forEach((s, aLong) -> {
                    if (aLong % 10 == 1) {
                        System.out.println(s + " - " + aLong + " сотрудник");
                    }
                    if (aLong % 10 >= 2 && aLong % 10 <= 4) {
                        System.out.println(s + " - " + aLong + " сотрудника");
                    }
                    if (aLong % 10 >= 5) {
                        System.out.println(s + " - " + aLong + " сотрудников");
                    }
                });
    }
}
