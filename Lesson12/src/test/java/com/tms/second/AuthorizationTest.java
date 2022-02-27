package com.tms.second;

import com.tms.second.exception.WrongLoginException;
import com.tms.second.exception.WrongPasswordException;
import com.tms.second.utils.Authorization;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorizationTest {

    @Test
    public void exceptionCauseMessageIfAvailable() throws Exception {

        Exception exception = assertThrows(WrongLoginException.class, () -> {
            Authorization.checkAuthorization("awd-", "123", "123");
        });
        String expectedMessage = "Ошибка в поле логин";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }
}