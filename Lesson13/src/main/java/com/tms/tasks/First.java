package com.tms.tasks;

public class First {
    //    1) Вырезать подстроку из строки начиная с первого вхождения символа(А) до, последнего вхождения сивола(B).
    public static void main(String[] args) {
        System.out.println(cutFromAtoB("С АобВаВ ка"));
    }
    private static String cutFromAtoB(String string) {

        int lastB = string.lastIndexOf("В") + 1;
        return string.substring(string.indexOf("А"), lastB);
//        return string.substring(string.indexOf("А"), string.lastIndexOf("В"));
//        substring не включает в подстроку последний элемент, а lastIndexOf не позволяет к найденному значению прибавить единицу
//        пришлось сделать int lastB
    }
}
