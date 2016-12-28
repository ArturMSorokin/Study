package ru.innopolis.uni;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by olymp on 17.11.2016.
 */
public class DatagramSocketExample {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(1234);
            datagramSocket
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
}
