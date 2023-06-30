package com.flimbis;


import com.flimbis.model.Player;
import com.flimbis.service.ClientComponent;
import com.flimbis.service.ServerComponent;

/**
 * Player stream app
 */
public class App {
    public static void main(String[] args) {

        int port = Integer.parseInt(args[0]);

        try {
            startAsClient(port);
        } catch (Exception e) {
            startAsServer(port);
        }

    }

    private static void startAsServer(int port) {
        System.out.println("starting server... ");

        Player master = new Player("master-player");
        new ServerComponent(port, master, new MessageHandler());

    }

    private static void startAsClient(int port) {
        System.out.println("starting client ...");

        Player initiator = new Player("initiator-player");
        new ClientComponent("127.0.0.1", port, initiator, new MessageHandler());
    }

}
