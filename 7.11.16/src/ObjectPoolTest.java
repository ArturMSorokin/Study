import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by olymp on 07.11.2016.
 */

public class ObjectPoolTest {

    public class PoolClient implements Runnable {
        ObjectPool pool;
        Object resource;

        public PoolClient(ObjectPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            resource = pool.getObject();
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.returnObject(resource);
            resource=null;
        }
    }

    public class ObjectPool {
        private Object monitor=new Object();
        private int size = 10, taken = 0;
        private LinkedList pool;
        private int timeOutMs = 10;

        private void initList() {
            for (int i = pool.size(); i < size - taken; ++i) {
                pool.add(new Object());
            }
        }

        {
            pool = new LinkedList();
            initList();
        }

        public Object getObject() {
            if (pool.size() > 0)
                return pool.removeLast();
            else {
                synchronized (monitor) {
                    int wait = timeOutMs;
                    while (pool.size()<1 || wait>0) {
                        try {
                            Thread.sleep(1);
                            --wait;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return new Object();
        }

        public void returnObject(Object obj) {

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
}
