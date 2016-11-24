package ru.innopolis.spring.Ioc;

/**
 * Created by olymp on 24.11.2016.
 */
public class Main {
    public static void main(String[] arg) {
        DataHandler dataHandler = new DataHandler();
        dataHandler.hadleData("someSrcPath","someDestPath");
    }
}
