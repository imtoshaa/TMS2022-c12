package com.tms.tasks.foutth.model;

import com.tms.tasks.foutth.utils.TextFormater;

public class TextHandler {
    private  String string;

    public TextHandler(String string) {
        this.string = string;
    }

    public StringBuilder outPutSentences() {
        StringBuilder newString = new StringBuilder();
        for (String str : TextFormater.splitByPoint(string)) {
            if (TextFormater.checkForFiveWordsInSentence(str) || TextFormater.checkPalindromeInSentence(str)) {
                newString.append(str).append(". ");
            }
        }
        return newString;
    }
}
