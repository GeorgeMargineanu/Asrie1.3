package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ServerConnection implements Runnable {

    String baseDirectory = "C:\\Users\\georg\\Desktop\\Asrie1.3\\FilesToRead\\";
    String inputFile = "Input.txt";
    String orderFile = "Orders.txt";
    String beaconFile = "Beacon.txt";
    String outputFile = "Output.txt";
    String companyFile = "Company.txt";
    String phraseologyFile = "Phraseology.txt";
    HashMap<String, String> map = new HashMap<String, String>();

    private Socket server;
    BufferedReader ois;
    PrintWriter oos;
    InetAddress address = InetAddress.getLocalHost();

    public ServerConnection(Socket s) throws IOException {
        server = s;
        this.ois = new BufferedReader(new InputStreamReader(server.getInputStream()));
        this.oos = new PrintWriter(server.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Client Addres: " + address);
                String line = "hi server";
                // oos.println(line);
                oos.flush();
                String response = ois.readLine();
                String message = response.toUpperCase();

                Main andra = new Main();
                andra.manti(message);
            }
        }
            catch(IOException e){
                e.printStackTrace();
            }
            finally{
                try {
                    ois.close();
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



