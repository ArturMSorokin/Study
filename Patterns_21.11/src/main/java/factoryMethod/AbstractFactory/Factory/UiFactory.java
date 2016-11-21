package factoryMethod.AbstractFactory.Factory;

import factoryMethod.AbstractFactory.Button;
import factoryMethod.AbstractFactory.Input;
import factoryMethod.AbstractFactory.Label;

/**
 * Created by olymp on 21.11.2016.
 */
public interface UiFactory {
    public Button createButton();
    public Label createLabel();
    public Input createInput();
}
