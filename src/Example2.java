package lesson4;

/**
 * Created by bbb1991 on 11/3/16.
 *
 * @author Bagdat Bimaganbetov
 * @author bagdat.bimaganbetov@gmail.com
 */
public class Example2 {
    /*
     * 4.  Напишите программу, которая каждую секунду отображает на экране данные о времени,
     * прошедшем от начала сессии, а другой ее поток выводит сообщение каждые 5 секунд.
     * Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение,
     * потоком, отсчитывающим время. Не внося изменений в код потока-"хронометра",
     * добавьте еще один поток, который выводит на экран другое сообщение каждые 7 секнд.
     * Предполагается использование методов wait(), notifyAll().
     */

    private static final String REMIND_TEXT_TEMPLATE = "Прошло %d секунд.%n";
    private static final Object monitor = new Object();

    private static int counter = 0;

    private static class Chronometer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(++counter);

                synchronized (monitor) {
                    monitor.notifyAll();
                }
            }
        }
    }

    private static class Reminder implements Runnable {

        private int delay;

        public Reminder(int delay) {
            this.delay = delay;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (monitor) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        System.out.println("interrupter");
                    }
                    if (counter % delay == 0)
                        System.out.printf(REMIND_TEXT_TEMPLATE, delay);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread chronometer = new Thread(new Chronometer());

        Thread reminder5 = new Thread(new Reminder(5));
        Thread reminder7 = new Thread(new Reminder(7));

        chronometer.start();
        reminder5.start();
        reminder7.start();
//        chronometer.join();
    }
}
