package com.company;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    private Socket client;
    private BufferedReader in;
    private PrintWriter oos;
    private ArrayList<ClientHandler> clients;

    public ClientHandler(Socket clientSocket,ArrayList<ClientHandler> clients) throws IOException {
        this.client = clientSocket;
        this.clients = clients;
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.oos = new PrintWriter(client.getOutputStream(),true);
    }

@Override
    public void run(){
        try{
            while(true){
                String request = in.readLine();
                if(request != null) {
                    System.out.println(request);
                    outToAll(request);
                }
                //??????????????????????????????????????????????????????????/
                else break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                in.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("IO exception in ClientHandler");
            }
        }
}

private void outToAll(String message){
       for (ClientHandler aclient : clients)
       {
           aclient.oos.println(message);
       }
    }
}
