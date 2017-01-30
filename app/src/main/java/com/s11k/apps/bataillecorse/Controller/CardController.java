package com.s11k.apps.bataillecorse.Controller;

import com.s11k.apps.bataillecorse.Model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nico on 30/01/2017.
 */
public class CardController {
    public static String getFamilyLabel(int family){
        String label = "";
        switch(family){
            case Card.FAMILY_CLUBS:
                label = "☘";
                break;
            case Card.FAMILY_DIAMONDS:
                label = "♦";
                break;
            case Card.FAMILY_HEARTS:
                label = "♡";
                break;
            case Card.FAMILY_SPADES:
                label = "♠";
                break;
        }
        return label;
    }

    public static int getValueFromSpecialCard(int specialCard){
        int value = 0;
        switch(specialCard){
            case Card.SPECIAL_JACK:
                value = 11;
                break;
            case Card.SPECIAL_QUEEN:
                value = 12;
                break;
            case Card.SPECIAL_KING:
                value = 13;
                break;
            case Card.SPECIAL_ACE:
                value = 14;
                break;
        }
        return value;
    }

    public static List<Card> getNewDeck(){
        List<Card> deck = new ArrayList<Card>();

        int[] specialCards = getCardFamilies();
        int[] cardFamilies = getCardFamilies();
        for(int value=2; value<=10; value++){
            for (int family : cardFamilies) {
                Card c = new Card();
                c.setFamily(family);
                c.setValue(value);
                deck.add(c);
            }
        }
        for (int specialCard : specialCards) {
            for (int family : cardFamilies) {
                Card c = new Card();
                c.setFamily(family);
                c.setValue(getValueFromSpecialCard(specialCard));
                c.setSpecialCard(specialCard);
                deck.add(c);
            }
        }
        return deck;
    }

    public static int[] getCardFamilies(){
        return new int[]{Card.FAMILY_CLUBS, Card.FAMILY_DIAMONDS, Card.FAMILY_HEARTS, Card.FAMILY_SPADES};
    }

    public static int[] getSpecialCards(){
        return new int[]{Card.SPECIAL_JACK, Card.SPECIAL_QUEEN, Card.SPECIAL_KING, Card.SPECIAL_ACE};
    }
}
