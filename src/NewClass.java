

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olymp on 02.11.2016.
 */
public class NewClass {
    public NewClass() {
    }


    public static void main(String[] args) throws IOException, InterruptedException {
//        Main mn=new Main();
//        mn.doSeme(1);
        List<Thread> lst=new ArrayList();
        Thread thread=null;
        for (int i=0; i<10; i++) {
            lst.add(thread=new SysOut());
            thread.start();
        }
        for (Thread thread1 : lst) {
            thread1.join();
        }
        System.out.println(SysOut.commonResource);

//        (new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0; i<1000; ++i) {
//                    System.out.println(i*10);
//                }
//            }
//        })).run();

//
////        System.out.print(sum);
        }
    }
