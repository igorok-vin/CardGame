package com.cardgame.view;

import com.cardgame.controller.GameController;
import com.cardgame.controller.GameController;

import java.nio.charset.UnmappableCharacterException;
import java.util.Scanner;

public class CommandLineView implements GameViewable {
    GameController controller;
    Scanner keyboard = new Scanner(System.in);

    public void setController(GameController controller) {
          this.controller = controller;
    }

    public void promptForPlayerName(){
        System.out.println("Enter player name");
        String name = keyboard.nextLine();
        if(name.isEmpty()){
            controller.startGame();
            controller.addPlayer(name);
       } else {
            controller.addPlayer(name);
        }
    }

    public void promptForFlip() {
        System.out.println("Press enter to reveal cards");
        keyboard.nextLine();
        controller.flipCards();
    }

    public void promptForNewGame() {
        System.out.println("Press enter to deal again");
        keyboard.nextLine();
        controller.flipCards();
    }

    public void showPlayerName(int playerIndex, String name){
        System.out.println("[" + playerIndex + "][" + name + "]");
    }

    public void showFaceDownCardForPlayer(int playerIndex, String name) {
        System.out.println("[" + name + "][][]");
    }

    public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
        System.out.println("[" + playerIndex + "][" + name + "][" + rank + "][" + suit + "]");
    }

    public void showWinner(String winnerName) {
        System.out.println("Winner!" + winnerName);
    }
}
