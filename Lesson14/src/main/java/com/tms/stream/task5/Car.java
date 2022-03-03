package com.tms.stream.task5;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(value = { "str" })
public class Car {

    @JsonAlias ("brand_name")
    private String brand;
    @JsonAlias ("max_speed")
    private int maxSpeed;
    private int price;

    @JsonCreator
    public Car (
        @JsonProperty("brand_name") String brandName,
        @JsonProperty("model_name") String modelName,
        @JsonProperty("max_speed") int maxSpeed,
        @JsonProperty("price") int price) {
            this.brand = brandName + " " + modelName;
            this.maxSpeed = maxSpeed;
            this.price = price;
    }

    @Override
    public String toString() {
        return "Это автомобиль " +
                "марки " + brand + ". " +
                "Максимальная скорость составляет " + maxSpeed + " км/ч. " +
                "Цена " + price + " $.";
    }
}

