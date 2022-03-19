package com.tms.task5.model;

import java.util.Optional;

public interface OfficeAware {
    Optional<String> getLastNameBeginningWithD();

    String getLetterAndNumberOfEmployees();
}
