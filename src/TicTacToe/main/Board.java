package TicTacToe.main;

import TicTacToe.Enum.Mark;
import TicTacToe.Enum.Winner;

import java.rmi.MarshalException;



public class Board {
    public static final int SIZE = 3;

    public static final int WIN_STREAK=4;

    public int countBlankSpace = 0;

    private Mark board[][];

    public Board() {
        board = new Mark[SIZE][SIZE];
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = Mark.BLANK;
            }
        }
    }

    public Mark getMark(int row , int column) {
        if(row >= SIZE || column >= SIZE || row < 0 || column < 0)
            return Mark.BLANK;
        else
        {
            Mark mark = board[row][column];
            return mark;
        }
    }

    public boolean putMark(int row, int column, Mark mark) {

        if (row >= board.length || column >= board.length  || row < 0 || column < 0) {
            System.out.print("Incorrect coordinates must be re-entered");
            return false;
        }
        if (board[row][column] != Mark.BLANK) {
            System.out.print("Space taken on the board"+ '\n');
            return false;
        }
        board[row][column] = mark;
        return true;

    }

    public Winner isHaveWinner(int row, int col, Mark mark) {

        countBlankSpace++;
        if(countBlankSpace == SIZE*SIZE)
        {
            countBlankSpace =0 ;
            return Winner.DRAW;
        }

        int winLine = countMarkInDirection(row, col ,-1, 0 , mark)
                +countMarkInDirection(row, col ,1, 0 , mark) ;
        int winDiagonalLeft  = countMarkInDirection(row,col,-1,-1, mark)
                + countMarkInDirection(row,col,1,1, mark);
        int winDiagonalRight = countMarkInDirection(row,col,1,-1, mark)
                +countMarkInDirection(row,col,-1,1, mark);
        int winColumn = countMarkInDirection(row, col, 0 , 1 , mark )
                +countMarkInDirection(row, col, 0 , -1 , mark );

        if(winLine == WIN_STREAK  || winDiagonalLeft == WIN_STREAK || winDiagonalRight == WIN_STREAK || winColumn == WIN_STREAK ) {
           if( mark == Mark.X)
           {
               countBlankSpace =0;
               return Winner.X_WIN;
           }
           else
           {
               countBlankSpace =0;
               return Winner.Y_WIN;
           }
        }

        return Winner.IN_PROGRESS;
    }

    private int countMarkInDirection(int row, int col, int rowDelta, int colDelta, Mark mark) {
        int count = 0;
        while(row < SIZE && row >= 0 && col < SIZE && col >= 0 && board[row][col] == mark) {
            count++;
            row += rowDelta;
            col += colDelta;
        }
        return count;
    }

    private Mark[][] getBoard() {
        return board;
    }

    private void setBoard(Mark[][] board) {
        this.board = board;
    }
}
