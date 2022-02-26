package com.tms.instruments;

public interface IInstrument {
    enum Type {
        GUITAR, DRUM, TRUMPET
    }

    String KEY = "До мажор"; //в интерфейсах можно объявлять статические переменные

    void play();
}
