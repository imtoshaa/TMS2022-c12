package com.tms.stream.task5;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(value = { "str", "model_name" })
public class Car {

    @JsonProperty("brand_name")
    private String brand; //я потыкал в аннотацию @JsonProperty, там без вариантов вроде как, надо через конструктор
    //в интернете поискал, тоже нет примеров, чтобы работало с двумя строками
    @JsonProperty("max_speed")
    private int maxSpeed;
    @JsonProperty("price")
    private int price;

//    @JsonCreator
//    public Car (
//        @JsonProperty("brand_name") String brandName,
//        @JsonProperty("model_name") String modelName) {
//            this.brand = brandName + " " + modelName;
//
//    }

    @Override
    public String toString() {
        return "Это автомобиль " +
                "марки " + brand + ". " +
                "Максимальная скорость составляет " + maxSpeed + " км/ч. " +
                "Цена " + price + " $.";
    }
}

