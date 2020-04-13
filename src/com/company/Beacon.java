package com.company;

public class Beacon {

    String result = "";

    public void beacon(String clearanceSplit,String keyWord){

        if(clearanceSplit.indexOf(keyWord) != -1)
        {
            this.result = keyWord;
        }
    }

    public String print()
    {
        return "DIRECT;BEACON_VALUE/" + this.result + ";";
    }
}
