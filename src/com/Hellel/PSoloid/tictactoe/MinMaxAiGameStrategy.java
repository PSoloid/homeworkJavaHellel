package com.Hellel.PSoloid.tictactoe;

/**
 * Created by otk_prog on 23.07.2015.
 */
public class MinMaxAiGameStrategy implements AiGameStrategy {

    @Override
    public int aiMakeTurn(int[] field) {

        int cell = -1;

        if (field[4] == 0) {
            return 4;
        }

        if (cell == -1) cell = chooseCell(field, -2);
        if (cell == -1) cell = chooseCell(field, 2);

        if (((field[1] != 0) || (field[3] != 0)) && (field[0] == 0) && (cell == -1)) return 0;
        if (((field[5] != 0) || (field[7] != 0)) && (field[8] == 0) && (cell == -1)) return 8;

        if (((field[0] == 0) || (field[2] == 0) || (field[6] == 0) || (field[8] == 0)) && (cell ==-1 )) {
            while (true) {
                switch ((int) (Math.random() * 3)) {
                    case 0:
                        if (field[0] == 0) return 0;
                        break;
                    case 1:
                        if (field[2] == 0) return 2;
                        break;
                    case 2:
                        if (field[6] == 0) return 6;
                        break;
                    case 3:
                        if (field[8] == 0) return 8;
                        break;
                }
            }
        }

        if (cell == -1) cell = chooseCell(field, -1);

        if (cell == -1) {
            while (true) {
                cell = (int) (Math.random() * 8);
                if (field[cell] == 0) {
                    return cell;
                }
            }
        }
        return cell;
    }

    public int chooseCell(int[] field, int n){
        if (field[0] + field[1] + field[2] == n) {

            if (field[0] == 0)
                return 0;
            if (field[1] == 0)
                return 1;
            if (field[2] == 0)
                return 2;
        } else if (field[3] + field[4] + field[5] == n){

            if (field[3] == 0)
                return 3;
            if (field[4] == 0)
                return 4;
            if (field[5] == 0)
                return 5;
        } else if (field[6] + field[7] + field[8] == n){

            if (field[6] == 0)
                return 6;
            if (field[7] == 0)
                return 7;
            if (field[8] == 0)
                return 8;
        } else if (field[0] + field[3] + field[6] == n){

            if (field[0] == 0)
                return 0;
            if (field[3] == 0)
                return 3;
            if (field[6] == 0)
                return 6;
        } else if (field[1] + field[4] + field[7] == n){

            if (field[1] == 0)
                return 1;
            if (field[4] == 0)
                return 4;
            if (field[7] == 0)
                return 7;
        } else if (field[2] + field[5] + field[8] == n){

            if (field[2] == 0)
                return 2;
            if (field[5] == 0)
                return 5;
            if (field[8] == 0)
                return 8;
        } else if (field[0] + field[4] + field[8] == n){

            if (field[0] == 0)
                return 0;
            if (field[4] == 0)
                return 4;
            if (field[8] == 0)
                return 8;
        } else if (field[6] + field[4] + field[2] == n){

            if (field[6] == 0)
                return 6;
            if (field[4] == 0)
                return 4;
            if (field[2] == 0)
                return 2;
        }

    return -1;
    }
}

//




