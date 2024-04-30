package controllers;
import models.Game;
import models.GameState;
import models.Move;
import models.Player;

import java.util.List;

import exceptions.InvalidExceptions;

public class GameController {

    public Game startGame(int dimension, List<Player> players) {
        //TODO:
        // we have to validate if 2 players having same symbol or not ?
        // if they have same symbol then we have to throw an exception
        return new Game(dimension, players);
    }
    public  void  makeMove(Game game) throws InvalidExceptions {
        game.makeMove();
    }
    public GameState checkState(Game game){
        return game.getGameState();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void printBoard(Game game){

       game.printBoard();
    }

}