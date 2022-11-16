package TicTacToe.main;

import TicTacToe.Enum.Mark;
import TicTacToe.Enum.Winner;
import TicTacToe.player.Player;
import TicTacToe.rendering.Renderer;

import javax.swing.*;

public class Game {

    private Renderer consoleRenderer;

    private Player humanPlayerX;

    private Player humanPlayerO;

    private int indexRow;

    private int indexCol;

    public Game(Player humanPlayerX, Player humanPlayerO, Renderer consoleRenderer)
    {
        this.humanPlayerX = humanPlayerX;
        this.humanPlayerO = humanPlayerO;
        this.consoleRenderer = consoleRenderer;
    }

    public Winner run(){
        Winner gameStatus = Winner.IN_PROGRESS;

        Board board = new Board();

        boolean isXPlay = true;

        while (Winner.IN_PROGRESS == gameStatus) {
            consoleRenderer.renderBoard(board);
            if (isXPlay == true) {
                humanPlayerX.playTurn(board);
                indexRow = humanPlayerX.getIndexRow();
                indexCol = humanPlayerX.getIndexCol();
                gameStatus = board.isHaveWinner(indexRow, indexCol, Mark.X);
            }
            else{
                humanPlayerO.playTurn(board);
                indexRow = humanPlayerO.getIndexRow();
                indexCol = humanPlayerO.getIndexCol();
            gameStatus = board.isHaveWinner(indexRow, indexCol, Mark.O);
        }
            isXPlay = !isXPlay;
        }

        return gameStatus;
    }



}
