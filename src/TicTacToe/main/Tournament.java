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

    private static Winner playTournament(Renderer renderer, Player player1, Player player2)
    {
        rounds = getRounds();
        Winner winner ;
        int maxWinner = 0;
        int[] arrayOfWinners = new int[5];

        for(int i = 0; i < rounds; i++)
        {
            Game game = new Game(player1, player2, renderer);
            winner=game.run();
            switch (winner)
            {
                case DRAW -> arrayOfWinners[0]++;
                case X_WIN -> arrayOfWinners[1]++;
                case Y_WIN -> arrayOfWinners[2]++;
            }
        }

        for(int j = 0;j <= rounds;j++)
        {
            if(arrayOfWinners[j]>maxWinner)
            {
                maxWinner = arrayOfWinners[j];
            }
        }

        if (maxWinner == arrayOfWinners[0] || arrayOfWinners[1] == arrayOfWinners[2])
        {
            winner =  Winner.DRAW;

        }
       else if(maxWinner == arrayOfWinners[1])
       {
            winner = Winner.X_WIN;
        }
        else
        {
            winner =  Winner.Y_WIN;
        }


        return winner;
    }

    public static void main(String[] args){

        Renderer consoleRenderer = new ConsoleRenderer();

        PlayerType playerTypeFirst;
        PlayerType playerTypeSecond;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Choose player types (HUMAN or EASY) for the first and second player, separated by a space:");
            try
            {
                playerTypeFirst = PlayerType.valueOf(scanner.next().toUpperCase());
                playerTypeSecond = PlayerType.valueOf(scanner.next().toUpperCase());
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Invalid input, please try again.");
            }
        }
        while (true);

        Player firstPlayerX = PlayerFactory.buildPlayer(playerTypeFirst, Mark.X);
        Player secondPlayer0 = PlayerFactory.buildPlayer(playerTypeSecond, Mark.O);

        System.out.print("Choose number of rounds "+ '\n');
        while (!scanner.hasNextInt())
        {
            System.out.print("Please enter a valid number of rounds: ");
            scanner.next();
        }
        rounds = scanner.nextInt();

        Winner winnerTournament = playTournament(consoleRenderer, firstPlayerX, secondPlayer0);

        System.out.print("The winner in the tournament is " + winnerTournament);

    }

    private static int getRounds() {
        return rounds;
    }

}
