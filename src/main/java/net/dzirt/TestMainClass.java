package net.dzirt;

import net.dzirt.controller.Client;
import net.dzirt.controller.Server;

/**
 * Created by Dzirt on 25.06.2016 - 14:06.
 *
 * @Author Dzirt
 */
public class TestMainClass {
    public static void main(String[] args) {
        Server srv = new Server();
        srv.serverStart();


        Client cln = new Client();
    }
}
