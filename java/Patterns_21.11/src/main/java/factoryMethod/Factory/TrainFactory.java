package factoryMethod.Factory;

import factoryMethod.Train;
import factoryMethod.Transport;

/**
 * Created by olymp on 21.11.2016.
 */
public class TrainFactory implements TransportFactory{


    @Override
    public Transport factoryMethod() {
        return new Train();
    }
}
