import exceptions.InvalidExceptions;

import java.util.List;
import java.util.Scanner;

import controllers.GameController;
import models.Bot;
import models.BotDifficulityLevel;
import models.Game;
import models.GameState;
import models.Player;
import models.PlayerType;
import models.Symbol;


public class Main {

    public static void main(String[] args) throws InvalidExceptions {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        int dimension = 3;
        List<Player> players = List.of(new Player("Player1", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Player2", new Symbol('O'), PlayerType.BOT, BotDifficulityLevel.EASY));

        Game game = gameController.startGame(dimension, players);
         while (game.getGameState().equals(GameState.IN_PROGRESS)) {
           
            gameController.printBoard(game);

            gameController.makeMove(game);


        }
        if (!gameController.checkState(game).equals(GameState.ENDED)) {
            game.setGameState(GameState.DRAW);
            System.out.println("Game Draw");
        } else {
            gameController.printBoard(game);
            System.out.println("Winner is " + game.getWinner().getName());
        }



    }
}