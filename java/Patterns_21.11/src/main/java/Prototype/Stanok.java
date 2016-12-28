package Prototype;

/**
 * Created by olymp on 21.11.2016.
 */
public class Stanok {
    private Coin prototype;
    public  Stanok(Coin prototype) {
        this.prototype = prototype;
    }
    public Coin createCoin() throws CloneNotSupportedException {
        return (Coin) this.prototype.clone();
    }

}
