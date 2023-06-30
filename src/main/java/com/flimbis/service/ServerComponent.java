package com.flimbis.service;

import com.flimbis.MessageHandler;
import com.flimbis.model.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * creates master player
 * */
public class ServerComponent extends PlayService {

    public ServerComponent(int port, Player player, MessageHandler messageHandler) {
        super(player, messageHandler);

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
             DataInputStream reader = new DataInputStream(socket.getInputStream())) {

            System.out.println("server listening on port... " + port);

            System.out.println("new client connected!!");

            listen(writer, reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
