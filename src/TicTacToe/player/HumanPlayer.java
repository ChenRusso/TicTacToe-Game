package TicTacToe.player;

import TicTacToe.Enum.Mark;
import TicTacToe.main.Board;

import  java.util.Scanner;


public class HumanPlayer implements Player {

    private Mark mark;

    private int indexCol;

    private int indexRow;

    public HumanPlayer(Mark mark) {
        this.mark = mark;
    }

    public void playTurn(Board board) {
        Scanner scanner = new Scanner(System.in);
        int rowNumer, colNumber;
        System.out.print("Enter row and column coordinates "+ '\n');
        rowNumer = scanner.nextInt();
        colNumber = scanner.nextInt();
        indexRow=rowNumer;
        indexCol=colNumber;

            while ( !board.putMark(rowNumer,colNumber,mark)){
                System.out.print("Incorrect coordinates ,must be re-entered"+ '\n');
                rowNumer = scanner.nextInt();
                colNumber = scanner.nextInt();
            }
    }

    public int getIndexRow() {
        return indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    private void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    private void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }
}
