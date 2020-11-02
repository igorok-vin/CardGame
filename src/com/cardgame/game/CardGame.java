package com.cardgame.game;

import com.cardgame.controller.GameController;
import com.cardgame.model.Deck;
import com.cardgame.model.NormalDeck;
import com.cardgame.view.CommandLineView;
import com.cardgame.view.GameSwing;

public class CardGame {
    public static void main (String[] args){
        GameSwing gameSwing = new GameSwing();
        gameSwing.createAndShowGUI();
        /*
        * Instead of making the deck ourselves ask the factory to do it for us.
        * We would use this exact same factory approach We would use this exact same factory approach
        * */
        GameController gameController = new GameController(gameSwing, /*new Deck()*/ DeckFactory.makeDeck(DeckFactory.DeckType.Normal),new HighCardEvaluator());
        gameController.run();
    }
}

