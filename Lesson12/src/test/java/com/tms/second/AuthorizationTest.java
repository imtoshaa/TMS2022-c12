package com.tms.second;

import com.tms.second.exception.WrongLoginException;
import com.tms.second.exception.WrongPasswordException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AuthorizationTest {

    @Test
    public void exceptionCauseMessageIfAvailable() throws Exception {
        Authorization authorization = new Authorization();
        String[] stringsActual = new String[3];
        stringsActual[0] = Authorization.exceptionCauseMessageIfAvailable(new WrongPasswordException("Ошибка в поле пароль",
                new WrongLoginException("Ошибка в поле логин")));
        stringsActual[1] = Authorization.exceptionCauseMessageIfAvailable(new WrongPasswordException("Ошибка в поле пароль",
                new Exception()));
        stringsActual[2] = Authorization.exceptionCauseMessageIfAvailable(new WrongLoginException("Ошибка в поле логин"));

        String[] stringsExpected = new String[3];
        stringsExpected[0] = "Ошибка в поле логин\n" + "Ошибка в поле пароль";
        stringsExpected[1] = "Ошибка в поле пароль";
        stringsExpected[2] = "Ошибка в поле логин";

        for (int i = 0; i < stringsActual.length; i++) {
            assertEquals(stringsExpected[i], stringsActual[i]);
        }
    }
}