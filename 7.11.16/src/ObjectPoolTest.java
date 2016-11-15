import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by olymp on 07.11.2016.
 */

public class ObjectPoolTest {

    private class PoolClient implements Runnable {
        ObjectPool pool;
        Object resource;

        public PoolClient(ObjectPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            try {
                resource = pool.getObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.returnObject(resource);
            resource=null;
            ClassLoader
        }
    }
//______________________________________________________________________________________
    private static class ObjectPool {
        private Object monitor=new Object();
        private int size = 10, taken = 0;
        private LinkedList pool;
        private int timeOutMs = 10;
        private void itemAdded() {taken++;}



        private void initList() {
//            for (int i = pool.size(); i < size - taken; ++i) {
//                pool.add(new Object());
//            }
        }

        {
            pool = new LinkedList();
            initList();
        }

        private void addToPool(Object object) {
            pool.add(object);
            itemAdded();
        }
        private void itemGetted() {taken--;}
        Object getObject() throws Exception {
            if (pool.size() > 0) {
                return pool.removeLast();
                this.itemGetted();
            }
            else {
                synchronized (pool) {
                    try {
                        pool.wait(timeOutMs);
                        if (pool.size() > 0) {
                            return pool.removeLast();
                        } else {
                            throw new Exception("Sorry, no Items");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        public void returnObject(Object obj) {
            pool.add(obj);
            pool.notify();
        }

        public void setTimeOutMs(int timeOutMs) {
            this.timeOutMs = timeOutMs;
        }

        public int getTimeOutMs() {
            return timeOutMs;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            if (size > this.size) {
                this.size = size;
                initList();
            }
        }


    }

    public void testPool() {
        ObjectPool pool = new ObjectPool();
        for (int i=0; i<pool.size+2; ++i) {
            new Thread(new PoolClient(pool)).start();
        }
    }
}
