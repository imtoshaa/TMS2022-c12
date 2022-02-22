package com.tms.second;

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

    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {

        System.out.println(checkAuthorization("A2d", "123-", "123"));

    }

    private static boolean checkAuthorization(String login, String password, String confirmPassword) {
        boolean checkLogin = false;
        boolean checkPassword = false;
        try {
            if (login.matches("^[a-zA-Z0-9_]{2,20}+$")) {
                checkLogin = true;
            } else {
                throw new WrongLoginException("Неверный логин");
            }
            if (password.matches("^[a-zA-Z0-9_]{2,20}+$") && password.equals(confirmPassword)) {
                System.out.println("ура");
                checkPassword = true;
            } else {
                throw new WrongPasswordException("Неверный пароль");
            }

        } catch (WrongLoginException | WrongPasswordException w) {
            System.out.println(w.getMessage());
        }
        return checkLogin && checkPassword;
    }
}
