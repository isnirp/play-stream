package com.flimbis;

import java.util.concurrent.atomic.AtomicInteger;

/*
 *  keep track of messages
 *  set cap and keep count
 *
 * */
public class MessageHandler {
    public static final int MESSAGE_CAP = 10;
    public static final String MESSAGE_INIT = "mario kart";
    private final AtomicInteger counter;
    private String message;


    public MessageHandler() {
        this.counter = new AtomicInteger(0);
    }

    public AtomicInteger getCounter() {
        return counter;
    }

    public void keepCount() {
        counter.incrementAndGet();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message + "-" + getCounter();
    }
}
