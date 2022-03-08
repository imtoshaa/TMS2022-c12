package com.tms.stream.task5;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car =  objectMapper.readValue(new File(
                "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw5\\car.json")
                , Car.class);

        System.out.println(car);
    }
}
