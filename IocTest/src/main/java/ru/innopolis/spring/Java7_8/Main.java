package ru.innopolis.spring.Java7_8;

import java.lang.*;
import java.lang.FunctionalInterface;

/**
 * Created by olymp on 06.12.2016.
 */
public class Main {
    public static void main(String[] arg) {
//        new Thread(()->System.out.println("1")).start();
//        Runnable
        int i=0;
        i=9;//<-effective final.
        test(() -> {
            System.out.println(i);

        });
    }
    public static void test(FunctionalInterface functionalInterface) {
        functionalInterface.doSome();
    }
}
