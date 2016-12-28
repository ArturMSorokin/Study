package factoryMethod.AbstractFactory.SWT;

import factoryMethod.AbstractFactory.Button;

/**
 * Created by olymp on 21.11.2016.
 */
public class SWTButton extends Button {
    @Override
    public void show() {
        System.out.println("SWt Button");
    }
}
