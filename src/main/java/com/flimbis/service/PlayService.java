package com.flimbis.service;

import com.flimbis.MessageHandler;
import com.flimbis.model.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/*
* Runs a service for a client or server app on the network
* listens and sends messages between parties on the network
*
* @param player
* @param messageHandler
* */
public class PlayService {
    private final Player player;
    private final MessageHandler messageHandler;

    public PlayService(Player player, MessageHandler messageHandler) {
        this.player = player;
        this.messageHandler = messageHandler;
    }

    /*
    * listens and fires messages on receive
    * cause program exit
    * @throws IOException
    * */
    protected void listen(DataOutputStream writer, DataInputStream reader) throws IOException {
        while (true) {
            // exit when message count equals message cap
            if (messageHandler.getCounter().intValue() == MessageHandler.MESSAGE_CAP) {
                System.out.println("Exiting " + player.getUserName() + "...\n");

                throw new IOException("Capacity reached");
            }

            String messageReceived = reader.readUTF();

            broadcast(messageReceived, writer);
        }
    }

    /*
    * build and broadcast message
    * @throws IOException
    * */
    protected void broadcast(String messageReceived, DataOutputStream writer) throws IOException {
        // set and track message
        messageHandler.setMessage(messageReceived);
        messageHandler.keepCount();

        // send new message
        System.out.println(player.getUserName() + " sent: " + messageHandler.getMessage());
        writer.writeUTF(messageHandler.getMessage());
    }
}
