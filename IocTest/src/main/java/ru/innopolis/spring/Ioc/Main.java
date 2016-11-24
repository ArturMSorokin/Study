package ru.innopolis.spring.Ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by olymp on 24.11.2016.
 */
public class Main {
    public static void main(String[] arg) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"});
//        DataHandler dataHandler = new DataHandler();
//        dataHandler.setDownloader(new FileDownloader());//in spring
//        dataHandler.setUploader(new FileUploader());//in spring
        DataHandler dataHandler = (DataHandler)applicationContext.getBean("dataHandler");
        DataHandler dataHandler1 = (DataHandler)applicationContext.getBean("dataHandler");
        DataHandler dataHandler2 = new DataHandler();
        DataHandler dataHandler3 = (DataHandler)new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}).getBean("dataHandler");
        System.out.println(dataHandler==dataHandler1);
        System.out.println(dataHandler==dataHandler2);
        System.out.println(dataHandler==dataHandler3);
        dataHandler.hadleData("someSrcPath","someDestPath");

    }
}
