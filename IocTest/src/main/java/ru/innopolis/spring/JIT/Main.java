package ru.innopolis.spring.JIT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olymp on 02.12.2016.
 */
public class Main {
    private static int Loop = 100_000_000;
    public static void main(String[] arg) {
        List<String> list = new ArrayList<>();
        for (int i=0; i<Loop; ++i) {
            list.add(""+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list);
    }
}
