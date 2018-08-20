package io.github.cgmoganedi.blackjack.console;

import java.util.Scanner;

public class Blackjack {
    // Input
    static Scanner userInput = new Scanner(System.in);

    public static void main(String []args){
        // Welcome message
        System.out.println("Welcome to blackjack");

        // Instantiate a deck of cards
        Deck dealingDeck = new Deck();
        dealingDeck.createNewDeck();

        // Shuffle them
        dealingDeck.shuffle();

        // Create deck for player
        Deck playerDeck = new Deck();

        // Create a deck for the dealer
        Deck dealerDeck = new Deck();

        // Money
        double playerMoney = new Double(100.00);

        // Game loop
        while (playerMoney > 0.0){
            // Keep playing soldier

            double playerbet;
            do {
                System.out.println("You have R"
                        + playerMoney +
                        ", how much would you like to bet");
                playerbet = getPlayerBet();

                if (playerbet > playerMoney)
                    System.out.println("You cannot bet more than you have!");
            }
            while(playerbet > playerMoney);

            boolean endRound =  false;

            //Start dealing

            //Player gets two cards
            playerDeck.draw(dealingDeck);
            playerDeck.draw(dealingDeck);

            //Player gets two cards
            dealerDeck.draw(dealingDeck);
            dealerDeck.draw(dealingDeck);

            //Payer wants to hit multiple times
            while(true){
                //Display your hand
                System.out.println("Your hand:");
                System.out.println(playerDeck.getDeck());
                System.out.println("Your hand is valued at: " + playerDeck.cardsValue());

                //Display dealer's hand
                System.out.println("Dealer hand: "
                        + dealerDeck.getCard(0).getCard() + " and [hidden]");

                //What does the player want to do?
                System.out.println("Would you like to (1)hit or (2)stand");
                int response = userInput.nextInt();

                //They hit
                if(response == 1){
                    playerDeck.draw(dealingDeck);
                    // print the last dealt card
                    System.out.println("You draw a:" + playerDeck.getCard(playerDeck.deckSize()-1).getCard());

                    //Bust if > 21
                    if(playerDeck.cardsValue() > 21){
                        System.out.println("Bust. Currently valued at: " + playerDeck.cardsValue());
                        playerMoney -= playerbet;
                        endRound = true;
                        break;
                    }
                }
                else if(response == 2){
                    break;
                }
            }
            // Reveal Dealer cards
            System.out.println("Dealer cards: " + dealerDeck.getDeck());

            // See if dealer has more points than the player
            if((dealerDeck.cardsValue() > playerDeck.cardsValue()) && !endRound){
                System.out.println("Dealer beats you!");
                playerMoney -= playerbet;
                endRound = true;
            }

            //Dealer draws at 16, stand at 17
            while((dealerDeck.cardsValue() < 17) && !endRound){
                dealerDeck.draw(dealingDeck);
                // Print the card he just drew
                System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).getCard());
            }

            //Display total value for dealer
            System.out.println("Dealer's hand is valued at: " + dealerDeck.cardsValue());

            //Determine if dealer busted
            if((dealerDeck.cardsValue() > 21 && !endRound)){
                System.out.println("Dealer bust! You win.");
                playerMoney += playerbet;
                endRound = true;
            }

            //Determine if push (or tie)
            if(playerDeck.cardsValue() == dealerDeck.cardsValue() && !endRound){
                System.out.println("Push");
                endRound = true;
            }
            // If none of th above cases hold them the plyer must hvae won
            if(playerDeck.cardsValue() > dealerDeck.cardsValue() && !endRound){
                System.out.println("You win the hand!");
                playerMoney += playerbet;
                endRound = true;
            }

            else if(!endRound){
                System.out.println("You lose the hand");
                playerMoney -= playerbet;
                endRound = true;
            }

            playerDeck.moveAllToDeck(dealingDeck);
            dealerDeck.moveAllToDeck(dealingDeck);

            System.out.println("End of hand");

        }

        if(! (playerMoney > 0.0) ){
            System.out.println("Game over! Go home, you are out of money");
        }

    }
    static double getPlayerBet(){
         return userInput.hasNextDouble() ? userInput.nextDouble(): -1;
    }
}
