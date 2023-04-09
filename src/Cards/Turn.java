package Cards;

import DataStructures.Pair;

import java.util.ArrayList;
import java.util.Queue;
import java.util.function.Predicate;

public class Turn {
    // Basic Class to keep track of information in the current turn
    ArrayList<Card> cardsPlayed;

    // Figure out how much stuff is left for each player
    // By default, they are set to 1, but other cards can add them
    private Pair<Integer, Predicate> minionsLeft;
    private Pair<Integer, Predicate> actionsLeft;

    // TODO: Figure out how to use this to resolve card effects.
    public Queue<Pair<Card, Signals>> orderOfResolution;

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
