package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ServerConnection implements Runnable {

    private Socket server;
    BufferedReader ois;
    PrintWriter oos;
    InetAddress address= InetAddress.getLocalHost();
    public ServerConnection(Socket s) throws IOException
    {
        server = s;
        this.ois = new BufferedReader(new InputStreamReader(server.getInputStream()));
        this.oos = new PrintWriter(server.getOutputStream());
    }

    @Override
    public void run()
    {
            try {
                while (true) {
                    System.out.println("Client Addres: " + address);
                    String line = "hi server";
                   // oos.println(line);
                    oos.flush();
                    String response = ois.readLine();
                    System.out.println(response);
               }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    ois.close();
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


