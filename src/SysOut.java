import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.ObjDoubleConsumer;

/**
 * Created by olymp on 03.11.2016.
 */


public class SysOut extends Thread {
    SysOut(Object monitor) {
        this.monitor=monitor;
    }
    {
//        commonResource = new ArrayList();
    }
    Object monitor ;
    private boolean inc=true;
    static boolean predicate = true;
    @Override
    public void run() {
        System.out.println("Thread runned!");
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                System.out.println("In Catch!");
                e.printStackTrace();
            }
        }
        System.out.println("Thread execution!");
    }
}
