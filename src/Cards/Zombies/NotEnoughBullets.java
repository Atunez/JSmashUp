package Cards.Zombies;

import Cards.Action;
import Cards.Player;

public class NotEnoughBullets extends Action {
    // Place any number of minions with the same name from your discard pile into your hand.
    public NotEnoughBullets(Player owner) {
        super(owner);
    }
}
