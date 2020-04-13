package com.company;

import java.util.HashMap;

public class ATCorder
{
    int order;
    String result = "";

    HashMap<Integer,String> hm = new HashMap<Integer,String>();

    public void getNumbers(String Clearance, String keyWord)
    {
        int strlen = keyWord.length();
        int max = Math.min(strlen + 15, Clearance.length());
        int clearanceIndex = strlen;

        for(; clearanceIndex < max; clearanceIndex++)
        {
            char toAnalise = Clearance.charAt(clearanceIndex);
            if (toAnalise != ' ' && Character.isDigit(toAnalise))
            {
                //System.out.println(toAnalize);
                this.result += toAnalise;
                //System.out.println(order);
            }
        }
    }

    public String print()
    {
        {
            String string = this.hm.get(this.order);
            //System.out.println(string);
            if(this.hm.get(this.order).contains("LEVEL_VALUE") )
                return "LEVEL/CLIMB;" + string + "/" + this.order + ";";
            else return "ALTITUDE/CLIMB;" + string + "/" + this.order + ";";
        }
    }
}

