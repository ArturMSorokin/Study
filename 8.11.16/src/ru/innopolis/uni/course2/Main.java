package ru.innopolis.uni.course2;

/**
 * Created by olymp on 08.11.2016.
 */
public class Main {
    public static void main(String[] a) {
        Class<Integer> clazz = Integer.class;
        try {
            clazz = (Class<Integer>)Class.forName("java.lang.Integer");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        ClassLoader.loadClass();
        Integer i = Integer.parseInt("5");
        clazz = (Class<Integer>)i.getClass();
    }

}
