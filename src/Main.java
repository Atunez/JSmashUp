import Cards.*;
import DataStructures.NamedPredicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static Cards.IOInteractions.getDeckFromIO;
import static Cards.IOInteractions.getNumInRange;

public class Main {
    static int currentPlayer = 0;
    static ArrayList<Player> players;


    public static void main(String[] args) {
        // We run stuff from here...
        // Deck robots = new Deck("Robots", null);

        // Main Game Loop In Terminal...
        System.out.println("Enter Number Of Players");
        int numberOfPlayers = getNumInRange(2, 4);
        int numberOfBases = numberOfPlayers + 1;


        // Define Basic Information:
        players = new ArrayList<>();
        ArrayList<String> pickedDecks = new ArrayList<>();
        ArrayList<Deck> allDecksPicked = new ArrayList<>();

        // Get Decks Queensberry style...
        for(int i = 0; i < numberOfPlayers; i++){
            Player p = new Player("Player " + i);
            players.add(p);
        }

        for(int i = 0; i < players.size(); i++){
            Player p = players.get(i);
            System.out.println("For: " + p.getName());
            String deck = getDeckFromIO(pickedDecks);
            Deck d = new Deck(deck, p);
            p.addDeckToPlayer(d);
            pickedDecks.add(deck);
            allDecksPicked.add(d);
        }

        for(int i = players.size()-1; i > 0; i--){
            Player p = players.get(i);
            System.out.println("For: " + p.getName());
            String deck = getDeckFromIO(pickedDecks);
            Deck d = new Deck(deck, p);
            p.addDeckToPlayer(d);
            pickedDecks.add(deck);
            allDecksPicked.add(d);
        }

        // Get bases, and shuffle them...
        ArrayList<Base> basesDeck = Base.getAllBasesRequired(pickedDecks);
        Collections.shuffle(basesDeck);

        ArrayList<Base> startingBases = new ArrayList<>();
        for(int i = 0; i < numberOfBases; i++){
            startingBases.add(basesDeck.remove(basesDeck.size() - 1));
        }

        Field.getField().setInPlayBases(startingBases);

        runGameLoop();

    }

    private static void runGameLoop() {
        Field.turnInPlay = new Turn(players.get(currentPlayer));
        while(true){
            startTurn();
            playCards();
            scoreBases();
            draw2Cards();
            endTurn();
            checkGameEnd();
        }
    }

    private static void checkGameEnd() {
        boolean someoneHas15VP = players.stream().anyMatch(player -> player.getTotalVP() >= 15);
        if(someoneHas15VP){
            System.out.println("Someone has at least 15 VP calculating total VPs...");
            // No Madness yet!
            players.stream().sorted(new Comparator<Player>() {
                        @Override
                        public int compare(Player o1, Player o2) {
                            return o1.getTotalVP() - o2.getTotalVP();
                        }
                    });
            System.out.println("Here is the sorted order of players:");
            System.out.println(players);
        }
    }

    private static void endTurn() {
        // Tell each card that the turn ended, and then update the player going next.
        Field.getField().getAllCardsInPlay().stream().forEach(card -> card.emitSignal(Signals.ENDOFTURN));
        // Move the Turn object over...
        players.get(currentPlayer).getPlayerTurns().add(Field.turnInPlay);
        Field.turnInPlay = new Turn(players.get(currentPlayer));
        // Move Player
        currentPlayer = (currentPlayer + 1) % players.size();

    }

    private static void draw2Cards() {
        Player p = players.get(currentPlayer);
        p.drawTopXCard(2);
        if(p.getCurrentHand().size() > 10){
            System.out.println("Too Many Cards in Hand, choose index of cards to remove");
            while(p.getCurrentHand().size() > 10){
                System.out.println(p.getCurrentHand());
                p.getCurrentHand().remove(getNumInRange(0, p.getCurrentHand().size() - 1));
            }
        }
    }

