package ru.innopolis.uni.course2;

/**
 * Created by olymp on 09.11.2016.
 */
import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class HelloWorld {
//    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    private static Logger logger = LoggerFactory.getLogger("ru.innopolis.HelloWorld.main");
    static public void main(String[] ar) {
        try {
            MDC.put("name", ar[0]);
            logger.error("some");
            doSome();
        } finally {
            MDC.clear();
        }
        Test test = new Test();
        Test.Int chld = test.make();
        chld.doit();
    }
    public static void doSome() {
        logger.error("doSome ");
    }

}
