package com.company;

public class Decimal extends ATCorder
{

    public void decimal(){

        this.order = Integer.valueOf(this.result);

        this.hm.put(this.order, ".");
    }

    @Override
    public String print()
    {
        return "." + this.order + ";";
    }
}
