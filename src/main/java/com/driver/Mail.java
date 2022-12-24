package com.driver;
import java.util.*;
public class Mail {

    private Date date;

    public Date getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    private String sender;
    private String message;

    public Mail(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }
}
