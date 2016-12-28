package Prototype;

/**
 * Created by olymp on 21.11.2016.
 */
public class Main {
    public static void main(String[] arg) throws CloneNotSupportedException {
        Coin coin = new Coin(7);
        Stanok stanok = new Stanok(coin);
        Coin firstOne = stanok.createCoin();
        System.out.println("firstClone value"+firstOne+"  value"+firstOne.getValue());
        System.out.println("original value"+coin+"  value"+coin.getValue());
    }
}
