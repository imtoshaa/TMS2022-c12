package com.tms.tasks.foutth.utils;

import org.apache.commons.lang3.StringUtils;

public class TextFormater {

    public static String[] splitByPoint(String string) {
        return string.split("\\. ");
    }

    public static boolean checkForFiveWordsInSentence(String string) {
        return string.split(" ").length >= 5;
    }

    public static boolean checkPalindromeInSentence(String string) {
        for (String str : string.split(" ")) {
            return str.equalsIgnoreCase(StringUtils.reverse(str));
        }
        return false;
    }
}
