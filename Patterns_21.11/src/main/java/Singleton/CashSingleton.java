package Singleton;

/**
 * Created by olymp on 21.11.2016.
 */
public class CashSingleton {
    public static CashSingleton getINSTANCE() {//DoubleCheck 
        if (INSTANCE == null)
            synchronized (CashSingleton.class) {
                if (INSTANCE == null)
                    INSTANCE = new CashSingleton();
            }
        return INSTANCE;
    }

    private static CashSingleton INSTANCE = null;
    private CashSingleton() {}
}
