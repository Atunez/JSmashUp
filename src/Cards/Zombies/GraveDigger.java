package Cards.Zombies;

import Cards.Minion;
import Cards.Player;

public class GraveDigger extends Minion {
    // power 4 - You may place a minion from your discard pile into your hand.
    public GraveDigger(Player owner) {
        super(owner, 4);
    }
}
