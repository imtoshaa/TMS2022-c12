package com.tms.task6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Reader {

    private String name;
    private EmailAddress emailAddress;
    private boolean isAgreeToReceiveMessages;
    private List<Book> books;
}
