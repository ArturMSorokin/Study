import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.ObjDoubleConsumer;

/**
 * Created by olymp on 03.11.2016.
 */


public class SysOut extends Thread {
    SysOut() {
//        this.commonResource=list;
    }
    {
//        commonResource = new ArrayList();
    }
    static Object ob = new Object();
    private boolean inc=true;
    @Override
    public void run() {
        for (int i=0; i<1000000; ++i) {
            synchronized (ob) {
                commonResource++;
            }
        }
    }
    public static int  commonResource;

    public int getCommonResource() {
        return commonResource;
    }

    public void setCommonResource(int commonResource) {
        this.commonResource = commonResource;
    }
}
