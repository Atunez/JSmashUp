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

        for(int i = 0; i < numberOfPlayers; i++){
            Player p = new Player("Player " + i);
            for(int j = 0; j < 2; j++){
                String deck = getDeckFromIO(pickedDecks);
                Deck d = new Deck(deck, p);
                p.addDeckToPlayer(d);
                pickedDecks.add(deck);
                allDecksPicked.add(d);
            }
            players.add(p);
        }
    }
}