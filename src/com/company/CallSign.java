package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CallSign  {


    public static String[] callSign(String[] arr) throws Exception
    {
        Main asrie = new Main();

        String[] parts = new String[30];
        String[] result = new String[20];

        List<String> list1 = new ArrayList<String>(); //companies
        List<String> list2 = new ArrayList<String>(); //phraseology

        int c = 0;
        int d = 0;

        for(int i = 0; i < arr.length; i++)
        {
            result[i] = "";
           // System.out.println(arr[i]);
        }

        //	-------	GET COMPANIES
        String[] Companies = new String[20];
        for(int i = 0; i < arr.length; i++)
        {
            Companies[i] = "";
        }
        File file1 = new File(asrie.baseDirectory + asrie.companyFile);
        Scanner company = new Scanner(file1);
        while (company.hasNextLine())
        {
            list1.add(company.nextLine());
            c++;
        }

        String[] listofcompanies = list1.toArray(new String[c]);
        HashMap <String, String>  CompanyMap = new HashMap <String, String> ();
        for ( int i = 0; i < listofcompanies.length; i++)
        {
            listofcompanies[i] = listofcompanies[i].toUpperCase();
        }

        for ( int index2 = 0 ; index2 < c; index2++)
        {
            switch(listofcompanies[index2])
            {
                case "AIRFRANS": CompanyMap.put("AIRFRANCE", "AFR"); break;
                case "AIRFRANCE": CompanyMap.put("AIRFRANCE", "AFR"); break;
                case "AIR FRANCE": CompanyMap.put("AIR FRANCE", "AFR"); break;
                case "NORTHTRANS": CompanyMap.put("NORTHTRANS", "IBK"); break;
                case "SHAMROCK": CompanyMap.put("SHAMROCK", "EIN"); break;
                case "JERSEY": CompanyMap.put("JERSEY", "BEE"); break;
                case "STOBART": CompanyMap.put("STOBART", "STK"); break;
                case "AMERICAN": CompanyMap.put("AMERICAN", "AAL"); break;
                case "POYSTON": CompanyMap.put("POYSTON", "PYN"); break;
                case "IBERIA EXPRE": CompanyMap.put("IBERIA EXPRE", "IBS"); break;
                case "TUIAIR": CompanyMap.put("TUIAIR", "TOM"); break;
                default: break;
            }
        }

        for ( int i = 0; i < arr.length; i++)
        {
            parts = arr[i].split(" ");
               {
                for(int j = 0 ; j < listofcompanies.length; j++)
                {
                    if(arr[i].indexOf(listofcompanies[j]) != -1)
                    {
                        result[i] += CompanyMap.get(listofcompanies[j]);
                    }
                }
            }
        }

        char vec;
        for ( int i = 0; i < arr.length; i++)
        {
            parts = arr[i].split(" ");
            for( int k = 0; k < parts.length ; )
            {
                for(int j = 0 ; j < listofcompanies.length; j++)
                {
                    if( arr[i].indexOf(listofcompanies[j]) != -1 )
                    {
                        int l = 0;
                        l  = arr[i].indexOf(listofcompanies[j]) + listofcompanies[j].length();
                        int max = l + 8;

                        for(; l < max; l++)
                        {
                            vec = arr[i].charAt(l);
                            if (vec != ' ' && Character.isDigit(vec) )
                            {
                                result[i] += vec;
                            }
                        }
                    }
                }
                break;
            }
        }

        //---------- GET ALPHABET
        File file2 = new File(asrie.baseDirectory + asrie.phraseologyFile);
        Scanner phrase = new Scanner(file2);

        while (phrase.hasNextLine())
        {
            list2.add(phrase.nextLine());
            d++;
        }
        HashMap <String, Character>  phraseologyMap = new HashMap <String,Character> ();
        String[] phraseology = list2.toArray(new String[d]);

        for(int index1 = 0 ; index1 < d; index1 ++)
        {
            char firstCharacter1 = phraseology[index1].charAt(0);
            phraseologyMap.put(phraseology[index1], firstCharacter1);
        }

        for(int i = 0; i < arr.length ; i++)
        {
            parts = arr[i].split(" ");
            for(int k = 0; k < parts.length ; k++)
            {
                for(int j = 0 ; j < phraseology.length; j++)
                {
                    if(parts[k].indexOf(phraseology[j]) != -1)
                    {
                        result[i] += phraseologyMap.get(phraseology[j]) ;
                    }
                }
            }
        }

        phrase.close();
        company.close();
        return(result);
    }
}