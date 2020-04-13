package com.company;

public class Turn extends ATCorder {

    String turn = "";

    public void turn (String clearance)
    {
        if(clearance.indexOf("RIGHT") != -1)
        {
            this.turn = "RIGHT";
        }

        else if(clearance.indexOf("LEFT") != -1)
        {
            this.turn = "LEFT";
        }
    }

    @Override
    public String print()
    {
        return "TURN;" + this.turn + ";" + "TURN_VALUE/" + this.result	+ ";";
    }
}
