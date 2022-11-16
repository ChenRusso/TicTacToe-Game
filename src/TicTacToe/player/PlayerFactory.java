package TicTacToe.player;

import TicTacToe.Enum.Mark;
import TicTacToe.Enum.PlayerType;

public class PlayerFactory {

    public static Player buildPlayer(PlayerType playerType, Mark mark) {
        if (playerType.equals(PlayerType.HUMAN))
            return new HumanPlayer(mark);
         else
            return new WhateverPlayer(mark);
    }
}
