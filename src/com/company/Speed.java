package com.company;

public class Speed extends ATCorder {

    public void speed(){

        this.order = Integer.valueOf(this.result);

        if (this.order < 10) hm.put(this.order, "M");
        else this.hm.put(this.order, "MPH");

        //System.out.println(hm);
    }

    @Override
    public String print ()
    {
        //String string = this.hm.get(this.order);
        //System.out.println(string);
        //if(this.hm.get(this.order).contains("LEVEL_VALUE") )
        return "SPEED;IAS_VALUE/"  + this.order + ";";
        //else return "ALTITUDE/DESCEND;" + string + "/" + this.order + ";";
    }
}
