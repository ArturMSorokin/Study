package ru.innopolis.spring.JIT;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by d.sapaev on 02.12.2016.
 */
public class Main {
    private static int LOOP_COUNT = 1_000_000;
    public static void main(String[] args) throws InterruptedException {
        try(Scanner scanner = new Scanner(System.in)){
            while(scanner.hasNext()){
                createObject();
                scanner.next();
            }
        }

    }

    static Object createObject() throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < LOOP_COUNT; i++) {
            Random r = new Random();
            String s = r.nextInt() + "" + i;
            list.add(s);
        }
        return list;
    }

}