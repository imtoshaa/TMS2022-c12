package com.tms.clothes;

import com.tms.clothes.utils.Sizes;
import com.tms.clothes.utils.Type;

public class Dressmaker {

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
            case TSHIRT -> TShirt.builder()
                    .color(color)
                    .cost(cost)
                    .size(size.getEuroSize())
                    .build();
        };
    }
}
