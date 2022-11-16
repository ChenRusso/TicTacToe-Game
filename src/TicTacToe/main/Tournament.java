package TicTacToe.main;

import TicTacToe.Enum.Mark;
import TicTacToe.Enum.PlayerType;
import TicTacToe.Enum.Winner;
import TicTacToe.player.Player;
import TicTacToe.player.PlayerFactory;
import TicTacToe.rendering.ConsoleRenderer;
import TicTacToe.rendering.Renderer;

import java.util.Scanner;

public class Tournament {

    private static int rounds;

    private static Winner WinnerTournament;

    private Renderer renderer;

    private static Winner playTournament(Renderer renderer, Player player1, Player player2)
    {
        rounds = getRounds();
        Winner winner = null;
        int maxWinner = 0;
        int[] arrayOfWinners = new int[5];

        for(int i = 0; i<rounds; i++)
        {
            Game game = new Game(player1, player2, renderer);
            winner=game.run();
            if(winner== Winner.DRAW)
                arrayOfWinners[0]++;
            else if (winner== Winner.X_WIN)
                   arrayOfWinners[1]++;
            else
                  arrayOfWinners[2]++;

        }

        for(int j=0;j<=rounds;j++)
        {
            if(arrayOfWinners[j]>maxWinner)
                maxWinner = arrayOfWinners[j];
        }

            if (maxWinner == arrayOfWinners[0] || arrayOfWinners[1] == arrayOfWinners[2])
                return Winner.DRAW;
       else if(maxWinner == arrayOfWinners[1])
            return Winner.X_WIN;
        else
            return Winner.Y_WIN;

    }

    public static void main(String[] args){

        Renderer consoleRenderer = new ConsoleRenderer();

        PlayerType playerTypeFirst;
        PlayerType playerTypeSecond;
        Player firstPlayerX;
        Player secondPlayer0;

        Scanner scanner = new Scanner(System.in);

        Winner winnerTournament;

        System.out.print("Choose 2 players type: HUMAN player or EASY player "+ '\n');

        playerTypeFirst = PlayerType.valueOf(scanner.next());
        playerTypeSecond = PlayerType.valueOf(scanner.next());

        firstPlayerX = PlayerFactory.buildPlayer(playerTypeFirst, Mark.X);
        secondPlayer0 = PlayerFactory.buildPlayer(playerTypeSecond, Mark.O);

        System.out.print("Choose number of rounds "+ '\n');
        rounds = scanner.nextInt();

        winnerTournament = playTournament(consoleRenderer, firstPlayerX, secondPlayer0 );

        System.out.print("The winner in the tournament is "+winnerTournament);

    }

    private static int getRounds() {
        return rounds;
    }

    private void setRounds(int rounds) {
        this.rounds = rounds;
    }


}
