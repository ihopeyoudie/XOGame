package net.dzirt.controller;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Dzirt on 25.06.2016 - 15:17.
 *
 * @Author Dzirt
 */
public class Client {
    private Socket client = null;


    public Client(){
        try {
            System.out.println("Connecting to Server");
            client = new Socket("localhost", 1234);
        } catch (IOException e) {
            System.out.println("Can not connect");
            e.printStackTrace();
        }
    }

}
