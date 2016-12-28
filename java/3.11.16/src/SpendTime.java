/**
 * Created by olymp on 03.11.2016.
 */
public class SpendTime extends Thread {
    private int spendTime;
    private int spendCounter;
    Object monitor=null;

    public SpendTime(int spendTime, Object monitor) {
        this.spendTime = spendTime;
        this.monitor = monitor;
        this.spendCounter=this.spendTime;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("Notified");
                if (--spendCounter<0) {
                    spendCounter=spendTime;
                    System.out.println("Elapsed "+spendTime+" seconds");
                }
            }
        }
    }
}
