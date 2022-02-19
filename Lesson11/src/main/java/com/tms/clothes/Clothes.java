package com.tms.clothes;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
//можно как то супербилдер сделать публичным, а не протектед? если я выношу Мэйн в другой пакет, то билдер не работает
@Getter
public abstract class Clothes {
    private int size;
    private int cost;
    private String color;
}
