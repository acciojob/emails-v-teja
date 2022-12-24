package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Stack;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    private Inbox inbox;
    private Trash trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new Inbox();
        this.trash = new Trash();
    }


    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(getInboxSize()<inboxCapacity){
            Mail mail = new Mail(date,sender,message);
            inbox.inbox.offer(mail);
        }else{
            trash.trash.offer(inbox.inbox.poll());
            Mail mail = new Mail(date,sender,message);
            inbox.inbox.offer(mail);
        }

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        int pos = 0;
        Iterator iterator = inbox.inbox.iterator();
        Mail temp = null;
        while(iterator.hasNext()){
            temp = (Mail) iterator.next();
            if(temp.getMessage().equals(message)){
                break;
            }
            pos++;
        }
        inbox.inbox.remove(temp);

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(getInboxSize()==0){
            return null;
        }
            Mail temp = inbox.inbox.getLast();
            return temp.getMessage();

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(getInboxSize()==0){
            return null;
        }
        Mail temp = inbox.inbox.getFirst();
        return temp.getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count = 0;
        Iterator iterator = inbox.inbox.iterator();
        while(iterator.hasNext()){
            Mail temp = (Mail) iterator.next();
            if(temp.getDate().compareTo(start)>=0 && temp.getDate().compareTo(end)<=0){
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
        int n = getTrashSize();
        for(int i=0;i<n;i++){
            trash.trash.poll();
        }
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
