package factoryMethod;

import factoryMethod.Factory.TransportFactory;
import factoryMethod.Factory.TruckFactory;

/**
 * Created by olymp on 21.11.2016.
 */
public class Ferm {
    private TransportFactory transport;

    public TransportFactory getTransport() {
        return transport;
    }

    public void setTransport(TransportFactory transport) {
        this.transport = transport;
    }

    public Ferm(TransportFactory transport) {
        this.transport = transport;
    }
    public static void main(String[] arg) {
        Ferm ferm = new Ferm(new TruckFactory());
        ferm.start();

    }
    public void start() {
        Object cargo = createProduct();
        this.transport.factoryMethod().transport(cargo);
    }
    public Object createProduct() {
        return new Object();
    }
}
