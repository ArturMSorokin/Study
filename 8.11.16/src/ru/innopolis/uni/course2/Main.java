package ru.innopolis.uni.course2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by olymp on 08.11.2016.
 */
public class Main {


    public static void main(String[] a) throws IllegalAccessException, InvocationTargetException, InstantiationException {
/*1*/        Class<Integer> clazz = Integer.class;
        try {
/*1*/            clazz = (Class<Integer>)Class.forName("java.lang.Integer");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        ClassLoader.loadClass();
        Integer i = Integer.parseInt("5");
        clazz = (Class<Integer>)i.getClass();


        Human human = new Human();
        Class<Human> humanClass = (Class<Human>) human.getClass();
        Field[] fields = humanClass.getDeclaredFields();
        Field name = fields[1];
        name.setAccessible(true);
        name.set(human,"John");
        Field money = fields[0];
        money.setAccessible(true);
        money.set(human,50);
        System.out.println(humanClass);

        Constructor[] constructors = humanClass.getConstructors();
        Object o = constructors[0].newInstance();
        System.out.println(humanClass);

    }

}
