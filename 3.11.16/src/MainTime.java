import java.util.Objects;

/**
 * Created by olymp on 03.11.2016.
 */
public class MainTime extends Thread {
    public MainTime(Object globalMonitor) {
        this.globalMonitor = globalMonitor;
    }

    Object globalMonitor=null;

    private int secs=0;

    public int getSecs() {
        return secs;
    }

    public void setSecs(int secs) {
        this.secs = secs;
    }
    @Override
    public void run() {
        while (!interrupted()) {


            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (globalMonitor) {

                System.out.println("Spend " + ++secs + " seconds");
                globalMonitor.notifyAll();

            }
        }
    }
}
