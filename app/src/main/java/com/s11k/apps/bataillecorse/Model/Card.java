package com.s11k.apps.bataillecorse.Model;

import com.s11k.apps.bataillecorse.Controller.CardController;

/**
 * Created by Nico on 30/01/2017.
 */
public class Card {
    public static final int FAMILY_SPADES = 1;
    public static final int FAMILY_HEARTS = 2;
    public static final int FAMILY_DIAMONDS = 3;
    public static final int FAMILY_CLUBS = 4;

    public static final int SPECIAL_JACK = 1;
    public static final int SPECIAL_QUEEN = 2;
    public static final int SPECIAL_KING = 3;
    public static final int SPECIAL_ACE = 4;

    private int family;
    private int specialCard;
    private int value;
    private String label;

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        if(this.label == null || this.label.isEmpty()) {
            String familyLabel = CardController.getFamilyLabel(this.family);
            String valueLabel = this.getValueLabel();
            this.label = valueLabel + familyLabel;
        }
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getSpecialCard() {
        return specialCard;
    }

    public void setSpecialCard(int specialCard) {
        this.specialCard = specialCard;
    }

    public String getValueLabel(){
        String label = "";
        switch(this.specialCard){
            case SPECIAL_JACK:
                label = "J";
                break;
            case SPECIAL_QUEEN:
                label = "Q";
                break;
            case SPECIAL_KING:
                label = "K";
                break;
            case SPECIAL_ACE:
                label = "A";
                break;
            default:
                label = String.valueOf(value);
                break;
        }
        return label;
    }

    @Override
    public String toString() {
        return "value : " + this.value + " family : " + this.getFamily() + " valueLabel : " + this.getLabel();
    }
}
