package com.tms.second;

import com.tms.second.exception.WrongLoginException;
import com.tms.second.exception.WrongPasswordException;

import static com.tms.second.utils.ValidationPatterns.PATTERN_LOGIN;
import static com.tms.second.utils.ValidationPatterns.PATTERN_PASSWORD;

public class Authorization {


    public static boolean checkAuthorization(String login, String password, String confirmPassword) throws Exception {
        Exception exception = null;
        if (!login.matches(PATTERN_LOGIN)) {
            exception = new WrongLoginException("Ошибка в поле логин");
        }
        if (!password.matches(PATTERN_PASSWORD) || !confirmPassword(password, confirmPassword)) {
            exception = new WrongPasswordException("Ошибка в поле пароль", exception);
        }
        if (exception != null) {
            throw exception;
        }
        return true;
    }

    private static boolean confirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public static String exceptionCauseMessageIfAvailable(Exception details) {
        if (details.getCause() == null) {
            return details.getMessage();
        }
        if (details.getCause() != null && details.getCause().getMessage() == null) {
            return details.getMessage();
        }
        return details.getCause().getMessage() + "\n" + details.getMessage();
    }

//    private static String exceptionCauseMessageIfAvailable(Exception details) {
//        if (details.getCause() == null) {
//            return details.getMessage();
//        }
//        return details.getCause().getMessage();
//    }
    //в том коде, что вы кидали, всё равно выводится информация только об одном исключении, т.к.
    //return выкидывает, если есть под капотом что-то
    //так что вот так можно)

//        return message;
}
