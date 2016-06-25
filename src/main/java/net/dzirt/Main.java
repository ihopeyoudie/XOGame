package net.dzirt;

import net.dzirt.controller.Controller;
import net.dzirt.view.GameCanvas;
import net.dzirt.view.StartWindow;

import javax.swing.*;

/**
 * Created by Dzirt on 21.06.2016 - 23:07.
 *
 * @Author Dzirt
 */
public class Main {
    public static void main(String[] args) {

//        StartWindow startWindow = new StartWindow();
//        startWindow.init();
//        startWindow.show();




        JFrame gameFrame = new JFrame("Tic-Tac-Toe");
        GameCanvas cnv = new GameCanvas();

        cnv.setFocusable(true);
        gameFrame.setSize(308,350);
        gameFrame.setLocation(300,300);
        gameFrame.setResizable(false);

        cnv.addMouseListener(cnv.getMouseListener());
        gameFrame.add(cnv);

        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

        Controller controller = new Controller();
        controller.init();
        controller.setGameField(cnv);
        cnv.setController(controller);

    }
}
