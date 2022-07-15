package by.teachmeskills.forJUnit;

import by.teachmeskills.forJUnit.annotation.FieldCustomVal;

import java.lang.reflect.Field;

public class Main {

    @FieldCustomVal
    public String myFieldWithDefaultVal;

    @FieldCustomVal(value = "My custom val")
    public String myFieldWithCustomVal;

    public static void main(String[] args) throws IllegalAccessException {
        Main m = new Main();

        for(Field field : Main.class.getFields()){
            FieldCustomVal fieldCustomVal = field.getAnnotation(FieldCustomVal.class);
            field.set(m, fieldCustomVal.value());
        }

        System.out.println(m.myFieldWithDefaultVal);
        System.out.println(m.myFieldWithCustomVal);
    }
}
