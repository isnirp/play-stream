package com.flimbis.service;

import com.flimbis.MessageHandler;
import com.flimbis.model.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * component launches a service for a server
 * */
public class ServerService extends PlayService {
    private final int port;

    public ServerService(int port, Player player, MessageHandler messageHandler) {
        super(player, messageHandler);
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
             DataInputStream reader = new DataInputStream(socket.getInputStream())) {

            System.out.println("server listening on port... " + port);

            System.out.println("new client connected!!");

            listener(writer, reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (MessageMaxException e) {
            exit(e.getMessage());
        }
    }

}
