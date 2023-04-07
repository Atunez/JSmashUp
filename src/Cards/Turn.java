package Cards;

import java.util.ArrayList;

public class Turn {
    // Basic Class to keep track of information in the current turn
    ArrayList<Card> cardsPlayed;

    public Turn(){
        cardsPlayed = new ArrayList<>();
    }

    public void addPlayedCard(Card card){
        this.cardsPlayed.add(card);
    }

    public ArrayList<Card> getCardsPlayed(){
        return this.cardsPlayed;
    }
}
