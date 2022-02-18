package com.tms.instruments;

public class Drum implements IInstrument {
    private final int size;

    public Drum(int size) {
        this.size = size;
    }

    public void play() {
        System.out.println("Играет барабан, размер барабана = " + size);
    }
}
