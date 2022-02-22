package by.teachmeskills.person.utils;

import lombok.Getter;

@Getter
public enum BrandName {
    ADIDAS("адидас"),
    PUMA("пума"),
    ZARA("зара");

    private String name;

    BrandName(String name) {
        this.name = name;
    }
}
