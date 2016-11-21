package factoryMethod.AbstractFactory.Factory;

import factoryMethod.AbstractFactory.Button;
import factoryMethod.AbstractFactory.Factory.UiFactory;
import factoryMethod.AbstractFactory.Input;
import factoryMethod.AbstractFactory.Label;

/**
 * Created by olymp on 21.11.2016.
 */
public class SWTUiFactory implements UiFactory {

    @Override
    public Button createButton() {
        return null;
    }

    @Override
    public Label createLabel() {
        return null;
    }

    @Override
    public Input createInput() {
        return null;
    }
}
