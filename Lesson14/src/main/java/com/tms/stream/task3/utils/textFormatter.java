package com.tms.stream.task3.utils;

public abstract class textFormatter {

    public static String[] splitText(String string) {
        return string.replace("-", "").split("[\n\r]");
    }

    public static String[] splitBlackList(String string) {
        return string.split(", ");
    }

    private static String[] getWordsFromTheSentence(String sentence) {
        return sentence.split(" ");
    }
    public static boolean isWordInTheSentence(String sentence, String word) {
        for (String str : getWordsFromTheSentence(sentence)) {
            if (str.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
