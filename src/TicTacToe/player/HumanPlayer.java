package TicTacToe.player;

import TicTacToe.Enum.Mark;
import TicTacToe.main.Board;

import  java.util.Scanner;


public class HumanPlayer implements Player {

    private final Mark mark;

    private int indexCol;

    private int indexRow;

    public HumanPlayer(Mark mark)
    {
        this.mark = mark;
    }

    public void playTurn(Board board)
    {
        Scanner scanner = new Scanner(System.in);
        int rowNumber, colNumber;
        System.out.print("Enter row and column coordinates "+ '\n');

        rowNumber = scanner.nextInt();
        colNumber = scanner.nextInt();
        indexRow=rowNumber;
        indexCol=colNumber;

            while ( !board.putMark(rowNumber,colNumber,mark))
            {
                System.out.print("Incorrect coordinates ,must be re-entered"+ '\n');
                rowNumber = scanner.nextInt();
                colNumber = scanner.nextInt();
            }
    }

    public int getIndexRow()
    {
        return indexRow;
    }

    public int getIndexCol()
    {
        return indexCol;
    }
}
