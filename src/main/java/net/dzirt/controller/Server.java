package net.dzirt.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Dzirt on 25.06.2016 - 15:04.
 *
 * @Author Dzirt
 */
public class Server implements Runnable {
    private ServerSocket server;


    private Socket client;
    private Thread thread;


    public Server(){
        System.out.println("Server Thread creating.");
        thread = new Thread(this);
    }

    public void serverStart(){
        try {
            System.out.println("Creating new Server on port 1234...");
            server = new ServerSocket(1234);
        } catch (IOException e) {
            System.out.println("Couldn't listen to port 1234");
            e.printStackTrace();
        }
        thread.start();
    }

    public void run() {
        try {
            System.out.print("Waiting for a client...");
            client = server.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            System.out.println("Can't accept");
            e.printStackTrace();
        }
    }
}
