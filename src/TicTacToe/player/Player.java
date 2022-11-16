package TicTacToe.player;

import TicTacToe.main.Board;

public interface Player {

    void playTurn(Board board) ;

     int getIndexRow();

    int getIndexCol();
}
