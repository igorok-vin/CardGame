package com.cardgame.view;

import com.cardgame.controller.GameController;

public interface GameViewable {
    void setController (GameController controller);
    void promptForPlayerName();
    void showPlayerName(int playerIndex, String name);
    void promptForFlip();
    void showFaceDownCardForPlayer(int playerIndex, String name);
    void showWinner(String winnerName);
    void promptForNewGame();
    void showCardForPlayer(int playerIndex, String name, String rank, String suit);
}
