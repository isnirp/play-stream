package com.flimbis.service;

import com.flimbis.MessageHandler;
import com.flimbis.model.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
* Component launches a service for a client
* */
public class ClientService extends PlayService {
    private final String host;
    private final int port;

    public ClientService(String host, int port, Player player, MessageHandler messageHandler) {
        super(player, messageHandler);
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        try (Socket clientSocket = new Socket(host, port);
             DataOutputStream writer = new DataOutputStream(clientSocket.getOutputStream());
             DataInputStream reader = new DataInputStream(clientSocket.getInputStream())) {

            System.out.println("client started!!");

            // set initial message
            messageHandler.setMessage(MessageHandler.MESSAGE_INIT);
            messageHandler.keepCount();

            // send message
            String msg = messageHandler.getMessage();
            System.out.println(player.getUserName() + " sent.." + msg);
            writer.writeUTF(msg);

            listener(writer, reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (MessageMaxException e) {
            exit(e.getMessage());
        }
    }

}


// Notes
// readers and writers (PrintWriter, BufferedReader) allows you to write Unicode characters over the socket.