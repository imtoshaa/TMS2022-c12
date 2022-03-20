package com.tms.task5.model;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
    public Map<String, Long> getLetterAndNumberOfEmployees() {
//                .forEach((s, aLong) ->  {
//                    if (aLong % 10 == 1) {
//                        s = s + " - " + aLong + " сотрудник" + '\n';
//                    }
//                    if (aLong % 10 >= 2 && aLong % 10 <= 4) {
//                        s = s + " - " + aLong + " сотрудника" + '\n';
//                    }
//                    if (aLong % 10 >= 5) {
//                        s = s + " - " + aLong + " сотрудников" + '\n';
//                    }
//                });
        return personList.stream()
                .map(Person::getLastName)
                .collect(Collectors.groupingBy(s -> String.valueOf(s.toCharArray()[0]), Collectors.counting()));
    }
}
