package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {
    final static int ServerPort = 9876;


    public static void main(String args[]) throws UnknownHostException, IOException {
        InetAddress ip = InetAddress.getByName("localhost");

        Socket socket = new Socket(ip, ServerPort);
        DataInputStream ois = new DataInputStream((socket.getInputStream()));

        try {
            while (true) {
                String serverResponse = ois.readLine();
                if (serverResponse != null)
                    System.out.println("Server says " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
