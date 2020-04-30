package com.company;

public class Descend extends ATCorder {

    public void descend()
    {
        this.order = Integer.valueOf(this.result);
        if(this.order > 600)
        {
            this.hm.put(this.order, "ALTITUDE_VALUE");
        }
        else this.hm.put(this.order,"LEVEL_VALUE");
    }

    public String print()
    {
        {
            String string = this.hm.get(this.order);
            //System.out.println(string);
            if(this.hm.get(this.order).contains("LEVEL_VALUE") )
                return "LEVEL/DESCEND;" + string + "/" + this.order + ";";
            else return "ALTITUDE/DESCEND;" + string + "/" + this.order + ";";
        }
    }
}