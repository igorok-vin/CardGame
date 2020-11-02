package com.cardgame.controller;

import com.cardgame.game.GameEvaluator;
import com.cardgame.game.HighCardEvaluator;
import com.cardgame.model.*;
import com.cardgame.view.GameViewable;
import com.cardgame.view.GameViewables;

import java.util.ArrayList;

public class GameController {
    enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed,
        AddingView
    }

    Deck deck;
    ArrayList<IPlayer> IPlayers;
    IPlayer winner;
    GameViewables gameViewables;
    GameState gameState;
    GameEvaluator gameEvaluator;

    public GameController(GameViewable gameViewable, Deck deck, GameEvaluator _gameEvaluator) {
        gameViewables = new GameViewables();
        this.deck = deck;
        IPlayers = new ArrayList<IPlayer>();
        gameState = GameState.AddingPlayers;
        //gameViewable.setController(this);
        addViewable(gameViewable);
        gameEvaluator = _gameEvaluator;
        this.gameEvaluator = new HighCardEvaluator();
    }
    /*
    * When adding a new view, we don't want the call to run to call
    * that new view until it's ready. So we'll save the current state,
    * set it to AddingView, wait for a second and then set it back.
    * */
    public void addViewable (GameViewable newView){
        GameState curState = gameState;
        gameState = GameState.AddingView;
        newView.setController(this);
        gameViewables.addViewable(newView);
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        gameState = curState;
    }

    public void run() {
        while (true) {
            switch (gameState) {
                case AddingPlayers:
                    gameViewables.promptForPlayerName();
                    break;
                case CardsDealt:
                    gameViewables.promptForFlip();
                    break;
                case WinnerRevealed:
                    gameViewables.promptForNewGame();
                    break;
                case AddingView:
                    break;
            }
        }
    }

    public void addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers) {
            IPlayers.add(new Player(playerName));
            gameViewables.showPlayerName(IPlayers.size(), playerName);
        }
    }

    public void startGame() {
        if (gameState != GameState.CardsDealt) {
            deck.shuffle();
            int playerIndex = 1;
            for (IPlayer IPlayer : IPlayers) {
                IPlayer.addCardToHand(deck.removeTopCard());
                gameViewables.showFaceDownCardForPlayer(playerIndex++, IPlayer.getName());
            }
            gameState = GameState.CardsDealt;
        }
    }

    public void flipCards() {
        int playerIndex = 1;
        for (IPlayer IPlayer : IPlayers) {
            PlayingCard playingCard = IPlayer.getCard(0);
            playingCard.flip();
            gameViewables.showCardForPlayer(playerIndex++,
                    IPlayer.getName(),
                    playingCard.getRank().toString(),
                    playingCard.getSuit().toString());
        }
        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
    }
    public void restarGame() {
        rebuildDeck();
        gameState = GameState.AddingPlayers;
    }

    void evaluateWinner() {
        winner = new WinningPlayer(gameEvaluator.evaluateWinner(IPlayers));
    }

    void displayWinner() {
        gameViewables.showWinner(winner.getName());
    }

    void rebuildDeck() {
        for (IPlayer IPlayer : IPlayers) {
            deck.returnCardToDeck(IPlayer.removeCard());
        }
    }
}
