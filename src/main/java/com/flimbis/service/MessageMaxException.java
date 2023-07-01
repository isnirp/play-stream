package com.flimbis.service;

public class MessageMaxException extends RuntimeException{
    public MessageMaxException(String msg) {
        super(msg);
    }
}
