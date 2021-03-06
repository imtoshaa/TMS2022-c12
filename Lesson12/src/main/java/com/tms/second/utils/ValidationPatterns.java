package com.tms.second.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationPatterns {
    public static final String PATTERN_PASSWORD = "^[a-zA-Z0-9_]+$";
    public static final String PATTERN_LOGIN = "^[a-zA-Z0-9_]{2,20}+$";
}
