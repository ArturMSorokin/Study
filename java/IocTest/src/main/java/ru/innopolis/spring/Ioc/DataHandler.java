package ru.innopolis.spring.Ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by olymp on 24.11.2016.
 */
@Component
@Scope(value = "")
public class DataHandler {
    @Autowired
    private Downloader downloader;
    @Autowired
    private Uploader uploader;


//    public DataHandler(Downloader downloader, Uploader uploader) {
//        this.downloader = downloader;
//        this.uploader = uploader;
//    }

    public DataHandler() {
    }

    public void hadleData(String srcPath, String destPath){
        String content = this.downloader.download(srcPath);
        String handledContent = handle(content);
        this.uploader.upload(destPath, handledContent);
    }

    private String handle(String content) {
        return content.toLowerCase();
    }

    public Downloader getDownloader() {
        return downloader;
    }

    public void setDownloader(Downloader downloader) {
        this.downloader = downloader;
    }

    public Uploader getUploader() {
        return uploader;
    }

    public void setUploader(Uploader uploader) {
        this.uploader = uploader;
    }
}
