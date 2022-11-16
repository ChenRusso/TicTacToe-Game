package TicTacToe.player;

import TicTacToe.Enum.Mark;
import TicTacToe.main.Board;

import java.util.Random;

public class WhateverPlayer implements Player {

    private Mark mark;

    private int rand_row;

    private int rand_col;

    public WhateverPlayer (Mark mark)
    {
        this.mark = mark;
    }

    @Override
    public void playTurn(Board board) {
        Random rand = new Random();
        int rand_row = rand.nextInt(board.SIZE);
        int rand_col = rand.nextInt(board.SIZE);

        while(!board.putMark(rand_row,rand_col,this.mark))
        {
            rand_row= rand.nextInt(board.SIZE);
            rand_col = rand.nextInt(board.SIZE);
        }
    }
    @Override
    public int getIndexRow() {
        return rand_row;
    }

    @Override
    public int getIndexCol() {
        return rand_col;
    }

    private void setRandRow(int rand_row) {
        this.rand_row = rand_row;
    }

    private void setRandCol(int rand_col) {
        this.rand_col = rand_col;
    }


}
