package Cards.Zombies;

import Cards.Action;
import Cards.Player;

public class LendAHand extends Action {
    // Shuffle any number of cards from your discard pile into your deck.

    public LendAHand(Player owner) {
        super(owner);
    }
}
