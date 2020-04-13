package com.company;

import java.io.*;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    private static ExecutorService pool = Executors.newFixedThreadPool(5);
    private static ServerSocket server;
    private static int port = 9876;

    public static void main(String args[]) throws IOException, ClassNotFoundException {

        server = new ServerSocket(port);

        while (true)
        {
            System.out.println("Waiting for the client request");

            Socket socket = server.accept();
            System.out.println("client connected");



           ClientHandler clientThread = new ClientHandler(socket,clients);


            clients.add(clientThread);
            pool.execute(clientThread);
        }
    }
}