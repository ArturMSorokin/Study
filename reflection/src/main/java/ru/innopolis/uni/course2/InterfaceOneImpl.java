package ru.innopolis.uni.course2;

/**
 * Created by olymp on 08.11.2016.
 */
public class InterfaceOneImpl implements InterfaceOne {
    private int field;
    @Override
    public void doSome(int a) {
        this.field=a;
        System.out.println("loging");
    }

}
