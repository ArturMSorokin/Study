package ru.innopolis.spring.Java7_8;

import java.lang.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by olymp on 06.12.2016.
 */
public class Main {
    public static void main(String[] arg) {
        Collection<Integer> collection = Arrays.asList(new Integer[]{1,2,3,4,5,6});
        Integer sumOdd = collection.stream().
                filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);

//        new Thread(()->System.out.println("1")).start();
//        Runnable
        int i=0;
//        i=9;//<-effective final.

//        test(new Functionalinterface(){
//            Test deletage = new Test();
//            @Override
//            public void doSome() {
//                deletage.print();
//            }
//        });


//        test(() -{
//                t.print()
//        })

//        test(() -> {
//            System.out.println(i);
//        });

        int k=8;
    }
//    public static void test(FunctionalInterface functionalInterface) {
//        functionalInterface.doSome();
//    }
}
