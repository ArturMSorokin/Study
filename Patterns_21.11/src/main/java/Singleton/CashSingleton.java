package Singleton;

/**
 * Created by olymp on 21.11.2016.
 */
public class CashSingleton {
    public static CashSingleton getINSTANCE() {
        return INSTANCE;
    }

    private static final CashSingleton INSTANCE = null;
    private CashSingleton() {}
}
