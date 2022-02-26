package by.teachmeskills.person.utils;

import lombok.Getter;

@Getter
public enum Brand {
    ADIDAS("адидас"),
    PUMA("пума"),
    ZARA("зара");

    private String name;

    Brand(String name) {
        this.name = name;
    }
}
