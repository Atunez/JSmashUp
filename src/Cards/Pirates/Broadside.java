package Cards.Pirates;

import Cards.Action;
import Cards.Player;

public class Broadside extends Action {
    // Destroy all of one player’s minions of power 2 or less on a base where you have a minion.
    public Broadside(Player owner) {
        super(owner);
    }
}
