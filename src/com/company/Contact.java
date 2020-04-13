package com.company;

public class Contact extends ATCorder {

    public void contact()
    {
        this.order = Integer.valueOf(this.result);
        this.hm.put(this.order, "CONTACT");
    }

    @Override
    public String print()
    {
        return "TRANSFER_ACTIVE;FREQUENCE_VALUE/" + this.order ;
    }

}
