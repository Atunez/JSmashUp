package Cards;

import java.util.ArrayList;

public class Player {
    private int totalVP;
    private String name;
    private ArrayList<Card> currentHand;
    private ArrayList<Card> remainingCards;

    private ArrayList<Card> discardedCards;
    private ArrayList<Turn> playerTurns;

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Turn> getPlayerTurns() {
        return playerTurns;
    }

    public void setPlayerTurns(ArrayList<Turn> playerTurns) {
        this.playerTurns = playerTurns;
    }

    public ArrayList<Deck> getPlayerDecks() {
        return playerDecks;
    }

    public void addDeckToPlayer(Deck deck) {
        this.playerDecks.add(deck);
    }

    private ArrayList<Deck> playerDecks;

    public Player(String name){
        this.totalVP = 0;
        this.name = name;
        this.playerTurns = new ArrayList<>();
        this.playerDecks = new ArrayList<>();
    }

    public void setTotalVP(int totalVP) {
        this.totalVP = totalVP;
    }

    public int getTotalVP() {
        return this.totalVP;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Card> getCurrentHand() {
        return currentHand;
    }

    public void setCurrentHand(ArrayList<Card> currentHand) {
        this.currentHand = currentHand;
    }

    public ArrayList<Card> getRemainingCards() {
        return remainingCards;
    }

    public void setRemainingCards(ArrayList<Card> remainingCards) {
        this.remainingCards = remainingCards;
    }

    public ArrayList<Card> getDiscardedCards() {
        return discardedCards;
    }

    public void setDiscardedCards(ArrayList<Card> discardedCards) {
        this.discardedCards = discardedCards;
    }

    public ArrayList<Card> getTopXCard(int x) {
        ArrayList<Card> topCards = new ArrayList<>();
        for(int i = 0; i < x; i++){
            topCards.add(this.remainingCards.get(this.remainingCards.size() - 1 - i));
        }
        return topCards;
    }

    public void drawTopXCard(int x){
        for(int i = 0; i < x; i++){
            this.currentHand.add(this.remainingCards.get(this.remainingCards.size() - 1));
            this.remainingCards.remove(this.remainingCards.size() - 1);
        }
    }
}
