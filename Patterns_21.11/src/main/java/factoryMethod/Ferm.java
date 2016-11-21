package factoryMethod;

/**
 * Created by olymp on 21.11.2016.
 */
public class Ferm {
    private Transport transport;
    public Ferm() {
        this.transport = new Truck();
    }
    public static void main(String[] arg) {
        Ferm ferm = new Ferm();
        ferm.start();

    }
    public void start() {
        Object cargo = createProduct();
        this.transport.transport(cargo);
    }
    public Object createProduct() {
        return new Object();
    }
}
