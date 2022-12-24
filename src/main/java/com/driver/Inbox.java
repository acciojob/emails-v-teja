package com.driver;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Inbox {

    public Deque<Mail> inbox;

    public Inbox() {
        this.inbox = new LinkedList<>();
    }
}
