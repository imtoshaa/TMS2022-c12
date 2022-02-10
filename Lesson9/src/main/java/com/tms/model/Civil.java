package com.tms.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Civil extends Air{
    private int passengerNumber;
    private boolean businessClass;

    @Override
    public String info() {
        return super.info() + '\n'
                + "Количество пассажиров = " + passengerNumber + '\n'
                + "Наличие бизнесс-класса: " + checkForBusinessClass(businessClass);
    }

    private String checkForBusinessClass(Boolean businessClass) {
        if (businessClass) {
            return "да";
        }
        return "нет";
    }

    public void loadPassengers(int passengers) {
        if (checkСapacity(passengers)) {
            System.out.println("Самолёт загружен!");
        } else {
            System.out.println("Вам нужен самолёт побольше");
        }
    }

    private boolean checkСapacity(int passengers) {
        if (passengers <= passengerNumber) {
            return true;
        }
        return false;
    }
}
