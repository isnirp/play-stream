package com.flimbis.service;

import com.flimbis.MessageHandler;
import com.flimbis.model.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PlayComponent {
    private final Player player;
    private final MessageHandler messageHandler;

    public PlayComponent(Player player, MessageHandler messageHandler) {
        this.player = player;
        this.messageHandler = messageHandler;
    }

    protected void listen(DataOutputStream writer, DataInputStream reader) throws IOException {
        while (true) {
            // exit when message count equals message cap
            if (messageHandler.getCounter().intValue() == MessageHandler.MESSAGE_CAP) {
                System.out.println("Exiting "+player.getUserName()+"...");
                System.exit(0);
            }

            String messageReceived = reader.readUTF();

            broadcast(messageReceived, writer);
        }
    }

    protected void broadcast(String messageReceived, DataOutputStream writer) throws IOException {
        // set and track message
        messageHandler.setMessage(messageReceived);
        messageHandler.keepCount();

        // send new message
        System.out.println(player.getUserName() + " sent: " + messageHandler.getMessage());
        writer.writeUTF(messageHandler.getMessage());
    }
}
