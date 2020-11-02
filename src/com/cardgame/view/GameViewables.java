package com.cardgame.view;

import com.cardgame.controller.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GameViewables implements GameViewable{
/*
* We will now support the ability to have many GUI windows watching the game.
* Our biggest problem is we will now have multiple threads running at the same time.
* We need to change our GameViewables class. Array lists are not thread safe.
* We need to change the list to a Vector.
* */
   // List<GameViewable>views;
      Vector<GameViewable>views;

    public GameViewables() {
        views = new Vector<>();
    }

    public void addViewable (GameViewable view){
        views.add(view);
    }

    /*
    * For every method called by the controller,
    * we need to pass that on to each GameViewable in our list.
    * */
    @Override
    public void setController(GameController controller) {
        for (GameViewable view : views){
            view.setController(controller);
        }
    }

    @Override
    public void promptForPlayerName() {
        for (GameViewable view : views){
            view.promptForPlayerName();
        }
    }

    @Override
    public void showPlayerName(int playerIndex, String name) {
        for (GameViewable view : views){
            view.showPlayerName(playerIndex, name);
        }
    }

    @Override
    public void promptForFlip() {
        for (GameViewable view : views){
            view.promptForFlip();
        }
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String name) {
        for (GameViewable view : views){
            view.showFaceDownCardForPlayer(playerIndex, name);
        }
    }

    @Override
    public void showWinner(String winnerName) {
        for (GameViewable view : views) {
            view.showWinner(winnerName);
        }
    }

    @Override
    public void promptForNewGame() {
            for (GameViewable view : views){
                view.promptForNewGame();
        }
    }

    @Override
    public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
            for (GameViewable view : views){
                view.showCardForPlayer(playerIndex, name, rank, suit);
        }
    }
}
