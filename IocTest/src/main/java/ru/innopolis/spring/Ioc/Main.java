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
        dataHandler.hadleData("someSrcPath","someDestPath");

    }
}
