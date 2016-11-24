package ru.innopolis.spring.Ioc;

/**
 * Created by olymp on 24.11.2016.
 */
public class FileDownloader implements Downloader {
    public String download(String path) {
        System.out.println(new StringBuilder("resource from path ")
                .append(path)
                .append(" was  downloaded") );
        return "content";
    }
}
