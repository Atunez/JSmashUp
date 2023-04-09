package Cards.Zombies;

import Cards.Action;
import Cards.Player;

public class MallCrawl extends Action {
    // Search your deck for any number of cards with the same name and place them into your discard pile. Shuffle your deck.
    public MallCrawl(Player owner) {
        super(owner);
    }
}
