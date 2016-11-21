package factoryMethod.AbstractFactory.SWT;

import factoryMethod.AbstractFactory.Label;

/**
 * Created by olymp on 21.11.2016.
 */
public class SWTLabel extends Label {
    @Override
    public void show() {
        System.out.println("SWTLabel");
    }
}
