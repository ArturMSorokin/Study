package ru.innopolis.uni;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by olymp on 17.11.2016.
 */
public class ClientSocket {
    public static void main(String[] arg) {
        Socket s;
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(Pattern.compile("\\n"));
        try {
            s = new Socket("localhost",3456);
            InputStream inputStream = s.getInputStream();
            OutputStream outputStream = s.getOutputStream();
            String tmp = null;
            do {
                if (scanner.hasNext())
                tmp=scanner.next();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while(scanner.hasNext());
            byte[] info = new byte[100];
            inputStream.read(info);
            String str = new String(info);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
