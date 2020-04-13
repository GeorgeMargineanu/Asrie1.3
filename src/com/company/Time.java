package com.company;


import java.util.Date;
import java.text.SimpleDateFormat;

public class Time {

    public static String time()
    {
        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        return timeFormat.format(currentDate);
    }
}