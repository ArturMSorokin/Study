package Prototype;

/**
 * Created by olymp on 21.11.2016.
 */
public class Coin implements Cloneable{
    private int value;

    public Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
