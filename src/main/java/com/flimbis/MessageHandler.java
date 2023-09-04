package com.flimbis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
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
    private List<String> messages;
    private Stack<String> stackStuff;
    private Set<String> setStuff;
    private Map<String, String> mapStuff;
    private String[] arrayStuff;
//    ConcurrentHashMap
    private String message;
    Object dummy;


    public MessageHandler() {
        this.counter = new AtomicInteger(0);
    }

    public int getCounter() {
        return counter.get();
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
