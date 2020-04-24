package com.company;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Orders extends Main {

    public static String[]  Order(String[] voiceCommands)	throws Exception
    {
        //read orders

        List<String> lines = new ArrayList<String>();
        Main asrie = new Main();

        File toread = new File(asrie.baseDirectory + asrie.orderFile);
        Scanner scan = new Scanner(toread);
        int c = 0;
        while(scan.hasNextLine())
        {
            lines.add(scan.nextLine());
            c++;
        }
        String[] orders = lines.toArray(new String[c]);
        scan.close();
        String[] result = new String[100];

        for(int ind = 0 ; ind < result.length; ind++)
        {
            result[ind] = "";
        }

        //read beacon
        List<String> list = new ArrayList<String>();

        int indexx = 0;

        File file = new File(asrie.baseDirectory + asrie.beaconFile);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext())
        {
            list.add(scanner.nextLine());
            indexx++;
        }
        scanner.close();
        String[] beacon = list.toArray(new String[indexx]);

        for(int ind = 0 ; ind < beacon.length; ind++)
        {
            beacon[ind] = beacon[ind].toUpperCase();
        }

        //*************
        String[][] clearances = new String[20][20];
        String clearanceSplit = new String();
        for(int i = 0; i < voiceCommands.length; i++)
        {
            int	Substring = 0;
            int[] index = new int[100];

            index[0] = 0;
            Substring++;
            int commandIndex = 0;

            for(int j = 0; j < orders.length; j++)
            {
                if(voiceCommands[i].indexOf(orders[j]) != -1)
                {
                    commandIndex = voiceCommands[i].indexOf(orders[j]);
                    index[Substring] = commandIndex;
                    Substring++;
                }
            }

            commandIndex = voiceCommands[i].length();
            index[Substring] = commandIndex;
            Substring++;

            for(int i_index = 0 ; i_index < Substring - 1; i_index++)
            {
                System.out.println( voiceCommands[i].substring(index[i_index], index[i_index+1]));
                clearances[i][i_index] = voiceCommands[i].substring(index[i_index], index[i_index+1]);
                clearanceSplit = clearances[i][i_index];
                //System.out.println(clearanceSplit);
                //System.out.println(index[i_index]);

                for(int k = 0; k < orders.length; k++)
                {
                    if(clearanceSplit.indexOf(orders[k]) != -1)
                    {
                        String keyWord = orders[k];
                        switch(orders[k])
                        {
                            case "DESCEND":	 { 	Descend level = new Descend();
                                level.getNumbers(clearanceSplit, keyWord);
                                level.descend();
                                result[i] += level.print();
                                break;
                            }
                            case "DESCENT":	 { 	Descend level = new Descend();
                                level.getNumbers(clearanceSplit, keyWord);
                                level.descend();
                                result[i] += level.print();
                                break;
                            }
                            case "CLIMB":	 { 	Climb climb = new Climb();
                                climb.getNumbers(clearanceSplit, keyWord);
                                climb.climb();
                                result[i] += climb.print();
                                break;
                            }
                            case "SPEED":	 { 	Speed speed = new Speed();
                                speed.getNumbers(clearanceSplit, keyWord);
                                speed.speed();
                                result[i] += speed.print();
                                break;
                            }
                            case "SQAWK":	 { 	SQAWK sqawk = new SQAWK();
                                sqawk.getNumbers(clearanceSplit, keyWord);
                                sqawk.Sqawk();
                                result[i] += sqawk.print();
                                break;
                            }
                            case "CONTACT":	 { 	Contact contact = new Contact();
                                contact.getNumbers(clearanceSplit, keyWord);
                                contact.contact();
                                result[i] += contact.print();
                                break;
                            }
                            case "DECIMAL":	 { 	Decimal decimal = new Decimal();
                                decimal.getNumbers(clearanceSplit, keyWord);

                                decimal.decimal();
                                result[i] += decimal.print();
                                break;
                            }
                            case "HEADING":	 { 	Heading heading = new Heading();
                                heading.getNumbers(clearanceSplit, keyWord);
                                heading.heading();
                                result[i] += heading.print();
                                break;
                            }
                            case "DIRECT" :	{
                                for (int m = 0; m < beacon.length; m++)
                                {
                                    if(clearanceSplit.indexOf(beacon[m]) != -1)
                                    {
                                        Beacon beaconOrder = new Beacon();
                                        beaconOrder.beacon(clearanceSplit,beacon[m]);
                                        result[i] += beaconOrder.print();
                                    }
                                }
                                break;
                            }
                            case"TURN": 	{
                                Turn turn = new Turn();
                                turn.getNumbers(clearanceSplit, keyWord);
                                turn.turn(clearanceSplit);
                                result[i] += turn.print();
                                break;
                            }
                            default: break;
                        }
                    }
                }
            }
        }

        return result;

    }
}

