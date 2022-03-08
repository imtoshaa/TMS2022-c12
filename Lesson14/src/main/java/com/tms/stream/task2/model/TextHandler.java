package com.tms.stream.task2.model;


import com.tms.stream.task2.utils.TextFormatterUtils;

import static com.tms.stream.task2.utils.TextFormatterUtils.reformatAndSplit;

public class TextHandler {
    private  String string;
    private String text;
    private String black;

    public TextHandler(String text, String black) {
        this.text = text;
        this.black = black;
    }
    public TextHandler(String string) {
        this.string = string;
    }

    public byte[] outPutSentences() {
        StringBuilder newString = new StringBuilder();
        for (String str : reformatAndSplit(string)) {
            if (TextFormatterUtils.checkForFromThreeToFiveWordsInSentence(str) || TextFormatterUtils.checkPalindromeInSentence(str)) {
                newString.append(str).append("\r");
            }
        }
        return newString.toString().getBytes();
    }

    public byte[] outPutCensoredSentence() {
        StringBuilder newString = new StringBuilder();
        boolean isCensored = true;
        for (String sentence : TextFormatterUtils.splitText(text)) { //берём предложение
            for (String word : TextFormatterUtils.splitBlackList(black)) { //берём слово
                if (TextFormatterUtils.isWordInTheSentence(sentence, word)) {
                    newString.append(sentence).append("\n");
                    isCensored = false;
                }
            }
        }
        if (isCensored) {
            return ("Текст цензурен").getBytes();
        }
        return newString.toString().getBytes();
    }
}
