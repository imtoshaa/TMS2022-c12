package com.tms.stream.task3.model;


import com.tms.stream.task3.utils.textFormatter;

public class TextHandler {
    private String text;
    private String black;

    public TextHandler(String text, String black) {
        this.text = text;
        this.black = black;
    }

    public byte[] outPutSentences() {
        StringBuilder newString = new StringBuilder();
        boolean isCensored = true;
        for (String sentence : textFormatter.splitText(text)) { //берём предложение
            for (String word : textFormatter.splitBlackList(black)) { //берём слово
                if (textFormatter.isWordInTheSentence(sentence, word)) {
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
