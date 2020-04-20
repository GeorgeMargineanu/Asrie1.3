package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;

public class ServerConnection implements Runnable {

    String baseDirectory = "C:\\Users\\georg\\Desktop\\Asrie1.3\\FilesToRead\\";
    String inputFile = "Input.txt";
    String orderFile = "Orders.txt";
    String beaconFile = "Beacon.txt";
    String outputFile = "Output.txt";
    String companyFile = "Company.txt";
    String phraseologyFile = "Phraseology.txt";
    HashMap<String , String> map = new HashMap< String, String>();

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

                    map.put("ZERO", "0");
                    map.put("ONE", "1");
                    map.put("TWO", "2");
                    map.put("THREE","3");
                    map.put("FOUR", "4");
                    map.put("FIVE", "5");
                    map.put("SIX", "6");
                    map.put("SEVEN", "7");
                    map.put("EIGHT", "8");
                    map.put("NINE", "9");
                    map.put("ONE HUNDRED", "100");
                    map.put("ONE THOUSAND", "1000");


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


