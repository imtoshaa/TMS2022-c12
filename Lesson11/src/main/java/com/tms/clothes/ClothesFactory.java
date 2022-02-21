package com.tms.clothes;

import com.tms.clothes.utils.Sizes;
import com.tms.clothes.utils.Type;

public class ClothesFactory {

    public Clothes createClothes(Type type, String color, Sizes size, int cost) {
        return switch (type) {
            case PANTS -> Pants.builder()
                    .color(color)
                    .cost(cost)
                    .size(size.getEuroSize())
                    .build();
            case SKIRT -> Skirt.builder()
                    .color(color)
                    .cost(cost)
                    .size(size.getEuroSize())
                    .build();
            case CRAVAT -> Cravat.builder()
                    .color(color)
                    .cost(cost)
                    .size(size.getEuroSize())
                    .build();
            //я думал в этом то и суть, что поступает в конструктор американский, а выводим в европейском
            case TSHIRT -> TShirt.builder()
                    .color(color)
                    .cost(cost)
                    .size(size.getEuroSize())
                    .build();
        };
    }
}
