package com.company;

public class Climb extends ATCorder {

    public void climb()
    {
        this.order = Integer.valueOf(this.result);

        if (this.order > 600) hm.put(this.order, "ALT");
        else this.hm.put(this.order,"FL");
    }

    @Override
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
