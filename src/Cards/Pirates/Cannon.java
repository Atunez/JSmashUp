package Cards.Pirates;

import Cards.Action;
import Cards.Player;

public class Cannon extends Action {
    // Destroy up to two minions of power 2 or less.
    public Cannon(Player owner) {
        super(owner);
    }
}
