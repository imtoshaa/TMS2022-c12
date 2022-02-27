package com.tms.first.model;

public class GasTank {

    private int fullVolume;
    private int volume = 5;

    public GasTank(int fullVolume) {
        this.fullVolume = fullVolume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getFullVolume() {
        return fullVolume;
    }

    public void burningFuel(GasTank gasTank, int volume) {
        gasTank.volume -= volume;
    }
}
