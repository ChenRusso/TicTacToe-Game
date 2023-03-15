package TicTacToe.main;
import TicTacToe.Enum.Mark;
import TicTacToe.Enum.Winner;
import java.util.Arrays;


public class Board
{
    public static final int SIZE = 3;

    public static final int WIN_STREAK=4;

    public int countBlankSpace = 0;

    private final Mark[][] board;

    public Board()
    {
        board = new Mark[SIZE][SIZE];
        initBoard();
    }

    private void initBoard()
    {
        for (Mark[] marks : board) {
            Arrays.fill(marks, Mark.BLANK);
        }
    }

    public Mark getMark(int row , int column)
    {
        Mark mark;

        if(row >= SIZE || column >= SIZE || row < 0 || column < 0)
        {
            mark = Mark.BLANK;
        }
        else
        {
            mark =  board[row][column];
        }

        return mark;
    }

    public boolean putMark(int row, int column, Mark mark)
    {
        boolean success = false;

        if (row >= board.length || column >= board.length  || row < 0 || column < 0)
        {
            System.out.print("Incorrect coordinates must be re-entered");
        }
        else if (board[row][column] != Mark.BLANK)
        {
            System.out.print("Space taken on the board"+ '\n');
        }
        else
        {
            board[row][column] = mark;
            success = true;
        }

        return success;
    }

    public Winner isHaveWinner(int row, int col, Mark mark)
    {
        countBlankSpace++;
        Winner winner = Winner.IN_PROGRESS;

        if (countBlankSpace == SIZE * SIZE)
        {
            winner = Winner.DRAW;
        }
        else
        {
            int winLine = countMarkInDirection(row, col, -1, 0, mark) + countMarkInDirection(row, col, 1, 0, mark);
            int winDiagonalLeft = countMarkInDirection(row, col, -1, -1, mark) + countMarkInDirection(row, col, 1, 1, mark);
            int winDiagonalRight = countMarkInDirection(row, col, 1, -1, mark) + countMarkInDirection(row, col, -1, 1, mark);
            int winColumn = countMarkInDirection(row, col, 0, 1, mark) + countMarkInDirection(row, col, 0, -1, mark);

            if (winLine == WIN_STREAK || winDiagonalLeft == WIN_STREAK || winDiagonalRight == WIN_STREAK || winColumn == WIN_STREAK)
            {
                winner = mark == Mark.X ? Winner.X_WIN : Winner.Y_WIN;
            }
        }

        countBlankSpace = winner == Winner.DRAW ? 0 : countBlankSpace;
        return winner;
    }


    private int countMarkInDirection(int row, int col, int rowDelta, int colDelta, Mark mark)
    {
        int count = 0;
        while(row < SIZE && row >= 0 && col < SIZE && col >= 0 && board[row][col] == mark) {
            count++;
            row += rowDelta;
            col += colDelta;
        }
        return count;
    }

}
