package Singleton;

/**
 * Created by olymp on 21.11.2016.
 */
public class CashSingleton {
    public static CashSingleton getINSTANCE() {//DoubleCheck

        return InstanceHolder.INSTANCE;
    }

    private CashSingleton() {}
    private static class InstanceHolder {
        static final CashSingleton  INSTANCE = new CashSingleton();
    }
}
