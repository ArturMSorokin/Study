package factoryMethod.Factory;

import factoryMethod.Transport;
import factoryMethod.Truck;

/**
 * Created by olymp on 21.11.2016.
 */
public class TruckFactory implements TransportFactory{
    @Override
    public Transport factoryMethod() {
        return new Truck();
    }
}
