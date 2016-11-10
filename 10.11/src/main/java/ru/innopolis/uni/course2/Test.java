package ru.innopolis.uni.course2;

/**
 * Created by olymp on 10.11.2016.
 */
public class Test {
    public interface Int{
        void doit();
    }

    private class Cls {
        public void doit() {
            System.out.println("sdf");
        }
    }

    public class Chld extends Cls implements Int {
        private Chld() {}
    }

    public Chld make() {
        return new Chld();
    }

}
