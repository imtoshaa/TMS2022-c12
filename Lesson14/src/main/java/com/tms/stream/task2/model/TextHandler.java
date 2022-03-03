package com.tms.stream.task2.model;


import com.tms.stream.task2.utils.textFormatter;

public class TextHandler {
    private  String string;

    public TextHandler(String string) {
        this.string = string;
    }

    public byte[] outPutSentences() {
        StringBuilder newString = new StringBuilder();
        for (String str : textFormatter.reformatAndSplit(string)) {
            if (textFormatter.checkForFiveWordsInSentence(str) || textFormatter.checkPalindromeInSentence(str)) {
                newString.append(str).append("\n");
            }
        }
        return newString.toString().getBytes();
    }
}
