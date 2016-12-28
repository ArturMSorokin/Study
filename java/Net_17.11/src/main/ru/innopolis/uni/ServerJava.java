package ru.innopolis.uni;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by olymp on 17.11.2016.
 */
public class ServerJava {
    public static void main(String[] arg) {
        ServerSocket ss = null;
        Socket client = null;
        try {
            ss = new ServerSocket(3456);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client = ss.accept();
            Reader inputStream = new InputStreamReader(client.getInputStream());
            OutputStream outputStream = client.getOutputStream();
            String tmp;
            char[] input = new char[100];
            do {
                inputStream.read(input);
                if ((tmp = new String(input)).length()==0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else
                    for (char c : input)
                        c=0;
                if (tmp.length()>0) {
                    outputStream.write(tmp.getBytes());
                    System.out.println(tmp);
                }
            } while (!tmp.equals("exit"));
            outputStream.write("helloworld!".getBytes());
            ss.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
