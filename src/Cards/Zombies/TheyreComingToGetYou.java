package Cards.Zombies;

import Cards.Action;
import Cards.Player;

public class TheyreComingToGetYou extends Action {
    // Play on a base. Ongoing: On your turn, you may play a minion here from your discard pile instead of from your hand.
    public TheyreComingToGetYou(Player owner) {
        super(owner);
    }
}
