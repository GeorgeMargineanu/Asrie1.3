package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection implements Runnable {

    private Socket server;
    DataInputStream ois;

    public ServerConnection(Socket s) throws IOException
    {
        server = s;
        this.ois = new DataInputStream((server.getInputStream()));
    }

    @Override
    public void run()
    {
            try {
                while (true) {
                    String serverResponse = ois.readUTF();
                    System.out.println("Server says " + serverResponse);
               }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


