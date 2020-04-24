package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {

    String baseDirectory = "C:\\Users\\georg\\Desktop\\Asrie1.3\\FilesToRead\\";
    String inputFile = "Input.txt";
    String orderFile = "Orders.txt";
    String beaconFile = "Beacon.txt";
    String outputFile = "Output.txt";
    String companyFile = "Company.txt";
    String phraseologyFile = "Phraseology.txt";

    public  void manti(String message) throws FileNotFoundException {
        HashMap<String , String> map = new HashMap< String, String>();

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

        List<String> lines = new ArrayList<String>();
        Main asrie = new Main();


        String[] voiceCommands = {""} ;
        voiceCommands[0] = message;


        for( int i = 0; i < voiceCommands.length; i++)
        {
            voiceCommands[i] = voiceCommands[i].toUpperCase();
            String[] voiceSplit = voiceCommands[i].split(" ");

            for(int j = 0; j < voiceSplit.length; j++)
            {
                if(map.get(voiceSplit[j]) != null)
                {
                    voiceCommands[i] = voiceCommands[i].replace(voiceSplit[j], map.get(voiceSplit[j]));
                }
            }
        }

        String[] resultCallsign = new String[100];
        String[] resultOrder = new String[100];
        String[] result = new String[100];


        try {
            resultCallsign = CallSign.callSign(voiceCommands);
            resultOrder = Orders.Order(voiceCommands);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Time.time();
        System.out.println(voiceCommands[0]);
        for(int index = 0 ; index < voiceCommands.length; index++)
        {
            result[index] = Time.time() +";" + resultCallsign[index] + ";" + resultOrder[index] + ":";
           System.out.println(result[index]);
        }

        try
        {
            PrintWriter TXToutputStream = new PrintWriter(asrie.baseDirectory + asrie.outputFile);
            for (int j = 0 ; j < result.length; j++)
            {
                if (result[j] != null)
                    TXToutputStream.println(result[j]);
            }

            TXToutputStream.flush();
            TXToutputStream.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}

