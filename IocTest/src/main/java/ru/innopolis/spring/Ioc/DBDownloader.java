package ru.innopolis.spring.Ioc;

/**
 * Created by olymp on 24.11.2016.
 */
public class DBDownloader implements Downloader {
    public String download(String path) {
        System.out.println(new StringBuilder("Resource from DB path ")
                .append(path)
                .append(" was downloaded!")
                .toString());

        return "I am DB Content!!!";
    }
}