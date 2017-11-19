package com.rnd.golovach;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id;
    private  String message;
    private Date  date;
    private DateFormat dateFormat;

    Random randomGenerator = new Random();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public  Event (Date date, DateFormat dateFormat){
        this.date = date;
        this.dateFormat = dateFormat;
        id = randomGenerator.nextInt(100);
    }

    @Override
    public String toString(){
        return "\r\nidEvent - " + id +"\nmessageEvent - " + message + "\ndateEvent - " +date + " " +dateFormat.format(date);
    }
}
