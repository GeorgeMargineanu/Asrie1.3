package com.company;

public class SQAWK extends ATCorder {

    public void Sqawk()
    {

        this.order = Integer.valueOf(this.result);

        this.hm.put(this.order, "SQAWK");
    }

    @Override
    public String print()
    {
        return "SQAWK;SQAWK_VALUE/" + this.order + ";";
    }
}