    private static void scoreBases() {
        Field.getField().getInPlayBases().stream().forEach(base -> {
            // If the base scores, then emit that signal...
            if(base.checkBaseBreak()){
                base.emitSignal(Signals.SCORE);
            }
        });
    }

    private static void playCards() {
        while(Field.turnInPlay.hasMovesLeft()){
            System.out.println("Select Move (Named Predicate) To Play: {Select -1 to end Turn, Game doesn't know if you can play a move or not}");
            ArrayList<NamedPredicate<Card>> movesToPlay = Field.turnInPlay.getActionsLeft();
            movesToPlay.addAll(Field.turnInPlay.getMinionsLeft());
            System.out.println(movesToPlay);
            int moveToPlay = getNumInRange(-1, movesToPlay.size() - 1);
            if(moveToPlay == -1){
                return;
            }
            NamedPredicate<Card> pickedMove = movesToPlay.get(moveToPlay);
            switch (pickedMove.cardType){
                case MINION -> {
                    List<Card> canPlayTheFollowing = players.get(currentPlayer).getCurrentHand().stream().filter(c -> c instanceof Minion && pickedMove.test(c)).collect(Collectors.toList());
                    System.out.println("Pick Card From Following");
                    System.out.println(canPlayTheFollowing);
                    int cardPicked = getNumInRange(0, canPlayTheFollowing.size() - 1);
                    System.out.println("Pick Base From Following");
                    System.out.println(Field.getField().getInPlayBases());
                    int basePicked = getNumInRange(0, Field.getField().getInPlayBases().size() - 1);
                    Field.getField().getInPlayBases().get(basePicked).playCardOnBase(canPlayTheFollowing.get(cardPicked), players.get(currentPlayer));
                }
                case ACTION -> {
                    List<Card> canPlayTheFollowing = players.get(currentPlayer).getCurrentHand().stream().filter(c -> c instanceof Action && pickedMove.test(c)).collect(Collectors.toList());
                    System.out.println("Pick Card From Following");
                    System.out.println(canPlayTheFollowing);
                    int cardPicked = getNumInRange(0, canPlayTheFollowing.size() - 1);
                    switch (((Action) canPlayTheFollowing.get(cardPicked)).getActionTypes()){
                        case PLAYONMINION -> {
                            System.out.println("Play on Minion Action");
                            System.out.println("Pick Minion From Following, make sure you own the minion");
                            System.out.println(Field.getField().getAllCardsInPlay());
                            int minionPicked = getNumInRange(0, Field.getField().getAllCardsInPlay().size() - 1);
                            while(Field.getField().getAllCardsInPlay().get(minionPicked).getOwner() != players.get(currentPlayer)){
                                System.out.println("You Don't Own This Minion, pick a different minion");
                                System.out.println(Field.getField().getAllCardsInPlay());
                                minionPicked = getNumInRange(0, Field.getField().getAllCardsInPlay().size() - 1);
                            }
                            ((Minion) Field.getField().getAllCardsInPlay().get(minionPicked)).addActionToMinion(canPlayTheFollowing.get(cardPicked));
                        }
                        case PLAYONBASE -> {
                            System.out.println("Play on Base Action");
                            System.out.println("Pick Base From Following");
                            System.out.println(Field.getField().getInPlayBases());
                            int basePicked = getNumInRange(0, Field.getField().getInPlayBases().size() - 1);
                            Field.getField().getInPlayBases().get(basePicked).playCardOnBase(canPlayTheFollowing.get(cardPicked), players.get(currentPlayer));
                        }
                    }

                }
            }


        }
        System.out.println("No More Moves Available or Turn Ended");
    }

    private static void startTurn() {
        Field.turnInPlay.addStartMoves();
        // Emit Start of signal to everything
        Field.getField().getInPlayBases().stream().forEach(b -> b.emitSignal(Signals.STARTOFTURN));
        Field.getField().getAllCardsInPlay().stream().forEach(c -> c.emitSignal(Signals.STARTOFTURN));
    }


}