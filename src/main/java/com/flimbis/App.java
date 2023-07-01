package com.flimbis;


import com.flimbis.model.Player;
import com.flimbis.service.ClientService;
import com.flimbis.service.ServerService;

/**
 *
 * @author Prince Amankwah
 * Player stream app
 */
public class App {
    public static void main(String[] args) {

        int port = Integer.parseInt(args[0]);
        int mode = Integer.parseInt(args[1]);

        if (mode != 1) { // run in separate process
            try {
                startAsClient(port).run();
            } catch (Exception e) {
                startAsServer(port).run();
            }
        } else { // run in same process
            new Thread(startAsServer(port)::run).start();
            new Thread(startAsClient(port)::run).start();
        }

    }

    private static ServerService startAsServer(int port) {
        System.out.println("starting server... ");

        Player master = new Player("master-player");
        return new ServerService(port, master, new MessageHandler());
    }

    private static ClientService startAsClient(int port) {
        System.out.println("starting client ...");

        Player initiator = new Player("initiator-player");
        return new ClientService("127.0.0.1", port, initiator, new MessageHandler());
    }

}
