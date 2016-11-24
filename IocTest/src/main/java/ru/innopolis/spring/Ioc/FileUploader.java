package ru.innopolis.spring.Ioc;

import org.springframework.stereotype.Component;

/**
 * Created by olymp on 24.11.2016.
 */
@Component
public class FileUploader implements Uploader {
    public boolean upload(String path, Object content) {
        System.out.println(new StringBuilder("Content")
                                            .append(content.toString())
                                            .append(" was uploaded to path ")
                                            .append(path));
        return true;
    }
}
