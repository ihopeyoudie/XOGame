package net.dzirt.view;

import net.dzirt.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Dzirt on 22.06.2016 - 00:18.
 *
 * @Author Dzirt
 */
public class GameCanvas extends Canvas implements KeyListener{
    private final int BOX_HEIGHT    = 100;
    private final int BOX_WIDTH     = 100;
    private final int GRID_HEIGHT   = 3;
    private final int GRID_WIDTH    = 3;

    private int[] xoArray = {0,0,0,0,0,0,0,0,0};
    private String turnInfo = "Just Test string";
    private Graphics globalGraphics;
    private Controller controller;


    public void setXoArray(int[] xoa) {
        this.xoArray = xoa;
    }

    public void refresh(){
        globalGraphics.clearRect(0, 0, BOX_WIDTH * GRID_WIDTH + 1, BOX_HEIGHT * GRID_HEIGHT+20);
        drawGrid(globalGraphics);
        drawXO(globalGraphics);
        drawTurnInfo(globalGraphics);
    }

    public void paint(Graphics g) {
        this.setPreferredSize(new Dimension(300, 300));
        globalGraphics = g.create();
        drawGrid(g);
        drawXO(g);
        drawTurnInfo(g);
//        this.addMouseListener(new MListener());
//        this.addKeyListener(this);
//        if(runThread == null){
//            runThread = new Thread(this);
//            runThread.start();
//        }
    }

    private void drawGrid(Graphics g){
        g.drawRect(0,0, GRID_WIDTH * BOX_WIDTH, GRID_HEIGHT * BOX_HEIGHT);
        for(int x = BOX_WIDTH; x < GRID_WIDTH * BOX_WIDTH; x += BOX_HEIGHT){
            g.drawLine(x, 0, x, BOX_HEIGHT * GRID_HEIGHT);
        }
        for(int y = BOX_HEIGHT; y < GRID_HEIGHT * BOX_HEIGHT;y += BOX_WIDTH){
            g.drawLine(0, y, BOX_WIDTH * GRID_WIDTH, y);
        }
    }

    private void drawXO(Graphics g){
        Font font = new Font("Tahoma", Font.BOLD, 110);
        g.setFont(font);
        for (int i = 0; i < xoArray.length; i++){
            Point position = new Point(i % 3, i / 3);
            if (xoArray[i] == 1){
                g.drawString("X", position.x * BOX_WIDTH + 10, position.y * BOX_HEIGHT + BOX_HEIGHT - 10);
            }
            else if (xoArray[i] == 2){
                g.drawString("O", position.x * BOX_WIDTH + 10, position.y * BOX_HEIGHT + BOX_HEIGHT - 10);
            }
        }
    }

    private void drawTurnInfo(Graphics g){
        Font font = new Font("Arial", Font.BOLD, 12);
        g.setFont(font);
        g.drawString("Turn: " + turnInfo, 10, BOX_HEIGHT * GRID_HEIGHT + 15);
    }


    private void drawWinner(Graphics g, String winner){
        Font font = new Font("Arial", Font.BOLD, 40);
        g.setFont(font);
        g.drawString("WINNER is " + winner, 10, BOX_HEIGHT * GRID_HEIGHT / 2);

    }
    public void showWinner(String winner){
        //drawWinner(globalGraphics, winner);

        if(JOptionPane.showConfirmDialog(this,winner + " WIN!", "One More Time?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            //System.out.println("Refreshing");
            controller.init();
            refresh();
        }
        else {

        }
    }
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.out.println("Refreshing");
            controller.init();
            refresh();

        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private class MListener implements MouseListener{

        public void mouseClicked(MouseEvent e) {
            //System.out.println(e.getPoint());
            int x = e.getX()/BOX_WIDTH;
            int y = e.getY()/BOX_HEIGHT;
            if (x < GRID_WIDTH && y < GRID_HEIGHT) {
                controller.playerTurn(e.getX() / BOX_WIDTH, e.getY() / BOX_HEIGHT);
            }
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

    public MouseListener getMouseListener(){
        return new MListener();
    }
}
