package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    Socket client;
    BufferedReader ois;
    DataOutputStream oos;
    private ArrayList<ClientHandler> clients;

    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException
    {
        this.client = clientSocket;
        this.clients = clients;
        this.ois = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.oos = new DataOutputStream(clientSocket.getOutputStream());
    }

    @Override
    public void run()
    {
        try
        {
        while(true)
        {
            String request = ois.readLine();
            System.out.println(request);
           // outToAll(request);
        }
        } catch (IOException e)
        {
            System.err.println("IO exception in client handler");
            System.err.println(e.getStackTrace());
        }
        finally
        {
            try
            {
                oos.close();
                ois.close();
            } catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void outToAll(String msg) throws IOException {
        for (ClientHandler aClient : clients)
        {
            aClient.oos.writeChars(msg);
        }
    }


}
