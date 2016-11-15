import java.util.Objects;

/**
 * Created by olymp on 07.11.2016.
 */
public class DeadLock {
    private static class Run implements Runnable {
        Object res1, res2;

        public Run(Object res1, Object res2) {
            this.res1 = res1;
            this.res2 = res2;
        }

        @Override
        public void run() {
            synchronized (res1) {
                try {
                    Thread.sleep(100);
                    System.out.println(this.hashCode()+"  res1 blocked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (res2) {
                    try {
                        Thread.sleep(100);
                        System.out.println(this.hashCode()+"  res2 blocked");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void makeDeadlock() {
        Object monitor1 = new Object();
        Object monitor2 = new Object();
        new Thread(new Run(monitor1,monitor2)).start();
        new Thread(new Run(monitor2,monitor1)).start();
    }
}
