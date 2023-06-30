package com.flimbis.service;

import com.flimbis.MessageHandler;
import com.flimbis.model.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientComponent extends PlayComponent {
//    private final Player player;
//    private final MessageHandler messageHandler;

    public ClientComponent(String host, int port, Player player, MessageHandler messageHandler) {
        super(player, messageHandler);
//        this.messageHandler = messageHandler;
//        this.player = player;

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

   /* public void buildChat(DataOutputStream writer, DataInputStream reader) throws IOException {
        while (true) {
            // exit when message count equals message cap
            if (messageHandler.getCounter().intValue() == MessageHandler.MESSAGE_CAP) {
                System.out.println("Exiting " + player.getUserName() + "...");
                System.exit(0);
            }

            String messageReceived = reader.readUTF();

            sendMessage(messageReceived, writer);

        }
    }*/

    /*private void sendMessage(String messageReceived, DataOutputStream writer) throws IOException {
        // set and track message
        messageHandler.setMessage(messageReceived);
        messageHandler.keepCount();

        // send new message
        System.out.println(player.getUserName() + " sent: " + messageHandler.getMessage());
        writer.writeUTF(messageHandler.getMessage());
    }*/
}
