package ru.innopolis.spring.Ioc;

/**
 * Created by olymp on 24.11.2016.
 */
public class FileUploader implements Uploader {
    public boolean upload(String path, Object content) {
        System.out.println(new StringBuilder("Content")
                                            .append(content.toString())
                                            .append(" was uploaded to path ")
                                            .append(path));
        return true;
    }
}
