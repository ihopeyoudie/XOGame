package net.dzirt.controller;

import net.dzirt.view.GameCanvas;
import java.util.Random;

/**
 * Created by Dzirt on 24.06.2016 - 02:09.
 *
 * @Author Dzirt
 */
public class Controller {
    private static final int N_TYPE = 0;
    private static final int X_TYPE = 1;
    private static final int O_TYPE = 2;

    private int[] xoArray = {0,0,0,0,0,0,0,0,0};
    private int turnCount = 0;
    private GameCanvas gameField;

    public void init(){
        for (int k = 0; k < 9; k++) {
            xoArray[k] = N_TYPE;
            turnCount = 0;
        }
    }

    public void playerTurn(int x,int y) {
        int k = y * 3 + x;
                                            // TODO here will be checking of turn token. if now enemy's turn - do nothing
        if (xoArray[k] == N_TYPE){
            turnCount++;
            xoArray[k] = X_TYPE;            //TODO this will be something like PLAYER_TYPE (need to chose in the start of game)
            System.out.println(turnCount + "  Player win?  " + checkWin(X_TYPE));                                //TODO add checkWin method calling

            if (checkWin(X_TYPE)){
                gameField.showWinner("Player");
            }
            enemyTurn();                    //TODO this method will delete and replaced by waiting of net opponent turn


            gameField.setXoArray(xoArray);
            gameField.refresh();
        }
    }

    private void enemyTurn(){
        if(turnCount < 9){
            Random rnd = new Random();
            int i;
            do {
                i = rnd.nextInt(8);
            } while(xoArray[i] != N_TYPE); //TODO here need to create ai

            turnCount++;
            xoArray[i] = O_TYPE;
            System.out.println(turnCount + "  Enemy win?  " + checkWin(O_TYPE));
            if (checkWin(X_TYPE)){
                gameField.showWinner("Computer");
            }
            //TODO add checkWin method calling
        }
    }

    private boolean checkWin(int type){
        if (    (checkThree(0,1,2,type)) ||
                (checkThree(3,4,5,type)) ||
                (checkThree(6,7,8,type)) ||
                (checkThree(0,3,6,type)) ||
                (checkThree(1,4,7,type)) ||
                (checkThree(2,5,8,type)) ||
                (checkThree(0,4,8,type)) ||
                (checkThree(2,4,6,type))) {
            return true;
        }
        return false;
    }

    private boolean checkThree(int i1, int i2, int i3, int type){
        return ((xoArray[i1] == type) && (xoArray[i2] == type) && (xoArray[i3] == type));
    }

    public void setGameField(GameCanvas gameField) {
        this.gameField = gameField;
    }
}
