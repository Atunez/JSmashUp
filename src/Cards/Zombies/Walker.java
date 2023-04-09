package Cards.Zombies;

import Cards.Minion;
import Cards.Player;

public class Walker extends Minion {
    // power 2 - Look at the top card of your deck. Discard it or return it to the top of your deck.
    public Walker(Player owner) {
        super(owner, 2);
    }
}
