package ru.innopolis.spring.Java7_8&8;

/**
 * Created by olymp on 06.12.2016.
 */
@FunctionalInterface
public interface FunctionalInterface {
    public void doSome();
    public int hashCode();
    default void doSomeDefault() {
        int i = hashCode();
        System.out.println(i);
    }
//    public void doSomeAbstract();
}
