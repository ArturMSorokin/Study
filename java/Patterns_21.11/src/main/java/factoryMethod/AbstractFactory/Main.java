package factoryMethod.AbstractFactory;

import factoryMethod.AbstractFactory.Factory.SWTUiFactory;
import factoryMethod.AbstractFactory.Factory.UiFactory;

/**
 * Created by olymp on 21.11.2016.
 */
public class Main {
    public static void main(String[] arg) {
        UiFactory uiFactory = new SWTUiFactory();
        Button button = uiFactory.createButton();
        button.show();
        Label label = uiFactory.createLabel();
        label.show();

    }
}
