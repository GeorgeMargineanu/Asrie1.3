package  com.company;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
    final static int ServerPort = 9876;

    public static void main(String args[]) throws UnknownHostException, IOException
    {
        InetAddress ip = InetAddress.getByName("localhost");

        Socket socket = new Socket(ip, ServerPort);
        ServerConnection  serverConn = new ServerConnection(socket);

        new Thread(serverConn).start();
    }
}
