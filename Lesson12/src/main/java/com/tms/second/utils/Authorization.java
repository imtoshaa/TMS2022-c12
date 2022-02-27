package com.tms.second.utils;

import com.tms.second.exception.WrongLoginException;
import com.tms.second.exception.WrongPasswordException;
import lombok.experimental.UtilityClass;

import static com.tms.second.utils.ValidationPatterns.PATTERN_LOGIN;
import static com.tms.second.utils.ValidationPatterns.PATTERN_PASSWORD;

@UtilityClass
public class Authorization {


    public static boolean checkAuthorization(String login, String password, String confirmPassword) throws Exception {
        Exception exception = null;
        if (!login.matches(PATTERN_LOGIN)) {
            exception = new WrongLoginException("Ошибка в поле логин");
        }
        if (!password.matches(PATTERN_PASSWORD)) {
            exception = new WrongPasswordException("Неверные данные в поле пароль", exception);
        }
        if (!confirmPassword(password, confirmPassword)) {
            exception = new WrongPasswordException("Пароли не совпадают", exception);
        }
        if (exception != null) {
            throw exception;
        }
        return true;
    }

    private static boolean confirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public static String exceptionCauseMessageIfAvailable(Throwable details, StringBuilder message) {
        if (details.getCause() != null) {
            message.append(details.getMessage()).append("\n");
            exceptionCauseMessageIfAvailable(details.getCause(), message);
            return message.toString();
        }
        return  message.append(details.getMessage()).toString();
    }
    //как-то так
}
