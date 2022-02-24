package com.tms.tasks.sixth.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Employee {
    private String fullName;
    private double salary;

}
