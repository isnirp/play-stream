package com.flimbis.service;

import com.flimbis.MessageHandler;
import com.flimbis.model.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientComponent extends PlayService {

    public ClientComponent(String host, int port, Player player, MessageHandler messageHandler) {
        super(player, messageHandler);

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

            listen(writer, reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
