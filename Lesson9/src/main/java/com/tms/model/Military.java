package com.tms.model;

import lombok.experimental.SuperBuilder;

import java.util.Random;

@SuperBuilder
public class Military extends Air {
    private boolean ejectionSystem;
    private int countRocket;

    @Override
    public String info() {
        return super.info() + '\n'
                + "Наличие системы катапультирования: " + checkForEjectionSystem(ejectionSystem) + '\n'
                + "Количество ракет = " + countRocket;
    }

    private String checkForEjectionSystem(Boolean ejectionSystem) {
        if (ejectionSystem) {
            return "да";
        }
        return "нет";
    }

    public void shot() {
        Random random = new Random();
        if (checkRockets()) {
            System.out.println("Ракета пошла!");
        } else {
            System.out.println("Нет ракет");
        }
    }

    private boolean checkRockets() {
        return countRocket != 0;
    }

    public void eject() {
        if (ejectionSystem) {
            System.out.println("Катапультирование прошло успешно!");
        } else {
            System.out.println("У Вас нет такой системы");
        }
    }
}
