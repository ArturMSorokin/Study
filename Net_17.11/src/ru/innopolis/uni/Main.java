package ru.innopolis.uni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by olymp on 17.11.2016.
 */
public class Main {
    public static void main(String[] arg) {
    }
    private URLConnection url;
        private BufferedReader br;
        {
            try {
                url = new URL("http://ya.ru");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            "classpath://log4j.properties".length();
            br=new BufferedReader(new InputStreamReader(System.in));
        }



        public void getURL() {
            System.out.print("Enter url:");
            urlString = br.
        }
}
