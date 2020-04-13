package com.company;

public class Heading extends ATCorder
{

    public void heading()
    {

        this.order = Integer.valueOf(this.result);

        this.hm.put(this.order, "HEADING");
    }

    @Override
    public String print()
    {
        return "HEADING;HEADING_VALUE/" + this.order + ";";
    }
}
