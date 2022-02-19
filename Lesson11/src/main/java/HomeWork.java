public class HomeWork {


    /**
     *
     * Задача1:
     * Интерфейс Инструмент
     *
     * 1) Создать интерфейс Инструмент(внутри enum Type с перечислением типов инструментов) и реализующие его классы Гитара, Барабан и Труба.
     * 2) Интерфейс Инструмент содержит метод play() и переменную String KEY ="До мажор".
     * 3) Гитара содержит переменные класса количествоСтрун,  Барабан - размер, Труба - диаметр.
     * 4) Создать массив типа Инструмент, содержащий инструменты разного типа.
     * 5) Наполнять массив инструментами необходимо через метод createInstrument,
     * который на вход принимает Тип инструмента(enum) и создает конкретный инструмен   т.
     * 6) В цикле вызвать метод play() для каждого инструмента, который должен выводить строку
     * "Играет такой-то инструмент, с такими-то характеристиками".
     *
     *
     * Задача2: Времена года
     *
     * 1) Создать перечисление, содержащее названия времен года.
     * 2) Создать переменную содержащую ваше любимое время года и распечатать всю информацию о нем.
     * 3) Создать метод, который принимает на вход переменную созданного вами enum типа.
     *  Если значение равно Лето, выводим на консоль “Я люблю лето” и так далее. Используем оператор switch.
     * 4) Перечисление должно содержать переменную, содержащую среднюю температуру в каждом времени года.
     * 5) Добавить конструктор принимающий на вход среднюю температуру.
     * 6) Создать метод getDescription, возвращающий строку “Холодное время года”.
     *  Переопределить метод getDescription - для константы Лето метод должен возвращать “Теплое время года”.
     * 7) В цикле распечатать все времена года, среднюю температуру и описание времени года.
     *
     *
     * Задача3: Одежда
     *
     * 1) Создать перечисление, содержащее размеры одежды (XXS, XS, S, M, L).
     * Перечисление содержит метод getDescription, возвращающий строку "Взрослый размер".
     * Переопределить метод getDescription - для константы XXS метод должен возвращать строку “Детский размер”.
     * Также перечисление должно содержать числовое значение euroSize(32, 34, 36, 38, 40), соответствующее каждому размеру.
     * Создать конструктор, принимающий на вход euroSize.
     * 2) Создать интерфейсы "Мужская Одежда" с методом "одетьМужчину" и "Женская Одежда" с методом "одетьЖенщину".
     * 3) Создать абстрактный класс Одежда, содержащий переменные - размер одежды, стоимость, цвет.
     * 4) Создать классы наследники Одежды - Футболка (реализует и нтерфейсы "Мужская Одежда" и "Женская Одежда"),
     * Штаны (реализует интерфейсы "Мужская Одежда" и "Женская Одежда"), Юбка (реализует интерфейсы "Женская Одежда"),
     * Галстук (реализует интерфейсы "Мужская Одежда").
     * 5) Создать массив, содержащий все типы одежды. Создать класс Ателье, содержащий методы одетьЖенщину,
     * одетьМужчину, на вход которых будет поступать массив, содержащий все типы одежды.
     * Метод одетьЖенщину выводит на консоль всю информацию о женской одежде. То же самое для метода одетьМужчину.
     *
     *
     * Задача4
     * Создать абстрактный класс Фрукт и классы Яблоко, Груша, Абрикос расширяющие его.
     * Класс Фрукт содержит:
     * а) переменную вес,
     * б) метод printManufacturerInfo(){System.out.print("Made in Belarus");} который нельзя изменить в наследнике.
     * в) абстрактный метод, возвращающий стоимость фрукта, который должен быть переопределен в каждом классе наследнике.
     * Метод должен учитывать вес фрукта(Т.е в зависимости от веса разная цена)
     * Создать несколько объектов разных классов.
     * Подсчитать общую стоимость проданных фруктов.
     * А также общую стоимость отдельно проданных яблок, груш и абрикос.
     *
     * Задача5*(звездочка)
     * Используя перечисления(enum), реализовать программу по вычислению площади фигуры (метод getSquare).
     * Создать классы Фигура, Линия, Треугольник, Прямоугольник. Можно пользоваться интерфейсами, при необходимости!
     * Если у фигуры нельзя вычислить площадь, то метод не должен быть реализован в в этом классе.
     * Добавить фигуры в массив, пробежать по массиву и вызвать метод getSquare.
     * Внимание!!! пользоваться instanceof НЕЛЬЗЯ, тут нужно применить перечисления.
     */

}