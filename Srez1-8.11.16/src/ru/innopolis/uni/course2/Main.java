package ru.innopolis.uni.course2;

import java.util.*;
import java.util.function.IntBinaryOperator;

/**
 * Created by olymp on 08.11.2016.
 */
public class Main {

    private static class AThread extends Thread {
        Object monitor;

        public AThread(Object monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            while (!interrupted()) {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (monitor) {
                    try {
                        monitor.wait(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (isComplete()) {
                        return;
                    } else {
                        int newValue = (int)(Math.random()*100.0);
                        addRandomNumber(newValue);
                        monitor.notify();
                    }
                }
            }
        }
    }

    private static class BThread extends Thread {
        Object monitor;

        public BThread(Object monitor) {
            this.monitor = monitor;
        }
        @Override
        public void run() {
            while (!interrupted()) {
                synchronized (monitor) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    check5Sec();
                }
            }
        }

        public void check5Sec() {
            if ((int)(System.currentTimeMillis()/1000.0)%5==0) {
                for (int i: tmp) {
                    if (map.containsKey(i)) {
                        map.put(i, map.get(i)+1);
                    } else {
                        map.put(i, 1);
                    }
                }
                Set<Integer> keys = map.keySet();
                for (Integer key: keys) {
                    if (map.get(key)>5) {
                        setComplete(true);
                        monitor.notify();
                        return;
                    }
                }
                System.out.println("______________________________________________");
                for (Integer i : tmp) {
                    System.out.println(i+" generated "+map.get(i)+" times");
                }
                tmp.clear();
            }
        }
    }
    public static boolean complete=false;

    public static void setComplete(boolean complete) {
        Main.complete = complete;
    }

    public static boolean isComplete() {

        return complete;
    }

    public static Map<Integer,Integer> map = new HashMap<>();
    public static LinkedList<Integer> tmp= new LinkedList<>();

    public static void addRandomNumber(int num) {
        tmp.addLast(num);
    }

    public static void main(String[] args) {
        Object monitor = new Object();
        Thread threadA = new AThread(monitor);
        Thread threadB = new BThread(monitor);
        threadA.start();
        threadB.start();
    }
}
