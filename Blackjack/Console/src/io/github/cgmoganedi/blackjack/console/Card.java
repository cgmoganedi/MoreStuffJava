package io.github.cgmoganedi.blackjack.console;

public class Card {
    private Suit suit; // The suit type of the card: Heart, Diamond etc.
    private Value value; // The card value: 2, 3, ... K, A

    // The card constructor
    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }
    // Return the value and suit of the card
    public String getCard(){
        String card = this.value.toString() + " of " + this.suit.toString();
        return card;
    }
    // Returns just the value of the card
    public Value getValue(){
        return this.value;
    }
}


