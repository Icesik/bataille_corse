package com.s11k.apps.bataillecorse.Controller;

import com.s11k.apps.bataillecorse.Model.Card;
import com.s11k.apps.bataillecorse.Model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nico on 29/01/2017.
 */
public class GameController {

    private List<Player> playersList = new ArrayList<Player>();

    /** Instance unique pré-initialisée */
    private static GameController INSTANCE = new GameController();

    /** Constructeur privé */
    private GameController() {

    }

    /** Point d'accès pour l'instance unique du singleton */
    public static GameController getInstance(){
        return INSTANCE;
    }

    public void initiateGame(){
        List<Card> newDeck = new ArrayList<Card>();
        // Charger joueurs
        Player playerA = new Player("player A");
        Player playerB = new Player("player B");
        this.playersList.add(playerA);
        this.playersList.add(playerB);
        // Charger Cartes

        // ...
    }

    public Card playCard(Player p){
        Card test = new Card();
        test.setSpecialCard(Card.SPECIAL_ACE);
        test.setValue(CardController.getValueFromSpecialCard(Card.SPECIAL_ACE));
        test.setFamily(Card.FAMILY_SPADES);
        return test;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }
}
