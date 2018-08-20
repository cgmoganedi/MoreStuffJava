package io.github.cgmoganedi.blackjack.console;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deckOfCards; // Instance of the collection of cards that make up this deck

    /**
     * Default constructor of out deck object
     */
    Deck(){
        this.deckOfCards = new ArrayList<>();
    }

    // A way of generating cards of the deck
    public void createNewDeck(){
        for(Suit cardSuit: Suit.values()){
            for(Value cardValue: Value.values()){
                //Add this new card exactly once to the deck
                this.deckOfCards.add(new Card(cardSuit, cardValue));
            }
        }
    }
    public int deckSize(){
        return this.deckOfCards.size();
    }

    public void moveAllToDeck(Deck moveTo){
        int size = this.deckOfCards.size();

        //put cards into moveTo deck
        for(int i = 0; i< size; ++i){
            moveTo.addCard(this.deckOfCards.get(i));
        }
        for(int i = 0; i< size; ++i){
            this.removeCard(0);
        }
    }
    // print the deck of cards in a greatly well formatted manner.
    public String getDeck(){
        String cardList = "The deck is:";

        for(int i = 1; i<= deckOfCards.size(); ++i){
            cardList += "\n" + i + " - " + this.deckOfCards.get(i-1).getCard();
        }
        return cardList;
    }
    // Shuffle the cards
    public void shuffle(){
        ArrayList<Card> shaffledDeck = new ArrayList<>();

        while( !this.deckOfCards.isEmpty()){
            int i = (int)(Math.random()*this.deckOfCards.size());
            shaffledDeck.add(this.deckOfCards.get(i));
            this.deckOfCards.remove(i);
        }
        this.deckOfCards = shaffledDeck;
    }

    // Getters and setters
    public Card getCard(int i){
        return this.deckOfCards.get(i);
    }
    public void removeCard(int i){
        this.deckOfCards.remove(i);
    }
    public void addCard(Card card){
        this.deckOfCards.add(card);
    }

    // Draw from the deck
    public void draw(Deck comingFrom){
        this.deckOfCards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

    // Return total value of cards in deck
    public int cardsValue(){
        int totalValue = 0;
        int aces = 0;

        for(Card card: this.deckOfCards){
            switch (card.getValue()){
                case TWO: totalValue += 2;
                break;
                case THREE: totalValue += 3;
                    break;
                case FOUR: totalValue += 4;
                    break;
                case FIVE: totalValue += 5;
                    break;
                case SIX: totalValue += 6;
                    break;
                case SEVEN: totalValue += 7;
                    break;
                case EIGHT: totalValue += 8;
                    break;
                case NINE: totalValue += 9;
                    break;
                case TEN: totalValue += 10;
                    break;
                case JACK: totalValue += 10;
                    break;
                case QUEEN: totalValue += 10;
                    break;
                case KING: totalValue += 10;
                    break;
                case ACE: aces += 1;
                    break;
            }
        }

        // Aces could be worth 1 or 11
        // Depending on the total value at hand
        // Just don't get over 21
        for(int i = 0; i < aces; ++i){
            if(totalValue > 10)
                totalValue += 1;
            else
                totalValue += 11;
        }
        return totalValue;
    }

}

/**
 * Nas
 * Hov
 * ===
 * Cole
 * ===
 * Immortal Technique
 * ASAP Rocky
 */
// OVO Team