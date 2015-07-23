package com.Hellel.PSoloid.tictactoe;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class RandomAiGameStrategy implements AiGameStrategy {
    @Override
    public int aiMakeTurn(int[] field) {

        while (true) {
            int cell = (int) (Math.random() * 8);
                   if (field[cell] ==0){
                       return cell;
                   }
        }
    }
}
