package com.tms.task5.model;

import java.util.Map;
import java.util.Optional;

public interface OfficeAware {
    Optional<String> getLastNameBeginningWithD();

    Map<String, Long> getLetterAndNumberOfEmployees();
}
