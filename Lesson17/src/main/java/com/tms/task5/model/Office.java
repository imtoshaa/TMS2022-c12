package com.tms.task5.model;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//        *  a) написать метод, который отображает все фамилии, начинающиеся на букву "Д".
//        *     Внимание! метод должен вернуть объект Optional<String>.
//        *  b*)Со звездочкой. Написать метод, который будет выводить в столбик первую букву фамилии и рядом количество сотрудников,
//        *  у которых фамилия начинается с этой буквы.
//        *  Пример: Антонов, Петров, Сидоров, Александров...
//        *  на экран выведет:
//        *  A - 2 сотрудника
//        *  П - 1 сотрудник
//        *  С - 1 сотрудник
@AllArgsConstructor
public class Office implements OfficeAware {

    private List<Person> personList;

    @Override
    public Optional<String> getLastNameBeginningWithD() {
        return personList.stream()
                .map(Person::getLastName)
                .filter(lastName -> lastName.charAt(0) == 'Д')
                .reduce((person, person2) -> person + "\n" + person2);
    }

    @Override
    public String getLetterAndNumberOfEmployees() {
        return personList.stream()
                .map(Person::getLastName)
                .map(s -> s = String.valueOf(s.toCharArray()[0]))
                .distinct()
                .map(s -> {
                    int count = 0;
                    for (Person person : personList) {
                        if (s.equals(String.valueOf(person.getLastName().toCharArray()[0]))) {
                            count++;
                        }
                    }
                    if (count % 10 == 1) {
                        return s + " - " + count + " сотрудник" + '\n';
                    }
                    if (count % 10 >= 2 && count % 10 <= 4) {
                        return s + " - " + count + " сотрудника" + '\n';
                    }
                    if (count % 10 >= 5) {
                        return s + " - " + count + " сотрудников" + '\n';
                    }
                    return "null";
                })
                .collect(Collectors.joining());
    }
}
