package com.tms.second.service;

import static com.tms.second.service.Authorization.checkAuthorization;
import static com.tms.second.service.Authorization.exceptionCauseMessageIfAvailable;

public class Second {
    /**
     * Создать статический метод "checkAuthorization" который будет вызваться из метода main и принимает на вход три параметра: login, password и confirmPassword. Поле login должен содержать:
     * - Tолько латинские буквы, цифры и знак подчеркивания.
     * - Длина login должна быть меньше 20 символов.
     * (Если не знаете как проверить первое условие, то проверяем только 2 условие - вызваем метод lenght())
     * Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
     * Password должен содержать:
     * - Только латинские буквы, цифры и знак подчеркивания.
     * -  Длина password должна быть меньше 20 символов.
     * (Если не знаете как проверить первое условие, то проверяем только 2 условие - вызваем метод lenght())
     * Также password и confirmPassword должны быть равны. Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
     * WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию,
     * второй принимает сообщение исключения и передает его в конструктор класса Exception.
     * Обработка исключений проводится внутри метода "checkAuthorization".
     * Используем multi-catch block. Метод "checkAuthorization" возвращает true, если значения верны или false в другом случае.
     * В методе main вызваем метод checkAuthorization и печатаем на консоль результат выполнения метода.
     * <p>
     * PS: если не знаем как сделать проверку, то можно просто оставить пустую реализацию! Прорабатываем работу с исключениями
     */

    public static void main(String[] args) throws Exception {
        try {
            System.out.println(checkAuthorization("awdф", "123ф", "123"));
        } catch (Exception exception) {
            System.out.println(exceptionCauseMessageIfAvailable(exception));
        }
    }
}

