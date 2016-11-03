

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by olymp on 02.11.2016.
 */
public class NewClass {
    public NewClass() {
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        Object globaoMonitor = new Object();
        SysOut sysOut=new SysOut(globaoMonitor);
        sysOut.start();
        calculate();
//        sysOut.interrupt();
        synchronized (globaoMonitor) {
            globaoMonitor.notify();
        }

        }

        public static void calculate() {
            try {
                Thread.sleep(5_000);
                System.out.println("Calculate is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
