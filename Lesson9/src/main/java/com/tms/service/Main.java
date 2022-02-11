package com.tms.service;


import com.tms.model.Civil;
import com.tms.model.Military;
import com.tms.model.Passenger;
import com.tms.model.Truck;

public class Main {
    public static void main(String[] args) {
        Truck transport1 = Truck.builder()
                .tonnage(10)
                .brand("Вольво")
                .countWheels(8)
                .maxSpeed(150)
                .fuelConsumption(35)
                .power(560)
                .weight(500).build();
        System.out.println(transport1.info() + '\n');
        transport1.loadCargo(9);
        System.out.println();
        Passenger transport2 = Passenger.builder()
                .bodyType("Седан")
                .countWheels(4)
                .brand("Мазда")
                .fuelConsumption(12)
                .maxSpeed(220)
                .power(150)
                .weight(2100)
                .passengerNumber(5).build();
        System.out.println(transport2.info() + '\n');
        transport2.trip(10);
        System.out.println();

        Civil transport3 = Civil.builder()
                .businessClass(true)
                .runwayLength(500)
                .brand("Боинг")
                .wingspan(40)
                .maxSpeed(1500)
                .power(33000)
                .weight(21)
                .passengerNumber(450).build();
        transport3.loadPassengers(460);
        System.out.println();

        Military transport4 = Military.builder()
                .countRocket(0)
                .ejectionSystem(false)
                .runwayLength(30)
                .maxSpeed(3000)
                .brand("МИГ")
                .power(45000)
                .weight(12)
                .wingspan(10).build();
        System.out.println(transport4.info());
        transport4.shot();
        transport4.eject();
    }
}
