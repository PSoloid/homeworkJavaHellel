package com.Hellel.PSoloid.tictactoe;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class GameLogic {
    //default

    public int [] cells = new int[9];

    private AiGameStrategy aiGameStrategy;


    public boolean makeTurn(int position){

        if (cells[position] == 0){
            cells[position] = 1;
            return true;
        }else{
            return false;
        }
    }
    public int aIMakeTurn(){
        int position = aiGameStrategy.aiMakeTurn(cells);
        cells[position] = -1;
        return position;
    }

    public void setAiGameStrategy(AiGameStrategy gameStrategy){
        this.aiGameStrategy=gameStrategy;
    }

    public boolean checkPlayerWin() {
        if ((cells[0]==1 && cells[1]==1 && cells[2]==1) ||
            (cells[3]==1 && cells[4]==1 && cells[5]==1) ||
            (cells[6]==1 && cells[7]==1 && cells[8]==1) ||
            (cells[0]==1 && cells[3]==1 && cells[6]==1) ||
            (cells[1]==1 && cells[4]==1 && cells[7]==1) ||
            (cells[2]==1 && cells[5]==1 && cells[8]==1) ||
            (cells[0]==1 && cells[4]==1 && cells[8]==1) ||
            (cells[2]==1 && cells[4]==1 && cells[6]==1)){
            return true;
        }
        else return false;
    }

    public boolean checkAiWin() {
        if ((cells[0]==-1 && cells[1]==-1 && cells[2]==-1) ||
            (cells[3]==-1 && cells[4]==-1 && cells[5]==-1) ||
            (cells[6]==-1 && cells[7]==-1 && cells[8]==-1) ||
            (cells[0]==-1 && cells[3]==-1 && cells[6]==-1) ||
            (cells[1]==-1 && cells[4]==-1 && cells[7]==-1) ||
            (cells[2]==-1 && cells[5]==-1 && cells[8]==-1) ||
            (cells[0]==-1 && cells[4]==-1 && cells[8]==-1) ||
            (cells[2]==-1 && cells[4]==-1 && cells[6]==-1)){
            return true;
        }
        else return false;
    }

    public boolean checkDraw() {
        for (int c: cells) {
            if (c == 0) {
                return false;
            }
        }
        return true;
    }
}
