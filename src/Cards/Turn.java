package Cards;

import DataStructures.NamedPredicate;
import DataStructures.Pair;

import java.util.ArrayList;
import java.util.Queue;
import java.util.function.Predicate;

public class Turn {
    // Basic Class to keep track of information in the current turn
    ArrayList<Card> cardsPlayed;

    // Figure out how much to play, each predicate indices the conditions
    // on the minion/action play

    // Other Left is used for order of resolution (if needed) and other stuff in general
    // that doesn't relate to the current player

    public ArrayList<NamedPredicate<Card>> getMinionsLeft() {
        return minionsLeft;
    }

    public ArrayList<NamedPredicate<Card>> getActionsLeft() {
        return actionsLeft;
    }

    public ArrayList<NamedPredicate<Card>> getOtherLeft() {
        return otherLeft;
    }

    public Player getOwnerOfTurn() {
        return ownerOfTurn;
    }

    private ArrayList<NamedPredicate<Card>> minionsLeft;
    private ArrayList<NamedPredicate<Card>> actionsLeft;
    private ArrayList<NamedPredicate<Card>> otherLeft;

    private Player ownerOfTurn;

    // TODO: Figure out how to use this to resolve card effects.
    public Queue<Pair<Card, Signals>> orderOfResolution;

    public Turn(Player owner){
        this.ownerOfTurn = owner;
        cardsPlayed = new ArrayList<>();
        minionsLeft = new ArrayList<>();
        actionsLeft = new ArrayList<>();
        otherLeft = new ArrayList<>();
    }

    public void addPlayedCard(Card card){
        this.cardsPlayed.add(card);
    }

    public ArrayList<Card> getCardsPlayed(){
        return this.cardsPlayed;
    }

    public void addStartMoves(){
        // Initally, all the minions and actions will be valid
        this.minionsLeft.add(new NamedPredicate<>("Free Minion Move", c -> true, CardTypes.MINION));
        this.actionsLeft.add(new NamedPredicate<>("Free Action Move", c -> true, CardTypes.ACTION));
    }

    public boolean hasMovesLeft(){
        return this.actionsLeft.size() + this.minionsLeft.size() > 0;
    }


    public void consumeMove(Predicate<Card> toRemove){
        this.minionsLeft.remove(toRemove);
    }

    public void consumeAction(Predicate<Card> toRemove){
        this.actionsLeft.remove(toRemove);
    }
}
