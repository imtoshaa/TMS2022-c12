package by.teachmeskills.person.utils;

import lombok.Getter;

@Getter
public enum ClothesType {
    JACKET("Куртка"),
    PANTS("Штаны"),
    SHOES("Обувь");

    private String name;

    ClothesType(String name) {
        this.name = name;
    }
}
