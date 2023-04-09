import Cards.Base;
import Cards.Deck;
import Cards.Player;

import java.util.ArrayList;

import static Cards.IOInteractions.getDeckFromIO;
import static Cards.IOInteractions.getNumInRange;

public class Main {
    public static void main(String[] args) {
        // We run stuff from here...
        // Deck robots = new Deck("Robots", null);

        // Main Game Loop In Terminal...
        System.out.println("Enter Number Of Players");
        int numberOfPlayers = getNumInRange(2, 4);
        int numberOfBases = numberOfPlayers + 1;


        // Define Basic Information:
        ArrayList<Player> players = new ArrayList<>();
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

        ArrayList<Base> basesDeck = Base.getAllBasesRequired(pickedDecks);

    }
}